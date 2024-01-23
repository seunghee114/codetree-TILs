import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static int N, M, Answer;
    static ArrayList<Integer>[] adj;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inArr = br.readLine().split(" ");
        N = Integer.parseInt(inArr[0]);
        M = Integer.parseInt(inArr[1]);
        adj = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            inArr = br.readLine().split(" ");
            int a = Integer.parseInt(inArr[0])-1;
            int b = Integer.parseInt(inArr[1])-1;
            adj[a].add(b);
            adj[b].add(a);
        }
        // end input
        visit = new boolean[N];
        visit[0] = true;
        Answer = 0;
        DFS(0);
        System.out.println(Answer);
    }
    static void DFS(int curr) {
        for (int i = 0; i < adj[curr].size(); i++) {
            int n = adj[curr].get(i);
            if (visit[n]) continue;
            visit[n] = true;
            Answer++;
            DFS(n);
        }
    }
}