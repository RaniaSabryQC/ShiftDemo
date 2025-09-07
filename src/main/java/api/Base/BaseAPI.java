package api.Base;

import com.shaft.driver.SHAFT;
import io.restassured.RestAssured;

public class BaseAPI {
    public final SHAFT.API api;

    public BaseAPI() {
       api = new SHAFT.API("https://automationexercise.com/api");
    }


}
