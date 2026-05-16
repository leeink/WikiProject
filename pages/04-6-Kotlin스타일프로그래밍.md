## 코틀린 스타일 프로그래밍

[1. null처리](#1-null처리)
[2. scope function](#2-scope-function)

* * *

### 1. null처리

이전 장에서 본 것처럼 예외처리를 간편하게 할 수 있는 것은
코틀린에서 많은 기능을 제공하기 때문이다. 대표적으로 보일 수 있는
예시가 null값 처리이다.

고전적인 null값 처리

```kotlin
fun main() {
    val value: Int? = null

    if(value != null){
        println("null이 아님")
    }else{
        println("null값")
    }
}
```

코틀린에서는 간편하게 처리할 수 있다.

```kotlin
fun main() {
    val value: Int? = null
    value ?: println("null값")
}
```

더 범용적인 예시를 들기 위해 클래스들을 만든다.

```kotlin
class Identity(id: Int){
    fun info(){
        println("print info")
    }
}

class Person(val name: String){
    val id: Identity? = null
}
```

다음은 고전적인 방식이다.

```kotlin
fun main() {
    val person: Person? = Person("John")

    if(person != null){
        if(person.id != null){
            person.id.info()
        }
    }
}
```

다음은 코틀린 스타일이다.

```kotlin
fun main() {
    val person: Person? = Person("John")
    person?.id?.info()
}
```

중간에 `?.`이 붙어 있는데 `nullable`이 프로퍼티나 함수를 호출할 경우에
사용 하는 것이다. 만약 null값이면 이후 호출은 실행이 되지 않는다.


값을 초기화할 때 null값일 수 있는 값에 대해 대처할 수 있는 연산자가
있는데 `?:`(엘비스 연산자)가 있다. 


```kotlin
fun main() {
    val value: Int? = null
    val result = value ?: 1
    println(result)
}
```

이런식으로 null값일 경우에 기본값을 대입하게 할 수도 있다.
`nullable`에서 호출할 때 null값이 아님을 단언할 수도 있다.
그 연산자는 `!!`이다. 이 연산자는 프로그래머 본인이 그 시점에
null이 아님을 단언하는 경우에 사용한다.

```kotlin
fun main() {
    val nullableName: String? = "Kotlin"
    val name: String = nullableName!!
    println(name)
}
```


### 2. scope function

특정 목적에 따라 유용하게 사용하는 함수들이 있는데 코틀린에서는
다음과 같은 함수들을 제공한다.

| 함수      | 참조 객체  | 반환값     | 확장함수 여부 |
|---------|--------|---------|---------|
| `let`   | `it`   | 람다의 결과  | 확장함수    |
| `run`   | `this` | 람다의 결과  | 확장함수    |
| `run`   | -      | 람다의 결과  | x       |
| `with`  | `this` | 람다의 결과  | x       |
| `apply` | `this` | 컨텍스트 객체 | 확장함수    |
| `also`  | `it`   | 컨텍스트 객체 | 확장함수    |

#### let

컨텍스트 객체를 `it`으로 참조하고 람다의 마지막 값을 반환한다.
보통은 null safe 처리와 결과 변환이 주요 사용 목적이다.

```kotlin
val name: String? = "Kotlin"
 
val length = name?.let {
    println("이름: $it")   
    it.length             
}
println(length)
```

연쇄적으로 호출할 수도 있는데 이를 메서드 체이닝이라고도 한다.

```kotlin
val result = "  hello  "
    .let { it.trim() }
    .let { it.uppercase() }
// result = "HELLO"
```

#### run

컨텍스트 객체를 `this`로 참조하고 람다의 마지막 값을 반환한다.
확장 함수 형태와 단독 형태 두 가지로 사용할 수 있다.

```kotlin
val result = StringBuilder().run {
    append("Hello")    
    append(", Kotlin")
    toString()         
}
println(result)
```

확장 함수 없이 단독으로도 사용 가능하다.

```kotlin
val isValid = run {
    val a = 10
    val b = 20
    a + b > 25
}
```

#### with

컨텍스트 객체를 `this`로 참조하고 람다의 마지막 값을 반환한다.
확장 함수가 아닌 일반 함수이므로 객체를 인자로 넘긴다.
null이 아닌 것이 분명한 객체에 여러 함수를 묶어 호출할 때 쓴다.

```kotlin
val person = Person(name = "Kim", age = 25)
 
val intro = with(person) {
    println(name)   
    println(age)
    "이름: $name, 나이: $age"   
}
```

nullable 객체에는 `?.run`이 더 적합하다.


#### apply

컨텍스트 객체를 `this`로 참조하고 객체 자신을 반환한다.
객체를 생성하면서 프로퍼티를 설정하는 빌더 패턴에 가장 잘 맞는다.

```kotlin
val person = Person("", 0).apply {
    name = "Lee"   
    age = 30
}

```

Android에서 View를 설정할 때 자주 쓰인다.

```kotlin
val textView = TextView(context).apply {
    text = "Hello"
    textSize = 16f
    setTextColor(Color.BLACK)
}
```

#### also

컨텍스트 객체를 `it`으로 참조하고 객체 자신을 반환한다.
체이닝 흐름을 끊지 않으면서 로그를 찍거나 검증을 추가할 때 쓴다.

```kotlin
val numbers = mutableListOf(1, 2, 3)
    .also { println("초기 리스트: $it") }
 
numbers.add(4)
```

#### 선택 기준

| 목적                  | 사용할 함수 |
|---------------------|------------|
| null 체크, 결과 변환      | `let`      |
| 초기화 + 연산 결과 필요      | `run`      |
| null아닌 객체에 함수 묶음 호출 | `with`    |
| 객체 프로퍼티 설정 (빌더)     | `apply`    |
| 체인 중간 부가 작업 (로그/검증) | `also`   |

`apply`와 `also`는 객체를 반환하기 때문에 메서드 체이닝에 자연스럽게 끼워 넣을 수 있다.
`let`, `run`, `with`는 연산 결과를 반환하기 때문에 값을 변환하거나 계산할 때 쓴다.