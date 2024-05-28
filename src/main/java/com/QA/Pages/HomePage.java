package com.QA.Pages;

import com.QA.Base.BaseTest;
import com.QA.reports.ExtentReport;
import com.QA.utlis.TestUtils;
import com.aventstack.extentreports.Status;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class HomePage extends BaseTest {

    public HomePage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    TestUtils utils = new TestUtils();
    //*************** Keep Elements Here ******************************************
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.dating.for.all.debug:id/title\" and @text=\"Training\"]")
    public  MobileElement tainingTab;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/coins")
    private MobileElement availableCoins;

    @AndroidFindBy(id = "//android.widget.TextView[@text=\"Limited\n" +
            "Discount Offer\"]")
    protected List<MobileElement> crossButton;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/cancelBtv")
    protected List<MobileElement> cancelButton;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/title")
    protected List<MobileElement> titlePopup;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.dating.for.all.debug:id/title\" and @text=\"Home\"]")
    private MobileElement homeTab;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/frameView")
    private MobileElement frameElement;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/design_bottom_sheet")
    private MobileElement frame2;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Update from Google Play available\n" +
            "\"]")
    private MobileElement updateCrossButton;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/freeMinsTv")
    private MobileElement freeMintCall;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/callNow")
    private MobileElement callNowButton;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    private List<MobileElement> audioRecordAllowPopup;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/addCoinsBtv")
    private MobileElement addCoinsNowButton;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[3]/android.widget.FrameLayout/android.widget.ImageView")
    public MobileElement frndTab;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/carouselIv")
    private MobileElement callNowBanner;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Group Rooms\"]")
    private List<MobileElement> groupRoom;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Private Training Rooms\"]")
    private MobileElement privateTrainingRooms;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"FRND Making Rooms\"]")
    private MobileElement frndMakingRoom;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/moreOptions")
    private MobileElement morePakageOptionButton;

    // com.dating.for.all.debug:id/moreOptions

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Create\"]")
    private MobileElement createButton;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"com.dating.for.all.debug:id/fscv_id\"]/android.widget.ImageView")
    MobileElement homePagePopup;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Audio Room\"]")
    private MobileElement audioRoomButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.dating.for.all.debug:id/day\" and @text=\"Day 1\"]")
    private MobileElement day1Button;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/info")
    private MobileElement collectDailyRewardPopup;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/rewardAmount")
    private MobileElement rewardAmount;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/okay")
    private MobileElement okayButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Video Room\"]")
    private MobileElement videoRoomButton;
    @AndroidFindBy(xpath = "com.dating.for.all.debug:id/profileAvatar")
    private MobileElement profileAvatar;


//*********************** End Elements *************************************************

    public void clickOnHomeTab(AppiumDriver driver) {
        click(homeTab, "Click on HomeTab", driver);
    }

    public void clickOnTrainingTab(AppiumDriver driver) throws InterruptedException {
        Thread.sleep(2000);
        waitForVisibility(tainingTab, driver);
        click(tainingTab, "Clicked on Training Tab", driver);
    }

    public void handlingPopup(AppiumDriver driver) throws InterruptedException {
//        waitForVisibility(crossButton.get(0));
        Thread.sleep(3000);
//        if (crossButton.size() == 1) {
//            Thread.sleep(1000);
            clickBackButton(driver);
//            Thread.sleep(2000);
//            click(cancelButton.get(0), "Clicked on Cancel Button", driver);
//        } else if (cancelButton.size() == 1) {
    //    Thread.sleep(2000);
            clickBackButton(driver);
//        }
        Thread.sleep(2000);
        try {
            if (updateCrossButton.isDisplayed()) {
                clickBackButton(driver);
            }
        }catch (Exception e)
        {

        }
        if (titlePopup.size() == 1) {
            clickBackButton(driver);
            utils.log().info("Clicked on Back button");
            ExtentReport.getTest().log(Status.INFO, "Clicked on Back Button");
        }
        Thread.sleep(2000);
        try {
            if (updateCrossButton.isDisplayed()) {
                clickBackButton(driver);
            }
        }catch (Exception e)
        {

        }
    }

    public  String getAvailableCoin(AppiumDriver driver) throws InterruptedException {
            click(homeTab,"Clicked on HomeTab",driver);
            waitForVisibility(availableCoins,driver);
            return getText(availableCoins,"Get available coin package", driver);
    }

    public void clickOnCoins(AppiumDriver driver)
    {
        click(homeTab,driver);
        click(availableCoins,"Clicked on available coins",driver);
    }

    public void clickOnAvailableCoinValueSymbol(AppiumDriver driver)
    {
        click(availableCoins,"Clicked on Coin Package", driver);
    }
    public void verifyHostExitTheRoom(AppiumDriver driver)
    {
        waitForVisibility(homeTab, driver);
        Assert.assertTrue(homeTab.isDisplayed(),"Host is not able to exit the room");
        utils.log().info("Host have exit the room");
        ExtentReport.getTest().log(Status.INFO, "Host Exit the Room");
    }
    public void checkFreeMinuteAndConnect(AppiumDriver driver) throws InterruptedException {
        waitForVisibility(freeMintCall,driver);
        Assert.assertTrue(freeMintCall.isDisplayed(),"Free minute label is not displayed");
        ExtentReport.getTest().log(Status.INFO, "Free Minute Call is Displayed");
        click(callNowButton,"Clicked on call now button",driver);
        if(audioRecordAllowPopup.size()==1)
        {
            click(audioRecordAllowPopup.get(0),"Clicked on Audio record allow popup",driver);
        }
        Thread.sleep(2000);
        if(audioRecordAllowPopup.size()==1)
        {
            click(audioRecordAllowPopup.get(0),"Clicked on Audio record allow popup",driver);
        }
    }
    public void clickOnAddCoinsNowButton(AppiumDriver driver)
    {
        click(addCoinsNowButton,"Click on Add Coins Now Button", driver);
    }

    public void verifyCoinsAddedAfterPayment(String availableCoins,String coinsAfterPayment,String coinsToBeAdded)
    {
        int availableCoin = Integer.parseInt(availableCoins);
        int coinsToBeAdded1 = Integer.parseInt(coinsToBeAdded);
        int coinAfterPayment = Integer.parseInt(coinsAfterPayment);
        int sumOfCoins = availableCoin+coinsToBeAdded1;
        Assert.assertEquals(coinAfterPayment,sumOfCoins,"Coins After payment have not been added");
        utils.log().info("Coins After Payment have been added successfully");
        ExtentReport.getTest().log(Status.INFO, "Coins After Payment have been successfully Added");
    }

    public void clickOnFrndTab(AppiumDriver driver) {
        waitForVisibility(frndTab, driver);
        waitForVisibility(frndTab, driver);
        click(frndTab, "Clicked on Frnd Tab", driver);
    }

    public void verifyCallNowBannerDisplayed(boolean isDisplayed, AppiumDriver driver) {
        waitForVisibility(callNowBanner, driver);
        Assert.assertEquals(callNowBanner.isDisplayed(), isDisplayed);
        ExtentReport.getTest().log(Status.INFO, "CallNowBanner is displayed");
    }

    public void clickOnGroupRoom(AppiumDriver driver) throws InterruptedException {
        swipeElementAndroid(privateTrainingRooms, Direction.LEFT, "swiping left", (AndroidDriver) driver);
        ExtentReport.getTest().log(Status.INFO, "Swiping Left");
        Thread.sleep(2000);
        if(groupRoom.size()<1)
        {
            swipeElementAndroid(frndMakingRoom, Direction.LEFT, "swiping left", (AndroidDriver) driver);
        }
        click(groupRoom.get(0), "clicked on GroupRoom", driver);
    }
    public void clickOnGroupRoom1(AppiumDriver driver) throws InterruptedException {
        swipeElementAndroid(privateTrainingRooms, Direction.LEFT, "swiping left", (AndroidDriver) driver);
        ExtentReport.getTest().log(Status.INFO, "Swiping Left");
        click(groupRoom.get(0), "clicked on GroupRoom", driver);
    }
    public void clickOnMorePackageOption(AppiumDriver driver)
    {
        click(morePakageOptionButton,driver);
    }

    public void clickOnCreateButton(AppiumDriver driver)
    {
        try {
            click(homePagePopup, driver);
        }catch (Exception e)
        {

        }
        click(homeTab,driver);
        click(createButton,driver);
        waitForVisibility(audioRoomButton,driver);
        Assert.assertTrue(audioRoomButton.isDisplayed(),"AudioRoomButton is displayed");
    }
    public void clickOnAudioRoomButton(AppiumDriver driver)
    {
        click(audioRoomButton,driver);
    }
    public void clickOnVideoRoomButton(AppiumDriver driver)
    {
        click(videoRoomButton,driver);
    }
    public void logOutOfTheApp(AppiumDriver driver)
    {
        click(homeTab,driver);
        click(profileAvatar,driver);
        click(new ProfilePage(driver).hamburgerMenu,driver);
        swipeElementAndroid(new ProfilePage(driver).transactionTab,Direction.DOWN,"Swipping Down",(AndroidDriver)driver);
        click(new ProfilePage(driver).settingIcon,driver);
        click(new ProfilePage(driver).logOutButton,driver);
    }

}
