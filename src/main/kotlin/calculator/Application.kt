package calculator

fun main() {
    // TODO: 프로그램 구현
    var sum = 0
    var v1: Int
    var v2: Int
    var separator = " "

    // 사용자가 입력을 하지 않거나 엔터만 입력하면 null이 반환될 수 있다는 것을 사용자에게 알림
    println("덧셈할 문자열을 입력해 주세요.")
    val input: String? = readLine()

    // 입력을 하지 않거나 엔터만 입력한 경우
    if (input.isNullOrEmpty()) {
        println("결과 : $sum")
        return
    }

}


