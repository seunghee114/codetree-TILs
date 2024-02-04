import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] chars = br.readLine().toCharArray();
        // end input

        int[] cntC = new int[N];
        int[] cntW = new int[N];
        for (int i = 0; i < N; i++) {
            if (i != 0) {
                cntC[i] = cntC[i - 1];
            }
            if (chars[i] == 'C') {
                cntC[i]++;
            }
        }
        for (int i = N - 1; i >= 0; i--) {
            if (i != N - 1) {
                cntW[i] = cntW[i + 1];
            }
            if (chars[i] == 'W') {
                cntW[i]++;
            }
        }
        // end init

        long answer = 0;
        for (int i = 0; i < N; i++) {
            if (chars[i] != 'O') continue;
            answer += (cntC[i] * cntW[i]);
        }
        System.out.println(answer);
    }
}