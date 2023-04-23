package testNg.withPriority;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ParaBankWithPriorityTest extends BaseParaBankWithPriorityTest{

    @Test(priority = 0)
    public void verifyPageTitleShouldSucceed(){
        System.out.println("The Page Title is: " + driver1.getTitle());
        Assert.assertEquals(driver1.getTitle().trim(), "ParaBank | Welcome | Online Banking");
        System.out.println("The Page URL is: " + driver1.getCurrentUrl());
    }

    @Test(priority = 1)
    public void verifyLoginPageShouldSucceed(){
        String loginText=driver1.findElement(By.cssSelector("#leftPanel h2")).getText().trim();
        System.out.println("The Text Is: " + loginText);
        Assert.assertEquals(loginText, "Customer Login");
    }

    @Test(priority = 2)
    public void loginShouldSucceed() {

        WebElement usernameEl= driver1.findElement(By.name("username"));
        usernameEl.clear();
        usernameEl.sendKeys("Demo User");

        WebElement passwordEl= driver1.findElement(By.name("password"));
        passwordEl.clear();
        passwordEl.sendKeys("abc");

        driver1.findElement(By.cssSelector("input.button")).click();

        String logoutLinkText=driver1.findElement(By.linkText("Log Out")).getText().trim();
        System.out.println("The Test Is: " + logoutLinkText);
        Assert.assertEquals(logoutLinkText, "Log Out");
    }
}
