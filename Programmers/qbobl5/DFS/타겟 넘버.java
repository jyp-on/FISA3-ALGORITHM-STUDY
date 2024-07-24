class Solution {
    static int[] nums;
    static int value;
    
    public int solution(int[] numbers, int target) {
        nums = numbers;
        value = target;
        return dfs(0, 0);
    }
    
    public static int dfs(int idx, int cnt) {
        if(idx == nums.length) {
            if(cnt == value) return 1;
            return 0;
        }
        
        return dfs(idx + 1, cnt - nums[idx]) + dfs(idx + 1, cnt + nums[idx]);
    }
}
