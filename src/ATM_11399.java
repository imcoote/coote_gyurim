import java.io.*;
import java.util.*;

/***********************************************************************************
 * 메모리 : 14404 KB
 * 시간 : 108 ms
 * 소요시간: 5분
 * 시간복잡도: O(nlogn)
 ************************************************************************************/

public class ATM_11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr); // O(nlogn)

        int cumsum = 0;
        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            cumsum += arr[i];
            totalSum += cumsum;
        }
        System.out.println(totalSum);
    }
}
