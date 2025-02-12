import java.io.*;
import java.util.*;

/*******************************************************************************
 * 소요시간: 5분
 * 시간복잡도: O(N)
 * 메모리: 332072 kb
 * 시간: 1232 ms
 *******************************************************************************/

public class 큐2_18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Deque<Integer> queue = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        while (n-- > 0) { // O(N)
            String input = br.readLine();
            st = new StringTokenizer(input);
            String cmd = st.nextToken();

            // deque의 시간복잡도: O(1)
            if (cmd.equals("push")) {
                queue.offer(Integer.parseInt(st.nextToken()));
            } else if (cmd.equals("front")) {
                if (queue.size() == 0) sb.append("-1").append("\n");
                else sb.append(queue.peekFirst()).append("\n");
            } else if (cmd.equals("back")) {
                if (queue.size() == 0) sb.append("-1").append("\n");
                else sb.append(queue.peekLast()).append("\n");
            } else if (cmd.equals("size")) {
                sb.append(queue.size()).append("\n");
            } else if (cmd.equals("empty")) {
                if (queue.size() == 0) sb.append("1").append("\n");
                else sb.append("0").append("\n");
            } else if (cmd.equals("pop")) {
                if (queue.size() != 0) sb.append(queue.pollFirst()).append("\n");
                else sb.append("-1").append("\n");
            }
        }
        System.out.print(sb);
    }
}
