package orders;

import static org.hamcrest.Matchers.hasKey;
import static org.junit.Assert.*;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import java.util.LinkedHashMap;
import java.util.List;

public class OrderSteps {

    private OrderApi orderApi = new OrderApi();

    private ValidatableResponse response;

    @Step("Checking the status code and the response of the POST request")
    public void postCreatePositiveOrder(Order exOrder) {
        ValidatableResponse  response = orderApi.postCreateOrders(exOrder).then();
        response.assertThat().statusCode(201);
        response.assertThat().body("$", hasKey("track"));
    }

    @Step("Checking the status code and the response of the GET request without  parameters")
    public void getListOrders() {
        ValidatableResponse response = orderApi.getListOrder().then();
        response.assertThat().statusCode(200);
        LinkedHashMap<Order, Object> orders = response.extract().jsonPath().get("$");
        assertNotNull(orders);
        assertFalse(orders.isEmpty());
    }

    @Step("Checking the status code and the response to the GET request with the id parameter")
    public void getListOrdersCourierId(Integer id) {
        ValidatableResponse response = orderApi.getListOrderCourierId(id).then();
        response.assertThat().statusCode(200);
        LinkedHashMap<Order, Object> orders = response.extract().jsonPath().get("$");
        assertNotNull(orders);
        assertFalse(orders.isEmpty());
    }

    @Step("Checking the status code and the response to the GET request with the id parameter")
    public void getListOrdersCourierIdNegative(Integer id) {
        ValidatableResponse response = orderApi.getListOrderCourierId(id).then();
        response.assertThat().statusCode(404);
        Order order = response.extract().body().as(Order.class);
        assertEquals("Курьер с идентификатором " + id + " не найден", order.getMessage());
    }

    @Step("Checking the status code and the response to the GET request with the id and station parameter")
    public void getListOrdersCourierIdAndNearestStation(Integer id, List<String> nearestStation) {
        ValidatableResponse response = orderApi.getListOrderCourierIdAndNearestStation(id, nearestStation).then();
        response.assertThat().statusCode(200);
        LinkedHashMap<Order, Object> orders = response.extract().jsonPath().get("$");
        assertNotNull(orders);
        assertFalse(orders.isEmpty());
    }

    @Step("Checking the status code and the response to the GET request with the limit and page parameter")
    public void getListOrdersLimitAndPage(Integer limit, Integer page) {
        ValidatableResponse response = orderApi.getListOrderParamLimitAndPage(limit, page).then();
        response.assertThat().statusCode(200);
        LinkedHashMap<Order, Object> orders = response.extract().jsonPath().get("$");
        assertNotNull(orders);
        assertFalse(orders.isEmpty());
    }

    @Step("Checking the status code and the response to the GET request with the limit, page and station parameter")
    public void getListOrdersLimitAndPageAndNearestStation(Integer limit, Integer page, List<String> nearestStation) {
        ValidatableResponse response = orderApi.getListOrderParamLimitAndPageAndNearestStation(limit, page, nearestStation).then();
        response.assertThat().statusCode(200);
        LinkedHashMap<Order, Object> orders = response.extract().jsonPath().get("$");
        assertNotNull(orders);
        assertFalse(orders.isEmpty());
    }
}