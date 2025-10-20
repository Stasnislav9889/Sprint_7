package base;

import models.Courier;
import models.response.AuthorizationSuccessResponse;
import org.junit.After;
import org.junit.Before;

import static constants.StatusCode.CREATED;
import static constants.StatusCode.OK;
import static helper.ApiHelper.*;
import static random.RandomData.getRandomCourier;

public class BaseParameterizationTests {

    protected static Courier courier = getRandomCourier();

    @Before
    public void setUp() throws Exception {
        createCourier();
    }

    @After
    public void tearDown() throws Exception {
        deleteCourierAfterTest();
    }

    protected void createCourier() {
        postCreateCourier(courier).then()
                .statusCode(CREATED);
    }

    protected void deleteCourierAfterTest() {
        deleteCourier(getCourierId()).then().statusCode(OK);
    }

    protected int getCourierId() {
        return postAuthorizationCourier(courier).then().statusCode(OK)
                .extract().as(AuthorizationSuccessResponse.class).getId();
    }
}