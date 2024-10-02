package testcases;

import commons.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class KTra extends BaseTest {
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver = getBrowserDriver("chrome");
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }

    @AfterClass
    public void afterClass(){
       // driver.quit();
    }

    @Test
    public void Testcase(){
        driver.get("https://material.playwrightvn.com/021-import-export.html");
        Select select1 = new Select(driver.findElement(By.xpath("//select[@id = 'filterCriteria']")));
        select1.selectByVisibleText("Lớp");
        driver.findElement(By.xpath("//input[@id = 'searchInput']")).sendKeys("A4");
        driver.findElement(By.xpath("//button[@id = 'searchButton']")).click();
        driver.findElement(By.xpath("//table[@id = 'studentTable']//tbody")).getSize();

        //Khởi tạo biến đếm số lượng dòng hiển thị
        int rowVisiable = 0;
        String thongtin = null;


        List<WebElement> rows = driver.findElements(By.xpath("//table[@id = 'studentTable']//tbody//tr"));
        // Duyệt qua từng hàng
        for (WebElement row : rows){
            if (row.isDisplayed()){
                rowVisiable++;
                thongtin = row.getText();

            }
        }
        // Kiểm tra số lượng hieenr thị
        Assert.assertEquals(rowVisiable, 1);
        Assert.assertEquals(thongtin, "4 Phạm Thị D 10A4 6 9 6");

        // Xóa nội dung tìm kiếm
        driver.findElement(By.xpath("//input[@id = 'searchInput']")).clear();
        driver.findElement(By.xpath("//button[@id = 'searchButton']")).click();

        Assert.assertEquals(rows.size(), 5);

        Assert.assertEquals(rows.get(0).getText(), "1 Nguyễn Văn A 10A1 8 7 9");
        Assert.assertEquals(rows.get(1).getText(), "2 Trần Thị B 10A2 9 6 8");
        Assert.assertEquals(rows.get(2).getText(), "3 Lê Văn C 10A3 5 8 7");
        Assert.assertEquals(rows.get(3).getText(), "4 Phạm Thị D 10A4 6 9 6");
        Assert.assertEquals(rows.get(4).getText(), "5 Hoàng Văn E 10A5 7 8 8");

    }





}
