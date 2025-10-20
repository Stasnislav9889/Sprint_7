package base;

import models.Courier;
import models.response.AuthorizationSuccessResponse;
import models.response.CreateSuccessResponse;
import org.junit.After;
import org.junit.Before;

import static constants.StatusCode.CREATED;
import static constants.StatusCode.OK;
import static helper.ApiHelper.*;
import static random.RandomData.getRandomCourier;

public class BaseTests {

    protected Courier courier;
    protected CreateSuccessResponse createSuccessResponse;

    @Before
    public void setUp() {
        createCourier();
    }

    @After
    public void tearDown() throws Exception {
        deleteCourierAfterTest();
    }

    protected void createCourier() {
        courier = getRandomCourier();
        createSuccessResponse = postCreateCourier(courier).then()
                .statusCode(CREATED)
                .extract().body().as(CreateSuccessResponse.class);
    }

    protected void deleteCourierAfterTest() {
        int idCourier = postAuthorizationCourier(courier).then().statusCode(OK)
                .extract().as(AuthorizationSuccessResponse.class).getId();
        deleteCourier(idCourier).then().statusCode(OK);
    }
}