

import java.util.Random;

public class Fish_Trout extends Fish {
	public Fish_Trout() {
	Random random = new Random();
	int maxLength = 25;
	int minLength = 10;
	int maxWeight;
	int minWeight;
	species = "Trout";
	int randomGender = random.nextInt(genders.length);
	gender = genders[randomGender];
	length = random.nextInt(maxLength-minLength+1)+minLength;
	if (length <= 15) {
		minWeight = 10;
		maxWeight = 20;
	} else if (length > 15 && length <= 20) {
		minWeight = 20;
		maxWeight = 37;
	} else {
		minWeight = 37;
		maxWeight = 60;
	}
	weight = (random.nextInt(maxWeight-minWeight+1)+minWeight)/10.0;
	
	}
}