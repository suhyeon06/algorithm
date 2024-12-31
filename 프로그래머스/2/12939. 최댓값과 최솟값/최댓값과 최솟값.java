import java.util.*;

class Solution {
    public String solution(String s) {
        String[] arr = s.split(" ");
        List<Integer> list = new ArrayList<>();
        
        for(String num : arr) {
            list.add(Integer.parseInt(num));
        }
        
        Collections.sort(list);
        
        return list.get(0) + " " + list.get(list.size() - 1);
    }
}
