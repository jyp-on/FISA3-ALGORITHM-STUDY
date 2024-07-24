package 스택;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class P3986_좋은단어 {
    public static void main(String[]args)throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int count=0;
        int n= Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++){
            char[] ch= br.readLine().toCharArray();
            if(ch.length%2 ==1){
                continue;
            }
            Stack<Character> stack= new Stack<>();
            stack.push(ch[0]);
            for(int j=1;j<ch.length;j++){
                if(!stack.isEmpty() && stack.peek()==ch[j]){
                    stack.pop();
                }else {
                    stack.push(ch[j]);
                }

            }
            if(stack.isEmpty()){
                count++;
            }

        }
        System.out.println(count);
    }
}
