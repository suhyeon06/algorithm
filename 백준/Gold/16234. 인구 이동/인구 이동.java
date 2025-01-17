import java.io.*;
import java.util.*;

public class Main {
    static int N, L, R;
    static int[][] map;
    static boolean[][] visited;
    static int day;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean flag = true;

        while(flag) {
            flag = false;
            visited = new boolean[N][N];

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(!visited[i][j]) {
                        visited[i][j] = true;
                        if(bfs(i, j)) {
                            flag = true;
                        }
                    }
                }
            }

            if(flag) {
                day++;
            }
        }

        System.out.println(day);

    }

    static boolean bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x, y});

        ArrayList<int []> list = new ArrayList<>();
        list.add(new int[] {x, y});

        int sum = map[x][y];

        while(!q.isEmpty()) {
            int[] now = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if(!inRange(nx, ny) || visited[nx][ny]) continue;

                int diff = Math.abs(map[nx][ny] - map[now[0]][now[1]]);

                if(L <= diff && diff <= R) {
                    visited[nx][ny] = true;
                    sum += map[nx][ny];
                    q.add(new int[]{nx, ny});
                    list.add(new int[]{nx, ny});
                }
            }
        }

        if(list.size() > 1) {
            int popularity = sum / list.size();

            for(int[] p : list) {
                map[p[0]][p[1]] = popularity;
            }
            return true;
        }

        return false;
    }

    static boolean inRange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }
}
