package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pageObjects.LoginPage;

import java.util.concurrent.TimeUnit;

public class SetupTests {
    //Create a WebDriver Object
    private WebDriver driver;
    //Create LoginPage object
    protected LoginPage loginPage;

    @BeforeTest
    public void setUp()
    {
        //Selenium WebDriver needs this executable in order to know which browser to run your test
        //Browser setup or Chrome
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        //Instantiate WebDriver object
        driver = new ChromeDriver();

        //Maximize window size
        driver.manage().window().maximize();

        //Launch the application and wait
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Instantiate login page after launching the browser - Handle
        loginPage = new LoginPage(driver);
    }

    @AfterTest
    public void closeBrowser()
    {
        //".close" would close the window but the ".quit" would exit the session
        driver.quit();
    }
}
