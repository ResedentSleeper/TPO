import edu.exceptions.InvalidDriverException;
import edu.pages.LoginPage;
import edu.pages.MainPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static edu.utils.DriverConfig.getCurrentDriver;

public class CheckFailedLogin {
    private static MainPage mainPage;
    private static LoginPage loginPage;
    private static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        try {
            driver = getCurrentDriver();
            mainPage = new MainPage(driver);
            loginPage = new LoginPage(driver);
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
    public void loginIncorrectPasswordTest() {
        driver.get("https://app.photobucket.com");
        driver.manage().window().maximize();

        mainPage.getSignInButton().click();
        Assertions.assertTrue(loginPage.getSubmit().isDisplayed());

        loginPage.getUsername().click();
        loginPage.getUsername().sendKeys("Summerrain_3");
        loginPage.getPassword().click();
        loginPage.getPassword().sendKeys("password");
        loginPage.getSubmit().click();

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@role='alert']")));
        Assertions.assertTrue(loginPage.getAlert().getText().contains("Wrong password for user Summerrain_3"));
    }

    @Test
    public void loginIncorrectUserTest() {
        driver.get("https://app.photobucket.com");
        driver.manage().window().maximize();

        mainPage.getSignInButton().click();
        Assertions.assertTrue(loginPage.getSubmit().isDisplayed());

        loginPage.getUsername().click();
        loginPage.getUsername().sendKeys("Summerrain_33");
        loginPage.getPassword().click();
        loginPage.getPassword().sendKeys("password");
        loginPage.getSubmit().click();

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@role='alert']")));
        Assertions.assertTrue(loginPage.getAlert().getText().contains("User not found Summerrain_33"));
    }

}

