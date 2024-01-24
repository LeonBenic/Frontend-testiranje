import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
public class ThirdTest {
    public WebDriver driver;
    //Declare a test URL variable
    public String testURL = "http://www.google.com";
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
        WebElement searchTextBox = driver.findElement(By.name("q"));
        searchTextBox.sendKeys("ferit");
        searchTextBox.submit();

        Thread.sleep(5000);

        WebElement linkRaspored =
                driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/table/tbody/tr[1]/td/div/div/div/div/h3/a")
                );
        linkRaspored.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement linkGrupe =
                driver.findElement(By.xpath("//*[@id=\"raspored\"]/h3/a[2]")
                );
        linkGrupe.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement linkDRC =
                driver.findElement(By.xpath("/html/body/div[13]/div/h3/div[2]/div/p[6]/a[5]")
                );
        linkDRC.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Thread.sleep(5000);
        String expectedUrl = "https://www.ferit.unios.hr/studenti/raspored-nastave-i-ispita/2024-01-24/1-38#raspored";
        String actualUrl = driver.getCurrentUrl();

        // Assert that the expected URL is equal to the actual URL
        Assert.assertEquals(actualUrl, expectedUrl, "Clicking on the link did not lead to the expected page.");
    }
    @AfterMethod
    public void teardownTest() {
//Close browser and end the session
        driver.quit();
    }
}
