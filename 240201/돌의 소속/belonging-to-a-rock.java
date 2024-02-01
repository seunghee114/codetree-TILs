import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inArr = br.readLine().split(" ");
        int N = Integer.parseInt(inArr[0]);
        int Q = Integer.parseInt(inArr[1]);
        int[] number = new int[N + 1];
        for (int i = 0; i < N; i++) {
            number[i + 1] = Integer.parseInt(br.readLine());
        }
        // prefix[i][j] : i번 돌 인덱스까지 j번 그룹의 총 개수
        int[][] prefix = new int[N + 1][4];
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < 4; j++) {
                prefix[i][j] = prefix[i - 1][j];
            }
            prefix[i][number[i]]++;
        }
                
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            inArr = br.readLine().split(" ");
            int start = Integer.parseInt(inArr[0]);
            int end = Integer.parseInt(inArr[1]);
            for (int j = 1; j < 4; j++) {
                sb.append(prefix[end][j] - prefix[start - 1][j]).append(" ");
            }
            sb.append("\n");
        }
        
        System.out.println(sb);
    }
}