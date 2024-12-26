import java.io.*;
import java.util.*;

/*******************************************************************************
 * 소요시간: 15분
 * 시간복잡도: O(t * (k + n * m))
 * 메모리: 15932 kb
 * 시간: 140 ms
 *******************************************************************************/

public class 유기농_배추_1012 {
    private static int[][] matrix;
    private static boolean[][] visited;
    private static int n, m;

    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};

    private static class Index {
        int x, y;

        Index(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) { // O(t)
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            matrix = new int[n][m];
            visited = new boolean[n][m];

            while (k-- > 0) { // O(k)
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                matrix[x][y] = 1;
            }

            // 지렁이 갯수
            int count = 0;

            // visit 배열을 통해, 모든 셀을 각 1번씩만 방문하도록 처리하고 있으므로 bfs 호출 로직에 대한 시간복잡도는 O(n*m)
            for (int i = 0; i < n; i++) { // O(n * m)
                for (int j = 0; j < m; j++) {
                    if (!visited[i][j] && matrix[i][j] == 1) {
                        count++;
                        bfs(i, j);
                    }
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }

    private static boolean oob(int x, int y) {
        return x < 0 || y < 0 || x >= n || y >= m;
    }

    private static void bfs(int x, int y) {
        Queue<Index> queue = new LinkedList<>();
        queue.offer(new Index(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Index cur = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (!oob(nx, ny) && !visited[nx][ny] && matrix[nx][ny] == 1) {
                    queue.offer(new Index(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
    }
}
