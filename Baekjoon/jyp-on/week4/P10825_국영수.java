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

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int kor = Integer.parseInt(st.nextToken());
            int eng = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            persons[i] = new Person(name, kor, eng, math);
        }

        Arrays.sort(persons, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if(o1.kor == o2.kor && o1.eng == o2.eng && o1.math == o2.math)
                    return o1.name.compareTo(o2.name);

                else if(o1.kor == o2.kor && o1.eng == o2.eng)
                    return o2.math - o1.math;

                else if(o1.kor == o2.kor)
                    return o1.eng - o2.eng;

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
