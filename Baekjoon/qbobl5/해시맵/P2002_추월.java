import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int carCnt = Integer.parseInt(br.readLine());

        Map<String, Integer> inCar = new HashMap<>();
        for(int i=0; i<carCnt; i++) inCar.put(br.readLine(), i);

        String[] outCar = new String[carCnt];
        for(int i=0; i<carCnt; i++) outCar[i] = br.readLine();

        int cnt = 0;
        for(int i=0; i<carCnt-1; i++) {
            for(int j=i+1; j<carCnt; j++) {
                if(inCar.get(outCar[i]) > inCar.get(outCar[j])) {
                    cnt ++;
                    break;
                }
            }
        }

        System.out.println(cnt);
    }
}
