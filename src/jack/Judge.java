package jack;

public class Judge {

	private ScoreCalculator pcScore;
	private ScoreCalculator humanScore;

	public Judge(ScoreCalculator pcScore, ScoreCalculator humanScore) {
		this.pcScore = pcScore;
		this.humanScore = humanScore;
	}

	public void calculateWinner() {
		int pcSum = pcScore.calulateScore();
		int yourSum = humanScore.calulateScore();

		if (pcSum <= 21 && yourSum <= 21) {
			if (pcSum > yourSum) {
				System.out.println("PC wins.");
			} else if (yourSum > pcSum) {
				System.out.println("You win.");
			}
		} else if (pcSum > yourSum && yourSum <= 21) {
			System.out.println("You win.");
		} else if (yourSum > pcSum && pcSum <= 21) {
			System.out.println("PC wins.");
		} else if (pcSum > yourSum) {
			System.out.println("PC wins.");
		} else if (yourSum > pcSum) {
			System.out.println("You win.");
		} else if (yourSum == pcSum) {
			System.out.println("Tie.");
		}
	}
}
