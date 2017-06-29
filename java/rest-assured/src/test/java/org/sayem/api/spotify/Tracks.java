package org.sayem.api.spotify;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import java.util.List;

import static com.jayway.restassured.RestAssured.given;

/**
 * Created by syed.sayem on 7/1/15.
 */
public class Tracks {

    @Test
    public void getTrack() {

        RestAssured.baseURI = "https://api.spotify.com/v1";

        JsonPath response = given()
                .contentType("application/json")
                .pathParam("id", "46Wv5hDZud87ECEnqCkNlm")
                .expect()
                .statusCode(200)

                .when()
                .get("/albums/{id}/tracks").jsonPath();

        List<String> winnerIds = response.getList("items.name");
        winnerIds.forEach(System.out::println);

    }
}
