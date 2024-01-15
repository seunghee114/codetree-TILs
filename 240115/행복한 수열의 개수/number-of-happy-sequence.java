import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inArr = br.readLine().split(" ");
        int N = Integer.parseInt(inArr[0]);
        int M = Integer.parseInt(inArr[1]);
        int[][] number = new int[N][N];
        for(int i = 0; i < N; i++){
            inArr = br.readLine().split(" ");
            for(int j = 0; j < N; j++){
                number[i][j] = Integer.parseInt(inArr[j]);
            }
        } // end input
        int answer = 0;
        // 행 체크
        for(int i = 0; i < N; i++){
            if(check(M, number[i])) answer++;
            int[] temp = new int[N];
            for(int j = 0; j < N; j++){
                temp[j] = number[j][i];
            }
            if(check(M, temp)) answer++;
        }
        System.out.println(answer);
    }
    static boolean check(int M, int[] arr){
        int prev = arr[0];
        int cnt = 1;
        for(int i = 1; i < arr.length; i++){
            if(prev == arr[i]){
                cnt++;
            }else{
                if(cnt >= M) return true;
                prev = arr[i];
                cnt = 1;
            }
        }
        if(cnt >= M) return true;
        return false;
    }
}