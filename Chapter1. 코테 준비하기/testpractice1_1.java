import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * 문제 : N개의 수가 주어졌을 때 이를 오름차순 정렬하는 프로그램을 작성하시오.
 * 입력 : 첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000,000)이 주어진다. 둘째 줄 부터는 N개의 수가 주어진다.
 * 출력 : 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
 * 수는 중복되지 않는다.
 * 정렬 방식 : 버블 정렬
 */

public class testpractice1_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        // 정렬
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        // 출력
        for(int i = 0; i < N; i++){
            System.out.println(arr[i]);
        }
    }
}
