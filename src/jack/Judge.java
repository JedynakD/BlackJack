package jack;

public class Judge {

    private ScoreCalculator pcScore;
    private ScoreCalculator humanScore;

    public Judge(ScoreCalculator pcScore, ScoreCalculator humanScore) {
        this.pcScore = pcScore;
        this.humanScore = humanScore;
    }

    public Winner calculateWinner() {
        int pcSum = pcScore.calulateScore();
        int yourSum = humanScore.calulateScore();

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
