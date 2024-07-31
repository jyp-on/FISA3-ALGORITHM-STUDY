
# Java Sort

## Comparator vs Comparable

- 처음엔 이해가 안될 수 있으니 밑에 예제들을 참고해주세요.

| 특징                   | `Comparable`                        | `Comparator`                               |
|------------------------|-------------------------------------|--------------------------------------------|
| **정의 위치** | 클래스 내부                         | 클래스 외부                                |
| **정렬 기준의 수**     | 단일 정렬 기준                      | 다수의 정렬 기준                           |
| **주요 메서드**        | `compareTo(T o)`                    | `compare(T o1, T o2)`                      |
| **용도**               | 기본 정렬 기준을 정의할 때 사용     | 다양한 정렬 기준을 정의할 때 사용         |
| **구현 방식**          | `public class ClassName implements Comparable<ClassName>` | `Comparator<ClassName> comparator = new Comparator<ClassName>() { ... };` |
| **자주 사용되는 경우** | 자연스러운 순서를 정렬해야 할 때    | 특정 상황에 따라 다른 기준으로 정렬할 때  |
| **예시**               | `public int compareTo(Person other) { return this.age - other.age; }` | `public int compare(Person p1, Person p2) { return p1.name.compareTo(p2.name); }` |

## 기본타입 정렬

- 1차원 배열 정렬

```java
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 5, 6};

        // 오름차순 정렬
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr)); // [1, 2, 5, 5, 6, 9]

        // 기본 타입 배열은 Comparator를 사용할 수 없습니다.
        // 따라서 int[]를 Integer[]로 변환하여 사용합니다.
        Integer[] integerArr = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        // 람다 표현식을 사용하여 내림차순 정렬
        Arrays.sort(integerArr, (o1, o2) -> o2 - o1);
        System.out.println(Arrays.toString(integerArr)); // [9, 6, 5, 5, 2, 1]
    }
}
```

- 2차원 배열 행마다 정렬
```java
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] array = {
                {5, 2, 9},
                {1, 5, 6},
                {8, 3, 7}
        };

        // 각 행을 오름차순으로 정렬
        for (int[] row : array) {
            Arrays.sort(row);
        }

        // 정렬된 배열 출력
        for (int[] row : array) {
            System.out.println(Arrays.toString(row));
        }
    }
}
```

- 2차원 배열 특정 Column 기준으로 정렬

```java
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        // Integer 배열로 선언
        Integer[][] array = {
                {5, 2, 9},
                {1, 5, 6},
                {8, 3, 7},
                {3, 9, 20}
        };

        // 2번째 값을 기준으로 오름차순 정렬 with Comparator
        Arrays.sort(array, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return o1[1].compareTo(o2[1]);
            }
        });

        for (Integer[] row : array) {
            System.out.println(Arrays.toString(row));
        }

        System.out.println();

        // 3번째 값을 기준으로 내림차순 정렬 with Comparator
        Arrays.sort(array, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return o2[2] - o1[2];
            }
        });

        // 3번째 값을 기준으로 내림차순 정렬 with lambda
        Arrays.sort(array, (o1, o2) -> o2[2] - o1[2]);

        // 정렬된 배열 출력
        for (Integer[] row : array) {
            System.out.println(Arrays.toString(row));
        }
    }
}

```

## Collections 정렬

- Collections 인터페이스를 구현한 클래스들은 Collections.sort() 로 정렬가능

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(2);
        list.add(9);
        list.add(1);

        // 두번째 인자가 없을경우 Default로 오름차순 정렬 [1, 2, 5, 9]
        Collections.sort(list);
        System.out.println(list);

        // 내림차순 [9, 5, 2, 1] 두번째 인자로 Comparator를 받음
        Collections.sort(list, new Comparator<Integer>() {

            // compare 메소드의 반환값이 양수면 swap 하는 방식
            @Override
            public int compare(Integer o1, Integer o2) {
	            /*
		            compareTo 메소드는 현재 객체가 인수 객체보다
		            큰 경우 양수
		            같은 경우 0
		            작은 경우 음수
		            반환

		            즉 내림차순으로 정렬하려면 o2 가 더 작을때
			    swap 해야 하므로 o2.compareTo(o1)
	            */
                return o2.compareTo(o1);
            }
        } );
        System.out.println(list);

        // Comparator를 lambda식으로 줄일 수 있음
        Collections.sort(list, (o1, o2) -> o2.compareTo(o1));
        System.out.println(list);
    }
}
```

- 객체배열 정렬 (Comparable을 사용한 기본 정렬)

```java
import java.util.Arrays;

class Person implements Comparable<Person> {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /*
        나이를 기준으로 오름차순 정렬
        Comparable의 compareTo 메소드를 구현하여
        정렬 순서를 직접 지정
    */
    @Override
    public int compareTo(Person other) {
        return this.age - other.age;
    }

    @Override
    public String toString() {
        return name + ": " + age;
    }
}

public class Main {
    public static void main(String[] args) {
        Person[] persons = {
                new Person("Alice", 30),
                new Person("Bob", 25),
                new Person("Charlie", 20)
        };

        // 객체의 compareTo 메소드로 정렬 수행
        Arrays.sort(persons);

        System.out.println(Arrays.toString(persons));
    }
}
```

- 객체배열 정렬 (lambda)

```java
import java.util.Arrays;
import java.util.Comparator;

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + ": " + age;
    }
}

public class Main {
    public static void main(String[] args) {
        Person[] persons = {
                new Person("Alice", 30),
                new Person("Bob", 25),
                new Person("Charlie", 20),
                new Person("Ace", 20)
        };

        // 나이 내림차순으로 정렬 (람다 표현식 사용)
        Arrays.sort(persons, (p1, p2) -> p2.age - p1.age);
        System.out.println(Arrays.toString(persons));

        // 나이 같은경우 이름 오름차순 정렬 (람다 표현식 사용)
        Arrays.sort(persons, (p1, p2) -> p1.age == p2.age ? p1.name.compareTo(p2.name) : p2.age - p1.age);
        System.out.println(Arrays.toString(persons));

        // 위와 같은 케이스 (Comparator 사용)
        Arrays.sort(persons, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                if(p1.age == p2.age) return p1.name.compareTo(p2.name);
                return p2.age - p1.age;
            }
        });
        System.out.println(Arrays.toString(persons));
    }
}
```