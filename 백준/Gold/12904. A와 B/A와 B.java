import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder s = new StringBuilder(br.readLine());
        StringBuilder t = new StringBuilder(br.readLine());

        while(s.length() < t.length()) {
            if(t.charAt(t.length() - 1) == 'B') {
                t.deleteCharAt(t.length() - 1);
                t.reverse();
            } else if(t.charAt(t.length() - 1) == 'A'){
                t.deleteCharAt(t.length() - 1);
            }
        }

        if(s.toString().equals(t.toString())) {
            System.out.print(1);
        } else {
            System.out.print(0);
        }
    }
}