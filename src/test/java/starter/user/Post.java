package starter.user;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class Post {

    protected static String url = "https://reqres.in/api/";
    protected static Response response;

    @Step("I set POST api endpoint")
    public String setEndpointPostUser(){
        return url + "users";
    }

    @Step("I send POST HTTP request")
    public void requestPostUser(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "morpheus");
        requestBody.put("job", "leader");

        this.response = SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).when().post(setEndpointPostUser());
    }

    @Step("I receive valid HTTP response code")
    public void validateResponseCode(int code){
        restAssuredThat(response -> response.statusCode(code));
    }

    @Step("I receive valid data for new user")
    public void validateNewUser(){
        restAssuredThat(response -> response.body("name", equalTo("morpheus")));
        restAssuredThat(response -> response.body("job", equalTo("leader")));
    }

    @Step("I use the id for another method")
    public String getIdForAnotherMethod(){
        return this.response.getBody().path("id");
    }
}
