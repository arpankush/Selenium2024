package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UILibrary {
    WebDriver driver;

    public UILibrary(WebDriver driver){
        this.driver = driver;
    }

    public void whenIClickOn(By obj){
        driver.findElement(obj).click();
    }

    public void whenISendKeys(By obj, String text, boolean clearToggle){
        if(clearToggle){
            driver.findElement(obj).clear();
        }
        driver.findElement(obj).sendKeys(text);
    }
    public void whenISendKeys(By obj, String text){
        whenISendKeys(obj, text, false);
    }

    public String whenIGetText(By obj){
        return driver.findElement(obj).getText();
    }


}
