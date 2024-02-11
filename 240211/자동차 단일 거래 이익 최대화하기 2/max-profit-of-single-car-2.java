import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] prices = new long[N];
        String[] inArr = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            prices[i] = Long.parseLong(inArr[i]);
        }
        // end input

        long answer = 0;
        long minPrice = prices[0];
        for (int i = 1; i < N; i++) {
            // minPrice에 사서 prices[i]에 팔기
            answer = Math.max(answer, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        System.out.println(answer);
    }
}