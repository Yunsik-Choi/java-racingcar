package game.domain.car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGameCarList {

    private final List<RacingGameCar> cars;

    public RacingGameCarList(List<RacingGameCar> cars) {
        this.cars = cars;
    }

    public RacingGameCarList(RacingGameCarList racingGameCarList) {
        this(racingGameCarList.cars());
    }

    public List<RacingGameCar> cars() {
        return Collections.unmodifiableList(cars);
    }

    public static RacingGameCarList makeRacingGameCars(int number) {
        List<RacingGameCar> racingGameCarList = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            racingGameCarList.add(new RacingGameCar());
        }
        return new RacingGameCarList(racingGameCarList);
    }

    public static RacingGameCarList makeRacingGameCars(List<String> names) {
        List<RacingGameCar> racingGameCarList = new ArrayList<>();
        for (String name : names) {
            racingGameCarList.add(new RacingGameCar(name));
        }
        return new RacingGameCarList(racingGameCarList);
    }

    public RacingGameCar getLast() {
        return new RacingGameCar(cars.get(cars.size() - 1));
    }

    public RacingGameCarList winners() {
        return winners(winnerLocation());
    }

    private RacingGameCarList winners(Location winnerLocation) {
        List<RacingGameCar> result = cars.stream()
                .filter(racingGameCar -> racingGameCar.location().equals(winnerLocation))
                .collect(Collectors.toList());
        return new RacingGameCarList(result);
    }

    private Location winnerLocation() {
        Location result = new Location(Location.LOCATION_MINIMUM);
        for (RacingGameCar car : cars()) {
            result = car.location.bigger(result);
        }
        return result;
    }
}
