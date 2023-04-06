package selenium.test.asignment1browserlaunch;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class FirefoxBrowserLaunchTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver=new FirefoxDriver();

        driver.get("https://www.selenium.dev/");
        driver.manage().window().maximize();

        // Implicit wait (will wait for max 30 ses)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        // Prints page Title
        System.out.println(driver.getTitle());

        // Prints current page URL
        System.out.println(driver.getCurrentUrl());

        //Thread Sleep (stops execution for 30 sec)
        Thread.sleep(3000);
        driver.quit();

    }
}
