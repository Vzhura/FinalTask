package Registration;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Listeners.CustomExtentReportListener;

        @Listeners({CustomExtentReportListener.class})
        public class RegistrationTest {
            private WebDriver driver;
            private RegistrationPage registrationPage;

            @BeforeMethod
            public void TestRegistration() {

                // Шлях до драйвера Chrome
                WebDriverManager.chromedriver().setup();

                // Ініціалізація драйвера
                driver = new ChromeDriver();

                // Сторінка реєстрації
                driver.get("https://freelance.lsrv.in.ua/register");

                // Ініціалізація класу сторінки логіну
                registrationPage = new RegistrationPage(driver);
            }

            @Test
            public void registrationTest() {
                // Заповнюємо поля реєстрації
                String username = "testUser";
                String name = "testUserLastname";
                String lastname = "testuserexample";
                String password = "testpassword";

                registrationPage.register(username, name, lastname, password);

                // При успішному тесті вивести повідомлення
                System.out.println("Registration successful!");
            }

            @AfterMethod
            public void tearDown() {
                // Закриваємо браузер після завершення тесту
                driver.quit();
            }
        }
