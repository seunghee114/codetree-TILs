import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] A = br.readLine().toCharArray();
        char[] B = br.readLine().toCharArray();
        int ALen = A.length;
        int BLen = B.length;
        // end input

        // dp[i][j] : A를 i번 문자까지, B를 j번 문자까지 고려했을 때 최장 공통 부분 수열의 길이
        int[][] dp = new int[ALen][BLen];

        for (int i = 0; i < ALen; i++) {
            if (A[i] == B[0]) {
                dp[i][0] = 1;
            }
        }

        for (int j = 0; j < BLen; j++) {
            if (A[0] == B[j]) {
                dp[0][j] = 1;
            }
        }
        // end dp init

        for (int i = 1; i < ALen; i++) {
            for (int j = 1; j < BLen; j++) {
                dp[i][j] = dp[i - 1][j - 1];
                if (A[i] == B[j]) {
                    dp[i][j]++;
                } 
                dp[i][j] = Math.max(dp[i][j], Math.max(dp[i - 1][j], dp[i][j - 1]));
            }
        }
        System.out.println(dp[ALen - 1][BLen - 1]);
    }
}