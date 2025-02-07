import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			int k = Integer.parseInt(br.readLine());
			
			TreeMap<Integer, Integer> map = new TreeMap<>();
			
			for(int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				
				char op = st.nextToken().charAt(0);
				int num = Integer.parseInt(st.nextToken());
				
				if(op == 'I') { // 삽입
					map.put(num, map.getOrDefault(num, 0) + 1);
				} else { // 삭제
					if(map.size() == 0) continue;
					
					int key;
					if(num == 1) {
						key = map.lastKey();
					} else {
						key = map.firstKey();
					}
					
					int cnt = map.get(key);
					if(cnt == 1) {
						map.remove(key);
					} else {
						map.put(key, cnt - 1);
					}
				}
			}
			
			if(map.size() == 0) {
				sb.append("EMPTY");
			} else {
				sb.append(map.lastKey()).append(" ").append(map.firstKey());
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}