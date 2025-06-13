import java.util.Scanner;
import java.util.Stack;

public class P1874_스택수열 {
    /**
     * 문제 : 1부터 n까지의 수를 스택에 넣었다가 뽑아 늘어놓음으로써, 하나의 수열을 만들 수 있다. 이때, 스택에 push하는 순서는 반드시 오름차순을 지키도록 한다고 하자. 
     * 임의의 수열이 주어졌을 때 스택을 이용해 그 수열을 만들 수 있는지 없는지, 있다면 어떤 순서로 push와 pop 연산을 수행해야 하는지를 알아낼 수 있다. 이를 계산하는 프로그램을 작성하라.
     * 입력 : 첫 줄에 n (1 ≤ n ≤ 100,000)이 주어진다. 둘째 줄부터 n개의 줄에는 수열을 이루는 1이상 n이하의 정수가 하나씩 순서대로 주어진다. 물론 같은 정수가 두 번 나오는 일은 없다.
     * 출력 : 입력된 수열을 만들기 위해 필요한 연산을 한 줄에 한 개씩 출력한다. push연산은 +로, pop 연산은 -로 표현하도록 한다. 불가능한 경우 NO를 출력한다.
     */
    public static void main(String[] args) {
        // =======================
        // 슈도 코드
        // =======================
        // N(수열 개수), A[](수열 배열)
        // for(N만큼 반복)
        //{
        //  if(현재 수열 값 >= 오름차순 자연수){
        //      while(값이 같을 때까지){ push() +저장}
        //      pop(), -저장
        //  }
        //  else(현재 수열 값 <= 오름차순 자연수){
        //      pop()
        //      if(스택 pop 결괏값 > 수열의 수) NO 출력
        //      else -저장
        //  }
        // }
        // if(NO 출력한 적 없을 시) 저장한 값 출력
        //
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int A[] = new int[N];
        for(int i = 0; i < N; i++){
            A[i] = sc.nextInt();
        }
        Stack<Integer> stack = new Stack<>();
        int num = 1;
        boolean result = true;
        StringBuffer bf = new StringBuffer();
        for(int i = 0; i < N; i++){
            int su = A[i];
            if(su >= num){
                while (su >= num) {
                    stack.push(num++);
                    bf.append("+\n");
                }
                stack.pop();
                bf.append("-\n");
            }
            else{
                int n = stack.pop();
                if(n > su){
                    System.out.println("NO");
                    result = false;
                    break;
                }
                else{
                    bf.append("-\n");
                }
            }
        }
        if(result) System.out.println(bf.toString());
    }
}
