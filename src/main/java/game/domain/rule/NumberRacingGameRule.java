package game.domain.rule;

import java.util.Random;

public class NumberRacingGameRule implements RacingGameRule {

    private static final int FORWARD_DISTANCE = 1;
    private static final Random RANDOM = new Random();
    private ForwardNumber forwardNumber;
    private Bound bound;

    public NumberRacingGameRule(int canForwardNumber, int bound) {
        this.forwardNumber = new ForwardNumber(canForwardNumber);
        this.bound = new Bound(bound);
    }

    public boolean isForward(int number) {
        return forwardNumber.isForward(number);
    }

    public Bound bound() {
        return new Bound(bound);
    }

    public ForwardNumber forwardNumber() {
        return new ForwardNumber(forwardNumber);
    }

    public int forwardDistance() {
        return FORWARD_DISTANCE;
    }

    @Override
    public boolean forward() {
        return forwardNumber.isForward(pickRandomNumber());
    }

    public int pickRandomNumber() {
        return RANDOM.nextInt(bound.getBound());
    }
}
