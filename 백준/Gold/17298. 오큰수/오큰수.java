import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> stack = new ArrayDeque<>();
        
        for(int i = 0; i < N; i++) {
            while(!stack.isEmpty() && arr[i] > arr[stack.getFirst()]) {
                arr[stack.removeFirst()] = arr[i];
            }
            stack.addFirst(i);
        }
        
        while(!stack.isEmpty()) {
            arr[stack.removeFirst()] = -1;
        }

        for(int n : arr) {
            sb.append(n).append(" ");
        }

        System.out.print(sb);
    }
}