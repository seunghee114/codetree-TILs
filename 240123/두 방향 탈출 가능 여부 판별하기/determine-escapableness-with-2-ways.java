import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, M;
    static int[] di = {1, 0};
    static int[] dj = {0, 1};
    static boolean[][] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inArr = br.readLine().split(" ");
        N = Integer.parseInt(inArr[0]);
        M = Integer.parseInt(inArr[1]);
        visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            inArr = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                int temp = Integer.parseInt(inArr[j]);
                if (temp == 0) visit[i][j] = true; // 뱀이 있어서 못감
            }
        }
        // end input
        visit[0][0] = true;
        DFS(0, 0);
        System.out.println(visit[N-1][M-1] ? 1 : 0);
    }

    private static void DFS(int I, int J) {
        for (int k = 0; k < di.length; k++) {
            int ni = I + di[k];
            int nj = J + dj[k];
            if (inRange(ni, nj) && !visit[ni][nj]) {
                visit[ni][nj] = true;
                DFS(ni, nj);
            }
        }
    }

    private static boolean inRange(int ni, int nj) {
        return ni >= 0 && nj >= 0 && ni < N && nj < M;
    }
}