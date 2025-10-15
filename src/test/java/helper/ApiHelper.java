package helper;

import base.BaseApiHelper;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.Courier;
import models.Order;

import static io.restassured.RestAssured.given;

public final class ApiHelper extends BaseApiHelper {

    private static final String CREATE_COURIER_API = "/api/v1/courier";
    private static final String AUTHORIZATION_COURIER_API = "/api/v1/courier/login";
    private static final String ORDER_API = "/api/v1/orders";
    private static final String DELETE_COURIER_API = "/api/v1/courier";

    @Step("Создать курьера")
    public static Response postCreateCourier(Courier courier) {
        return given().contentType(ContentType.JSON)
                .body(courier)
                .post(CREATE_COURIER_API);
    }

    @Step("Авторизоваться курьером")
    public static Response postAuthorizationCourier(Courier courier) {
        return given().contentType(ContentType.JSON)
                .body(courier)
                .post(AUTHORIZATION_COURIER_API);
    }

    @Step("Создать заказ")
    public static Response postCreateOrder(Order order) {
        return given().contentType(ContentType.JSON)
                .body(order)
                .post(ORDER_API);
    }

    @Step("Получить список заказов")
    public static Response getOrdersList() {
        return given().contentType(ContentType.JSON)
                .get(ORDER_API);
    }

    @Step("Удалить курьера")
    public static Response deleteCourier(int courierId) {
        return given().contentType(ContentType.JSON)
                .pathParam("id", courierId)
                .delete(DELETE_COURIER_API + "/{id}");
    }
}