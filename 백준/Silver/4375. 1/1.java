import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = "";
        while ((input = br.readLine()) != null) {
            int num = Integer.parseInt(input);

            int base = 1;
            int cnt = 1;
            while (base % num != 0) {
                base = (base * 10 + 1) % num;
                cnt++;
            }
            sb.append(cnt).append('\n');
        }
        System.out.println(sb);
    }
}