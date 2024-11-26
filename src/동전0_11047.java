import java.io.*;
import java.util.*;

/*******************************************************************************
 * 소요시간: 10분
 * 시간복잡도: O(n)
 * 메모리: 14348 kb
 * 시간: 100 ms
 *******************************************************************************/

public class 동전0_11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Integer[] coins = new Integer[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(coins, Collections.reverseOrder()); // 내림차순 쓰려면 int 아닌 Integer 타입 필요

        int idx = 0;
        int count = 0;

        while (k != 0) {
            if (k % coins[idx] == 0) {
                count += (k / coins[idx]);
                k = 0;
                break;
            } else if (k > coins[idx]) {
                int div = k / coins[idx];
                count += div;
                k -= (coins[idx] * div);
            }
            idx++;
        }
        System.out.println(count);
    }
}
