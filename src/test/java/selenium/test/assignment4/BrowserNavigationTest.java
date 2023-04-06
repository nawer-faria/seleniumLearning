package selenium.test.assignment4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BrowserNavigationTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver=new FirefoxDriver();
        driver.get("https://www.selenium.dev/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        // Navigate to
        driver.navigate().to("https://smartmf-erp.brac.net/");
        Thread.sleep(2000);

        // back()
        driver.navigate().back();
        Thread.sleep(2000);

        // forward()
        driver.navigate().forward();
        Thread.sleep(2000);

        // refresh()
        driver.navigate().refresh();

        Thread.sleep(2000);
        driver.quit();

    }
}
