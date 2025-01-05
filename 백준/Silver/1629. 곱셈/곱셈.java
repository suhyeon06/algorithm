import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());
        
        System.out.print(solve(a, b, c));
    }

    private static long solve(long a, long b, long c) {
        if(b == 1) return a % c;
        long k = solve(a, b / 2, c);
        k = (k * k) % c;
        if(b % 2 == 1) {
            k = (k * a) % c;
        }
        return k;
    }
}