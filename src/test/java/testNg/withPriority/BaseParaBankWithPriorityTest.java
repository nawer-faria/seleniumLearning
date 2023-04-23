package testNg.withPriority;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseParaBankWithPriorityTest {

    protected static WebDriver driver1;

    @BeforeClass
    public void browserLaunch() {
        WebDriverManager.firefoxdriver().setup();
        driver1 = new FirefoxDriver();
        driver1.get("https://parabank.parasoft.com/parabank/index.htm");
        driver1.manage().window().maximize();
        driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @AfterClass
    public void tearDown() {
        driver1.quit();
    }
}
