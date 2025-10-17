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

    // 쉼표 또는 콜론을 구분자로 가지는 문자열을 전달하는 경우(정상 값 입력,숫자가 십의 자리 수 이상인 경우도 고려해봄)
    if (input.contains(',')||input.contains(':')) {
        // input 값을 쉼표와 콜론을 기준으로 쪼개서 저장해두고
        val parts = input.split(',',':')
        for(part in parts){
            sum += part.toInt()
        }
    }
}


