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
        // end input
        int acc = 1;            // acc : 현재 누적되고 있는 선분의 수
        int answer = 0;         // answer : 총 구간의 합
        int start = PQ.poll()[0];          // start : 현재 만들어지고 있는 구간의 시작
        boolean chk = true;    // chk : 구간이 시작 됬는지

        while(!PQ.isEmpty()){
            int[] pop = PQ.poll();
            acc += pop[1];
            if(pop[1] == 1){    // 시작 지점이고 
                if(!chk){       // 구간이 시작되지 않았다면
                    start = pop[0];
                    chk = true;
                }
            }
            if(acc == 0){   // 하나의 구간이 다 만들어짐
                answer += (pop[0] - start);
                chk = false;
            }
        }
        System.out.println(answer);
    }
}