package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    @DisplayName("콤마 존재 유무에 따른 split")
    public void splitString() {
        /*
        1. "1,2"을 , 로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
        2. "1"을 , 로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.
        */

        String containCommaString = "1,2";
        String singleString = "1";

        assertThat(containCommaString.split(",")).contains("1", "2").containsExactly("1", "2");
        assertThat(singleString.split(",")).containsExactly("1");
    }

    @Test
    @DisplayName("문자열에서 괄호를 제거하고 split")
    public void splitStringWithoutBracket() {
        // "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 () 을 제거하고 "1,2"를 반환하도록 구현한다.

        String testString = "(1,2)";

        assertThat(
                testString.substring(1, testString.length() - 1).split(",")
        ).contains("1", "2").containsExactly("1", "2");
    }

    @Test
    @DisplayName("문자열에서 특정 문자 추출")
    public void extractCharFromString() {
        /*
        1. "abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.
        2. String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면
           StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.
        3. JUnit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다
        */

        String testString = "abc";
        int index = 5;

        assertThatThrownBy(() -> testString.charAt(index)).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("%d", index);

        assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() -> testString.charAt(index))
                .withMessageContaining("%d", index);
    }
}
