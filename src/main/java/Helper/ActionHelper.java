package Helper;

import common.Initializer;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionHelper {

    private WebDriver driver;
    private Actions action;

    public ActionHelper(){
        this.driver = Initializer.getDriver();
        action = new Actions(this.driver);
    }

    public void rightClickOn(WebElement obj){
        action.contextClick(obj).build().perform();
    }

    public void doubleClickOn(WebElement obj){
        action.moveToElement(obj).doubleClick().perform();
    }

}
