

import java.util.Random;

public class Fish_Catfish extends Fish {
	public Fish_Catfish() {
	Random random = new Random();
	int maxLength = 36;
	int minLength = 12;
	int maxWeight;
	int minWeight;
	species = "Catfish";
	int randomGender = random.nextInt(genders.length);
	gender = genders[randomGender];
	length = random.nextInt(maxLength-minLength+1)+minLength;
	if (length <= 20) {
		minWeight = 15;
		maxWeight = 45;
	} else if (length > 20 && length <= 30) {
		minWeight = 30;
		maxWeight = 70;
	} else {
		minWeight = 70;
		maxWeight = 150;
	}
	weight = (random.nextInt(maxWeight-minWeight+1)+minWeight)/10.0;
	
	}
}