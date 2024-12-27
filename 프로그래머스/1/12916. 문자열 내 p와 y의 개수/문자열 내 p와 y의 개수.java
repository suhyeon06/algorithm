class Solution {
    boolean solution(String s) {
        s = s.toLowerCase();
        boolean answer = true;
        int pCnt = 0;
        int yCnt = 0;
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == 'p') pCnt++;
            else if(c == 'y') yCnt++;
        }
        
        if(pCnt != yCnt) answer = false;

        return answer;
    }
}