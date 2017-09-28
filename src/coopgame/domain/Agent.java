package coopgame.domain;

import coopgame.strategy.Strategy;

public class Agent {

    private static int nextId = 1;

    private final int id;
    private final Strategy strategy;
    private int money;

    Agent(int money, Strategy strategy) {
        this.id = nextId++;
        this.money = money;
        this.strategy = strategy;
    }

    boolean play() {
        boolean coinPut = strategy.coinPut();
        if (coinPut) --money;
        return coinPut;
    }

    void prize(int amount) {
        money += amount;
    }

    void penalty(int amount) {
        money -= amount;
    }

    boolean isDead() {
        return money < 0;
    }

    @Override
    public String toString() {
        return "Agent{" +
                "id=" + id +
                ", strategy=" + strategy.name() +
                ", money=" + money +
                '}';
    }
}
