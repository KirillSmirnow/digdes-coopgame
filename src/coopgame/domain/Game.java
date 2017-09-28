package coopgame.domain;

import java.util.Collections;
import java.util.List;

public class Game {

    private final List<Agent> agents;

    Game(List<Agent> agents) {
        this.agents = agents;
    }

    public void nextRound() {
        for (int i = 0; i < agents.size(); ++i)
            for (int j = i + 1; j < agents.size(); ++j)
                play(agents.get(i), agents.get(j));
        removeDefeatedPlayers();
    }

    public List<Agent> getAgents() {
        return Collections.unmodifiableList(agents);
    }

    public boolean isGameOver() {
        return agents.size() < 2;
    }

    private void play(Agent player1, Agent player2) {
        boolean putCoinByFirst = player1.play();
        boolean putCoinBySecond = player2.play();
        if (putCoinByFirst && putCoinBySecond) {
            player1.prize(2);
            player2.prize(2);
        } else if (putCoinByFirst) {
            player1.penalty(1);
            player2.prize(3);
        } else if (putCoinBySecond) {
            player1.prize(3);
            player2.penalty(1);
        } else {
            player1.penalty(1);
            player2.penalty(1);
        }
    }

    private void removeDefeatedPlayers() {
        agents.removeIf(Agent::isDead);
    }
}
