import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[] number;
    static boolean[] isSelect;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        number = new int[N];
        isSelect = new boolean[N+1];
        sb = new StringBuilder();
        permutation(0);
        System.out.println(sb);
    }

    static void permutation(int cnt) {
        if (cnt == N) {
            for (int i = 0; i < N; i++) {
                sb.append(number[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (isSelect[i]) continue;
            number[cnt] = i;
            isSelect[i] = true;
            permutation(cnt + 1);
            isSelect[i] = false;
        }
    }
}