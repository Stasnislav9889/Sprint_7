package tests;

import base.BaseParameterizationTests;
import io.qameta.allure.junit4.DisplayName;
import models.Courier;
import models.response.ErrorMessage;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static constants.ApiResponseConstants.INVALID_LOGIN_OR_PASS;
import static constants.StatusCode.BAD_REQUEST;
import static helper.ApiHelper.postAuthorizationCourier;

@RunWith(Parameterized.class)
public class CourierLoginParameterizationTests extends BaseParameterizationTests {

    private String login;
    private String password;

    public CourierLoginParameterizationTests(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Parameterized.Parameters(name = "Тест: login={0}, password={1}")
    public static Collection<Object[]> invalidAuthorizationData() {
        String login = courier.getLogin();
        String password = courier.getPassword();
        return Arrays.asList(new Object[][]{
                {null, password},
                {"", password},
                {login, null},
                {login, ""},
                {"", ""}
        });
    }

    @Test
    @DisplayName("Проверка сообщения об ошибке при передаче пустых значений при авторизации")
    public void checkErrorMessageWhenAuthWithoutValues() {
        Courier testCourier = new Courier(login, password);
        var actualMessage = postAuthorizationCourier(testCourier)
                .then()
                .statusCode(BAD_REQUEST)
                .extract()
                .body().as(ErrorMessage.class);

        Assert.assertEquals(INVALID_LOGIN_OR_PASS, actualMessage.getMessage());
    }
}