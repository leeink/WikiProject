## 클래스(Class)와 인터페이스(Interface)

[1. 사용자 정의 타입](#1-사용자-정의-타입)  
[2. 인터페이스](#2-인터페이스)  
[3. 열거형과 데이터 클래스](#3-열거형과-데이터-클래스)  
[4. 연산자 오버로딩](#4-연산자-오버로딩)
[5. 컬렉션과 제네릭](#5-컬렉션과-제네릭)

* * *

### 1. 사용자 정의 타입

클래스란 사용자가 타입을 정의해서 사용하는 것이다. 이에 관해서
용어가 몇 가지 있다.

- 클래스: 타입이 어떻게 정의되어 있는지
- 인스턴스: 클래스가 프로그램 실행 시 메모리에 적재된 상태 또는 적재하는 행동
- 객체: 인스턴스된 클래스

특히 인스턴스는 맥락에 따라 이해해야 한다. 명사로 쓸 때도 있고
동사의 의미로 쓸 때도 있다.

코틀린에서 클래스는 다음과 같이 정의하고 사용할 수 있다.

```kotlin
class Person(
    val name: String,
    var age: Int,
) {
    init {
        println("Person Instantiate!")
    }

    public fun introduce(introduce: String) {
        printString(introduce)
    }

    private fun printString(printString: String) {
        println(printString)
    }
}

fun main() {
    val person: Person = Person(name = "Lee", age = 21)
    println(person.name)
    println(person.age)

    person.introduce("Hi my Name is Lee")
    person.printString("Hi my Name is Lee") // Error
}
```

(상속 여부) class (타입 이름)(매개변수들): (상속받을 클래스) { 클래스 본문 }

- `class (클래스 이름)(매개변수들)`: 클래스 헤더
- `{ 클래스 본문 }`: 클래스 몸체

클래스 헤더의 매개변수들을 입력하면 클래스의 속성을 선언할 수 있다.
클래스의 속성(프로퍼티)은 클래스가 가진 특징, 정보 같은 거라고 이해하면 된다.

클래스 몸체에는 클래스의 멤버들이 있는데 클래스를 이루는
요소들이라고 생각하면 된다. 그 요소들은 함수, `init`, 프로퍼티, 보조 생성자
등이 있다.

생성자라는 것이 있는데 코틀린에서 생성자는 외부에서 값을 받아들이는 역할을 한다.

매개변수들이 있는 영역이 주 생성자라는 것이고,
보조 생성자는 클래스 몸체 안에 있다.

클래스가 인스턴스될 때
주 생성자 → init → 보조 생성자 순서로 실행이 된다.

```kotlin
public fun introduce(introduce: String) {
    printString(introduce)
}

private fun printString(printString: String) {
    println(printString)
}
```

여기서 보면 `public`과 `private`라는 키워드가 있다. 클래스의 멤버에
접근을 제한하는 키워드이다.

- `public`: `person.introduce` 형식으로 클래스 외부에서 접근 가능하다.
- `protected`: 상속받은 클래스만 접근이 가능하다.
- `private`: 클래스 외부에서 접근이 불가능하다.

위 예제에서 `introduce` 함수는 클래스 외부에서 호출이 가능하지만
`printString` 함수는 무조건 클래스 내부에서만 호출이 가능하다.

클래스는 상속이라는 것이 가능한데 상속은 말 그대로 물려주는 것이다.
코틀린에서 상속은 프로퍼티, 함수들 모두 상속이 가능한데
상속을 제한할 수도 있다. `open`이라는 키워드를 사용해서
상속이 가능하게 하고 아무것도 쓰지 않으면 기본적으로 `final`
키워드가 자동으로 붙는다고 보면 된다. `final` 키워드는
상속이 불가능하게 하는 키워드이다.

상속에는 오버라이딩이라는 개념이 있다. 재작성이라는 의미인데
상속받은 것들을 재작성한다는 것이다. 상속을 받을 클래스가
자식 클래스이고 상속을 줄 클래스가 부모 클래스라면
부모 클래스에서 작성한 함수의 기능을 자식 클래스에서 전혀 다른
기능으로 만들 수 있다는 의미이다.

```kotlin
open class Person(
    val name: String,
    val age: Int
) {
    init {
        println("Person Instantiate!")
    }

    open fun introduce(introduce: String) {
        printString(introduce)
    }

    private fun printString(printString: String) {
        println(printString)
    }
}

class Kim(
    name: String,
    age: Int
) : Person(name, age) {
    init {
        println("Kim Instantiate!")
    }

    override fun introduce(introduce: String) {
        super.introduce(introduce)
        println("Child Introduce!")
    }
}

fun main() {
    val kim = Kim(name = "Kim", age = 25)
    println(kim.name)
    println(kim.age)

    kim.introduce("Hi my Name is Kim")
}
```

여기서 주목할 부분은 `private`으로 선언한 함수는 상속이 안 된다.
그리고 자식 클래스에서 속성을 선언할 때 `val` 키워드를 쓰지 않는다.
오버라이드를 할 때 `override`라는 키워드를 사용하여 오버라이드한다.
`super.introduce(introduce)`라는 것을 볼 수 있는데
`super`는 부모 클래스를 의미하고, `super.introduce`는 부모 클래스의
`introduce` 함수를 호출하겠다는 의미이다.

그다음 주목할 부분은 실행 결과이다.  
부모 클래스와 자식 클래스 모두 `init`이 구현되어 있다.
그리고 `main` 함수에서 분명 `Kim` 클래스만 인스턴스되었는데
실행 시 가장 먼저 `Person` 클래스의 `init` 블록이 수행되었다.

클래스 인스턴스 시 부모 클래스가 있다면 부모 클래스도 같이
인스턴스된다는 것을 알 수 있는 부분이다. 단지 컴퓨터 메모리에
여러 곳에 나뉘어 인스턴스되는 것이 아닌 한 군데에 같이 적재된다는
것이다.

마지막으로 코틀린 클래스는 상속을 하나의 클래스만 받을 수 있다.
한 번에 여러 개의 클래스를 상속받을 수 없다.

### 2. 인터페이스

인터페이스는 프로그램 구조를 유연하게 할 수 있는 좋은 개념이다.
클래스를 본체라고 한다면 그 행위를 정의하게 할 수 있는 것이
인터페이스이다. 클래스는 다른 클래스를 한 번에 하나만 상속받을 수
있지만 인터페이스는 여러 개 상속받아도 무관하다.

클래스에는 추상 클래스라는 개념이 있는데 인터페이스는
그 어떠한 구현도 하지 않은 함수만 선언되어 있는 추상 클래스이다.

```kotlin
interface LegBehaviour {
    fun walk()
    fun run()
}

interface HandBehaviour {
    fun grip()
    fun throwing()
}

class Person(val name: String, val age: Int) : LegBehaviour, HandBehaviour {
    init {
        println("Person Instantiate!")
    }

    open fun introduce(introduce: String) {
        printString(introduce)
    }

    private fun printString(printString: String) {
        println(printString)
    }

    override fun walk() {
        println("Walk")
    }
    override fun run() {
        println("Run")
    }
    override fun grip() {
        println("Grip")
    }
    override fun throwing() {
        println("Throwing")
    }
}

fun main() {
    val person: Person = Person(name = "Kim", age = 25)
    println(person.name)
    println(person.age)

    person.walk()
    person.run()
    person.grip()
    person.throwing()
}
```

여기서 인터페이스를 추가로 만들고 상속을 더 해도 문제가 없다.

### 3. 열거형과 데이터 클래스

열거형이라는 것이 있는데 보통 상태 같은 것을 표현할 때 쓴다.

```kotlin
enum class Status {
    WAIT, RUN, BLOCK
}

fun main() {
    val status: Status = Status.WAIT
    when (status) {
        Status.WAIT -> println("Wait")
        Status.RUN -> println("Run")
        Status.BLOCK -> println("Block")
        else -> println("Nothing")
    }
}
```

열거형은 이런 식으로 활용이 가능하다.

데이터 클래스는 클래스와는 다르게 데이터 저장 용도로만 사용하는
클래스이다. 별도의 함수로 처리할 수 있는 행위가 필요하지 않다.

```kotlin
data class Point(
    val x: Int,
    val y: Int
)
```

### 4. 연산자 오버로딩

오버로딩이란 같은 이름으로 정의한 것을 다른 이름의 매개변수나 타입으로
선언하는 것인데 연산자 오버로딩은 의미가 좀 다르다.

연산자 오버로딩은 사용자 정의 타입(클래스)에도 `+`, `-`, `*` 같은
연산자를 사용할 수 있게 하는 것이다. 예시를 보면서 알아보자.

```kotlin
data class Point(val x: Int, val y: Int) : Comparable<Point> {
    operator fun plus(other: Point): Point {
        return Point(x + other.x, y + other.y)
    }

    operator fun minus(other: Point): Point {
        return Point(x - other.x, y - other.y)
    }

    override operator fun compareTo(other: Point): Int {
        val thisDist  = x * x + y * y
        val otherDist = other.x * other.x + other.y * other.y
        return thisDist - otherDist
    }
}

fun main() {
    val p1 = Point(1, 2)
    val p2 = Point(3, 4)

    println(p1 + p2)
    println(p1 - p2)
    println(p1 > p2)
    println(p1 < p2)
}
```

함수로 연산자 오버로딩을 적용해야 하는데 `+`는 `plus`, `-`는 `minus` 등
다른 연산자들도 프로그래머가 직접 설정할 수 있다.
클래스도 대소 비교를 할 수 있게 할 수 있는데 `Comparable<T>`를 상속받으면
대소 비교도 할 수 있다.


### 5. 컬렉션과 제네릭

컬렉션은 자주 사용하는 자료구조를 미리 만들어 놓은 것들이다.
코틀린에서 제공하는 컬렉션은 네 가지가 있는데 기본적인 자료구조에
대한 이해가 있다면 어떤 상황에 어떤 것을 써야할 지 판단이 될 것이다.

- `List`: 배열처럼 쓰는 자료구조(단 배열과 완전히 같지 않음)
- `Set`: 중복값 허용이 안되는 자료구조
- `Map`: 키-값 형태의 자료구조
- `ArrayDeque`: `List`는 값을 삽입 삭제할 때 한 쪽 에서만 가능하지만
이 컬렉션은 양쪽에서 가능하다.

보통 사용할 때 `List<T>` 나 `ArrayDequeue<T>`처럼 쓴다.
여기서 <T>는 데이터 타입을 가리킨다.

```kotlin
val sampleList: List<Int> = listOf(1, 2, 3)
sampleList.forEach{ it -> 
    println(it)
}
```

직접 정의한 클래스도 사용 가능하다.

```kotlin
data class Person(val name: String, val age: Int)

val personList: List<Person> = listOf(
    Person("Alice", 29),
    Person("Bob", 31),
)
personList.forEach { println(it) }
```


클래스를 정의할 때 다음과 같은 좌표 클래스를 만들었다고 하자.

```kotlin
data class Point(var x: Int, var y: Int)
```

그런데 좌표를 표현할 때 정수만 표현하는 것이 아닌 실수도 표현하고 싶을 때가
있다. 정수 좌표를 표현할 때와 실수 좌표를 표현하는 데 있어서
하나의 클래스만으로 처리가 가능할까? 가능하다. 답은 이미 위에서 컬렉션의 종류를
살펴볼 때 알 수 있었다.


```kotlin
data class Point<T>(var x: T, var y: T)

val integerPoint: List<Point<Int>> = listOf(
    Point(10, 10),
    Point(10, 20),
)

val doublePoint: List<Point<Double>> = listOf(
    Point(10.12, 20.32),
    Point(7.73, 50.90),
)

for(num in 0..<integerPoint.size){
    println("${integerPoint[num]}, ${doublePoint[num]}")
}
```

데이터 타입을 꼭 하나만 쓸 수 있는 것은 아니다. 다음과 같이 쓸 수도 있다.

```kotlin
data class OtherPoint<T, K>(var x: T, var y: K)

val otherPoint: List<OtherPoint<Int, Double>> = listOf(
    OtherPoint(1, 2.123),
)
```

**제네릭**은 타입을 미리 지정하지 않고 사용하는 것이다. 제네릭을 활용하면
동일한 사용 목적을 가진 클래스에 대해 여러 데이터 타입을 적용하여
사용할 수 있다.