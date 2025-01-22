import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int K;
    static int size;
    static int[] arr;
    static ArrayList<Integer>[] list;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        size = (int)(Math.pow(2, K) - 1);
        arr = new int[size];
        list = new ArrayList[K];

        for(int i = 0; i < K; i++) {
            list[i] = new ArrayList<>();
        }
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0, size);

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < K; i++) {
            for(int j = 0; j < list[i].size(); j++) {
                sb.append(list[i].get(j) + " ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    static void dfs(int depth, int s, int e) {
        if(depth == K) {
            return;
        }
        int mid = (s + e) / 2;

        list[depth].add(arr[mid]); 
        dfs(depth + 1, s, mid - 1);
        dfs(depth + 1, mid + 1, e);
    }
}