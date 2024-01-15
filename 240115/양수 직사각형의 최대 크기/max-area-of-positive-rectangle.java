import java.util.*;
import java.io.*;
public class Main {
    static int N, M;
    static int[][] Board;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inArr = br.readLine().split(" ");
        N = Integer.parseInt(inArr[0]);
        M = Integer.parseInt(inArr[1]);
        Board = new int[N][M];
        for(int i = 0; i < N; i++){
            inArr = br.readLine().split(" ");
            for(int j = 0; j < M; j++){
                Board[i][j] = Integer.parseInt(inArr[j]);
            }
        } // end input
        System.out.println(makeRectangle());
    }
    static int makeRectangle(){
        int answer = -1;
        for(int selo = N; selo > 0; selo--){    // 사각형의 세로 길이
            for(int galo = M; galo > 0; galo--){    // 사각형의 가로 길이
                for(int i = 0; i <= N - selo; i++){     // 사각형의 좌상단 세로 좌표
                    for(int j = 0; j <= M - galo; j++){ // 사각형의 좌상단 가로 좌표
                        if(checkRectangle(selo, galo, i, j)){
                            answer = Math.max(answer, selo * galo);
                        }
                    }
                }
            }
        }
        return answer;
    }
    static boolean checkRectangle(int selo, int galo, int I, int J){
        for(int i = 0; i < selo; i++){
            for(int j = 0; j < galo; j++){
                if(Board[I+i][J+j] <= 0) return false;
            }
        }
        return true;
    }
}