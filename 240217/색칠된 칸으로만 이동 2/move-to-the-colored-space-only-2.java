import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {
    static int N, M, Answer, Cnt;
    static int[][] Number;
    static int[] pnt;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};
    static boolean[][] isColored;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inArr = br.readLine().split(" ");
        N = Integer.parseInt(inArr[0]);
        M = Integer.parseInt(inArr[1]);
        Number = new int[N][M];
        for (int i = 0; i < N; i++) {
            inArr = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                Number[i][j] = Integer.parseInt(inArr[j]);
            }
        }
        Cnt = 0;
        pnt = null;
        isColored = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            inArr = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                if (inArr[j].equals("1")) {
                    isColored[i][j] = true;
                    if (pnt == null) {
                        pnt = new int[]{i, j};
                    }
                    Cnt++;
                }
            }
        }
        // end input
        System.out.println(coloring());
    }
    private static int coloring() {
        Queue<int[]> Q = new ArrayDeque<>();
        // visit[i][j] : (i, j)에 올 때, 최소 차이
        int[][] visit = new int[N][M];  
        for (int i = 0; i < N; i++) {
            Arrays.fill(visit[i], Integer.MAX_VALUE);
        }
        Q.add(pnt);
        visit[pnt[0]][pnt[1]] = 0;

        while (!Q.isEmpty()) {
            int[] poll = Q.poll();
            for (int k = 0; k < 4; k++) {
                int ni = poll[0] + di[k];
                int nj = poll[1] + dj[k];
                // 범위 벗어나면 안됨
                if (ni < 0 || nj < 0 || ni >= N || nj >= M) continue;
                int d = Math.abs(Number[poll[0]][poll[1]] - Number[ni][nj]);
                // 이미 적거나 같 차이로 왔었으면 볼 필요 없음
                if (visit[ni][nj] <= d) continue;
                Q.add(new int[]{ni, nj});
                visit[ni][nj] = d;
            }
        }
        return maxValue(visit);
    }

    // 각 좌표마다 최소 차이를 구한 배열 = visit에서 가장 큰 값을 반환
    static int maxValue(int[][] visit) {
        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (isColored[i][j]) {
                    answer = Math.max(answer, visit[i][j]);
                }
            }
        }
        return answer;
    }
}