import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N;
    static int mp, mf, ms, mv;
    static final int SIZE = 5;
    static int[][] arr;
    static boolean[] select;
    static int minCost = Integer.MAX_VALUE;
    static List<Integer> list;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        mp = Integer.parseInt(st.nextToken());
        mf = Integer.parseInt(st.nextToken());
        ms = Integer.parseInt(st.nextToken());
        mv = Integer.parseInt(st.nextToken());

        arr = new int[N][SIZE];
        select = new boolean[N];
        list = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < SIZE; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, 0, 0, 0, 0);

        Collections.sort(list);

        sb = new StringBuilder();

        if(list.size() > 0) {
            sb.append(minCost).append("\n");
            for(int num : list) {
                sb.append(num + " ");
            }
        } else {
            sb.append(-1);
        }

        System.out.print(sb);
    }


    static void dfs(int depth, int sumP, int sumF, int sumS, int sumV, int sumCost) {

        if(sumCost > minCost) {
            return;
        }

        if(sumP >= mp && sumF >= mf && sumS >= ms && sumV >= mv && sumCost < minCost) {
            minCost = sumCost;

            list = new ArrayList<>();

            for(int i = 0; i < select.length; i++) {
                if(select[i]) {
                    list.add(i + 1);
                }
            }
        }

        if(depth >= N) {
            return;
        }

        select[depth] = true;
        dfs(depth + 1, sumP + arr[depth][0], sumF + arr[depth][1], sumS + arr[depth][2], sumV + arr[depth][3], sumCost + arr[depth][4]);
        select[depth] = false;
        dfs(depth + 1, sumP, sumF, sumS, sumV, sumCost);
    }
}