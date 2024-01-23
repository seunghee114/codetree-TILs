import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static int N, K;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};
    static int[][] Board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inArr = br.readLine().split(" ");
        N = Integer.parseInt(inArr[0]);
        K = Integer.parseInt(inArr[1]);
        Board = new int[N][N];
        for (int i = 0; i < N; i++) {
            inArr = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                Board[i][j] = Integer.parseInt(inArr[j]);
            }
        }
        inArr = br.readLine().split(" ");
        int[] pnt = {Integer.parseInt(inArr[0]) - 1, Integer.parseInt(inArr[1]) - 1};
        for (int k = 0; k < K; k++) {
            pnt = BFS(pnt, Board[pnt[0]][pnt[1]]);
        }
        System.out.printf("%d %d\n", pnt[0] + 1, pnt[1] + 1);
    }

    static int[] BFS(int[] pnt, int standard) {
        Queue<int[]> Q = new ArrayDeque<>();
        boolean[][] visit = new boolean[N][N];
        int[] answer = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};  // 숫자, x좌표, y좌표

        visit[pnt[0]][pnt[1]] = true;
        Q.add(pnt);
        while (!Q.isEmpty()) {
            int[] poll = Q.poll();
            for (int k = 0; k < 4; k++) {
                int ni = poll[0] + di[k];
                int nj = poll[1] + dj[k];
                if (notRange(ni, nj) || visit[ni][nj] || Board[ni][nj] >= standard) continue;
                answer = compareAnswer(answer, new int[]{Board[ni][nj], ni, nj});
                visit[ni][nj] = true;
                Q.add(new int[]{ni, nj});
            }
        }
        return answer[0] != Integer.MIN_VALUE ? new int[]{answer[1], answer[2]} : pnt;
    }

    static int[] compareAnswer(int[] a, int[] b) {
        if (a[0] > b[0]) return a;
        if (a[0] < b[0]) return b;
        if (a[1] > b[1]) return b;
        if (a[1] < b[1]) return a;
        if (a[2] > b[2]) return b;
        return a;
    }

    static boolean notRange(int i, int j) {
        return i < 0 || j < 0 || i >= N || j >= N;
    }
}