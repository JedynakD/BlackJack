package jack.jedynakd.score;

import jack.jedynakd.cards.Card;
import jack.jedynakd.cards.CardDeck;

public class ScoreCalculator {
    private int score;
    private CardDeck playerDeck;

    public ScoreCalculator(CardDeck playerDeck) {
        this.playerDeck = playerDeck;
    }

    public int calculateScore() {
        score = 0;
        for (Card card : playerDeck.getCardDeck()) {
            score = score + card.getValue();
        }
        return score;
    }
}
