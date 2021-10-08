package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.BaseUITests;


public class LaptopsPageObject extends BaseUITests {


    public WebElement getLaptopByName(WebDriver driver, WebDriverWait w, String laptopName) {

        By laptopLocator = By.xpath("//a[text()='" + laptopName + "']");
        w.until(ExpectedConditions.presenceOfElementLocated(laptopLocator));
        return driver.findElement(laptopLocator);

    }

    public WebElement addToCart(WebDriver driver, WebDriverWait w) {
        By addToCartLocator = By.linkText("Add to cart");
        w.until(ExpectedConditions.presenceOfElementLocated(addToCartLocator));
        return driver.findElement(addToCartLocator);
    }


}