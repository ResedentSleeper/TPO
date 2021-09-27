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

public class CheckRemoveFiles {

    private static WebDriver driver;
    private static MainPage mainPage;
    private static LoginPage loginPage;
    private static HomePage homePage;

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
    public void DeleteTest() {
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
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class, 'Placeholder-sc-')]")));
        do
            homePage.getFile().click();
        while (driver.findElements(By.xpath("//div[contains(@style, 'solid transparent')]")).size() != 0);

        homePage.getDelete().click();
        homePage.getSubmitDeleteButton().click();
        Assertions.assertTrue(driver.findElement(By.xpath("//div[@id='delete-icon' and (contains(@class, 'disabled')) ]")).isDisplayed());
    }

}
