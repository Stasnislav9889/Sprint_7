package tests;

import base.BaseTests;
import io.qameta.allure.junit4.DisplayName;
import models.response.ErrorMessage;
import models.response.CreateSuccessResponse;
import org.junit.Assert;
import org.junit.Test;

import static constants.ApiResponseConstants.DUPLICATE_USERNAME;
import static constants.StatusCode.CONFLICT;
import static constants.StatusCode.CREATED;
import static helper.ApiHelper.createCourier;

public class CourierCreationTests extends BaseTests {

    @Test
    @DisplayName("Проверка создания курьера")
    public void checkCourierCreationTest() {
        var actualResponse = createCourier(courier).then()
                .statusCode(CREATED)
                .extract().body().as(CreateSuccessResponse.class);

        Assert.assertTrue(actualResponse.getOk());
    }

    @Test
    @DisplayName("Проверка сообщения об ошибке при повторном создании курьера")
    public void duplicateCourierCreationFailsTest() {
        createCourier(courier).then()
                .statusCode(CREATED);
        var actualMessage = createCourier(courier).then()
                .statusCode(CONFLICT)
                .extract().body().as(ErrorMessage.class);

        Assert.assertEquals(DUPLICATE_USERNAME, actualMessage.getMessage());
    }
}