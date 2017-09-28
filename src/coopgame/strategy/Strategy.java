package coopgame.strategy;

public interface Strategy {

    boolean coinPut();

    default String name() {
        return getClass().getSimpleName();
    }
}
