import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class P12891_DNA비밀번호 {
    /**
     * 문제 : 평소에 문자열을 가지고 노는 것을 좋아하는 민호는 DNA 문자열을 알게 되었다. DNA 문자열은 모든 문자열에 등장하는 문자가 {‘A’, ‘C’, ‘G’, ‘T’} 인 문자열을 말한다. 
     * 예를 들어 “ACKA”는 DNA 문자열이 아니지만 “ACCA”는 DNA 문자열이다. 
     * 이런 신비한 문자열에 완전히 매료된 민호는 임의의 DNA 문자열을 만들고 만들어진 DNA 문자열의 부분문자열을 비밀번호로 사용하기로 마음먹었다.
     * 하지만 민호는 이러한 방법에는 큰 문제가 있다는 것을 발견했다. 
     * 임의의 DNA 문자열의 부분문자열을 뽑았을 때 “AAAA”와 같이 보안에 취약한 비밀번호가 만들어 질 수 있기 때문이다. 
     * 그래서 민호는 부분문자열에서 등장하는 문자의 개수가 특정 개수 이상이여야 비밀번호로 사용할 수 있다는 규칙을 만들었다.
     * 임의의 DNA문자열이 “AAACCTGCCAA” 이고 민호가 뽑을 부분문자열의 길이를 4라고 하자. 
     * 그리고 부분문자열에 ‘A’ 는 1개 이상, ‘C’는 1개 이상, ‘G’는 1개 이상, ‘T’는 0개 이상이 등장해야 비밀번호로 사용할 수 있다고 하자. 
     * 이때 “ACCT” 는 ‘G’ 가 1 개 이상 등장해야 한다는 조건을 만족하지 못해 비밀번호로 사용하지 못한다. 하지만 “GCCA” 은 모든 조건을 만족하기 때문에 비밀번호로 사용할 수 있다.
     * 민호가 만든 임의의 DNA 문자열과 비밀번호로 사용할 부분분자열의 길이, 그리고 {‘A’, ‘C’, ‘G’, ‘T’} 가 각각 몇번 이상 등장해야 비밀번호로 사용할 수 있는지 
     * 순서대로 주어졌을 때 민호가 만들 수 있는 비밀번호의 종류의 수를 구하는 프로그램을 작성하자. 
     * 단 부분문자열이 등장하는 위치가 다르다면 부분문자열이 같다고 하더라도 다른 문자열로 취급한다.
     * 입력 : 첫 번째 줄에 민호가 임의로 만든 DNA 문자열 길이 |S|와 비밀번호로 사용할 부분문자열의 길이 |P| 가 주어진다. (1 ≤ |P| ≤ |S| ≤ 1,000,000)
     *      두번 째 줄에는 민호가 임의로 만든 DNA 문자열이 주어진다.
     *      세번 째 줄에는 부분문자열에 포함되어야 할 {‘A’, ‘C’, ‘G’, ‘T’} 의 최소 개수가 공백을 구분으로 주어진다. 
     *      각각의 수는 |S| 보다 작거나 같은 음이 아닌 정수이며 총 합은 |S| 보다 작거나 같음이 보장된다.
     * 출력 : 첫 번째 줄에 민호가 만들 수 있는 비밀번호의 종류의 수를 출력해라.
     */
    private static int[] myArr;
    private static int checkArr[];
    private static int checkSecret;
    
    public static void main(String[] args) throws IOException{
        // P와 S의 길이가 1,000,000으로 매우 크므로 O(n)으로 풀어야 함.
        // =======================
        // 슈도 코드
        // =======================
        // S(문자열 길이), P(부분문자열 길이)
        // A(문자열 데이터)
        // checkArr(비밀번호 체크 배열)
        // myArr(현재 상태 배열)
        // checkSecret(몇 개의 문자와 관련된 개수를 충족했는지 판단하는 변수)
        // P 범위(0~ P-1) 만큼 S 배열에 적용, 유효한 비밀번호인지 판단.
        // for(i를 P에서 S까지 반복){
        //      j 선언 (i - P)
        //      // 함수 별도 구현
        //      한 칸씩 이동하며 제거되는 문자열, 새로 들어오는 문자열 처리
        //      유효 비밀번호인지 (checkSecret = 4) 판단해 결괏값에 업데이트
        // }
        // 결괏갑 출력
        // 
        // 별도 함수
        // Add(문자 더하기 함수){ 새로 들어온 문자를 myArr에 업데이트 하거나, checkSecret 값 변경}
        // Remove(문자 빼기 함수){ 제거되는 문자를 myArr에 업데이트 하거나, checkSecret 값 변경}

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken()); // 문자열 길이
        int P = Integer.parseInt(st.nextToken()); // 부분 문자열 길이
        
        int Result      = 0;             // 정답 변수
        checkArr        = new int[4];    // 비밀번호 체크 배열
        myArr           = new int[4];    // 현재 부분 문자열 상태 체크용 배열
        char A[]        = new char[S];   // 문자열 데이터
        checkSecret = 0;             // 조건이 되는 것 중 몇 개가 만족하는지 체크용

        A = br.readLine().toCharArray(); // 임의로 만든 DNA 문자열
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++){
            checkArr[i] = Integer.parseInt(st.nextToken()); // 부분문자열에 포함되어야 할 {‘A’, ‘C’, ‘G’, ‘T’} 의 최소 개수
            if(checkArr[i] == 0){
                checkSecret++; // 만약 0인 부분이 있을 경우, 있어도 없어도 상관 없으므로 1을 올려준다.
            }
        }
        for(int i = 0; i < P; i++){ // 부분 문자열 처음 받을 때 세팅
            Add(A[i]);
        }
        if(checkSecret == 4) Result++;

        //슬라이딩 윈도우
        for(int end = P; end < S; end++){ 
            int start = end - P;
            Add(A[end]);
            Remove(A[start]);
            if(checkSecret == 4) Result++;
        }

        System.out.println(Result);
        br.close();
    }
    private static void Add(char c){
        switch (c) {
            case 'A':
                myArr[0]++;
                if(myArr[0] == checkArr[0]) checkSecret++;
                break;
            case 'C':
                myArr[1]++;
                if(myArr[1] == checkArr[1]) checkSecret++;
                break;
            case 'G':
                myArr[2]++;
                if(myArr[2] == checkArr[2]) checkSecret++;
                break;
            case 'T':
                myArr[3]++;
                if(myArr[3] == checkArr[3]) checkSecret++;
                break;
        }
    }
    private static void Remove(char c){
        switch (c) {
            case 'A':
                if(myArr[0] == checkArr[0]) checkSecret--;
                myArr[0]--;
                break;
            case 'C':
                if(myArr[1] == checkArr[1]) checkSecret--;
                myArr[1]--;
                break;
            case 'G':
                if(myArr[2] == checkArr[2]) checkSecret--;
                myArr[2]--;
                break;
            case 'T':
                if(myArr[3] == checkArr[3]) checkSecret--;
                myArr[3]--;
                break;
        }
    }
}
