import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        TreeMap<String, Integer> treeMap = new TreeMap<>();     // key : 단어, value : 단어 등장 횟수
        for (int i = 0; i < N; i++) {
            String key = br.readLine();
            int temp = treeMap.getOrDefault(key, 0);
            treeMap.put(key, temp + 1);
        }

        StringBuilder sb = new StringBuilder();
        for (String s : treeMap.keySet()) {
            sb.append(s).append(" ").append(treeMap.get(s)).append("\n");
        }
        System.out.println(sb);
    }
}