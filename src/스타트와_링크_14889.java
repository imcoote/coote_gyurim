import java.io.*;
import java.util.*;

/*******************************************************************************
 * 소요시간: 15분
 * 시간복잡도: O(2^n * n * n)
 * 메모리: 62944 kb
 * 시간: 484 ms
 *******************************************************************************/

public class 스타트와_링크_14889 {
    private static int[][] matrix;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        matrix = new int[n + 1][n + 1];

        StringTokenizer st;
        for (int i = 1; i <= n; i++) { // O(n*n)
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[] visited = new boolean[n + 1];
        // 조합
        dfs(0, visited, 0);
        System.out.println(minDiff);
    }

    private static int minDiff = Integer.MAX_VALUE;

    private static void dfs(int count, boolean[] visited, int idx) { // O(2^n * n * n)
        if (count == n / 2) {
            List<Integer> start = new ArrayList<>();
            List<Integer> link = new ArrayList<>();

            for (int i = 1; i <= n; i++) { // O(n)
                if (visited[i]) start.add(i);
                else link.add(i);
            }

            int diff = Math.abs(getScore(start) - getScore(link)); // O(n*n)

            minDiff = Math.min(diff, minDiff);

            return;
        }

        for (int i = idx + 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(count + 1, visited, i);
                visited[i] = false;
            }
        }
    }

    private static int getScore(List<Integer> team) { // O(n*n)
        int score = 0;
        for (Integer t : team) {
            for (Integer tt : team) {
                score += matrix[t][tt];
            }
        }

        return score;
    }
}
