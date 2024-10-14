import Helper.JSHelper;
import PageObjects.ElementsPage;
import common.UILibrary;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ElementsTest extends BaseClass {

    WebDriver driver;
    UILibrary uiLibrary;
    JSHelper jsHelper;
    ElementsPage elementsPage;

    public ElementsTest() throws Exception {
        super();
        driver = super.driver;
        uiLibrary = new UILibrary(driver);
        jsHelper = new JSHelper(driver);
        elementsPage = new ElementsPage();
    }

    @Test
    public void elementsTextBoxTesting() {
        System.out.println("Test elementsTextBoxTesting");
        uiLibrary.whenIClickOn(elementsPage.elementsButton);
        uiLibrary.whenIClickOn(elementsPage.textButton);
        uiLibrary.whenISendKeys(elementsPage.userNameInput,"Test UserName");
        uiLibrary.whenISendKeys(elementsPage.emailInput,"testEmail@testing.coo");
        uiLibrary.whenISendKeys(elementsPage.currentAddressInput,"Current Address Test");
        uiLibrary.whenISendKeys(elementsPage.permanentAddressInput,"Permanent Address Test");
        jsHelper.scrollIntoViewOfElement(elementsPage.submitButton);
        uiLibrary.whenIClickOn(elementsPage.submitButton);
        Assert.assertEquals("Name:Test UserName", uiLibrary.whenIGetText(elementsPage.nameOutput));
        Assert.assertEquals("Email:testEmail@testing.coo", uiLibrary.whenIGetText(elementsPage.emailOutput));
        Assert.assertEquals("Current Address :Current Address Test", uiLibrary.whenIGetText(elementsPage.currentAddressOutput));
        Assert.assertEquals("Permananet Address :Permanent Address Test", uiLibrary.whenIGetText(elementsPage.permanentAddressOutput));
    }

}
