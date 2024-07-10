package testcases;

import commons.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Level_01_Setup_Environment extends BaseTest {
    WebDriver driver;
    @BeforeClass
    public void beforeClass(){
        driver = getBrowserDriver("chrome");
    }

    @AfterClass
    public void afterClass(){
        quitBrowser(driver);
    }

    @Test
    //public void TC_01(){
        // Get(): de truyen URL -> mo ra page day
        // Get nhan vao 1 chuoi gia tri la String -> nen phai co ""
       //driver.get("https://alada.vn/tai-khoan/dang-ky.html");
       //driver.findElement(By.xpath("//button[@class='btn_pink_sm fs16']")).click();
    //}
    public void TC_02(){
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.findElement(By.xpath("//input[@id='txtFirstname']")).sendKeys("Hoang Hai Yen");
        driver.findElement(By.xpath("//input[@id='txtEmail']")).sendKeys("haiaja");
        driver.findElement(By.xpath("//input[@id='txtCEmail']")).sendKeys("haiaja");
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("Hoang Hai Yen");
        driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("0357207250");
        driver.findElement(By.xpath("//button[@class='btn_pink_sm fs16']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//input[@id='txtEmail']//following-sibling::label")).isDisplayed());
        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='txtEmail']//following-sibling::label")).getText(), "Không biết", "Sai");


    }
}