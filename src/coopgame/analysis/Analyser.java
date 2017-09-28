package coopgame.analysis;

import coopgame.domain.Agent;
import coopgame.domain.Game;
import coopgame.domain.GameBuilder;

import java.util.List;

public class Analyser {

    private static final Printer PRINTER = new Printer();

    public void play(GameBuilder gameBuilder) {
        Game game = gameBuilder.build();
        PRINTER.println("GAME INIT");
        outputAgents(game.getAgents());
        int qty = game.getAgents().size();
        PRINTER.println("GAME START");
        for (int round = 1; !game.isGameOver(); ++round) {
            game.nextRound();
            outputAgents(game.getAgents());
            int curQty = game.getAgents().size();
            PRINTER.println(String.format("round %d, agents: %d, eliminated: %d", round, curQty, (qty - curQty)));
            PRINTER.println("***\n");
            qty = curQty;
        }
        PRINTER.println("GAME OVER");
    }

    private void outputAgents(List<Agent> agents) {
        agents.forEach(PRINTER::println);
        PRINTER.println("");
    }
}
