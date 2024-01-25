import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inArr = br.readLine().split(" ");
        int N = Integer.parseInt(inArr[0]);
        int M = Integer.parseInt(inArr[1]);
        inArr = br.readLine().split(" ");
        int[] coins = new int[N];
        int[] dp =new int[M+1];
        for(int i = 0; i < N; i++){
            coins[i] = Integer.parseInt(inArr[i]);
            if(coins[i] <= M)
                dp[coins[i]] = 1;
        }
        Arrays.sort(coins);
        // end input

        for(int price = 1; price <= M; price++){
            for(Integer coin : coins){
                int temp = price - coin;
                if(temp <= 0 || dp[temp] == 0) continue;
                dp[price] = Math.max(dp[price], dp[temp]+1);
            }
        }
        System.out.println(dp[M] != 0 ? dp[M] : -1);
    }
}