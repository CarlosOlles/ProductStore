package test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

@ExtendWith(CustomWatcher.class)
public class BaseUITests {

    public static final String GRID_URL = "http://localhost:4444";
    public static final String BASE_URL = "https://www.demoblaze.com/index.html";

    private WebDriver driver;
    JavascriptExecutor js;

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    @BeforeEach
    public void setUp() throws Exception {

        String browserName = System.getProperty("browserName");

        if (browserName == null) {
            throw new NoSupportedBrowserException("Please use \"chrome\", \"firefox\"or \"edge\" with -DbrowserName parameter");
        }
        switch (browserName) {
            case "firefox":
                FirefoxOptions cap = new FirefoxOptions();
                cap.setCapability("platform", "LINUX");
                driver = new RemoteWebDriver(new URL(GRID_URL), new FirefoxOptions());
                System.out.println("Firefox node registered");
                break;
            case "chrome":
                driver = new RemoteWebDriver(new URL(GRID_URL), new ChromeOptions());
                System.out.println("Chrome node registered");
                break;
            case "edge":
                driver = new RemoteWebDriver(new URL(GRID_URL), new EdgeOptions());
                System.out.println("Edge node registered");
                break;
            default: {
                throw new NoSupportedBrowserException(browserName + " is not a supported browser. Please use \"chrome\", \"firefox\"or \"edge\"");
            }
        }
        js = (JavascriptExecutor) driver;
        driver.get(BASE_URL);
        driver.manage().window().fullscreen();
    }

    @AfterEach
    public void tearDown() {
        System.out.println("TEARDOWN");
        driver.quit();
    }
}
