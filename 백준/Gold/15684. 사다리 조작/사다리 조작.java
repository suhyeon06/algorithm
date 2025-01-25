import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N, M, H;
    static int size;
    static boolean[][] visited;
    static ArrayList<Integer>[] list;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int answer = 4;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        visited = new boolean[H + 1][N + 1];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            visited[x][y] = true;
        }

        if(check()) {
            System.out.print(0);
            return;
        }

        for(int i = 1; i <= 3; i++) {
            addLine(0, i);

            if(answer != 4) {
                System.out.println(answer);
                return;
            }
        }
        System.out.println(-1); 
        
    }

    static void addLine(int cnt, int target) {
        if(cnt == target) {
            if(check()) {
                answer = Math.min(answer, target);
            }
            return;
        }

        for(int i = 1; i <= H; i++) {
            for(int j = 1; j < N; j++) {
                if (!visited[i][j] && !visited[i][j - 1] && !visited[i][j + 1]) {
                    visited[i][j] = true;
                    addLine(cnt + 1, target);
                    visited[i][j] = false;
                }
            }
        }
    }

    static boolean check() {
        for(int i = 1; i <= N; i++) {
            if(i != move(i)) {
                return false;
            }
        }
        return true;
    }

    static int move(int start) {
        int pos = start;

        for(int i = 1; i <= H; i++) {
            if(pos > 1 && visited[i][pos - 1]) {
                pos--;
            } else if(pos < N && visited[i][pos]) {
                pos++;
            }
        }
        return pos;
    }    

}