import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
public class FourthTest {
    public WebDriver driver;
    //Declare a test URL variable
    public String testURL = "https://nsbm.hr/";
    //----------------------Test Setup-----------------------------------
    @BeforeMethod
    public void setupTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\madel\\Testiranje\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
//Create a new ChromeDriver
        driver = new ChromeDriver();
//Go to www.swtestacademy.com
        driver.navigate().to(testURL);
    }
    @Test
    public void googleSearchTest() throws InterruptedException {
        driver.manage().window().maximize();
        Thread.sleep(5000);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.manage().window().setSize(new Dimension(400, 740));
        Thread.sleep(5000);
        WebElement responsiveElement = driver.findElement(By.xpath("//*[@id=\"page\"]/div[1]/div/section[3]/div/div/div/div/div/div/div/div/i"));
        responsiveElement.isDisplayed();
    }
    @AfterMethod
    public void teardownTest() {
//Close browser and end the session
        driver.quit();
    }
}
