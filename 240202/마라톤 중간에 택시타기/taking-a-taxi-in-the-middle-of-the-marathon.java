import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] points = new int[N][2];
        for (int i = 0; i < N; i++) {
            String[] inArr = br.readLine().split(" ");
            int x = Integer.parseInt(inArr[0]);
            int y = Integer.parseInt(inArr[1]);
            points[i][0] = x;
            points[i][1] = y;
        }
        // end input
        int[] left = new int[N];        // left[i] : 왼쪽부터 i번까지 거리
        for (int i = 1; i < N; i++) {
            left[i] = left[i - 1] + distance(points, i, i - 1);
        }
        int[] right = new int[N];       // right[i] : 오른쪽부터 i번까지 거리
        for (int i = N - 2; i >= 0; i--) {
            right[i] = right[i+1] +  distance(points, i, i+1);
        }

        int answer = Integer.MAX_VALUE;
        // i번 체크 포인트를 건너뛸거야
        for (int i = 1; i < N - 1; i++) {
            int temp = left[i - 1] + right[i + 1];
            temp += distance(points, i - 1, i + 1);
            answer = Math.min(answer, temp);
        }
        System.out.println(answer);
    }

    static int distance(int[][] points, int a, int b) {
        return Math.abs(points[a][0] - points[b][0]) + Math.abs(points[a][1] - points[b][1]);
    }
}