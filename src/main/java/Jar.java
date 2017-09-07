import java.util.Random;

public class Jar {
	String object;
	int amount;
	int max;

	public Jar(String itemName, int max) {
		this.object = itemName;
		this.max = max;
	}


	public void fill() {
		this.amount = new Random().nextInt(max) + 1;
	}

	public String getObject() {
		return object;
	}

	public int getAmount() {
		return amount;
	}

	public int getMax() {
		return max;
	}

	public boolean isGuessValid(Jar jar, int guess) {
		return (guess > 0 && guess <= jar.getMax());
	}

}