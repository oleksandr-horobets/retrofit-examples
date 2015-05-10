package demo.testing;

import com.squareup.okhttp.mockwebserver.MockResponse;
import com.squareup.okhttp.mockwebserver.MockWebServer;
import org.junit.Test;
import retrofit.RestAdapter;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class HelloWorldServiceTest {
    @Test
    public void integrationTest() throws IOException {
        MockWebServer server = new MockWebServer();

        server.enqueue(new MockResponse().setBody("{'payload': 'Hello world!'}"));
        server.start();

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(server.getUrl("/").toString())
                .build();

        HelloWorldService helloWorldService = restAdapter.create(HelloWorldService.class);

        assertThat(helloWorldService.getMessage().getPayload(), equalTo("Hello world!"));

    }
}
