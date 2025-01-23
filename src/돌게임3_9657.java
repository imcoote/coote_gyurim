import java.io.*;
import java.util.*;

/*******************************************************************************
 * 소요시간: 20분
 * 시간복잡도: O(n)
 * 메모리: 14292 kb
 * 시간: 108 ms
 *******************************************************************************/

public class 돌게임3_9657 {
    // 8:40
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[1001];
        dp[1] = 1; // 1: 상근
        dp[2] = 2; // 2: 창영
        dp[3] = 1;
        dp[4] = 1;

        for (int i = 5; i <= n; i++) {
            boolean isSangGeun = false;

            if (dp[i - 1] == 2) isSangGeun = true;
            if (dp[i - 3] == 2) isSangGeun = true;
            if (dp[i - 4] == 2) isSangGeun = true;

            if (isSangGeun) dp[i] = 1; // 상근이가 이김
            else dp[i] = 2; // 창영이가 이김
        }

        if (dp[n] == 1) System.out.println("SK");
        else System.out.println("CY");
    }
}
