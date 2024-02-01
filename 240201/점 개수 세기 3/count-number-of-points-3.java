import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inArr = br.readLine().split(" ");
        int N = Integer.parseInt(inArr[0]);
        int Q = Integer.parseInt(inArr[1]);
        PriorityQueue<Integer> PQ = new PriorityQueue<>();
        inArr = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            PQ.add(Integer.parseInt(inArr[i]));
        }

        // key : 원래 좌표, value : 압축 좌표
        HashMap<Integer, Integer> mapper = gridCompression(PQ);
        
        int[] sum = prefixSum(mapper.size());
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            inArr = br.readLine().split(" ");
            int start = Integer.parseInt(inArr[0]);
            int end = Integer.parseInt(inArr[1]);
            start = mapper.get(start);
            end = mapper.get(end);
            sb.append(sum[end] - sum[start - 1]).append("\n");
        }
        System.out.println(sb);
    }

    static HashMap<Integer, Integer> gridCompression(PriorityQueue<Integer> PQ) {
        HashMap<Integer, Integer> mapper = new HashMap<>();
        int value = 1;
        while (!PQ.isEmpty()) {
            int key = PQ.poll();
            mapper.put(key, value++);
        }
        return mapper;
    }

    static int[] prefixSum(int len) {
        int[] sum = new int[len + 1];
        for (int i = 1; i < len + 1; i++) {
            sum[i] = sum[i - 1] + 1;
        }
        return sum;
    }
}