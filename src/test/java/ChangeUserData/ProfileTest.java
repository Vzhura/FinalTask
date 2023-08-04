package ChangeUserData;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Login.LoginPage;
import Listeners.CustomExtentReportListener;

@Listeners({CustomExtentReportListener.class})
public class ProfileTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private ProfilePage profilePage;

    @BeforeMethod
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
    }
    @Test
    public void editProfileTest() {
        // Перехід на сторінку Profile
        profilePage.openProfilePage();

        // Змінюємо дані профілю
        String newName = "NewTestUser";
        String NewLastName = "newtestuserpass";
        profilePage.editInfo(newName, NewLastName);

        // Перевірка відображення даних на сторінці Profile
        Assert.assertEquals(profilePage.getNewNameValue(), newName, "Name update failed!");
        Assert.assertEquals(profilePage.getNewLastNameValue(), NewLastName, "NewLastName update failed!");
    }
    @AfterMethod
    public void tearDown() {
        // Закриваємо браузер після завершення тесту
        driver.quit();
    }
}

