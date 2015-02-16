package jack.jedynakd;

import jack.jedynakd.ai.AI;
import jack.jedynakd.player.Player;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import jack.jedynakd.score.ScoreCalculator;

import static org.mockito.Mockito.*;

public class AITest {
    private Player player;
    private ScoreCalculator calculator;
    InOrder inOrder;
    private AI ai;

    @Before
    public void beforeAITest() {
        player = mock(Player.class);
        calculator = mock(ScoreCalculator.class);
        ai = new AI(player, calculator);
        inOrder = inOrder(player, calculator);
    }

    @Test
    public void shouldControlPlayerUntilScoreIsEighteen() {
        when(calculator.calculateScore()).thenReturn(5).thenReturn(10).thenReturn(18);

        ai.controlPlayer();

        inOrder.verify(player).draw();
        inOrder.verify(player).showYourCard();
        inOrder.verify(player).draw();
        inOrder.verify(player).showYourCard();
        inOrder.verify(player).pass();
    }

    @Test
    public void shouldNotControlPlayerWhenScoreIsMoreThanEighteen() {
        when(calculator.calculateScore()).thenReturn(20);

        ai.controlPlayer();

        inOrder.verify(player, never()).draw();
        inOrder.verify(player, never()).showYourCard();
        inOrder.verify(player, times(1)).pass();
    }
}