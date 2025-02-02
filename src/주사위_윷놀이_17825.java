import java.io.*;
import java.util.*;

public class 주사위_윷놀이_17825 {
    private static int[] dice;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        dice = new int[10];
        for (int i = 0; i < 10; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
        }

        // 말 4개
    }
}
