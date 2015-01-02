package black;

import java.util.Scanner;

public class Controller {
	public static void main(String[] args) {
		Jack jack = new Jack();
		int yourSum = 0;
		int pcSum = 0;
		jack.makeCards();
		jack.newGame();

		System.out.println("Kto zaczyna?");
		System.out.println("PC(0) czy Ty(1)");

		Scanner in = new Scanner(System.in);
		int chooseWhoFirst = in.nextInt();

		while (chooseWhoFirst != 0 && chooseWhoFirst != 1) {
			System.out
					.println("Poda³eœ nie prawid³owe dane. Spróbuj ponownie.");
			System.out.println("Kto zaczyna?");
			System.out.println("PC(0) czy Ty(1)");
			chooseWhoFirst = in.nextInt();
		}

		if (chooseWhoFirst == 0) {
			System.out.println("Zaczyna PC");
			jack.pass();
			pcSum = jack.getSuma();
			System.out.println("Teraz ty");
			jack.setSum(0);
			int yourMove = 0;
			while (yourMove == 0 && yourSum <= 21) {
				System.out.println("Draw(0) or Pass(1)");
				yourMove = in.nextInt();
				if (yourMove == 0) {
					jack.draw();
					yourSum = jack.getSuma();
				}
			}
		}
		
		if (chooseWhoFirst == 1) {
			System.out.println("Zaczynasz ty");
			int yourMove = 0;
			while (yourMove == 0 && yourSum <= 21) {
				System.out.println("Draw(0) or Pass(1)");
				yourMove = in.nextInt();
				if (yourMove == 0) {
					jack.draw();
					yourSum = jack.getSuma();
				}
			}
			System.out.println("Teraz PC");
			jack.setSum(0);
			jack.pass();
			pcSum = jack.getSuma();
		}

		System.out.println("PC SUMA:" + pcSum);
		System.out.println("MOja SUMA:" + yourSum);
		if (pcSum > yourSum) {
			System.out.println("Wygra³ PC");
		} else if (yourSum > pcSum) {
			System.out.println("Wygra³eœ");
		} else if (pcSum > yourSum && yourSum == 21) {
			System.out.println("Wygra³eœ");
		} else if (yourSum > pcSum && pcSum == 21) {
			System.out.println("Wygra³ PC");
		} else if (yourSum == pcSum) {
			System.out.println("Remis");
		}
	}
}
