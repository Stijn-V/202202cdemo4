package be.brightest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import logger.Logger;
import org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.support.PageFactory;
import page_objects.CartPage;
import page_objects.HomePage;
import page_objects.ProductDetailPage;
import page_objects.SearchPage;
import webdriver.WebDriverManager;

public class StepDefinitions {

    public StepDefinitions() {
        PageFactory.initElements(WebDriverManager.getInstance().getWebDriver(), HomePage.class);
        PageFactory.initElements(WebDriverManager.getInstance().getWebDriver(), SearchPage.class);
        PageFactory.initElements(WebDriverManager.getInstance().getWebDriver(), CartPage.class);
        PageFactory.initElements(WebDriverManager.getInstance().getWebDriver(), ProductDetailPage.class);
    }


    @Given("the search page is up and running")
    public void the_search_page_is_up_and_running() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();

        HomePage.goToSearchPage();
        SearchPage.assertSearchInputAvailable();
    }

//    @When("the customer searches for paprika")
//    public void the_customer_searches_for_paprika() {
//        // Write code here that turns the phrase above into concrete actions
//        //throw new io.cucumber.java.PendingException();
//
//        SearchPage.searchProduct("paprika");
//    }
//
//    @Then("paprika appears in the search results")
//    public void paprika_appears_in_the_search_results() {
//        // Write code here that turns the phrase above into concrete actions
//        //throw new io.cucumber.java.PendingException();
//
//        SearchPage.verifySearchResults("Gherkin - Paprika");
//    }

    @When("the customer searches for (.*)$")
    public void the_customer_searches_for_product(String arg0) {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();

        SearchPage.searchProduct(arg0);
    }

    @Then("^(.*) appears in the search results")
    public void result_appears_in_the_search_results(String arg0) {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();

        SearchPage.verifySearchResults(arg0);
    }


    @Then("a message is displayed that foobar did not deliver any results")
    public void a_message_is_displayed_that_foobar_did_not_deliver_any_results() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();

        String template = ProjectConstants.SEARCH_NO_RESULTS;
        template = template.replace("CHANGE_ME", "foobar");
        SearchPage.verifyMessage(template);
    }




    @Given("the customer's cart is empty")
    public void the_customer_s_cart_is_empty() {
        // Write code here that turns the phrase above into concrete actions
        // throw new io.cucumber.java.PendingException();
        HomePage.goToCartPage();
        CartPage.verifyCartPageIsVisible();
        CartPage.verifyEmptyCartMessage(ProjectConstants.EMPTY_CART_MESSAGE);
        CartPage.clickContinueShopping();
    }
    @Given("the customer is on the paprika product detail page")
    public void the_customer_is_on_the_paprika_product_detail_page() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        HomePage.goToSearchPage();
        SearchPage.assertSearchInputAvailable();
        SearchPage.searchProduct("paprika");
        SearchPage.verifySearchResults("Gherkin - Paprika");
        SearchPage.viewProductDetail();
        ProductDetailPage.verifyProductName("Gherkin - Paprika");
    }
    @When("the customer chooses to add the product to the cart")
    public void the_customer_chooses_to_add_the_product_to_the_cart() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        ProductDetailPage.addToCart();
    }
    @Then("the cart overview is displayed")
    public void the_cart_overview_is_displayed() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        CartPage.verifyCartPageIsVisible();
    }
    @Then("the paprika product counter equals {int}")
    public void the_paprika_product_counter_equals(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        CartPage.checkCounterValue(int1);
    }

}