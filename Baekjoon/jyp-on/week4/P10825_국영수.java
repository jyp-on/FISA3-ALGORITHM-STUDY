package week4;

import java.util.*;
import java.io.*;

class Person {
    String name;
    int kor;
    int eng;
    int math;

    public Person(String name, int kor, int eng, int math) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }
}

public class P10825_국영수 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Person[] persons = new Person[N];

        Scanner sc = new Scanner(System.in);
        char[] arr = new char[N];
        Arrays.sort(arr);

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int kor = Integer.parseInt(st.nextToken());
            int eng = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            persons[i] = new Person(name, kor, eng, math);
        }

        // lambda로 구현
//        Arrays.sort(persons, (o1, o2) -> {
//            if(o1.kor == o2.kor && o1.eng == o2.eng && o1.math == o2.math)
//                return o1.name.compareTo(o2.name);
//
//            else if(o1.kor == o2.kor && o1.eng == o2.eng)
//                return o2.math - o1.math;
//
//            else if(o1.kor == o2.kor)
//                return o1.eng - o2.eng;
//
//            else
//                return o2.kor - o1.kor;
//
//        });

        // Comparator 로 구현
        /*
        * 각 단계는 우선순위가 높은 조건을 만족하지 못한 경우에만 그 다음 조건으로 넘어가므로, 가장 우선순위가 높은 조건이 제일 나중에 고려되어야 함.
        * 즉 우선순위가 낮은 조건부터 정렬 조건을 만들어야 함
        * */
        Arrays.sort(persons, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                // 모든 점수가 같은 경우가 가장 가능한 경우가적기 때문에 먼저 처리해줌
                if(o1.kor == o2.kor && o1.eng == o2.eng && o1.math == o2.math)
                    return o1.name.compareTo(o2.name);

                // 국어점수, 영어점수가 같은 경우
                else if(o1.kor == o2.kor && o1.eng == o2.eng)
                    return o2.math - o1.math;

                // 국어점수만 같은 경우
                else if(o1.kor == o2.kor)
                    return o1.eng - o2.eng;

                // 그 외의 경우는 국어 점수 내림차순
                else
                    return o2.kor - o1.kor;

            }
        });

        StringBuilder sb = new StringBuilder();
        for(Person p : persons) {
            sb.append(p.name + "\n");
        }

        System.out.println(sb);
    }
}
