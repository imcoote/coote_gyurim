import java.io.*;
import java.util.*;

/*******************************************************************************
 * 소요시간: 1시간
 * 시간복잡도: O(n)
 * 메모리: 14252 kb
 * 시간: 108 ms
 *******************************************************************************/
public class 게임을_만든_동준이_2847 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] grades = new int[n];

        for (int i = 0; i < n; i++) {
            grades[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        for (int i = n - 2; i >= 0; i--) { // O(n)
            if (grades[i] >= grades[i + 1]) { // 현재 레벨이 다음 레벨보다 크다면
                count += (grades[i] - (grades[i + 1] - 1));
                grades[i] = grades[i + 1] - 1; // 점수 줄이기
            }
        }
        System.out.println(count);
    }
}
