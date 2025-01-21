import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int R, C;
    static char[][] map;
    static Queue<int[]> fire;
    static Queue<int[]> man;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);

        map = new char[R][C]; 
        fire = new LinkedList<>();
        man = new LinkedList<>();

        for(int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
            for(int j = 0; j < C; j++) {
                if(map[i][j] == 'J') {
                    man.add(new int[]{i, j});
                }
                if(map[i][j] == 'F') {
                    fire.add(new int[]{i, j});
                }
            }
        }

        int time = 0;
        boolean isMove = true;
        
        while(!man.isEmpty()) {
            time++;
            fireMove();

            if(manMove()) {
                System.out.print(time);
                return;
            }
        }

        System.out.print("IMPOSSIBLE");
    }

    private static void fireMove() {
        int size = fire.size();

        for(int i = 0; i < size; i++) {
            int[] now = fire.poll();

            for(int j = 0; j < 4; j++) {
                int nx = now[0] + dx[j];
                int ny = now[1] + dy[j];

                if(!inRange(nx, ny)) continue;

                if(map[nx][ny] == 'J' || map[nx][ny] == '.') {
                    fire.add(new int[]{nx, ny});
                    map[nx][ny] = 'F';
                }

            }
        }
    }

    private static boolean manMove() {
        int size = man.size();

        for(int i = 0; i < size; i++) {
            int[] now = man.poll();

            for(int j = 0; j < 4; j++) {
                int nx = now[0] + dx[j];
                int ny = now[1] + dy[j];

                if(!inRange(nx, ny)) {
                    return true;
                }

                if(map[nx][ny] == '.') {
                    man.add(new int[]{nx, ny});
                    map[nx][ny] = 'J';
                }
                
            }
        }
        return false;
    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }
}
