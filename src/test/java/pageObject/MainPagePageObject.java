package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.BaseUITests;

import java.util.concurrent.TimeUnit;


public class MainPagePageObject extends BaseUITests {


    public WebElement getPhonesElement(WebDriver driver) {
        return driver.findElement(By.linkText("Phones"));
    }

    public WebElement getLaptopsElement(WebDriver driver, WebDriverWait w) {
        WebElement laptops = driver.findElement(By.linkText("Laptops"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        w.until(ExpectedConditions.elementToBeClickable(laptops));
        return laptops;
    }

    public WebElement getMonitorsElement(WebDriver driver) {
        return driver.findElement(By.linkText("Monitors"));
    }

    public WebElement getCartElement(WebDriver driver, WebDriverWait w) {
        WebElement cart = driver.findElement(By.id("cartur"));
        w.until(ExpectedConditions.visibilityOf(cart));
        return cart;
    }

    public WebElement goHome(WebDriver driver, WebDriverWait w) {
        WebElement home = driver.findElement(By.xpath("//a[contains(text(), 'Home')]"));
        w.until(ExpectedConditions.visibilityOf(home));
        return home;
    }
}
