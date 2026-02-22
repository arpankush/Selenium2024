import org.aspectj.util.FileUtil;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class screenshotTest {
    @Test
    public void NewWindow() throws InterruptedException, IOException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://sketch.io/sketchpad/");
        driver.manage().window().maximize();
        Thread.sleep(5000);
        File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtil.copyFile(screenshotFile, new File("./src/test/resources/screenshots/new" + ".png"));
//        driver.findElement(By.cssSelector("[class*='close-button']")).click();
//        By canvas = By.cssSelector(" sketch-doc-scrollarea");
//        int height = driver.findElement(canvas).getSize().getHeight();
//        int width = driver.findElement(canvas).getSize().getWidth();
//        System.out.println(height);
//        System.out.println(width);
//        Actions actions = new Actions(driver);
//        int h = 500;
//        int w = 500;
//        for (int i = 0; i < 100; i = i + 1+2) {
//            actions.moveToLocation(h,w+i).click().perform();
//        }
//        driver.quit();
    }
}
