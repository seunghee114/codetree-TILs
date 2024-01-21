import java.util.*;
import java.io.*;
public class Main {
    static int N, M;
    static int[][] number;
    static HashMap<Integer, int[]> map; 
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inArr = br.readLine().split(" ");
        N = Integer.parseInt(inArr[0]);
        M = Integer.parseInt(inArr[1]);
        number = new int[N][N];
        map = new HashMap<>();      // key : 숫자, value : 숫자의 위치
        for(int i = 0; i < N; i++){
            inArr = br.readLine().split(" ");
            for(int j = 0; j < N; j++){
                number[i][j] = Integer.parseInt(inArr[j]);
                map.put(number[i][j], new int[]{i, j});
            }
        }
        // end input

        for(int m = 0; m < M; m++){
            for(int n = 1; n <= N * N; n++){
                move(map.get(n));
            }
        }
        pretty();
    }
    static void pretty(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                sb.append(number[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static int[] di = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dj = {0, 1, 1, 1, 0, -1, -1, -1};
    
    static boolean notRange(int I, int J){
        return I < 0 || J < 0 || I >= N || J >= N;
    }
    static void move(int[] pnt){
        int chk = -1;
        int d = -1;
        for(int k = 0; k < di.length; k++){
            int ni = pnt[0] + di[k];
            int nj = pnt[1] + dj[k];
            if(notRange(ni, nj)) continue;
            if(number[ni][nj] > chk){
                chk = number[ni][nj];
                d = k;
            }
        }
        int ni = pnt[0] + di[d];
        int nj = pnt[1] + dj[d];

        // number[pnt[0]][pnt[1]] <-> number[ni][nj]
        number[ni][nj] = number[pnt[0]][pnt[1]];
        number[pnt[0]][pnt[1]] = chk;
        map.put(number[ni][nj], new int[]{ni, nj});
        map.put(number[pnt[0]][pnt[1]], new int[]{pnt[0], pnt[1]});
    }
}