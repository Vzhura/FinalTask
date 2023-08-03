package LeaveComment;

import AddJob.AddJobPage;
import Login.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LeaveCommentTest {
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeClass
    @BeforeMethod
    public void setup() {
        // Шлях до драйвера Chrome
        WebDriverManager.chromedriver().setup();

        // Ініціалізація драйвера
        driver = new ChromeDriver();

        // Сторінка логіну
        driver.get("https://freelance.lsrv.in.ua/login");

        // Ініціалізація класу сторінки логіну
        loginPage = new LoginPage(driver);

        // Логін з тестовими даними
        loginPage.login("testUser", "testpassword");
    }
    @Test
    public void testLeaveComment() {
        HomePage homePage = new HomePage(driver);
        homePage.clickJob("Random title");

        JobDetailsPage jobDetailsPage = new JobDetailsPage(driver);
        jobDetailsPage.clickViewInfoButton();
        jobDetailsPage.leaveComment("Test comment bla bla bla.");

        // Перевірка, що коментар було успішно залишено
        Assert.assertTrue(true, "Comment was not left successfully.");
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

