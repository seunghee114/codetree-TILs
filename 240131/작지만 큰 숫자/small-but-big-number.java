import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inArr = br.readLine().split(" ");
        int N = Integer.parseInt(inArr[0]);
        int M = Integer.parseInt(inArr[1]);
        TreeSet<Integer> set = new TreeSet<>();
        inArr = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            set.add(Integer.parseInt(inArr[i]));
        }
        inArr = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(inArr[i]);
            Integer floor = set.floor(num);
            if (floor == null) {
                System.out.println(-1);
            } else {
                set.remove(floor);
                System.out.println(floor);
            }
        }

    }
}