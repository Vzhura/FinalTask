package AddJob;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddJobPage {
        private WebDriver driver;
        public AddJobPage(WebDriver driver) {
            this.driver = driver;
        }

    public WebElement getAddJobButton() {
        return driver.findElement(By.xpath("//button[contains(text(), 'Add job')]"));
    }
    public WebElement getTitle() {
        return driver.findElement(By.id("mat-input-2"));
    }
    public WebElement getDescription() {
        return driver.findElement(By.id("mat-input-3"));
    }
    public WebElement getPrice() {
        return driver.findElement(By.id("mat-input-4"));
    }
    public WebElement CreateJobButton() {
        return driver.findElement(By.xpath("//button[contains(text(), 'Create job')]"));
    }
    public void getAddJob (String Title, String Description, String Price) {
        getAddJobButton().click();
        getTitle().sendKeys(Title);
        getDescription().sendKeys(Description);
        getPrice().sendKeys(Price);
        CreateJobButton().click();
    }
    public String getDescriptionValue() {
        return getDescription().getAttribute("value");
    }

}
