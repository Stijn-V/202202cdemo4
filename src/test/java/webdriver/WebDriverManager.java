package webdriver;

import be.brightest.ProjectConstants;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import io.github.bonigarcia.wdm.managers.EdgeDriverManager;
import io.github.bonigarcia.wdm.managers.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class WebDriverManager {

    private static WebDriverManager instance = new WebDriverManager();
    private static WebDriver driver = null;

    private WebDriverManager() {

    }

    public static WebDriverManager getInstance() {
        return instance;
    }

    public WebDriver getWebDriver() {
        if (driver == null)
            initWebDriver(ProjectConstants.DEFAULT_BROWSER);
        return driver;
    }

    public WebDriver initWebDriver(String browserName) {
        switch (browserName.toLowerCase()) {
            case "chrome":
                ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
                ChromeOptions chromeSettings = new ChromeOptions();
                chromeSettings.setScriptTimeout(Duration.ofSeconds(60));
                chromeSettings.setPageLoadTimeout(Duration.ofSeconds(60));
                driver = new ChromeDriver(chromeSettings);
                break;

            case "edge":
                EdgeDriverManager.getInstance(DriverManagerType.EDGE).setup();
                EdgeOptions edgeSettings = new EdgeOptions();
                edgeSettings.setScriptTimeout(Duration.ofSeconds(60));
                edgeSettings.setPageLoadTimeout(Duration.ofSeconds(60));
                driver = new EdgeDriver(edgeSettings);
                break;

            case "firefox":
                FirefoxDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
                FirefoxOptions firefoxSettings = new FirefoxOptions();
                firefoxSettings.setScriptTimeout(Duration.ofSeconds(60));
                firefoxSettings.setPageLoadTimeout(Duration.ofSeconds(60));
                driver = new FirefoxDriver(firefoxSettings);
                break;

            default:
                break;
        }

        // Additional browser settings
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        return driver;
    }


    public void removeWebDriver() {
        driver.quit();
        driver = null;
    }
}
