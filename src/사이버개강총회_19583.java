import java.io.*;
import java.util.*;

/*******************************************************************************
 * 소요시간: 25분
 * 시간복잡도: O(10^5)
 * 메모리: 88784 kb
 * 시간: 640 ms
 *******************************************************************************/

public class 사이버개강총회_19583 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String start = st.nextToken();
        String end = st.nextToken();
        String sEnd = st.nextToken();

        int startH = Integer.parseInt(start.split(":")[0]);
        int startM = Integer.parseInt(start.split(":")[1]);

        int endH = Integer.parseInt(end.split(":")[0]);
        int endM = Integer.parseInt(end.split(":")[1]);

        int sEndH = Integer.parseInt(sEnd.split(":")[0]);
        int sEndM = Integer.parseInt(sEnd.split(":")[1]);

        Map<String, Integer> map = new HashMap<>();

        while (true) { // O(10^5)
            String input = br.readLine();
            if (input == null || input.isEmpty()) break; // 입력 없을 시 종료

            st = new StringTokenizer(input);

            String time = st.nextToken();
            String nickname = st.nextToken();

            int timeH = Integer.parseInt(time.split(":")[0]);
            int timeM = Integer.parseInt(time.split(":")[1]);

            if (!map.containsKey(nickname)) { // 닉네임이 없는 경우,  // 평균: O(1) 최악: O(n)
                // 첫 입장
                if (checkEnterTime(timeH, timeM, startH, startM)) {
                    map.put(nickname, 1); // 상태값 1: 입장
                }
            } else { // 닉네임이 있는 경우
                // 퇴장 or 채팅을 치는 경우
                if (map.get(nickname) != 1) continue;
                if (checkOutTime(timeH, timeM, endH, endM) && checkEnterTime(timeH, timeM, sEndH, sEndM)) {
                    map.put(nickname, 2); // 상태값 2: 정상 퇴장
                }
            }
        }

        int count = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 2) count++;
        }
        System.out.println(count);
    }

    private static boolean checkEnterTime(int h, int m, int enterH, int enterM) { // h:m은 enterH:enterM보다 앞 시간이여야 함
        if (h < enterH) return true;
        else if (h == enterH) {
            if (m <= enterM) return true;
            else return false;
        } else { // h > outH
            return false;
        }
    }

    private static boolean checkOutTime(int h, int m, int outH, int outM) { // h:m은 outH:outM보다 뒷 시간이여야 함
        if (h > outH) return true;
        else if (h == outH) {
            if (m >= outM) return true;
            else return false;
        } else { // h < outH
            return false;
        }
    }
}
