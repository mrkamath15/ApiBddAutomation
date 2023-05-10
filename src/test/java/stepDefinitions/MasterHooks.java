package stepDefinitions;

import io.cucumber.java.BeforeAll;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;

public class MasterHooks {

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }
}
