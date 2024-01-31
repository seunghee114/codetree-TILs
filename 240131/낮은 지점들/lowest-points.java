import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, Integer> pnts = new HashMap<>();   // key : x, value : y
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String[] inArr = br.readLine().split(" ");
            int x = Integer.parseInt(inArr[0]);
            int y = Integer.parseInt(inArr[1]);
            int temp = pnts.getOrDefault(x, Integer.MAX_VALUE);
            pnts.put(x, Math.min(temp, y));
        }
        int answer = 0;
        for (Integer value : pnts.values()) {
            answer += value;
        }
        System.out.println(answer);
    }
}