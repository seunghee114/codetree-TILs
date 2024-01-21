import java.util.*;
import java.io.*;
public class Main {
    static int N, M, T;
    static int[][] number;
    static HashMap<ArrayList<Integer>, Integer> map;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inArr = br.readLine().split(" ");
        N = Integer.parseInt(inArr[0]);
        M = Integer.parseInt(inArr[1]);
        T = Integer.parseInt(inArr[2]);
        number = new int[N][N];
        for(int i = 0; i < N; i++){
            inArr = br.readLine().split(" ");
            for(int j = 0; j < N; j++){
                number[i][j] = Integer.parseInt(inArr[j]);
            }
        } // end input

        // key : 좌표, value : 해당 좌표에 있는 구슬의 개수
        map = new HashMap<>();
        for(int i = 0; i < M; i++){
            inArr = br.readLine().split(" ");
            int a = Integer.parseInt(inArr[0])-1;
            int b = Integer.parseInt(inArr[1])-1;
            ArrayList<Integer> temp = getList(a, b);
            map.put(temp, 1);
        }
        // end input
        for(int t = 0; t < T; t++){
            move(bomb());
        }
        ArrayList<ArrayList<Integer>> list = bomb();
        System.out.println(list.size());
    }

    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};
    // list에 있는 구슬을 움직인다.
    static void move(ArrayList<ArrayList<Integer>> list){
        map = new HashMap<>();
        for(ArrayList<Integer> bead : list){
            ArrayList<Integer> pnt = beadMove(bead);
            map.put(pnt, map.getOrDefault(pnt, 0) + 1);
        }
    }
    // a와 b를 ArrayList 원소로 하는 ArrayList 반환
    // HashMap에서 key로 배열을 사용할 수 없음. why? 배열이 같은지 확인할 때, 참조값을 확인하기 때문
    static ArrayList<Integer> getList(int a, int b){
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(a);
        temp.add(b);
        return temp;
    }
    // 구슬 한 개 움직이기
    static ArrayList<Integer> beadMove(ArrayList<Integer> bead){
        int chk = -1;
        ArrayList<Integer> pnt = getList(-1, -1);
        for(int k = 0; k < 4; k++){
            int ni = bead.get(0) + di[k];
            int nj = bead.get(1) + dj[k];
            if(ni < 0 || nj < 0 || ni >= N || nj >= N) continue;
            if(number[ni][nj] > chk){
                chk = number[ni][nj];
                pnt = getList(ni, nj);
            }
        }
        return pnt;
    }
    // 구슬을 모두 움직인 다음에 같은 위치에 있는 구슬을 없애기
    static ArrayList<ArrayList<Integer>> bomb(){
        ArrayList<ArrayList<Integer>> list = new ArrayList();
        for(ArrayList<Integer> bead : map.keySet()){
            if(map.get(bead) > 1){
                continue;
            }
            list.add(bead);
        }
        return list;
    }
}