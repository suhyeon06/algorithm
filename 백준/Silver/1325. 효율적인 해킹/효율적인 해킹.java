import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N, M;
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int[] result;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];

        for(int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[b].add(a);
        }

        result = new int[N + 1];

        int max = 0;
        for(int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            result[i] = bfs(i);
            max = Math.max(max, result[i]);
        }

        for(int i = 1; i <= N; i++) {
            if(result[i] == max) {
                System.out.print(i + " ");
            }
        }
    }

    private static int bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        int cnt = 0;
        while(!q.isEmpty()) {
            int now = q.poll();
            for(int next : list[now]) {
                if(!visited[next]) {
                    cnt++;
                    visited[next] = true;
                    q.add(next);
                }
            }
        }

        return cnt;
    }
}
