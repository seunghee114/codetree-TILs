import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[Math.max(N + 1, 6)];
        int[] nums = {1, 2, 5};
        for(Integer num : nums){
            dp[num] = 1;
        }
        for(int i = 1; i <= N; i++){
            for(Integer num : nums){
                int temp = i - num;
                if(temp < 0) continue;
                dp[i] = (dp[temp] + dp[i]) % 10007;
            }
        }
        System.out.println(dp[N]);
    }
}