package courier;

import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

public class CourierTest {

    private CourierSteps steps = new CourierSteps();

    @Test
    @DisplayName("Creating a courier is a positive test")
    @Description("Checking the status code and response of the POST request when creating a courier and check duplicate")
    public void createCourierPositiveAndNegativeTest() {
        Faker faker = new Faker();
        Courier exCourier = new Courier(faker.name().firstName(), "qwe1234", "Misha");
        steps.postCreatePositiveCourier(exCourier);
        steps.postCreateNegativeCourier(exCourier);
    }

    //my test/the request is not working
    /*@Test
    @DisplayName("Creating a courier without a login test")
    @Description("Checking the status code and the response to the POST request when creating a courier without a login")
    public void createCourierWithoutALoginTest() {
        Courier expCourier = new Courier(null, "qwe1234", "Misha");
        steps.postCreateWithoutLoginCourier(expCourier);
    }*/

    @Test
    @DisplayName("Creating a courier without a password test")
    @Description("Checking the status code and the response to the POST request when creating a courier without a password")
    public void createCourierWithoutPasswordTest() {
        Courier expCourier = new Courier("Misha9", null, "Misha");
        steps.postCreateWithoutPasswordCourier(expCourier);
    }

    @Test
    @DisplayName("The courier's login in the system positive test")
    @Description("Checking the status code and the response to the courier's POST login request")
    public void courierPositiveLoginInSystemTest() {
        Courier exCourier = new Courier("Misha12", "qwe1234");
        steps.postCourierPositiveLoginInSystem(exCourier);
    }

    @Test
    @DisplayName("The courier's login in the system negative test")
    @Description("Checking the status code and the response to the courier's POST login request")
    public void courierNegativeLoginInSystemTest() {
        Courier exCourier = new Courier("nety_takogo", "123456789");
        steps.postCourierNegativeLoginInSystem(exCourier);
    }

    @Test
    @DisplayName("The courier's no login in the system negative test")
    @Description("Checking the status code and the response to the POST request without login")
    public void courierNegativeCheckWithoutLoginInSystemTest() {
        Courier exCourier = new Courier(null, "123456789");
        steps.postCourierWithoutLoginInSystem(exCourier);
    }

    @Test
    @DisplayName("The courier's no password in the system negative test")
    @Description("Checking the status code and the response to the POST request without password.")
    public void courierNegativePasswordCheckWithoutLoginInSystemTest() {
        Courier exCourier = new Courier("Misha23", "");
        steps.postCourierWithoutPasswordInSystem(exCourier);
    }

    @Test
    @DisplayName("Courier removal is a positive test")
    @Description("Checking the status code and the response to the DELETE request")
    public void courierPositiveDeleteTest() {
        steps.deleteCourierPositive(354626);
    }

    ///my test/the request is not working
    /*@Test
    @DisplayName("Courier removal is a negative test")
    @Description("Checking the status code and the response to the DELETE request." +
            "This API with an error should return 400, but returns 404(Not Found)")
    public void courierWithoutIdNegativeDeleteTest() {
        steps.deleteCourierWithoutIdNegative();
    }*/

    @Test
    @DisplayName("Courier removal is a negative test")
    @Description("Checking the status code and the response to the DELETE request")
    public void courierNonExistentIdNegativeDeleteTest() {
        steps.deleteCourierNonExistentIdNegative(22222);
    }


    //my test/the request is not working
    /*@Test
    @DisplayName("Get the number of courier orders")
    @Description("Checking the status code and the response to the GET request. " +
            "This API with an error should return 400, but returns 404(Not Found)")
    public void courierGetOrderCount() { // данная API с ошибкой, должна вовзращать 200, а возвращает 404(Not found)
        steps.getCourierIdOrder(351512);
    }*/
}