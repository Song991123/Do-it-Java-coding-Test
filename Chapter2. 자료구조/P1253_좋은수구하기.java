import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1253_좋은수구하기 {
    /**
     * 문제 : N개의 수 중에서 어떤 수가 다른 수 두 개의 합으로 나타낼 수 있다면 그 수를 “좋다(GOOD)”고 한다.
     *       N개의 수가 주어지면 그 중에서 좋은 수의 개수는 몇 개인지 출력하라.
     *       수의 위치가 다르면 값이 같아도 다른 수이다.
     * 입력 : 첫째 줄에는 수의 개수 N(1 ≤ N ≤ 2,000), 두 번째 줄에는 i번째 수를 나타내는 Ai가 N개 주어진다. (|Ai| ≤ 1,000,000,000, Ai는 정수)
     * 출력 : 좋은 수의 개수를 첫 번째 줄에 출력한다.
     */
    public static void main(String[] args) throws IOException{
        // 
        // =======================
        // 슈도 코드
        // =======================
        // N(수의 개수) 
        // A[N] 배열 선언
        // for(N만큼 반복) { A 배열에 데이터 저장 }
        // A 배열 정렬
        // result 값 변수 선언
        // for(k -> 0 ~ N){
        //      변수 초기화. i = 0, j = N-1, find = A[k]
        //      while(i > j){
        //          if(A[i] + A[j] == find) {
        //              if(i != k && j != k){
        //                  result 증가;
        //                  break;
        //              }
        //              else if(i == k){
        //                  i 증가
        //              }
        //              else if(j == k){
        //                  j 감소
        //              }
        //          }
        //          else if(A[i] + A[j] < find){
        //              i 증가
        //          }
        //          else j 감소
        //      }
        // }
        // result 값 출력

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 0;
        long A[] = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            A[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(A);
        for(int k = 0; k < N; k++){
            long find = A[k];
            int i = 0; 
            int j = N-1;
            while(i < j){
                if(A[i] + A[j] == find){
                    if(i != k && j != k){
                        result++;
                        break;
                    }
                    else if (i == k){
                        i++;
                    }
                    else if(j == k){
                        j--;
                    }
                }
                else if(A[i] + A[j] < find){
                    i++;
                }
                else {
                    j--;
                }
            }
        }
        System.out.println(result);
    }
}
