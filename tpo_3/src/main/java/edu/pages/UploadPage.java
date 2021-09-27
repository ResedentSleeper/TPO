package edu.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UploadPage extends PageObject {

    @FindBy(xpath = "//*[@id='link-paste']")
    private WebElement urlInput;

    @FindBy(xpath = "//input[@type='file']")
    private WebElement inputArea;

    @FindBy(xpath = "//button[.='Add']")
    private WebElement addButton;

    @FindBy(xpath = "//button[.='Upload to My Bucket']")
    private WebElement uploadButton;

    public UploadPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getUrlInput() {
        return urlInput;
    }

    public WebElement getInputArea() {
        return inputArea;
    }

    public WebElement getAddButton() {
        return addButton;
    }

    public WebElement getUploadButton() {
        return uploadButton;
    }
}
