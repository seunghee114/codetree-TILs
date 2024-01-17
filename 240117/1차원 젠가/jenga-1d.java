import java.util.*;
import java.io.*;
public class Main {
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] number = new int[N];
        for(int i= 0; i < N; i++){
            number[i] = Integer.parseInt(br.readLine());
        } 
        int[][] op = new int[2][2];
        for(int i = 0; i < 2; i++){
            String[] inArr = br.readLine().split(" ");
            op[i][0] = Integer.parseInt(inArr[0])-1;
            op[i][1] = Integer.parseInt(inArr[1])-1;
        } // end input
        int NN = N;
        int[] answer = new int[N];
        for(int j = 0; j < 2; j++){
            NN = N - (op[j][1] - op[j][0] + 1);
            answer = new int[NN];
            int idx = 0;
            for(int i = 0; i < op[j][0]; i++){
                answer[idx++] = number[i];
            }
            for(int i = op[j][1]+1; i < N; i++){
                answer[idx++] = number[i];
            }
            N = NN;
            number = answer;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(number.length).append("\n");
        for(int n : number){
            sb.append(n).append("\n");
        }
        System.out.println(sb);
    }
}