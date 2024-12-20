import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n * 2];

        int total = 0;

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            arr[i + n] = arr[i];
            total += arr[i];
        }

        int s = 0;
        int e = 0;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        
        while(true) {
            if(sum > max) {
                sum -= arr[s++];
            } else if(e == n) {
                break;
            } else {
                sum += arr[e++];
            }
            
            int minDist = Math.min(sum, total - sum);
            max = Math.max(max, minDist);
        }

        System.out.print(max);
    }
}