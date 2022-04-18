package baseball.service;

import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ComputerServiceTest {
    @Test
    @DisplayName("임의의 3자리 숫자 생성")
    public void testRandomNumberDuplication() {
        Set<Integer> numberSet = new HashSet<>(pickGameNumberList());
        Assertions.assertThat(numberSet.size()).isEqualTo(3);
    }

    private List<Integer> pickGameNumberList() {
        List<Integer> numberList = Arrays.asList(0, 0, 0);
        for (int i = 0; i < 3; i++) {
            int pickedNumber = pickRandomNumber(numberList);
            numberList.set(i, pickedNumber);
        }

        return numberList;
    }

    private int pickRandomNumber(final List<Integer> numberList) {
        int pickedNumber;
        do {
            pickedNumber = Randoms.pickNumberInRange(1, 9);
        } while (isDuplicateNumber(numberList, pickedNumber));

        return pickedNumber;
    }

    private boolean isDuplicateNumber(final List<Integer> numberList, final int pickedNumber) {
        return numberList.contains(pickedNumber);
    }
}
