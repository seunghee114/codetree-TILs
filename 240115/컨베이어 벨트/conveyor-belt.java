import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static int[] Number;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inArr = br.readLine().split(" ");
        N = Integer.parseInt(inArr[0]);
        int T = Integer.parseInt(inArr[1]);
        Number = new int[N*2];
        for(int i = 0; i < 2; i++){
            inArr = br.readLine().split(" ");
            for(int j = 0; j < N; j++){
                Number[i * N + j] = Integer.parseInt(inArr[j]);
            }
        } // end input
        for(int t = 0; t < T; t++){
            rotate();
        }
        answer();
    }
    static void rotate(){
        int temp = Number[N*2-1];
        for(int i = N*2-2; i >= 0; i--){
            Number[i+1] = Number[i];
        }
        Number[0] = temp;
    }
    static void answer(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < N; j++){
                sb.append(Number[i * N + j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);    
    }
}