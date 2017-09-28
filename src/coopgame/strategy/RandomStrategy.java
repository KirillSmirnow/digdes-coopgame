package coopgame.strategy;

import java.util.Random;

public class RandomStrategy implements Strategy {

    private static final Random RANDOM = new Random();

    @Override
    public boolean coinPut() {
        return RANDOM.nextBoolean();
    }
}
