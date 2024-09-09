package testcases;

import commons.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC03_StaticWait extends BaseTest {
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver = getBrowserDriver("chrome");
    }
    @AfterClass
    public void afterClass(){
        //driver.quit();
    }
    @Test
    public void TestCase() throws InterruptedException {
        driver.get("https://automationfc.github.io/dynamic-loading/");
        driver.findElement(By.xpath("//button")).click();
        Thread.sleep(8000);
        Assert.assertTrue(driver.findElement(By.xpath("//h4")).isDisplayed());

    }
}
