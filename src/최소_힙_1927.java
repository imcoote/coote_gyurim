import java.io.*;
import java.util.*;

/*******************************************************************************
 * 소요시간: 5분
 * 시간복잡도: O(n * logn)
 * 메모리: 31248 kb
 * 시간: 764 ms
 *******************************************************************************/

public class 최소_힙_1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        while (n-- > 0) { // O(n)
            int cmd = Integer.parseInt(br.readLine());

            if (cmd == 0) { // O(logn)
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
