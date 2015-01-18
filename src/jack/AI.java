package jack;

public class AI {
    private Player player;
    private ScoreCalculator calculator;

    public AI(Player player, ScoreCalculator calculator) {
        this.player = player;
        this.calculator = calculator;
    }

    public void controlPlayer() {
        do {
            player.draw();
            player.showYourCard();
        } while (calculator.calulateScore() < 15);
        player.pass();
    }
}
