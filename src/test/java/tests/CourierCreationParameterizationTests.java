package tests;

import io.qameta.allure.junit4.DisplayName;
import models.Courier;
import models.response.ErrorMessage;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static constants.ApiResponseConstants.NOT_ENOUGH_DATA_CREATE_ACCOUNT;
import static constants.StatusCode.BAD_REQUEST;
import static helper.ApiHelper.postCreateCourier;
import static random.RandomData.getRandomString;

@RunWith(Parameterized.class)
public class CourierCreationParameterizationTests {

    private String login;
    private String password;

    public CourierCreationParameterizationTests(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Parameterized.Parameters(name = "Тест: login={0}, password={1}")
    public static Collection<Object[]> invalidCredentialsData() {
        String randomString = getRandomString();
        return Arrays.asList(new Object[][]{
                {null, randomString},
                {"", randomString},
                {randomString, null},
                {randomString, ""},
                {null, null},
                {"", ""}
        });
    }

    @Test
    @DisplayName("Проверка сообщения при передаче пустых значений")
    public void checkErrorMessageWhenCreateWithoutValues() {
        Courier courier = new Courier(login, password);
        var actualMessage = postCreateCourier(courier)
                .then()
                .statusCode(BAD_REQUEST)
                .extract()
                .body().as(ErrorMessage.class);

        Assert.assertEquals(NOT_ENOUGH_DATA_CREATE_ACCOUNT, actualMessage.getMessage());
    }
}