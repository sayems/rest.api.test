package org.sayem.api.weather;

import com.jayway.restassured.RestAssured;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;

/**
 * Created by syed.sayem on 6/29/15.
 */
public class OpenWeatherMap {

    @Test
    public void byCityName() {
        RestAssured.baseURI = "http://api.openweathermap.org/data/2.5";

        given()
                .contentType("application/json; charset=utf-8")
                .expect()
                .statusCode(200)
                .log().all()

                .when()
                .get("/weather?q=New York,New York");

    }
}
