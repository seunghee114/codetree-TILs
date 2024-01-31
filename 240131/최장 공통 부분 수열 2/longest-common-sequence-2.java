import java.util.*;
import java.io.*;
public class Main {
    static class Tuple{
        int len, i, j;
        public Tuple(){}
        public Tuple(int len, int i, int j){
            this.len = len;
            this.i = i;
            this.j = j;
        }
        public String toString(){
            return "len: " + this.len + ", ( " + i +", " + j + " )";
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tempA = "-" + br.readLine();
        String tempB = "-" + br.readLine();
        char[] a = tempA.toCharArray();
        char[] b = tempB.toCharArray();
        int lenA = a.length;
        int lenB = b.length;

        // dp[i][j] = {현재 최장 공통 부분 수열의 길이, 이전에 온 좌표 x, y}
        Tuple[][] dp = new Tuple[lenA][lenB];
        for(int i = 0; i < lenA; i++){
            dp[i][0] = new Tuple(0, -1, -1);
        }
        for(int j = 0; j < lenB; j++){
            dp[0][j] = new Tuple(0, -1, -1);
        }
        for(int i = 1; i < lenA; i++){
            for(int j = 1; j < lenB; j++){
                if(dp[i-1][j-1] != null){
                    dp[i][j] = new Tuple(dp[i-1][j-1].len, i-1, j-1);
                }
                if(dp[i][j] != null && a[i] == b[i]){
                    dp[i][j].len++;
                    continue;
                }
                if(dp[i-1][j] != null){
                    if(dp[i][j] == null || dp[i][j].len < dp[i-1][j].len){
                        dp[i][j] = new Tuple(dp[i-1][j].len, i-1, j);    
                    }
                }
                if(dp[i][j-1] != null){
                    if(dp[i][j] == null || dp[i][j].len < dp[i][j-1].len){
                        dp[i][j] = new Tuple(dp[i][j-1].len, i, j-1);
                    } 
                }
                System.out.printf("(i, j) = ( %d, %d ), %s\n", i, j, dp[i][j].toString());
            }
            
        }
        StringBuilder sb = new StringBuilder();
        Tuple tp = new Tuple(-1, lenA-1, lenB-1);
        while(tp.i != -1 && tp.j != -1){
            if(a[tp.i] == b[tp.j]){
                sb.append(a[tp.i]);
            }
            tp = dp[tp.i][tp.j];
        }
        System.out.println(sb.reverse());
    }
}