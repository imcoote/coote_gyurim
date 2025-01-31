import java.io.*;
import java.util.*;

/*******************************************************************************
 * 소요시간: 1시간
 * 시간복잡도: O(n * w)
 * 메모리: 15152 kb
 * 시간: 116 ms
 *******************************************************************************/
public class 트럭_13335 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken()); // 다리의 길이
        int l = Integer.parseInt(st.nextToken()); // 다리의 최대 하중

        st = new StringTokenizer(br.readLine());
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        Queue<Integer> queue = new LinkedList<>(); // 다리에 있는 버스
        int onBridgeWeight = 0;
        int time = 0;

        for (int i = 0; i < n; i++) { // O(n)
            while (true) { // O(w) 최대 다리 길이만큼 진행
                if (queue.size() == w) {
                    onBridgeWeight -= queue.poll();
                }

                if (a[i] + onBridgeWeight <= l) break;
                queue.offer(0); // 무게가 l을 넘는 경우
                time++;
            }
            queue.offer(a[i]);
            onBridgeWeight += a[i];
            time++;
        }

        System.out.println(time + w); // 마지막 트럭이 건너는 시간(w) 추가
    }
}
