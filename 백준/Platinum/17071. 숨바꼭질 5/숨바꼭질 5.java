import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N, K;
    static boolean visited[][];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[2][500001];

        System.out.println(solve(N));
    }

    static int solve(int start) {
        if(N == K) return 0;
        
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[0][start] = true;
        
        int time = 0;

        while(!q.isEmpty()) {
            time++;
            int size = q.size();
            int flag = time % 2; // 짝수초는 0, 홀수초는 1

            K += time;

            if(K > 500000) {
                return -1;
            }

            for(int i = 0; i < size; i++) {
                int now = q.poll();

                for(int j = 0; j < 3; j++) {
                    int next;
                    if(j == 0) {
                        next = now + 1;
                    } else if(j == 1) {
                        next = now - 1;
                    } else {
                        next = now * 2;
                    }
                    
                    if (next < 0 || next > 500000 || visited[flag][next]) continue;

                    visited[flag][next] = true;
                    q.add(next);
                }
            }

           if(visited[flag][K]) {
                return time;
            }
        }
        return -1;

    }
}