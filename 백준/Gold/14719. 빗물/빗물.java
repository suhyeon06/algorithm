import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int H, W;
    static int[] height;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        height = new int[W];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < W; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;

        for(int i = 1; i < W - 1; i++) {
            int left = 0;
            int right = 0;

            for(int j = 0; j < i; j++) {
                left = Math.max(left, height[j]);
            }

            for(int j = i + 1; j < W; j++) {
                right = Math.max(right, height[j]);
            }

            if(height[i] < left && height[i] < right) {
                answer += Math.min(left, right) - height[i];
            }
        }

        System.out.print(answer);
        
    }
}