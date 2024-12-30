class Solution {
    public double solution(int[] arr) {
        double answer = 0;
        int size = arr.length;
        
        for(int i = 0; i < size; i++) {
            answer += arr[i];
        }
        return answer / size;
    }
}