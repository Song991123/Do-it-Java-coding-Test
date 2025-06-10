import java.util.Scanner;

/**
 * 문제 : N개의 숫자가 공백 없이 써 있다. 이 숫자들을 모두 합하는 프로그램을 작성하시오.
 * 입력 : 1번째 줄에 숫자의 개수 N(1 ≤ N ≤ 100), 2번쨰 줄에 숫자 N개가 공백 없이 주어진다.
 * 출력 : 입력으로 주어진 숫자 N개의 합을 출력한다.
 */

public class P11720_NumberAdd {
    public static void main(String[] args){


        // 1. 숫자의 개수만큼 입력받은 값을 String 형으로 저장
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String sNum = sc.next();
        // 2. String 형으로 입력받은 값을 char[] 형으로 변환
        char[] cNum = sNum.toCharArray();
        
        // 3. 인덱스 0부터 끝까지 배열을 탐색하며 각 값을 정수형으로 변환하고 결괏값에 더하여 누적
        int sum = 0;
        for(int i = 0; i < N; i++){
            sum += cNum[i] - 48; // 48 == '0'
        }
        // 4. 출력
        System.out.println(sum);
    }

}