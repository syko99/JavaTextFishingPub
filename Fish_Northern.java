

import java.util.Random;

public class Fish_Northern extends Fish {
	public Fish_Northern() {
	Random random = new Random();
	int maxLength = 45;
	int minLength = 12;
	int maxWeight;
	int minWeight;
	species = "Northern Pike";
	int randomGender = random.nextInt(genders.length);
	gender = genders[randomGender];
	length = random.nextInt(maxLength-minLength+1)+minLength;
	if (length <= 20) {
		minWeight = 16;
		maxWeight = 30;
	} else if (length > 20 && length <= 30) {
		minWeight = 30;
		maxWeight = 70;
	} else {
		minWeight = 50;
		maxWeight = 100;
	}
	weight = (random.nextInt(maxWeight-minWeight+1)+minWeight)/10.0;
	
	}
}
