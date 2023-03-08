package steps;

import utils.BrowserFactory;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Hooks{
    private static final Logger LOGGER = Logger.getLogger(Hooks.class);
    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    @Before
    public void BeforeScenario() {
        try {
            driver = BrowserFactory.getCurrentDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage(), ex);
        }
    }

    @After
    public void AfterScenario(Scenario scenario) {
        BrowserFactory.closeCurrentBrowser();
    }

}
