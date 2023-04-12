package selenium.test.assignment6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWaitTest {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://demoqa.com/alerts");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));

        //Explicit wait until .titleContains the page title
        explicitWait.until(ExpectedConditions.titleContains(driver.getTitle()));
        System.out.println(driver.getTitle());

        WebElement simpleAlert = driver.findElement(By.cssSelector("button[id*='alertButton']"));
        //Explicit wait until .elementToBeClickable
        explicitWait.until(ExpectedConditions.elementToBeClickable(simpleAlert));
        simpleAlert.click();
        //Explicit wait until .alertIsPresent
        explicitWait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();

        //Explicit wait until .visibilityOf a web element
        explicitWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".main-header"))));
        System.out.println(driver.findElement(By.cssSelector(".main-header")).getText());

        WebElement confirmAlert = driver.findElement(By.cssSelector("button[id*='confirmButton']"));
        explicitWait.until(ExpectedConditions.elementToBeClickable(simpleAlert));
        confirmAlert.click();
        explicitWait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().dismiss();

        explicitWait.until(ExpectedConditions.titleContains(driver.getTitle()));
        System.out.println(driver.getTitle());


        WebElement promtAlert=driver.findElement(By.cssSelector("button[id*='promtButton']"));
        explicitWait.until(ExpectedConditions.elementToBeClickable(simpleAlert));
        promtAlert.click();

        Alert promptalert= driver.switchTo().alert();
        promptalert.sendKeys("IT IS OK TO HIT OK");

        System.out.println(promptalert.getText());
        promptalert.accept();

        driver.quit();
    }
}
