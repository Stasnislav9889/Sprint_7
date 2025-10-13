package helper;

import base.BaseApiHelper;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.Courier;
import models.Order;

import static io.restassured.RestAssured.given;

public final class ApiHelper extends BaseApiHelper {

    @Step("Создать курьера")
    public static Response createCourier(Courier courier) {
        return given().contentType(ContentType.JSON)
                .body(courier)
                .post("/api/v1/courier");
    }

    @Step("Авторизоваться курьером")
    public static Response authorizationCourier(Courier courier) {
        return given().contentType(ContentType.JSON)
                .body(courier)
                .post("/api/v1/courier/login");
    }

    @Step("Создать заказ")
    public static Response createOrder(Order order){
        return given().contentType(ContentType.JSON)
                .body(order)
                .post("/api/v1/orders");
    }

    @Step("Получить список заказов")
    public static Response getOrdersList(){
        return given().contentType(ContentType.JSON)
                .get("/api/v1/orders");
    }
}