package LeaveComment;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        Configuration.timeout = 7500;
    }
    public void clickJob(String jobTitle) {
        WebElement jobLink = driver.findElement(By.linkText(jobTitle));
        jobLink.click();
    }
}

