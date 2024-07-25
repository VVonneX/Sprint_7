package orders;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import java.util.Arrays;

public class OrderTest {

    private OrderSteps steps = new OrderSteps();

    @Test
    @DisplayName("Get order list test")
    @Description("Checking the status code and the response of the GET request without  parameters")
    public void getOrderListTest() {
        steps.getListOrders();
    }

    @Test
    @DisplayName("Get order list by courier id test")
    @Description("Checking the status code and the response to the GET request with the id parameter")
    public void getOrderListByCourierIdTest() {
        steps.getListOrdersCourierId(355012);
    }

    @Test
    @DisplayName("Get order list by courier id and nearest station test")
    @Description("Checking the status code and the response to the GET request with the id and station parameter")
    public void getOrderListByCourierIdAndNearestStationTest() {
        steps.getListOrdersCourierIdAndNearestStation(355003, Arrays.asList("1", "2"));
    }

    @Test
    @DisplayName("Get order list by limit and page test")
    @Description("Checking the status code and the response to the GET request with the limit and page parameter")
    public void getOrderListByLimitAndPageTest() {
        steps.getListOrdersLimitAndPage(10,0);
    }

    @Test
    @DisplayName("Get order list by limit, page and nearest station test")
    @Description("Checking the status code and the response to the GET request with the limit, page and station parameter")
    public void getOrderListByLimitAndPageAndNearestStationTest() {
        steps.getListOrdersLimitAndPageAndNearestStation(10,0, Arrays.asList("110"));
    }

    @Test
    @DisplayName("Get order list by courier id negative test")
    @Description("Checking the status code and the response to the GET request with the id parameter")
    public void getOrderListByCourierIdNegativeTest() {
        steps.getListOrdersCourierIdNegative(12345);
    }

}
