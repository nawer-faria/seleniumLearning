package selenium.test.assignment5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Set;

public class CookiesTest {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://demoqa.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        // Add Cookie
        driver.manage().addCookie(new Cookie("User","00016952"));

        // Get Named Cookie
        System.out.println(driver.manage().getCookieNamed("User"));

        // Delete Cookie
        driver.manage().deleteCookieNamed("User");

        Set<Cookie> cookies = driver.manage().getCookies();

        // Get All Cookies: for each loop
        for(Cookie cookie : cookies){
            System.out.println("Cookie Name: "+ cookie.getName());
            System.out.println("Cookie Path: " + cookie.getPath());
            System.out.println("Cookie Value: "+cookie.getValue());
            System.out.println("Cookie Expiry Date: " + cookie.getExpiry());
        }

        // Print Cookie Size
        System.out.println("Cookie size before delete: "+cookies.size());

        // Delete All Cookies
        driver.manage().deleteAllCookies();
        cookies=driver.manage().getCookies();
        System.out.println("Cookie size after delete: "+cookies.size());

        driver.quit();
    }
}
