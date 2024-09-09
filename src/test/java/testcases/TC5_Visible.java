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

public class TC5_Visible extends BaseTest {
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver = getBrowserDriver("chrome");
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
    @Test
    public void TestCase(){
        driver.get("https://automationfc.github.io/dynamic-loading/");
        driver.findElement(By.xpath("//button")).click();
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4")));
        Assert.assertTrue(driver.findElement(By.xpath("//h4")).isDisplayed());

    }
}
