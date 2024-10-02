package Helper;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class JSHelper {

    private WebDriver driver;

    public JSHelper(WebDriver driver){
        this.driver = driver;
    }

    public void scrollIntoViewOfElement(By element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", driver.findElement(element));

    }

}
