package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import page_objects.helpers.PageActions;

public class ProductDetailPage {

    protected WebDriver driver;

    @FindBy(how = How.XPATH, using = "//*[@id=\"ProductSection-product-template\"]/div/div[2]/div/h1")
    private static WebElement productName;

    @FindBy(how = How.XPATH, using = "//*[@id=\"AddToCart-product-template\"]")
    private static WebElement addToCartButton;


    public ProductDetailPage(WebDriver driver) {
        this.driver = driver;
    }

    public static void verifyProductName(String expectedName) {
        PageActions.assertElementText(productName, expectedName);
    }

    public static void addToCart() {
        PageActions.click(addToCartButton);
    }


}
