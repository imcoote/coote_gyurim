import java.io.*;
import java.util.*;

/*******************************************************************************
 * 소요시간: 1시간 30분
 * 시간복잡도: O(t * nlogn)
 * 메모리: 301620 kb
 * 시간: 1592 ms
 *******************************************************************************/

public class 신입사원_1946 {
    private static class Grade implements Comparable<Grade> {
        int dG, iG;

        Grade(int documentScore, int interviewScore) {
            this.dG = documentScore;
            this.iG = interviewScore;
        }

        @Override
        public int compareTo(Grade o) {
            if (this.dG == o.dG) {
                return Integer.compare(this.iG, o.iG);
            } else return Integer.compare(this.dG, o.dG);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) { // O(t)
            int n = Integer.parseInt(br.readLine());
            List<Grade> grades = new ArrayList<>();

            for (int i = 0; i < n; i++) { // O(n)
                st = new StringTokenizer(br.readLine());
                int dGrade = Integer.parseInt(st.nextToken());
                int iGrade = Integer.parseInt(st.nextToken());

                grades.add(new Grade(dGrade, iGrade));
            }

            Collections.sort(grades); // O(nlogn)

            int firstiG = Integer.MAX_VALUE; // 선발된 사람들 중 가장 높은 인터뷰 등급
            List<Grade> selected = new ArrayList<>();

            for (int i = 0; i < n; i++) { // O(n)
                if (selected.size() == 0) {
                    selected.add(grades.get(i)); // 서류 1등급 들어감
                    firstiG = grades.get(i).iG;
                } else {
                    if (firstiG > grades.get(i).iG) { // 선발된 사람들의 인터뷰 등급보다 높다면 선발 (grades 정렬했으므로 무조건 서류 등급은 선발된 사람보다 낮음)
                        selected.add(grades.get(i));
                        firstiG = Math.min(firstiG, grades.get(i).iG);
                    }
                }
            }
            sb.append(selected.size()).append("\n");
        }
        System.out.print(sb);
    }
}
