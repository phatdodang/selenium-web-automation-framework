package pageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    public static WebDriver driver;
    private static WebElement element;
    private static WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public static void clickButtonLogin() {
        wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='css-1dbjc4n r-88pszg']")));
        element = driver.findElement(By.xpath("//*[@class='css-1dbjc4n r-88pszg']"));
        element.click();
    }

    public static void enterUsername(String username){
        wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        element = driver.findElement(By.id("username"));
        element.click();
        element.sendKeys(new CharSequence[]{username});
    }

    public static void enterPassword(String password){
        wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        element = driver.findElement(By.id("password"));
        element.click();
        element.sendKeys(new CharSequence[]{password});
    }

    public static void clickButtonLoginInForm(){
        wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='css-1dbjc4n r-1ow6zhx']/preceding-sibling::div[@role='button']")));
        element = driver.findElement(By.xpath("//*[@class='css-1dbjc4n r-1ow6zhx']/preceding-sibling::div[@role='button']"));
        element.click();
    }

    public static void loginFailWithNotice(){
        waitUntilElementIsVisible(By.xpath("//*[contains(@class,'css-901oao r-jwli3a') and contains(text(),'Email')]"));
        if(isElementDisplayed(By.xpath("//*[contains(@class,'css-901oao r-jwli3a') and contains(text(),'Email')]"))){
            String valueAlert = getText(By.xpath("//*[contains(@class,'css-901oao r-jwli3a') and contains(text(),'Email')]"));
            Assert.assertTrue(valueAlert,true);
            System.out.println(valueAlert);
        } else {
            Assert.assertFalse("False",true);
        }
    }

    public static void waitUntilElementIsVisible(By locator){
        try {
            wait = new WebDriverWait(driver, 20);
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public static boolean isElementDisplayed(By locator){
        wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        WebElement element = driver.findElement(locator);
        try {
            element.isDisplayed();
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public static String getText(By locator){
        wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator).getText();
    }
}
