import java.util.Scanner;

class Prompter {

	private Scanner scanner = new Scanner(System.in);
	private String newGuess;

	public String getItemName() {

		String item;
		do {
			System.out.println(("What type of item?"));
			item = scanner.nextLine();
		} while (item.isEmpty());

		return item;
	}

	public int getMax(String itemName) {

		String amount;
		do {
			System.out.printf("What is the maximum amount of %s?%n", itemName);
			amount = scanner.nextLine();
		} while (amount.isEmpty());
		return Integer.parseInt(amount);
	}

	public int getNewGuess(Jar jar) {

		String guess;
		do {
			System.out.printf("How many %s are in the jar? Pick a number between 1 and %d%n", jar.getObject(), jar.getMax());
			guess = scanner.nextLine();
		} while (guess.isEmpty());
		return Integer.parseInt(guess);
	}


	public void warningNoValidGuess(int guess, Jar jar) {
		if (guess > jar.getAmount()) {
			System.out.printf("Your guess must be less than %d%n", jar.getMax());
		}

		if (guess <= 0) {
			System.out.printf("Your guess must be greater than 0%n");
		}
	}

	public void showAttempts(int attempts) {
		System.out.printf("You got it in %d attempts", attempts);
	}

	public void tooHigh() {
		System.out.println("Your guess is too high");
	}

	public void tooLow() {
		System.out.println("Your guess is too low");
	}


	public void hint(int guess, Jar jar) {
		if (guess > jar.getAmount()) {
			tooHigh();
		}
		if (guess < jar.getAmount()) {
			tooLow();
		}
	}
}

