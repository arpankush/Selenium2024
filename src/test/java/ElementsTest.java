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
        uiLibrary.whenIOpenThisUrl(Initializer.webUrl);
        uiLibrary.whenIClickOn(elementsPage.elementsButton);
    }

    @Test(enabled = true)
    public void elementsTextBoxTesting() {
        uiLibrary.whenIClickOn(elementsPage.textButton);
        uiLibrary.whenISendKeys(elementsPage.userNameInput, "Test UserName");
        uiLibrary.whenISendKeys(elementsPage.emailInput, "testEmail@testing.coo");
        uiLibrary.whenISendKeys(elementsPage.currentAddressInput, "Current Address Test");
        uiLibrary.whenISendKeys(elementsPage.permanentAddressInput, "Permanent Address Test");
        uiLibrary.whenIScrollIntoView(elementsPage.submitButton);
        uiLibrary.whenIClickOn(elementsPage.submitButton);
        Assert.assertEquals("Name:Test UserName", uiLibrary.whenIGetText(elementsPage.nameOutput));
        Assert.assertEquals("Email:testEmail@testing.coo", uiLibrary.whenIGetText(elementsPage.emailOutput));
        Assert.assertEquals("Current Address :Current Address Test", uiLibrary.whenIGetText(elementsPage.currentAddressOutput));
        Assert.assertEquals("Permananet Address :Permanent Address Test", uiLibrary.whenIGetText(elementsPage.permanentAddressOutput));
    }

    @Test(enabled = true)
    public void elementsCheckBoxTesting() {
        uiLibrary.whenIClickOn(elementsPage.checkBoxButton);
        uiLibrary.whenIClickOn(elementsPage.homeCheckbox);
        uiLibrary.whenIClickOn(elementsPage.homeCheckboxToggle);
        Assert.assertTrue(uiLibrary.whenIGetText(elementsPage.checkboxResult).contains("home"));
        uiLibrary.whenIClickOn(elementsPage.desktopCheckbox);
        Assert.assertTrue(uiLibrary.whenIGetText(elementsPage.checkboxResult).contains("documents"));
        Assert.assertTrue(uiLibrary.whenIGetText(elementsPage.checkboxResult).contains("downloads"));
    }

    @Test(enabled = true)
    public void elementsRadioBoxTesting() {
        uiLibrary.whenIClickOn(elementsPage.radioBoxButton);
        Assert.assertTrue(uiLibrary.whenICheckThisIsEnabled(elementsPage.impressiveRadio));
        uiLibrary.whenIClickOn(elementsPage.impressiveRadio);
        Assert.assertTrue(uiLibrary.whenICheckThisIsSelected(elementsPage.impressiveRadioCheckbox));
        Assert.assertFalse(uiLibrary.whenICheckThisIsEnabled(elementsPage.noRadioCheckbox));
        uiLibrary.whenIClickOn(elementsPage.noRadio);
    }

    @Test(enabled = true)
    public void elementsWebTablesTesting() {
        uiLibrary.whenIClickOn(elementsPage.webTables);
        uiLibrary.whenIClickOn(elementsPage.addNewRecordButton);
        uiLibrary.whenISendKeys(elementsPage.firstNameWebTables, "Arpan");
        uiLibrary.whenISendKeys(elementsPage.lastNameWebTables, "Kush");
        uiLibrary.whenISendKeys(elementsPage.userEmailTables, "arku@ex.co");
        uiLibrary.whenISendKeys(elementsPage.ageWebTables, "28");
        uiLibrary.whenISendKeys(elementsPage.salaryWebTables, "8000");
        uiLibrary.whenISendKeys(elementsPage.departmentWebTables, "Computer");
        uiLibrary.whenIClickOn(elementsPage.addNewRecordSubmitButton);
        Assert.assertTrue(uiLibrary.whenICheckThisIsEnabled(elementsPage.impressiveRadio));

    }

    @Test(enabled = true)
    public void elementsButtonTesting() {
        uiLibrary.whenIClickOn(elementsPage.buttons);
        uiLibrary.whenIClickOn(elementsPage.clickMeBtn);
        Assert.assertEquals(uiLibrary.whenIGetText(elementsPage.dynamicClickMessage), "You have done a dynamic click");
        uiLibrary.whenIRightClickOn(elementsPage.rightClickBtn);
        Assert.assertEquals(uiLibrary.whenIGetText(elementsPage.rightClickMessage), "You have done a right click");
        uiLibrary.whenIDoubleClickOn(elementsPage.doubleClickBtn);
        Assert.assertEquals(uiLibrary.whenIGetText(elementsPage.doubleClickMessage), "You have done a double click");
    }

    @Test(enabled = true)
    public void elementsLinkTesting() {
        uiLibrary.whenIClickOn(elementsPage.links);
        uiLibrary.whenIClickOn(elementsPage.homeLinks);
        uiLibrary.whenISwitchToAnotherWindow();
        uiLibrary.whenICheckThisIsDisplayed(elementsPage.homeTrainingBanner);
    }

    @Test(enabled = true)
    public void elementsBrokenLinksTesting() {
        uiLibrary.whenIClickOn(elementsPage.brokenLinks);
    }

}