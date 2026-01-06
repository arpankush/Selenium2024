import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SeleniumTests {
    @Test
    public void NewWindow() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://sketch.io/sketchpad/");
        driver.manage().window().maximize();
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("[class*='close-button']")).click();
        By canvas = By.cssSelector(" sketch-doc-scrollarea");
        int height = driver.findElement(canvas).getSize().getHeight();
        int width = driver.findElement(canvas).getSize().getWidth();
        System.out.println(height);
        System.out.println(width);
            Actions actions = new Actions(driver);
            int h = 500;
            int w = 500;
        for (int i = 0; i < 100; i = i + 1+2) {
            actions.moveToLocation(h,w+i).click().perform();
        }
        driver.quit();
    }
}
