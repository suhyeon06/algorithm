import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N, K;
    static int[] order;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        order = new int[K];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < K; i++) {
            order[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> multiTap = new ArrayList<>();
        int cnt = 0;
        
        for(int i = 0; i < K; i++) {
            if(multiTap.contains(order[i])) {
                continue;
            } else if(multiTap.size() < N) {
                multiTap.add(order[i]);
            } else {
                PriorityQueue<Plug> pq = new PriorityQueue<>();
                for(int no : multiTap) {
                    int next = Integer.MAX_VALUE;
                    for(int j = i + 1; j < K; j++) {
                        if(no == order[j]) {
                            next = j;
                            break;
                        }
                    }

                    pq.add(new Plug(no, next));
                }

                Plug target = pq.poll();

                multiTap.remove(Integer.valueOf(target.no));
                multiTap.add(order[i]);
                cnt++;
            }
        }

        System.out.print(cnt);

    }

    static class Plug implements Comparable<Plug> {
        int no;
        int next;

        public Plug(int no, int next) {
            this.no = no;
            this.next = next;
        }

        @Override
        public int compareTo(Plug o) {
            return o.next - this.next;
        }
    }
}