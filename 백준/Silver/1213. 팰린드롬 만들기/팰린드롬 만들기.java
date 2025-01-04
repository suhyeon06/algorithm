import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int[] arr = new int[26];
        String s = br.readLine();

        for(int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'A';
            arr[idx]++;
        }

        int odd = 0;
        int mid = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] % 2 == 1) {
                odd++;
                mid = i;
            }
            
            if(odd >= 2) {
                System.out.print("I'm Sorry Hansoo");
                return;
            }
        }

        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i] / 2; j++) {
                sb.append((char)('A' + i));
            }
        }

        String answer = sb.toString();

        if(odd == 1) {
            answer += (char)('A' + mid);
        }

        answer += sb.reverse().toString();

        System.out.print(answer);
    }
}