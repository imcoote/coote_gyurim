import java.io.*;
import java.util.*;

/*******************************************************************************
 * 소요시간: 10분
 * 시간복잡도: O(nlogn)
 * 메모리: 14412 kb
 * 시간: 104 ms
 *******************************************************************************/

public class 보물_1026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Integer[] a = new Integer[n]; // 내림차순 정렬을 위해 기본 타입(int)가 아닌 객체 배열로 만들기
        int[] b = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) { // O(n)
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) { // O(n)
            b[i] = Integer.parseInt(st.nextToken());
        }

        // n <= 50
        // 50! 에 대한 모든 경우의 수를 한다면 시간초과 무조건 발생
        // a와 b의 각 원소는 100보다 작거나 같은 음이 아닌 정수

        Arrays.sort(b); // 오름차순 // O(nlogn)
        Arrays.sort(a, Collections.reverseOrder()); // 내림차순 // O(nlogn)

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (a[i] * b[i]);
        }

        System.out.println(sum);
    }
}
