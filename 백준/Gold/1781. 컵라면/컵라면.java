import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        List<Problem> problems = new ArrayList<>();
        int maxTime = 0;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            problems.add(new Problem(t, v));
            maxTime = Math.max(maxTime, t);
        }
        problems.sort((a, b) -> b.t - a.t);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;
        int idx = 0;

        for(int i = maxTime; i > 0; i--) {
            while (idx < N && problems.get(idx).t >= i) {
                pq.add(problems.get(idx).v);
                idx++;
            }
            if (!pq.isEmpty()) {
                answer += pq.poll();
            }
        }

        System.out.println(answer);
        
    }

    static class Problem {
        int t;
        int v;

        Problem(int t, int v) {
            this.t = t;
            this.v = v;
        }
    }


}