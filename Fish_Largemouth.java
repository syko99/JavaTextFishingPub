
import java.util.Random;

public class Fish_Largemouth extends Fish {
	public Fish_Largemouth() {
		Random random = new Random();
		int maxLength = 25;
		int minLength = 10;
		int maxWeight;
		int minWeight;
		species = "Largemouth Bass";
		int randomGender = random.nextInt(genders.length);
		gender = genders[randomGender];
		length = random.nextInt(maxLength - minLength + 1) + minLength;
		if (length <= 15) {
			minWeight = 5;
			maxWeight = 20;
		} else if (length > 15 && length <= 20) {
			minWeight = 20;
			maxWeight = 45;
		} else {
			minWeight = 45;
			maxWeight = 90;
		}
		weight = (random.nextInt(maxWeight - minWeight + 1) + minWeight) / 10.0;

	}
}
