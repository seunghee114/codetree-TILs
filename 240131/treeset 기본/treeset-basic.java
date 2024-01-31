import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < N; i++) {
            String[] inArr = br.readLine().split(" ");
            switch (inArr[0]) {
                case "add":
                    set.add(Integer.parseInt(inArr[1]));
                    break;
                case "remove":
                    set.remove(Integer.parseInt(inArr[1]));
                    break;
                case "find":
                    System.out.println(set.contains(Integer.parseInt(inArr[1])));
                    break;
                case "lower_bound":
                    Integer ceiling = set.ceiling(Integer.parseInt(inArr[1]));
                    System.out.println(ceiling != null ? ceiling : "None");
                    break;
                case "upper_bound":
                    Integer higher = set.higher(Integer.parseInt(inArr[1]));
                    System.out.println(higher != null ? higher : "None");
                    break;
                case "largest":
                    System.out.println(set.isEmpty() ? "None" : set.last());
                    break;
                case "smallest":
                    System.out.println(set.isEmpty() ? "None" : set.first());
                    break;
            }
        }
    }
}