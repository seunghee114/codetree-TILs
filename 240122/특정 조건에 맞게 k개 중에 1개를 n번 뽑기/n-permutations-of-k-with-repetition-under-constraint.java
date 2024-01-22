import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int K, N;
    static int[] select;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inArr = br.readLine().split(" ");
        K = Integer.parseInt(inArr[0]);
        N = Integer.parseInt(inArr[1]);
        select = new int[N];
        sb = new StringBuilder();
        permutation(0);
        System.out.println(sb);
    }

    static void permutation(int cnt) {
        if (cnt == N) {
            for (int i = 0; i < N; i++) {
                sb.append(select[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int n = 1; n <= K; n++) {
            if (cnt == 0 || cnt == 1) {     // 인덱스 0이나 1일때는 그냥 넣기
                select[cnt] = n;
                permutation(cnt + 1);
                continue;
            }
            // 3번 연속 같은 숫자면 안되기 때문에 cnt가 2 이상일 때는 확인
            if (select[cnt - 2] != n || select[cnt - 1] != n) {
                select[cnt] = n;
                permutation(cnt + 1);
            }
        }
    }
}