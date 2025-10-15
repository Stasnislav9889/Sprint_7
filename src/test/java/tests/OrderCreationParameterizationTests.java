package tests;

import io.qameta.allure.junit4.DisplayName;
import models.Order;
import models.response.CreateOrderResponse;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static java.util.Arrays.asList;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static constants.StatusCode.CREATED;
import static helper.ApiHelper.postCreateOrder;
import static org.codehaus.groovy.runtime.InvokerHelper.asList;
import static random.RandomData.getRandomOrder;

@RunWith(Parameterized.class)
public class OrderCreationParameterizationTests {

    private List<String> colorOptions;
    private static final String BLACK = "BLACK";
    private static final String GREY = "GREY";

    public OrderCreationParameterizationTests(List<String> colorOptions) {
        this.colorOptions = colorOptions;
    }

    @Parameterized.Parameters(name = "Заказ с цветами: {0}")
    public static Collection<Object[]> colorData() {
        return Arrays.asList(new Object[][]{
                {asList(BLACK)},
                {asList(GREY)},
                {asList(BLACK, GREY)},
                {null}
        });
    }

    @Test
    @DisplayName("Проверка создания заказа с различным цветом")
    public void testCreateOrderWithVariousColorsReturnsTrack() {
        Order order = getRandomOrder();
        order.setColor(colorOptions);

        var response = postCreateOrder(order)
                .then()
                .statusCode(CREATED)
                .extract()
                .body()
                .as(CreateOrderResponse.class);

        Assert.assertNotNull(response.getTrack());
        Assert.assertTrue(response.getTrack() > 0);
    }
}