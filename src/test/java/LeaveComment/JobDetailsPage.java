package LeaveComment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JobDetailsPage {
    private WebDriver driver;

    public JobDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickViewInfoButton() {
        WebElement viewInfoButton = driver.findElement(By.xpath("/html/body/app-root/div/app-index/div/mat-card[1]/mat-card-actions/button/"));
        viewInfoButton.click();
    }

    public void leaveComment(String comment) {
        WebElement commentInput = driver.findElement(By.id("mat-input-1"));
        WebElement leaveCommentButton = driver.findElement(By.id("Leave comment"));

        commentInput.sendKeys(comment);
        leaveCommentButton.click();
    }
}

