import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static ArrayList<Integer> num;
    static ArrayList<Character> op;
    static int answer = Integer.MIN_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        num = new ArrayList<>();
        op = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            if(i % 2 == 0) {
                num.add(str.charAt(i) - '0');
            } else {
                op.add(str.charAt(i));
            }
        }

        solve(0, num.get(0));

        System.out.print(answer);
    }

    static void solve(int idx, int sum) {
        if(idx == num.size() - 1) {
            answer = Math.max(answer, sum);
            return;
        }

        solve(idx + 1, calculate(op.get(idx), sum, num.get(idx + 1)));

        if(idx + 2 <= num.size() - 1) {
            int temp = calculate(op.get(idx + 1), num.get(idx + 1), num.get(idx + 2));
            solve(idx + 2, calculate(op.get(idx), sum, temp));
        }
    }

    static int calculate(char a, int b, int c) {
        if(a == '+') return b + c;
        if(a == '-') return b - c;
        if(a == '*') return b * c;
        return 0;
    }
}
