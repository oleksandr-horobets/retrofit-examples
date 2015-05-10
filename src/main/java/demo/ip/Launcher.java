package demo.ip;

import retrofit.RestAdapter;

/**
 * This example prints your API using http://httpbin.org/ip
 */
public class Launcher {
    public static void main(String[] args) {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://httpbin.org")
                .build();

        IpService service = restAdapter.create(IpService.class);

        System.out.println("Your IP is: " + service.getIpResponse().origin());
    }
}
