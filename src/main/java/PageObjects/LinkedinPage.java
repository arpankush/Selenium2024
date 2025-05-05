package PageObjects;

import org.openqa.selenium.By;

public class LinkedinPage {
    public By signInButton = By.xpath("//nav/descendant::a[contains(text(),'Sign in')]");
    public By emailId = By.id("username");
    public By password = By.id("password");
    public By signIn = By.xpath("//button[@aria-label='Sign in']");
    public By jobs = By.xpath("//a[@href='https://www.linkedin.com/jobs/?']");
    public By jobsCollections = By.xpath("//h2[text()='Explore with job collections']/parent::div/parent::div/parent::section/descendant::a[@aria-label='Show all Explore with job collections'][1]");
    public By easyApply = By.xpath("//div[@class='jobs-apply-button--top-card']/descendant::span[text()='Easy Apply'][1]");
    public By easyApplyNext = By.xpath("//button[@id='ember990']");
    public By errorOnField = By.xpath("//span[text()='Please enter a valid answer']/parent::div/parent::div/parent::div/div/label");
}
