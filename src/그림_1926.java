import java.io.*;
import java.util.*;

/*******************************************************************************
 * 소요시간: 20분
 * 시간복잡도: O(n*m)
 *      - 도화지 내 모든 칸을 1번씩만 돌기 때문에 O(n*m) 시간복잡도 가짐
 * 메모리: 57504 kb
 * 시간: 324 ms
 *******************************************************************************/

public class 그림_1926 {
    private static int n;
    private static int m;
    private static int[][] map;
    private static boolean[][] visit;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};

    private static int maxDimension = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int pictureCount = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (!visit[i][j] && map[i][j] == 1) {
                    dimension = 0;
                    visit[i][j] = true;
                    pictureCount++;
                    dfs(i, j);
                    maxDimension = Math.max(maxDimension, dimension);
                }
            }
        }
        System.out.println(pictureCount);
        System.out.println(maxDimension);
    }

    private static int dimension = 0;

    // dfs 돌면서 맵의 모든 칸 탐색
    private static void dfs(int x, int y) {
        dimension++;

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (!oob(nx, ny) && !visit[nx][ny] && map[nx][ny] == 1) {
                visit[nx][ny] = true;
                dfs(nx, ny);
            }
        }
    }

    private static boolean oob(int x, int y) {
        return x < 0 || y < 0 || x >= n || y >= m;
    }
}
