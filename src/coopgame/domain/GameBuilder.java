package coopgame.domain;

import coopgame.strategy.GreedyStrategy;
import coopgame.strategy.NaiveStrategy;
import coopgame.strategy.RandomStrategy;
import coopgame.strategy.Strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameBuilder {

    private static final Random RANDOM = new Random();

    private final List<Agent> agents;

    public GameBuilder() {
        agents = new ArrayList<>();
    }

    public Game build() {
        return new Game(agents);
    }

    public GameBuilder addAgent(int money, Strategy strategy) {
        agents.add(new Agent(money, strategy));
        return this;
    }

    public GameBuilder addAgents(int greedyQty, int naiveQty, int randomQty) {
        for (int i = 0; i < greedyQty; ++i)
            addAgent(RANDOM.nextInt(1000) + 10, new GreedyStrategy());
        for (int i = 0; i < naiveQty; ++i)
            addAgent(RANDOM.nextInt(1000) + 10, new NaiveStrategy());
        for (int i = 0; i < randomQty; ++i)
            addAgent(RANDOM.nextInt(1000) + 10, new RandomStrategy());
        return this;
    }
}
