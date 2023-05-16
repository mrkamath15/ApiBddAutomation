package stepDefinitions;

import io.cucumber.java.en.Then;
import io.restassured.response.ValidatableResponse;

import static org.hamcrest.Matchers.lessThan;

public class BaseSteps {
    public static ValidatableResponse response;
}
