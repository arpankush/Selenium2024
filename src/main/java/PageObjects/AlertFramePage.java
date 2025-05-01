package PageObjects;

import org.openqa.selenium.By;

public class AlertFramePage {

    public By alertFrameWindowPage = By.xpath("//*[contains(text(),'Alerts')]/ancestor::div[@class='card mt-4 top-card']");
    public By alertFrameWindowSection = By.xpath("//span[text()='Alerts']");
    public By alertButton = By.xpath("//button[@id='alertButton']");
    public By confirmButton = By.xpath("//button[@id='confirmButton']");
    public By promptButton = By.xpath("//button[@id='promtButton']");


}
