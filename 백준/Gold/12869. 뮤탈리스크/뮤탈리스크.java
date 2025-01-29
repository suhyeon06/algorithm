import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N;
    static int[] arr;
    static int[][][] visited = new int[64][64][64];
    static int[][] attack = {
        {9, 3, 1},
        {9, 1, 3},
        {3, 9, 1},
        {3, 1, 9},
        {1, 9, 3},
        {1, 3, 9}
    };
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[3];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bfs();

        System.out.print(visited[0][0][0]);
    }

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{arr[0], arr[1], arr[2]});

        while(!q.isEmpty()) {
            int[] now = q.poll();
            int a = now[0];
            int b = now[1];
            int c = now[2];

            if(visited[0][0][0] > 0) break;

            for(int i = 0; i < 6; i++) {
                int na = Math.max(0, a - attack[i][0]);
                int nb = Math.max(0, b - attack[i][1]);
                int nc = Math.max(0, c - attack[i][2]);

                if(visited[na][nb][nc] > 0) continue;
                q.add(new int[]{na, nb, nc});
                visited[na][nb][nc] = visited[a][b][c] + 1;
            }
        }
    }
}