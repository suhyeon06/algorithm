import java.util.*;
import java.lang.*;
import java.io.*;

class Main {  
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;

        for(int i = 0; i < N; i++) {
            char[] word = br.readLine().toCharArray();
            Deque<Character> stack = new ArrayDeque<>();

            for(int j = 0; j < word.length; j++) {
                if(!stack.isEmpty() && stack.peekLast() == word[j]) {
                    stack.removeLast();
                } else {
                    stack.addLast(word[j]);
                }
            }

            if(stack.isEmpty()) {
                cnt++;
            }
        }

        System.out.print(cnt);
    }
}
