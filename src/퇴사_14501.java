import java.io.*;
import java.util.*;

/*******************************************************************************
 * 소요시간: 1시간
 * 시간복잡도: O(n^2)
 * 메모리: 14324 kb
 * 시간: 100 ms
 *******************************************************************************/

public class 퇴사_14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] tArr = new int[n];
        int[] pArr = new int[n];
        int[] dp = new int[n + 1]; // 당일에 받을 수 있는 최대 금액 저장

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            tArr[i] = Integer.parseInt(st.nextToken());
            pArr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) { // O(n)
            int paidDay = i + tArr[i]; // 상담 후 금액 받는 날

            for (int j = paidDay; j <= n; j++) { // O(n)
                // 마지막날 끝나는 상담의 금액이 dp[n]에 담기므로 연산자(<=) 사용
                if (dp[j] < dp[i] + pArr[i]) {
                    dp[j] = dp[i] + pArr[i];
                }
            }
        }
        System.out.println(dp[n]);
    }
}
