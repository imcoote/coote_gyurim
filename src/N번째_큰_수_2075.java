import java.io.*;
import java.util.*;

/*******************************************************************************
 * 소요시간: 7분
 * 시간복잡도: O(n*n*logn)
 * 메모리: 274212 kb
 * 시간: 776 ms
 *******************************************************************************/

public class N번째_큰_수_2075 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder()); // 최대힙

        for (int i = 0; i < n; i++) { // O(n * n)
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                pq.offer(Integer.parseInt(st.nextToken())); // O(logn)
            }
        }

        while(n-- >0) {
            int cur = pq.poll();
            if (n == 0) System.out.print(cur);
        }
    }
}
