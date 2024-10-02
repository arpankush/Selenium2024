import Helper.JSHelper;
import common.UILibrary;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import PageObjects.ElementsPage;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import reader.configReader;

public class BaseClass {

    WebDriver driver;
    Actions action;
    ElementsPage elementsPage;
    JSHelper jsHelper;
    UILibrary uiLibrary;
    Properties prop = configReader.propertiesReader();

    public BaseClass() throws Exception {
    }

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.get(prop.getProperty("webUrl"));
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        uiLibrary = new UILibrary(driver);
        elementsPage = new ElementsPage();
        jsHelper = new JSHelper(driver);
    }

    @Test
    public void elementsTextBoxTesting() {
        uiLibrary.whenIClickOn(elementsPage.elementsButton);
        uiLibrary.whenIClickOn(elementsPage.textButton);
        uiLibrary.whenISendKeys(elementsPage.userNameInput,"Test UserName");
        uiLibrary.whenISendKeys(elementsPage.emailInput,"testEmail@testing.coo");
        uiLibrary.whenISendKeys(elementsPage.currentAddressInput,"Current Address Test");
        uiLibrary.whenISendKeys(elementsPage.permanentAddressInput,"Permanent Address Test");
        jsHelper.scrollIntoViewOfElement(elementsPage.submitButton);
        uiLibrary.whenIClickOn(elementsPage.submitButton);
        Assert.assertEquals("Name:Test UserName", uiLibrary.whenIGetText(elementsPage.nameOutput));
        Assert.assertEquals("Email:testEmail@testing.coo", uiLibrary.whenIGetText(elementsPage.emailOutput));
        Assert.assertEquals("Current Address :Current Address Test", uiLibrary.whenIGetText(elementsPage.currentAddressOutput));
        Assert.assertEquals("Permananet Address :Permanent Address Test", uiLibrary.whenIGetText(elementsPage.permanentAddressOutput));
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
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
