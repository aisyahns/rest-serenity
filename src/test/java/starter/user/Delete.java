package starter.user;

import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.given;

public class Delete {

    protected static String url = "https://reqres.in/api/";

    @Step("I set DELETE api endpoint")
    public String setDeleteApi(String id){
        return url + "users/" + id;
    }

    @Step("I send Delete HTTP request")
    public void sendDeleteRequest(String id){
        given().when().delete(setDeleteApi(id));
    }
}
