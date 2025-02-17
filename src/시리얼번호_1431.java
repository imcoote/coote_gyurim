import java.io.*;
import java.util.*;

/*******************************************************************************
 * 소요시간: 15분
 * 시간복잡도:
 * 메모리: 14256 kb
 * 시간: 104	 ms
 *******************************************************************************/

public class 시리얼번호_1431 {
    private static class Number implements Comparable<Number> {
        String str;
        int count;

        Number(String str) {
            this.str = str;

            for (char c : str.toCharArray()) {
                if (c >= '0' && c <= '9')
                    count += (c - '0');
            }
        }

        @Override
        public int compareTo(Number o) {
            if (this.str.length() != o.str.length()) { // 길이가 다르면 짧은 것이 먼저
                return Integer.compare(this.str.length(), o.str.length());
            } else {
                if (this.count != o.count) {
                    return Integer.compare(this.count, o.count);
                } else {
                    return this.str.compareTo(o.str); // 사전순 정렬
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Number> list = new ArrayList<>();

        while (n-- > 0) {
            String str = br.readLine();
            list.add(new Number(str));
        }
        Collections.sort(list);

        for (Number num : list) {
            System.out.println(num.str);
        }
    }
}
