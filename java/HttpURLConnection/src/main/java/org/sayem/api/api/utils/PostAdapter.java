package org.sayem.api.api.utils;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by syed.sayem on 6/26/15.
 */

public class PostAdapter extends AbstractAdapter implements RestAdapter {
    private String name;

    protected PostAdapter(GetBuilder<?, ?> builder) {
        super(builder);
        this.name = builder.name;

    }

    public static GetBuilder<?, ?> builder() {
        return new DefaultGetBuilder();
    }

    public String getName() {
        return name;
    }

    @Override
    public <T> T execute(Class<T> responseClass) {
        Gson jsonParser = new Gson();
        final String endpoint = getEndPoint() + getMethod();
        String body = jsonParser.toJson(getObject());
        HttpURLConnection request = null;
        try {
            request = postRequest(endpoint, body);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String response = null;
        try {
            response = makeRawRequest(request);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Request \n" + prettyPrint(body) + "\n");
        System.out.println("Response \n" + prettyPrint(response) + "\n");
        return jsonParser.fromJson(response, responseClass);
    }

    private HttpURLConnection postRequest(String command, String body) throws IOException {
        HttpURLConnection con = null;
        try {
            URL obj = new URL(command);
            con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod(MethodType.POST.getMethodType());
            con.setRequestProperty("Content-Type", ContentType.JSON.getContentType());
            con.setDoOutput(true);
            OutputStreamWriter osw = new OutputStreamWriter(con.getOutputStream());
            osw.write(body);
            osw.flush();
            osw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return con;
    }

    public static abstract class GetBuilder<S extends PostAdapter, B extends GetBuilder<S, B>> extends AbstractAdapter.AbstractBuilder<S, B> {
        private String name;

        @SuppressWarnings("unchecked")
        public B name(String name) {
            this.name = name;
            return (B) this;
        }

    }

    private static class DefaultGetBuilder extends GetBuilder<PostAdapter, DefaultGetBuilder> {
        @Override
        public PostAdapter build() {
            return new PostAdapter(this);
        }
    }
}
