package org.sayem.api.petstore;

import com.jayway.restassured.RestAssured;
import org.testng.annotations.Test;

import javax.json.Json;
import javax.json.JsonObject;

import static com.jayway.restassured.RestAssured.given;

/**
 * Created by syed.sayem on 6/28/15.
 */
public class User {

    @Test(groups = {"user"})
    public void user() {
        RestAssured.baseURI = "http://petstore.swagger.io/v2";

        JsonObject request = Json.createObjectBuilder()
                .add("id", "0")
                .add("username", "sayem")
                .add("firstName", "Syed")
                .add("lastName", "Sayem")
                .add("email", "syed@sayem.org")
                .add("password", "passw0rd")
                .add("phone", "7189568116")
                .build();

        given()
                .contentType("application/json")
                .body(request.toString())
                .expect()
                .statusCode(200)
                .log().all().request().and().response()

                .when()
                .post("/user").asString();
    }
}
