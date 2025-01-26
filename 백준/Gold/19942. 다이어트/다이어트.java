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

        for(int i = 1; i <= N; i++) {
            dfs(0, i, 0);
        }

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


    static void dfs(int depth, int target, int start) {
        if(depth == target) {
            check();
            return;
        }

        for(int i = start; i < N; i++) {
            select[i] = true;
            dfs(depth + 1, target, i + 1);
            select[i] = false;
        }
    }

    static void check() {
        int[] sum = new int[SIZE];

        for(int i = 0; i < select.length; i++) {
            if(select[i]) {
                for(int j = 0; j < SIZE; j++) {
                    sum[j] += arr[i][j];
                }
            }
        }

        if(sum[0] >= mp && sum[1] >= mf && sum[2] >= ms && sum[3] >= mv) {
            
            if(sum[4] < minCost) {
                minCost = sum[4];
            
                list.clear();
                for(int i = 0; i < select.length; i++) {
                    if(select[i]) {
                        list.add(i + 1);
                    }
                }
            } else if(sum[4] == minCost) {
                Collections.sort(list);

                sb = new StringBuilder();
                for(int num : list) {
                    sb.append(num);
                }
        
                String a = sb.toString();
                String b = "";

                for(int i = 0; i < select.length; i++) {
                    if(select[i]) {
                        b += (i + 1) + "";
                    }
                }

                if(a.compareTo(b) > 0) {
                    list.clear();
                    for(int i = 0; i < select.length; i++) {
                        if(select[i]) {
                            list.add(i + 1);
                        }
                    }
                }
                
            }

        }
    }
}