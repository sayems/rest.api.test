package org.sayem.api.api.utils;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by syed.sayem on 6/26/15.
 */

public class AbstractAdapter {

    private Object object;
    private String endPoint;
    private String method;
    private ContentType contentType;

    protected AbstractAdapter(AbstractBuilder<?, ?> builder) {
        this.object = builder.object;
        this.endPoint = builder.endPoint;
        this.method = builder.method;
        this.contentType = builder.contentType;
    }

    public static AbstractBuilder<?, ?> builder() {
        return new DefaultAbstractBuilder();
    }

    public Object getObject() {
        return object;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public String getMethod() {
        return method;
    }

    public ContentType getContentType() {
        return contentType;
    }

    public String prettyPrint(String body) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser jp = new JsonParser();
        JsonElement je = jp.parse(body);
        return gson.toJson(je);
    }

    public String makeRawRequest(HttpURLConnection connection) throws IOException {
        BufferedReader in = new BufferedReader(
                new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        getResponseHeader(connection);
        return response.toString();
    }


    public void getResponseHeader(HttpURLConnection con) throws IOException {
        StringBuilder builder = new StringBuilder();
        builder.append(con.getResponseCode())
                .append(" ")
                .append(con.getResponseMessage())
                .append("\n");

        Map<String, List<String>> map = con.getHeaderFields();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry.getKey() == null)
                continue;
            builder.append(entry.getKey())
                    .append(": ");

            List<String> headerValues = entry.getValue();
            Iterator<String> it = headerValues.iterator();
            if (it.hasNext()) {
                builder.append(it.next());

                while (it.hasNext()) {
                    builder.append(", ")
                            .append(it.next());
                }
            }
            builder.append("\n");
        }
        System.out.println(builder);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("object", object)
                .append("endPoint", endPoint)
                .append("method", method)
                .append("contentType", contentType)
                .toString();
    }

    public static abstract class AbstractBuilder<S extends AbstractAdapter, B extends AbstractBuilder<S, B>> {
        private Object object;
        private String endPoint;
        private String method;
        private ContentType contentType;

        @SuppressWarnings("unchecked")
        public B setRequestObject(Object object) {
            this.object = object;
            return (B) this;
        }

        @SuppressWarnings("unchecked")
        public B setEndPoint(String endPoint) {
            this.endPoint = endPoint;
            return (B) this;
        }

        @SuppressWarnings("unchecked")
        public B setMethodName(String method) {
            this.method = method;
            return (B) this;
        }

        @SuppressWarnings("unchecked")
        public B setContentType(ContentType contentType) {
            this.contentType = contentType;
            return (B) this;
        }

        public abstract S build();
    }

    private static class DefaultAbstractBuilder extends AbstractBuilder<AbstractAdapter, DefaultAbstractBuilder> {

        @Override
        public AbstractAdapter build() {
            return new AbstractAdapter(this);
        }
    }
}
