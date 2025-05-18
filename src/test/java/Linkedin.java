import PageObjects.LinkedinPage;
import common.Initializer;
import common.UILibrary;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import java.io.IOException;

public class Linkedin {
    private UILibrary uiLibrary;
    private LinkedinPage linkedinPage;

    Linkedin() throws IOException {
        uiLibrary = Initializer.getUILibrary();
        linkedinPage = Initializer.getLinkedinPage();
    }

    @BeforeMethod
    public void setup(){
        uiLibrary.maximizeWindow();
        uiLibrary.implicitlyWaitFor(5);
    }

    @Test
    public void applyJobs(){
        uiLibrary.maximizeWindow();
        uiLibrary.implicitlyWaitFor(5);

        uiLibrary.openThisUrl(Initializer.webUrlLinkedin);
        uiLibrary.clickOn(linkedinPage.signInButton);
        uiLibrary.sendKeys(linkedinPage.emailId,"arpankushwahapro@gmail.com");
        uiLibrary.sendKeys(linkedinPage.password,"Linkedin2012..");
        uiLibrary.clickOn(linkedinPage.signIn);
        uiLibrary.clickOn(linkedinPage.jobs);
        uiLibrary.scrollIntoView(linkedinPage.jobsCollections);
        uiLibrary.clickOn(linkedinPage.jobsCollections);
        uiLibrary.clickOn(linkedinPage.easyApply);
        uiLibrary.clickOn(linkedinPage.easyApplyNext);
        if (!uiLibrary.getText(linkedinPage.errorOnField).isEmpty()){
            System.out.println(uiLibrary.getText(linkedinPage.errorOnField));
        }


    }

    @AfterMethod
    public void teardown() throws InterruptedException {
        uiLibrary.waitFor(3000);
//        uiLibrary.quitDriver();

    }
}
