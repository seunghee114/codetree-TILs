import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inArr = br.readLine().split(" ");
        int sizeA = Integer.parseInt(inArr[0]);
        int sizeB = Integer.parseInt(inArr[1]);

        inArr = br.readLine().split(" ");
        HashSet<Integer> A = init(sizeA, inArr);
        inArr = br.readLine().split(" ");
        HashSet<Integer> B = init(sizeB, inArr);
        // end input

        List<Integer> differenceA = A.stream().filter(a -> !B.contains(a)).collect(Collectors.toList());
        List<Integer> differenceB = B.stream().filter(b -> !A.contains(b)).collect(Collectors.toList());
        Set<Integer> answer = new HashSet<>(differenceA);
        answer.addAll(differenceB);
        System.out.println(answer.size());
    }

    static HashSet<Integer> init(int size, String[] inArr) {
        HashSet<Integer> a = new HashSet<>();
        for (int i = 0; i < size; i++) {
            a.add(Integer.parseInt(inArr[i]));
        }
        return a;
    }
}