import java.util.*;
import java.io.*;

class Main {
    static int N, D;
    static Present[] presents;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        presents = new Present[N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            presents[i] = new Present(p, v);
        }

        Arrays.sort(presents);

        long answer = 0;
        long sum = 0;
        int left = 0;
        int right = 0;
        
        while(right < N) {
            sum += presents[right].v;
            while(presents[left].p + D <= presents[right].p) {
                sum -= presents[left].v;
                left++;
            }
            answer = Math.max(answer, sum);
            
            right++;
        }

        System.out.print(answer);
    }

    static class Present implements Comparable<Present> {
        int p;
        int v;

        public Present(int p, int v) {
            this.p = p;
            this.v = v;
        }

        @Override
        public int compareTo(Present o) {
            return this.p - o.p;
        }
    }
}