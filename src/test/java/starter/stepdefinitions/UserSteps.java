package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.Delete;
import starter.user.Get;
import starter.user.Post;
import starter.user.Put;

public class UserSteps {

    private String id;

    @Steps
    Get get;

    @Steps
    Post post;

    @Steps
    Put put;

    @Steps
    Delete delete;

    @Given("I set GET api endpoint")
    public void iSetGetApiEndpoint(){
        get.setApiEndpoint();
    }

    @When("I send GET HTTP request")
    public void iSendGETHTTPRequest() {
        get.sendGetHttpRequest();
    }

    @Then("I receive valid HTTP response code")
    public void iReceiveValidHTTPResponseCode() {
        get.validateHttpResponseCode200();
    }

    @And("I receive valid data for detail user")
    public void iReceiveValidDataForDetailUser() {
        get.validateDataDetailUser();
    }

    @Given("I set POST api endpoint")
    public void iSetPOSTApiEndpoint() {
        post.setEndpointPostUser();
    }

    @When("I send POST HTTP request")
    public void iSendPOSTHTTPRequest() {
        post.requestPostUser();
    }

    @Then("I receive valid HTTP response code {int}")
    public void iReceiveValidHTTPResponseCode(int arg0) {
        post.validateResponseCode(arg0);
    }

    @And("I receive valid data for new user")
    public void iReceiveValidDataForNewUser() {
        post.validateNewUser();
    }

    @Given("I set PUT api endpoint")
    public void iSetPUTApiEndpoint() {
        put.setPutApi(post.getIdForAnotherMethod());
    }

    @When("I send PUT HTTP request")
    public void iSendPUTHTTPRequest() {
        put.sendPutRequest(post.getIdForAnotherMethod());
    }

    @And("I receive valid data for updated user")
    public void iReceiveValidDataForUpdatedUser() {
        put.validateUpdatedUser();
    }

    @Given("I set DELETE api endpoint")
    public void iSetDELETEApiEndpoint() {
        delete.setDeleteApi(post.getIdForAnotherMethod());
    }

    @When("I send Delete HTTP request")
    public void iSendDeleteHTTPRequest() {
        delete.sendDeleteRequest(post.getIdForAnotherMethod());
    }

    @And("I use the id for another method")
    public void iUseTheIdForAnotherMethod() {
        this.id = post.getIdForAnotherMethod();
    }
}
