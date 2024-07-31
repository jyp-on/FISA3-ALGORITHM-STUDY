import java.util.*;
import java.io.*;

class Student {
    String name;
    int ko;
    int en;
    int math;

    Student (String s, int i1, int i2, int i3) {
        this.name = s;
        this.ko = i1;
        this.en = i2;
        this.math = i3;
    }
}

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Student[] students = new Student[N];

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            students[i] = new Student(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(students, new Comparator<Student>(){
            public int compare(Student s1, Student s2) {
                if(s1.ko == s2.ko) {
                    if(s1.en == s2.en) {
                        if(s1.math == s2.math) return s1.name.compareTo(s2.name);
                        else return s2.math - s1.math;
                    } else return s1.en - s2.en;
                } else return s2.ko - s1.ko;
            }
        });

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) sb.append(students[i].name).append("\n");
        bw.append(sb.toString());
        bw.close();
    }
}
