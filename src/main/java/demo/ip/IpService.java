package demo.ip;

import retrofit.http.GET;

public interface IpService {
    @GET("/ip")
    IpResponse getIpResponse();
}
