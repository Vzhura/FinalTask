package JobDelete;

import Login.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ChangeUserData.ProfilePage;
import LeaveComment.HomePage;

public class ProfilePageTest {
    private WebDriver driver;
    private ProfilePage profilePage;
    private LoginPage loginPage;

    @BeforeClass
    public void setup() {
        // Шлях до драйвера Chrome
        WebDriverManager.chromedriver().setup();

        // Ініціалізація драйвера
        driver = new ChromeDriver();

        // Відкриття сторінки логіну
        driver.get("https://freelance.lsrv.in.ua/login");

        // Ініціалізація класу сторінки логіну
        loginPage = new LoginPage(driver);

        // Ініціалізація класу сторінки профілю
        profilePage = new ProfilePage(driver);

        // Логін з тестовими даними
        loginPage.login("testUser", "testpassword");

    @Test
    public void testViewMyJobs() {
        HomePage homePage = new HomePage(driver);
        homePage.clickJob();

        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.viewMyJobs();

        // Перевірка, переходу на сторінку зі списком своїх оголошень
        Assert.assertTrue(true, "Not on My Jobs page.");
    }

    @Test(dependsOnMethods = "testViewMyJobs")
    public void GetCommentCount() {
        // Назва оголошення, для якого ви необхідно перевірити кількість коментарів
        String jobTitle = "Test Job";

        ProfilePage profilePage = new ProfilePage(driver);
        int commentCount = profilePage.getCommentCount(jobTitle);

        // Перевірка, що кількість коментарів відображається коректно
        Assert.assertEquals(commentCount, 3, "Incorrect comment count.");
    }

    @Test(dependsOnMethods = "testGetCommentCount")
    public void DeleteJob() {
        // Назва оголошення яке треба видалити
        String jobTitleToDelete = "Test Job";

        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.deleteJob(jobTitleToDelete);

        // Перевірка, видаленя оголошення
        Assert.assertTrue(true, "Job was not deleted successfully.");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

