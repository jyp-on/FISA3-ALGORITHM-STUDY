import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class P1141_접두사 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer= 0;
        List<String> list = new ArrayList<>(n);
        for(int i=0;i<n;i++){
            String string= br.readLine();
            list.add(string);
        }
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length()-o1.length();
            }
        });
        for (int i=0;i<n;i++){
            String si= list.get(i);

            boolean flag= true;
            for (int j=0;j<i;j++){
                String sj= list.get(j);

                if(si.equals(sj.substring(0,si.length()))){

                    flag=false;
                    break;
                }
            }
            if (flag){
                answer++;
            }
        }

        System.out.println(answer);

    }
}