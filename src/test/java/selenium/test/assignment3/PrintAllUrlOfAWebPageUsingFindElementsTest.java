package selenium.test.assignment3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.List;

public class PrintAllUrlOfAWebPageUsingFindElementsTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://smartmf-erp.brac.net/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        //Login to ERP SmartMF
        WebElement userName = driver.findElement(By.cssSelector("input[id*='username_']"));
        userName.clear();
        userName.sendKeys("00191549");
        WebElement password = driver.findElement(By.cssSelector("input[name^='j_pass']"));
        password.clear();
        password.sendKeys("abc123$");
        driver.findElement(By.cssSelector("button[class$='btn-primary']")).click();

        // Print All Url Of A Web Page Using Find Elements
        List<WebElement> linkList = driver.findElements(By.tagName("a"));
        System.out.println("The web page contains total " + linkList.size() + "links");

        if (linkList.size() != 0) {
            for (WebElement webElement : linkList) {
                String linkValue = webElement.getAttribute("href"); //.trim() trims space if any at the begaining or end of the link
                if (linkValue != null && !linkValue.isEmpty() && !linkValue.equals("")) {
                    System.out.println(linkValue);
                }
            }
        }

        Thread.sleep(3000);
        driver.quit();
    }
}
