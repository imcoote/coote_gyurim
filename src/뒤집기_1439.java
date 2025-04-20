import java.io.*;
import java.util.*;

/*******************************************************************************
 * 소요시간: 5분
 * 시간복잡도: O(s.length) = O(1,000,000)
 * 메모리: 14196 kb
 * 시간: 104 ms
 *******************************************************************************/

public class 뒤집기_1439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int one_count = 0;
        int zero_count = 0;

        char curChar = str.charAt(0);
        if (curChar == '0') zero_count++;
        else one_count++;

        for (int i = 1; i < str.length(); i++) {
            if (curChar == str.charAt(i)) continue;
            else {
                curChar = str.charAt(i);
                if (curChar == '0') zero_count++;
                else one_count++;
            }
        }

        if (one_count < zero_count) System.out.println(one_count);
        else System.out.println(zero_count);
    }
}
