package utils;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class BrowserFactory {
    private static WebDriver currentDriver = null;

    //Get current web driver running
    public static WebDriver getCurrentDriver() {
        if (currentDriver == null) {
            currentDriver = BrowserFactory.createBrowser();
        }
        return currentDriver;
    }

    // create new browser
    public static WebDriver createBrowser() {
        WebDriver driver;
        driver = createChromeDriver();
        addAllBrowserSetup(driver);
        return driver;
    }

    //Add all browser setup
    private static void addAllBrowserSetup(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().setPosition(new Point(0, 0));
        java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension dim = new Dimension((int) screenSize.getWidth(), (int) screenSize.getHeight());
        driver.manage().window().setSize(dim);
    }

    private static WebDriver createChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/java/config/chromedriver.exe");
        return new ChromeDriver();
    }

    // Close current browser
    public static void closeCurrentBrowser() {
        if (currentDriver != null) {
            currentDriver.quit();
        }
        currentDriver = null;
    }
}
