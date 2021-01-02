package tests;


import config.ApiConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;

public class ApiTest {

    @Test
    public void testApi() {

        ApiConfig config = ConfigFactory.newInstance().create(ApiConfig.class, System.getProperties());

        System.out.println(config.baseUrl());
        System.out.println(config.tokenSecret());
        System.out.println(config.tokenNonSecret());

    }

}