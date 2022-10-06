package game.domain.game;

import game.domain.car.Car;
import game.domain.car.RacingGameCarList;
import game.domain.rule.RacingGameRule;

public class RacingGame {

    private RacingGameCarList racingGameCarList;
    private RacingGameRule racingGameRule;
    private Round round;


    public RacingGame(RacingGameRule racingGameRule, RacingGameCarList cars, int round) {
        this.racingGameRule = racingGameRule;
        this.racingGameCarList = cars;
        this.round = new Round(round);
    }

    public void progressRound() {
        for (Car car : racingGameCarList.cars()) {
            car.forward(racingGameRule);
        }
    }

    public RacingGameCarList carList() {
        return new RacingGameCarList(racingGameCarList);
    }

    public Round round() {
        return new Round(round);
    }
    
}
