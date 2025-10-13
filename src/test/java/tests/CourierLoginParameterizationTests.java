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

import static constants.ApiResponseConstants.INVALID_LOGIN_OR_PASS;
import static constants.StatusCode.*;
import static helper.ApiHelper.authorizationCourier;
import static helper.ApiHelper.createCourier;
import static random.RandomData.getRandomCourier;
import static random.RandomData.getRandomString;

@RunWith(Parameterized.class)
public class CourierLoginParameterizationTests {

    private String login;
    private String password;

    public CourierLoginParameterizationTests(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Parameterized.Parameters(name = "Тест: login={0}, password={1}")
    public static Collection<Object[]> invalidAuthorizationData() {
        String login = createCourser().getLogin();
        String password = createCourser().getPassword();
        String randomString = getRandomString();
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
        Courier courier = new Courier(login, password);
        var actualMessage = authorizationCourier(courier)
                .then()
                .statusCode(BAD_REQUEST)
                .extract()
                .body().as(ErrorMessage.class);

        Assert.assertEquals(INVALID_LOGIN_OR_PASS, actualMessage.getMessage());
    }

    public static Courier createCourser() {
        Courier courier = getRandomCourier();
        createCourier(getRandomCourier())
                .then()
                .statusCode(CREATED);
        return courier;
    }
}