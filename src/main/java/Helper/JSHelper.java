package Helper;

import common.Initializer;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class JSHelper {

    private WebDriver driver;

    public JSHelper() throws IOException {
        driver = Initializer.getDriver();
    }

    public void scrollIntoViewOfElement(WebElement obj) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", obj);

    }

}
