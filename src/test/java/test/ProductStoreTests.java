package test;

import helpers.Utils;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.CartPageObject;
import pageObject.CheckoutPageObject;
import pageObject.LaptopsPageObject;
import pageObject.MainPagePageObject;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductStoreTests extends BaseUITests {

    MainPagePageObject mainPagePageObject = new MainPagePageObject();
    LaptopsPageObject laptopsPageObject = new LaptopsPageObject();
    CartPageObject cartPageObject = new CartPageObject();
    CheckoutPageObject checkoutPageObject = new CheckoutPageObject();
    Utils utils = new Utils();

    @Test
    @Order(1)
    @DisplayName("Browsing between categories :)")
    public void browsingBetweenCategories() {
        WebDriverWait w = new WebDriverWait(getDriver(), Duration.ofSeconds(5));

        mainPagePageObject.getPhonesElement(getDriver()).click();
        mainPagePageObject.getLaptopsElement(getDriver(), w).click();
        mainPagePageObject.getMonitorsElement(getDriver()).click();
    }

    @Test
    @Order(2)
    public void addLaptoptocart() {
        utils.saveDOM(getDriver());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebDriverWait w = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

        mainPagePageObject.getLaptopsElement(getDriver(), w).click();
        laptopsPageObject.getLaptopByName(getDriver(), w, "Sony vaio i5").click();
        laptopsPageObject.addToCart(getDriver(), w).click();

        w.until(ExpectedConditions.alertIsPresent());
        assertEquals(getDriver().switchTo().alert().getText(), "Product added");
        getDriver().switchTo().alert().accept();

        mainPagePageObject.goHome(getDriver(), w).click();
        mainPagePageObject.getLaptopsElement(getDriver(), w).click();

        laptopsPageObject.getLaptopByName(getDriver(), w, "Dell i7 8gb").click();

        laptopsPageObject.addToCart(getDriver(), w).click();

        w.until(ExpectedConditions.alertIsPresent());
        assertEquals(getDriver().switchTo().alert().getText(), ("Product added"));
        getDriver().switchTo().alert().accept();

        //TODO export cookies to perform this action under deletefromcart() test
        mainPagePageObject.getCartElement(getDriver(), w).click();

        cartPageObject.deleteProductFromCart(getDriver(), w, "Dell i7 8gb").click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //TODO export cookies to perform this action under placeorder() test
        Float amountBeforePurchase = Float.parseFloat(cartPageObject.getTotalOrderAmount(getDriver()).getText());
        System.out.println("TOTAL AMOUNT -> " + amountBeforePurchase);

        WebElement placeOrderButton = cartPageObject.placeOrder(getDriver());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        checkoutPageObject.customClick(getDriver(), placeOrderButton);
        enterData(getDriver());
        checkoutPageObject.purchase(getDriver()).click();

        utils.takeScreenshot(getDriver(), "idamount.png");
        String orderInfo = checkoutPageObject.orderInfo(getDriver()).getText();

        checkoutPageObject.okButton(getDriver()).click();

        String id = orderInfo.substring(orderInfo.indexOf("Id:") + 4);
        Float amountAfterPurchase = Float.parseFloat(orderInfo.substring(orderInfo.indexOf("Amount:") + 8, orderInfo.indexOf(" USD")));

        System.out.println("---- ORDER INFO -----");
        System.out.println("---- Id: " + id);
        System.out.println("---- Amount: " + amountAfterPurchase);
        assertEquals(amountAfterPurchase, amountBeforePurchase);
    }

    private void enterData(WebDriver driver) {

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.switchTo().activeElement();

        driver.findElement(By.xpath("//div[@id='orderModal']//input[@id='name']")).sendKeys("collesname");

        driver.findElement(By.xpath("//div[@id='orderModal']//input[@id='country']")).sendKeys("spain");

        driver.findElement(By.xpath("//input[@id='city']")).sendKeys("zaragoza");

        driver.findElement(By.xpath("//input[@id='card']")).sendKeys("555-5555-5555");

        driver.findElement(By.xpath("//input[@id='month']")).sendKeys("01");

        driver.findElement(By.xpath("//input[@id='year']")).sendKeys("01");
    }
}
