import java.io.*;
import java.util.*;

/*******************************************************************************
 * 소요시간: 10분
 * 시간복잡도: O(t*n)
 * 메모리: 14172 kb
 * 시간: 108 ms
 *******************************************************************************/

public class 일이삼더하기_9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] dp = new int[11];
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4; // 1+1+1, 1+2, 2+1, 3

            for (int i = 4; i <= n; i++) {
                dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
            }
            sb.append(dp[n]).append("\n");
        }
        System.out.println(sb);
    }
}
