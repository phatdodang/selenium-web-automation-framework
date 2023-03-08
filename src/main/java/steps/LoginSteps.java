package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pageObject.LoginPage;
import utils.TestBase;

import java.util.concurrent.TimeUnit;

public class LoginSteps extends TestBase {

    public LoginSteps() {
    }

    LoginPage loginPage = new LoginPage(driver);

    @Given("^Launch Traveloka web application$")
    public void launchApp() {
        driver.get("https://www.traveloka.com/vi-vn/flight");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @When("^User click button Login$")
    public void userClickButtonLogin() {
        loginPage.clickButtonLogin();
    }

    @And("^User enter username as \"([^\"]*)\"$")
    public void userEnterUsername(String username) {
        loginPage.enterUsername(username);
    }

    @And("^User enter password as \"([^\"]*)\"$")
    public void userEnterPassword(String password) {
        loginPage.enterPassword(password);
    }

    @And("^User click button Login in Form$")
    public void userClickButtonLoginInForm() {
        loginPage.clickButtonLoginInForm();
    }

    @Then("^Login fail with notice$")
    public void loginFailWithNotice() {
        loginPage.loginFailWithNotice();
    }
}
