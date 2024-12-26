import java.io.*;
import java.util.*;
/*******************************************************************************
 * 소요시간: 15분
 * 시간복잡도: O(n^m) => 순열 nPm
 * 메모리: 109844 kb
 * 시간: 2544 ms
 *******************************************************************************/
public class N과M1_15649 {
    private static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        boolean[] visit = new boolean[n+1];
        List<Integer> list = new ArrayList<>();
        backtracking(0, visit, list);
    }

    private static void backtracking(int depth, boolean[] visit, List<Integer> list) {
        if (depth == m) {
            for (Integer elem : list) {
                System.out.print(elem + " ");
            }
            System.out.println();
        }

        for (int i = 1; i <= n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                List<Integer> newList = new ArrayList<>(list);
                newList.add(i);
                backtracking(depth + 1, visit, newList);
                visit[i] = false;
            }
        }
    }
}
