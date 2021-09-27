package edu.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends PageObject {

    @FindBy(xpath = "//a[@href='/login']")
    private WebElement signInButton;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getSignInButton() {
        return signInButton;
    }
}
