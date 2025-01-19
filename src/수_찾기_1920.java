import java.io.*;
import java.util.*;

/*******************************************************************************
 * 소요시간: 20분
 * 시간복잡도: O(nlogn + mlogn) = O((n+m)*logn)
 * 메모리: 43728 kb
 * 시간: 656 ms
 *******************************************************************************/

public class 수_찾기_1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] num = new int[n];

        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num); // O(nlogn)

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) { // O(m) = O(10^5)
            int key = Integer.parseInt(st.nextToken());

            // 시간 초과 안 걸리기 위해서는 O(10^4) 이하 로직 필요
            int left = 0;
            int right = n - 1;
            int mid = (left + right) / 2;
            boolean isFound = false;

            while (left <= right) { // O(logn) <= 이분탐색 시간복잡도
                mid = (left + right) / 2;

                if (num[mid] == key) {
                    isFound = true;
                    break;
                } else if (num[mid] > key) { // 찾고자하는 값(key)보다 가리키고 있는 값이 크다면
                    right = mid - 1; // 가리키는 값 범위 줄이기
                } else {
                    left = mid + 1;
                }
            }

            if (isFound) sb.append(1).append("\n");
            else sb.append(0).append("\n");
        }

        System.out.println(sb);
    }
}
