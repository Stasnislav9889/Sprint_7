package tests;

import base.BaseTests;
import io.qameta.allure.junit4.DisplayName;
import models.response.ErrorMessage;
import org.junit.Assert;
import org.junit.Test;

import static constants.ApiResponseConstants.DUPLICATE_USERNAME;
import static constants.StatusCode.CONFLICT;
import static helper.ApiHelper.postCreateCourier;

public class CourierCreationTests extends BaseTests {

    @Test
    @DisplayName("Проверка создания курьера")
    public void checkCourierCreationTest() {
        Assert.assertTrue(createSuccessResponse.getOk());
    }

    @Test
    @DisplayName("Проверка сообщения об ошибке при повторном создании курьера")
    public void duplicateCourierCreationFailsTest() {
        var actualMessage = postCreateCourier(courier).then()
                .statusCode(CONFLICT)
                .extract().body().as(ErrorMessage.class);

        Assert.assertEquals(DUPLICATE_USERNAME, actualMessage.getMessage());
    }
}