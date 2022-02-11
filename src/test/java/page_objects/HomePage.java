package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import page_objects.helpers.PageActions;

public class HomePage {

    protected WebDriver driver;

    @FindBy(how = How.XPATH, using = "//*[@id=\"shopify-section-footer\"]/footer/div/div[1]/div[1]/ul/li/a")
    private static WebElement searchLink;

    @FindBy(how = How.XPATH, using = "//*[@id=\"shopify-section-header\"]/div/header/div/div[2]/div/a")
    private static WebElement cartLink;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public static void goToSearchPage(){
        PageActions.click(searchLink);
    }
    public static void goToCartPage() { PageActions.click(cartLink);}
}
