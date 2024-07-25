package courier;

import courier.Courier;
import courier.CourierApi;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CourierSteps {

    private CourierApi courierApi = new CourierApi();

    private ValidatableResponse response;

    @Step("Checking the status code and the response to the GET request")
    public void getCourierIdOrder(Integer id) {
        response = courierApi.getCourierIdOrder(id).then();
        response.assertThat().statusCode(200);
        Courier courierFromApi = response.extract().body().as(Courier.class);
        assertEquals(id, courierFromApi.getId());
    }

    @Step("Checking the status code and response of the POST request when creating a courier")
    public void postCreatePositiveCourier(Courier expectCourier) {
        ValidatableResponse  response = courierApi.postCreateCourier(expectCourier).then();
        response.assertThat().statusCode(201);
        String courierFromApi = response.extract().body().asString();
        assertTrue(courierFromApi.contains("true"));
    }

    @Step("Checking the status code and response of the POST request when creating a courier")
    public void postCreateNegativeCourier(Courier expCourier) {
        ValidatableResponse response = courierApi.postCreateCourier(expCourier).then();
        response.assertThat().statusCode(409);
        Courier courierFromApi = response.extract().body().as(Courier.class);
        assertEquals("Этот логин уже используется. Попробуйте другой.", courierFromApi.getMessage());
    }

    @Step("Checking the status code and the response to the POST request when creating a courier without a login")
    public void postCreateWithoutLoginCourier(Courier exCourier) {
        ValidatableResponse response = courierApi.postCreateCourier(exCourier).then();
        response.assertThat().statusCode(400);
        Courier courierFromApi = response.extract().body().as(Courier.class);
        assertEquals("Недостаточно данных для создания учетной записи", courierFromApi.getMessage());
    }

    @Step("Checking the status code and the response to the POST request when creating a courier without a password")
    public void postCreateWithoutPasswordCourier(Courier exCourier) {
        ValidatableResponse response = courierApi.postCreateCourier(exCourier).then();
        response.assertThat().statusCode(400);
        Courier courierFromApi = response.extract().body().as(Courier.class);
        assertEquals("Недостаточно данных для создания учетной записи", courierFromApi.getMessage());
    }

    @Step("Checking the status code and the response to the courier's POST login request")
    public void postCourierPositiveLoginInSystem(Courier expectCourier) {
        ValidatableResponse response = courierApi.postCourierCheckLogin(expectCourier).then();
        response = response.assertThat().statusCode(200);
        Courier courierFromApi = response.extract().body().as(Courier.class);
        assertEquals(351512, courierFromApi.getId().intValue());
    }

    @Step("Checking the status code and the response to the courier's POST login request")
    public void postCourierNegativeLoginInSystem(Courier expectCourier) {
        ValidatableResponse response = courierApi.postCourierCheckLogin(expectCourier).then();
        response = response.assertThat().statusCode(404);
        Courier courierFromApi = response.extract().body().as(Courier.class);
        assertEquals("Учетная запись не найдена", courierFromApi.getMessage());
    }

    @Step("Checking the status code and the response to the POST request without password")
    public void postCourierWithoutPasswordInSystem(Courier expectCourier) {
        ValidatableResponse response = courierApi.postCourierCheckLogin(expectCourier).then();
        response.assertThat().statusCode(400);
        Courier courierFromApi = response.extract().body().as(Courier.class);
        assertEquals("Недостаточно данных для входа", courierFromApi.getMessage());
    }

    @Step("Checking the status code and the response to the POST request without login")
    public void postCourierWithoutLoginInSystem(Courier expectCourier) {
        ValidatableResponse response = courierApi.postCourierCheckLogin(expectCourier).then();
        response = response.assertThat().statusCode(400);
        Courier courierFromApi = response.extract().body().as(Courier.class);
        assertEquals("Недостаточно данных для входа", courierFromApi.getMessage());
    }

    @Step("Checking the status code and the response to the DELETE request")
    public void deleteCourierPositive(Integer id) {
        ValidatableResponse response = courierApi.deleteCourier(id).then();
        response.assertThat().statusCode(200);
        String courierFromApi = response.extract().body().asString();
        assertTrue(courierFromApi.contains("true"));;
    }

    @Step("Checking the status code and the response to the DELETE request")
    public void deleteCourierWithoutIdNegative() {
        ValidatableResponse response = courierApi.deleteCourier().then();
        response.assertThat().statusCode(400);
        Courier courierFromApi = response.extract().body().as(Courier.class);
        assertEquals("Недостаточно данных для удаления курьера", courierFromApi.getMessage());
    }

    @Step("Checking the status code and the response to the DELETE request")
    public void deleteCourierNonExistentIdNegative(Integer id) {
        ValidatableResponse response = courierApi.deleteCourier(id).then();
        response.assertThat().statusCode(404);
        Courier courierFromApi = response.extract().body().as(Courier.class);
        assertEquals("Курьера с таким id нет.", courierFromApi.getMessage());
    }
}