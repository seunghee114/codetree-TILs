import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static boolean[][] Visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Visit = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String[] inArr = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                if (Integer.parseInt(inArr[j]) == 0) {
                    Visit[i][j] = true;
                }
            }
        }
        // end input
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (Visit[i][j]) continue;
                answer.add(Math.max(DFS(i, j), 1));
            }
        }
        System.out.println(answer.size());
        Collections.sort(answer);
        for (Integer integer : answer) {
            System.out.println(integer);
        }
    }

    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};
    static int DFS(int I, int J) {
        int cnt = 0;
        for (int k = 0; k < 4; k++) {
            int ni = I + di[k];
            int nj = J + dj[k];
            if (notRange(ni, nj) || Visit[ni][nj]) continue;
            Visit[ni][nj] = true;
            cnt++;
            cnt+=DFS(ni, nj);
        }
        return cnt;
    }

    static boolean notRange(int I, int J) {
        return I < 0 || J < 0 || I >= N || J >= N;
    }
}