import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int minHam = Integer.MAX_VALUE;
        for(int i=0; i<3; i++) {
            minHam = Math.min(minHam, sc.nextInt());
        }

        int minJuicy = Integer.MAX_VALUE;
        for(int i=0; i<2; i++) {
            minJuicy = Math.min(minJuicy, sc.nextInt());
        }

        System.out.println(minHam + minJuicy - 50);
    }
}
