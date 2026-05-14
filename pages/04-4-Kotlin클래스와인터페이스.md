## 클래스(Class)와 인터페이스(Interface)

[1. 사용자 정의 타입](#1-사용자-정의-타입)
[2. 인터페이스](#2-인터페이스)
[3. 열거형과 데이터 클래스](#3-열거형과-데이터-클래스)
[4. 연산자 오버로딩](#4-연산자-오버로딩)

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