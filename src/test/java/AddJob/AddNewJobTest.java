package AddJob;

import Login.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Listeners.CustomExtentReportListener;

@Listeners({CustomExtentReportListener.class})
public class AddNewJobTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private AddJobPage AddJobPage;

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

        // Ініціалізація класу сторінки додавання нового оголошення
        AddJobPage = new AddJobPage(driver);

        // Логін з тестовими даними
        loginPage.login("testUser", "testpassword");
    }
    @Test
    public void loginTest() {
        // Заповнення полів логіну
        String login = "testUser";
        String password = "testpassword";
        loginPage.login(login, password);
    }
    public void getAddJobTest() {
        // Заповнення полів форми додавання об'яви
        String Title = "Random title";
        String Description = "testDescription";
        String Price = "100Hryvnas";
        AddJobPage.getAddJob(Title, Description, Price);

        // Перевірка відображення даних на сторінці Profile
        Assert.assertEquals(AddJobPage.getDescription(), Description, "Name update failed!");

    }
    @AfterMethod
    public void tearDown() {
        // Закриваємо браузер після завершення тесту
        driver.quit();
    }
}


