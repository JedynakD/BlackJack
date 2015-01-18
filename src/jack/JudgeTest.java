package jack;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class JudgeTest {

    ScoreCalculator mockedHumanScore;
    ScoreCalculator mockedPcScore;
    Judge judge;
    Winner result;

    @Before
    public void beforeJudgeTest() {
        mockedHumanScore = mock(ScoreCalculator.class);
        mockedPcScore = mock(ScoreCalculator.class);
    }

    @Test
    public void shouldReturnThatPcWinsWhenPcScoreAndHumanScoreIsLessThanTwentyOneButPcScoreIsBigger() {
        when(mockedHumanScore.calulateScore()).thenReturn(5);
        when(mockedPcScore.calulateScore()).thenReturn(15);
        judge = new Judge(mockedPcScore, mockedHumanScore);
        result = judge.calculateWinner();

        assertEquals(Winner.PC, result);
    }

    @Test
    public void shouldReturnThatHumanWinWhenPcScoreAndHumanScoreIsLessThanTwentyOneButHumanScoreIsBigger() {
        when(mockedHumanScore.calulateScore()).thenReturn(20);
        when(mockedPcScore.calulateScore()).thenReturn(15);
        judge = new Judge(mockedPcScore, mockedHumanScore);
        result = judge.calculateWinner();

        assertEquals(Winner.HUMAN, result);
    }

    @Test
    public void shouldReturnThatHumanWinWhenPcScoreIsMoreThanTwentyOneButHumanScoreIsLessOrEqualTwentyOne() {
        when(mockedHumanScore.calulateScore()).thenReturn(20);
        when(mockedPcScore.calulateScore()).thenReturn(23);
        judge = new Judge(mockedPcScore, mockedHumanScore);
        result = judge.calculateWinner();

        assertEquals(Winner.HUMAN, result);
    }

    @Test
    public void shouldReturnThatPcWinWhenHumanScoreIsMoreThanTwentyOneButPcScoreIsLessOrEqualTwentyOne() {
        when(mockedHumanScore.calulateScore()).thenReturn(26);
        when(mockedPcScore.calulateScore()).thenReturn(21);
        judge = new Judge(mockedPcScore, mockedHumanScore);
        result = judge.calculateWinner();

        assertEquals(Winner.PC, result);
    }

    @Test
    public void shouldReturnThatPcWinsWhenPcScoreAndHumanScoreIsMoreThanTwentyOneButPcScoreIsBigger() {
        when(mockedHumanScore.calulateScore()).thenReturn(32);
        when(mockedPcScore.calulateScore()).thenReturn(50);
        judge = new Judge(mockedPcScore, mockedHumanScore);
        result = judge.calculateWinner();

        assertEquals(Winner.PC, result);
    }

    @Test
    public void shouldReturnThatHumanWinWhenPcScoreAndHumanScoreIsMoreThanTwentyOneButHumanScoreIsBigger() {
        when(mockedHumanScore.calulateScore()).thenReturn(29);
        when(mockedPcScore.calulateScore()).thenReturn(24);
        judge = new Judge(mockedPcScore, mockedHumanScore);
        result = judge.calculateWinner();

        assertEquals(Winner.HUMAN, result);
    }

    @Test
    public void shouldReturnTieWhenPcScoreAndHumanScoreAreEqual() {
        when(mockedHumanScore.calulateScore()).thenReturn(12);
        when(mockedPcScore.calulateScore()).thenReturn(12);
        judge = new Judge(mockedPcScore, mockedHumanScore);
        result = judge.calculateWinner();

        assertEquals(Winner.TIE, result);
    }
}
