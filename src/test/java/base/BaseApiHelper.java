package base;

import io.restassured.RestAssured;

public class BaseApiHelper {

    static {
        RestAssured.baseURI = "https://qa-scooter.praktikum-services.ru";
    }
}
