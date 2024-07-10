package commons;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public abstract class AbstractPage {
    // - Define 1 biến là WebDriverWait
    private WebDriverWait explicitWait;

    // - Define thư viện Alert
    private Alert alert;

    // - Define thư viện Select
    private Select select;

    // - Define thư viện JavaExecutor
    private JavascriptExecutor jsExecutor;

    // - Define thư viện Actions
    private Actions action;

    // - Define biến long timeout
    private long longTimeOut = 15;

    // - Khai báo biến global cho element (của hàm Javascript Executor)
    private WebElement element;


    // define ra biến url, => tránh việc fix cứng url làm sai ý nghĩa của commons
    protected void implicitWaitBrowser(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    protected static int randomNumber() {
        Random rand = new Random();
        return rand.nextInt(999);
    }

    protected void waitToAlertPresence(WebDriver driver) {
        explicitWait = new WebDriverWait(driver, 30);
        explicitWait.until(ExpectedConditions.alertIsPresent());
    }

    protected void acceptAlert(WebDriver driver) {
        alert = driver.switchTo().alert();
        alert.accept();
    }

    protected void cancelAlert(WebDriver driver) {
        alert = driver.switchTo().alert();
        alert.dismiss();
    }

    protected void sendkeyToAlert(WebDriver driver, String value) {
        alert = driver.switchTo().alert();
        alert.sendKeys(value);
    }


    protected String getTextInAlert(WebDriver driver) {
        alert = driver.switchTo().alert();
        return alert.getText();
    }


    // Xpath
    protected By byXpath(String locator) {
        return By.xpath(locator);
    }

    // Find Element
    protected WebElement find(WebDriver driver, String locator) {
        return driver.findElement(byXpath(locator));
    }

    // Find list Elements
    protected List<WebElement> finds(WebDriver driver, String locator) {
        return driver.findElements(byXpath(locator));
    }


    // Click To Element
    protected void clickToElement(WebDriver driver, String locator) {
        find(driver, locator).click();
    }

    // Senkey to Element
    protected void sendkeyToElement(WebDriver driver, String locator, String value) {
        find(driver, locator).clear();
        find(driver, locator).sendKeys(value);
    }

    // Select Item in Dropdow List
    protected void selectItemInDropdow(WebDriver driver, String locator, String itemValue) {
        select = new Select(find(driver, locator));
        select.selectByVisibleText(itemValue);
    }

    // Get text sau khi được select trong Dropdown
    protected String getFirstSelectedItemInDropdow(WebDriver driver, String locator) {
        select = new Select(find(driver, locator));
        return select.getFirstSelectedOption().getText();
    }

    // Verify Dropdown list là Multiple
    protected boolean isMultipleDropdown(WebDriver driver, String locator) {
        select = new Select(find(driver, locator));
        return select.isMultiple();
    }

    // Select item in custom dropdown list
    protected void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childLocator, String expectedItem) {
        // 1 - Click vào thẻ (cha) để xổ ra tất cả các item con
        find(driver, parentLocator).click();

        // 2 - Chờ cho tất cả các item con được load ra
        explicitWait = new WebDriverWait(driver, 20);

        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(byXpath(childLocator)));

        // 3 - Đưa tất cả các item trong Dropdown vào 1 list để kiểm tra
        List<WebElement> allItems = finds(driver, childLocator);

        // 4 - Chạy qua tất cả các giá trị đang có trong list
        for (WebElement item : allItems) {
            // 5 - Kiểm tra xem text của các giá trị có item nào bằng với text mong muốn không
            if (item.getText().equals(expectedItem)) {
                // 6 - Scroll xuống đến đúng item này
                jsExecutor = (JavascriptExecutor) driver;
                jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);

                // 7 - Click vào item này
                item.click();
                // 8 - Thoát vòng lặp
                break;
            }
        }
    }


    // Get attribute value
    protected String getElementAttribute(WebDriver driver, String locator, String attributeValue) {
        return find(driver, locator).getAttribute(attributeValue);
    }

    // Get text
    protected String getTextElement(WebDriver driver, String locator) {
        return find(driver, locator).getText();
    }

    // Tính tổng element giống nhau có trong page đấy
    protected int countElementsSize(WebDriver driver, String locator) {
        return finds(driver, locator).size();
    }

    // Check to Checkbox
    protected void checkToCheckbox(WebDriver driver, String locator) {
        // Phủ định (!) của isSelected là isUnSelected
        if (!find(driver, locator).isSelected()) {
            find(driver, locator).click();
        }
    }

    // Uncheck to Checkbox
    protected void uncheckToCheckbox(WebDriver driver, String locator) {
        // Nếu đã selected rồi thì click thêm 1 lần nữa để uncheck
        if (find(driver, locator).isSelected()) {
            find(driver, locator).click();
        }
    }

    // isDisplay
    protected boolean isControlDisplayed(WebDriver driver, String locator) {
        return find(driver, locator).isDisplayed();
    }

    // isEnabled
    protected boolean isControlEnable(WebDriver driver, String locator) {
        return find(driver, locator).isEnabled();
    }

    // isSelected
    protected boolean isControlSelected(WebDriver driver, String locator) {
        return find(driver, locator).isSelected();
    }

    // Tương tác với Frame/ iFrame
    protected void switchToFrame(WebDriver driver, String locator) {

        driver.switchTo().frame(find(driver, locator));
    }

    // Chuyển về defaultPage để tương tác sau khi switch qua Frame để tương tác với nó
    protected void switchToDefaultPage(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    // Double click: mô phỏng hành vi của người dùng = hàm Action (Khai báo thư viện Actions)
    protected void doubleClickToElement(WebDriver driver, String locator) {
        action = new Actions(driver);
        action.doubleClick(find(driver, locator)).perform();
    }

    // Right click: mô phỏng hành vi của người dùng = hàm Action (Khai báo thư viện Actions)
    protected void rightClickToElement(WebDriver driver, String locator) {
        action = new Actions(driver);
        action.contextClick(find(driver, locator)).perform();
    }

    // Hover to Element: mô phỏng hành vi của người dùng = hàm Action (Khai báo thư viện Actions)
    protected void hoverToElement(WebDriver driver, String locator) {
        action = new Actions(driver);
        action.moveToElement(find(driver, locator)).perform();
    }

    // Drag And Drop to Element: mô phỏng hành vi của người dùng = hàm Action (Khai báo thư viện Actions)
    protected void dragAndDropElement(WebDriver driver, String locator, String sourceLocator, String targetLocator) {
        action = new Actions(driver);
        action.dragAndDrop(find(driver, sourceLocator), find(driver, targetLocator)).perform();
        ;
    }

    // Send keyBoard to Element: mô phỏng hành vi của người dùng = hàm Action (Khai báo thư viện Actions)
    protected void sendKeyBoardToElement(WebDriver driver, String locator, Keys key) {
        action = new Actions(driver);
        action.sendKeys(find(driver, locator), key).perform();
    }

    protected void waitToElementPresence(WebDriver driver, String locator) {
        explicitWait = new WebDriverWait(driver, longTimeOut);
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(byXpath(locator)));
    }

    protected void waitToElementVisible(WebDriver driver, String locator) {
        explicitWait = new WebDriverWait(driver, longTimeOut);
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(byXpath(locator)));
    }

    protected void waitToElementInVisible(WebDriver driver, String locator) {
        explicitWait = new WebDriverWait(driver, longTimeOut);
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(byXpath(locator)));
    }

    protected void waitToElementClickable(WebDriver driver, String locator) {
        explicitWait = new WebDriverWait(driver, longTimeOut);
        explicitWait.until(ExpectedConditions.elementToBeClickable(byXpath(locator)));
    }

    protected void clickToElementByJS(WebDriver driver, String locator) {
        jsExecutor = (JavascriptExecutor) driver;
        element = find(driver, locator);
        jsExecutor.executeScript("arguments[0].click();", element);
    }

    protected void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
        jsExecutor = (JavascriptExecutor) driver;
        element = find(driver, locator);
        jsExecutor.executeScript("arguments[0].setAttribute('value'," + value + "')", element);
    }

    protected void removeAtributteInDOM(WebDriver driver, String locator, String attributeRemove) {
        jsExecutor = (JavascriptExecutor) driver;
        element = find(driver, locator);
        jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "')", element);
    }
    protected void scrollIntoView(WebDriver driver, String locator){
        jsExecutor = (JavascriptExecutor) driver;
        element = find(driver, locator);
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    protected void scrollIntoViewToClick(WebDriver driver, String locator){
        jsExecutor = (JavascriptExecutor) driver;
        element = find(driver, locator);
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
        jsExecutor.executeScript("arguments[0].click();", element);
    }

    protected void getItemInListItem(WebDriver driver, String locator, String expected){
        List<WebElement> allItems = finds(driver, locator);
        for (WebElement item : allItems){
            if (item.getText().equals(expected)){
                String actual = item.getText();
                Assert.assertEquals(expected, actual);
            }else {
                throwException();
            }
        }
    }

    protected void clickItemInListItem(WebDriver driver, String locator, String expected){
        List<WebElement> allItems = finds(driver, locator);
        for (WebElement item : allItems){
            if (item.getText().equals(expected)){
                item.click();
                break;
            }
        }
    }

    protected void throwException(){
        try {
            throw new Exception("------ Khong ton tai gia tri EXPECTED nay!!! ------");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
