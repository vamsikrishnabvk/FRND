package com.QA.Pages;

import com.QA.Base.BaseTest;
import com.QA.reports.ExtentReport;
import com.QA.utlis.TestUtils;
import com.aventstack.extentreports.Status;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class SelectTagScreenPage extends BaseTest {

    public SelectTagScreenPage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    TestUtils utils = new TestUtils();
    //*************** Keep Elements Here ******************************************
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[2]")
    private MobileElement loveTopic;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/goLiveBtv")
    public MobileElement goOnlineButton;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/howToEarnRewards")
    private MobileElement earnRewardButton;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    private List<MobileElement> audioRecordAllowPopup;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    private List<MobileElement> audioRecordAllowPopup2;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    private List<MobileElement> allowFRNDToConnectPopup;

    @AndroidFindBy(xpath = "//android.widget.ProgressBar[@text=\"1.0\"]/following-sibling::android.widget.TextView[@text=\"I Agree\"]")
    private List<MobileElement> iAgreeButton;

    @AndroidFindBy(xpath = "//android.view.View[@resource-id=\"com.dating.for.all.debug:id/exo_subtitles\"]")
    private List<MobileElement> aidPage;
    //android.widget.FrameLayout[@resource-id="com.dating.for.all.debug:id/exo_ad_overlay"]

    //android.view.View[@resource-id="com.dating.for.all.debug:id/exo_subtitles"

    @AndroidFindBy(id = "com.dating.for.all.debug:id/skipNowTv")
    private List<MobileElement> skipNowButton;

    //*********************** End Elements *************************************************

    public void clickOnLoveTag(AppiumDriver driver) throws InterruptedException {
        try
        {
            if(aidPage.size()==1)
            {
                click(aidPage.get(0), driver);
            }
           // Thread.sleep(1000);
            if(skipNowButton.size()==1)
            {
                click(skipNowButton.get(0), driver);
            }
        }catch (Exception e)
        {

        }
        waitForVisibility(loveTopic, driver);
        Assert.assertTrue(loveTopic.isDisplayed(),"Topic is not displayed");
        click(loveTopic, "Clicked on Love Tag", driver);
    }

    public void verifyUerAbleToHost(AppiumDriver driver) throws InterruptedException {
        click(goOnlineButton, "Clicked on Go Online Button", driver);
        Thread.sleep(2000);
        if (audioRecordAllowPopup.size() == 1) {
            click(audioRecordAllowPopup.get(0), "Clicked on Audio Record allow popup", driver);
        }
        Thread.sleep(2000);
        if (audioRecordAllowPopup2.size() == 1) {
            click(audioRecordAllowPopup2.get(0), "Clicked on Audio record popup2", driver);
        }
        if (allowFRNDToConnectPopup.size() == 1) {
            click(allowFRNDToConnectPopup.get(0), "Clicked on allow button", driver);
        }
        Thread.sleep(9000);
        if (iAgreeButton.size()==1) {
            click(iAgreeButton.get(0), "Clicked on IAgree Button", driver);
        }
        waitForVisibility(earnRewardButton, driver);
        Assert.assertTrue(earnRewardButton.isDisplayed());
        ExtentReport.getTest().log(Status.INFO, "User is able to host the room");
    }

    public void checkGoOnlineButtonEnabled(AppiumDriver driver)
    {
        waitForVisibility(goOnlineButton,driver);
        Assert.assertTrue(goOnlineButton.isEnabled(),"GoOnline Button is not enabled");
    }

    public void verifyUserRehostTheHostedRoom(AppiumDriver driver) throws InterruptedException {
        Thread.sleep(9000);
        if (iAgreeButton.size()==1) {
            click(iAgreeButton.get(0), "Clicked on IAgree Button", driver);
        }
        waitForVisibility(earnRewardButton, driver);
        Assert.assertTrue(earnRewardButton.isDisplayed());
        ExtentReport.getTest().log(Status.INFO, "User again host the room");
    }
    public void clickOnGoOnlineButton(AppiumDriver driver)
    {
        click(goOnlineButton,driver);
    }
}
