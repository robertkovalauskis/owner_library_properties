package config;

import org.aeonbits.owner.Config;

import java.net.URL;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:api.properties",
        "file:../secret.properties",
        "system:properties"
})
public interface ApiConfig extends Config {
    @DefaultValue("https://yandex.ru")
    @Key("base.url")
    URL baseUrl();

    @Key("secret.token")
    String tokenSecret();

    @Key("non.secret.token")
    String tokenNonSecret();

}