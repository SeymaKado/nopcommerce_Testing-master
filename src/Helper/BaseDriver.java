package Helper;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDriver {
    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeClass(groups = {"Regression"})
    public void StartsRegression() {
        Logger logger = Logger.getLogger("");
        logger.setLevel(Level.SEVERE);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Login();
    }

    @AfterClass(groups = {"Regression"})
    public void FinishRegression() {
        Function.Wait(5);
        driver.quit();
    }

    @BeforeMethod(groups = {"Smoke"})
    public void StartsSmoke() {
        Logger logger = Logger.getLogger("");
        logger.setLevel(Level.SEVERE);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @AfterMethod(groups = {"Smoke"})
    public void FinishSmoke() {
        Function.Wait(5);
        driver.quit();
    }

    public void myClick(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        scrollToElement(element);
        element.click();
    }

    public void mySendkeys(WebElement element, String text) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        scrollToElement(element);
        element.clear();
        element.sendKeys(text);
    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void verifyContainsText(WebElement element, String value) {
        wait.until(ExpectedConditions.textToBePresentInElement(element, value));
        Assert.assertTrue(element.getText().toLowerCase().contains(value.toLowerCase()));
    }

    public void myHover(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        scrollToElement(element);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    public void mySelect(WebElement element, String text) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        Select dMenu = new Select(element);
        dMenu.selectByVisibleText(text);
    }

    public void myJsClick(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        scrollToElement(element);
        JavascriptExecutor js = (JavascriptExecutor) (driver);
        js.executeScript("arguments[0].click();", element);
    }

    public void Login() {
        driver.get("https://demo.nopcommerce.com/");
        myClick(driver.findElement(By.linkText("Log in")));
        mySendkeys(driver.findElement(By.xpath("//div//input[@class='email']")), "Burnage_Logan@example.com");
        mySendkeys(driver.findElement(By.xpath("//div//input[@class='password']")), "123qwe456asd7");
        myClick(driver.findElement(By.xpath("//div//button[@class='button-1 login-button']")));
    }
}
