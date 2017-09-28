package coopgame;

import coopgame.analysis.Analyser;
import coopgame.domain.GameBuilder;

public class Starter {

    public static void main(String[] args) {
        Analyser analyser = new Analyser();
        GameBuilder gameBuilder = new GameBuilder()
                .addAgents(
                        1,
                        2,
                        1
                );
        analyser.play(gameBuilder);
    }
}
