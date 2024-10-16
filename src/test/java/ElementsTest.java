import Helper.JSHelper;
import PageObjects.ElementsPage;
import common.UILibrary;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ElementsTest extends BaseClass {

    WebDriver driver;
    UILibrary uiLibrary;
    ElementsPage elementsPage;

    public ElementsTest() throws Exception {
        super();
        driver = super.driver;
        uiLibrary = new UILibrary(driver);
        elementsPage = new ElementsPage();
    }

    @BeforeMethod
    public void elementTestSetup(){
        System.out.println("---BeforeMethod elementTestSetup---");
        uiLibrary.whenIClickOn(elementsPage.elementsButton);
    }

    @Test
    public void elementsTextBoxTesting() {
        uiLibrary.whenIClickOn(elementsPage.textButton);
        uiLibrary.whenISendKeys(elementsPage.userNameInput,"Test UserName");
        uiLibrary.whenISendKeys(elementsPage.emailInput,"testEmail@testing.coo");
        uiLibrary.whenISendKeys(elementsPage.currentAddressInput,"Current Address Test");
        uiLibrary.whenISendKeys(elementsPage.permanentAddressInput,"Permanent Address Test");
        uiLibrary.whenIScrollIntoView(elementsPage.submitButton);
        uiLibrary.whenIClickOn(elementsPage.submitButton);
        Assert.assertEquals("Name:Test UserName", uiLibrary.whenIGetText(elementsPage.nameOutput));
        Assert.assertEquals("Email:testEmail@testing.coo", uiLibrary.whenIGetText(elementsPage.emailOutput));
        Assert.assertEquals("Current Address :Current Address Test", uiLibrary.whenIGetText(elementsPage.currentAddressOutput));
        Assert.assertEquals("Permananet Address :Permanent Address Test", uiLibrary.whenIGetText(elementsPage.permanentAddressOutput));
    }

    @Test
    public void elementsCheckBoxTesting() throws InterruptedException {
        uiLibrary.whenIClickOn(elementsPage.checkBoxButton);
        uiLibrary.whenIClickOn(elementsPage.homeCheckbox);
        uiLibrary.whenIClickOn(elementsPage.homeCheckboxToggle);
        Assert.assertTrue(uiLibrary.whenIGetText(elementsPage.checkboxResult).contains("home"));
        uiLibrary.whenIClickOn(elementsPage.desktopCheckbox);
        Assert.assertTrue(uiLibrary.whenIGetText(elementsPage.checkboxResult).contains("documents"));
        Assert.assertTrue(uiLibrary.whenIGetText(elementsPage.checkboxResult).contains("downloads"));
    }

    @Test
    public void elementsRadioBoxTesting() throws InterruptedException {
        uiLibrary.whenIClickOn(elementsPage.radioBoxButton);
        Assert.assertTrue(uiLibrary.whenICheckIsEnabled(elementsPage.impressiveRadio));
        uiLibrary.whenIClickOn(elementsPage.impressiveRadio);
        Assert.assertTrue(uiLibrary.whenICheckIsSelected(elementsPage.impressiveRadioCheckbox));
        Assert.assertFalse(uiLibrary.whenICheckIsEnabled(elementsPage.noRadioCheckbox));
        uiLibrary.whenIClickOn(elementsPage.noRadio);
    }

    @Test
    public void elementsWebTablesTesting() throws InterruptedException {
        uiLibrary.whenIClickOn(elementsPage.webTables);
        uiLibrary.whenIClickOn(elementsPage.addNewRecordButton);
        uiLibrary.whenISendKeys(elementsPage.firstNameWebTables,"Arpan");
        uiLibrary.whenISendKeys(elementsPage.lastNameWebTables,"Kush");
        uiLibrary.whenISendKeys(elementsPage.userEmailTables,"arku@ex.co");
        uiLibrary.whenISendKeys(elementsPage.ageWebTables,"28");
        uiLibrary.whenISendKeys(elementsPage.salaryWebTables,"8000");
        uiLibrary.whenISendKeys(elementsPage.departmentWebTables,"Computer");
        uiLibrary.whenIClickOn(elementsPage.addNewRecordSubmitButton);
        Thread.sleep(10000);
//        Assert.assertTrue(uiLibrary.whenICheckIsEnabled(elementsPage.impressiveRadio));

    }

    @Test
    public void elementsButtonTesting() throws InterruptedException {
        uiLibrary.whenIClickOn(elementsPage.buttons);
        uiLibrary.whenIClickOn(elementsPage.clickMeBtn);
        Assert.assertTrue(uiLibrary.whenIGetText(elementsPage.dynamicClickMessage).equals("You have done a dynamic click"));
        uiLibrary.whenIRightClickOn(elementsPage.rightClickBtn);
        Assert.assertTrue(uiLibrary.whenIGetText(elementsPage.rightClickMessage).equals("You have done a right click"));
        uiLibrary.whenIDoubleClickOn(elementsPage.doubleClickBtn);
        Assert.assertTrue(uiLibrary.whenIGetText(elementsPage.doubleClickMessage).equals("You have done a double click"));
    }

}
