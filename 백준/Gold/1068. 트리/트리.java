import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N;
    static ArrayList<Integer>[] tree;
    static boolean[] visited;
    static int target;
    static int start;
    static int cnt = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String[] nodes = br.readLine().split(" ");

        tree = new ArrayList[N];
        visited = new boolean[N];
        for(int i = 0; i < N; i++) {
            tree[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < N; i++) {
            int node = Integer.parseInt(nodes[i]);
            if(node == -1) {
                start = i;
                continue;
            }
            tree[node].add(i);
        }

        target = Integer.parseInt(br.readLine());
        visited[target] = true;
        dfs(start);

        System.out.print(cnt);
    }

    private static void dfs(int parent) {
        visited[parent] = true;
        boolean isLeaf = true;

        int size = tree[parent].size();

        if(parent != target) {
            for(int i = 0; i < size; i++) {
                int next = tree[parent].get(i);
                
                if(!visited[next]) {
                    isLeaf = false;
                    dfs(next);
                }
            }
            if(isLeaf) {
                cnt++;
            }
        }
    }
}