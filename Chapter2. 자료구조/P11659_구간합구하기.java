import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11659_구간합구하기 {
    /**
     * 문제 : 수 N개가 주어졌을 때 i번째 수에서 j 번째 수까지의 합을 구하는 프로그램을 작성하시오.
     * 입력 : 첫째 줄에 수의 개수 N(1 ≤ N ≤ 100,000)과 합을 구해야 하는 횟수 M(1 ≤ M ≤ 100,000)이 주어진다. 둘째 줄에는 N개의 수가 주어진다. 수는 1,000보다 작거나 같은 자연수이다. 
     *       셋째 줄부터 M개의 줄에는 합을 구해야 하는 구간 i와 j가 주어진다.
     * 출력 : 총 M개의 줄에 입력으로 주어진 i번째 수부터 j번째 수까지 합을 출력한다.
     */
    public static void main(String[] args) throws IOException{
        // =======================
        // 슈도 코드
        // =======================
        // suNo(숫자 개수), QuizNo(질의 개수) 저장
        // S[suNo + 1]이라는 합 배열 제작하기. 1 ≤ i ≤ j ≤ N 될 것이므로. 0은 0으로 초기화하고 1부터 시작.
        // for(숫자 개수만큼 반복) { 합 배열 S에 데이터 값 입력. S[i-1] + A[i] }
        // for(질의 개수M만큼 반복){질의 범위 받기(i ~ j), 구간 합 출력하기(S[j] - S[i-1])}
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 데이터를 많이 받으므로 버퍼리더 활용
        StringTokenizer st = new StringTokenizer(br.readLine()); 
        int suNo = Integer.parseInt(st.nextToken());
        int QuizNo = Integer.parseInt(st.nextToken());
        long[] S = new long[suNo + 1]; // 

        st = new StringTokenizer(br.readLine()); 
        for(int i = 1; i <= suNo; i++){
            S[i] = S[i-1] + Integer.parseInt(st.nextToken());
        }

        for(int q = 0; q < QuizNo; q++){
            st = new StringTokenizer(br.readLine()); 
            int i = Integer.parseInt(st.nextToken());
            int j =Integer.parseInt(st.nextToken());
            System.out.println(S[j] - S[i-1]);
        }
        
    }
}