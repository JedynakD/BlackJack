package jack;

import org.junit.Before;
import org.junit.Test;

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
        int result = calculator.calulateScore();

        assertEquals(0, result);
    }

    @Test
    public void shouldReturnFiveWhenCardWithValueOfFiveAdded() {
        deck.addCardToCardDeck(Card.FIVE);
        int result = calculator.calulateScore();

        assertEquals(5, result);
    }

    @Test
    public void shouldReturnTenWhenWhenCardWithValueOfSixAndCardWithValueOfFourAdded() {
        deck.addCardToCardDeck(Card.SIX);
        deck.addCardToCardDeck(Card.FOUR);
        int result = calculator.calulateScore();

        assertEquals(10, result);
    }

    @Test
    public void shouldReturnSumOfAllCardsValuesAdded() {
        deck.addCardToCardDeck(Card.TWO);
        deck.addCardToCardDeck(Card.SEVEN);
        deck.addCardToCardDeck(Card.ACE);
        deck.addCardToCardDeck(Card.KING);
        int result = calculator.calulateScore();

        assertEquals(30, result);
    }

}
