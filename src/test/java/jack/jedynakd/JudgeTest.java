package jack.jedynakd;

import jack.jedynakd.judge.Judge;
import jack.jedynakd.score.Winner;
import org.junit.Before;
import org.junit.Test;
import jack.jedynakd.score.ScoreCalculator;

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
        when(mockedHumanScore.calculateScore()).thenReturn(5);
        when(mockedPcScore.calculateScore()).thenReturn(15);
        judge = new Judge(mockedPcScore, mockedHumanScore);
        result = judge.calculateWinner();

        assertEquals(Winner.PC, result);
    }

    @Test
    public void shouldReturnThatHumanWinWhenPcScoreAndHumanScoreIsLessThanTwentyOneButHumanScoreIsBigger() {
        when(mockedHumanScore.calculateScore()).thenReturn(20);
        when(mockedPcScore.calculateScore()).thenReturn(15);
        judge = new Judge(mockedPcScore, mockedHumanScore);
        result = judge.calculateWinner();

        assertEquals(Winner.HUMAN, result);
    }

    @Test
    public void shouldReturnThatHumanWinWhenPcScoreIsMoreThanTwentyOneButHumanScoreIsLessOrEqualTwentyOne() {
        when(mockedHumanScore.calculateScore()).thenReturn(20);
        when(mockedPcScore.calculateScore()).thenReturn(23);
        judge = new Judge(mockedPcScore, mockedHumanScore);
        result = judge.calculateWinner();

        assertEquals(Winner.HUMAN, result);
    }

    @Test
    public void shouldReturnThatPcWinWhenHumanScoreIsMoreThanTwentyOneButPcScoreIsLessOrEqualTwentyOne() {
        when(mockedHumanScore.calculateScore()).thenReturn(26);
        when(mockedPcScore.calculateScore()).thenReturn(21);
        judge = new Judge(mockedPcScore, mockedHumanScore);
        result = judge.calculateWinner();

        assertEquals(Winner.PC, result);
    }

    @Test
    public void shouldReturnThatPcWinsWhenPcScoreAndHumanScoreIsMoreThanTwentyOneButPcScoreIsBigger() {
        when(mockedHumanScore.calculateScore()).thenReturn(32);
        when(mockedPcScore.calculateScore()).thenReturn(50);
        judge = new Judge(mockedPcScore, mockedHumanScore);
        result = judge.calculateWinner();

        assertEquals(Winner.PC, result);
    }

    @Test
    public void shouldReturnThatHumanWinWhenPcScoreAndHumanScoreIsMoreThanTwentyOneButHumanScoreIsBigger() {
        when(mockedHumanScore.calculateScore()).thenReturn(29);
        when(mockedPcScore.calculateScore()).thenReturn(24);
        judge = new Judge(mockedPcScore, mockedHumanScore);
        result = judge.calculateWinner();

        assertEquals(Winner.HUMAN, result);
    }

    @Test
    public void shouldReturnTieWhenPcScoreAndHumanScoreAreEqual() {
        when(mockedHumanScore.calculateScore()).thenReturn(12);
        when(mockedPcScore.calculateScore()).thenReturn(12);
        judge = new Judge(mockedPcScore, mockedHumanScore);
        result = judge.calculateWinner();

        assertEquals(Winner.TIE, result);
    }
}
