import java.util.Scanner;

public class P1427_소트인사이드 {
    /**
     * 문제 : 배열을 정렬하는 것은 쉽다. 수가 주어지면, 그 수의 각 자리수를 내림차순으로 정렬해보자.
     * 입력 : 첫째 줄에 정렬하려고 하는 수 N이 주어진다. N은 1,000,000,000보다 작거나 같은 자연수이다.
     * 출력 : 첫째 줄에 자리수를 내림차순으로 정렬한 수를 출력한다.
     */
    public static void main(String[] args) {
        // =======================
        // 슈도 코드
        // =======================
        // str(정렬할 수)
        // A(자릿수별로 구분해 저장한 배열)
        // for(str의 길이만큼 반복){
        // A 배열 저장 -> str.substring 사용
        // }
        // for(i : 0 ~ str 길이만큼 반복){
        //      for( j : i + 1 ~ str 길이만큼 반복){
        //          현재 범위에서 Max 값 찾기
        //      }
        //      현재 i의 값과 Max 값 중 Max 값이 더 크면 swap 수행
        // }
        // A 배열 출력
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int A[] = new int[str.length()];
        for(int i = 0; i < str.length(); i++){
            A[i] = Integer.parseInt(str.substring(i, i+1));
        }

        // 선택정렬
        for(int i = 0; i < str.length(); i++){
            int Max = i;
            for(int j = i+1; j < str.length(); j++){
                if(A[j] > A[Max]) Max = j;
            }
            if(A[i] < A[Max]) {
                int temp = A[i];
                A[i] = A[Max];
                A[Max] = temp;
            }
        }
        
        // 배열 출력
        for(int i = 0; i < str.length(); i++){
            System.out.print(A[i]);
        }
    }
}
