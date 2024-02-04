import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inArr = br.readLine().split(" ");
        int N = Integer.parseInt(inArr[0]);
        int M = Integer.parseInt(inArr[1]);

        int[] points = new int[N];
        inArr = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            points[i] = Integer.parseInt(inArr[i]);
        }
        Arrays.sort(points);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            inArr = br.readLine().split(" ");
            int s = Integer.parseInt(inArr[0]);
            int e = Integer.parseInt(inArr[1]);
            int sidx = smallThing(points, s);
            int eidx = largeThing(points, e);
            sb.append(eidx - sidx).append("\n");
        }
        System.out.println(sb);
    }

    // points 에서 x가 들어갈 자리
    // x보다 작은 거 중에서 제일 큰 숫자 뒤에 들어가야 함
    static int smallThing(int[] points, int x) {
        int start = 0;
        int end = points.length - 1;
        int idx = 0;
        while (start <= end && end < points.length) {
            int mid = (start + end) / 2;
            if (points[mid] >= x) {
                end = mid - 1;
            } else {
                start = mid + 1;
                idx = mid + 1;
            }
        }
        return idx;
    }

    // points 에서 x가 들어갈 자리
    // x보다 큰 거 중에서 제일 작은 숫자 자리에 들어가야 함
    static int largeThing(int[] points, int x) {
        int start = 0;
        int end = points.length - 1;
        int idx = points.length;
        while (start <= end && end < points.length) {
            int mid = (start + end) / 2;
            if (points[mid] <= x) {
                start = mid + 1;
            } else {
                end = mid - 1;
                idx = mid;
            }
        }
        return idx;
    }
}