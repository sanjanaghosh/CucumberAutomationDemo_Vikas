package stepDefinitions;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginPageSteps {

    private static final Logger logger = LoggerFactory.getLogger(LoginPageSteps.class);
    private static String title;
// Here We create object of POM i.e( LoginPage) class by using  private keyword
    private LoginPage  loginPage =new LoginPage(DriverFactory.getDriver());


    @Given("user is on login page")
    public void user_is_on_login_page() {
     DriverFactory.getDriver()
             .get("https://magento.softwaretestingboard.com/customer/account/login");
        logger.info("page title is: " + loginPage.getLoginPageTitle());

    }

    @When("user gets the title of the page")
    public void user_gets_the_title_of_the_page() {

    }

    @Then("page title should be {String}")
    public void page_title_should_be(String expectedTitleName) {

        Assert.assertTrue(title.contains(expectedTitleName));
    }

    @Then("forgot your password link should be displayed")
    public void forgot_your_password_link_should_be_displayed() {
        Assert.assertTrue(loginPage.isForgotPwdLinkExist());

    }

    @When("user enters username {string}")
    public void user_enters_username(String username) {
        loginPage.enterUserName(username);

    }

    @When("user enters password {string}")
    public void user_enters_password(String password) {
        loginPage.enterPassword(password);


    }

    @When("user clicks on Login button")
    public void user_clicks_on_login_button() {
        loginPage.clickOnLogin();

    }


//    @Then("page title should be {string}")
//    public void pageTitleShouldBe(String expTtitle) {
//        Assert.assertTrue(title.contains(expTtitle));
//    }
}
