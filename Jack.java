package black;

import java.util.Collections;
import java.util.Random;

public class Jack extends Cards {
	private int numberOfCards = 52;
	private int sum;

	public void newGame() {
		Collections.shuffle(getCards());
	}

	public void pass() {
		do {
			draw();
		} while (sum < 15);
	}

	public int getSuma() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public void draw() {
		Random random = new Random();
		int randomCardValue = random.nextInt(numberOfCards);
		sum = sum + getCards().get(randomCardValue).getKey();
		removeCard(randomCardValue);
		showGameState(randomCardValue);
	}

	private void showGameState(int randomCardValue) {
		System.out.println("Pobrano: " + getCards().get(randomCardValue));
		System.out.println("Suma to: " + sum);
	}

	private void removeCard(int randomCardValue) {
		getCards().remove(randomCardValue);
		numberOfCards--;
	}

}
