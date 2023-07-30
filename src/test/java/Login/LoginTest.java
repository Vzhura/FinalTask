package Login;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Listeners.CustomExtentReportListener;

@Listeners({CustomExtentReportListener.class})
public class LoginTest {
    private WebDriver driver;
    private LoginPage loginPage;

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
    }

    @Test
    public void loginTest() {
        // Заповнення полів логіну
        String login = "testUser";
        String password = "testpassword";
        loginPage.login(login, password);

        // При успішному тесті вивести повідомлення
        System.out.println("Login successful!");
    }

    @AfterMethod
    public void tearDown() {
        // Закриваємо браузер після завершення тесту
        driver.quit();
    }
}

