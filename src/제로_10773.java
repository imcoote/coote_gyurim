import java.io.*;
import java.util.*;

/*******************************************************************************
 * 소요시간: 5분
 * 시간복잡도: O(k) = O(100,000)
 * 메모리: 23736 kb
 * 시간: 208 ms
 *******************************************************************************/

public class 제로_10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> stack = new ArrayDeque<Integer>(); // 덱 선언

        int k = Integer.parseInt(br.readLine());

        while (k-- > 0) { // O(k)
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                stack.pollLast();
            } else {
                stack.offer(num);
            }
        }

        long sum = 0L;
        while(!stack.isEmpty()) { // O(k)
            long number = stack.poll();
            sum += number;
        }
        System.out.println(sum);
    }
}
