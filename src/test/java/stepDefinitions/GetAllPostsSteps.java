package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Test;
import utils.Constants;

import java.io.File;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

public class GetAllPostsSteps extends BaseSteps {

    @When("user requests get all posts api")
    public void user_requests_get_all_posts_api() {
        response = given().when().get("posts").then();
    }

    @Then("get all posts api returns all fields in response body")
    public void get_all_posts_api_returns_all_fields_in_response_body() {
        response.assertThat().body("userId", everyItem(greaterThanOrEqualTo(1)));
        response.assertThat().body("id", everyItem(greaterThanOrEqualTo(1)));
        response.assertThat().body("title", everyItem(notNullValue()));
        response.assertThat().body("body", everyItem(notNullValue()));
    }

    @Then("get all posts api schema is validated successfully")
    public void get_all_posts_api_schema_is_validated_successfully() {
        response.assertThat().body(JsonSchemaValidator.matchesJsonSchema(new File(Constants.GET_ALL_POSTS_SCHEMA_FILE_PATH)));
    }

    @Then("api response is returned within {long} ms")
    public void api_response_is_returned_within(long responseTime) {
        response.assertThat().time(lessThan(responseTime));
    }

    @Then("api returns status code as {int}")
    public void api_returns_status_code_as_200(int statusCode) {
        response.assertThat().statusCode(200);
    }
}
