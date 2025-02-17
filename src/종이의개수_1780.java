import java.io.*;
import java.util.*;

/*******************************************************************************
 * 소요시간: 30분
 * 시간복잡도:
 * 메모리: 310176 kb
 * 시간: 860 ms
 *******************************************************************************/
public class 종이의개수_1780 {
    private static int n;
    private static int[][] map;
    private static int[] count;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        count = new int[3]; // 0, 1, 2 => -1, 0, 1

        func(0, 0, n);

        for (int i = 0; i < 3; i++) {
            System.out.println(count[i]);
        }
    }

    private static void func(int x, int y, int d) {
        if (isSame(x, y, d)) {
            int cur = map[x][y];
            count[cur + 1]++;
        } else {
            // 9등분
            int nd = d / 3;
            for (int i = x; i < x + d; i += nd) {
                for (int j = y; j < y + d; j += nd) {
                    if (!oob(i, j))
                        func(i, j, nd);
                }
            }
        }
    }

    private static boolean oob(int x, int y) {
        return x < 0 || y < 0 || x >= n || y >= n;
    }

    private static boolean isSame(int x, int y, int d) {
        int num = map[x][y];
        for (int i = x; i < x + d; i++) {
            for (int j = y; j < y + d; j++) {
                if (num != map[i][j]) return false;
            }
        }
        return true;
    }
}
