package ChangeUserData;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePage {
    private WebDriver driver;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getProfileTab() {
        return driver.findElement(By.xpath("/html/body/app-root/div/app-navigation/mat-toolbar/button/span[1]/mat-icon"));
    }

    public WebElement getEditInfoButton() {
        return driver.findElement(By.xpath("//button[contains(text(), 'Edit Info')]"));
    }

    public WebElement CreateJobButton() {
        return driver.findElement(By.xpath("//button[contains(text(), 'Create job')]"));
    }

    public WebElement getCloseProfileButton() {
        return driver.findElement(By.xpath("//button[contains(text(), 'Close profile')]"));
    }

    public WebElement getNewName() {
        return driver.findElement(By.id("mat-input-15"));
    }

    public WebElement getNewLastName() {
        return driver.findElement(By.id("mat-input-16"));
    }

    public void openProfilePage() {
        getProfileTab().click();
    }

    public WebElement UpdateButton() {
        return driver.findElement(By.xpath("//button[contains(text(), ' Update')]"));
    }

    public void editInfo(String NewName, String NewLastName) {
        getEditInfoButton().click();
        getNewName().sendKeys(NewName);
        getNewLastName().sendKeys(NewLastName);
        UpdateButton().click();
    }

    public String getNewNameValue() {
        return getNewName().getAttribute("value");
    }

    public String getNewLastNameValue() {
        return getNewLastName().getAttribute("value");
    }

    public void viewMyJobs() {
        WebElement myJobsLink = driver.findElement(By.linkText("My Jobs"));
        myJobsLink.click();
    }

    public int getCommentCount(String jobTitle) {
        WebElement commentCountElement = driver.findElement(By.xpath("//a[contains(text(), '" + jobTitle + "')]/../span"));
        return Integer.parseInt(commentCountElement.getText());
    }

    public void deleteJob(String jobTitle) {
        WebElement deleteButton = driver.findElement(By.xpath("//a[contains(text(), '" + jobTitle + "')]/../a[@title='Delete']"));
        deleteButton.click();
    }
}
