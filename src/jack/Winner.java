package jack;

public enum Winner {

	PC("PC wins."), HUMAN("You win."), TIE("Tie.");

	private String gameWinner;

	Winner(String gameWinner) {
		this.gameWinner = gameWinner;
	}

	public String toString() {
		return gameWinner;
	}
}
