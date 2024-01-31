import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> PQ = new PriorityQueue<>();
        String[] inArr = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(inArr[i]);
            PQ.add(num);
            if (PQ.size() < 3) {
                sb.append("-1").append("\n");
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                long answer = 1;
                for (int j = 0; j < 3; j++) {
                    answer *= PQ.peek();
                    list.add(PQ.poll());
                }
                for (int j = 0; j < 3; j++) {
                    PQ.add(list.get(j));
                }
                sb.append(answer).append("\n");
            }
        }
        System.out.println(sb);
    }
}