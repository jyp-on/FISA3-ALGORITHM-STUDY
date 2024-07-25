package 문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class P12891_DNA비밀번호 {
    public static void main(String[]args) throws IOException{
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int s= Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        char[] ch= br.readLine().toCharArray();
        st= new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int count=0;
        Map<Character,Integer> map = new HashMap<>();
        map.put('A',a);map.put('C',c);map.put('G',g);map.put('T',t);


        for(int i=0;i<p;i++){
            map.put(ch[i], map.get(ch[i])-1 );
        }

        if( map.get('A')<=0&& map.get('C')<=0&& map.get('G')<=0&& map.get('T')<=0 ){

            count++;
        }

        for(int i=p;i<s;i++){

            char first= ch[i-p];
            char last=ch[i];
            map.put(first, map.get(first)+1);
            map.put(last, map.get(last)-1);

            if( map.get('A') <= 0 && map.get('C')<=0 && map.get('G')<=0 && map.get('T')<=0 ){
                count++;
            }

        }
        System.out.println(count);
    }
}
