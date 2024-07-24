class Solution {
    public int solution(int[] ingredient) {
        int[] arr = new int[ingredient.length];
        int cnt = 0;
        int idx = 0;
        
        for(int i=0; i<arr.length; i++) {
            arr[idx++] = ingredient[i];
            if(idx >= 4 && arr[idx-1] == 1 && arr[idx-2] == 3 && arr[idx-3] == 2 && arr[idx-4] == 1) {
                idx -= 4;
                cnt ++;
            }
        }
        
        return cnt;
    }
}
