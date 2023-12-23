package hexlet.code;

import java.util.Random;

public class Utils {
    public static int getRandomNumberBetween(int minNumber, int maxNumber) {
        return new Random().nextInt(maxNumber - minNumber + 1) + minNumber;
    }

}
