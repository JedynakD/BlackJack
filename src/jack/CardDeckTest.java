package jack;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CardDeckTest {
    CardDeck cardDeck;
    List<Card> deck;
    Card card;

    @Before
    public void beforeCardDeckTest() {
        cardDeck = new CardDeck();
        deck = cardDeck.getCardDeck();
    }

    @Test
    public void shouldReturnFalseWhenCardsAdded() {
        cardDeck.newGame();

        assertFalse(deck.isEmpty());
    }

    @Test
    public void shouldReturnTrueWhenNoCardsAdded() {
        assertTrue(deck.isEmpty());
    }

    @Test
    public void shouldReturnTrueWhenCardAddedToEmptyCardDeck() {
        cardDeck.addCardToCardDeck(Card.ACE);

        assertEquals(true, deck.contains(Card.ACE));
    }

    @Test
    public void shouldReturnFalseWhenRemovedLastCardFromDeck() {
        cardDeck.addCardToCardDeck(Card.EIGHT);
        cardDeck.getOneCardFromDeck();

        assertTrue(deck.isEmpty());
    }
}
