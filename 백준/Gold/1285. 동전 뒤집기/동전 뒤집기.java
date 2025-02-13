import java.util.*;
import java.io.*;

class Main {
    static int N;
    static char[][] arr;
    static int answer = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];

        for(int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        for(int bit = 1; bit < (1 << N); bit++) {
            int sum = 0;
            for(int j = 0; j < N; j++) {
                int back  = 0;
                for(int i = 0; i < N; i++) {
                    char now = arr[i][j];
                    if((bit & (1 << i)) != 0) {
                        now = reverse(now);
                    }
                    if(now == 'T') back ++;
                }
                sum += Math.min(back , N - back);
            }
            answer = Math.min(answer, sum);
        }
        System.out.println(answer);
    }

    public static char reverse(char c) {
        if(c == 'T') return 'H';
        else return 'T';
    }
}