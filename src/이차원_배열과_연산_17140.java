import java.io.*;
import java.util.*;

/***********************************************************************************
 * 메모리 : 21288 KB
 * 시간 : 208 ms
 * 소요시간: 2시간
 * 시간복잡도: O(n^3)
 *      - maxR, maxC가 100 이하. 이때, 최대 길이를 n이라고 했을 때, 시간복잡도는 O(n^3)이 됨
 ************************************************************************************/

public class 이차원_배열과_연산_17140 {
    private static int r, c, k;
    private static int[][] matrix;
    private static int maxR = 3, maxC = 3;

    private static class Number implements Comparable<Number> {
        int num;
        int count;

        Number(int num, int count) {
            this.num = num;
            this.count = count;
        }

        @Override
        public int compareTo(Number o) {
            if (this.count == o.count) {
                return Integer.compare(this.num, o.num); // 오름차순
            } else {
                return Integer.compare(this.count, o.count); // 오름차순
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        matrix = new int[101][101];

        // 초기 matrix 설정
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;

        while (true) { // O(100) => O(n)
            if (matrix[r - 1][c - 1] == k) {
                break;
            } else {
                if (count == 100) {
                    count = -1;
                    break;
                }
            }

            // R 혹은 C 연산 수행
            if (maxR < maxC) { // 행 < 열
                // C 연산
                operateC();
            } else {
                // R 연산
                operateR();
            }
            count++;
        }
        System.out.println(count);
    }

    private static void operateR() {
        // 행에 대해서 정렬
        for (int i = 0; i < maxR; i++) { // O(n^2)
            HashMap<Integer, Integer> map = new HashMap<>();
            PriorityQueue<Number> pq = new PriorityQueue<>();

            for (int j = 0; j < maxC; j++) {
                if (matrix[i][j] == 0) continue;

                int cur = matrix[i][j];
                if (map.containsKey(cur)) {
                    map.put(cur, map.get(cur) + 1);
                } else {
                    map.put(cur, 1);
                }
            }

            // 정렬 순서를 맞추기 위함
            for (Map.Entry<Integer, Integer> elem : map.entrySet()) {
                pq.offer(new Number(elem.getKey(), elem.getValue())); // O(logn)
            }

            List<Integer> list = new ArrayList<>(); // 새로운 행을 담을 리스트

            while (!pq.isEmpty()) { // O(n)
                Number cur = pq.poll();
                list.add(cur.num);
                list.add(cur.count);
            }

            maxC = Math.max(maxC, list.size());

            for (int j = 0; j <= 100; j++) { // O(n)
                if (j < list.size()) {
                    matrix[i][j] = list.get(j);
                } else {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    private static void operateC() {
        // 열에 대해서 정렬
        for (int i = 0; i < maxC; i++) {
            HashMap<Integer, Integer> map = new HashMap<>();
            PriorityQueue<Number> pq = new PriorityQueue<>();

            for (int j = 0; j < maxR; j++) {
                if (matrix[j][i] == 0) continue;
                int cur = matrix[j][i];

                if (map.containsKey(cur)) {
                    map.put(cur, map.get(cur) + 1);
                } else {
                    map.put(cur, 1);
                }
            }

            // 정렬 순서를 맞추기 위함
            for (Map.Entry<Integer, Integer> elem : map.entrySet()) {
                pq.offer(new Number(elem.getKey(), elem.getValue()));
            }

            List<Integer> list = new ArrayList<>(); // 새로운 열을 담을 리스트

            while (!pq.isEmpty()) {
                Number cur = pq.poll();
                list.add(cur.num);
                list.add(cur.count);
            }

            maxR = Math.max(maxR, list.size());

            for (int j = 0; j <= 100; j++) {
                if (j < list.size()) {
                    matrix[j][i] = list.get(j);
                } else {
                    matrix[j][i] = 0;
                }
            }
        }
    }
}
