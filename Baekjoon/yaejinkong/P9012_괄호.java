import java.util.*;
import java.lang.*;
import java.io.*;

class Validator {
    public boolean isValid(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.push(str.charAt(i));
            } else if (str.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();

    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLine();
        }

        Validator validator = new Validator();
        for (int i = 0; i < arr.length; i++) {
            String ps = arr[i];
            if (validator.isValid(ps)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}