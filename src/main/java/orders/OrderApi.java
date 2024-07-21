package orders;

import BaseURL.BaseHttpClient;
import io.restassured.response.Response;

import java.util.List;

public class OrderApi extends BaseHttpClient {

    private final String apiPath = "/api/v1/orders";

    public Response postCreateOrders(Order order) {
        return doPostRequest(apiPath, order);
    }

    public Response getListOrder() {
        return doGetRequest(apiPath);
    }

    public Response getListOrderCourierId(Integer id) {
        return doGetRequest(apiPath, id);
    }

    public Response getListOrderCourierIdAndNearestStation(Integer id, List<String> nearestStation) {
        return doGetRequest(apiPath, id, nearestStation);
    }

    public Response getListOrderParamLimitAndPage(Integer limit, Integer page) {
        return doGetRequest(apiPath, limit, page);
    }

    public Response getListOrderParamLimitAndPageAndNearestStation(Integer limit, Integer page, List<String> nearestStation) {
        return doGetRequest(apiPath, limit, page, nearestStation);
    }
}
