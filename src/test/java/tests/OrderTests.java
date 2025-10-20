package tests;

import base.BaseTests;
import io.qameta.allure.junit4.DisplayName;
import models.response.OrderResponse;
import org.junit.Assert;
import org.junit.Test;

import static constants.StatusCode.OK;
import static helper.ApiHelper.getOrdersList;

public class OrderTests extends BaseTests {

    @Test
    @DisplayName("Проверка успешного получения списка заказов")
    public void checkSuccessfulOrdersList() {
        var orderList = getOrdersList().then()
                .statusCode(OK)
                .extract()
                .body().as(OrderResponse.class).getOrders();

        Assert.assertNotNull(orderList);
        Assert.assertFalse(orderList.isEmpty());
    }
}
