import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static int N;
    static int[] di = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dj = {-2, -1, 1, 2, 2, 1, -1, -2};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String[] inArr = br.readLine().split(" ");
        int[] start = {Integer.parseInt(inArr[0]) - 1, Integer.parseInt(inArr[1]) - 1};
        int[] end = {Integer.parseInt(inArr[2]) - 1, Integer.parseInt(inArr[3]) - 1};
        // end input
        System.out.println(BFS(start, end));
    }

    static int BFS(int[] start, int[] end) {
        boolean[][] visit = new boolean[N][N];
        Queue<int[]> Q = new ArrayDeque<>();
        visit[start[0]][start[1]] = true;
        Q.add(new int[]{start[0], start[1], 0});
        while (!Q.isEmpty()) {
            int[] poll = Q.poll();
            for (int k = 0; k < di.length; k++) {
                int ni = poll[0] + di[k];
                int nj = poll[1] + dj[k];
                if (notRange(ni, nj) || visit[ni][nj]) continue;
                if (ni == end[0] && nj == end[1]) return poll[2] + 1;
                visit[ni][nj] = true;
                Q.add(new int[]{ni, nj, poll[2] + 1});
            }
        }
        return -1;
    }

    static boolean notRange(int i, int j) {
        return i < 0 || j < 0 || i >= N || j >= N;
    }
}