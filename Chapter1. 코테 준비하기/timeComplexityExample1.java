/***
 * 시간 복잡도 예제 1
 * Big Omega: Ω(1)   // 최선의 경우 (findNumber == 0)
 * Big Theta: Θ(n) // 평균적인 경우 (findNumber == 50)
 * Big O: O(n)      // 최악의 경우 (findNumber == 99)
 */

public class timeComplexityExample1 {
    public static void main(String[] args) {
        // 1~100 사이 값 랜덤 선택
        int findNumber = (int) (Math.random() * 100);
        for(int i = 0; i < 100; i++){
            if(i == findNumber){
                System.out.println(i);
                break;
            }
        }
    }
}