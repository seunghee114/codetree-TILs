import java.util.*;
import java.io.*;
public class Main {
    static int N, Answer;
    static int[] number;
    static boolean[] isSelect;
    static int[][] Board;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Board = new int[N][N];
        for(int i=0; i < N; i++){
            String[] inArr = br.readLine().split(" ");
            for(int j = 0; j < N; j++){
                Board[i][j] = Integer.parseInt(inArr[j]);
            }
        }// end input

        number = new int[N];
        isSelect = new boolean[N];
        Answer = 0;
        permutation(0);
        
        System.out.println(Answer);
    }
    static void permutation(int cnt){
        if(cnt == N){
            count();
            return;
        }
        for(int i = 0; i < N; i++){
            if(isSelect[i]) continue;
            number[cnt] = i;
            isSelect[i] = true;
            permutation(cnt+1);
            isSelect[i] = false;
        }
    }
    static void count(){
        int cnt = 0;
        for(int i = 0; i < N; i++){
            cnt += Board[i][number[i]];
        }
        Answer = Math.max(Answer, cnt);
    }
}