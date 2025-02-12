import java.io.*;
import java.util.*;

/*******************************************************************************
 * 소요시간: 5분
 * 시간복잡도: O(V + E) = O(n + m)
 * 메모리: 14224 kb
 * 시간: 104 ms
 *******************************************************************************/

public class 바이러스_2606 {
    private static int n;
    private static List<Integer>[] edges;
    private static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st;

        edges = new ArrayList[n + 1];
        visit = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            edges[a].add(b);
            edges[b].add(a);
        }

        bfs(1);

        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (visit[i]) count++;
        }
        System.out.println(count);
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visit[start] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (Integer next : edges[cur]) {
                if (!visit[next]) {
                    visit[next] = true;
                    queue.offer(next);
                }
            }
        }
    }
}
