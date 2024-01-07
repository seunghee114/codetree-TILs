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
        }   // end input

        int sum = 1;
        int start = PQ.poll()[0];
        int answer = 0;
        boolean chk = true;
        while(!PQ.isEmpty()){
            int[] pop = PQ.poll();
            sum += pop[1];
            if(pop[1] == 1 && !chk){
                start = pop[0];
                chk = true;
            }
            if(sum == 0){   // 하나의 구간이 끝남
                answer = Math.max(answer, pop[0] - start);
                chk = false;
            }
        }
        System.out.println(answer);
    }
}