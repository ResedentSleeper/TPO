import edu.exceptions.InvalidDriverException;
import edu.pages.HomePage;
import edu.pages.LoginPage;
import edu.pages.MainPage;
import edu.utils.PropertyNames;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static edu.utils.DriverConfig.getCurrentDriver;

public class CheckLogin {

    private static MainPage mainPage;
    private static LoginPage loginPage;
    private static HomePage homePage;
    private static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        try {
            driver = getCurrentDriver();
            mainPage = new MainPage(driver);
            loginPage = new LoginPage(driver);
            homePage = new HomePage(driver);
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
    public void loginCorrectTest() {
        driver.get("https://app.photobucket.com");
        driver.manage().window().maximize();

        mainPage.getSignInButton().click();
        Assertions.assertTrue(loginPage.getSubmit().isDisplayed());

        loginPage.getUsername().click();
        loginPage.getUsername().sendKeys(PropertyNames.LOGIN);
        loginPage.getPassword().click();
        loginPage.getPassword().sendKeys(PropertyNames.PASSWORD);
        loginPage.getSubmit().click();

        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='appbar-my-bucket']/span")));
        Assertions.assertTrue(homePage.getUser().getText().contains("My Bucket"));

    }


}
