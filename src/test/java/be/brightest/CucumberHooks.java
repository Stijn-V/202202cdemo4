package be.brightest;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import webdriver.WebDriverManager;

public class CucumberHooks {

    @Before
    public void openBrowser() {
        WebDriverManager.getInstance().getWebDriver().get(ProjectConstants.BASE_URL);
    }

    @After
    public void closeBrowser() {
        WebDriverManager.getInstance().removeWebDriver();
    }
}

