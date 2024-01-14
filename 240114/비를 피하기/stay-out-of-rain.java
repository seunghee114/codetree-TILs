import java.util.*;
import java.io.*;
public class Main {
    static int N, H, M;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};
    static int[][] Board;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inArr = br.readLine().split(" ");
        N = Integer.parseInt(inArr[0]);     // 격자의 크기
        H = Integer.parseInt(inArr[1]);     // 사람의 수
        M = Integer.parseInt(inArr[2]);     // 안전공간의 수

        Board = new int[N][N];
        for(int i = 0; i < N; i++){
            inArr = br.readLine().split(" ");
            for(int j = 0; j < N; j++){
                Board[i][j] = Integer.parseInt(inArr[j]);
            }
        } // end input

        int[][] Answer = new int[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(Board[i][j] == 2){
                    Answer[i][j] = BFS(i, j);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                sb.append(Answer[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
    static int BFS(int I, int J){
        boolean[][] visit = new boolean[N][N];
        Queue<int[]> Q = new ArrayDeque<>();
        int time = 0;
        Q.add(new int[]{I, J});
        visit[I][J] = true;
        while(!Q.isEmpty()){
            int S = Q.size();
            for(int s = 0; s < S; s++){
                int[] pop = Q.poll();
                for(int k = 0; k < 4; k++){
                    int ni = pop[0] + di[k];
                    int nj = pop[1] + dj[k];
                    if(ni < 0 || nj < 0 || ni >= N || nj >= N) continue;
                    if(visit[ni][nj] || Board[ni][nj] == 1) continue;
                    if(Board[ni][nj] == 3) return time + 1;
                    visit[ni][nj] = true;
                    Q.add(new int[]{ni, nj});
                }
            }
            time++;
        }
        return -1;
    }
}