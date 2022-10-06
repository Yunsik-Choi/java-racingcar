package game.domain.car;

import game.domain.rule.RacingGameRule;

public class RacingGameCar extends Car {

    public RacingGameCar(String name) {
        super(name);
    }

    public RacingGameCar() {
        this("");
    }

    @Override
    public void forward(RacingGameRule racingGameRule) {
        if(racingGameRule.forward()){
            forward(racingGameRule.forwardDistance());
        }
    }

    public RacingGameCar(RacingGameCar racingGameCar) {
        super(racingGameCar.carName().getCarName());
    }


    public void forward(int number) {
        location.forward(number);
    }

}
