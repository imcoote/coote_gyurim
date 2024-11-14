import java.io.*;
import java.util.*;

/*******************************************************************************
 * 소요시간: 25분
 * 시간복잡도: O(n + nlogn)
 * 메모리: 44664 kb
 * 시간: 560 ms
 *******************************************************************************/

public class 회의실_배정_1931 {
    private static class Time implements Comparable<Time> {
        int start, end;

        Time(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Time o) {
            if (this.end == o.end) {
                return Integer.compare(this.start, o.start);
            } else {
                return Integer.compare(this.end, o.end);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;

        Time[] arr = new Time[n];

        for (int i = 0; i < n; i++) { // O(n)
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr[i] = new Time(start, end);
        }

        Arrays.sort(arr); // O(nlogn)

        int idx = 0;
        int endTime = arr[idx].end;
        idx++;

        int count = 1;
        while (idx != n) { // O(n)
            if (endTime <= arr[idx].start) {
                endTime = arr[idx].end;
                count++;
            }
            idx++;
        }
        System.out.println(count);
    }
}
