import common.Initializer;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BaseClass {

    WebDriver driver;

    public BaseClass() throws IOException {
        driver = Initializer.getDriver();
    }

    @BeforeSuite
    public void setup() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterSuite
    public void tearDown() throws InterruptedException, IOException {
        System.out.println("---AfterSuite tearDown---");
        File ss = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Thread.sleep(3000);
        File dest = new File(System.getProperty("user.dir") + "/src/test/resources/screenshots/ss.png");
        try {
            FileHandler.copy(ss, dest);
        } catch (Exception fileError) {
            System.err.println("File not found!");
        }
        driver.quit();
    }
}
