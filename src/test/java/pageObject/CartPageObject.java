package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.BaseUITests;


public class CartPageObject extends BaseUITests {


    public WebElement deleteProductFromCart(WebDriver driver, WebDriverWait w, String productToDelete) {

        // Finding the Delete element by the product's name,
        // just in case we have more than 1 product on the cart
        By deleteElement = By.xpath("//td[contains(text(),'" + productToDelete + "')]/following-sibling::td//a");
        w.until(ExpectedConditions.presenceOfElementLocated(deleteElement));

        return driver.findElement(deleteElement);
    }

    public WebElement placeOrder(WebDriver driver) {
        return driver.findElement(By.xpath("//button[@data-target='#orderModal']"));
    }

    public WebElement getTotalOrderAmount(WebDriver driver) {
        return driver.findElement(By.xpath("//h3[@id='totalp']"));
    }

}