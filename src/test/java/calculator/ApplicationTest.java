package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    @DisplayName("빈 문자열 입력 시 0 반환")
    void add_empty() {
        assertSimpleTest(() -> {
            run("");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    @DisplayName("쉼표 또는 콜론 구분자로 분리한 숫자의 합 반환")
    void add_comma_or_colon_separator() {
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    @DisplayName("커스텀 구분자를 사용하여 분리한 숫자의 합 반환")
    void add_custom_delimiter() {
        assertSimpleTest(() -> {
            run("//;\n1;2;3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    @DisplayName("숫자가 아닌 값 입력 시 IllegalArgumentException 발생")
    void add_non_numeric_exception() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,a:3"))
                        .isExactlyInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("음수가 포함된 경우 IllegalArgumentException 발생")
    void add_negative_number_exception() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isExactlyInstanceOf(IllegalArgumentException.class)
        );
    }
}