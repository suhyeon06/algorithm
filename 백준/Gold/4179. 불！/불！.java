import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int R, C;
    static char[][] map;
    static boolean[][] visited;
    static List<Item> fire;
    static Queue<Item> q;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int answer;

    static class Item {
        char type;
        int x;
        int y;
        int cnt;

        public Item(char type, int x, int y, int cnt) {
            this.type = type;
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);

        map = new char[R+1][C+1]; 
        visited = new boolean[R+1][C+1];
        q = new LinkedList<>();
        fire = new ArrayList<>();

        for(int i = 0; i < R; i++) {
            String s = br.readLine();
            for(int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);
                if(map[i][j] == 'J') {
                    q.add(new Item('J', i, j, 0));
                    visited[i][j] = true;
                }
                if(map[i][j] == 'F') {
                    fire.add(new Item('F', i, j, 0));
                }
            }
        }

        for(Item item : fire) {
            q.add(item);
        }


        bfs();

        System.out.print(answer > 0 ? answer : "IMPOSSIBLE");
    }

    private static void bfs() {

        while(!q.isEmpty()) {
            Item now = q.poll();

            if(now.type == 'J' && map[now.x][now.y] == 'F') {
                continue;
            }

            for(int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(!inRange(nx, ny)) {
                    if(now.type == 'F') continue;
                    answer = now.cnt + 1;
                    return;
                }

                if(map[nx][ny] == '#' || map[nx][ny] == 'F') continue;
                
                if(now.type == 'J' && !visited[nx][ny]) {
                    q.add(new Item('J', nx, ny, now.cnt + 1));
                    visited[nx][ny] = true;
                }

                if(now.type == 'F') {
                    q.add(new Item('F', nx, ny, 0));
                    map[nx][ny] = 'F';
                }

            }
        }
    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }
}
