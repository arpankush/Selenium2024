import PageObjects.AlertFramePage;
import common.Initializer;
import common.UILibrary;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class AlertFrameWindowTest extends BaseClass {

    UILibrary uiLibrary;
    AlertFramePage alertFramePage;

    public AlertFrameWindowTest() throws IOException {
        uiLibrary = Initializer.getUILibrary();
        alertFramePage = Initializer.getAlertFramePage();
    }

    @BeforeMethod
    public void alertFramePageSetup(){
        uiLibrary.openThisUrl(Initializer.webUrl);
        uiLibrary.clickOn(alertFramePage.alertFrameWindowPage);
    }

    @Test
    public void alertTesting(){
        uiLibrary.clickOn(alertFramePage.alertFrameWindowSection);
        uiLibrary.clickOn(alertFramePage.alertButton);
        Assert.assertEquals(uiLibrary.getAlertText(),"");
        uiLibrary.dismissAlert();
    }

}
