package jack.jedynakd.game;

import jack.jedynakd.judge.Judge;
import jack.jedynakd.player.Player;
import jack.jedynakd.score.ScoreCalculator;
import jack.jedynakd.ai.AI;
import jack.jedynakd.cards.CardDeck;

import java.util.Scanner;

public class Game {
    public static void main(String args[]) {
        CardDeck originalDeck = new CardDeck();
        System.out.println("Game begins.");
        System.out.println("Cards are shuffling...");
        originalDeck.newGame();
        System.out.println("Cards shuffled.");

        System.out.println("You start.");
        CardDeck playerHumanDeck = new CardDeck();
        Player playerHuman = new Player(playerHumanDeck, originalDeck);
        ScoreCalculator humanScore = new ScoreCalculator(playerHumanDeck);
        Scanner in = new Scanner(System.in);
        int yourChoice = 0;
        while (yourChoice == 1 || yourChoice == 0) {
            System.out.println("Draw(1), Pass(2), Show Score(0)");
            yourChoice = in.nextInt();
            if (yourChoice == 1) {
                playerHuman.draw();
                System.out.println("You drew: ");
                System.out.println(playerHuman.showYourCard());
            }
            if (yourChoice == 0) {
                System.out.println("Your score: " + humanScore.calculateScore());
            }
        }
        playerHuman.pass();
        System.out.println("Sum of your points: " + humanScore.calculateScore());

        System.out.println("Pc starts");
        CardDeck pcDeck = new CardDeck();
        Player playerPc = new Player(pcDeck, originalDeck);
        ScoreCalculator pcScore = new ScoreCalculator(pcDeck);
        AI ai = new AI(playerPc, pcScore);
        ai.controlPlayer();

        Judge judge = new Judge(pcScore, humanScore);
        System.out.println("Sum of PC points: " + pcScore.calculateScore());
        System.out.println(judge.calculateWinner());
    }
}
