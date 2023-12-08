package com.QA.Pages;

<<<<<<< HEAD
import com.QA.Base.BaseTest;
=======
import com.QA.Base.BaseTest2;
>>>>>>> e7aad041656f51bcd7540c5837b667b08d8aa271
import com.QA.utlis.TestUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

<<<<<<< HEAD
public class SelectTagScreenPage extends BaseTest {

    public SelectTagScreenPage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

=======
public class SelectTagScreenPage extends BaseTest2 {

    public SelectTagScreenPage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);   }
>>>>>>> e7aad041656f51bcd7540c5837b667b08d8aa271
    TestUtils utils = new TestUtils();
    //*************** Keep Elements Here ******************************************
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[2]")
    private MobileElement loveTopic;

    @AndroidFindBy(id = "com.dating.for.all:id/goLiveBtv")
    public MobileElement goOnlineButton;

    @AndroidFindBy(id = "com.dating.for.all:id/howToEarnRewards")
    private MobileElement earnRewardButton;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    private List<MobileElement> audioRecordAllowPopup;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    private List<MobileElement> audioRecordAllowPopup2;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    private List<MobileElement> allowFRNDToConnectPopup;

    //*********************** End Elements *************************************************

    public void clickOnLoveTag(AppiumDriver driver) throws InterruptedException {
        waitForVisibility(loveTopic, driver);
<<<<<<< HEAD
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
=======
        click(loveTopic,"Clicked on Love Tag", driver);
    }

    public void verifyUerAbleToHost(AppiumDriver driver) throws InterruptedException {
        click(goOnlineButton,"Clicked on Go Online Button", driver);
        Thread.sleep(2000);
        if(audioRecordAllowPopup.size()==1)
        {
            click(audioRecordAllowPopup.get(0),"Clicked on Audio Record allow popup", driver);
        }
        Thread.sleep(2000);
        if (audioRecordAllowPopup2.size()==1)
        {
            click(audioRecordAllowPopup2.get(0),"Clicked on Audio record popup2",driver);
        }
        if(allowFRNDToConnectPopup.size()==1)
        {
            click(allowFRNDToConnectPopup.get(0),"Clicked on allow button",driver);
>>>>>>> e7aad041656f51bcd7540c5837b667b08d8aa271
        }
        waitForVisibility(earnRewardButton, driver);
        Assert.assertTrue(earnRewardButton.isDisplayed());
    }
}
