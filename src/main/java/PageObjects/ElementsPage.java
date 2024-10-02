package PageObjects;

import org.openqa.selenium.By;

public class ElementsPage {

    public By elementsButton = By.xpath("//*[text()='Elements']/ancestor::div[@class='card mt-4 top-card']");
    public By textButton = By.xpath("//span[text()='Text Box']");
    public By userNameInput = By.xpath("//input[@id='userName']");
    public By emailInput = By.xpath("//input[@id='userEmail']");
    public By currentAddressInput = By.xpath("//textarea[@id='currentAddress']");
    public By permanentAddressInput = By.xpath("//textarea[@id='permanentAddress']");
    public By submitButton = By.xpath("//button[@id='submit']");
    public By nameOutput = By.xpath("//div[@id='output']/div/p[@id='name']");
    public By emailOutput = By.xpath("//div[@id='output']/div/p[@id='email']");
    public By currentAddressOutput = By.xpath("//div[@id='output']/div/p[@id='currentAddress']");
    public By permanentAddressOutput = By.xpath("//div[@id='output']/div/p[@id='permanentAddress']");

}
