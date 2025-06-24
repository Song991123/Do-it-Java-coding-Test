import java.util.Scanner;

public class P10986_나머지합 {
    /**
     * 문제 : 수 N개 A1, A2, ..., AN이 주어진다. 이때, 연속된 부분 구간의 합이 M으로 나누어 떨어지는 구간의 개수를 구하는 프로그램을 작성하시오.
     *       즉, Ai + ... + Aj (i ≤ j) 의 합이 M으로 나누어 떨어지는 (i, j) 쌍의 개수를 구해야 한다.
     * 입력 : 첫째 줄에 N과 M이 주어진다. (1 ≤ N ≤ 106, 2 ≤ M ≤ 103)
     *       둘째 줄에 N개의 수 A1, A2, ..., AN이 주어진다. (0 ≤ Ai ≤ 109)
     * 출력 : 첫째 줄에 연속된 부분 구간의 합이 M으로 나누어 떨어지는 구간의 개수를 출력한다.
     */
    public static void main(String[] args) {
        // =======================
        // 슈도 코드
        // =======================
        // N(수 개수), M(목표 수)
        // S[N](합 배열) 선언
        // C[M](나머지가 어떻게 떴는지 저장하는 배열) 선언
        // S[0] = 입력받은 값 첫번째
        // answer(답 저장용 변수) 선언
        // for(i -> 1 ~ N){
        //      S[i] = S[i-1] + 나머지 입력받은 값;
        // }
        // for(i -> 0 ~ N){
        //      remainder = S[i] % M;
        //      if(remainder == 0) answer++;
        //      C[remainder]++;
        // }
        // for(i -> 0 ~ M){
        //      C[i](i가 나머지인 인덱스의 개수) 에서 2가지를 뽑는 경우의 수를 정답에 더함
        //  }
        // 결괏값(answer) 출력

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        long[] S = new long[N];
        long[] C = new long[M];
        long answer = 0;
        
        S[0] = sc.nextInt();
        for(int i = 1; i < N; i++){
            S[i] = S[i-1] + sc.nextInt();
        }
        for(int i = 0; i < N; i++){
            int remainder = (int)(S[i] % M);
            if (remainder == 0) answer++;
            C[remainder]++;
        }
        for(int i = 0; i < M; i++){
            answer = answer + (C[i] * (C[i] - 1 )/ 2); // 경우의 수
        }
        System.out.println(answer);
    }
}
