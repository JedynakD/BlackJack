package jack.jedynakd;

import jack.jedynakd.cards.Card;
import jack.jedynakd.cards.CardDeck;
import org.junit.Before;
import org.junit.Test;
import jack.jedynakd.score.ScoreCalculator;

import static org.junit.Assert.assertEquals;

public class ScoreCalculatorTest {
    CardDeck deck;
    ScoreCalculator calculator;

    @Before
    public void beforeScoreCalculatorTest() {
        deck = new CardDeck();
        calculator = new ScoreCalculator(deck);
    }

    @Test
    public void shouldReturnZeroWhenNoCardAdded() {
        int result = calculator.calculateScore();

        assertEquals(0, result);
    }

    @Test
    public void shouldReturnFiveWhenCardWithValueOfFiveAdded() {
        deck.addCardToCardDeck(Card.FIVE);
        int result = calculator.calculateScore();

        assertEquals(5, result);
    }

    @Test
    public void shouldReturnTenWhenWhenCardWithValueOfSixAndCardWithValueOfFourAdded() {
        deck.addCardToCardDeck(Card.SIX);
        deck.addCardToCardDeck(Card.FOUR);
        int result = calculator.calculateScore();

        assertEquals(10, result);
    }

    @Test
    public void shouldReturnSumOfAllCardsValuesAdded() {
        deck.addCardToCardDeck(Card.TWO);
        deck.addCardToCardDeck(Card.SEVEN);
        deck.addCardToCardDeck(Card.ACE);
        deck.addCardToCardDeck(Card.KING);
        int result = calculator.calculateScore();

        assertEquals(30, result);
    }

}
