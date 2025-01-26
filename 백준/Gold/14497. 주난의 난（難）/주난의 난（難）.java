import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N, M;
    static int[][] arr;
    static boolean[][] visited;
    static int sx, sy;
    static int ex, ey;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int answer;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];

        st = new StringTokenizer(br.readLine());
        sx = Integer.parseInt(st.nextToken()) - 1;
        sy = Integer.parseInt(st.nextToken()) - 1;        
        ex = Integer.parseInt(st.nextToken()) - 1;
        ey = Integer.parseInt(st.nextToken()) - 1;

        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            for(int j = 0; j < M; j++) {
                if(s.charAt(j) == '#' || s.charAt(j) == '*') {
                    arr[i][j] = 1;
                    continue;
                }    
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        bfs();

        System.out.print(answer);
    }

    static void bfs() {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.addFirst(new int[]{sx, sy, 0});
        visited[sx][sy] = true;

        while(!q.isEmpty()) {
            int[] now = q.removeFirst();
            int x = now[0];
            int y = now[1];
            int cnt = now[2];

            if(x == ex && y == ey) {
                answer = cnt;
                return;
            }

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(!inRange(nx, ny) || visited[nx][ny]) continue;
                
                if(arr[nx][ny] == 0) {
                    q.addFirst(new int[]{nx, ny, cnt});
                } else {
                    q.addLast(new int[]{nx, ny, cnt + 1});
                }
                visited[nx][ny] = true;
            }
        }
    }

    static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}