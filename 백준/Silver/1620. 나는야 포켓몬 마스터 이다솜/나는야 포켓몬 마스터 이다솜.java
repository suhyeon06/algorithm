import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<Integer, String> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        
        for(int i = 1; i <= N; i++) {
            String s = br.readLine();
            map1.put(i, s);
            map2.put(s, i);
        }

        for(int i = 0; i < M; i++) {
            String s = br.readLine();
            if(Character.isDigit(s.charAt(0))) {
                sb.append(map1.get(Integer.parseInt(s)));
            } else {
                sb.append(map2.get(s));
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}