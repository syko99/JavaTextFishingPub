

import java.util.Random;

public class Fish_Walleye extends Fish {
	public Fish_Walleye() {
	Random random = new Random();
	int maxLength = 32;
	int minLength = 12;
	int maxWeight;
	int minWeight;
	species = "Walleye";
	int randomGender = random.nextInt(genders.length);
	gender = genders[randomGender];
	length = random.nextInt(maxLength-minLength+1)+minLength;
	if (length <= 18) {
		minWeight = 16;
		maxWeight = 30;
	} else if (length > 18 && length <= 24) {
		minWeight = 20;
		maxWeight = 50;
	} else {
		minWeight = 40;
		maxWeight = 100;
	}
	weight = (random.nextInt(maxWeight-minWeight+1)+minWeight)/10.0;
	
	}
}
