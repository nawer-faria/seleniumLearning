package selenium.test.assignment5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Set;

public class WindowTest {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://demoqa.com/browser-windows");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        String originalWindow = driver.getWindowHandle();
//        driver.findElement(By.id("tabButton")).click();
        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to("https://demoqa.com/sample");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++");
        System.out.println(driver.findElement(By.id("sampleHeading")).getText());

        Set<String> windows = driver.getWindowHandles();
        System.out.println("+++++++++++++++++++++++++++++++++++++++++");
        System.out.println(windows.size());
        driver.close();
        driver.switchTo().window(originalWindow);

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.navigate().to("https://demoqa.com/sample");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++");
        System.out.println(driver.findElement(By.id("sampleHeading")).getText());
        windows = driver.getWindowHandles();
        System.out.println("+++++++++++++++++++++++++++++++++++++++++");
        System.out.println(windows.size());
        driver.close();
        driver.switchTo().window(originalWindow);

        driver.quit();

    }
}
