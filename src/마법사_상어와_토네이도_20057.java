import java.io.*;
import java.util.*;

public class 마법사_상어와_토네이도_20057 {
    private static int[][] map;
    private static int n;
    private static int[][] dirs = {
            {0, -1}, // 좌
            {1, 0}, // 하
            {0, 1}, // 우
            {-1, 0} // 상
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int x = n / 2;
        int y = n / 2;
        int width = 1;
        int count = 0;
        int d = 0;
        int cc = 0;

        while (true) {
            if (count == 2) {
                count = 0;
                width += 1;
            }

            for (int i = 1; i <= width; i++) {
                x = x + dirs[d][0];
                y = y + dirs[d][1];
            }

            if (x == 0 && y == -1) break; // 종료 조건

            d = (d + 1) % 4;
            count++;
            cc++;
        }
    }

    private static boolean oob(int x, int y) {
        return x < 0 || y < 0 || x >= n || y >= n;
    }
}
