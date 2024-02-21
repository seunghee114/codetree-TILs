import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String initStr = br.readLine();
        String goalStr = br.readLine();
        // end input

        boolean[] isSame = new boolean[N];
        for (int i = 0; i < N; i++) {
            if (initStr.charAt(i) == goalStr.charAt(i)) {
                isSame[i] = true;
            }
        }

        boolean prev = isSame[0];
        int cnt = prev ? 0 : 1;        // isSame이 false인 구간의 개수

        for (int i = 1; i < N; i++) {
            if (prev == isSame[i]) continue;
            if (prev) {
                cnt++;
            }
            prev = isSame[i];
        }
        System.out.println(cnt);
    }
}