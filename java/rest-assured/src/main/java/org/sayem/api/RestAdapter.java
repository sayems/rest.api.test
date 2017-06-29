package org.sayem.api;

import com.jayway.restassured.path.json.JsonPath;

/**
 * Created by syed.sayem on 6/21/15.
 */

public interface RestAdapter {

    JsonPath execute();

    <T> T execute(Class<T> responseClass);
}