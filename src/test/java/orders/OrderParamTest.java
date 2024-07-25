package orders;


import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

@RunWith(Parameterized.class)
public class OrderParamTest {

    private OrderSteps steps = new OrderSteps();

    private Order order;

    public OrderParamTest(String firstName,  String lastName, String address, String metroStation, String phone, Integer rentTime, String deliveryDate, String comment, List<String> color) {
        this.order = new Order(firstName, lastName, address, metroStation,phone, rentTime, deliveryDate, comment, color);
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"Миша", "Чуриков", "Есенина 21", "Красносельская", "11111111111", 5, "2024-07-30", "Привезите во 2 половине дня!", Arrays.asList("BLACK")},
                {"Миша", "Чуриков", "Есенина 21", "Красносельская", "11111111111", 5, "2024-07-30", "Привезите во 2 половине дня!", Arrays.asList("BLACK", "GRAY")},
                {"Миша", "Чуриков", "Есенина 21", "Красносельская", "11111111111", 5, "2024-07-30", "Привезите во 2 половине дня!", Arrays.asList()},
        };
    }

    @Test
    @DisplayName("Create order test")
    @Description("Checking the status code and the response of the POST request")
    public void createOrderTest() {
        steps.postCreatePositiveOrder(order);
    }

}