package testcases;

import commons.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Check2 extends BaseTest {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = getBrowserDriver("chrome");
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }

    @AfterClass
    public void afterClass() {
        // driver.quit();
    }

    @Test
    public void Testcase() {
        driver.get("https://material.playwrightvn.com/021-import-export.html");
        Select select1 = new Select(driver.findElement(By.xpath("//select[@id = 'filterCriteria']")));
        select1.selectByVisibleText("Lớp");
        driver.findElement(By.xpath("//input[@id = 'searchInput']")).sendKeys("A4");
        driver.findElement(By.xpath("//button[@id = 'searchButton']")).click();

        List<WebElement> rows = driver.findElements(By.xpath("//table[@id = 'studentTable']//tbody//tr"));
        List<WebElement> b = driver.findElements(By.xpath("//table[@id = 'studentTable']//tbody//tr//td"));

        for (WebElement row : rows) {
            if (rows.size() == 1){



            }else{
             System.out.print("Sai");
            }
        }
    }
}
