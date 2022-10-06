package game.domain.rule;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberRacingGameRuleTest {

    @DisplayName("forwardNumber 이상의 값이 전달되면 True를 이하면 False를 반환한다.")
    @Test
    void isForward() {
        NumberRacingGameRule numberRacingGameRule = new NumberRacingGameRule(4, 10);

        Assertions.assertAll(
                () -> assertThat(numberRacingGameRule.isForward(4)).isEqualTo(true),
                () -> assertThat(numberRacingGameRule.isForward(66)).isEqualTo(true),
                () -> assertThat(numberRacingGameRule.isForward(3)).isEqualTo(false)
        );
    }

}
