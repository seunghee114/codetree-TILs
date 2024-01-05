import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> PQ = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[0], o2[0]));
        for(int i = 0; i < N; i++){
            String[] inArr = br.readLine().split(" ");
            int a = Integer.parseInt(inArr[0]);
            int b = Integer.parseInt(inArr[1]);
            PQ.add(new int[]{a, 1});
            PQ.add(new int[]{b, -1});
        }
        int answer = 0;
        int acc = 0;
        while(!PQ.isEmpty()){
            int[] pop = PQ.poll();
            if(pop[1] == 1){    // 시작점인 경우
                acc++;
            }else{      // 끝점인 경우
                acc--;
                // 시작점으로 들어오는 선분의 끝점이 모두 들어온 경우 -> 하나의 선분이 끝났다.
                if(acc == 0) answer++;  
            }
        }
        System.out.println(answer);
    }
}