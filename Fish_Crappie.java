

import java.util.Random;

public class Fish_Crappie extends Fish {
	public Fish_Crappie() {
		Random random = new Random();
		int maxLength = 14;
		int minLength = 3;
		int maxWeight;
		int minWeight;
		species = "Crappie";
		int randomGender = random.nextInt(genders.length);
		gender = genders[randomGender];
		length = random.nextInt(maxLength-minLength+1)+minLength;
		if (length <= 6) {
			minWeight = 2;
			maxWeight = 8;
		} else if (length > 6 && length <= 10) {
			minWeight = 8;
			maxWeight = 17;
		} else {
			minWeight = 15;
			maxWeight = 20;
		}
		weight = (random.nextInt(maxWeight-minWeight+1)+minWeight)/10.0;
		
		}
}