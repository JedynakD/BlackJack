package jack;

public class AI {
    static final int MAX_SCORE = 18;
    private Player player;
    private ScoreCalculator calculator;

    public AI(Player player, ScoreCalculator calculator) {
        this.player = player;
        this.calculator = calculator;
    }

    public void controlPlayer() {
        while ((calculator.calculateScore() < MAX_SCORE)) {
            player.draw();
            player.showYourCard();
        }
        player.pass();
    }
}
