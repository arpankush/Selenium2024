package common;

import Helper.ActionHelper;
import Helper.JSHelper;
import PageObjects.AlertFramePage;
import PageObjects.ElementsPage;
import PageObjects.LinkedinPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import reader.configReader;

import java.io.IOException;
import java.util.Properties;

public class Initializer {

    static WebDriver driver;
    static Properties prop;
    static UILibrary uiLibrary;
    static ActionHelper actionHelper;
    static JSHelper jsHelper;
    static ElementsPage elementsPage;
    static AlertFramePage alertFramePage;
    static LinkedinPage linkedinPage;
    public static String browser;
    public static String webUrl;
    public static String webUrlLinkedin;

    static {
        try {
            prop = configReader.propertiesReader();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        browser = prop.getProperty("browser").toLowerCase();
        webUrl = prop.getProperty("webUrl").toLowerCase();
        webUrlLinkedin = prop.getProperty("webUrlLinkedin").toLowerCase();
    }

    public Initializer() throws IOException {
        driver = getDriver();
    }

    public static UILibrary getUILibrary() throws IOException {
        if (uiLibrary == null)
            uiLibrary = new UILibrary();
        return uiLibrary;
    }

    public static LinkedinPage getLinkedinPage(){
        if (linkedinPage == null)
            linkedinPage = new LinkedinPage();
        return linkedinPage;
    }

    public static ElementsPage getElementsPage() throws IOException {
        if (elementsPage == null)
            elementsPage = new ElementsPage();
        return elementsPage;
    }

    public static AlertFramePage getAlertFramePage() throws IOException {
        if (alertFramePage == null)
            alertFramePage = new AlertFramePage();
        return alertFramePage;
    }

    public static ActionHelper getActionHelper() throws IOException {
        if (actionHelper == null)
            actionHelper = new ActionHelper();
        return actionHelper;
    }

    public static JSHelper getJsHelper() throws IOException {
        if (jsHelper == null)
            jsHelper = new JSHelper();
        return jsHelper;
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            switch (browser) {
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                default:
                    break;
            }
        }
        return driver;
    }

}
