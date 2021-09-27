package edu.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObject {

    @FindBy(xpath = "//input[@name='username']")
    private WebElement username;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement password;

    @FindBy(xpath = "//div[@role='alert']")
    private WebElement alert;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submit;

    @FindBy(xpath = "//a[@aria-label='dismiss cookie message']")
    private WebElement dismiss;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getUsername() {
        return username;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getAlert() {
        return alert;
    }

    public WebElement getSubmit() {
        return submit;
    }

    public WebElement getDismiss() {
        return dismiss;
    }
}
