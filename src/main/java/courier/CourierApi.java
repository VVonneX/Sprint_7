package courier;

import BaseURL.BaseHttpClient;
import io.restassured.response.Response;

public class CourierApi extends BaseHttpClient {

    private final String apiPath = "/api/v1/courier";

    public Response getCourierIdOrder(Integer id) {
        return doGetRequest(apiPath + "/" + id + "/ordersCount");
    }

    public Response postCourierCheckLogin(Courier courier) {
        return doPostRequest(apiPath + "/login", courier);
    }

    public Response postCreateCourier(Courier courier) {
        return doPostRequest(apiPath, courier);
    }

    public Response deleteCourier(Integer id) {
        return doDeleteRequest(apiPath, id);
    }
    public Response deleteCourier() {
        return doDeleteRequest(apiPath);
    }
}
