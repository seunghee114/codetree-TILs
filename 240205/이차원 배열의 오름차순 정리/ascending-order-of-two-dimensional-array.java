import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        long K = Long.parseLong(br.readLine());
        long start = 1;
        long end = N * N;
        long answer = N * N;
        while (start <= end) {
            long mid = (start + end) / 2;
            long acc = 0;
            for (int i = 1; i <= N; i++) {
                acc += Math.min(N, mid / i);
            }
            if (acc >= K) {
                end = mid - 1;
                answer = Math.min(answer, mid);
            } else {
                start = mid + 1;
            }
        }
        System.out.println(answer);
    }
}