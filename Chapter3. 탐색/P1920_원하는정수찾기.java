import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class P1920_원하는정수찾기 {
    /**
     * 문제 : N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때, 이 안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오.
     * 입력 : 첫째 줄에 자연수 N(1 ≤ N ≤ 100,000)이 주어진다. 다음 줄에는 N개의 정수 A[1], A[2], …, A[N]이 주어진다. 
     *       다음 줄에는 M(1 ≤ M ≤ 100,000)이 주어진다. 
     *       다음 줄에는 M개의 수들이 주어지는데, 이 수들이 A안에 존재하는지 알아내면 된다. 
     *       모든 정수의 범위는 -231 보다 크거나 같고 231보다 작다.
     * 출력 : M개의 줄에 답을 출력한다. 존재하면 1을, 존재하지 않으면 0을 출력한다.
     */
    public static void main(String[] args) throws IOException{
        // =======================
        // 슈도 코드
        // =======================
        // N(정렬할 수 개수), M{탐색할 숫자 개수}
        // for(N의 개수만큼 반복)
        // {
        //      A배열 저장
        // }
        // for(M의 개수만큼 반복하기)
        // {
        //      target(찾야아 하는 수)
        //      start(시작 인덱스), end(종료 인덱스)
        //      while(시작 인덱스 <= 종료 인덱스) { // 탐색할 부분이 없을 때까지
        //          midi(중간 인덱스)
        //          if(중앙값 > target){
        //              종료 인덱스 = 중간 인덱스 - 1
        //          }
        //          else if(중앙값 < target){
        //              시작 인덱스 = 중간 인덱스 + 1
        //          }
        //          else{
        //              찾았으므로 반복문 종료
        //          }
        //      }
        //      if(찾았음) 1 출력
        //      else 0 출력
        // }
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for(int i = 0; i < N; i++){
            A[i] = sc.nextInt();
        }
        Arrays.sort(A);
        int M = sc.nextInt();
        for(int i = 0; i < M; i++){
            boolean find = false;
            int target = sc.nextInt();
            int start = 0;
            int end = A.length -1;
            while(start <= end){
                int mid_index = (start + end) / 2;
                int mid_value = A[mid_index];
                if(mid_value > target){
                    end = mid_index - 1;
                }
                else if(mid_value < target){
                    start = mid_index + 1;
                }
                else{
                    find = true;
                    break;
                }
            }
            if(find) System.out.println(1);
            else System.out.println(0);
        }
    }
}
