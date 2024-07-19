package testcases;

import commons.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC_4 extends BaseTest {
    WebDriver driver;
    Select select;
    @BeforeClass
    public void beforeClass(){
        driver = getBrowserDriver("chrome");
    }

    @AfterClass
    public void afterClass(){
        quitBrowser(driver);
    }
    @Test
    public void Testcase(){
        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2Fregister");
        driver.findElement(By.xpath("//a[@class='ico-register']")).click();
        Assert.assertFalse(driver.findElement(By.xpath("//input[@id=\"gender-male\"]")).isSelected(), "Sai");
        driver.findElement(By.xpath("//input[@id=\"gender-male\"]")).click();
        driver.findElement(By.xpath("//input[@id=\"FirstName\"]")).sendKeys("Hoang Hai");
        driver.findElement(By.xpath("//input[@id=\"LastName\"]")).sendKeys("Yen");
        Select select1 = new Select(driver.findElement(By.xpath("//select[@name = 'DateOfBirthDay']")));
        select1.selectByVisibleText("1");
        Assert.assertEquals(select1.getOptions().size(), 32);
        Select select2 = new Select(driver.findElement(By.xpath("//select[@name = 'DateOfBirthMonth']")));
        select2.selectByVisibleText("May");
        Assert.assertEquals(select2.getOptions().size(), 13);
        Select select3 = new Select(driver.findElement(By.xpath("//select[@name = 'DateOfBirthYear']")));
        select3.selectByVisibleText("1985");
        driver.findElement(By.xpath("//input[@id = 'Email']")).sendKeys("Hoanghaiyen12a12062002@gmail.com");
        driver.findElement(By.xpath("//input[@id = 'Company']")).sendKeys("Icetea");
        driver.findElement(By.xpath("//input[@id = 'Password']")).sendKeys("Icetea");
        driver.findElement(By.xpath("//input[@id = 'ConfirmPassword']")).sendKeys("Icetea");
        driver.findElement(By.xpath("//button[@id = 'register-button']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class = 'result' and text() = 'Your registration completed']")).getText(), "Your registration completed");
        driver.findElement(By.xpath("//a[@class= 'ico-account']")).click();
        Assert.assertEquals(select1.getFirstSelectedOption().getText(), "1");
        Assert.assertEquals(select2.getFirstSelectedOption().getText(), "May");





    }
}
