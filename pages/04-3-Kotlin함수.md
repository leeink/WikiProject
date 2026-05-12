## 코틀린의 기본 문법

[1. 함수](#section-1)  
[2. 람다](#section-2)

* * *

### <span id="section-1">1. 함수</span>

프로그래밍에서는 프로시저라는 것이 있는데
프로시저란 특정 작업을 수행하기 위한 일련의 절차를 명령어로 기술한
것이다. 함수란 특정 작업을 수행한 결과를 반환하는 것이다.
우리가 지금까지 흔히 써왔던 main과 print, println도 함수다.

저 두 개념적인 내용을 프로그래밍 언어에서는 함수로 구현한다.

함수를 만드는 방법은 다음과 같다.

fun (함수이름) (매개변수들): 반환타입{
    함수 본문
}

- fun (함수이름) (매개변수들): 반환타입: 함수 헤더
- { 함수 본문 }: 함수 몸체

프로그래밍 언어에서 함수는 꼭 값을 반환할 필요가 없고 작업만
수행하고 끝내도 되고 값을 반환해도 된다.

```kotlin
fun main(){
    printStringFunction()
    val result = calculateFunction(10, 10)
    println(result)
}

fun printStringFunction(){
    println("Print Function")
}

fun calculateFunction(a : Int, b: Int): Int{
    return a + b
}
```

이전 장, 절들에서 함수를 호출하는 다른 방법이 있는데
.함수이름() 이런식으로도 호출한다.

```kotlin
fun main() {
    val charArr: CharArray = "String to CharArray".toCharArray()
    for(c in charArr){
        println(c)
    }
}
```

위 예시는 String에 내장된 함수를 호출하는 예시이다.
.함수이름()은 멤버함수인 경우에만 이와 같은 방식으로
함수 호출이 가능하다.

매개변수는 함수를 호출할 때 전달되는데 매개변수를 따로
명시하지 않아도 전달할 수 있는 방법이 있는데 이를 기본 매개변수
라고 한다.

```kotlin
fun printStringFunction(val printString: String = "Print Function"){
    println(printString)
}
```

이러고 함수 호출을 할 때 매개변수를 전달하지 않아도
기본 매개변수로 정한 값으로 출력이 된다.

### <span id="section-2">1. 람다</span>

람다(lambda)는 위 섹션에서 설명한 대로 함수를 만드는 것이 아닌
일회성으로만 사용할 명령문 모음을 만드는 거다. 일회성으로 사용하는
코드들은 보통 코드를 정돈하지 않고 쓰는 경우가 있는데 코드가
길어질 경우 정돈하고 쓰는 게 가독성이 좋은 경우가 많다. 이 때
람다가 유용해진다.

이전 장에서 람다를 사용한 적이 있는데 다음 예시와 같다.

```kotlin
TextButton(onClick = {},
    modifier = Modifier
        .width(200.dp)
        .clip(RoundedCornerShape(50))
        .background(MaterialTheme.colorScheme.primary)
)
```

onClick 매개변수에 {}가 들어가 있는데 이는 다음과 같은 이유
때문이다.

```kotlin
@Composable
@ComposableInferredTarget
public fun TextButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = ButtonDefaults.textShape,
    colors: ButtonColors = ButtonDefaults.textButtonColors…,
    elevation: ButtonElevation? = null,
    border: BorderStroke? = null,
    contentPadding: PaddingValues = ButtonDefaults.TextButtonConten…,
    interactionSource: MutableInteractionSource? = null,
    content: @Composable (RowScope.() -> Unit)
): Unit
```

코틀린은 특이하게 매개변수로 함수를 전달가능하다. 
클릭을 했을 때 실행할 명령문들을 중괄호 내부에 작성하면 되는데,
지금은 아무것도 없으니 함수자체는 실행되지만 아무런 일이 일어나지
않는다.  

이제 람다를 만드는 방법을 알아보자

```kotlin
fun main(){
    val squareFunction = { x: Int -> x * x }
    println(squareFunction(2))
}
```

위 예시처럼 람다를 변수에 저장해두고 사용해도 된다.