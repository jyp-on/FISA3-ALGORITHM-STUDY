import java.util.Stack;

class Solution {
    public int solution(int[] ingredient) {
        Stack<Integer> stack = new Stack<>();
        int cnt = 0;

        for(int i : ingredient) {
            stack.push(i);
            if (stack.size() >= 4) {
                if (stack.get(stack.size()-1) == 1 &&
                    stack.get(stack.size()-2) == 3 &&
                    stack.get(stack.size()-3) == 2 &&
                    stack.get(stack.size()-4) == 1) {
                    for(int j=0; j<4; j++) stack.pop();
                    cnt ++;
                }
            }
        }
        
        return cnt;
    }
}
