import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inArr = br.readLine().split(" ");
        int N = Integer.parseInt(inArr[0]);
        int M = Integer.parseInt(inArr[1]);
        inArr = br.readLine().split(" ");
        int[] number = new int[N];
        for (int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(inArr[i]);
        }
        StringBuilder sb = new StringBuilder();
        inArr = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            int x = Integer.parseInt(inArr[i]);
            sb.append(binarySearch(number, x)).append("\n");
        }
        System.out.println(sb);
    }

    static int binarySearch(int[] number, int x) {
        int answer = -1;

        int start = 0;
        int end = number.length - 1;
        while (start <= end && end < number.length) {
            int mid = (start + end) / 2;
            if (number[mid] == x) {
                end = mid - 1;
                answer = mid + 1;
            } else if (number[mid] > x) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return answer;
    }
}