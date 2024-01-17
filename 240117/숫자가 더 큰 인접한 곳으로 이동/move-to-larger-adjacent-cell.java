import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static int[] Pnt;
    static int[][] Board;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inArr = br.readLine().split(" ");
        N = Integer.parseInt(inArr[0]);
        Pnt = new int[]{Integer.parseInt(inArr[1])-1, Integer.parseInt(inArr[2])-1};
        Board = new int[N][N];
        for(int i = 0; i < N; i++){
            inArr = br.readLine().split(" ");
            for(int j = 0; j < N; j++){
                Board[i][j] = Integer.parseInt(inArr[j]);
            }
        } // end input

        StringBuilder sb = new StringBuilder();
        sb.append(Board[Pnt[0]][Pnt[1]]).append(" ");
        while(move()){
            sb.append(Board[Pnt[0]][Pnt[1]]).append(" ");    
        }

        System.out.println(sb);
    }
    static boolean move(){
        int pivot = Board[Pnt[0]][Pnt[1]];
        int dir = -1;
        for(int k = 0; k < 4; k++){
            int ni = Pnt[0] + di[k];
            int nj = Pnt[1] + dj[k];
            if(ni < 0 || nj < 0 || ni >= N || nj >= N) continue;
            if(Board[ni][nj] <= pivot) continue;
            dir = k;
            pivot = Board[ni][nj];
            break;
        }
        if(dir == -1) return false;
        Pnt[0] += di[dir];
        Pnt[1] += dj[dir];
        return true;
    }
}