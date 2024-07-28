### 📌 Map
> Java Collections Framework의 일부인 Interface
* 키-값 쌍을 저장하는 데이터 구조를 제공
* 각 키는 오직 하나의 값과 매핑
* 여러 구현체가 있으나 가장 많이 사용되는 것은 **HashMap**

### 📌 HashMap
> Map 인터페이스의 구현체 중 하나로, 해시 테이블을 사용하여 키-값 쌍을 저장
* 해시 테이블 기반
* 빠른 검색: 보통 O(1) 의 시간 복잡도로 데이터 검색 가능 (최악의 경우 O(n))
* 키의 중복 X (값의 중복은 O)
* 비정렬

### 📌 Code
> HashMap Test
```java
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        /* HashMap 생성 */
        Map<String, Integer> map = new HashMap<>();

        /* 데이터 추가 */
        map.put("Alice", 30);
        map.put("Bob", 30); // 값의 중복 가능
        map.put("Eve", 40);

        /* 데이터 검색 */
        System.out.println("Alice's age: " + map.get("Alice")); // 30
        System.out.println("Bob's age: " + map.get("Bob")); // 30

        /* 키와 값의 존재 여부 확인 */
        System.out.println("Contains key 'Alice': " + map.containsKey("Alice")); // true
        System.out.println("Contains value 30: " + map.containsValue(30)); // true

        /* 데이터 삭제 */
        map.remove("Bob");

        /* 데이터 개수 확인 */
        System.out.println(map.size()); // 2 (Bob 을 삭제했으므로)

        /* 중복된 키를 추가 */
        map.put("Alice", 35); // 이미 존재하는 key 인 Alice 를 추가
        System.out.println("Alice's age after update: " + map.get("Alice")); // 35
        // !!! 여기서 알 수 있는 사실은, 키는 중복적으로 추가되지 않고 기존의 해당 키가 업데이트 된다는 사실

        /* 맵의 모든 키와 값 출력 */
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        /* 맵의 크기 출력 */
        System.out.println("Map size: " + map.size()); // 3
    }
}
