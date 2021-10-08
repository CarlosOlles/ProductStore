package helpers;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Utils {


    public void takeScreenshot(WebDriver driver, String fileName) {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Path pathSrcFile = Paths.get(srcFile.getPath());
        File destFile = new File(System.getProperty("user.dir") + "/screenshot/" + fileName);
        try {
            FileOutputStream stream = new FileOutputStream(destFile);
            stream.write(Files.readAllBytes(pathSrcFile));
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveDOM(WebDriver driver) {
        File destFile = new File(System.getProperty("user.dir") + "/dom/dom.html");
        try {
            FileOutputStream stream = new FileOutputStream(destFile);
            stream.write(driver.getPageSource().getBytes(StandardCharsets.UTF_8));
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
