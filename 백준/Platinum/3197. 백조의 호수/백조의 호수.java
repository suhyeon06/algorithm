import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int R, C;
    static char[][] arr;
    static boolean[][] visited;
    static Queue<int[]> wq, sq;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int sx = -1;
    static int sy = -1;
    static int ex;
    static int ey;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[R][C];
        visited = new boolean[R][C];
        wq = new LinkedList<>();
        sq = new LinkedList<>();

        for(int i = 0; i < R; i++) {
            String s = br.readLine();
            for(int j = 0; j < C; j++) {
                arr[i][j] = s.charAt(j);
                if(arr[i][j] == 'L') {
                    if(sx == -1 && sy == -1) {
                        sx = i;
                        sy = j;
                    } else {
                        ex = i;
                        ey = j;
                    }
                    arr[i][j] = '.';
                }

                if(arr[i][j] == '.') {
                    wq.add(new int[]{i, j});
                }
            }
        }

        sq.add(new int[]{sx, sy});
        visited[sx][sy] = true;
        
        int time = 0;
        while(true) {
            if(move()) break;
            melt();
            time++;
        }

        System.out.print(time);
    }

    static boolean move() {
        Queue<int[]> nq = new LinkedList<>();

        while(!sq.isEmpty()) {
            int[] now = sq.poll();

            if(now[0] == ex && now[1] == ey) {
                return true;
            }
        
            for(int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if(!inRange(nx, ny) || visited[nx][ny]) continue;

                visited[nx][ny] = true;

                if(arr[nx][ny] == 'X') {
                    nq.add(new int[]{nx, ny});
                } else {
                    sq.add(new int[]{nx, ny});
                }
                
            }
        }

        sq = nq;
        return false;
    }

    static void melt() {
        int size = wq.size();

        for(int i = 0; i < size; i++) {
            int[] now = wq.poll();

            for(int j = 0; j < 4; j++) {
                int nx = now[0] + dx[j];
                int ny = now[1] + dy[j];

                if(!inRange(nx, ny)) continue;

                if(arr[nx][ny] == 'X') {
                    arr[nx][ny] = '.';
                    wq.add(new int[]{nx, ny});
                }
            }
        }
    }

    static boolean inRange(int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }

}