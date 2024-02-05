package com.project.StepDefn;

import com.project.Pages.Login_pojo;
import com.project.Utils.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.Select;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.*;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;

public class Base_class extends Constants{
public static WebDriver driver;
public static String variableName ="";
public static WebDriverWait webDriverWait;
public static JavascriptExecutor jsDriver;
public static String myFilePath = System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\";
public static List<String> errorLog =  new ArrayList<String>();
public static List<String> locationName = new ArrayList<String>();
public static  List<String> locationStatus = new ArrayList<String>();
public static String chromepath = System.getProperty("user.dir") + "\\src\\test\\resources\\Drivers\\chromedriver.exe";
public static String chromeKey = "webdriver.chrome.driver";

//	public static void Launch_browser() {	
//		WebDriverManager.chromedriver().setup();
//		driver=new ChromeDriver();
//		driver.manage().window().maximize();		
//	}
	public static void launch_Browser() throws AWTException, InterruptedException {
        WebDriverManager.chromedriver().setup();       
//        Map<String, Object> prefs = new HashMap<String, Object>();
//        prefs.put("download.default_directory", myFilePath +typeUI );
//        ChromeOptions options = new ChromeOptions();
//         //options.addArguments("--headless=new");
//        options.setExperimentalOption("prefs", prefs);

//    	System.setProperty(chromeKey, chromepath);
//    	System.out.println(chromepath);
        driver = new ChromeDriver();

//        jsDriver = (JavascriptExecutor) driver;
//        ngWebDriver = new NgWebDriver(jsDriver);

        implicitWait(20);
        driver.manage().window().maximize();
        Login_pojo login_pojo = new Login_pojo();
        defaultWait(5000);
    }

    public static void load_url(String url) {
        driver.get(url);        
    }

    public static void cLickBtn(WebElement element) {
        element.click();
    }

    public static String getText(WebElement element) {
        return element.getText();
    }

    public static void sendText(WebElement element, String text) {
        element.sendKeys(text);

    }

    public static void currentPageURL() {
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
    }

    public static void pageTitle() {
        String title = driver.getTitle();
        System.out.println(title);
    }

    public static void closeBrowser() {
        driver.close();
    }


    // JAVASCRIPT EXECUTORS METHODS

    public static JavascriptExecutor js;

    public static void scrollPage(WebElement targetWebelement) {
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()", targetWebelement);


    }

    public static void javascriptClick(WebElement targetWebelement) {
        js = (JavascriptExecutor) driver;
        js.executeAsyncScript("arguments[0].click()", targetWebelement);
    }

    public static void javascriptGetAttribute(WebElement targetWebelement) {
        js = (JavascriptExecutor) driver;
        js.executeScript("return arguments[0].getAttribute('value')", targetWebelement);
    }

    public static void javascriptSetAttribute(WebElement targetWebelement, String value) {
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('value'" + value + ")", targetWebelement);

    }

    //ACTIONS CLASS METHODS

    public static Actions a;

    public static void moveToElement(WebElement target) {
        a = new Actions(driver);
        a.moveToElement(target).perform();

    }

    public static void dragAndDrop(WebElement source, WebElement target) {
        a = new Actions(driver);
        a.dragAndDrop(source, target).perform();

    }

    public void doubleClick(WebElement target ) {
        a = new Actions(driver);
        a.doubleClick(target).perform();

    }

    public static void contextClick(WebElement target) {
        a = new Actions(driver);
        a.contextClick(target).perform();
    }

    // WAITS METHODS

    public static void implicitWait(long unit) {
        driver.manage().timeouts().implicitlyWait(unit, TimeUnit.SECONDS);

    }

//    public static void webdriverWait(long timeOutInSeconds, WebElement element) {
//        WebDriverWait wb = new WebDriverWait(driver, timeOutInSeconds);
//        //wb.until(ExpectedConditions.visibilityOf(element));
//    }


    public static void defaultWait(long unit) throws InterruptedException {
        Thread.sleep(unit);
    }

    public static void webdriverElementClickable(Duration timeOutInSeconds, WebElement element) {
        WebDriverWait wb = new WebDriverWait(driver, timeOutInSeconds);
        //wb.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void screenshot(String imgName, String ssLink) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File Source = ts.getScreenshotAs(OutputType.FILE);
        File destination = new File("" + ssLink + "/" + imgName + ".png");
        FileUtils.copyFile(Source, destination);
    }

    public static void selectVisibleText(WebElement element, String sValue){
        Select sel = new Select(element);
        sel.selectByVisibleText(sValue);
    }

    public static void switchMainWindow()
    {
        Set<String> AllWindow = driver.getWindowHandles();
        List<String> AllId = new ArrayList<String>(AllWindow);

        for (int i = 1; i < AllId.size(); i++) {
            driver.switchTo().window(AllId.get(i));
            driver.close();
        }
        driver.switchTo().window(AllId.get(0));
    }

    public static void redWinSize(int noOfTimes) throws AWTException {
        Robot robot = new Robot();
        for (int j = 0; j < noOfTimes; j++) {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        }
    }

    public static void incWinSize(int noOfTimes) throws AWTException {
        Robot robot = new Robot();
        for (int j = 0; j < noOfTimes; j++) {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ADD);
            robot.keyRelease(KeyEvent.VK_ADD);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        }
    }
	
}
