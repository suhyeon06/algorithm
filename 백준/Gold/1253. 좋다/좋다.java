import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N;
    static int[] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        
        int max = arr[N-1];
        int cnt = 0;
        for(int i = 0; i < N; i++) {
            if(check(i)) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    static boolean check(int target) {
        int left = 0;
        int right = N - 1;

        while(true) {
            if(left == target) {
                left++;
            } else if(right == target) {
                right--;
            }

            if(left >= right) {
                break;
            }
            
            if(arr[left] + arr[right] > arr[target]) {
                right--;
            } else if(arr[left] + arr[right] < arr[target]) {
                left++;
            } else {
                return true;
            }
        }

        return false;
    }
}