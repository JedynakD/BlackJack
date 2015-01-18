package jack;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PlayerTest {

    CardDeck originalDeck;
    CardDeck playerDeck;
    Player player;
    List<Card> deck;

    @Before
    public void beforePlayerTest() {
        originalDeck = new CardDeck();
        originalDeck.newGame();
        playerDeck = new CardDeck();
        player = new Player(playerDeck, originalDeck);
        deck = playerDeck.getCardDeck();
    }

    @Test
    public void shouldReturnFalseWhenDrawnCardFromOriginalDeckAddedtoEmptyPlayerDeck() {
        player.draw();

        assertFalse(deck.isEmpty());
    }

    @Test
    public void shouldReturnDrawnCardFromOriginalDeck() {
        player.draw();
        Card card = player.showYourCard();

        assertTrue(deck.contains(card));
    }

}
