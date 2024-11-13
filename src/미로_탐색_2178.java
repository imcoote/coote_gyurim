/*******************************************************************************
 * 소요시간: 10분
 * 시간복잡도: O(n*m)
 * 메모리: 15336 kb
 * 시간: 132 ms
 *******************************************************************************/

import java.io.*;
import java.util.*;

public class 미로_탐색_2178 {
    private static int n, m;
    private static int[][] map;
    private static boolean[][] visit;

    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {1, -1, 0, 0};

    private static class Index {
        int x, y;
        int count;

        Index(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        }

        bfs();
    }

    private static void bfs() {
        int x = 0;
        int y = 0;

        Queue<Index> queue = new LinkedList<>();
        queue.offer(new Index(x, y, 1));
        visit[x][y] = true;

        while (!queue.isEmpty()) {
            Index cur = queue.poll();

            if (cur.x == n - 1 && cur.y == m - 1) {
                System.out.println(cur.count);
                break;
            }

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (!oob(nx, ny) && !visit[nx][ny] && map[nx][ny] == 1) {
                    visit[nx][ny] = true;
                    queue.offer(new Index(nx, ny, cur.count + 1));
                }
            }
        }
    }

    private static boolean oob(int x, int y) {
        return x < 0 || y < 0 || x >= n || y >= m;
    }
}
