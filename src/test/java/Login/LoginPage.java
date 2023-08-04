package Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getLoginInput() {
        return driver.findElement(By.id("mat-input-0"));
    }
    public WebElement getPasswordInput() {
        return driver.findElement(By.id("mat-input-1"));
    }

    public WebElement getLoginButton() {
        return driver.findElement(By.xpath("//html/body/app-root/div/app-login/div/form/div/div/div[3]/button/"));
    }

    public void login(String login, String password) {
        getLoginInput().sendKeys(login);
        getPasswordInput().sendKeys(password);
        getLoginButton().click();
    }
}

