package utils;

import java.util.Random;

public class RandomDataUtility {

    public static int generateRandomNumber() {

        return 10000 + new Random().nextInt(90000);
    }

    public static String generateRandomMobileNumber() {

        Random random = new Random();

        return "9" + String.format(
            "%09d",
            random.nextInt(1000000000)
        );
    }
}