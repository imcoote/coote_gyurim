import java.io.*;
import java.util.*;

/*******************************************************************************
 * 소요시간: 40분
 * 시간복잡도: O(1)
 * 메모리: 14200 kb
 * 시간: 104 ms
 *******************************************************************************/

public class 걷기_1459 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long x = Integer.parseInt(st.nextToken());
        long y = Integer.parseInt(st.nextToken());
        long w = Integer.parseInt(st.nextToken());
        long s = Integer.parseInt(st.nextToken());

        long min = Math.min(x, y);
        long max = Math.max(x, y);

        long distance;
        if (2 * w > s) { // 대각선(s) 이동이 이득
            if ((max - min) % 2 == 0) {
                distance = min * s + (max - min) * s;
            } else {
                distance = min * s + (max - min - 1) * s + w; // 마지막 홀수는 직선
            }
            distance = Math.min(distance, min * s + (max - min) * w);
        } else { // 직선(w) 이동이 이득
            distance = (x + y) * w;
        }
        System.out.println(distance);
    }
}
