package jack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardDeck {
    private List<Card> cardDeck = new ArrayList<>();

    public void newGame() {
        for (int i = 0; i < 4; i++) {
            cardDeck.add(Card.TWO);
            cardDeck.add(Card.THREE);
            cardDeck.add(Card.FOUR);
            cardDeck.add(Card.FIVE);
            cardDeck.add(Card.SIX);
            cardDeck.add(Card.SEVEN);
            cardDeck.add(Card.EIGHT);
            cardDeck.add(Card.NINE);
            cardDeck.add(Card.TEN);
            cardDeck.add(Card.JACK);
            cardDeck.add(Card.QUEEN);
            cardDeck.add(Card.KING);
            cardDeck.add(Card.ACE);
            shuffleCards();
        }
    }

    private void shuffleCards() {
        Collections.shuffle(cardDeck);
    }

    public void addCardToCardDeck(Card card) {
        cardDeck.add(card);
    }

    public Card getOneCardFromDeck() {
        return cardDeck.remove(0);
    }

    public List<Card> getCardDeck() {
        return cardDeck;
    }
}
