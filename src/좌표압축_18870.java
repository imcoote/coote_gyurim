import java.io.*;
import java.util.*;

/*******************************************************************************
 * 소요시간: 20분
 * 시간복잡도: O(nlogn)
 * 메모리: 263688 kb
 * 시간: 1792 ms
 *******************************************************************************/
public class 좌표압축_18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] num = new int[n];
        int[] sorted = new int[n];

        for (int i = 0; i < n; i++) { // O(n) = O(10^6)
            num[i] = Integer.parseInt(st.nextToken());
            sorted[i] = num[i];
        }

        Arrays.sort(sorted); // O(nlogn)

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) { // O(n)
            if (!map.containsKey(sorted[i])) { // 평균: O(1), 최악: O(n)
                map.put(sorted[i], map.size());
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(map.get(num[i])).append(" ");
        }
        System.out.print(sb);
    }
}
