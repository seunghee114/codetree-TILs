import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    static int N, T, Answer;
    static int[] time;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inArr = br.readLine().split(" ");
        N = Integer.parseInt(inArr[0]);
        T = Integer.parseInt(inArr[1]);
        time = new int[N];
        for (int i = 0; i < N; i++) {
            time[i] = Integer.parseInt(br.readLine());
        }
        // end input
        Answer = Integer.MAX_VALUE;
        binarySearch();
        System.out.println(Answer != Integer.MAX_VALUE ? Answer : 0);
    }

    static void binarySearch() {
        int start = 1;
        int end = N;
        while (start <= end) {
            int mid = (start + end) / 2;
            int total = mid >= N ? maxTime() : onStage(mid);
            
            if (total <= T) {   // 무대에 더 적은 애들을 올려보자
                Answer = Math.min(Answer, mid);
                end = mid - 1;
            } else {    // total > T -> 무대에 더 많은 애들을 올려야 함
                start = mid + 1;
            }
        }
    }
    static int maxTime() {
        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, time[i]);
        }
        return max;
    }

    static int onStage(int K) {
        int t = 0;
        PriorityQueue<Integer> stage = new PriorityQueue<>();   // 무대에 올라가 있는 사람들이 내려와야 하는 시간
        int idx = 0;
        for (idx = 0; idx < K; idx++) {
            stage.add(time[idx]);
        }
        while (!stage.isEmpty()) {
            t = stage.poll();
            if (idx < N) {
                stage.add(t + time[idx++]);
            }
        }
        return t;
    }
}