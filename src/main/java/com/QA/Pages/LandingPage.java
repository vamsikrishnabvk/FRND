package com.QA.Pages;

import com.QA.Base.BaseTest;
import com.QA.reports.ExtentReport;
import com.QA.utlis.TestUtils;
import com.aventstack.extentreports.Status;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LandingPage extends BaseTest {

    public LandingPage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    TestUtils utils = new TestUtils();
    //*************** Keep Elements Here ******************************************
    @AndroidFindBy(id = "com.dating.for.all:id/join")
    private MobileElement letsGoButton;
    @AndroidFindBy(id = "com.dating.for.all:id/numberEt")
    private MobileElement mobileNumberTextBox;

    @AndroidFindBy(id = "android:id/text1")
    private MobileElement autoSuggestedNum;
    @AndroidFindBy(id = "com.dating.for.all:id/getOtp")
    private MobileElement getOTPButton;
    @AndroidFindBy(id = "com.dating.for.all:id/otpEt")
    private MobileElement otpTextBox;
    @AndroidFindBy(id = "com.dating.for.all:id/submitBtv")
    private MobileElement submitButton;

    @AndroidFindBy(id = "com.dating.for.all:id/genderCl")
    private MobileElement selectGenderButton;

    @AndroidFindBy(id = "com.dating.for.all:id/boySelectBgCv")
    private MobileElement boyGender;

    @AndroidFindBy(id = "com.dating.for.all:id/girlSelectBgCv")
    private MobileElement girlGender;

    @AndroidFindBy(id = "com.dating.for.all:id/recordBt")
    private MobileElement voiceRecordButton;

    @AndroidFindBy(id = "com.dating.for.all:id/ageEt")
    private MobileElement dateOfBirthButton;

    @AndroidFindBy(id = "android:id/button1")
    private MobileElement okButton;

    @AndroidFindBy(id = "com.dating.for.all:id/nextUpdateProfileBt")
    private MobileElement submitButtonSignIn;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"com.dating.for.all:id/nameEt\"]")
    private MobileElement nickNameField;

    @AndroidFindBy(xpath = "(//android.widget.FrameLayout[@resource-id=\"com.dating.for.all:id/imageFl\"])[1]")
    private MobileElement hindiLanguage;

    @AndroidFindBy(id = "com.dating.for.all:id/updatePrimaryBt")
    private MobileElement saveButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.dating.for.all:id/debug_menu_title\" and @text=\"Select server\"]")
    private MobileElement selectServerButton;

    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"android:id/button1\"]")
    private MobileElement serverOkButton;

    @AndroidFindBy(id = "Dismiss update dialogue")
    private static MobileElement updateCrossButton;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    private List<MobileElement> notificationAllowPopup;

    @AndroidFindBy(id = "com.dating.for.all:id/customactivityoncrash_error_activity_restart_button")
    private MobileElement restartButton;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"8088\"]")
    private MobileElement devServer8088;

    @AndroidFindBy(id = "com.dating.for.all:id/confirm")
    private MobileElement cyberCrimeCheckBox;

    @AndroidFindBy(id = "com.dating.for.all:id/submit")
    private MobileElement cyberCrimeSubmitButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.dating.for.all:id/language\" and @text=\"English\"]")
    private MobileElement appLanguage;

    @AndroidFindBy(id = "com.dating.for.all:id/confirm")
    private MobileElement appLanguageConfirmButton;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    private MobileElement allowLocationPopup;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    private MobileElement audioRecordPopup;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"android:id/text1\"]")
    private List<MobileElement> devServer;

    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"android:id/aerr_close\"]")
    private MobileElement closeAppCrossButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Private Training Rooms\"]")
    private MobileElement privateTrainingRooms;


//*********************** End Elements *************************************************

//   public void verifySignIn()
//   {
//	   isDisplayed(signInButton, "checking Sign In button");
//   }
    //public void clickSignIn()
//   {
//	   click(signInButton,"click on Sign In button");
//   }

    public void clickOnActionBarRoot(AppiumDriver driver)
    {
        try {
            click(privateTrainingRooms, driver);
        }catch (Exception e)
        {

        }
    }

    public void handlingUpdatePopup(AppiumDriver driver) throws InterruptedException {
        Thread.sleep(2000);
        //System.out.println(updateCrossButton.size());
        try {
            if (updateCrossButton.isDisplayed()) {
                click(updateCrossButton,driver);
            }
        } catch (Exception e) {

        }
        Thread.sleep(1000);
        try {
            if (closeAppCrossButton.isDisplayed()) {
                click(closeAppCrossButton, "Clicked on Restart Button", driver);
            }
        } catch (Exception e) {

        }

        Thread.sleep(2000);
        try {
            if (restartButton.isDisplayed()) {
                click(restartButton, "Clicked on Restart Button", driver);
            }
        } catch (Exception e) {

        }
        Thread.sleep(3000);
    }

    public static final void KEYCODE_VOLUME_DOWN(AppiumDriver driver) throws InterruptedException {
        Thread.sleep(2000);
        AndroidDriver driver1 = (AndroidDriver) driver;
        //driver.pressKey(new KeyEvent(AndroidKey.VOLUME_DOWN));
        driver1.longPressKey(new KeyEvent(AndroidKey.VOLUME_DOWN));
    }

    public void changingPort(String portNumber, AppiumDriver driver) throws InterruptedException {
        click(selectServerButton, "Select server Button", driver);
        for (int i = 0; i < devServer.size(); i++) {
            String actualPort = getText(devServer.get(i), "Getting Port number", driver);
            System.out.println(i + ":" + actualPort);
            if (actualPort.equals(portNumber)) {
                click(devServer.get(i), "Select dev server", driver);
                ExtentReport.getTest().log(Status.INFO, "Clicked on Dev Server");
                click(serverOkButton, "Clicked on Ok button", driver);
                ExtentReport.getTest().log(Status.INFO, "Clicked on Ok Button");
                break;
            }
        }
    }

    public void clickOnLetsGoButton(AppiumDriver driver) {
        click(letsGoButton, "Click on LetsGoButton", driver);
        ExtentReport.getTest().log(Status.INFO, "Clicked on LetsGo Button");
    }

    public void enterMobileNumber(String phoneNumber, AppiumDriver driver) {
        sendKeys(mobileNumberTextBox, phoneNumber, driver);
        ExtentReport.getTest().log(Status.INFO, "Entered Phone NUmber");
    }

    public void clickOnGetOTPButton(AppiumDriver driver) {
        click(getOTPButton, "Clicked on getOtp button", driver);
        ExtentReport.getTest().log(Status.INFO, "Clicked on Get OTP Button");
    }

    public void enterOTPNumber(String otpNUm, AppiumDriver driver) {
        sendKeys(otpTextBox, otpNUm, driver);
        ExtentReport.getTest().log(Status.INFO, "Entered OTP");
    }

    public void clickOnSubmitButton(AppiumDriver driver) {
        click(submitButton, "Click on Submit Button", driver);
        ExtentReport.getTest().log(Status.INFO, "Clicked on Submit Button");
    }

    public void loginToApplication(String mobileNumber, String otpNumber, AppiumDriver driver) throws InterruptedException {
        try {
            if (updateCrossButton.isDisplayed()) {
                click(updateCrossButton,driver);
            }
        } catch (Exception e) {

        }

        waitForVisibility(letsGoButton, driver);
        click(letsGoButton, "Clicked on Let's Go Button", driver);
        sendKeys(mobileNumberTextBox, mobileNumber, "Enter Mobile number in Mobile text box", driver);
        click(getOTPButton, "Clicked on Get OTP Button", driver);
        sendKeys(otpTextBox, otpNumber, "enter otp number", driver);
        click(submitButton, "Clicked on Submit Button", driver);
        Thread.sleep(2000);
        if (notificationAllowPopup.size() == 1) {
            click(notificationAllowPopup.get(0), "Clicked on notification allow button", driver);
        }
    }

    public void clickOnSelectGenderButton(AppiumDriver driver) {
        click(selectGenderButton, "Clicked on Select Gender Button", driver);
    }

    public void clickOnBoyGender(AppiumDriver driver) {
        click(boyGender, "Clicked on boy gender option", driver);
    }

    public void clickGirlGender(AppiumDriver driver) {
        click(girlGender, "Clicked on Girl Gender", driver);
    }

    public void clickOnVoiceRecordButton(AppiumDriver driver) {
        try {
            click(allowLocationPopup, "Click on allow notification popup", driver);
        } catch (Exception e) {

        }
        click(voiceRecordButton, "Click on voice record Button", driver);
        try {
            if (audioRecordPopup.isDisplayed()) {
                click(audioRecordPopup, "Clicked on notification allow button", driver);
            }
        } catch (Exception e) {

        }
        click(voiceRecordButton, "Click on voice record Button", driver);

    }

    public void clickOnDateOfBirthButtonAndOkButton(AppiumDriver driver) {
        click(dateOfBirthButton, "Clicked on DateOfBirth Button", driver);
        click(okButton, "clicked on Ok Button", driver);
    }

    public void clickOnSignInSubmitButton(AppiumDriver driver) {
        click(submitButtonSignIn, "Clicked on Submit Button", driver);
    }

    public void enterNickName(AppiumDriver driver, String nickName) {
        click(nickNameField, "Clicked on NickName field", driver);
        sendKeys(nickNameField, nickName, "Entered Nick Name", driver);
    }

    public void selectLanguage(AppiumDriver driver) {
        try {
            {
                click(allowLocationPopup, "Click on allow notification popup", driver);
            }
        } catch (Exception e) {

        }
        click(hindiLanguage, "Select Language", driver);
        click(saveButton, "Clciked on Save Button", driver);
    }

    public void checkCyberManifestoPolicies(AppiumDriver driver) {
        click(cyberCrimeCheckBox, "Clicked on Cyber Crime Checkbox", driver);
        click(cyberCrimeSubmitButton, "Clicked on Cyber Crime Submit button", driver);
    }

    public void selectAppLanguage(AppiumDriver driver) throws InterruptedException {
        click(appLanguage, "Select app Language", driver);
        click(appLanguageConfirmButton, "Clicked on AppLanguage Confirm Button", driver);
        Thread.sleep(3000);
        if (notificationAllowPopup.size() == 1) {
            click(notificationAllowPopup.get(0), "Clicked on allow notification popup", driver);
        }
    }

}

