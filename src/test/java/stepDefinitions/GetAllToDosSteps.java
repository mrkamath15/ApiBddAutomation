package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.hamcrest.Condition;
import utils.Constants;

import java.io.File;
import java.util.Arrays;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetAllToDosSteps extends BaseSteps {

    @When("user requests get all todos api")
    public void user_requests_get_all_todos_api() {
        response = given().when().get("todos").then();
    }

    @Then("get all todos api returns all fields in response body")
    public void get_all_todos_api_returns_all_fields_in_response_body() {
        response.assertThat().body("userId", everyItem(greaterThanOrEqualTo(1)));
        response.assertThat().body("id", everyItem(greaterThanOrEqualTo(1)));
        response.assertThat().body("title", everyItem(notNullValue()));
        response.assertThat().body("completed", everyItem(in(Arrays.asList(true, false))));
    }

    @Then("get all todos api schema is validated successfully")
    public void get_all_todos_api_schema_is_validated_successfully() {
        response.assertThat().body(JsonSchemaValidator.matchesJsonSchema(new File(Constants.GET_ALL_TODOS_SCHEMA_FILE_PATH)));
    }
}
