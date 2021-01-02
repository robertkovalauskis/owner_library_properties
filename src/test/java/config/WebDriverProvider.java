package config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.function.Supplier;

public class WebDriverProvider implements  Supplier<WebDriver> {

    @Override
    public WebDriver get() {

        final WebDriverConfig config = ConfigFactory.newInstance().create(WebDriverConfig.class);

        if (config.remote()) {

            String browserType;

            switch (config.browserName()) {
                case CHROME:
                    browserType = BrowserType.CHROME;
                    break;
                case OPERA:
                    browserType = BrowserType.OPERA;
                    break;
                default:
                    throw new RuntimeException("Unknown browser name: " + config.browserName());
            }

            DesiredCapabilities desiredCapabilities = new DesiredCapabilities(browserType, "", Platform.ANY);
            desiredCapabilities.setCapability("enableVNC", true);
            desiredCapabilities.setCapability("enableVideo", true);

            return new RemoteWebDriver(config.remoteURL(), desiredCapabilities);

        } else {

            switch (config.browserName()) {
                case CHROME:
                    WebDriverManager.chromedriver().setup();
                    return new ChromeDriver();
                case OPERA:
                    WebDriverManager.operadriver().setup();
                    return new OperaDriver();
                default:
                    throw new RuntimeException("Unknown browser name: " + config.browserName());
            }

        }
    }
}