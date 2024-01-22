import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, M;
    static int[] select;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inArr = br.readLine().split(" ");
        N = Integer.parseInt(inArr[0]);
        M = Integer.parseInt(inArr[1]);
        select = new int[M];
        sb = new StringBuilder();
        combination(1, 0);
        System.out.println(sb);
    }

    static void combination(int idx, int cnt) {
        if (cnt == M) {
            for (int i = 0; i < M; i++) {
                sb.append(select[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = idx; i < N + 1; i++) {
            select[cnt] = i;
            combination(i + 1, cnt + 1);
        }
    }
}