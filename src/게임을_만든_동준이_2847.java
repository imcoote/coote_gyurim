import java.io.*;
import java.util.*;

public class 게임을_만든_동준이_2847 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] grades = new int[n];

        int maxNum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            grades[i] = Integer.parseInt(br.readLine());
            maxNum = Math.max(maxNum, grades[i]);
        }

        int minCount = Integer.MAX_VALUE;
        for (int start = 1; start <= maxNum; start++) { // O(20000)
            int count = 0;
            int prevNum = grades[0];

            for (int i = 0; i < n; i++) {

            }
        }
    }
}
