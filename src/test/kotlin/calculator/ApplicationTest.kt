package calculator

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApplicationTest : NsTest() {
    @Test
    fun `커스텀 구분자 사용`() {
        assertSimpleTest {
            run("//;\\n1")
            assertThat(output()).contains("결과 : 1")
        }
    }

    @Test
    fun `예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("-1,2,3") }
        }
    }

    @Test
    fun `빈 입력 결과 0`(){
        assertSimpleTest {
            run("")
            assertThat(output()).contains("결과 : 0")
        }
    }

    @Test
    fun `쉼표 구분자`(){
        assertSimpleTest {
            run("1,2,3")
            assertThat(output()).contains("결과 : 6")
        }
    }

    @Test
    fun `콜론 구분자`(){
        assertSimpleTest {
            run("1:2:3")
            assertThat(output()).contains("결과 : 6")
        }
    }

    @Test
    fun `쉼표 또는 콜론 구분자`(){
        assertSimpleTest {
            run("1,2:3")
            assertThat (output()).contains("결과 : 6")
        }
    }

    @Test
    fun `십의 자리 이상의 숫자 입력`(){
        assertSimpleTest {
            run("//;\\n1;20;32")
            assertThat (output()).contains("결과 : 53")
        }
    }

    @Test
    fun `커스텀 구분자가 여러글자인 경우`(){
        assertSimpleTest {
            run("//;?\\n2;?10;?35")
            assertThat (output()).contains("결과 : 47")
        }
    }

    override fun runMain() {
        main()
    }
}
