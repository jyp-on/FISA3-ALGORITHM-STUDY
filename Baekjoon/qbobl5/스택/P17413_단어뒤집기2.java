import java.io.*;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        boolean flag = false;

        for(char c:input.toCharArray()) {
            if(c == '<') {
                if(!stack.isEmpty()) while(!stack.isEmpty()) sb.append(stack.pop());
                flag = true;
                sb.append(c);
            } else if(c == '>') {
            	flag = false;
                sb.append(c);
            } else if(c == ' ') {
                if(!stack.isEmpty()) while(!stack.isEmpty()) sb.append(stack.pop());
                sb.append(" ");
            } else if(flag) sb.append(c);
            else stack.push(c);
        }

        while(!stack.isEmpty()) sb.append(stack.pop());

        bw.write(sb.toString());
        bw.close();
        br.close();
	}

}
