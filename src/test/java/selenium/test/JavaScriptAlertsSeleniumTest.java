package selenium.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class JavaScriptAlertsSeleniumTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.selenium.dev/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.findElement(By.cssSelector("a[href='/documentation/webdriver/']")).click();
        driver.findElement(By.cssSelector("a[id$='driverinteractions']")).click();
        driver.findElement(By.cssSelector("a[id$='interactionsalerts']")).click();
        driver.findElement(By.cssSelector("a[onclick*='Sample alert']")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        Thread.sleep(3000);

        driver.findElement(By.cssSelector("a[onclick*='window.confirm']")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().dismiss();
        Thread.sleep(3000);
        driver.quit();

    }
}
