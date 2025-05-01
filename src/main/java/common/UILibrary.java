package common;

import Helper.ActionHelper;
import Helper.JSHelper;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
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

    public void whenIOpenThisUrl(String obj) {
        driver.get(obj);
    }

    public void whenIClickOn(By obj) {
        jsHelper.scrollIntoViewOfElement(driver.findElement(obj));
        driver.findElement(obj).click();
    }

    public void whenIRightClickOn(By obj) {
        jsHelper.scrollIntoViewOfElement(driver.findElement(obj));
        actionHelper.rightClickOn(driver.findElement(obj));
    }

    public void whenIDoubleClickOn(By obj) {
        jsHelper.scrollIntoViewOfElement(driver.findElement(obj));
        actionHelper.doubleClickOn(driver.findElement(obj));
    }

    public void whenIScrollIntoView(By obj) {
        jsHelper.scrollIntoViewOfElement(driver.findElement(obj));
    }

    public void whenISendKeys(By obj, String text, boolean clearToggle) {
        jsHelper.scrollIntoViewOfElement(driver.findElement(obj));
        if (clearToggle) {
            driver.findElement(obj).clear();
        }
        driver.findElement(obj).sendKeys(text);
    }

    public void whenISendKeys(By obj, String text) {
        whenISendKeys(obj, text, false);
    }

    public String whenIGetText(By obj) {
        jsHelper.scrollIntoViewOfElement(driver.findElement(obj));
        return driver.findElement(obj).getText();
    }

    public boolean whenICheckThisIsDisplayed(By obj) {
        return driver.findElement(obj).isDisplayed();
    }

    public boolean whenICheckThisIsEnabled(By obj) {
        return driver.findElement(obj).isEnabled();
    }

    public boolean whenICheckThisIsSelected(By obj) {
        return driver.findElement(obj).isSelected();
    }

    public void whenISwitchToAnotherWindow() {
        String parentWindow = driver.getWindowHandle();
        Iterator<String> itr = driver.getWindowHandles().iterator();
        while (itr.hasNext()) {
            String windowIteration = itr.next();
            if (!windowIteration.equals(parentWindow))
                driver.switchTo().window(windowIteration);
        }
    }

    public String whenIGetAlertText(){
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }

    public void whenIAcceptAlert(){
        driver.switchTo().alert().accept();
    }

    public void whenIDismissAlert(){
        driver.switchTo().alert().dismiss();
    }

    public void whenIEnterTextInAlert(String inputText){
        driver.switchTo().alert().sendKeys(inputText);
    }


}
