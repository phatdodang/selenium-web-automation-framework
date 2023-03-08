package utils;

import org.openqa.selenium.WebDriver;
import steps.Hooks;

public class TestBase {
    public static WebDriver driver;
    public TestBase() {
        this.driver = Hooks.getDriver();
    }
}
