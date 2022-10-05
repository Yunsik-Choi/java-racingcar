package game.domain.car;

import game.domain.rule.RacingGameRule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class RacingGameCarTest {

    private RacingGameCar car;

    @BeforeEach
    private void setCar() {
        car = new RacingGameCar("name");
    }

    @ParameterizedTest(name = "자동차의 위치를 숫자만큼 증가시킨다")
    @ValueSource(ints = {1, 33, 999})
    void forward(int number) {
        Location expected = new Location(car.location().getLocation() + number);

        car.forward(number);

        assertThat(car.location()).isEqualTo(expected);
    }

    @DisplayName(value = "RacingGameRule과 숫자가 주어지고 RacingGameRule의 이동 가능한 숫자보다 큰 값이 주어지면 RacingGameRule의 이동 거리만큼 이동한다.")
    @Test
    void forwardRacingGameRule() {
        RacingGameRule racingGameRule = new RacingGameRule(4, 10);

        Location expected = new Location(car.location().getLocation());
        car.forward(racingGameRule, 3);
        assertThat(car.location()).isEqualTo(new Location(expected));

        expected = new Location(car.location().getLocation() + racingGameRule.forwardDistance());
        car.forward(racingGameRule, 4);
        assertThat(car.location()).isEqualTo(expected);
    }

}