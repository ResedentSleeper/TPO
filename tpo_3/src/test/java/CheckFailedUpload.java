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
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static edu.utils.DriverConfig.getCurrentDriver;

public class CheckFailedUpload {

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
    public void uploadFailedTest() {
        driver.get("https://app.photobucket.com");
        driver.manage().window().maximize();

        mainPage.getSignInButton().click();
        loginPage.getDismiss().click();
        loginPage.getUsername().click();
        loginPage.getUsername().sendKeys(PropertyNames.LOGIN);
        loginPage.getPassword().click();
        loginPage.getPassword().sendKeys(PropertyNames.PASSWORD);
        loginPage.getSubmit().click();

        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='/upload']")));
        homePage.getUpload().click();
        try {
            uploadPage.getInputArea().sendKeys("C:\\WebDriver\\bin\\geckodriver.exe");
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[.='Media format is not supported']")));
        }catch (TimeoutException e){
            Assertions.fail("Time for loading is up");
        }catch (NoSuchElementException e) {
            Assertions.fail("Elements are not present");
        }
    }


}
