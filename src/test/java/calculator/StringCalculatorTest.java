package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    @Test
    @DisplayName("빈 문자열 또는 null 입력 시 0 반환")
    void add_null_or_empty() {
        StringCalculator calculator = new StringCalculator();

        assertThat(calculator.add(null)).isEqualTo(0);
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
}
