import common.Initializer;
import common.UILibrary;
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
    private UILibrary uiLibrary;

    public BaseClass() throws IOException {
        uiLibrary = Initializer.getUILibrary();
    }

    @BeforeSuite
    public void setup() {
        System.out.println("---BeforeSuite---");
        uiLibrary.maximizeWindow();
        uiLibrary.implicitlyWaitFor(5);
    }

    @AfterSuite
    public void tearDown() throws InterruptedException, IOException {
        System.out.println("---AfterSuite---");
        uiLibrary.takeScreenshot();
        uiLibrary.quitDriver();
    }
}
