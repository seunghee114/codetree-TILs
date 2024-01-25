import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inArr = br.readLine().split(" ");
        int N = Integer.parseInt(inArr[0]);
        int M = Integer.parseInt(inArr[1]);
        int[] coins = new int[N];
        inArr = br.readLine().split(" ");
        for(int i = 0; i < N; i++){
            coins[i] = Integer.parseInt(inArr[i]);
        }
        // end input

        int[] dp = new int[M+1];    // dp[i] : i 금액을 만들기 위해 필요한 동전의 최소 개수
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;
        for(int price = 1; price <= M; price++){
            for(Integer coin : coins){
                int temp = price - coin;    // coin 동전을 쓰기 전에 만들었던 금액
                if(temp < 0) continue;      // 0보다 작으면 안돼
                temp = dp[temp] + 1;        // temp 금액을 만들었을 때 사용한 동전 개수에 coin 동전 1개 추가 
                dp[price] = Math.min(dp[price], temp); 
            }
        }
        System.out.println(dp[M] != Integer.MAX_VALUE ? dp[M] : -1);
    }
}