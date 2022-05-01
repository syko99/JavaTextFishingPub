
import java.util.Random;
import java.util.Stack;
import java.util.Timer;

public class Angler {
	private String name;
	private String location;
	private int worms = 10;
	int percentage;
	Random random = new Random();
	Timer catchTimer = new Timer();
	Stack<Fish> catchHistory = new Stack<Fish>();

	public Angler(String playerName, String fishLocation) {
		name = playerName;
		location = fishLocation;
	}
	
	public void waitForFish() throws InterruptedException {
		System.out.println("waiting for fish...");
		int timerUpperLimit = 1000;
		int timerLowerLimit = 500;
		long timer = random.nextInt(((timerUpperLimit-timerLowerLimit)+timerLowerLimit)*10); // Randomly selects time <10 sec
		Thread.sleep(timer); // Waiting for selected time
		int randPercentage = random.nextInt(101); // Chooses int from 1-100
		percentage = randPercentage; // Sets int as percentage to determine fish that was caught
		System.out.println("A fish took the bait!\n");
		int loseWorm = random.nextInt(2); //50% chance of losing worm
		if (loseWorm == 0) {
			worms--;
		}
	}
	
	public int getWorms() {
		return worms;
	}

	public void setWorms(int worms) {
		this.worms = worms;
	}

	public int getPercentage() {
		return percentage;
	}

	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Stack<Fish> getCatchHistory() {
		return catchHistory;
	}

}