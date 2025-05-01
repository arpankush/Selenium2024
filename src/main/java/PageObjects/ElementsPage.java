package PageObjects;

import org.openqa.selenium.By;

public class ElementsPage {

    //TextBox
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

    //CheckBox
    public By checkBoxButton = By.xpath("//span[text()='Check Box']");
    public By homeCheckbox = By.xpath("//label[@for='tree-node-home']");
    public By homeCheckboxToggle = By.xpath("//input[@id='tree-node-home']/parent::label/parent::span/button");
    public By desktopCheckbox = By.xpath("//label[@for='tree-node-desktop']/span[@class='rct-checkbox']");
    public By checkboxResult = By.xpath("//div[@id='result']");

    //RadioBox
    public By radioBoxButton = By.xpath("//span[text()='Radio Button']");
    public By impressiveRadio = By.xpath("//input[@id='impressiveRadio']/parent::div");
    public By impressiveRadioCheckbox = By.xpath("//input[@id='impressiveRadio']");
    public By noRadio = By.xpath("//input[@id='noRadio']/parent::div");
    public By noRadioCheckbox = By.xpath("//input[@id='noRadio']");

    //WebTables
    public By webTables = By.xpath("//span[text()='Web Tables']");
    public By addNewRecordButton = By.xpath("//button[@id='addNewRecordButton']");
    public By firstNameWebTables = By.xpath("//input[@id='firstName']");
    public By lastNameWebTables = By.xpath("//input[@id='lastName']");
    public By userEmailTables = By.xpath("//input[@id='userEmail']");
    public By ageWebTables = By.xpath("//input[@id='age']");
    public By salaryWebTables = By.xpath("//input[@id='salary']");
    public By departmentWebTables = By.xpath("//input[@id='department']");
    public By addNewRecordSubmitButton = By.xpath("//button[@id='submit']");

    //Buttons
    public By buttons = By.xpath("//span[text()='Buttons']");
    public By clickMeBtn = By.xpath("//button[text()='Click Me']");
    public By dynamicClickMessage = By.xpath("//p[@id='dynamicClickMessage']");
    public By rightClickBtn = By.xpath("//button[@id='rightClickBtn']");
    public By rightClickMessage = By.xpath("//p[@id='rightClickMessage']");
    public By doubleClickBtn = By.xpath("//button[@id='doubleClickBtn']");
    public By doubleClickMessage = By.xpath("//p[@id='doubleClickMessage']");

    //Links
    public By links = By.xpath("//span[text()='Links']");
    public By brokenLinks = By.xpath("//span[text()='Broken Links - Images']");
    public By homeLinks = By.xpath("//a[@id='simpleLink']");
    public By homeTrainingBanner = By.xpath("//img[@alt='Selenium Online Training']");

}
