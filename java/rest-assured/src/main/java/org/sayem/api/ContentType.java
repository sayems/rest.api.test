package org.sayem.api;

/**
 * Created by syed.sayem on 6/21/15.
 */
public enum ContentType {

    JSON("application/json; charset=utf-8"),
    XML("text/xml; charset=utf-8");

    private String contentType;

    private ContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getContentType() {
        return contentType;
    }

    @Override
    public String toString() {
        return this.getContentType();
    }
}