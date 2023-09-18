## 목차

- [1. 문제](#문제) <br/>
  - [1.1 요구사항](#요구사항) <br/>
  - [1.2 실행결과(콘솔)](#실행결과콘솔) <br/>
- [2. 문제 해결 과정]() <br/>
  - [2.1 Input과 Output을 Interface로 구현하는 이유는?](#-input과-output을-interface로-구현하는-이유는) <br/>
  - [2.2 Enum의 if와 switch](#-enum의-if와-switch) <br/>
  - [2.3 BiFunction 인터페이스](#-bifunction-인터페이스) <br/>
    - [2.3.1 BiFunction 인터페이스의 apply 메서드](#bifunction-인터페이스의-apply-메서드) <br/>
    - [2.3.2 BiFunction 인터페이스의 andThen 메서드](#bifunction-인터페이스의-andthen-메서드) <br/>
  - [2.4 Arrays.asList](#-arraysaslist) <br/>
  - [2.5 주의할 점](#-주의할-점) <br/>

# 문제
자바 계산기 구현.

### 요구사항
- 콘솔로 구현입니다.(스윙으로 구현하시는 분들 계실까봐) 
- 객체지향적인 코드로 계산기 구현하기
    - [ ]  더하기
    - [ ]  빼기
    - [ ]  곱하기
    - [ ]  나누기
    - [ ]  우선순위(사칙연산)
- [ ]  테스트 코드 구현하기
- [ ]  계산 이력을 맵으로 데이터 저장기능 만들기
    - 애플리케이션이 동작하는 동안 데이터베이스 외에 데이터를 저장할 수 있는 방법을 고안해보세요.
- (선택) 정규식 사용

### 실행결과(콘솔)
```
1. 조회
2. 계산

선택 : 2

1 + 2
3

1. 조회
2. 계산

선택 : 2

1 + 2 * 3
7

1. 조회
2. 계산

선택 : 1

1 + 2 = 3
1 + 2 * 3 = 7

선택 : 2

3 - 2 * 2
-1
```

# 📑 문제 해결 과정

https://github.com/noxknow/Dev_practice/assets/122594223/53705a60-43d8-4f76-ab5b-50277b8843c0

## 🤔 Input과 Output을 Interface로 구현하는 이유는?

인터페이스를 사용하는 주요 이유는 추상화, 분리, 유연성, 테스트 용이성, 의존성 관리, 코드 재사용성을 향상시키기 위함. 따라서 인터페이스를 통해 Input과 Output을 정의하고 구현하는 것은 소프트웨어의 품질과 유지보수성을 향상시키는 데 도움이 된다.

**단위 테스트 용이성** : 인터페이스를 사용하면 단위 테스트를 쉽게 수행할 수 있다. Mock 객체를 사용하여 인터페이스를 구현하는 클래스의 동작을 테스트할 때 테스트 더블로 인터페이스의 메서드를 구현한 클래스를 대체할 수 있다.

**의존성 관리** : 인터페이스를 사용하면 클래스 간의 결합도를 낮출 수 있다. 즉, 클래스가 직접적으로 다른 클래스에 의존하지 않고 인터페이스에 의존함으로써 코드를 더 유연하게 관리할 수 있다.

## 🔹 Enum의 if와 switch

> **`switch`** 문은 열거형(enum) 타입의 상수를 직접 사용할 수 있지만, **`if`** 문을 사용할 때는 해당 열거형 상수를 직접 비교할 수 없다.
>

**`switch`** 문에서 열거형(enum) 상수를 사용할 수 있는 이유는 **`switch`** 문이 내부적으로 열거형 상수의 정수 값(ordinal)을 비교하기 때문이다. 각 열거형 상수는 정수 값으로 매핑되어 있으며, **`switch`** 문은 이 값을 이용하여 분기를 수행한다. 그래서 **`switch`** 문에서는 열거형 상수의 이름을 사용하여 해당 상수를 가져올 수 있다.

하지만 **`if`** 문에서는 직접 열거형 상수의 이름을 비교할 수 없다. **`if (selectedMenu == HISTORY)`**와 같은 비교는 컴파일 오류를 발생시킨다. 이런 경우에는 열거형 상수를 가져오기 위해 **`Menu.HISTORY`**와 같이 열거형의 이름과 상수 이름을 사용해야 한다.

따라서 **`if`** 문에서 **`Menu.HISTORY`**와 같이 열거형 상수를 가져오려면 해당 열거형을 import해야 한다. 이는 열거형 상수를 사용하기 위해 필요한 Java의 문법 규칙이다.

## 🔹 **BiFunction 인터페이스**

BiFunction Interface는 Java에서 함수형 프로그래밍을 구현하기 위해 Java 버전 1.8부터 도입된 함수형 인터페이스로 두 개의 매개변수를 전달받아 특정 작업을 수행 후 새로운 값을 반환하는 경우 사용됩니다.

제네릭 타입인 두 개의 인수가 존재하며, 제네릭 타입을 반환합니다.

```java
@FunctionalInterface
public interface BiFunction<T, U, R> {
  R apply(T t, U u);

  default <V> BiFunction<T, U, V> andThen(Function<? super R, ? extends V> after) {
    Objects.requireNonNull(after);
    return (T t, U u) -> after.apply(apply(t, u));
  }
}
```

BiFunction 인터페이스는 세 개의 제네릭 타입을 사용합니다.

T: 첫 번째 매개변수의 타입입니다.

U: 두 번째 매개변수의 타입입니다.

R: 반환 타입입니다.

인터페이스 내부에는 추상 메서드 apply()와 디폴트 메서드인 andThen() 메서드가 존재합니다.

람다 표현식을 사용하면 BiFunction 인터페이스의 추상 메서드를 구현하는 클래스를 정의할 필요가 없으며, BiFunction 타입의 객체에 할당된 람다 표현식은 apply() 메서드를 구현하기 위해 사용됩니다.

### **BiFunction 인터페이스의 apply 메서드**

apply() 메서드는 제네릭 타입인 두 개의 매개변수를 전달받아 특정 작업을 수행 후 값을 반환합니다.

```java
R apply(T t, U u);
```

다음 예제는 apply() 메서드 사용 방법입니다.

먼저, 세 개의 BiFunction 타입의 객체를 생성하며 특정 로직을 수행하는 람다 표현식을 할당합니다.

- biFunctionAdd 객체는 Integer 타입의 두 개의 매개변수를 전달받아 더한 결과를 문자열로 반환합니다.
- biFunctionMinus 객체는 Integer 타입의 두 개의 매개변수를 전달받아 뺄셈 결과를 문자열로 반환합니다.
- biFunctionMultiple 객체는 Integer 타입의 두 개의 매개변수를 전달받아 곱한 결과를 문자열로 반환합니다.

```java
public static void main(String args[]) {
  BiFunction<Integer, Integer, String> biFunctionAdd =
          (num1, num2) ->  Integer.toString(num1 + num2);

  BiFunction<Integer, Integer, String> biFunctionMinus =
          (num1, num2) -> Integer.toString(num1 - num2);

  BiFunction<Integer, Integer, String> biFunctionMultiple =
          (num1, num2) -> Integer.toString(num1 * num2);

  System.out.println("100 + 50 = " + biFunctionAdd.apply(100, 50));
  System.out.println("100 - 50 = " + biFunctionMinus.apply(100, 50));
  System.out.println("100 * 50 = " + biFunctionMultiple.apply(100, 50));
}
```

[실행 결과]

```html
100 + 50 = 150
100 - 50 = 50
100 * 50 = 5000
```

---

### **BiFunction 인터페이스의 andThen 메서드**

apply() 메서드 실행 후 반환 결과에 대해 특정 작업이 필요한 경우 해당 로직을 andThen() 메서드에 전달합니다.

매개변수로 전달되는 함수는 BiFunction 타입이 아니라 Function 타입이어야 합니다.

다음 예제는 apply() 메서드 반환 결과를 andThen() 메서드를 사용하여 문자열을 병합합니다.

```java
public static void main(String args[]) {
  BiFunction<Integer, Integer, String> biFunctionAdd =
          (num1, num2) ->  Integer.toString(num1 + num2);
  biFunctionAdd = biFunctionAdd.andThen(result -> "biFunctionAdd Result: " + result);

  BiFunction<Integer, Integer, String> biFunctionMinus =
          (num1, num2) -> Integer.toString(num1 - num2);
  biFunctionMinus = biFunctionMinus.andThen(result -> "biFunctionMinus Result: " + result);

  BiFunction<Integer, Integer, String> biFunctionMultiple =
          (num1, num2) -> Integer.toString(num1 * num2);
  biFunctionMultiple = biFunctionMultiple.andThen(result -> "biFunctionMultiple Result: " + result);

  System.out.println(biFunctionAdd.apply(100, 50));
  System.out.println(biFunctionMinus.apply(100, 50));
  System.out.println(biFunctionMultiple.apply(100, 50));
}
```

[실행 결과]

```html
biFunctionAdd Result: 150
biFunctionMinus Result: 50
biFunctionMultiple Result: 5000
```

## 🔹 Arrays.asList

일반 배열을 ArrayList로 변환한다.

`List<String> list = Arrays.asList(arr);`

Arrays.asList()는 Arrays의 private 정적 클래스인 ArrayList를 리턴한다. **java.util.ArrayList 클래스와는 다른 클래스**이다.

java.util.Arrays.ArrayList 클래스는 set(), get(), contains() 메서드를 가지고 있지만 **원소를 추가하는 메서드는 가지고 있지 않기 때문에 사이즈를 바꿀 수 없다.**

```java
package Test;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
 
 
public class TestArrayAsList {
   public static void main(String[] args) {
      String[] strs = {"alpha", "beta", "charlie"};
      System.out.println(Arrays.toString(strs));   // [alpha, beta, charlie]
 
      List<String> lst = Arrays.asList(strs); // new ArrayList<String>(); 대신에 사용
      System.out.println(lst);  // [alpha, beta, charlie]
 
      lst.add("ttt");     // error : asList()로 List를 생성하면 원소를 새롭게 추가할 수 없음
 
      // Changes in array or list write thru
      strs[0] += "88";
      lst.set(2, lst.get(2) + "99"); // 2번째 인덱스 원소에 charlie99 넣음
      System.out.println(Arrays.toString(strs)); // [alpha88, beta, charlie99]
      System.out.println(lst);  // [alpha88, beta, charlie99]
 
      // Initialize a list using an array
      List<Integer> lstInt = Arrays.asList(22, 44, 11, 33);
      System.out.println(lstInt);  // [22, 44, 11, 33]
   }
}
```

---

위에 소스를 보면 lst에 담겨있는 두 번째 인덱스에 데이터를 수정했는데 **원본 배열의 데이터까지 변경이 됐다.**

List는 내부 구조가 배열로 만들어져 있다. 따라서 asList()를 사용해서 반환되는 List도 배열을 갖게 된다. 이때, asList()를 사용해서 List 객체를 만들 때 새로운 배열 객체를 만드는 것이 아니라, **원본 배열의 주소값**을 가져오게 된다.

따라서 asList()를 사용해서 내용을 수정하면 원본 배열도 함께 바뀌게 되고, 원본 배열을 수정하면 그 배열로 만들어뒀던 asList()를 이용한 List 내용도 바뀌게 된다.

이러한 이유 때문에 Arrays.asList()로 만든 List에 새로운 원소를 추가하거나 삭제 할 수 없다.따라서 Arrays.asList()는 배열의 내용을 수정하려고 할 때 List로 바꿔서 편리하게 사용하기 위함.

→

1. **일관성과 통일성 유지**: **`List`** 인터페이스는 배열과 유사한 작업을 수행할 수 있는 메서드를 제공한다. 예를 들어 **`get`**, **`set`**, **`size`** 등의 메서드를 사용하여 배열과 `List`를 일관되게 다룰 수 있습니다. 이로써 코드의 일관성을 유지하고 유지보수를 단순화할 수 있습니다.
2. **컬렉션 라이브러리 활용**: **`List`** 인터페이스를 구현한 컬렉션 클래스(예: **`ArrayList`**, **`LinkedList`**)는 배열보다 풍부한 기능을 제공.
3. **호환성**: 기존의 배열 기반 코드를 컬렉션 기반 코드로 쉽게 이전할 수 있도록 한다. 이렇게 하면 코드의 유지보수가 더 쉬워지고 새로운 기능을 추가하기도 용이해진다.

---

만약, **진짜 ArrayList를 받기 위해서는 다음과 같이 변환하면 된다.**

ArrayList 생성자는 **java.util.Arrays.ArrayList의 상위(super) 클래스인 Collection Type도 받아들일 수 있다.**

`List<String> lst = new ArrayList<String>(Arrays.asList(strs));`

```java
package Test;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
 
 
public class TestArrayAsList {
   public static void main(String[] args) {
      String[] strs = {"alpha", "beta", "charlie"};
      System.out.println(Arrays.toString(strs));   // [alpha, beta, charlie]
 
      List<String> lst = new ArrayList<String>(Arrays.asList(strs)); 
      System.out.println(lst);  // [alpha, beta, charlie]
 
      lst.add("ttt");     // 이제는 에러가 나지 않고 데이터를 추가 시킬 수 있다.
 
      // Changes in array or list write thru
      strs[0] += "88";
      lst.set(2, lst.get(2) + "99"); // 2번째 인덱스 원소에 charlie99 넣음
      System.out.println(Arrays.toString(strs)); // [alpha88, beta, charlie]
      System.out.println(lst);  // [alpha, beta, charlie99, ttt]
 
      // Initialize a list using an array
      List<Integer> lstInt = Arrays.asList(22, 44, 11, 33);
      System.out.println(lstInt);  // [22, 44, 11, 33]
   }
}
```

이제는 원본 배열과 lst 객체에 담겨있는 배열 데이터는 별개의 주소값이라고 보면 된다.

## 🚧 주의할 점

아래와 같은 상황에 처음의 stack.pop()에 firstNumber를 붙여주게 된다면 "-" 의 상황에서 잘못된 값이 나오게 된다. 
이유는 pop() 메서드의 경우 마지막 값이 먼저 나오게 되는데 이렇게 된다면 뒤에서 앞의 값을 "-"하는 상황이 나오기 때문에 주의해야 한다.

```java
@Override
public long calculate(List<String> postfix) {

        Stack<Long> stack = new Stack<>();
        for (String token : postfix) {
            if (token.matches(pattern)) {
                stack.push(Long.parseLong(token));
            } else {
                long secondNumber = stack.pop(); // pop의 경우 나중에 들어온 것 부터 나오기 때문에 second가 먼저 나온다.
                long firstNumber = stack.pop();
                Operator operator = Operator.getOperator(token);

                stack.push(operator.calculate(firstNumber, secondNumber));
            }
        }

        return stack.pop();
}
```
