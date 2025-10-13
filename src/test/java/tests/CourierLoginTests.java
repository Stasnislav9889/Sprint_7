package tests;

import base.BaseTests;
import io.qameta.allure.junit4.DisplayName;
import models.response.AuthorizationSuccessResponse;
import models.response.ErrorMessage;
import org.junit.Assert;
import org.junit.Test;

import static constants.ApiResponseConstants.ACCOUNT_NOT_FOUND;
import static constants.StatusCode.*;
import static helper.ApiHelper.authorizationCourier;
import static helper.ApiHelper.createCourier;

public class CourierLoginTests extends BaseTests {

    @Test
    @DisplayName("Проверка успешной авторизации")
    public void successfulAuthorizationTest() {
        createCourier(courier).then()
                .statusCode(CREATED);
        var actualResponse = authorizationCourier(courier)
                .then()
                .statusCode(OK)
                .extract()
                .body().as(AuthorizationSuccessResponse.class);

        Assert.assertNotNull(actualResponse.getId());
    }

    @Test
    @DisplayName("Проверка сообщения об ошибке при передаче невалидных данных")
    public void checkErrorMessageWhenAuthWithInvalidValues() {
        var actualResponse = authorizationCourier(courier)
                .then()
                .log()
                .all()
                .statusCode(NOT_FOUND)
                .extract()
                .body().as(ErrorMessage.class);

        Assert.assertEquals(ACCOUNT_NOT_FOUND, actualResponse.getMessage());
    }
}