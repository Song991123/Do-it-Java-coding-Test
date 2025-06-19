import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P11724_연결요소의개수 {
    /**
     * 문제 : 방향 없는 그래프가 주어졌을 때, 연결 요소 (Connected Component)의 개수를 구하는 프로그램을 작성하시오.
     * 입력 : 첫째 줄에 정점의 개수 N과 간선의 개수 M이 주어진다. 
     *       (1 ≤ N ≤ 1,000, 0 ≤ M ≤ N×(N-1)/2) 둘째 줄부터 M개의 줄에 간선의 양 끝점 u와 v가 주어진다. 
     *       (1 ≤ u, v ≤ N, u ≠ v) 같은 간선은 한 번만 주어진다.
     * 출력 : 첫째 줄에 연결 요소의 개수를 출력한다.
     */

    static boolean visited[];
    static ArrayList<Integer>[] A;
    public static void main(String[] args) throws IOException{
        // =======================
        // 슈도 코드
        // =======================
        // n(노드 개수) m(에지 개수)
        // A(그래프 데이터 저장 인접 리스트)
        // visited(방문 기록 저장 배열)
        // for(n의 개수만큼 반복하기) { A 인접 리스트의 각 ArrayList 초기화하기 }
        // for(m의 개수만큼 반복하기) { A 인접 리스트에 그래프 데이터 저장하기   }
        // for(n의 개수만큼 반복하기) { 
        //      if(방문하지 않은 노드가 있으면){
        //          연결 요소 개수++ 
        //          DFS 실행
        //      }
        // }
        // // DFS 구현
        // DFS {
        //      if(현재 노드 == 방문 노드) return;
        //      visited 배열에 현재 노드 방문 기록
        //      현재 노드의 연결 노드 중 방문하지 않은 노드로 DFS 실행(재귀 함수 형태)
        // }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        visited = new boolean[n+1]; // 헷갈리니 0번을 사용하지 않으려고.
        A = new ArrayList[n+1];

        for(int i = 1; i < n+1; i++){
            A[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            A[s].add(e);
            A[e].add(s);
        }
        int count = 0;
        for(int i = 1; i < n+1; i++){
            if(!visited[i]){
                count++;
                DFS(i);
            }
        }
        System.out.println(count);
    }
    private static void DFS(int v) {
        if(visited[v]){
            return;
        }
        visited[v] = true;
        for(int i : A[v]){
            if(!visited[i]){
                DFS(i);
            }
        }
    }
}