import java.io.*;
import java.util.*;

/****************************************************************************************
 * 소요시간: 30분
 * 메모리: 15892 KB
 * 시간: 116 ms
 * 시간복잡도: O(n * m) : O(노드 수)
 ****************************************************************************************/


public class 영역구하기_2583 {
    private static int m, n, k;
    private static int[][] map;
    private static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[m][n]; // m = 5, n = 7
        visit = new boolean[m][n];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int sy = Integer.parseInt(st.nextToken());
            int sx = Integer.parseInt(st.nextToken()); // 왼쪽 아래

            int ey = Integer.parseInt(st.nextToken());
            int ex = Integer.parseInt(st.nextToken()); // 오른쪽 위

            for (int x = sx; x < ex; x++) {
                for (int y = sy; y < ey; y++) {
                    map[x][y] = 1;
                }
            }
        }

        int count = 0;
        List<Integer> sizes = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j] && map[i][j] == 0) {
                    visit[i][j] = true;
                    sizes.add(dfs(i, j, 1));
                    count++;
                }
            }
        }

        Collections.sort(sizes);
        System.out.println(count);

        for (Integer size : sizes) {
            System.out.print(size + " ");
        }
    }

    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};

    private static int dfs(int x, int y, int size) {
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (!oob(nx, ny) && !visit[nx][ny] && map[nx][ny] == 0) {
                visit[nx][ny] = true;
                size += dfs(nx, ny, 1);
            }
        }

        return size;
    }

    private static boolean oob(int x, int y) {
        return x < 0 || y < 0 || x >= m || y >= n;
    }
}
