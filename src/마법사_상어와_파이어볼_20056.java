import java.io.*;
import java.util.*;

/*******************************************************************************
 * 소요시간: 1시간
 * 시간복잡도: O(k * (n * n + m))
 * 메모리: 35088 kb
 * 시간: 456 ms
 *******************************************************************************/

public class 마법사_상어와_파이어볼_20056 {
    private static int n;
    private static List<Ball> board[][]; // 동일한 좌표 내의 파이어볼을 관리하기 위함

    private static int[][] dirs = {
            {-1, 0},    // 0
            {-1, 1},    // 1
            {0, 1},     // 2
            {1, 1},     // 3
            {1, 0},     // 4
            {1, -1},    // 5
            {0, -1},    // 6
            {-1, -1}    // 7
    };

    private static List<Ball> balls;

    private static class Ball {
        int x, y;
        int m, d, s; // 질량, 방향, 속력

        Ball(int x, int y, int m, int s, int d) {
            this.x = x;
            this.y = y;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        balls = new ArrayList<>();

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int mass = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());

            balls.add(new Ball(r, c, mass, speed, dir));
        }

        // 모든 배열 요소에 대해 ArrayList 초기화
        board = new ArrayList[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                board[i][j] = new ArrayList<>();
            }
        }

        while (k-- > 0) { // O(k)
            moveBall();
        }

        System.out.println(countBall());
    }

    private static int countBall() {
        int count = 0;
        for (Ball b : balls) {
            count += b.m;
        }

        return count;
    }

    private static void moveBall() { // O( n * n + m)
        for (int i = 1; i <= n; i++) { // O(n * n)
            for (int j = 1; j <= n; j++) {
                board[i][j].clear();
            }
        }

        for (Ball b : balls) { // 모든 파이어볼에 대해서 이동 진행 // O(m)
            int nx = b.x + (dirs[b.d][0] * (b.s % n));
            int ny = b.y + (dirs[b.d][1] * (b.s % n));
            if (nx <= 0) nx += n;
            if (ny <= 0) ny += n;
            if (nx > n) nx -= n;
            if (ny > n) ny -= n;

            b.x = nx;
            b.y = ny;

            board[nx][ny].add(b);
        }

        // 같은 칸에 있는 파이어볼은 모두 하나로 합쳐짐
        balls.clear();
        balls = mergeBall(board);
    }

    private static List<Ball> mergeBall(List<Ball>[][] board) { // O(n * n + m): 모든 볼은 총 m개 이므로 + m
        List<Ball> newBalls = new ArrayList<>();

        for (int i = 1; i <= n; i++) { // O(n * n)
            for (int j = 1; j <= n; j++) {
                int count = board[i][j].size();
                if (count == 0) continue;
                if (count == 1) {
                    newBalls.add(board[i][j].get(0));
                    continue;
                }

                // 여러 개 있는 경우
                int totalMass = 0;
                int totalSpeed = 0;
                boolean dirIsSame = true;
                boolean isOddDir = isOdd(board[i][j].get(0).d);

                for (Ball b : board[i][j]) {
                    totalMass += b.m;
                    totalSpeed += b.s;

                    if (isOddDir != isOdd(b.d)) dirIsSame = false;
                }

                int[] nDirs;
                if (dirIsSame) {
                    nDirs = new int[]{0, 2, 4, 6};
                } else {
                    nDirs = new int[]{1, 3, 5, 7};
                }

                if (totalMass / 5 == 0) continue; // 소멸

                for (int d = 0; d < 4; d++) {
                    newBalls.add(new Ball(i, j, totalMass / 5, totalSpeed / count, nDirs[d]));
                }
            }
        }

        return newBalls;
    }

    private static boolean isOdd(int dir) {
        if (dir % 2 == 0) return false; // 짝수
        return true;
    }
}
