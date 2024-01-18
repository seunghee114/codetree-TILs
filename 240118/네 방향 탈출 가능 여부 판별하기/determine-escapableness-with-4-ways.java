import java.util.*;
import java.io.*;
public class Main {
    static int N, M;
    static boolean[][] Snake;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inArr = br.readLine().split(" ");
        N = Integer.parseInt(inArr[0]);
        M = Integer.parseInt(inArr[0]);
        Snake = new boolean[N][M];
        for(int i = 0; i < N; i++){
            inArr = br.readLine().split(" ");
            for(int j = 0; j < M; j++){
                if(inArr[j].equals("0")){
                    Snake[i][j] = true;
                }
            }
        }// end input
        System.out.println(BFS() ? 1 : 0);
    }
    static boolean BFS(){
        boolean[][] visit = new boolean[N][M];
        Queue<int[]> Q = new ArrayDeque<>();
        Q.add(new int[]{0, 0});
        visit[0][0] = true;
        while(!Q.isEmpty()){
            int[] pop = Q.poll();
            for(int k = 0 ; k < 4; k++){
                int ni = di[k] + pop[0];
                int nj = dj[k] + pop[1];
                if(ni < 0 || nj < 0 || ni >= N || nj >= M) continue;
                if(visit[ni][nj] || Snake[ni][nj]) continue;
                if(ni == N-1 && nj == M-1) return true;
                Q.add(new int[] {ni, nj});
                visit[ni][nj] = true;
            }
        }
        return false;
    }
}