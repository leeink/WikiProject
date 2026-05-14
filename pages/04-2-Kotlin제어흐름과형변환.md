## 제어흐름과 형 변환

[1. 조건에 따른 흐름](#1-조건에-따른-흐름)
[2. 형 변환(Type Casting)](#2-형-변환type-casting)
[3. 반복처리](#3-반복처리)

* * *

### 1. 조건에 따른 흐름

#### if

프로그래밍 언어에서 대표적으로 조건에 따른 처리를 `if`라는 것으로
처리한다. `if`문은 참이냐 거짓이냐에 따라서 분기를 나눈다.
예시로 확인해보자.

```kotlin
fun main() {
    val a: Int = 100
    val b: Int = 200

    if (a > b) {
        println("a > b")
    } else {
        println("b > a")
    }
}
```

- `if(조건식)`: 조건식이 참이면 실행된다.
- `else`: 조건식이 거짓이면 실행된다.

여기서 조건에 따른 처리에 복잡성이 추가됨에 따라 문장이 길어진다.
다음을 보자.

```kotlin
fun main() {
    val a: Int = 200
    val b: Int = 200

    if (a > b) {
        println("a > b")
    } else if (b > a) {
        println("b > a")
    } else {
        println("a == b")
    }
}
```

- `else if(조건식)`: `if(조건식)`이 거짓이면 실행될 문장이다.

`if`문은 `else`문과 `else if`문을 필수로 작성할 필요가 없고 `if`문만
써도 된다.

다음은 더 복잡한 조건인 경우이다.

```kotlin
fun main() {
    val a: Int = 5000

    if (a >= 300) {
        println("a >= 300")
        if (a >= 500) {
            println("a >= 500")
            if (a >= 5000) {
                println("a >= 5000")
            }
        }
    }
}
```

이런 식으로 중첩해서 조건을 확인할 수 있다. 중첩해서 쓸 때도
`else`와 `else if`를 사용해도 된다.

`if`문은 단순한 문장이 아니다. 표현식이라는 것인데
문장은 대입 연산자로 값을 대입하지 못하지만 식은 값을 대입하는 것이
가능하다.

```kotlin
fun main() {
    val a: Int = 100
    val b: Int = 200

    val result: String = if (a > b) "a > b" else "b > a"
    println(result)
}
```

아래와 같이 대입할 값을 `{}` 내부의 마지막에 두면 위와 같이
값이 대입된다.

```kotlin
fun main() {
    val a: Int = 100
    val b: Int = 200

    val result: String = if (a > b) {
        println("a greater than b")
        "a > b"
    } else {
        println("b greater than a")
        "b > a"
    }
    println(result)
}
```

#### when

`if`는 논리 타입으로 조건을 판단했지만 `when`은 단일 값 하나로
판단한다. 예시로 보여주겠다.

```kotlin
fun main() {
    val name: String = "Kim"
    when (name) {
        "Lee" -> println("User Name Lee")
        "Kim" -> println("User Name Kim")
        else -> println("No idea")
    }
}
```

`when`도 `if`처럼 식으로 사용 가능하다.

```kotlin
fun main() {
    val x: Int = 100
    val result = when (x % 2) {
        0 -> "x is even"
        1 -> "x is ordinal"
        else -> "None"
    }
    println(result)
}
```

조건을 한 분기에 여러 개 쓸 수 있다.

```kotlin
fun main() {
    val type: String = "Dog"
    when (type) {
        "Dog", "Cat" -> println("Animal")
        "Kim", "Lee" -> println("Human")
        else -> println("None")
    }
}
```

`when`에 조건을 각 분기에 쓸 수 있다.

```kotlin
fun main() {
    val score = 80
    val grade = when {
        score >= 90 -> "A"
        score >= 80 -> "B"
        score >= 70 -> "C"
        score >= 60 -> "D"
        else        -> "F"
    }
    println(grade)
}
```

### 2. 형 변환(Type Casting)

타입 캐스팅은 다른 타입으로 변환하는 것이다.
숫자를 문자 또는 문자열로, 문자 또는 문자열을 숫자로,
같은 숫자이지만 정수를 실수로, 실수를 정수로 등
형 변환을 할 수 있다.

코틀린은 어떤 타입으로 변환할지를 명시해야 한다.

```kotlin
val a: Int = 100

val b: Long   = a.toLong()
val c: Double = a.toDouble()
val d: Float  = a.toFloat()
val e: Short  = a.toShort()
val f: Byte   = a.toByte()
val g: String = a.toString()
```

```kotlin
val str = "100"

val a = str.toInt()
val b = str.toLong()
val c = str.toDouble()
val d = str.toFloat()
```

변환을 안전하게 하려면 `toIntOrNull()` 같은 함수를 사용한다.

```kotlin
val a = "123".toIntOrNull()
val b = "abc".toIntOrNull()
val c = "12.3".toIntOrNull()

val result = "abc".toIntOrNull() ?: 0
```

타입이 어떤 타입인지 체크하고 싶을 때가 있는데
코틀린은 타입 체크를 하면 자동으로 캐스팅을 해주는 기능이 있다.
스마트 캐스트라는 것이다.

```kotlin
fun main() {
    val data: Any = "string"
    if (data is String) {
        println(data.length)
    }
}
```

`Any` 타입이어서 원래는 `length`가 호출이 안 되어야 하지만
스마트 캐스팅이 되어 `data.length`가 정상 실행된다.

명시적으로 타입을 변환하는 방법이 하나 더 있는데 다음 예시와 같다.

```kotlin
fun main() {
    val data: Any = "12345"

    val number = data as Int
    val string = data as String
    val bool = data as Boolean // Error

    val number2 = data as? Int
    val string2 = data as? String
    val bool2 = data as? Boolean // null
}
```

`as`를 쓰면 캐스팅 실패 시 에러가 나지만 `as?`를 쓰면 null을
반환한다.

### 3. 반복처리

Kotlin에서의 반복문은 1장부터 3장까지 자주 사용해서 이미
익숙하니 못 보던 구문을 소개하겠다.

```kotlin
for (num in 1..10) {
    println(num)
}

for (num in 1..10 step 2) {
    println(num)
}

for (num in 10 downTo 0 step 2) {
    println(num)
}
```

아래는 배열에 대한 못 보던 구문 예시다.

```kotlin
fun main() {
    val arr: Array<String> = arrayOf("Kim", "Lee", "Hong", "Gang")
    for (index in arr.indices) {
        println("$index's player: ${arr[index]}")
    }
}
```

```kotlin
fun main() {
    val arr: Array<String> = arrayOf("Kim", "Lee", "Hong", "Gang")
    for ((index, value) in arr.withIndex()) {
        println("$index's player: $value")
    }
}
```

`for`문은 보통 정해진 횟수만큼 반복을 할 때 쓰는 구문이다.
반복 횟수를 특정하지 못할 때가 있는데 그때 쓰는 구문이
`while`문이다.

```kotlin
fun main() {
    var num: Int = 0

    while (num++ < 10) {
        if (num % 2 == 0) {
            continue
        }
        println(num)
        if (num > 10) break
    }
}
```

`num`이 10보다 커지면 `break`이라는 키워드로 반복문을 탈출한다.
그리고 `continue`라는 키워드도 보이는데 `num`이 짝수인 경우 다음
반복으로 넘어간다. `break`은 반복문을 탈출할 때 쓰는 키워드고,
`continue`는 다음 반복으로 넘어갈 때 쓰는 키워드이다.
해당 키워드들은 `for`문에서도 동일하게 사용할 수 있다.