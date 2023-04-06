package selenium.test.assignment4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public record WorkingWithSelectListElements() {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://smartmf-erp.brac.net/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        // Login to SmartMF ERP
        WebElement userName = driver.findElement(By.cssSelector("input[id*='username_']"));
        userName.clear();
        userName.sendKeys("00191549");
        WebElement password = driver.findElement(By.cssSelector("input[name^='j_pass']"));
        password.clear();
        password.sendKeys("abc123$");
        driver.findElement(By.cssSelector("button[class$='btn-primary']")).click();

        //Microfinance
        driver.findElement(By.cssSelector("a[href='/mfDashboard']")).click();
        //Member
        driver.findElement(By.cssSelector("li.menu-parent:nth-child(5) > div:nth-child(1)")).click();
        //Member Setup Page
        driver.findElement(By.cssSelector("li.menu-parent:nth-child(5) > ul:nth-child(2) > li:nth-child(1) > div:nth-child(1) > span:nth-child(1)")).click();
        driver.findElement(By.cssSelector("li.menu-parent:nth-child(5) > ul:nth-child(2) > li:nth-child(1) > ul:nth-child(2) > li:nth-child(1) > a:nth-child(1) > span:nth-child(1)")).click();
        Thread.sleep(2000);

        //Select List Elements
        WebElement otherId = driver.findElement(By.cssSelector("select[id='project_info_id']"));
        Select select = new Select(otherId);
        select.selectByValue("171798702775");
        Thread.sleep(3000);
        select.selectByVisibleText("[15] - Microfinance (Dabi)");
        Thread.sleep(3000);
        select.selectByIndex(3);
        Thread.sleep(3000);


        for (WebElement options : select.getOptions()) {
            System.out.println("Dropdown Options are: " + options.getText());
        }

        Thread.sleep(3000);
        driver.quit();
    }
}
