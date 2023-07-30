package Registration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage {
    private WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getUsernameInput() {
        return driver.findElement(By.id("mat-input-0"));
    }
    public WebElement getNameInput() {
        return driver.findElement(By.id("mat-input-1"));
    }
    public WebElement getUserLastnameInput() { return driver.findElement(By.id("mat-input-2")); }
    public WebElement getPasswordInput() {
        return driver.findElement(By.id("mat-input-3"));
    }
    public WebElement getConfirmPasswordInput() { return driver.findElement(By.id("mat-input-4"));}

    public WebElement getRegisterButton() {
        return driver.findElement(By.xpath("//button[contains(text(), 'Register')]"));
    }

    public void register(String username, String name, String lastname, String password) {
        getUsernameInput().sendKeys(username);
        getNameInput().sendKeys(name);
        getUserLastnameInput().sendKeys(lastname);
        getPasswordInput().sendKeys(password);
        getConfirmPasswordInput().sendKeys(password);
        getRegisterButton().click();
    }
}
