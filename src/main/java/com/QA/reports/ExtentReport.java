package com.QA.reports;

import java.io.*;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import com.QA.Base.BaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.io.Zip;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


public class ExtentReport extends BaseTest {
	/**
	 * These methods are used to generate Extent report
	 */
	static ExtentReports extent;
	static ExtentSparkReporter extentSparkReporter;
	public String environment;
	static final String filePath = "Extent.html";
	@SuppressWarnings({"unchecked", "rawtypes"})
	static Map<Integer, ExtentTest> extentTestMap = new HashMap();
@BeforeSuite
	public synchronized static ExtentReports getReporter() throws IOException {


		Properties prop = new Properties();
		File files = new File(System.getProperty("user.dir") + "/src/main/resources/config.properties");
//		FileInputStream fis = new FileInputStream(files);
//		prop.load(fis);
		try {
			if (extent == null) {
				String filepath = "./TestReport";
				File file = new File(filepath);
				deleteScreenshotsFolder(file);
				file.delete();

				extent = new ExtentReports();
				ExtentSparkReporter html = new ExtentSparkReporter("Extent.html");
				extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "./TestReport/screenshots/Frnd_AppAutomation_ExecutionReport.html");
//				extent.setSystemInfo("System Name: ", InetAddress.getLocalHost().getHostName());
				html.config().setDocumentTitle("Appium Framework");
				html.config().setReportName("FRND Testing");
				html.config().setTheme(Theme.DARK);
				extent = new ExtentReports();
				extent.attachReporter(html);
				extent.setSystemInfo("Android App package Name", prop.getProperty("androidAppPackage"));
				extent.setSystemInfo("Android App activity Name", prop.getProperty("androidAppActivity"));
				extent.setSystemInfo("Android OS", prop.getProperty("androidOS"));
				extent.setSystemInfo("Operating System: ", System.getProperty("os.name"));
				extent.setSystemInfo("Java Version: ", System.getProperty("java.version"));


			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return extent;
	}


	@AfterSuite()
	public void afterSuite() {
//		if (environment.contains("pulse-uae")) {
//			extent.setSystemInfo("UAE Test Environment: ", prop.getProperty("UAE_Test_Environment_Url"));
//			environment = "test_uae";
//		} else if (url.contains("pulse-dev")) {
//			extentReports.setSystemInfo("Dev Environment", prop.getProperty("Dev_Environment_Url"));
//			env = "dev";
//		} else if (url.contains("pulse-it")) {
//			extentReports.setSystemInfo("Italy Test Environment", prop.getProperty("Italy_Test_Environment_Url"));
//			env = "Italy-test";
//		} else if (url.contains("pulse-leb")) {
//			extentReports.setSystemInfo("Lebanon Test Environment", prop.getProperty("Lebanon_Test_Environment_Url"));
//			env = "Lebanon-test";
//		} else if (url.contains("pulse-egp")) {
//			extentReports.setSystemInfo("Egypt Test Environment", prop.getProperty("Egypt_Test_Environment_Url"));
//			env = "Egypt-test";
//		}else if (url.contains("pulse-ksa")) {
//			extentReports.setSystemInfo("KSA Test Environment", prop.getProperty("KSA_Test_Environment_Url"));
//			env = "KSA-test";
//		}

		extentSparkReporter.config().setReportName("Frnd Automation Report = "+environment);

//	Capabilities browserCap = getDriver().getCapabilities();
//		String browserName = browserCap.getBrowserName();
//		String browserVersion = browserCap.getBrowserVersion();
//		extentReports.setSystemInfo("Browser Name and Version", browserName +" - "+ browserVersion);
//		extent.setSystemInfo("Browser Resolution",screenSize);

//        videoRecording.stopRecording();
//		extent.flush();

	// Open the hmtl
	// Find all and replace ../TestReport/screenshots to ../screenshots
	File textFile = new File("./TestReport/screenshots/Frnd_AppAutomation_ExecutionReport.html");
		try

	{
		String data = FileUtils.readFileToString(textFile);
		data = data.replace("..\\TestReport\\screenshots\\", "..\\screenshots\\");
		FileUtils.writeStringToFile(textFile, data);
	} catch(
	IOException e)

	{
		e.printStackTrace();
	}
	//Create zip report folder
		try

	{
		String zip = Zip.zip(new File("./TestReport"));
		BufferedOutputStream s = new BufferedOutputStream(new FileOutputStream("./TestReportZip/TestReports.zip"), 10000);
		byte[] b = Base64.getDecoder().decode(zip);
		s.write(b);
		s.close();
	} catch(
	IOException e)

	{
		e.printStackTrace();
	}
}

	public static void deleteScreenshotsFolder(File file) {
		try {
			for (File subfile : file.listFiles()) {

				if (subfile.isDirectory()) {
					deleteScreenshotsFolder(subfile);
				}
				subfile.delete();
			}
		} catch (Exception e) {

		}
	}
	public static synchronized ExtentTest getTest() {
		return extentTestMap.get((int) (Thread.currentThread().getId()));
	}

	public static synchronized ExtentTest startTest(String testName, String desc) throws IOException {
		ExtentTest test = ExtentReport.getReporter().createTest(testName, desc);
		extentTestMap.put((int) (Thread.currentThread().getId()), test);
		return test;
	}



}


//
//	public static synchronized ExtentReports getReporter() throws IOException {
//		Properties prop = new Properties();
//		File file = new File(System.getProperty("user.dir") + "/src/main/resources/config.properties");
//		FileInputStream fis = new FileInputStream(file);
//		prop.load(fis);
//
//		if (extent == null) {
//			ExtentSparkReporter html = new ExtentSparkReporter("Extent.html");
//			html.config().setDocumentTitle("Appium Framework");
//			html.config().setReportName("MyNextCare Testing Factory");
//			html.config().setTheme(Theme.DARK);
//			extent = new ExtentReports();
//			extent.attachReporter(html);
//			extent.setSystemInfo("Android App package Name", prop.getProperty("androidAppPackage"));
//			extent.setSystemInfo("Android App activity Name", prop.getProperty("androidAppActivity"));
//			extent.setSystemInfo("Android OS", prop.getProperty("androidOS"));
//			extent.setSystemInfo("Operating System: ", System.getProperty("os.name"));
//			extent.setSystemInfo("Java Version: ", System.getProperty("java.version"));
//		}
//
//		return extent;
//	}
//






