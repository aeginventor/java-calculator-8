package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    @DisplayName("빈 문자열 입력 시 0 반환")
    void add_empty() {
        StringCalculator calculator = new StringCalculator();

        assertThat(calculator.add("")).isEqualTo(0);
    }

    @Test
    @DisplayName("쉼표 또는 콜론 구분자로 분리한 숫자의 합 반환")
    void add_comma_or_colon_separator() {
        StringCalculator calculator = new StringCalculator();
        String text = "1,2:3";

        int result = calculator.add(text);

        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자를 사용하여 분리한 숫자의 합 반환")
    void add_custom_delimiter() {
        StringCalculator calculator = new StringCalculator();
        String text = "//;\n1;2;3";

        int result = calculator.add(text);

        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("구분자로 분리한 값이 숫자가 아닌 경우 IllegalArgumentException 발생")
    void add_non_numeric_exception() {
        StringCalculator calculator = new StringCalculator();
        String text = "1,a:3";

        assertThatThrownBy(() -> calculator.add(text))
                .isExactlyInstanceOf(IllegalArgumentException.class);

    }

    @Test
    @DisplayName("음수가 포함된 경우 IllegalArgumentException 발생")
    void add_negative_number_exception() {
        StringCalculator calculator = new StringCalculator();
        String text = "1,-2:3";

        assertThatThrownBy(() -> calculator.add(text))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
