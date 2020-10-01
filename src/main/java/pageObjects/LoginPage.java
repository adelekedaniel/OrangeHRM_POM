package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    //In the page class we need the field that represent the elements on th page and method to interact with the element

    private WebDriver driver;


    public LoginPage(WebDriver driver)
    {
     this.driver = driver;
    }

    //Using By as a locator for elements
    private By username = By.id("txtUsername");

    public void enterUsername(String uName)
    {
        //Find the username element and enter the username
        driver.findElement(username).sendKeys(uName);
    }

    public void enterPassword(String pwd)
    {
        WebElement passwordField = driver.findElement(By.id("txtPassword"));
        passwordField.sendKeys(pwd);
    }

    public DashboardPage clickLoginBtn()
    {
        driver.findElement(By.id("btnLogin")).click();
        return new DashboardPage(driver);
    }
}
