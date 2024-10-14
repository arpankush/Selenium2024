import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import reader.configReader;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {

    WebDriver driver;
    Properties prop = configReader.propertiesReader();

    public BaseClass() throws Exception {
        driver = new ChromeDriver();
    }

    @BeforeSuite
    public void setup() {
        System.out.println("BeforeSuite setup");
        driver.get(prop.getProperty("webUrl"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

    @AfterSuite
    public void tearDown() throws InterruptedException {
        System.out.println("AfterSuite tearDown");
        File ss = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest = new File(System.getProperty("user.dir") + "/src/test/resources/screenshots/ss.png");
        try {
            FileHandler.copy(ss, dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Thread.sleep(3000);
        driver.quit();
    }


}
