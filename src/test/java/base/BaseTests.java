package base;

import models.Courier;
import org.junit.Before;

import static random.RandomData.getRandomCourier;

public class BaseTests {

    protected Courier courier;

    @Before
    public void setUp() {
        courier = getRandomCourier();
    }
}