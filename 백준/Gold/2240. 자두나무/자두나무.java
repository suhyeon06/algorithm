import java.util.*;
import java.io.*;

class Main {
    static int T, W;
    static int[] arr;
    static int[][][] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        arr = new int[1001];
        dp = new int[T+1][W+2][3];

        for(int i = 1; i <= T; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 1; i <= T; i++) {
            for(int j = 1; j <= W + 1; j++) {
                if(arr[i] == 1) {
                    dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j-1][2]) + 1;
                    dp[i][j][2] = Math.max(dp[i-1][j-1][1], dp[i-1][j][2]);
                } else {
                    if (i == 1 && j == 1) continue;
                    dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j-1][2]);
                    dp[i][j][2] = Math.max(dp[i-1][j-1][1], dp[i-1][j][2]) + 1;
                }
            }
        }

        int answer = 0;
        for(int i = 1; i <= W + 1; i++) {
            answer = Math.max(answer, Math.max(dp[T][i][1], dp[T][i][2]));
        }

        System.out.println(answer);
        
    }
}