import java.util.*;
import java.io.*;

class Main {
    static int N, K;
    static int[] bags;
    static Jewel[] jewels;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        jewels = new Jewel[N];
        bags = new int[K];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            jewels[i] = new Jewel(m, v);
        }

        for(int i = 0; i < K; i++) {
            int c = Integer.parseInt(br.readLine());
            bags[i] = c;
        }
        
        Arrays.sort(jewels);
        Arrays.sort(bags);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        long answer = 0;
        int idx = 0;
        
        for(int i = 0; i < K; i++) {
            while(idx < N && jewels[idx].m <= bags[i]) {
                pq.add(jewels[idx].v);
                idx++;
            }

            if(!pq.isEmpty()) {
                answer += pq.poll();
            }
        }

        System.out.println(answer);
        
    }

    static class Jewel implements Comparable<Jewel> {
        int m;
        int v;

        public Jewel(int m, int v) {
            this.m = m;
            this.v = v;
        }

        @Override
        public int compareTo(Jewel j) {
            if(this.m == j.m) {
                return j.v - this.v;
            }
            return this.m - j.m;
        }
    }
}