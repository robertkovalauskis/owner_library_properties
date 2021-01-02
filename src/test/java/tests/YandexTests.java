package tests;

import com.codeborne.selenide.Configuration;
import config.ConfigHelper;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class YandexTests {

    @Test
    void selenideSearchTest() {
        Configuration.remote = ConfigHelper.getWebdriverRemote();

        String searchSite = ConfigHelper.getSearchSite();
        String searchItem = ConfigHelper.getSearchItem();
        String searchResult = ConfigHelper.getSearchResult();
        String password = ConfigHelper.getPassword();
        System.out.println(password);

        open(searchSite);

        $(byXpath("//input[@name='text']")).setValue(searchItem).pressEnter();

        $("html").shouldHave(text(searchResult));
    }
}