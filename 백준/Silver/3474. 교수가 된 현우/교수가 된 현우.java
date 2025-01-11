import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            
            int two = 0;
            int five = 0;

            for(int j = 2; j <= num; j *= 2) {
                two += num / j;
            }

            for(int j = 5; j <= num; j *= 5) {
                five += num / j;
            }

            System.out.println(Math.min(two, five));
        }
    }
}