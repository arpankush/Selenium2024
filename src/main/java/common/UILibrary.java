package common;

import Helper.ActionHelper;
import Helper.JSHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UILibrary {
    WebDriver driver;
    ActionHelper actionHelper;
    JSHelper jsHelper;

    public UILibrary(WebDriver driver){
        this.driver = driver;
        actionHelper = new ActionHelper(this.driver);
        jsHelper = new JSHelper(this.driver);
    }

    public void whenIClickOn(By obj){
        jsHelper.scrollIntoViewOfElement(driver.findElement(obj));
        driver.findElement(obj).click();
    }

    public void whenIRightClickOn(By obj){
        jsHelper.scrollIntoViewOfElement(driver.findElement(obj));
        actionHelper.rightClickOn(driver.findElement(obj));
    }

    public void whenIDoubleClickOn(By obj){
        jsHelper.scrollIntoViewOfElement(driver.findElement(obj));
        actionHelper.doubleClickOn(driver.findElement(obj));
    }

    public void whenIScrollIntoView(By obj){
        jsHelper.scrollIntoViewOfElement(driver.findElement(obj));
    }

    public void whenISendKeys(By obj, String text, boolean clearToggle){
        jsHelper.scrollIntoViewOfElement(driver.findElement(obj));
        if(clearToggle){
            driver.findElement(obj).clear();
        }
        driver.findElement(obj).sendKeys(text);
    }
    public void whenISendKeys(By obj, String text){
        whenISendKeys(obj, text, false);
    }

    public String whenIGetText(By obj){
        jsHelper.scrollIntoViewOfElement(driver.findElement(obj));
        return driver.findElement(obj).getText();
    }

    public boolean whenICheckIsDisplayed(By obj){
        return driver.findElement(obj).isDisplayed();
    }

    public boolean whenICheckIsEnabled(By obj){
        return driver.findElement(obj).isEnabled();
    }

    public boolean whenICheckIsSelected(By obj){
        return driver.findElement(obj).isSelected();
    }


}
