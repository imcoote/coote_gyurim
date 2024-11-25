import java.io.*;
import java.util.*;

/*******************************************************************************
 * 소요시간: 40분
 * 시간복잡도: O(n)
 * 메모리: 275308 kb
 * 시간: 1532 ms
 *******************************************************************************/

public class 선긋기_2170 {
    private static class Line implements Comparable<Line> {
        int first, second;

        Line(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(Line o) {
            if (this.first == o.first) {
                return Integer.compare(this.second, o.second); // second가 더 작은 애로
            } else {
                return Integer.compare(this.first, o.first);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Line> pq = new PriorityQueue<>();
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            pq.offer(new Line(a, b));
        }

        Line cur = pq.poll();
        int left = cur.first;
        int right = cur.second;
        long sum = 0;

        while (!pq.isEmpty()) { // O(N)
            cur = pq.poll();

            if (cur.first >= right) {
                long diff = right - left;
                sum += diff;
                left = cur.first;
                right = cur.second;
            } else if (right < cur.second) {
                right = cur.second;
            }
        }

        sum += (right - left);
        System.out.println(sum);
    }
}
