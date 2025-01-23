import java.io.*;
import java.util.*;

/*******************************************************************************
 * 소요시간: 40분
 * 시간복잡도: O(2*n)
 * 메모리: 33752 kb
 * 시간: 372 ms
 *******************************************************************************/
public class 스택수열_1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        boolean isNo = false;
        StringBuilder sb = new StringBuilder();

        for (Integer cur : list) {

            while (true) {
                if (!stack.isEmpty() && stack.peek().equals(cur)) { // 스택 top에 cur이 존재하는 경우
                    sb.append("-").append("\n");
                    stack.pop();
                    break;
                }

                if (!queue.isEmpty() && queue.peek().equals(cur)) { // 큐 top에 cur이 존재하는 경우
                    stack.push(queue.poll());
                    sb.append("+").append("\n");
                    sb.append("-").append("\n");
                    stack.pop();
                    break;
                }

                if (queue.isEmpty()) { // 더이상 불가능한 경우
                    isNo = true;
                    break;
                }

                stack.push(queue.poll());
                sb.append("+").append("\n");
            }

            if (isNo) break; // 불가능한 연산
        }

        if (isNo) System.out.println("NO");
        else System.out.print(sb);
    }
}
