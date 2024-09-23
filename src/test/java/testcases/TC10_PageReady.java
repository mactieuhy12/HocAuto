package testcases;

import commons.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC10_PageReady extends BaseTest {
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver = getBrowserDriver("chrome");
    }

    @AfterClass
    public void afterClass(){
       // driver.quit();
    }

    @Test
    public void Testcase(){
        driver.get("https://admin-demo.nopcommerce.com/");
        driver.findElement(By.xpath("//input[@type= 'checkbox'")).click();
        WebDriverWait wait = new WebDriverWait(driver, 8);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class = 'lds-ring' ]")));
        driver.findElement(By.xpath("//a[@class = 'nav-link' and text() = \"Logout\"]")).click();
        driver.findElement(By.xpath("//button[@type = 'submit']")).click();
        WebDriverWait wait1 = new WebDriverWait(driver, 5);
        wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//i[@class = 'fas fa-cogs']")));
        driver.findElement(By.xpath("//a[@class = 'nav-link' and text() = \"Logout\"]")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//strong")).getText(), "Welcome, please sign in!" );

    }



}
