package org.sayem.api;

/**
 * Created by syed.sayem on 6/21/15.
 */

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

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
        prettyPrint();
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

    private void prettyPrint() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(("\nNavigating to the URL : "
                + getEndPoint() + getMethod()));
        System.out.println("Sending request with  : \t\t");
        System.out.println(gson.toJson(object) + "\n");
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