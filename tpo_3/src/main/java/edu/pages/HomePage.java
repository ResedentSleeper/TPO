package edu.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageObject {

    @FindBy(xpath = "//a[@href='/u/Tpo_3']")
    private WebElement user;

    @FindBy(xpath = "//a[@href='/upload']")
    private WebElement upload;

    @FindBy(xpath = "//div[contains(@style, 'solid transparent')]")
    private WebElement file;

    @FindBy(xpath = "//div[@id='delete-icon']")
    private WebElement delete;

    @FindBy(xpath = "//button[contains(text(), 'Yes, Delete ')]")
    private WebElement submitDeleteButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public WebElement getUser() {
        return user;
    }

    public WebElement getUpload() {
        return upload;
    }

    public WebElement getFile() {
        return file;
    }

    public WebElement getDelete() {
        return delete;
    }

    public WebElement getSubmitDeleteButton() {
        return submitDeleteButton;
    }

}
