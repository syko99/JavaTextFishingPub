
import java.util.Random;

public class Fish_Sunfish extends Fish {
	public Fish_Sunfish() {
		Random random = new Random();
		int maxLength = 10;
		int minLength = 3;
		int maxWeight;
		int minWeight;
		species = "Sunfish";
		int randomGender = random.nextInt(genders.length);
		gender = genders[randomGender];
		length = random.nextInt(maxLength-minLength+1)+minLength;
		if (length <= 5) {
			minWeight = 2;
			maxWeight = 6;
		} else if (length > 5 && length <= 7) {
			minWeight = 6;
			maxWeight = 10;
		} else {
			minWeight = 10;
			maxWeight = 13;
		}
		weight = (random.nextInt(maxWeight-minWeight+1)+minWeight)/10.0;
		
		}
}
