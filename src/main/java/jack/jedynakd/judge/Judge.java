package jack.jedynakd.judge;

import jack.jedynakd.score.ScoreCalculator;
import jack.jedynakd.score.Winner;

public class Judge {

    private ScoreCalculator pcScore;
    private ScoreCalculator humanScore;

    public Judge(ScoreCalculator pcScore, ScoreCalculator humanScore) {
        this.pcScore = pcScore;
        this.humanScore = humanScore;
    }

    public Winner calculateWinner() {
        int pcSum = pcScore.calculateScore();
        int yourSum = humanScore.calculateScore();

        if (pcSum <= 21 && yourSum <= 21) {
            if (pcSum > yourSum) {
                return Winner.PC;
            } else if (yourSum > pcSum) {
                return Winner.HUMAN;
            }
        } else if (pcSum > yourSum && yourSum <= 21) {
            return Winner.HUMAN;
        } else if (yourSum > pcSum && pcSum <= 21) {
            return Winner.PC;
        } else if (pcSum > yourSum) {
            return Winner.PC;
        } else if (yourSum > pcSum) {
            return Winner.HUMAN;
        }
        return Winner.TIE;
    }
}
