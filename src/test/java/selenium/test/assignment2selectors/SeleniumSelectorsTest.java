package selenium.test.assignment2selectors;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class SeleniumSelectorsTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver=new FirefoxDriver();
        driver.get("https://demoqa.com/text-box");
        driver.manage().window().maximize();

        // Implicit wait (will wait for max 30 ses)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        // driver.findElement(By.id("userName")).sendKeys("Faria Nawer");

        // By ID
        WebElement userName=driver.findElement(By.id("userName"));
        userName.clear();
        userName.sendKeys("Faria Nawer");
        WebElement userEmail=driver.findElement(By.id("userEmail"));
        userEmail.clear();
        userEmail.sendKeys("faria.nawer@gmail.com");

        // By Tag Name
        driver.findElement(By.tagName("textarea")).sendKeys("Parveen Villa");
        Thread.sleep(3000);

        driver.navigate().to("https://parabank.parasoft.com/parabank/index.htm");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        // By Name
        WebElement userName1=driver.findElement(By.name("username")); // Creates a WebElement type object
        userName1.clear();
        userName1.sendKeys("FariaNawer");
        WebElement password=driver.findElement(By.name("password"));
        password.clear();
        password.sendKeys("abcd1234");

        //By Css Selector
        driver.findElement(By.cssSelector("form .login [value='Log In']")).click();

        // By Class Name
        driver.findElement(By.className("contact")).click();

        // By Link Text
        driver.findElement(By.linkText("About Us")).click();

        // BY Partial Link Text
        driver.findElement(By.partialLinkText("Admin page")).click();

        driver.findElement(By.cssSelector(".leftmenu a[href='services.htm']")).click();
        Thread.sleep(3000);
        driver.quit();

    }
}
