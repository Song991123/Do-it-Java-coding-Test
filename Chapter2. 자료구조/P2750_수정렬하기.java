import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class P2750_수정렬하기 {
    /**
     * 문제 : N개의 수가 주어졌을 때 이를 오름차순 정렬하는 프로그램을 작성하시오.
     * 입력 : 첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수가 주어진다. 이 수는 절댓값이 1,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.
     * 출력 : 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
     */
    public static void main(String[] args) throws IOException{
        // =======================
        // 슈도 코드
        // =======================
        // N 변수 저장, A 배열 선언
        // A[N]에 데이터 차례대로 저장
        // for( i : 0 ~ N-1){ //루프 개수
        //      for( j : 0 ~ N - 1 - i){
        //          현재 A 배열의 값보다 1칸 오른쪽 배열의 값이 더 작으면 두 수를 바꾼다.
        //      }
        //  }
        // A 출력
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int A[] = new int[N];

        for(int i = 0; i < N; i++){
            A[i] = sc.nextInt();
        }
        
        for(int i = 0; i < N-1; i++){
            for(int j = 0; j < N-1-i; j++){
                if(A[j] > A[j+1]){
                    int temp = A[j+1];
                    A[j+1] = A[j];
                    A[j] = temp;
                }
            }
        }
        for(int i = 0; i < N; i++){
            System.out.println(A[i]);
        }
    }
}
