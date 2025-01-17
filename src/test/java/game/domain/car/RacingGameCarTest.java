package game.domain.car;

import game.domain.rule.NumberRacingGameRule;
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

        Location expected = new Location(car.location().getLocation());
        NumberRacingGameRule racingGameRule = new NumberRacingGameRule(4, 10) {
            @Override
            public int pickRandomNumber() {
                return 3;
            }
        };
        car.forward(racingGameRule);
        assertThat(car.location()).isEqualTo(new Location(expected));

        racingGameRule = new NumberRacingGameRule(4, 10) {
            @Override
            public int pickRandomNumber() {
                return 4;
            }
        };
        expected = new Location(car.location().getLocation() + racingGameRule.forwardDistance());
        car.forward(racingGameRule);
        assertThat(car.location()).isEqualTo(expected);
    }

}
