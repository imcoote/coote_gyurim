import java.io.*;
import java.util.*;

/*******************************************************************************
 * 소요시간: 5분
 * 시간복잡도: O(n * logn)
 * 메모리: 35480 kb
 * 시간: 828 ms
 *******************************************************************************/

public class 최대_힙_11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());

        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            int cmd = Integer.parseInt(br.readLine());

            if (cmd == 0) {
                if (pq.size() == 0) System.out.println(0);
                else {
                    System.out.println(pq.peek());
                    pq.poll();
                }
            } else {
                pq.offer(cmd);
            }
        }
    }
}
