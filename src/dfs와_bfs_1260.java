import java.io.*;
import java.util.*;

/*******************************************************************************
 * 소요시간: 20분
 * 시간복잡도: O(n^2)
 *      * 인접 행렬 사용했으므로 모든 노드 간의 연결 여부를 확인해야 하기에, O(n^2)
 * 메모리: 24528 kb
 * 시간: 296 ms
 *******************************************************************************/

public class dfs와_bfs_1260 {
    private static int n, m, v;
    private static int[][] matrix;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        matrix = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            matrix[a][b] = 1;
            matrix[b][a] = 1;
        }

        visited[v] = true;
        dfs(v);
        System.out.println();

        // 초기화
        visited = new boolean[n + 1];
        bfs(v);
    }

    private static void dfs(int node) { // O(n^2)
        System.out.print(node + " ");

        for (int next = 1; next <= n; next++) {
            if (!visited[next] && matrix[node][next] == 1) {
                visited[next] = true;
                dfs(next);
            }
        }
    }

    private static void bfs(int node) { // O(n^2)
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        visited[node] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            System.out.print(cur + " ");

            for (int next = 1; next <= n; next++) {
                if (!visited[next] && matrix[cur][next] == 1) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
        System.out.println();
    }
}
