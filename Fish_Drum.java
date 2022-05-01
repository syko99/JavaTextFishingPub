

import java.util.Random;

public class Fish_Drum extends Fish {
	public Fish_Drum() {
	Random random = new Random();
	int maxLength = 25;
	int minLength = 10;
	int maxWeight;
	int minWeight;
	species = "Drum";
	int randomGender = random.nextInt(genders.length);
	gender = genders[randomGender];
	length = random.nextInt(maxLength-minLength+1)+minLength;
	if (length <= 15) {
		minWeight = 15;
		maxWeight = 30;
	} else if (length > 15 && length <= 20) {
		minWeight = 30;
		maxWeight = 50;
	} else {
		minWeight = 50;
		maxWeight = 75;
	}
	weight = (random.nextInt(maxWeight-minWeight+1)+minWeight)/10.0;
	
	}
}