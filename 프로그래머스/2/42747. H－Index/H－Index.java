import java.util.*;

class Solution {
    public int solution(int[] citations) {
        
        Arrays.sort(citations);
        int hIndex = citations.length;
        
        for(int i = 0; i < hIndex; i++) {
            if(citations[i] >= hIndex - i) {
                return hIndex - i;
            }
        }
        
        return 0;
    }
}
