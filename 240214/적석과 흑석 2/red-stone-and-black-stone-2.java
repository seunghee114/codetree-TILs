import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inArr = br.readLine().split(" ");
        int R = Integer.parseInt(inArr[0]); // R : 빨간 돌의 개수
        int B = Integer.parseInt(inArr[1]); // B : 검정 돌의 개수

        PriorityQueue<Integer> red = new PriorityQueue<>(); // red : 빨간 돌에 적혀 있는 숫자를 오름차순으로
        // black : 검정 돌에 적혀 있는 A를 기준으로 먼저 오름차순, A가 같으면 B를 기준으로 오름차순
        PriorityQueue<int[]> black = new PriorityQueue<>((o1, o2) -> {
            if (Integer.compare(o1[0], o2[0]) == 0) return Integer.compare(o1[1], o2[1]);
            return Integer.compare(o1[0], o2[0]);
        });
        for (int i = 0; i < R; i++) {
            red.add(Integer.parseInt(br.readLine()));
        }
        for (int j = 0; j < B; j++) {
            inArr = br.readLine().split(" ");
            black.add(new int[]{Integer.parseInt(inArr[0]), Integer.parseInt(inArr[1])});
        }
        // end input

        int cnt = 0;
        while (red.size() > 0 && black.size() > 0) {
            int r = red.peek();
            int[] b = black.peek();
            if (b[0] <= r && r <= b[1]) {   // 빨강 돌과 검정 돌 쌍 만들기
                red.poll();
                black.poll();
                cnt++;
                continue;
            }
            if (r < b[0]) {     // 빨강 돌이 검정 돌 A보다 작으면 
                red.poll();
            }else{              // 빨강 돌이 검정돌 B보다 크면
                black.poll();
            }

        }
        System.out.println(cnt);
    }
}