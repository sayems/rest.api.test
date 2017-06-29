package org.sayem.api;

/**
 * Created by syed.sayem on 6/21/15.
 */

public enum Repository {

    USER_NAME("username"),
    PASSWORD("password"),
    METHOD("method"),
    ENDPOINT("endpoint");

    public static final String PROPERTIES = "src/test/resources/api.properties";
    private String value;

    private Repository(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.getValue();
    }
}