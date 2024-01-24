import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static int N, M;
    static boolean[][] Visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inArr = br.readLine().split(" ");
        N = Integer.parseInt(inArr[0]);
        M = Integer.parseInt(inArr[1]);
        Visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            inArr = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                if (Integer.parseInt(inArr[j]) == 0) {  // 뱀이 있는 경우 갈 수 없음
                    Visit[i][j] = true;
                }
            }
        }
        // end input
        System.out.println(BFS());
    }

    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};
    static int BFS() {
        Queue<int[]> Q = new ArrayDeque<>();
        Visit[0][0] = true;
        Q.add(new int[]{0, 0, 0});  // x좌표, y좌표, 거리

        while (!Q.isEmpty()) {
            int[] poll = Q.poll();
            for (int k = 0; k < di.length; k++) {
                int ni = poll[0] + di[k];
                int nj = poll[1] + dj[k];
                if (notRange(ni, nj) || Visit[ni][nj]) continue;
                if (ni == N-1 && nj == M-1) return poll[2] + 1;
                Visit[ni][nj] = true;
                Q.add(new int[]{ni, nj, poll[2] + 1});
            }
        }
        return -1;
    }

    static boolean notRange(int i, int j) {
        return i < 0 || j < 0 || i >= N || j >= M;
    }
}