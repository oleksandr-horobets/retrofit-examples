package demo.testing;

import retrofit.http.GET;

public interface HelloWorldService {
    @GET("/message")
    Message getMessage();
}
