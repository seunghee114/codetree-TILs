import java.util.*;
import java.io.*;
public class Main {
    static class Tuple implements Comparable<Tuple>{
        int y, idx;
        public Tuple(int y, int idx){
            this.y = y;
            this.idx = idx;
        }
        public int compareTo(Tuple oth){
            return Integer.compare(this.y, oth.y);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> PQ = new PriorityQueue<>(
            (o1, o2) -> Integer.compare(o1[0], o2[0]));
        for(int i = 0; i < N; i++){
            String[] inArr = br.readLine().split(" ");
            int y = Integer.parseInt(inArr[0]);
            int x1 = Integer.parseInt(inArr[1]);
            int x2 = Integer.parseInt(inArr[2]);
            PQ.add(new int[]{x1, 1, y, i});
            PQ.add(new int[]{x2, -1, y, i});
        }   // end input

        TreeSet<Tuple> set = new TreeSet<>();
        boolean[] answer = new boolean[N];
        while(!PQ.isEmpty()){
            int[] pop = PQ.poll();
            if(pop[1] == 1){    // 시작점
                set.add(new Tuple(pop[2], pop[3]));
            }else if(pop[1] == -1){     // 끝점
                set.remove(new Tuple(pop[2], pop[3]));
            }
            if(set.isEmpty()) continue;
            answer[set.first().idx] = true;
        }
        int cnt = 0;
        for(int i = 0; i < N; i++){
            if(answer[i]) cnt++;
        }
        System.out.println(cnt);
    }
}