import java.util.*;
import java.io.*;
public class Main {
    static int N, K;
    static boolean[][] Wall;
    static int[][] start;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inArr = br.readLine().split(" ");
        N = Integer.parseInt(inArr[0]);
        K = Integer.parseInt(inArr[1]);
        Wall = new boolean[N][N];
        for(int i = 0; i < N; i++){
            inArr = br.readLine().split(" ");
            for(int j = 0; j < N; j++){
                if(inArr[j].equals("1")){
                    Wall[i][j] = true;
                }
            }
        }
        start = new int[K][2];
        for(int k = 0; k < K; k++){
            inArr = br.readLine().split(" ");
            start[k][0] = Integer.parseInt(inArr[0]);
            start[k][1] = Integer.parseInt(inArr[1]);
        }
        // end input
        System.out.println(BFS());
    }
    static int BFS(){
        boolean[][] visit = new boolean[N][N];
        Queue<int[]> Q =  new ArrayDeque<>();
        for(int k = 0; k < K; k++){
            Q.add(new int[]{start[k][0], start[k][1]});
            visit[start[k][0]][start[k][1]] = true;
        }
        while(!Q.isEmpty()){
            int[] pop = Q.poll();
            for(int k = 0; k < 4; k++){
                int ni = di[k] + pop[0];
                int nj = dj[k] + pop[1];
                if(ni < 0 || nj < 0 || ni >= N || nj >= N || visit[ni][nj] || Wall[ni][nj]) continue;
                Q.add(new int[]{ni, nj});
                visit[ni][nj] = true;
            }
        }
        return count(visit);
    }
    static int count(boolean[][] visit){
        int cnt = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(visit[i][j] && !Wall[i][j]) cnt++;
            }
        }
        return cnt;
    }
}