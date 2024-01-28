import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inArr = br.readLine().split(" ");
        int N = Integer.parseInt(inArr[0]);
        int M = Integer.parseInt(inArr[1]);
        int[][] clothes = new int[N][3];    // clothes[i] : {시작 날짜, 끝 날짜, 화려함}
        for (int i = 0; i < N; i++) {
            inArr = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                clothes[i][j] = Integer.parseInt(inArr[j]);
            }
        } // end input

        // dp[i][j] : i일에 j번 옷을 입었을 때 최대 만족도
        int[][] dp = new int[M + 1][N];
        for (int i = 1; i < M + 1; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }
        for (int j = 0; j < N; j++) {
            if (clothes[j][0] <= 1 && 1 <= clothes[j][1]) {
                dp[1][j] = 0;
            }
        }

        for (int i = 2; i < M + 1; i++) {
            for (int j = 0; j < N; j++) {
                // j번 옷을 i일에 입을 수 있으면
                if (clothes[j][0] <= i && i <= clothes[j][1]) {
                    int temp = Integer.MIN_VALUE;
                    for (int a = 0; a < N; a++) {   // i-1일에 입은 경우의 수 중 만족도가 가장 높은 거
                        if (dp[i-1][a] == Integer.MIN_VALUE) continue;
                        int point = dp[i - 1][a] + Math.abs(clothes[a][2] - clothes[j][2]);
                        temp = Math.max(temp, point);
                    }
                    dp[i][j] = temp;
                }
            }
        }

        int answer = Integer.MIN_VALUE;
        for (int j = 0; j < N; j++) {
            if (dp[M][j] == Integer.MIN_VALUE) continue;
            answer = Math.max(dp[M][j], answer);
        }
        System.out.println(answer);
    }
}