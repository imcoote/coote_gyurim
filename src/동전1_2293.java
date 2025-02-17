import java.io.*;
import java.util.*;

/*******************************************************************************
 * 소요시간: 1시간 30분
 * 시간복잡도: O(n * k)
 * 메모리: 14196 kb
 * 시간: 108 ms
 *******************************************************************************/

public class 동전1_2293 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(coins);
        int[] dp = new int[k + 1];
        dp[0] = 1;

        for (int i = 0; i < n; i++) { // O(n)
            for (int j = coins[i]; j <= k; j++) { // O(k)
                dp[j] += dp[j - coins[i]]; // 현재 동전을 사용하여 i원을 만드는 방법 추가
            }
        }
        System.out.println(dp[k]);
    }
}
