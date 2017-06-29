package org.sayem.api;

import org.sayem.api.api.utils.ContentType;
import org.sayem.api.api.utils.PostAdapter;
import org.sayem.api.api.utils.RestAdapter;
import org.sayem.api.request.PostRequest;
import org.sayem.api.response.PostResponse;
import org.testng.annotations.Test;

import java.io.IOException;

public class ApiTest {

    @Test
    public void testSetUp() throws IOException {

        PostRequest request = new PostRequest();
        request.setPassword("passw0rd");
        request.setName("Syed");

        RestAdapter adapter = PostAdapter.builder()
                .setContentType(ContentType.JSON)
                .setRequestObject(request)
                .setEndPoint("http://jsonplaceholder.typicode.com")
                .setMethodName("/posts")
                .build();
        PostResponse response = adapter.execute(PostResponse.class);
        response.getId();

    }
}
