package tests;

import base.BaseTests;
import io.qameta.allure.junit4.DisplayName;
import models.Courier;
import models.response.AuthorizationSuccessResponse;
import models.response.ErrorMessage;
import org.junit.Assert;
import org.junit.Test;

import static constants.ApiResponseConstants.ACCOUNT_NOT_FOUND;
import static constants.StatusCode.*;
import static helper.ApiHelper.postAuthorizationCourier;
import static random.RandomData.getRandomCourier;

public class CourierLoginTests extends BaseTests {

    @Test
    @DisplayName("Проверка успешной авторизации")
    public void successfulAuthorizationTest() {
        var actualResponse = postAuthorizationCourier(courier)
                .then()
                .statusCode(OK)
                .extract()
                .body().as(AuthorizationSuccessResponse.class);

        Assert.assertNotNull(actualResponse.getId());
    }

    @Test
    @DisplayName("Проверка сообщения об ошибке при передаче невалидных данных")
    public void checkErrorMessageWhenAuthWithInvalidValues() {
        var actualResponse = postAuthorizationCourier(getRandomCourier())
                .then()
                .log()
                .all()
                .statusCode(NOT_FOUND)
                .extract()
                .body().as(ErrorMessage.class);

        Assert.assertEquals(ACCOUNT_NOT_FOUND, actualResponse.getMessage());
    }
}