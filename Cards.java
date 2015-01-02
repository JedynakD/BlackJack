package black;

import java.util.ArrayList;
import java.util.List;

public class Cards {
	private int key;
	private String nazwa;
	private List<Cards> cards = new ArrayList<Cards>();

	public Cards() {
	};

	public Cards(int key, String nazwa) {
		this.key = key;
		this.nazwa = nazwa;
	}

	public int getKey() {
		return key;
	}

	public String getNazwa() {
		return nazwa;
	}

	public String toString() {
		return "Cards [key=" + key + ", nazwa=" + nazwa + "]";
	}

	public ArrayList<Cards> getCards() {
		return (ArrayList<Cards>) cards;
	}

	public void makeCards() {
		for (int k = 2; k <= 10; k++) {
			for (int j = 0; j < 4; j++) {
				cards.add(new Cards(k, String.valueOf(k)));
			}
		}
		for (int i = 0; i < 4; i++) {
			cards.add(new Cards(10, "Walet"));
		}
		for (int i = 0; i < 4; i++) {
			cards.add(new Cards(10, "Dama"));
		}
		for (int i = 0; i < 4; i++) {
			cards.add(new Cards(10, "Król"));
		}
		for (int i = 0; i < 4; i++) {
			cards.add(new Cards(11, "As"));
		}
	}
}
