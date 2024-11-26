import java.io.*;
import java.util.*;

/****************************************************************************************
 * 소요시간: 30분
 * 메모리: 22124KB
 * 시간: 152ms
 * 시간복잡도: O(3 * MAX + MAX) : O(간선 수 + 노드 수)
 ****************************************************************************************/

public class 숨바꼭질_1697 {
    private static int MAX = 100001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        System.out.print(bfs(n, k));
    }

    private static int bfs(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);

        int[] arr = new int[1000000];
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[n] = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            if (cur - 1 >= 0) {
                if (arr[cur - 1] > arr[cur] + 1) {
                    arr[cur - 1] = arr[cur] + 1;
                    queue.offer(cur - 1);
                }
            }

            if (cur + 1 < MAX) {
                if (arr[cur + 1] > arr[cur] + 1) {
                    arr[cur + 1] = arr[cur] + 1;
                    queue.offer(cur + 1);
                }
            }

            if (2 * cur > 0 && 2 * cur < MAX) {
                if (arr[2 * cur] > arr[cur] + 1) {
                    arr[2 * cur] = arr[cur] + 1;
                    queue.offer(2 * cur);
                }
            }
        }

        return arr[k];
    }
}
