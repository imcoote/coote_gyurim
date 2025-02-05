import java.io.*;
import java.util.*;

/*******************************************************************************
 * 소요시간: 1시간 20분
 * 시간복잡도: O(n * n) // 모든 셀을 한 번만 방문
 * 메모리: 120344 kb
 * 시간: 580 ms
 *******************************************************************************/
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

        while (true) {
            if (count == 2) {
                count = 0;
                width += 1;
            }

            for (int i = 1; i <= width; i++) {
                x = x + dirs[d][0];
                y = y + dirs[d][1];

                if (x == 0 && y == -1) break; // 종료 조건

                if (d == 0) moveLeft(x, y);
                else if (d == 1) moveDown(x, y);
                else if (d == 2) moveRight(x, y);
                else moveUp(x, y);
            }

            if (x == 0 && y == -1) break; // 종료 조건

            d = (d + 1) % 4;
            count++;
        }
        System.out.println(outSand);
    }

    private static int outSand = 0;

    private static void moveLeft(int x, int y) {
        int[][] percent = { // y 기준
                {0, -2, 5},
                {1, -1, 10},
                {-1, -1, 10},
                {1, 0, 7},
                {-1, 0, 7},
                {-2, 0, 2},
                {2, 0, 2},
                {1, 1, 1},
                {-1, 1, 1}
        };

        int dust = map[x][y];
        int movedDust = 0;

        for (int i = 0; i < 9; i++) {
            int nx = x + percent[i][0];
            int ny = y + percent[i][1];
            int pDust = dust * percent[i][2] / 100; // 이동할 모래

            if (oob(nx, ny)) outSand += pDust;
            else {
                map[nx][ny] += pDust; // 이동할 모래 이동
            }
            movedDust += pDust; // 여태 이동한 모래 카운트
        }

        map[x][y] = 0;

        // 알파 위치의 모래 처리
        if (!oob(x, y - 1)) {
            map[x][y - 1] += dust - movedDust;
        } else {
            outSand += (dust - movedDust);
        }
    }

    private static void moveRight(int x, int y) {
        int[][] percent = {
                {-1, -1, 1}, {1, -1, 1},
                {-2, 0, 2}, {2, 0, 2},
                {1, 0, 7}, {-1, 0, 7},
                {1, 1, 10}, {-1, 1, 10},
                {0, 2, 5}
        };

        int dust = map[x][y];
        int movedDust = 0;

        for (int i = 0; i < 9; i++) {
            int nx = x + percent[i][0];
            int ny = y + percent[i][1];
            int pDust = dust * percent[i][2] / 100; // 이동할 모래

            if (oob(nx, ny)) outSand += pDust;
            else {
                map[nx][ny] += pDust; // 이동할 모래 이동
            }
            movedDust += pDust; // 여태 이동한 모래 카운트
        }

        map[x][y] = 0;

        // 알파 위치의 모래 처리
        if (!oob(x, y + 1)) {
            map[x][y + 1] += dust - movedDust;
        } else {
            outSand += (dust - movedDust);
        }
    }

    private static void moveUp(int x, int y) {
        int[][] percent = {
                {1, -1, 1}, {1, 1, 1},
                {0, -2, 2}, {0, 2, 2},
                {0, -1, 7}, {0, 1, 7},
                {-1, -1, 10}, {-1, 1, 10},
                {-2, 0, 5}
        };

        int dust = map[x][y];
        int movedDust = 0;

        for (int i = 0; i < 9; i++) {
            int nx = x + percent[i][0];
            int ny = y + percent[i][1];
            int pDust = dust * percent[i][2] / 100; // 이동할 모래

            if (oob(nx, ny)) outSand += pDust;
            else {
                map[nx][ny] += pDust; // 이동할 모래 이동
            }
            movedDust += pDust; // 여태 이동한 모래 카운트
        }

        map[x][y] = 0;

        // 알파 위치의 모래 처리
        if (!oob(x - 1, y)) {
            map[x - 1][y] += dust - movedDust;
        } else {
            outSand += (dust - movedDust);
        }
    }

    private static void moveDown(int x, int y) {
        int[][] percent = {
                {-1, -1, 1}, {-1, 1, 1},
                {0, 2, 2}, {0, -2, 2},
                {0, 1, 7}, {0, -1, 7},
                {1, -1, 10}, {1, 1, 10},
                {2, 0, 5}
        };

        int dust = map[x][y];
        int movedDust = 0;

        for (int i = 0; i < 9; i++) {
            int nx = x + percent[i][0];
            int ny = y + percent[i][1];
            int pDust = dust * percent[i][2] / 100; // 이동할 모래

            if (oob(nx, ny)) outSand += pDust;
            else {
                map[nx][ny] += pDust; // 이동할 모래 이동
            }
            movedDust += pDust; // 여태 이동한 모래 카운트
        }

        map[x][y] = 0;

        // 알파 위치의 모래 처리
        if (!oob(x + 1, y)) {
            map[x + 1][y] += dust - movedDust;
        } else {
            outSand += (dust - movedDust);
        }
    }

    private static boolean oob(int x, int y) {
        return x < 0 || y < 0 || x >= n || y >= n;
    }
}
