import java.io.*;
import java.util.*;

/*******************************************************************************
 * 소요시간: 15분
 * 시간복잡도: O(V+E)
 * 메모리: 70128 kb
 * 시간: 1088 ms
 *******************************************************************************/

public class 트리의_부모_찾기_11725 {
    private static int n;
    private static List<Integer>[] edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        edges = new ArrayList[n+1];

        for (int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }

        int count = n-1;
        while (count-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            edges[a].add(b);
            edges[b].add(a);
        }

        setParent();
    }

    private static void setParent() { // O(V+E)
        int[] parent = new int[n+1];
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visit = new boolean[n+1];
        queue.add(1);
        visit[1] = true;
        parent[1] = 1;

        while(!queue.isEmpty()) {
            int cur = queue.poll();
            visit[cur] = true;

            for (Integer child: edges[cur]) {
                if (!visit[child]) {
                    parent[child] = cur;
                    queue.offer(child);
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            System.out.println(parent[i]);
        }
    }
}
