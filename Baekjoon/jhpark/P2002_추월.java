//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//class P2002_추월 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n= Integer.parseInt(br.readLine());
//        Map<String,Integer> map = new HashMap<>();
//
//        Map<Integer,String> map2 = new HashMap<>();
//        int count =0;
//        for (int i = 1; i <= n; i++) {
//            map.put(br.readLine(),i);
//        }
//        for (int i = 1; i <= n; i++) {
//            map2.put(i,br.readLine());
//        }
//        for (int i = 1; i <= n; i++) {
//            String s = map2.get(i);
//            Integer k =map.get(s);
//            if(k-i !=0){
//                count++;
//                for (int j=i;j<k;j++){
//                    map.
//                }
//            }
//        }
//    }
//}
//
//// 3->1   3 1 2 4 5
//// 4->3   3 1 4 2 5
//// 5 ->4  3  14 5 2
////