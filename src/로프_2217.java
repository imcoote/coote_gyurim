import java.io.*;
import java.util.*;

/*******************************************************************************
 * 소요시간: 10분
 * 시간복잡도: O(n)
 * 메모리: 26796 kb
 * 시간: 372 ms
 *******************************************************************************/

public class 로프_2217 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Integer[] ropes = new Integer[n];

        for (int i = 0; i < n; i++) { // O(n)
            ropes[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(ropes, Collections.reverseOrder());

        int maxWeight = 0;
        for (int i = 0; i < n; i++) { // O(n)
            int canWeight = ropes[i] * (i + 1);
            maxWeight = Math.max(canWeight, maxWeight);
        }
        System.out.println(maxWeight);
    }
}
