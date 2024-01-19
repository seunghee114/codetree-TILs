import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static boolean[][] wall;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String[] inArr = br.readLine().split(" ");
        int[] start = {Integer.parseInt(inArr[0])-1, Integer.parseInt(inArr[1])-1, 3};
        wall = new boolean[N][N];
        for(int i = 0; i < N; i++){
            String a = br.readLine();
            for(int j = 0; j < N; j++){
                if(a.charAt(j) == '#') wall[i][j] = true;
            }
        }
        // end input
        System.out.println(BFS(start));
    }
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, -1, 0, 1};
    static int[] clockwise = {3, 0, 1, 2}; 
    static int BFS(int[] pnt){
        boolean[][][] visit = new boolean[N][N][4];
        visit[pnt[0]][pnt[1]][3] = true;
        Queue<int[]> Q = new ArrayDeque<>();
        Q.add(new int[]{pnt[0], pnt[1], pnt[2], 0});
        while(!Q.isEmpty()){
            int[] pop = Q.poll();
            int ni = pop[0] + di[pop[2]];
            int nj = pop[1] + dj[pop[2]];
            if(ni < 0 || nj < 0|| ni >= N || nj >= N) return pop[3] + 1;
            if(visit[ni][nj][pop[2]]) continue;
            if(wall[ni][nj]){
                int d = (pop[2] + 1) % 4;
                Q.add(new int[]{ni, nj, d, pop[3]});
                visit[ni][nj][d] = true;
            }else{
                int d = clockwise[pop[2]];
                int ci = ni + di[d];
                int cj = nj + dj[d];
                if(ci < 0 || cj < 0 || ci >= N || cj >= N) continue;
                if(wall[ci][cj]){
                    Q.add(new int[]{ni, nj, pop[2], pop[3]+1});
                    visit[ni][nj][pop[2]] = true;
                }else{
                    if(visit[ci][cj][d]) continue;
                    Q.add(new int[]{ci, cj, d, pop[3]+2});
                    visit[ci][cj][d] = true;
                }
            }
        }
        return -1;
    }
}