import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> original = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            original.add(Integer.parseInt(st.nextToken()));
            list.add(original.get(i));
            map.put(original.get(i), map.getOrDefault(original.get(i), 0) + 1);
        }

        Collections.sort(list, (o1, o2) -> {
            if(map.get(o1) == map.get(o2)) {
                return original.indexOf(o1) - original.indexOf(o2);
            } else {
                return Integer.compare(map.get(o2), map.get(o1));
            }
        });

        for(int num : list) {
            sb.append(num + " ");
        }

        System.out.print(sb);

    }

}