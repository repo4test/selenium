/**
 * 
 */
package pocsquash;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * @author angoumtsa-ext
 * 
 *         Test JUnit pour test de retour de résultats de tests dans Squash
 *
 */

public class CU00XX_TestJUnit {

    private static WebDriver driver;

    @Before
    public void setUp() {
        // Driver Instantiation: Instantiate driver object as ChromeDriver

        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless", "--disable-gpu", "--window-size=1920,1200", "--ignore-certificate-errors");

        driver = new ChromeDriver(options);

        driver.navigate().to("https://www.google.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test1() {
        System.out.println("This fake Test1 is OK");
        Assert.assertTrue(true);
    }

    @Test
    public void GoogleSearchTest() {

        Assert.assertEquals("Title failed Checked", driver.getTitle(), "Google");

        WebElement searchForm = driver.findElement(By.xpath("//input[@name='q']"));

        searchForm.sendKeys("Robot Framework");

        driver.findElement(By.xpath("//li[1]//div[1]//div[2]")).click();

    }

    @After
    public void tearDown() throws Exception {
        // Close driver
        driver.close();

        // Quit Driver
        driver.quit();
    }
}
