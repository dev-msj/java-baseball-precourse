package baseball.service;

import baseball.model.Ball;
import baseball.service.serviceImpl.ValidationServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidationServiceTest {
    ValidationService service = new ValidationServiceImpl();

    @ParameterizedTest
    @DisplayName("문자열 길이 검증 확인")
    @ValueSource(strings = {"1233v", "aa", "qwer"})
    public void testValidationStringLength(String testString) {
        assertThatThrownBy(() -> service.validateBallNumberLength(testString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력한 문자의 길이가 3보다 작거나 큽니다.");
    }

    @Test
    @DisplayName("0이 포함된 문자열 검증")
    public void testValidationStringZero() {
        assertThatThrownBy(() -> service.validateBallNumberZero("120"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1-9 외의 숫자를 입력했습니다.");
    }

    @ParameterizedTest
    @DisplayName("숫자가 아닌 문자열 검증")
    @ValueSource(strings = {"123asd", "aaa", "qwer"})
    public void testValidationStringType(String testString) {
        assertThatThrownBy(() -> service.validateBallNumberType(testString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자가 아닌 다른 문자를 입력했습니다.");
    }

    @Test
    @DisplayName("중복된 값이 존재하는 Ball 객체 검증")
    public void testValidationDuplicateBallNumber() {
        Ball ball = new Ball(112);
        assertThatThrownBy(() -> service.validateDuplicateBallNumber(ball))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 숫자가 존재합니다.");
    }

    @ParameterizedTest
    @DisplayName("1 또는 2가 아닌 문자열 검증")
    @ValueSource(strings = {"b", "3", "!"})
    public void testValidationFinishNumber(String testString) {
        assertThatThrownBy(() -> service.validateFinishNumber(testString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1 또는 2가 아닌 문자를 입력했습니다.");
    }
}
