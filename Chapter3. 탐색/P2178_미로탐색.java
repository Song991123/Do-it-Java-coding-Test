import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2178_미로탐색 {
    /**
     * 문제 : N×M크기의 배열로 표현되는 미로가 있다.
     *       미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다. 
     *       이러한 미로가 주어졌을 때, (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오. 
     *       한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동할 수 있다.
     *       위의 예에서는 15칸을 지나야 (N, M)의 위치로 이동할 수 있다. 칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.
     * 입력 : 첫째 줄에 두 정수 N, M(2 ≤ N, M ≤ 100)이 주어진다. 다음 N개의 줄에는 M개의 정수로 미로가 주어진다. 각각의 수들은 붙어서 입력으로 주어진다.
     * 출력 : 첫째 줄에 연결 요소의 개수를 출력한다.
     */
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visited;
    static int[][] A;
    static int N, M;

    public static void main(String[] args) throws IOException{
        // =======================
        // 슈도 코드
        // =======================
        // dx, dy(상하좌우를 탐색하기 위한 define 값 정의 변수)
        // A(데이터 저장 2차원 행렬)
        // N(row), M(column)
        // visited(방문 기록 저장 배열)
        // A 배열 초기화
        // visited 배열 초기화
        // for(N의 개수만큼){
        //      for(M의 개수만큼){ A 배열에 데이터 저장}
        // }
        // BFS(0,0) 실행
        // A[N-1][N-1] 값 출력
        // BFS(m, n){
        //      큐 자료구조에 시작 노드 삽입(add)
        //      visited 배열에 현재 노드 방문 기록
        //      while(큐가 빌 때까지){
        //          큐에서 노드 데이터 가져오기 (poll)
        //          for(상하좌우 탐색){
        //              if(유효좌표){
        //                  if(이동할 수 있는 칸 && 방문 안한 노드){
        //                      visited 배열에 방문 기록
        //                      A 배열에 depth를 현재 노드의 depth + 1로 업뎃
        //                      큐에 데이터 삽입(add 연산)
        //                  }
        //              }
        //          }
        //      }
        // }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][M];
        visited = new boolean[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for(int j = 0; j < M; j++){
                A[i][j] = Integer.parseInt(line.substring(j, j + 1));
            }
        }
        BFS(0, 0);
        System.out.println(A[N-1][M-1]);
    }

    private static void BFS(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {i,j});
        visited[i][j] = true;
        while(!queue.isEmpty()){
            int now[] = queue.poll();
            // 상하좌우 탐색
            for(int k = 0; k < 4; k++){
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];
                if(x >= 0 && y >= 0 && x < N && y < M){ // 배열을 넘어가면 안됨
                    if(A[x][y] != 0 && !visited[x][y]){ // 0이어서 갈 수 없거나, 기방문할 수 있는 곳이면 안됨.
                        //갈 수 있는 곳이면
                        visited[x][y] = true;
                        A[x][y] = A[now[0]][now[1]] + 1; //핵심
                        queue.add(new int[] {x,y});

                    }
                }
            }
        }
    }

}
