import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static boolean[][] coins;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        coins = new boolean[N][N];
        for(int i = 0; i < N; i++){
            String[] inArr = br.readLine().split(" ");
            for(int j = 0; j < N; j++){
                int number = Integer.parseInt(inArr[j]);
                if(number == 1) coins[i][j] = true;
            }
        }// end input
        System.out.println(makeRectangle());
    }
    static int makeRectangle(){
        int answer = 0;
        for(int i = 0; i <= N - 3; i++){
            for(int j = 0; j <= N - 3; j++){
                answer = Math.max(answer, countCoin(i, j));
            }
        }
        return answer;
    }
    static int countCoin(int I, int J){
        int cnt = 0;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(coins[I+i][J+j]) cnt++;
            }
        }
        return cnt;
    }
}