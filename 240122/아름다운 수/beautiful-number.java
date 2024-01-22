import java.util.*;
import java.io.*;
public class Main {
    static int N, Total;
    static int[] select;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        select = new int[N];
        Total = 0;
        permutation(0);
        System.out.println(Total);
    }
    static void permutation(int cnt){
        if(cnt == N){
            Total++;
            return;
        }
        for(int i = 1; i < 5; i++){
            if (cnt + i <= N){
                for(int j = 0; j < i; j++){
                    select[cnt + j] = i;
                }
                permutation(cnt + i);
            }
        }
    }
}