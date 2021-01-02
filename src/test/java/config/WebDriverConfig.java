package config;

import org.aeonbits.owner.Config;

import java.net.URL;


@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:${webdriver.type}.properties",
        "system:properties"
})
public interface WebDriverConfig extends Config {

    @Key("webdriver.browser.name")
    BrowserName browserName();

    @DefaultValue("87")
    @Key("webdriver.browser.version")
    String browserVersion();

    @Key("webDriver.remote.url")
    URL remoteURL();

    @Key("webdriver.remote")
    Boolean remote();

    @DefaultValue("https://yandex.ru")
    @Key("base.url")
    String baseUrl();

}
