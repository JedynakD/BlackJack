package jack;

public class AI {
	private Player player;
	private ScoreCalculator score; 

	public AI(Player player,ScoreCalculator score) {
		this.player = player;
		this.score = score;
	}

	public void controlPlayer() {
		do {
			player.draw();
			player.showYourCard();
		} while (score.calulateScore() < 15);
		player.pass();
	}
}
