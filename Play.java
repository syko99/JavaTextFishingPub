import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class Play {

	public static void main(String[] args) throws InterruptedException {
		mainMenu();
	}

	public static void mainMenu() throws InterruptedException {
		char playerChoice;

		System.out.println("Welcome to the Fishing Game!"); // Welcome message
		System.out.println("====================================");
		Scanner menuScanner = new Scanner(System.in);
		System.out.println("Select an option:");
		System.out.println("A. Play");
		System.out.println("B. Exit");
		do { // Loop option selection until user inputs valid option
			playerChoice = menuScanner.next().charAt(0);
			playerChoice = Character.toUpperCase(playerChoice);
			switch (playerChoice) {
			case 'A': //runs method with character creation
				playMenu(); 
				break;
			case 'B': //leaves loop
				System.out.println("Thanks for coming.");
				System.exit(0);
			default: //repeats loop
				System.out.println("Invalid option, please choose again.");
				System.out.println("\n");
				break;
			}
		} while (playerChoice != 'B'); 
	}

	public static void playMenu() throws InterruptedException {
		String playerName; // Instance variables later used as arguments for creating Angler instance
		String location;
		Scanner playMenuScanner = new Scanner(System.in);
		System.out.println("\n");
		System.out.println("====================================");
		System.out.println("Create your character");
		System.out.println("What is your name?");
		playerName = playMenuScanner.nextLine(); // Assigns player's name
		System.out.println("\n");
		System.out.println("Hello " + playerName + "! Where would you like to fish?");
		System.out.println("Lake - River");
		location = playMenuScanner.nextLine(); // Assigns players fishing location
		Angler player = new Angler(playerName, location); // Creates instance of Angler
		if (player.getLocation().equalsIgnoreCase("lake")) {	// Selects one of two fishing locations based on Angler
			System.out.println("Welcome to the lake!");
			System.out.println("Please choose an option below.");
			System.out.println("\n");
			lakeMenu(player); //runs lake main menu screen
		} else if (player.getLocation().equalsIgnoreCase("river")) {
			System.out.println("Welcome to the river!");
			System.out.println("Please choose an option below.");
			System.out.println("\n");
			riverMenu(player); //runs river main menu screen
		}
	}

	public static void lakeMenu(Angler player) throws InterruptedException {
		char userChoice; //used as input for switch case

		System.out.println("========================");
		System.out.println("A. Fish");
		System.out.println("B. Catch History");
		System.out.println("C. Exit");
		Scanner lakeMenuScanner = new Scanner(System.in);

		do {
			userChoice = lakeMenuScanner.next().charAt(0);
			userChoice = Character.toUpperCase(userChoice);
			switch (userChoice) {	//selects from options in lake menu
			case 'A':
				lakeFishing(player); //runs method that simulates fishing at lake
				break;
			case 'B':
				if (player.catchHistory.size() == 0) {
					System.out.println("You haven't caught any fish yet!");
					System.out.println("\n");
					lakeMenu(player); //returns back to lake menu options
				} else {
					catchHistory(player); // shows existing catch history
					lakeMenu(player);	// then returns back to lake menu options
				}
				break;
			case 'C':
				System.out.println("Returning to main menu...");
				System.out.println(" ");
				mainMenu(); //returns to the previous menu, the Main menu
				break;
			default:
				System.out.println("Invalid option. Please enter again.");
				System.out.println("\n");
				break;
			}
		} while (userChoice != 'C');

	}

	public static void lakeFishing(Angler player) throws InterruptedException {

		HashMap<String, Integer> allFish = new HashMap<String, Integer>(); //hashmap serving as list of possible fish to catch and their likelihood of being caught
		allFish.put("Largemouth Bass", 20);
		allFish.put("Smallmouth Bass", 25);
		allFish.put("Sunfish", 50);
		allFish.put("Crappie", 60);
		allFish.put("White Bass", 65);	//the values represented as integers simulate the percentage of being caught. A key's value minus the previous is the percentage of being caught.
		allFish.put("Northern Pike", 80);
		allFish.put("Walleye", 85);
		allFish.put("Muskie", 90);
		allFish.put("Catfish", 95);
		allFish.put("Drum", 100);
		Scanner lakeFishingScanner = new Scanner(System.in);

		player.waitForFish(); //simulates waiting for a fish to bite, random wait time up to 10 seconds.
		int percentage = player.getPercentage();
		if (percentage <= allFish.get("Largemouth Bass")) {	//uses a random int and compares to values in fish hashmap to decide which fish was caught.
			Fish newFish = new Fish_Largemouth(); //creates new fish object based on species
			player.catchHistory.push(newFish); //adds fish object to a history stack
			fishCaughtDialouge(newFish, player); //tells user the fish they caught and details about it
			lakeAfterFishCaught(player); //runs method that allows user to continue or quit fishing
		} else if (percentage > allFish.get("Largemouth Bass") && percentage <= allFish.get("Smallmouth Bass")) {
			Fish newFish = new Fish_Smallmouth();
			player.catchHistory.push(newFish);
			fishCaughtDialouge(newFish, player);
			lakeAfterFishCaught(player);
		} else if (percentage > allFish.get("Smallmouth Bass") && percentage <= allFish.get("Sunfish")) {
			Fish newFish = new Fish_Sunfish();
			player.catchHistory.push(newFish);
			fishCaughtDialouge(newFish, player);
			lakeAfterFishCaught(player);
		} else if (percentage > allFish.get("Sunfish") && percentage <= allFish.get("Crappie")) {
			Fish newFish = new Fish_Crappie();
			player.catchHistory.push(newFish);
			fishCaughtDialouge(newFish, player);
			lakeAfterFishCaught(player);
		} else if (percentage > allFish.get("Crappie") && percentage <= allFish.get("White Bass")) {
			Fish newFish = new Fish_Whitebass();
			player.catchHistory.push(newFish);
			fishCaughtDialouge(newFish, player);
			lakeAfterFishCaught(player);
		} else if (percentage > allFish.get("White Bass") && percentage <= allFish.get("Northern Pike")) {
			Fish newFish = new Fish_Northern();
			player.catchHistory.push(newFish);
			fishCaughtDialouge(newFish, player);
			lakeAfterFishCaught(player);
		} else if (percentage > allFish.get("Northern Pike") && percentage <= allFish.get("Walleye")) {
			Fish newFish = new Fish_Walleye();
			player.catchHistory.push(newFish);
			fishCaughtDialouge(newFish, player);
			lakeAfterFishCaught(player);
		} else if (percentage > allFish.get("Walleye") && percentage <= allFish.get("Muskie")) {
			Fish newFish = new Fish_Muskie();
			player.catchHistory.push(newFish);
			fishCaughtDialouge(newFish, player);
			lakeAfterFishCaught(player);
		} else if (percentage > allFish.get("Muskie") && percentage <= allFish.get("Catfish")) {
			Fish newFish = new Fish_Catfish();
			player.catchHistory.push(newFish);
			fishCaughtDialouge(newFish, player);
			lakeAfterFishCaught(player);
		} else if (percentage > allFish.get("Catfish") && percentage <= allFish.get("Drum")) {
			Fish newFish = new Fish_Drum();
			player.catchHistory.push(newFish);
			fishCaughtDialouge(newFish, player);
			lakeAfterFishCaught(player);
		}
	}

	public static void riverMenu(Angler player) throws InterruptedException {
		char userChoice;

		System.out.println("========================");
		System.out.println("A. Fish");
		System.out.println("B. Catch History");
		System.out.println("C. Exit");
		Scanner riverMenuScanner = new Scanner(System.in);

		do {
			userChoice = riverMenuScanner.next().charAt(0);
			userChoice = Character.toUpperCase(userChoice);
			switch (userChoice) {
			case 'A':
				riverFishing(player);
				break;
			case 'B':
				if (player.catchHistory.size() == 0) {
					System.out.println("You haven't caught any fish yet!");
					System.out.println("\n");
					riverMenu(player);
				} else {
					catchHistory(player);
					riverMenu(player);
				}
				break;
			case 'C':
				System.out.println("Returning to main menu...");
				System.out.println(" ");
				mainMenu();
				break;
			default:
				System.out.println("Invalid option. Please enter again.");
				System.out.println("\n");
				break;
			}
		} while (userChoice != 'C');
	}

	public static void riverFishing(Angler player) throws InterruptedException {

		HashMap<String, Integer> allFish = new HashMap<String, Integer>();
		allFish.put("Largemouth Bass", 5);
		allFish.put("Smallmouth Bass", 20);
		allFish.put("Sunfish", 25);
		allFish.put("Crappie", 35);
		allFish.put("White Bass", 50);
		allFish.put("Northern Pike", 60);
		allFish.put("Walleye", 70);
		allFish.put("Muskie", 75);
		allFish.put("Catfish", 90);
		allFish.put("Drum", 100);
		Scanner lakeFishingScanner = new Scanner(System.in);

		player.waitForFish();
		int percentage = player.getPercentage();
		if (percentage <= allFish.get("Largemouth Bass")) {
			Fish newFish = new Fish_Largemouth();
			player.catchHistory.push(newFish);
			fishCaughtDialouge(newFish, player);
			riverAfterFishCaught(player);
		} else if (percentage > allFish.get("Largemouth Bass") && percentage <= allFish.get("Smallmouth Bass")) {
			Fish newFish = new Fish_Smallmouth();
			player.catchHistory.push(newFish);
			fishCaughtDialouge(newFish, player);
			riverAfterFishCaught(player);
		} else if (percentage > allFish.get("Smallmouth Bass") && percentage <= allFish.get("Sunfish")) {
			Fish newFish = new Fish_Sunfish();
			player.catchHistory.push(newFish);
			fishCaughtDialouge(newFish, player);
			riverAfterFishCaught(player);
		} else if (percentage > allFish.get("Sunfish") && percentage <= allFish.get("Crappie")) {
			Fish newFish = new Fish_Crappie();
			player.catchHistory.push(newFish);
			fishCaughtDialouge(newFish, player);
			riverAfterFishCaught(player);
		} else if (percentage > allFish.get("Crappie") && percentage <= allFish.get("White Bass")) {
			Fish newFish = new Fish_Whitebass();
			player.catchHistory.push(newFish);
			fishCaughtDialouge(newFish, player);
			riverAfterFishCaught(player);
		} else if (percentage > allFish.get("White Bass") && percentage <= allFish.get("Northern Pike")) {
			Fish newFish = new Fish_Northern();
			player.catchHistory.push(newFish);
			fishCaughtDialouge(newFish, player);
			riverAfterFishCaught(player);
		} else if (percentage > allFish.get("Northern Pike") && percentage <= allFish.get("Walleye")) {
			Fish newFish = new Fish_Walleye();
			player.catchHistory.push(newFish);
			fishCaughtDialouge(newFish, player);
			riverAfterFishCaught(player);
		} else if (percentage > allFish.get("Walleye") && percentage <= allFish.get("Muskie")) {
			Fish newFish = new Fish_Muskie();
			player.catchHistory.push(newFish);
			fishCaughtDialouge(newFish, player);
			riverAfterFishCaught(player);
		} else if (percentage > allFish.get("Muskie") && percentage <= allFish.get("Catfish")) {
			Fish newFish = new Fish_Catfish();
			player.catchHistory.push(newFish);
			fishCaughtDialouge(newFish, player);
			riverAfterFishCaught(player);
		} else if (percentage > allFish.get("Catfish") && percentage <= allFish.get("Drum")) {
			Fish newFish = new Fish_Drum();
			player.catchHistory.push(newFish);
			fishCaughtDialouge(newFish, player);
			riverAfterFishCaught(player);
		}
	}

	public static void catchHistory(Angler player) throws InterruptedException { // lets player see catch history
		Fish newFish;
		Stack<Fish> catchHistoryCopy = (Stack<Fish>) player.catchHistory.clone();
		int history = player.catchHistory.size();
		for (int i = 0; i < history; i++) { //prints out each fish in catch history stack
			newFish = catchHistoryCopy.pop();
			System.out.println("Species: " + newFish.getSpecies() + ", Gender: " + newFish.getGender() + ", Weight: "
					+ newFish.getWeight() + " lbs, Length: " + newFish.getLength() + " in.");
		}
		System.out.println("\n");
	}

	public static void lakeAfterFishCaught(Angler player) throws InterruptedException { //method for player to continue or quit fishing
		Scanner afterLakeFish = new Scanner(System.in);
		char userChoice;
		do {
			userChoice = afterLakeFish.next().charAt(0);
			userChoice = Character.toUpperCase(userChoice);
			switch (userChoice) {
			case 'A':
				lakeFishing(player);
				break;
			case 'B':
				System.out.println("Returning to lake menu...");
				System.out.println(" ");
				lakeMenu(player);
				return;
			default:
				System.out.println("Invalid option. Please enter again.");
				System.out.println("\n");
				break;
			}
		} while (userChoice != 'B');
	}

	public static void riverAfterFishCaught(Angler player) throws InterruptedException { //method for player to continue or quit fishing
		Scanner afterRiverFish = new Scanner(System.in);
		char userChoice;
		do {
			userChoice = afterRiverFish.next().charAt(0);
			userChoice = Character.toUpperCase(userChoice);
			switch (userChoice) {
			case 'A':
				riverFishing(player);
				break;
			case 'B':
				System.out.println("Returning to river menu...");
				System.out.println(" ");
				riverMenu(player);
				return;
			default:
				System.out.println("Invalid option. Please enter again.");
				System.out.println("\n");
				break;
			}
		} while (userChoice != 'B');
	}

	public static void fishCaughtDialouge(Fish newFish, Angler player) throws InterruptedException { //method that prints dialogue to let player know about the fish they caught
		System.out.println("You caught a " + newFish.getSpecies());
		System.out.println("\n");
		System.out.println("Weight: " + newFish.getWeight() + " lbs");
		System.out.println("Length: " + newFish.getLength() + " in");
		System.out.println("Gender: " + newFish.getGender());
		System.out.println("\n");
		System.out.println("Worms left: " + player.getWorms());
		System.out.println(" ");
		if (player.getWorms() == 0) {
			System.out.println("Looks like you've ran out of worms!");
			System.out.println("No more fishing for today!");
			System.out.println("Here's what you caught: ");
			System.out.println("\n");
			catchHistory(player);
			System.out.println("Thanks for playing!");
			System.exit(0);
		} else {
			System.out.println("Cast again?");
			System.out.println("A. Yes");
			System.out.println("B. No");
		}
	}

}
