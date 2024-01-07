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
            PQ.add(new int[]{a, 1, i});
            PQ.add(new int[]{b, -1, i});
        }
        PriorityQueue<Integer> candidate = new PriorityQueue<>();
        int idx = 1;
        candidate.add(idx++);
        int[] answer = new int[N];
        while(!PQ.isEmpty()){
            int[] pop = PQ.poll();
            if(pop[1] == 1){    // 시작점
                answer[pop[2]] = candidate.poll();
                if(candidate.isEmpty()) candidate.add(idx++);
            }else if(pop[1] == -1){ // 끝점
                candidate.add(answer[pop[2]]);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb);
    }
}