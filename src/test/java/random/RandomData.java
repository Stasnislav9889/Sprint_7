package random;

import models.Courier;
import models.Order;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import static constants.CommonConstants.*;

public final class RandomData {
    private final static Random random = new Random();

    public static Courier getRandomCourier() {
        int randomNumber = random.nextInt(1_000_000);
        String login = (String.format("%s%s", COURIER_LOGIN, randomNumber));
        String password = (String.format("%s%s", COURIER_PASSWORD, randomNumber));
        String firstName = (String.format("%s%s", COURIER_FIRST_NAME, randomNumber));

        return new Courier(login, password, firstName);
    }

    public static String getRandomString() {
        int randomNumber = random.nextInt(1_000_000);

        return String.format("%s%s", COURIER_LOGIN, randomNumber);
    }

    public static Order getRandomOrder() {
        String firstName = getRandomString();
        String lastName = getRandomString();
        String address = getRandomString();
        String phone = (String.format("%s%s", "+7800", random.nextInt(10_000_000)));
        String comment = getRandomString();
        Integer rentTime = random.nextInt(10);
        String deliveryDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        Integer metroStation = random.nextInt(50);

        return new Order(firstName, lastName, address, phone, comment, rentTime, deliveryDate, metroStation);
    }
}