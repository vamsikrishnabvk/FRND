package com.QA.Base;

import com.QA.reports.ExtentReport;
import com.QA.utlis.TestUtils;
import com.aventstack.extentreports.Status;
import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Random;

import static java.time.Duration.ofSeconds;

public class BaseTest {
    protected static ThreadLocal<AppiumDriver> driver1 = new ThreadLocal<AppiumDriver>();
    protected static ThreadLocal<AppiumDriver> driver2 = new ThreadLocal<AppiumDriver>();
    protected static ThreadLocal<AppiumDriver> driver3 = new ThreadLocal<AppiumDriver>();

    protected static ThreadLocal<String> platform = new ThreadLocal<String>();

    protected static ThreadLocal<String> deviceName = new ThreadLocal<String>();

    protected static ThreadLocal<String> dateTime = new ThreadLocal<String>();

    public static AppiumDriver getDriver1() {
        return driver1.get();
    }

    public static AppiumDriver getDriver2() {
        return driver2.get();
    }

    public static AppiumDriver getDriver3() {
        return driver3.get();
    }

    public void setDriver1(AppiumDriver driver2) {
        driver1.set(driver2);
    }

    public void setDriver2(AppiumDriver driver3) {
        driver2.set(driver3);
    }

    public void setDriver3(AppiumDriver driver4) {
        driver3.set(driver4);
    }

    public String getPlatform() {
        return platform.get();
    }

    public void setPlatform(String platform2) {
        platform.set(platform2);
    }

    public String getDeviceName() {
        return deviceName.get();
    }

    public void setDeviceName(String deviceName2) {
        deviceName.set(deviceName2);
    }


    public String getDateTime() {
        return dateTime.get();
    }

    public void setDateTime(String dateTime2) {
        dateTime.set(dateTime2);
    }

    TestUtils utils = new TestUtils();

    public BaseTest() {
        PageFactory.initElements(new AppiumFieldDecorator(getDriver1()), this);
        PageFactory.initElements(new AppiumFieldDecorator(getDriver2()), this);
    }


    public AndroidDriver<AndroidElement> createAndroidDriver(String deviceName,
                                                             String appPackage,
                                                             String udid,
                                                             String appActivity,
                                                             String appiumHost) throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("deviceName", deviceName);
        dc.setCapability("platformName", "Android");
        dc.setCapability("udid", udid);
        dc.setCapability("appPackage", appPackage);
        dc.setCapability("appActivity", appActivity);
        dc.setCapability("newCommandTimeout", 60 * 15);
        // It will launch Dialer app in android emulator-device.
        return new AndroidDriver<AndroidElement>(new URL(appiumHost), dc);

    }

    @BeforeTest
    public void setUp() throws MalformedURLException {
        AppiumDriver driver1, driver2, driver3;

//         driver1 = createAndroidDriver("emulator-5556",
//                 "com.google.android.dialer",
//                 "extensions.GoogleDialtactsActivity",
//                 "http://127.0.0.1:4723/wd/hub");
        driver1 = createAndroidDriver("Google Pixel 6A",
                "com.dating.for.all",
                "2C161JEGR00633",//
                "com.dating.chat.main.MainActivity",
                "http://127.0.0.1:4723/wd/hub");

//         driver2 = createAndroidDriver("emulator-5554",
//                 "com.android.dialer",
//                 "com.android.dialer.main.impl.MainActivity",
//                 "http://127.0.0.1:4725/wd/hub");
        driver2 = createAndroidDriver("Moto G62 5G",
                "com.dating.for.all",
                "ZD2227CVBC",
                "com.dating.chat.main.MainActivity",
                "http://127.0.0.1:4724/wd/hub");


//         driver1 = createAndroidDriver("emulator-5556",
//                 "com.google.android.dialer",
//                 "extensions.GoogleDialtactsActivity",
//                 "http://127.0.0.1:4723/wd/hub");
//        driver3 = createAndroidDriver("Samsung S20",
//                "com.dating.for.all",
//                "4tyljv4df6tgzxyx",
//                "com.dating.chat.main.MainActivity",
//                "http://127.0.0.1:4725/wd/hub");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        setDriver1(driver1);
        setDriver2(driver2);
//        setDriver3(driver3);
    }

//    @BeforeTest
//    public void setUp1()
//    {
//
//    }

//        @Test
//        public void clickTest() {//com.google.android.dialer:id/icon
//          //  driver1.findElementByXPath("//android.widget.ImageView[@content-desc=\"Dismiss update dialogue\"]").click();
//            WebElement a = getDriver1().findElementById("com.dating.for.all:id/join");
//            waitForVisibility1(a);
//            click1(a,"Cliked on the element");
//            //driver2.findElementById("com.android.dialer:id/main_options_menu_button").click();
//            WebElement b = getDriver2().findElementById("com.dating.for.all:id/join");
//            click2(b,"Cliked on element");
//            try{Thread.sleep(10000);}catch(InterruptedException e){System.out.println(e);}
//
//        }

    @AfterTest
    public void End() {
        getDriver1().quit();
        getDriver2().quit();
    //    getDriver3().quit();
    }

    public boolean waitForClickable(MobileElement e, AppiumDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 200);
        wait.until(ExpectedConditions.elementToBeClickable(e));
        return false;
    }
//    public boolean waitForClickable2(MobileElement e) {
//        WebDriverWait wait = new WebDriverWait(getDriver2(), 240);
//        wait.until(ExpectedConditions.elementToBeClickable(e));
//        return false;
//    }

    public void waitForVisibility(MobileElement e, AppiumDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOf(e));
    }

    public void waitForVisibility1(MobileElement e, AppiumDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 300);
        wait.until(ExpectedConditions.visibilityOf(e));
    }

    public void waitForVisible(MobileElement e, AppiumDriver driver) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(ofSeconds(30))
                .pollingEvery(ofSeconds(1)).ignoring(StaleElementReferenceException.class);
        wait.until(ExpectedConditions.visibilityOf(e));
    }

    public void fluentVisibility(MobileElement e, AppiumDriver driver) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(ofSeconds(30))
                .pollingEvery(ofSeconds(1)).ignoring(StaleElementReferenceException.class)
                .ignoring(IndexOutOfBoundsException.class)
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOf(e));
    }

    public void waitForVisibility(WebElement e, AppiumDriver driver) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(ofSeconds(50))
                .pollingEvery(ofSeconds(5)).ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOf(e));
    }


    public void clear(WebElement e, AppiumDriver driver) {
        MobileElement a = (MobileElement) e;
        waitForVisibility(a, driver);
        a.clear();
    }

    public Action click(WebElement e, AppiumDriver driver) {
        MobileElement a = (MobileElement) e;
        waitForVisibility(a, driver);
        a.click();
        return null;
    }

    public void click(WebElement e, String msg, AppiumDriver driver) {
        MobileElement a = (MobileElement) e;
        waitForVisibility(a, driver);
        ExtentReport.getTest().log(Status.INFO, msg);
        utils.log().info(msg);
        //ExtentReport.getTest().log(Status.INFO, msg);
        a.click();
    }

    public void select(WebElement e, String msg, AppiumDriver driver) {
        MobileElement a = (MobileElement) e;
        waitForVisibility(a, driver);
        ExtentReport.getTest().log(Status.INFO, msg);
        utils.log().info(msg);
        //  ExtentReport.getTest().log(Status.INFO, msg);
        Actions action = new Actions(driver);
        action.moveToElement(a).click().perform();
    }

    public void sendKeys(WebElement e, String txt, AppiumDriver driver) {
        MobileElement a = (MobileElement) e;
        waitForVisibility(a, driver);
        a.sendKeys(txt);
        utils.log().info("Successfully Enter- " + txt);
        ExtentReport.getTest().log(Status.INFO, "Successfully Enter- "+txt);
    }

    public void sendKeys(WebElement e, String txt, String msg, AppiumDriver driver) {
        MobileElement a = (MobileElement) e;
        waitForVisibility(a, driver);
        a.click();
        Actions b = new Actions(driver);
        b.sendKeys(txt + Keys.ENTER);
        b.perform();
        utils.log().info(msg);
        ExtentReport.getTest().log(Status.INFO, msg);

    }

    public String getAttribute(WebElement e, String attribute, AppiumDriver driver) {
        MobileElement a = (MobileElement) e;
        waitForVisibility(a, driver);
        return a.getAttribute(attribute);
    }

    public String getText(WebElement e, String msg, AppiumDriver driver) {
        MobileElement a = (MobileElement) e;
        String txt = null;
        txt = getAttribute(a, "text", driver);
        utils.log().info(msg + txt);
        ExtentReport.getTest().log(Status.INFO, msg + txt);
        return txt;
    }


    public void clickBackButton(AppiumDriver driver) {
        driver.navigate().back();
    }

    public void refreshPage(AppiumDriver driver) {
        driver.navigate().refresh();
    }

    public void closeApp(AppiumDriver driver) {
        ((InteractsWithApps) driver).closeApp();
    }

    public void launchApp(AppiumDriver driver) {
        ((InteractsWithApps) driver).launchApp();
    }

    public MobileElement scrollToElement(MobileElement e, AppiumDriver driver) {
        return (MobileElement) ((FindsByAndroidUIAutomator) driver).findElementByAndroidUIAutomator(
                "new UiScrollable(new UiSelector()" + ".scrollable(true)).scrollIntoView("
                        + "new UiSelector().descriptionContains(\"" + e + "\"))");
    }

    public void scrollIntoElement(String Text, String msg, AppiumDriver driver) {
        ((AndroidDriver<MobileElement>) driver).findElementByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"" + Text + "\").instance(0))").click();
        utils.log().info(msg);
        ExtentReport.getTest().log(Status.INFO, msg);
    }

    /**
     * Performs swipe from the center of screen
     *
     * @param dir the direction of swipe
     * @version java-client: 7.3.0
     **/
    public void swipeScreen(BaseTest.Direction dir, AppiumDriver driver) {
        System.out.println("swipeScreen(): dir: '" + dir + "'"); // always log your actions

        // Animation default time //  - Android: 300 ms //  - iOS: 200 ms
        // final value depends on your app and could be greater
        final int ANIMATION_TIME = 200; // ms

        final int PRESS_TIME = 200; // ms

        int edgeBorder = 10; // better avoid edges
        PointOption pointOptionStart, pointOptionEnd;

        // init screen variables
        Dimension dims = driver.manage().window().getSize();

        // init start point = center of screen
        pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);

        switch (dir) {
            case DOWN: // center of footer
                pointOptionEnd = PointOption.point(dims.width / 2, dims.height - edgeBorder);
                break;
            case UP: // center of header
                pointOptionEnd = PointOption.point(dims.width / 2, edgeBorder);
                break;
            case LEFT: // center of left side
                pointOptionEnd = PointOption.point(edgeBorder, dims.height / 2);
                break;
            case RIGHT: // center of right side
                pointOptionEnd = PointOption.point(dims.width - edgeBorder, dims.height / 2);
                break;
            default:
                throw new IllegalArgumentException("swipeScreen(): dir: '" + dir + "' NOT supported");
        }

        // execute swipe using TouchAction
        try {
            new TouchAction(driver)
                    .press(pointOptionStart)
                    // a bit more reliable when we add small wait
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
                    .moveTo(pointOptionEnd)
                    .release().perform();
        } catch (Exception e) {
            System.err.println("swipeScreen(): TouchAction FAILED\n" + e.getMessage());
            return;
        }

        // always allow swipe action to complete
        try {
            Thread.sleep(ANIMATION_TIME);
        } catch (InterruptedException e) {
            // ignore
        }
    }

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT;
    }

    /**
     * Performs swipe inside an element
     *
     * @param el  the element to swipe
     * @param dir the direction of swipe
     * @version java-client: 7.3.0
     **/
    public void swipeElementAndroid(MobileElement el, BaseTest.Direction dir, String msg, AndroidDriver driver) {
        System.out.println("swipeElementAndroid(): dir: '" + dir + "'"); // always log your actions

        // Animation default time:
        //  - Android: 300 ms
        //  - iOS: 200 ms
        // final value depends on your app and could be greater
        final int ANIMATION_TIME = 200; // ms

        final int PRESS_TIME = 200; // ms

        int edgeBorder;
        PointOption pointOptionStart, pointOptionEnd;

        // init screen variables
        Rectangle rect = el.getRect();
        // sometimes it is needed to configure edgeBorders
        // you can also improve borders to have vertical/horizontal
        // or left/right/up/down border variables
        edgeBorder = 0;

        switch (dir) {
            case DOWN: // from up to down
                pointOptionStart = PointOption.point(rect.x + rect.width / 2,
                        rect.y + edgeBorder);
                pointOptionEnd = PointOption.point(rect.x + rect.width / 2,
                        rect.y + rect.height - edgeBorder);
                break;
            case UP: // from down to up
                pointOptionStart = PointOption.point(rect.x + rect.width / 2,
                        rect.y + rect.height - edgeBorder);
                pointOptionEnd = PointOption.point(rect.x + rect.width / 2,
                        rect.y + edgeBorder);
                break;
            case LEFT: // from right to left
                pointOptionStart = PointOption.point(rect.x + rect.width - edgeBorder,
                        rect.y + rect.height / 2);
                pointOptionEnd = PointOption.point(rect.x + edgeBorder,
                        rect.y + rect.height / 2);
                break;
            case RIGHT: // from left to right
                pointOptionStart = PointOption.point(rect.x + edgeBorder,
                        rect.y + rect.height / 2);
                pointOptionEnd = PointOption.point(rect.x + rect.width - edgeBorder,
                        rect.y + rect.height / 2);
                break;
            default:
                throw new IllegalArgumentException("swipeElementAndroid(): dir: '" + dir + "' NOT supported");
        }

        // execute swipe using TouchAction
        try {
            new TouchAction(driver)
                    .press(pointOptionStart)
                    // a bit more reliable when we add small wait
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
                    .moveTo(pointOptionEnd)
                    .release().perform();
        } catch (Exception e) {
            System.err.println("swipeElementAndroid(): TouchAction FAILED\n" + e.getMessage());
            return;
        }

        // always allow swipe action to complete
        try {
            Thread.sleep(ANIMATION_TIME);
        } catch (InterruptedException e) {
            // ignore
        }
        utils.log().info(msg);
        ExtentReport.getTest().log(Status.INFO, msg);
    }

    /**
     * Performs small swipe from the center of screen
     *
     * @param dir the direction of swipe
     * @version java-client: 7.3.0
     **/
    public void swipeScreenSmall(BaseTest.Direction dir, AppiumDriver driver) {
        System.out.println("swipeScreenSmall(): dir: '" + dir + "'"); // always log your actions

        // Animation default time:
        //  - Android: 300 ms
        //  - iOS: 200 ms
        // final value depends on your app and could be greater
        final int ANIMATION_TIME = 200; // ms

        final int PRESS_TIME = 200; // ms

        PointOption pointOptionStart, pointOptionEnd;

        // init screen variables
        Dimension dims = driver.manage().window().getSize();

        // init start point = center of screen
        pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);

        // reduce swipe move into multiplier times comparing to swipeScreen move
        int mult = 10; // multiplier
        switch (dir) {
            case DOWN: // center of footer
                pointOptionEnd = PointOption.point(dims.width / 2, (dims.height / 2) + (dims.height / 2) / mult);
                break;
            case UP: // center of header
                pointOptionEnd = PointOption.point(dims.width / 2, (dims.height / 2) - (dims.height / 2) / mult);
                break;
            case LEFT: // center of left side
                pointOptionEnd = PointOption.point((dims.width / 2) - (dims.width / 2) / mult, dims.height / 2);
                break;
            case RIGHT: // center of right side
                pointOptionEnd = PointOption.point((dims.width / 2) + (dims.width / 2) / mult, dims.height / 2);
                break;
            default:
                throw new IllegalArgumentException("swipeScreenSmall(): dir: '" + dir.toString() + "' NOT supported");
        }

        // execute swipe using TouchAction
        try {
            new TouchAction(driver)
                    .press(pointOptionStart)
                    // a bit more reliable when we add small wait
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
                    .moveTo(pointOptionEnd)
                    .release().perform();
        } catch (Exception e) {
            System.err.println("swipeScreenSmall(): TouchAction FAILED\n" + e.getMessage());
            return;
        }

        // always allow swipe action to complete
        try {
            Thread.sleep(ANIMATION_TIME);
        } catch (InterruptedException e) {
            // ignore
        }
    }

    public int getRandomNum() {
        Random randomNum = new Random();
        return randomNum.nextInt(10000 - 1000) + 1000;
    }

    @AfterTest(alwaysRun = true)
    public void afterTest() {
        if (getDriver1() != null) {
            getDriver1().quit();
        }
    }

    @AfterTest(alwaysRun = true)
    public void afterTest2() {
        if (getDriver2() != null) {
            getDriver2().quit();
        }
    }

//    @AfterTest(alwaysRun = true)
//    public void afterTest3() {
//        if (getDriver3() != null) {
//            getDriver3().quit();
//        }
//    }


}
