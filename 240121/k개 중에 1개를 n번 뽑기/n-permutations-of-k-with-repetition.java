import java.util.*;
import java.io.*;
public class Main {
    static int N, K;
    static StringBuilder sb;
    static int[] select;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inArr = br.readLine().split(" ");
        K = Integer.parseInt(inArr[0]);
        N = Integer.parseInt(inArr[1]);
        select = new int[N];
        sb = new StringBuilder();
        permutation(0);
        System.out.println(sb);
    }
    static void permutation(int cnt){
        if(cnt == N){
            for(int i = 0; i < N; i++){
                sb.append(select[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = 1; i <= K; i++){
            select[cnt] = i;
            permutation(cnt+1);
        }
    }
}