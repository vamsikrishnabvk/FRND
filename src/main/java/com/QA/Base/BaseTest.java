package com.QA.Base;


import com.QA.reports.ExtentReport;
import com.QA.utlis.TestUtils;
import com.aventstack.extentreports.Status;
import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.screenrecording.CanRecordScreen;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.logging.log4j.ThreadContext;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;
import java.util.Random;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofMillis;
import static java.time.Duration.ofSeconds;

public class BaseTest {
	protected static ThreadLocal<AppiumDriver> driver = new ThreadLocal<AppiumDriver>();
	protected static ThreadLocal<Properties> props = new ThreadLocal<Properties>();
	protected static ThreadLocal<HashMap<String, String>> strings = new ThreadLocal<HashMap<String, String>>();
	protected static ThreadLocal<String> platform = new ThreadLocal<String>();
	protected static ThreadLocal<String> dateTime = new ThreadLocal<String>();
	protected static ThreadLocal<String> deviceName = new ThreadLocal<String>();
	private static AppiumDriverLocalService server;
	TestUtils utils = new TestUtils();

	public static AppiumDriver getDriver() {
		return driver.get();
	}
	public void setDriver(AppiumDriver driver2) {
		driver.set(driver2);
	}

	public Properties getProps() {
		return props.get();
	}

	public void setProps(Properties props2) {
		props.set(props2);
	}

	public HashMap<String, String> getStrings() {
		return strings.get();
	}

	public void setStrings(HashMap<String, String> strings2) {
		strings.set(strings2);
	}

	public String getPlatform() {
		return platform.get();
	}

	public void setPlatform(String platform2) {
		platform.set(platform2);
	}

	public String getDateTime() {
		return dateTime.get();
	}

	public void setDateTime(String dateTime2) {
		dateTime.set(dateTime2);
	}

	public String getDeviceName() {
		return deviceName.get();
	}

	public void setDeviceName(String deviceName2) {
		deviceName.set(deviceName2);
	}

	public BaseTest() {

		 //PageFactory.initElements(getDriver(), this);

		PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);

	int a =0;
	}

//	@BeforeMethod
	public void beforeMethod() {
		((CanRecordScreen) getDriver()).startRecordingScreen();
	}

	// stop video capturing and create *.mp4 file
//	@AfterMethod
//	public synchronized void afterMethod(ITestResult result) throws Exception {
//		String media = ((CanRecordScreen) getDriver()).stopRecordingScreen();
//
//		Map<String, String> params = result.getTestContext().getCurrentXmlTest().getAllParameters();
//		String dirPath = "videos" + File.separator + params.get("platformName") + "_" + params.get("deviceName")
//				+ File.separator + getDateTime() + File.separator
//				+ result.getTestClass().getRealClass().getSimpleName();
//
//		File videoDir = new File(dirPath);
//
//		synchronized (videoDir) {
//			if (!videoDir.exists()) {
//				videoDir.mkdirs();
//			}
//		}
//		FileOutputStream stream = null;
//		try {
//			stream = new FileOutputStream(videoDir + File.separator + result.getName() + ".mp4");
//			stream.write(Base64.decodeBase64(media));
//			stream.close();
//			utils.log().info("video path: " + videoDir + File.separator + result.getName() + ".mp4");
//		} catch (Exception e) {
//			utils.log().error("error during video capture" + e.toString());
//		} finally {
//			if (stream != null) {
//				stream.close();
//			}
//		}
//	}

	@BeforeSuite
	public void beforeSuite() throws Exception, Exception {
		ThreadContext.put("ROUTINGKEY", "ServerLogs");
	//	server = getAppiumService(); // -> If using Mac, uncomment this statement and comment below statement
     	server = getAppiumServerDefault();
		 // -> If using Windows, uncomment this statement and comment above statement
		if (!checkIfAppiumServerIsRunnning(4723) || !checkIfAppiumServerIsRunnning(4724))
		{
			server.start();
			server.clearOutPutStreams(); // -> Comment this if you don't want to see server logs in the console
			utils.log().info("Appium server started");
		} else {
			utils.log().info("Appium server already running");
		}
	}

	public boolean checkIfAppiumServerIsRunnning(int port) throws Exception {
		boolean isAppiumServerRunning = false;
		ServerSocket socket;
		try {
			socket = new ServerSocket(port);
			socket.close();
		} catch (IOException e) {
			// System.out.println("1");
			isAppiumServerRunning = true;
		} finally {
			socket = null;
		}
		return isAppiumServerRunning;
	}

	@AfterSuite(alwaysRun = true)
	public void afterSuite() {
		if (server.isRunning()) {
			server.stop();
			utils.log().info("Appium server stopped");
		}
	}

	// for Windows
	public AppiumDriverLocalService getAppiumServerDefault() {
		return AppiumDriverLocalService.buildDefaultService();
	}

	// for Mac. Update the paths as per your Mac setup
	public AppiumDriverLocalService getAppiumService() {
		HashMap<String, String> environment = new HashMap<String, String>();
		environment.put("PATH",
				"/Library/Internet Plug-Ins/JavaAppletPlugin.plugin/Contents/Home/bin:/Users/Library/Android/sdk/tools:/Users/Library/Android/sdk/platform-tools:/usr/local/bin:/usr/bin:/bin:/usr/sbin:/sbin:/Library/Apple/usr/bin"
						+ System.getenv("PATH"));
		environment.put("ANDROID_HOME", "/Users/Library/Android/sdk");
		return AppiumDriverLocalService
				.buildService(new AppiumServiceBuilder().usingDriverExecutable(new File("/usr/local/bin/node"))
						.withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js")).usingPort(4723)
						.withArgument(GeneralServerFlag.SESSION_OVERRIDE)
//				.withArgument(() -> "--allow-insecure","chromedriver_autodownload")
						.withEnvironment(environment).withLogFile(new File("ServerLogs/server.log")));
	}

	@Parameters({ "emulator", "platformName", "udid", "deviceName", "systemPort", "chromeDriverPort", "wdaLocalPort",
			"webkitDebugProxyPort" })
	@BeforeTest
	public void beforeTest(@Optional("androidOnly") String emulator, String platformName, String udid,
			String deviceName, @Optional("androidOnly") String systemPort,
			@Optional("androidOnly") String chromeDriverPort, @Optional("iOSOnly") String wdaLocalPort,
			@Optional("iOSOnly") String webkitDebugProxyPort) throws Exception {
		setDateTime(utils.dateTime());
		setPlatform(platformName);
		setDeviceName(deviceName);
		URL url1,url2;
		InputStream inputStream = null;
		InputStream stringsis = null;
		Properties props = new Properties();
		AppiumDriver driver;

		String strFile = "logs" + File.separator + platformName + "_" + deviceName;
		File logFile = new File(strFile);
		if (!logFile.exists()) {
			logFile.mkdirs();
		}
		// route logs to separate file for each thread
		ThreadContext.put("ROUTINGKEY", strFile);
		utils.log().info("log path: " + strFile);

		try {
			props = new Properties();
			String propFileName = "config.properties";
			String xmlFileName = "strings/strings.xml";

			utils.log().info("load " + propFileName);
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
			props.load(inputStream);
			setProps(props);

			utils.log().info("load " + xmlFileName);
			stringsis = getClass().getClassLoader().getResourceAsStream(xmlFileName);
			setStrings(utils.parseStringXML(stringsis));

			DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
			desiredCapabilities.setCapability("platformName", platformName);
			desiredCapabilities.setCapability("deviceName", deviceName);
			desiredCapabilities.setCapability("udid", udid);

			url1 = new URL(props.getProperty("device1appiumURL"));
			url2 = new URL(props.getProperty("device2appiumURL"));

			switch (deviceName) {
			case "device1":
				desiredCapabilities.setCapability("automationName", props.getProperty("androidAutomationName"));
				desiredCapabilities.setCapability("appPackage", props.getProperty("androidAppPackage"));
				desiredCapabilities.setCapability("appActivity", props.getProperty("androidAppActivity"));
				desiredCapabilities.setCapability("autoGrantPermissions", true);
				desiredCapabilities.setCapability("noReset", false);
			//	desiredCapabilities.setCapability("newCommandTimeout", 60 * 35);
				desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 700);
				if (emulator.equalsIgnoreCase("true")) {
					desiredCapabilities.setCapability("avd", deviceName);
				//	desiredCapabilities.setCapability("avdLaunchTimeout", 120000);
				}
				desiredCapabilities.setCapability("systemPort", systemPort);
				desiredCapabilities.setCapability("chromeDriverPort", chromeDriverPort);
				String androidAppUrl1 = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
						+ File.separator + "resources" + File.separator + "app" + File.separator
						+ "frnd-development-v448_2.135_.apk";
				// String androidAppUrl =
				// getClass().getResource(props.getProperty("androidAppLocation")).getFile();
				utils.log().info("appUrl is" + androidAppUrl1);
				desiredCapabilities.setCapability("app", androidAppUrl1);

				driver = new AndroidDriver(url1, desiredCapabilities);
				break;
				case "device2":
				desiredCapabilities.setCapability("automationName", props.getProperty("androidAutomationName"));
				desiredCapabilities.setCapability("appPackage", props.getProperty("androidAppPackage"));
				desiredCapabilities.setCapability("appActivity", props.getProperty("androidAppActivity"));
				desiredCapabilities.setCapability("autoGrantPermissions", true);
				desiredCapabilities.setCapability("noReset", false);
				//desiredCapabilities.setCapability("newCommandTimeout", 60 * 35);
					desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 700);
				if (emulator.equalsIgnoreCase("true")) {
					desiredCapabilities.setCapability("avd", deviceName);
				//	desiredCapabilities.setCapability("avdLaunchTimeout", 120000);
				}
				desiredCapabilities.setCapability("systemPort", systemPort);
				desiredCapabilities.setCapability("chromeDriverPort", chromeDriverPort);
				String androidAppUrl2 = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
						+ File.separator + "resources" + File.separator + "app" + File.separator
						+ "frnd-development-v448_2.135_.apk";
				// String androidAppUrl =
				// getClass().getResource(props.getProperty("androidAppLocation")).getFile();
				utils.log().info("appUrl is" + androidAppUrl2);
				desiredCapabilities.setCapability("app", androidAppUrl2);

				driver = new AndroidDriver(url2, desiredCapabilities);
				break;
//			case "iOS":
//				desiredCapabilities.setCapability("automationName", props.getProperty("iOSAutomationName"));
//				String iOSAppUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
//						+ File.separator + "resources" + File.separator + "app" + File.separator
//						+ "3fab7ffd-2c92-4d05-b47d-9cbaacfd4518.apk";
//				// String iOSAppUrl =
//				// getClass().getResource(props.getProperty("iOSAppLocation")).getFile();
//				utils.log().info("appUrl is" + iOSAppUrl);
//				desiredCapabilities.setCapability("bundleId", props.getProperty("iOSBundleId"));
//				desiredCapabilities.setCapability("wdaLocalPort", wdaLocalPort);
//				desiredCapabilities.setCapability("webkitDebugProxyPort", webkitDebugProxyPort);
//				desiredCapabilities.setCapability("app", iOSAppUrl);
//
//				driver = new IOSDriver(url1, desiredCapabilities);
//				break;
			default:
				throw new Exception("Invalid platform! - " + platformName);
			}
			setDriver(driver);
			utils.log().info("driver initialized: " + driver);
		} catch (Exception e) {
			utils.log().fatal("driver initialization failure. ABORT!!!\n" + e.toString());
			throw e;
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
			if (stringsis != null) {
				stringsis.close();
			}
		}
	}

	public boolean waitForClickable(MobileElement e) {
		WebDriverWait wait = new WebDriverWait(getDriver(), TestUtils.WAIT);
		wait.until(ExpectedConditions.elementToBeClickable(e));
		return false;
	}

	public void waitForVisibility(MobileElement e) {
		WebDriverWait wait = new WebDriverWait(getDriver(), TestUtils.WAIT);
		wait.until(ExpectedConditions.visibilityOf(e));
	}

	public void waitForVisibility(WebElement e) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver()).withTimeout(ofSeconds(40))
				.pollingEvery(ofSeconds(5)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOf(e));
	}

	public void clear(MobileElement e) {
		waitForVisibility(e);
		e.clear();
	}

	public void click(MobileElement e) {
		waitForVisibility(e);
		e.click();
	}

	public void click(MobileElement e, String msg) {
		waitForVisibility(e);
		utils.log().info(msg);
		ExtentReport.getTest().log(Status.INFO, msg);
		e.click();
	}

	
	public String getBackgroundcolor(MobileElement e) {
		waitForVisibility(e);
		String color = e.getCssValue("background-color");
		utils.log().info("Background color- "+color);
		ExtentReport.getTest().log(Status.INFO, "Background color- "+color);
	    return color;
	}
	

	
	
	
	public void select(MobileElement element, String msg) {
		waitForVisibility(element);
		utils.log().info(msg);
		ExtentReport.getTest().log(Status.INFO, msg);
		Actions action = new Actions(getDriver());
		action.moveToElement(element).click().perform();
	}

	public void sendKeys(MobileElement e, String txt) {
		waitForVisibility(e);
		e.sendKeys(txt);
		utils.log().info("Successfully Enter- "+txt);
		ExtentReport.getTest().log(Status.INFO, "Successfully Enter- "+txt);
	}

	public void sendKeys(MobileElement e, String txt, String msg) {
		waitForVisibility(e);
		e.click();
		Actions a = new Actions(getDriver());
        a.sendKeys(txt+Keys.ENTER);
        a.perform();
		utils.log().info(msg);
		ExtentReport.getTest().log(Status.INFO, msg);
		
	}
	
	public void isDisplayed(MobileElement e, String msg) {
		waitForVisibility(e);
		utils.log().info(msg);
		ExtentReport.getTest().log(Status.INFO, msg);

	}

	public boolean isElementDisplayed(MobileElement element){
		try{
			return element.isDisplayed();

		}catch(Exception e){
			//System.out.println(e);
			return false;
		}
	}


	public String getAttribute(MobileElement e, String attribute) {
		waitForVisibility(e);
		return e.getAttribute(attribute);
	}

	public String getText(MobileElement e, String msg) {
		String txt = null;
		switch (getPlatform()) {
		case "Android":
			txt = getAttribute(e, "text");
			break;
		case "iOS":
			txt = getAttribute(e, "label");
			break;
		}
		utils.log().info(msg + txt);
		ExtentReport.getTest().log(Status.INFO, msg + txt);
		return txt;
	}
	public void clickBackButton()
	{
		getDriver().navigate().back();
	}

	public void refreshPage()
	{
		getDriver().navigate().refresh();
	}

	public void closeApp() {
		((InteractsWithApps) getDriver()).closeApp();
	}

	public void launchApp() {
		((InteractsWithApps) getDriver()).launchApp();
	}

	/**
	 * Performs swipe from the center of screen
	 *
	 * @param dir the direction of swipe
	 * @version java-client: 7.3.0
	 **/
	public void swipeScreen(Direction dir) {
		System.out.println("swipeScreen(): dir: '" + dir + "'"); // always log your actions

		// Animation default time //  - Android: 300 ms //  - iOS: 200 ms
		// final value depends on your app and could be greater
		final int ANIMATION_TIME = 200; // ms

		final int PRESS_TIME = 200; // ms

		int edgeBorder = 10; // better avoid edges
		PointOption pointOptionStart, pointOptionEnd;

		// init screen variables
		Dimension dims = getDriver().manage().window().getSize();

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
			new TouchAction(getDriver())
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
	public void swipeElementAndroid(MobileElement el, Direction dir, String msg) {
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
			new TouchAction(getDriver())
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
	public void swipeScreenSmall(Direction dir) {
		System.out.println("swipeScreenSmall(): dir: '" + dir + "'"); // always log your actions

		// Animation default time:
		//  - Android: 300 ms
		//  - iOS: 200 ms
		// final value depends on your app and could be greater
		final int ANIMATION_TIME = 200; // ms

		final int PRESS_TIME = 200; // ms

		PointOption pointOptionStart, pointOptionEnd;

		// init screen variables
		Dimension dims = getDriver().manage().window().getSize();

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
			new TouchAction(getDriver())
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

	public void fluentWaitForElementToBePresent(MobileElement element, long timeoutMillis, int polling) {
		FluentWait<AppiumDriver> wait = new FluentWait<>(getDriver())
				.withTimeout(Duration.ofMillis(timeoutMillis))
				.pollingEvery(Duration.ofMillis(polling))
				.ignoring(NoSuchElementException.class)
				.ignoring(IndexOutOfBoundsException.class)
				.ignoring(TimeoutException.class);
		try {
			wait.until(ExpectedConditions.visibilityOf(element));}
            catch (TimeoutException ignore) {
			}
		}

	public MobileElement scrollToElement(MobileElement e) {
		return (MobileElement) ((FindsByAndroidUIAutomator) getDriver()).findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()" + ".scrollable(true)).scrollIntoView("
						+ "new UiSelector().descriptionContains(\"" + e + "\"))");
	}

	public void scrollIntoView(String Text){
		((AndroidDriver<MobileElement>) getDriver()).findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"" + Text + "\").instance(0))");
	}

	public void scrollIntoElement(String Text, String msg){
		((AndroidDriver<MobileElement>) getDriver()).findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"" + Text + "\").instance(0))").click();
		utils.log().info(msg);
		ExtentReport.getTest().log(Status.INFO, msg);
	}

	public void tapByElement (MobileElement androidElement) {
		new TouchAction(getDriver())
				.tap(tapOptions().withElement(element(androidElement)))
				.waitAction(waitOptions(ofMillis(80))).perform();
	}

	public void pressByElement (MobileElement mobileElement, long seconds) {
		new TouchAction(getDriver())
				.press(element(mobileElement))
				.waitAction(waitOptions(ofSeconds(seconds)))
				.release()
				.perform();
	}


	public void waitFor(MobileElement element){
		WebDriverWait wait = new WebDriverWait(getDriver(), (80));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitFor(MobileElement element, long milliSeconds){
		WebDriverWait wait = new WebDriverWait(getDriver(), (milliSeconds));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public String getRandomUserName() {
		String randomUserName = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 10) { // length of the random string.
			int index = (int) (rnd.nextFloat() * randomUserName.length());
			salt.append(randomUserName.charAt(index));
		}
		String saltStr = salt.toString();
		return saltStr;  // Call it as getRandomUserName()+"@domain.com"
	}

	public String getRandomPassword() {
		String randomPassword = "AbcDeF@#12345";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 9) { // length of the random string.
			int index = (int) (rnd.nextFloat() * randomPassword.length());
			salt.append(randomPassword.charAt(index));
		}
		String saltStr = salt.toString();
		return saltStr;  // Call it as getRandomPassword()"
	}

	public void iOSScrollToElement() {
		RemoteWebElement element = (RemoteWebElement) getDriver().findElement(By.name("test-ADD TO CART"));
		String elementID = element.getId();
		HashMap<String, String> scrollObject = new HashMap<String, String>();
		scrollObject.put("element", elementID);
//	  scrollObject.put("direction", "down");
//	  scrollObject.put("predicateString", "label == 'ADD TO CART'");
//	  scrollObject.put("name", "test-ADD TO CART");
		scrollObject.put("toVisible", "sdfnjksdnfkld");
		getDriver().executeScript("mobile:scroll", scrollObject);
	}

	@AfterTest(alwaysRun = true)
	public void afterTest() {
		if (getDriver() != null) {
			getDriver().quit();
		}
	}
}
