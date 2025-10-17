package calculator

fun main() {
    // TODO: 프로그램 구현
    var sum = 0
    var v1: Int
    var v2: Int
    var separator = " "

    // 사용자가 입력을 하지 않거나 엔터만 입력하면 null이 반환될 수 있다는 것을 사용자에게 알립니다
    println("덧셈할 문자열을 입력해 주세요.")
    val input: String? = readLine()

    // 입력을 하지 않거나 엔터만 입력한 경우
    if (input.isNullOrEmpty()) {
        println("결과 : $sum")
        return
    }

    // 쉼표 또는 콜론을 구분자로 가지는 문자열을 전달하는 경우(정상 값 입력,숫자가 십의 자리 수 이상인 경우도 고려해보았습니다)
    if (input.contains(',') || input.contains(':')) {
        // input 값을 쉼표와 콜론을 기준으로 쪼개서 저장해두고
        val parts = input.split(',', ':')
        for (part in parts) {
            val value = part.toInt()
            // 숫자들은 양수만 있어야함
            if (value > 0)
                sum += part.toInt()
            else
                throw IllegalArgumentException()
        }
    }

    // 커스텀 구분자를 가지는 경우(정상 값 입력,커스텀 구분자가 여러 글자인 경우와 숫자가 십의 자리 수 이상인 경우도 고려해보았습니다)
    else if (input[0] == '/' && input[1] == '/') {
        // 커스텀 구분자를 지정하여 문자열을 전달하는 경우(//와 \n 사이에 입력)
        val start = 2 //구분자의 시작 인덱스
        val end = input.indexOf("\\n") // \n의 시작 인덱스
        //커스텀 연산자 파악
        separator = input.substring(start, end)
        //숫자 더하기 시작
        val part = input.substring(end + 2, input.length)
        val parts = part.split(separator)
        for (p in parts) {
            val value = p.toInt()
            if (value > 0)
                sum += p.toInt()
            else
                throw IllegalArgumentException()
        }
    }


    // 잘못된 값을 입력하는 경우(숫자, ,(쉼표), :(콜론), // , \n 외의 문자열이 입력된 경우)
    else {
        throw IllegalArgumentException()
    }
    println("결과 :  $sum")
}


