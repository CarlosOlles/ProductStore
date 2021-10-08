package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import test.BaseUITests;


public class CheckoutPageObject extends BaseUITests {


    public void customClick(WebDriver driver, WebElement placeOrderButton) {
        Actions action = new Actions(driver);
        action.moveToElement(placeOrderButton).click().build().perform();
    }

    public WebElement purchase(WebDriver driver) {
        return driver.findElement(By.xpath("//button[contains(text(), 'Purchase')]"));
    }

    public WebElement orderInfo(WebDriver driver) {
        return driver.findElement(By.xpath("//p[contains(@class, 'lead text-muted')]"));
    }

    public WebElement okButton(WebDriver driver) {
        return driver.findElement(By.xpath("//button[contains(text(), 'OK')]"));
    }
}