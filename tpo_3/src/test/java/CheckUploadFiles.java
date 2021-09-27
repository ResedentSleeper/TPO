import edu.exceptions.InvalidDriverException;
import edu.pages.HomePage;
import edu.pages.LoginPage;
import edu.pages.MainPage;
import edu.pages.UploadPage;
import edu.utils.PropertyNames;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static edu.utils.DriverConfig.getCurrentDriver;

public class CheckUploadFiles {

    private static WebDriver driver;
    private static MainPage mainPage;
    private static LoginPage loginPage;
    private static HomePage homePage;
    private static UploadPage uploadPage;


    @BeforeAll
    public static void setUp() {
        try {
            driver = getCurrentDriver();
            mainPage = new MainPage(driver);
            loginPage = new LoginPage(driver);
            homePage = new HomePage(driver);
            uploadPage = new UploadPage(driver);
        } catch (InvalidDriverException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }


    @Test
    public void uploadTest() {
        int countFiles;
        driver.get("https://app.photobucket.com");
        driver.manage().window().maximize();

        mainPage.getSignInButton().click();
        loginPage.getUsername().click();
        loginPage.getUsername().sendKeys(PropertyNames.LOGIN);
        loginPage.getPassword().click();
        loginPage.getPassword().sendKeys(PropertyNames.PASSWORD);
        loginPage.getSubmit().click();

        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class, 'Counter-sc-')]")));

        countFiles = Integer.parseInt(driver.findElement(By.xpath("//div[contains(@class, 'Counter-sc-')]")).getText()
                .replaceAll("Images", "").replace(" ", ""));

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='/upload']")));
        homePage.getUpload().click();
        uploadPage.getUrlInput().sendKeys("https://pa1.narvii.com/7695/32ef0f7ce448ddb1506cd86fd2659f0abe8212e2r1-512-266_hq.gif");
        uploadPage.getAddButton().click();
        wait.until(ExpectedConditions.elementToBeClickable(uploadPage.getUploadButton()));
        uploadPage.getUploadButton().click();
        countFiles++;

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='/upload']")));
        homePage.getUpload().click();
        uploadPage.getInputArea().sendKeys("C:\\Users\\Alena\\IdeaProjects\\tpo_3\\src\\main\\resources\\bar.mp4");
        wait.until(ExpectedConditions.elementToBeClickable(uploadPage.getUploadButton()));
        uploadPage.getUploadButton().click();
        countFiles++;

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class, 'Placeholder-sc-')]")));
        List<WebElement> files = driver.findElements(By.xpath("//div[contains(@class, 'Placeholder-sc-')]"));

        Assertions.assertEquals(countFiles, files.size());

    }


}
