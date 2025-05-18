import PageObjects.AlertFramePage;
import common.BaseClass;
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
        uiLibrary.whenIOpenThisUrl(Initializer.webUrl);
        uiLibrary.whenIClickOn(alertFramePage.alertFrameWindowPage);
    }

    @Test
    public void alertTesting(){
        uiLibrary.whenIClickOn(alertFramePage.alertFrameWindowSection);
        uiLibrary.whenIClickOn(alertFramePage.alertButton);
        Assert.assertEquals(uiLibrary.whenIGetAlertText(),"");
        uiLibrary.whenIDismissAlert();
    }

}
