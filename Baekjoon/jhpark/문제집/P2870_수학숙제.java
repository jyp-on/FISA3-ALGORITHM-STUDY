package 문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P2870_수학숙제 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            String temp="";

            for (int j = 0; j < s.length(); j++) {
                char c=s.charAt(j);
                if(c>'0' && c<='9'){
                    temp+=s.charAt(j);
                }
                else if (c=='0'){
                    if (j+1==s.length()){
                        list.add("0");
                    }
                    else {
                        char _c = s.charAt(j + 1);
                        if (_c > '0' && _c <= '9') {
                            temp += s.charAt(++j);
                        }
                    }
                }
                else {
                    if (!temp.isEmpty()){
                        list.add(temp);
                        temp="";
                    }
                }
            }

            if (!temp.isBlank()){
                list.add(temp);
            }
        }
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
