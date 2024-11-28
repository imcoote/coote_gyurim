import java.io.*;
import java.util.*;

/*******************************************************************************
 * 소요시간: 30분
 * 시간복잡도: O(4^(n-1))
 * 메모리: 25832 kb
 * 시간: 168 ms
 *******************************************************************************/

public class 연산자_끼워넣기_14888 {
    private static int n;
    private static int[] op;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        op = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0, 0, 0, 0, "");
        System.out.println(maxTotal);
        System.out.println(minTotal);
    }

    private static int minTotal = Integer.MAX_VALUE;
    private static int maxTotal = Integer.MIN_VALUE;

    private static void dfs(int depth, int plus, int minus, int mul, int div, String ops) { // O(4^(n-1))
        if (depth == n - 1) {
            // 계산
            int idx = 0;
            int total = arr[idx];

            for (char o : ops.toCharArray()) {
                if (o == '+') {
                    total += arr[idx + 1];
                } else if (o == '-') {
                    total -= arr[idx + 1];
                } else if (o == '*') {
                    total *= arr[idx + 1];
                } else if (o == '/') {
                    boolean isNegative = false;
                    if (total < 0) {
                        isNegative = true;
                        total = -total;
                    }

                    total /= arr[idx + 1];

                    if (isNegative) {
                        total = -total;
                    }
                }
                idx++;
            }
            minTotal = Math.min(minTotal, total);
            maxTotal = Math.max(maxTotal, total);

            return;
        }

        if (op[0] > plus) {
            dfs(depth + 1, plus + 1, minus, mul, div, ops + "+");
        }
        if (op[1] > minus) {
            dfs(depth + 1, plus, minus + 1, mul, div, ops + "-");
        }
        if (op[2] > mul) {
            dfs(depth + 1, plus, minus, mul + 1, div, ops + "*");
        }
        if (op[3] > div) {
            dfs(depth + 1, plus, minus, mul, div + 1, ops + "/");
        }
    }
}
