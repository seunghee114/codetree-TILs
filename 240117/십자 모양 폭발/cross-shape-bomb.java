import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static int[][] Board;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Board = new int[N][N];
        for(int i = 0; i < N; i++){
            String[] inArr = br.readLine().split(" ");
            for(int j = 0; j < N; j++){
                Board[i][j] = Integer.parseInt(inArr[j]);
            }
        }
        String[] inArr = br.readLine().split(" ");
        int I = Integer.parseInt(inArr[0])-1;
        int J = Integer.parseInt(inArr[1]) -1;
        // end input
        bomb(I, J);
        down();
        prettyPrint();

    }
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};
    static void bomb(int I, int J){
        int len = Board[I][J]-1;
        Board[I][J] = 0;
        for(int k = 0; k < 4; k++){
            int ni = I;
            int nj = J;
            for(int l = 0; l < len; l++){
                ni += di[k];
                nj += dj[k];
                if(ni < 0 || nj < 0 || ni >= N || nj >= N) continue;
                Board[ni][nj] = 0;
            }
        }
    }
    static void down(){
        int[][] temp = new int[N][N];
        for(int j = 0; j < N; j++){
            int idx = N-1;
            for(int i = N-1; i >= 0; i--){
                if(Board[i][j] == 0) continue;
                temp[idx--][j] = Board[i][j];
            }
        }
        Board = temp;
    }
    static void prettyPrint(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                sb.append(Board[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}