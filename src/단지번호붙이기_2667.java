import java.io.*;
import java.util.*;

/*******************************************************************************
 * 소요시간: 15분
 * 시간복잡도: O(n * n + nlogn)
 * 메모리: 14388 kb
 * 시간: 108 ms
 *******************************************************************************/

public class 단지번호붙이기_2667 {
    private static int n;
    private static int[][] board;
    private static boolean[][] visit;

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
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        visit = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(String.valueOf(row.charAt(j)));
            }
        }

        int houseCount = 0;
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j] && board[i][j] == 1) {
                    houseCount++;
                    list.add(bfs(i, j));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(houseCount).append("\n");
        Collections.sort(list); // O(nlogn)

        for (Integer elem : list) {
            sb.append(elem).append("\n");
        }
        System.out.print(sb);
    }

    private static int bfs(int x, int y) { // O(n * n) // O(V + E) = O(V + 4V) = O(n * n)
        Queue<Index> queue = new LinkedList<>();
        queue.offer(new Index(x, y));
        visit[x][y] = true;
        int count = 1;

        while (!queue.isEmpty()) {
            Index cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (!oob(nx, ny) && !visit[nx][ny] && board[nx][ny] == 1) {
                    queue.offer(new Index(nx, ny));
                    visit[nx][ny] = true;
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean oob(int x, int y) {
        return x < 0 || y < 0 || x >= n || y >= n;
    }
}
