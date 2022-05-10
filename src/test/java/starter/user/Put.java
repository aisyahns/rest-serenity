package starter.user;

import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class Put {

    protected static String url = "https://reqres.in/api/";

    @Step("I set PUT api endpoint")
    public String setPutApi(String id){
        return url + "users/" + id;
    }

    @Step("I send PUT HTTP request")
    public void sendPutRequest(String id){
        JSONObject requestData = new JSONObject();
        requestData.put("name", "aisyah");
        requestData.put("job", "qa engineer");

        System.out.println(id);
        given().header("Content-Type", "application/json")
                .body(requestData.toJSONString())
                .when()
                .put(setPutApi(id));
    }

    @Step("I receive valid data for updated user")
    public void validateUpdatedUser(){
        restAssuredThat(response -> response.body("name", equalTo("aisyah")));
        restAssuredThat(response -> response.body("job", equalTo("qa engineer")));
    }
}
