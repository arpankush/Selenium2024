import PageObjects.ElementsPage;
import common.Initializer;
import common.UILibrary;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ElementsTest extends BaseClass {

    UILibrary uiLibrary;
    ElementsPage elementsPage;

    public ElementsTest() throws Exception {
        elementsPage = Initializer.getElementsPage();
        uiLibrary = Initializer.getUILibrary();
    }

    @BeforeMethod
    public void elementTestSetup() {
        uiLibrary.openThisUrl(Initializer.webUrl);
        uiLibrary.clickOn(elementsPage.elementsButton);
    }

    @Test(enabled = true)
    public void elementsTextBoxTesting() {
        uiLibrary.clickOn(elementsPage.textButton);
        uiLibrary.sendKeys(elementsPage.userNameInput, "Test UserName");
        uiLibrary.sendKeys(elementsPage.emailInput, "testEmail@testing.coo");
        uiLibrary.sendKeys(elementsPage.currentAddressInput, "Current Address Test");
        uiLibrary.sendKeys(elementsPage.permanentAddressInput, "Permanent Address Test");
        uiLibrary.scrollIntoView(elementsPage.submitButton);
        uiLibrary.clickOn(elementsPage.submitButton);
        Assert.assertEquals("Name:Test UserName", uiLibrary.getText(elementsPage.nameOutput));
        Assert.assertEquals("Email:testEmail@testing.coo", uiLibrary.getText(elementsPage.emailOutput));
        Assert.assertEquals("Current Address :Current Address Test", uiLibrary.getText(elementsPage.currentAddressOutput));
        Assert.assertEquals("Permananet Address :Permanent Address Test", uiLibrary.getText(elementsPage.permanentAddressOutput));
    }

    @Test(enabled = true)
    public void elementsCheckBoxTesting() {
        uiLibrary.clickOn(elementsPage.checkBoxButton);
        uiLibrary.clickOn(elementsPage.homeCheckbox);
        uiLibrary.clickOn(elementsPage.homeCheckboxToggle);
        Assert.assertTrue(uiLibrary.getText(elementsPage.checkboxResult).contains("home"));
        uiLibrary.clickOn(elementsPage.desktopCheckbox);
        Assert.assertTrue(uiLibrary.getText(elementsPage.checkboxResult).contains("documents"));
        Assert.assertTrue(uiLibrary.getText(elementsPage.checkboxResult).contains("downloads"));
    }

    @Test(enabled = true)
    public void elementsRadioBoxTesting() {
        uiLibrary.clickOn(elementsPage.radioBoxButton);
        Assert.assertTrue(uiLibrary.isEnabled(elementsPage.impressiveRadio));
        uiLibrary.clickOn(elementsPage.impressiveRadio);
        Assert.assertTrue(uiLibrary.isSelected(elementsPage.impressiveRadioCheckbox));
        Assert.assertFalse(uiLibrary.isEnabled(elementsPage.noRadioCheckbox));
        uiLibrary.clickOn(elementsPage.noRadio);
    }

    @Test(enabled = true)
    public void elementsWebTablesTesting() {
        uiLibrary.clickOn(elementsPage.webTables);
        uiLibrary.clickOn(elementsPage.addNewRecordButton);
        uiLibrary.sendKeys(elementsPage.firstNameWebTables, "Arpan");
        uiLibrary.sendKeys(elementsPage.lastNameWebTables, "Kush");
        uiLibrary.sendKeys(elementsPage.userEmailTables, "arku@ex.co");
        uiLibrary.sendKeys(elementsPage.ageWebTables, "28");
        uiLibrary.sendKeys(elementsPage.salaryWebTables, "8000");
        uiLibrary.sendKeys(elementsPage.departmentWebTables, "Computer");
        uiLibrary.clickOn(elementsPage.addNewRecordSubmitButton);
        Assert.assertTrue(uiLibrary.isEnabled(elementsPage.impressiveRadio));

    }

    @Test(enabled = true)
    public void elementsButtonTesting() {
        uiLibrary.clickOn(elementsPage.buttons);
        uiLibrary.clickOn(elementsPage.clickMeBtn);
        Assert.assertEquals(uiLibrary.getText(elementsPage.dynamicClickMessage), "You have done a dynamic click");
        uiLibrary.rightClickOn(elementsPage.rightClickBtn);
        Assert.assertEquals(uiLibrary.getText(elementsPage.rightClickMessage), "You have done a right click");
        uiLibrary.doubleClickOn(elementsPage.doubleClickBtn);
        Assert.assertEquals(uiLibrary.getText(elementsPage.doubleClickMessage), "You have done a double click");
    }

    @Test(enabled = true)
    public void elementsLinkTesting() {
        uiLibrary.clickOn(elementsPage.links);
        uiLibrary.clickOn(elementsPage.homeLinks);
        uiLibrary.switchToAnotherWindow();
        uiLibrary.isDisplayed(elementsPage.homeTrainingBanner);
    }

    @Test(enabled = true)
    public void elementsBrokenLinksTesting() {
        uiLibrary.clickOn(elementsPage.brokenLinks);
    }

}