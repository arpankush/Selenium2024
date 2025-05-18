package common;

import Helper.ActionHelper;
import Helper.JSHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;

public class UILibrary {
    WebDriver driver;
    ActionHelper actionHelper;
    JSHelper jsHelper;

    public UILibrary() throws IOException {
        driver = Initializer.getDriver();
        jsHelper = Initializer.getJsHelper();
        actionHelper = Initializer.getActionHelper();
    }

    public void openThisUrl(String obj) {
        driver.get(obj);
    }
    public void maximizeWindow() {
        driver.manage().window().maximize();
    }

    public void implicitlyWaitFor(int seconds) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }

    public void takeScreenshot() {
        File ss = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest = new File(System.getProperty("user.dir") + "/src/test/resources/screenshots/ss.png");
        try {
            FileHandler.copy(ss, dest);
        } catch (Exception fileError) {
            System.err.println("File not found!");
        }
    }

    public void clickOn(By obj) {
        jsHelper.scrollIntoViewOfElement(driver.findElement(obj));
        driver.findElement(obj).click();
    }

    public void rightClickOn(By obj) {
        jsHelper.scrollIntoViewOfElement(driver.findElement(obj));
        actionHelper.rightClickOn(driver.findElement(obj));
    }

    public void doubleClickOn(By obj) {
        jsHelper.scrollIntoViewOfElement(driver.findElement(obj));
        actionHelper.doubleClickOn(driver.findElement(obj));
    }

    public void scrollIntoView(By obj) {
        jsHelper.scrollIntoViewOfElement(driver.findElement(obj));
    }

    public void sendKeys(By obj, String text, boolean clearToggle) {
        jsHelper.scrollIntoViewOfElement(driver.findElement(obj));
        if (clearToggle) {
            driver.findElement(obj).clear();
        }
        driver.findElement(obj).sendKeys(text);
    }

    public void sendKeys(By obj, String text) {
        sendKeys(obj, text, false);
    }

    public String getText(By obj) {
        jsHelper.scrollIntoViewOfElement(driver.findElement(obj));
        return driver.findElement(obj).getText();
    }

    public boolean isDisplayed(By obj) {
        return driver.findElement(obj).isDisplayed();
    }

    public boolean isEnabled(By obj) {
        return driver.findElement(obj).isEnabled();
    }

    public boolean isSelected(By obj) {
        return driver.findElement(obj).isSelected();
    }

    public void switchToAnotherWindow() {
        String parentWindow = driver.getWindowHandle();
        Iterator<String> itr = driver.getWindowHandles().iterator();
        while (itr.hasNext()) {
            String windowIteration = itr.next();
            if (!windowIteration.equals(parentWindow))
                driver.switchTo().window(windowIteration);
        }
    }

    public String getAlertText(){
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }

    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }

    public void dismissAlert(){
        driver.switchTo().alert().dismiss();
    }

    public void enterTextInAlert(String inputText){
        driver.switchTo().alert().sendKeys(inputText);
    }

    public void quitDriver(){ driver.quit(); }
    public void waitFor(int time) throws InterruptedException { Thread.sleep(time); }


}
