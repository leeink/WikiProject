# 제어흐름과 형 변환

[1. 조건에 따른 흐름](#section-1)  
[2. 반복처리](#section-2)

* * *

### <span id="section-1">1. 조건에 따른 흐름</span>

#### if
프로그래밍 언어에서 대표적으로 조건에 따른 처리를 if라는 것으로
처리한다. if문은 참이냐 거짓이냐에 따라서 분기를 나눈다.
예시로 확인해보자.

```kotlin
fun main(){
    val a: Int = 100
    val b: Int = 200
    
    if(a > b){
        println("a > b")
    }else{
        println("b > a")
    }
}
```

- if(조건식): 조건식이 참이면 실행된다.
- else: 조건식이 거짓이면 실행된다.

여기서 조건에 따른 처리에 복잡성이 추가됨에 따라 문장이 길어진다.
다음을 보자

```kotlin
fun main(){
    val a: Int = 200
    val b: Int = 200
    
    if(a > b){
        println("a > b")
    }else if(b > a){
        println("b > a")
    }else{
        println("a == b")
    }
}
```

- else if(조건식): if(조건식)이 거짓이면 실행될 문장이다.

if문은 else문과 else if문을 필수로 작성할 필요가 없고 if문만
써도 된다.

다음은 더 복잡한 조건인 경우이다.

```kotlin
fun main(){
    val a: Int = 5000
 
    
    if(a >= 300){
        println("a >= 300")
        if(a >= 500){
            println("a >= 500")
            if(a >= 5000){
                println("a >= 5000")
            }
        }
    }
}
```

이런식으로 중첩해서 조건을 확인할 수 있다. 중첩해서 쓸 때도
else와 else if를 사용해도 된다.  

if문은 단순한 문장이 아니다. 표현식이라는 것인데
문장은 대입연산자로 값을 대입하지 못하지만 식은 값을 대입하는 것이
가능하다.  

```kotlin
fun main(){
    val a: Int = 100
    val b: Int = 200
    
    val result: String = if(a > b) "a > b" else "b > a"
    println(result)
}
```

아래와 같이 대입할 값을 {}내부의 마지막에 두면 위와 같이 
값이 대입된다.

```kotlin
fun main(){
    val a: Int = 100
    val b: Int = 200

    val result: String = if(a > b) {
        println("a greater than b")
        "a > b"
    } else{
        println("b greater than a")
        "b > a"
    }
    println(result)
}
```

#### when

if는 논리타입으로 조건을 판단했지만 when은 단일값 하나로
판단한다. 예시로 보여주겠다.

```kotlin
fun main(){
    val name: String = "Kim"
    when(name){
        "Lee" -> println("User Name Lee")
        "Kim" -> println("User Name Kim")
        else -> println("No idea")
    }
}
```

when도 if처럼 식으로 사용 가능하다.

```kotlin
fun main(){
    val x: Int = 100
    val result = when(x % 2){
        0 -> "x is even"
        1 -> "x is ordinal"
        else -> "None"
    }
    println(result)
}
```

조건을 한 분기에 여러개 쓸 수 있다.

```kotlin
fun main(){
    val type: String = "Dog"
    when(type){
        "Dog", "Cat" -> println("Animal")
        "Kim", "Lee" -> println("Human")
        else -> println("None")
    }
}
```

when에 조건을 각 분기에 쓸 수 있다.

```kotlin
fun main(){
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

### <span id="section-2">2. 반복처리</span>

Kotlin에서의 반복문은 1장부터 3장까지 자주 사용해서 이미
익숙하니 못보던 구문을 소개하겠다.

```kotlin
for(num in 1..10){
    println(num)
}

for(num in 1..10 step 2){
    println(num)
}

for(num in 10 downTo 0 step 2){
    println(num)
}
```

아래는 배열에 대한 못보던 구문 예시다.

```kotlin
fun main(){
    val arr: Array<String> = arrayOf("Kim", "Lee", "Hong", "Gang")
    for(index in arr.indices){
        println("$index's player: ${arr[index]}")
    }
}
```

```kotlin
fun main(){
    val arr: Array<String> = arrayOf("Kim", "Lee", "Hong", "Gang")
    for((index, value) in arr.withIndex()){
        println("$index's player: $value")
    }
}
```

for문은 보통 정해진 횟수만큼 반복을 할 때 쓰는 구문이다.
반복횟수를 특정하지 못할 때가 있는데 그 때 쓰는 구문이
while문이다.

```kotlin
fun main(){
    val num: Int = 0
    
    while(num++){
        if(num % 2 == 0){
            continue
        }
        println(num)
        if(num > 10) break
    }
}
```

num이 10보다 커지면 break이라는 키워드로 반복문을 탈출한다.
그리고 continue라는 키워드도 보이는데 num이 짝수인 경우 다음
반복으로 넘어간다. break은 반복문을 탈출할 때 쓰는 키워드고,
continue는 다음 반복으로 넘어갈 때 쓰는 키워드이다.
해당 키워드들은 for문에서도 동일하게 사용할 수 있다.