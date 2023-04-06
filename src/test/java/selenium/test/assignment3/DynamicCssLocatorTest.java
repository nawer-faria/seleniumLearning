package selenium.test.assignment3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DynamicCssLocatorTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver=new FirefoxDriver();

        driver.get("https://smartmf-erp.brac.net/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        // tag[attribute*='value']    * contains the 'value'
        WebElement userName=driver.findElement(By.cssSelector("input[id*='username_']"));
        userName.clear();
        userName.sendKeys("00191549");

        // tag[attribute^='value']    ^ start with 'value'
        WebElement password=driver.findElement(By.cssSelector("input[name^='j_pass']"));
        password.clear();
        password.sendKeys("abc123$");

        // tag[attribute$='value']    $ end with 'value'
        driver.findElement(By.cssSelector("button[class$='btn-primary']")).click();

        Thread.sleep(3000);
        driver.quit();



    }
}
