import java.io.*;
import java.util.*;

/*******************************************************************************
 * 소요시간: 20분
 * 시간복잡도: O(t * n)
 * 메모리: 313972 kb
 * 시간: 1056 ms
 *******************************************************************************/

public class 주식_11501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) { // O(t)
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] stockPrice = new int[n];

            for (int i = 0; i < n; i++) {
                stockPrice[i] = Integer.parseInt(st.nextToken());
            }

            int maxNumber = Integer.MIN_VALUE;
            int count = 0;
            long totalProfit = 0;
            long totalBuy = 0;

            for (int i = n - 1; i >= 0; i--) { // O(n)
                if (maxNumber < stockPrice[i]) { // 팔아야할 시점
                    // long 연산 필요
                    long currentProfit = (long) maxNumber * count - totalBuy;
                    totalProfit += currentProfit;

                    // 초기화
                    maxNumber = stockPrice[i];
                    count = 0;
                    totalBuy = 0;
                } else { // 구매해야할 시점
                     count++;
                     totalBuy += stockPrice[i];
                }
            }

            if (count > 0) {
                long currentProfit = (long) maxNumber * count - totalBuy;
                totalProfit += currentProfit;
            }
            sb.append(totalProfit).append("\n");
        }
        System.out.print(sb);
    }
}
