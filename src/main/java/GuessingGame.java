import java.util.Scanner;

public class GuessingGame {
	public static void main(String[] args) {
		boolean win = false;
		int tries = 0;

		Scanner scanner = new Scanner(System.in);
		Prompter prompter = new Prompter();

		String itemName = prompter.getItemName();
		int max = prompter.getMax(itemName);

		Jar jar = new Jar(itemName, max);
		jar.fill();

		while (!win) {
			int guess = prompter.getNewGuess(jar);
			if (jar.isGuessValid(jar, guess)) {
				tries++;
				if (guess != jar.getAmount()) {
					prompter.hint(guess, jar);
				} else win = true;
			} else {
				prompter.warningNoValidGuess(guess, jar);
			}
		}

		prompter.showAttempts(tries);

	}


}