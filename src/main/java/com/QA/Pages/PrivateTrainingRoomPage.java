package com.QA.Pages;

import com.QA.Base.BaseTest;
import com.QA.reports.ExtentReport;
import com.QA.utlis.TestUtils;
import com.aventstack.extentreports.Status;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class PrivateTrainingRoomPage extends BaseTest {

    public PrivateTrainingRoomPage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    TestUtils utils = new TestUtils();
    //*************** Keep Elements Here ******************************************
    @AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"Private Training Rooms\"]/preceding-sibling::android.view.View)[4]")
    private MobileElement plusIcon;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/treasure_animation_lv")
    private MobileElement animationIcon;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Create Room\"]")
    private MobileElement createRoomIcon;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Audio Room\"]")
    private MobileElement audioRoomButton;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text = \"Daniel\"]/preceding-sibling::android.widget.TextView)[1]")
    private List<MobileElement> vivoHostedRoom;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text = \"Daniel\"]/preceding-sibling::android.widget.ImageView[@resource-id=\"com.dating.for.all.debug:id/starFrameIv\"])[1]")
    private List<MobileElement> vivoStarHostedRoom;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"Private Training Rooms\"]/preceding-sibling::android.view.View)[2]/android.widget.TextView")
    private MobileElement availableCoins;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/hostsRv")
    private MobileElement hostRv;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Video Room\"]")
    private MobileElement videoRoomButton;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/coinTitleTv")
    private MobileElement addCoinsToWalletLabel;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/ocrAddCoinTv")
    private MobileElement addCoinsLabel;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"Private Training Rooms\"]/preceding-sibling::android.view.View)[1]")
    public MobileElement profileIcon;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/gift")
    public MobileElement giftBox;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    public List<MobileElement> audioRecordAllowPopup;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    public MobileElement audioRecordAllowPopup1;


    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"5 Min Call\"]")
    private MobileElement fiveMinuteCallButton;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/title")
    private List<MobileElement> startTrainingLabel;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/yellowRoseHeadTv")
    private MobileElement yellowRoseHead;

    @AndroidFindBy(xpath = "//android.widget.ProgressBar[@text=\"1.0\"]/following-sibling::android.widget.TextView[@text=\"I Agree\"]")
    private List<MobileElement> iAgreeButton;

    @AndroidFindBy(xpath = "//android.view.View[@resource-id=\"com.dating.for.all.debug:id/exo_subtitles\"]")
    private List<MobileElement> aidPage;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/skipNowTv")
    private List<MobileElement> skipNowButton;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/videoSwitch")
    private MobileElement videoSwitchIcon;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/aurBataoTitle")
    private MobileElement aurBtaoIcon;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/close")
    private MobileElement aurBtaoIconCloseButton;

    //*********************** End Elements *************************************************

    public void clickOnAudioRecordAllowPopoup(AppiumDriver driver) throws InterruptedException {
        Thread.sleep(1000);
        if(audioRecordAllowPopup.size()==1)
        {
            click(audioRecordAllowPopup.get(0),driver);
        }
    }
    public void clickOnPlusIcon(AppiumDriver driver) throws InterruptedException {
        try {
            if (yellowRoseHead.isDisplayed()) {
                clickBackButton(driver);
            }
        } catch (Exception e) {

        }
        waitForClickable(plusIcon, driver);
        click(plusIcon, "Clicked on Plus Icon", driver);
    }

    public void clickOnProfileIcon(AppiumDriver driver) throws InterruptedException {
        waitForVisibility(profileIcon, driver);
        click(profileIcon, "Clicked on ProfileICon", driver);
    }

    public void clickOnCreateRoomIcon(AppiumDriver driver) {
        click(createRoomIcon, "Clicked on create room icon", driver);
    }

    public void switchToFrame(AppiumDriver driver)
    {
        driver.switchTo().frame(0);
    }

    public void clickOnAudioRoomButton(AppiumDriver driver) {
        click(audioRoomButton, "Clicked on Audio Room Button", driver);
    }

    public void clickOnVideoRoomButton(AppiumDriver driver) {
        click(videoRoomButton, "Clicked on Video Room Button", driver);
    }

    public static final TouchAction clickOnTouch(AppiumDriver driver) {
        AndroidDriver driver1 = (AndroidDriver) driver;
        driver1.performTouchAction(clickOnTouch(driver));
        return null;
    }

    public void handleHostedRoomPopup(AppiumDriver driver) throws InterruptedException {
        if (audioRecordAllowPopup.size() == 1) {
            click(audioRecordAllowPopup.get(0), "Clicked on audio record allow popup", driver);
        }
        Thread.sleep(2000);
        if (audioRecordAllowPopup.size() == 1) {
            click(audioRecordAllowPopup.get(0), "Clicked on audio record allow popup", driver);
        }
        Thread.sleep(6000);
        if (iAgreeButton.size()==1) {
            click(iAgreeButton.get(0), "Clicked on IAgree Button", driver);
        }
    }
    public void checkCoinAndEnterRoom(String coin, String expectedCoin, AppiumDriver driver) throws InterruptedException {
        int coin1 = Integer.parseInt(coin);
        int expectedCion = Integer.parseInt(expectedCoin);
        if (coin1 >= expectedCion) {
            Assert.assertTrue(true, "User coin is less than 20 So he cannot join the room");
            Thread.sleep(2000);
                swipeScreen(Direction.DOWN, driver);
            Thread.sleep(4000);
            waitForClickable(vivoHostedRoom.get(0), driver);
            click(vivoHostedRoom.get(0), "Clicked on Vivo call", driver);
            try
            {
                if(aidPage.size()==1) {
                    click(aidPage.get(0), driver);
                }
                Thread.sleep(1000);
                if(skipNowButton.size()==1) {
                    click(skipNowButton.get(0), driver);
                }
            }catch (Exception e)
            {

            }
            if (audioRecordAllowPopup.size() == 1) {
                click(audioRecordAllowPopup.get(0), "Clicked on audio record allow popup", driver);
            }
            Thread.sleep(2000);
            if (audioRecordAllowPopup.size() == 1) {
                click(audioRecordAllowPopup.get(0), "Clicked on audio record allow popup", driver);
            }
            Thread.sleep(9000);
            if (iAgreeButton.size()==1) {
                click(iAgreeButton.get(0), "Clicked on IAgree Button", driver);
            }
            utils.log().info("User is able to join room as Coins is more than " + expectedCoin);
            ExtentReport.getTest().log(Status.INFO, "User is able to join as Coins is more than "+expectedCoin);
            waitForVisibility(giftBox, driver);
            Assert.assertTrue(giftBox.isDisplayed(), "User is not able to join hosted room");
            utils.log().info("User have joined the hosted room");
            ExtentReport.getTest().log(Status.INFO, "User have joined hosted room");
        } else if (coin1 < expectedCion) {

            Assert.assertTrue(coin1 < expectedCion, "User coin is more than " + expectedCion);
            swipeScreen(Direction.DOWN, driver);
            while (vivoHostedRoom.size() < 1) {
                waitForClickable(vivoHostedRoom.get(0), driver);
            }
            click(vivoHostedRoom.get(0), "Clicked on Vivo call", driver);
            waitForVisibility(addCoinsToWalletLabel, driver);
            Assert.assertTrue(addCoinsToWalletLabel.isDisplayed(), "User is able to join room while coin is less than " + expectedCoin);
            utils.log().info("User is not able to join room as Coins is less than " + expectedCoin);
            ExtentReport.getTest().log(Status.INFO, "User is not able to join room as Coins is less than " + expectedCoin);
        }
    }

    public void clickOnHostedRoomAndJoin(AppiumDriver driver)
    {
        while (vivoHostedRoom.size() < 1) {
            swipeScreen(Direction.DOWN, driver);
        }
        waitForClickable(vivoHostedRoom.get(0), driver);
        click(vivoHostedRoom.get(0), "Clicked on Vivo call", driver);
    }

    public void verifyUserNeedToAddCoinsForFurtherCall(AppiumDriver driver)
    {
        waitForVisibility(addCoinsToWalletLabel,driver);
        Assert.assertTrue(addCoinsToWalletLabel.isDisplayed(),"Add Coins Popup is not visible");
        utils.log().info("User is not able to join call as need to add Coins");
        ExtentReport.getTest().log(Status.INFO,"User is not able to join call as need to add Coins");
    }

    public void clickOnIAgreeButton(AppiumDriver driver) throws InterruptedException {
        Thread.sleep(9000);
        if (iAgreeButton.size()==1) {
            click(iAgreeButton.get(0), "Clicked on IAgree Button", driver);
        }
    }

    public void checkCoinsDeducted(String expectedCoin, AppiumDriver driver) {
        //click(homeTab,"Clicked on HomeTab");
        waitForVisibility(availableCoins, driver);
        String coinsLeft = getText(availableCoins, "Get availabel coins", driver);
        int actCoin = Integer.parseInt(expectedCoin);
        int remCoin = Integer.parseInt(coinsLeft);
        Assert.assertTrue(remCoin < actCoin, "Coins left after sending gift is not less than the coin before sending gift");
        utils.log().info("Coins left after sending gift is less than the coin before sending gift");
        ExtentReport.getTest().log(Status.INFO, "Coins left after sending gift is less than the coin before sending gift");
    }

    public void verifyUserNotJoinRoomAfterBan(AppiumDriver driver) throws InterruptedException {
        Thread.sleep(4000);
        while (vivoHostedRoom.size() < 1) {
            swipeScreen(Direction.DOWN, driver);
        }
        waitForClickable(vivoHostedRoom.get(0), driver);
        click(vivoHostedRoom.get(0), "Clicked on Vivo call", driver);
        waitForVisibility(profileIcon, driver);
        Assert.assertTrue(profileIcon.isDisplayed(), "User is able to join after ban");
        utils.log().info("User is not able to join after ban");
        ExtentReport.getTest().log(Status.INFO, "User is not able to join after ban");
    }

    public void checkFiveMinuteCallButton(AppiumDriver driver) {
        if (startTrainingLabel.size() == 1) {
            clickBackButton(driver);
        }
        waitForVisibility(fiveMinuteCallButton, driver);
        Assert.assertTrue(fiveMinuteCallButton.isDisplayed(), "Five Minute call is not displayed");
        utils.log().info("User is getting Five minute free call");
        ExtentReport.getTest().log(Status.INFO, "User is getting Five minute free call");
    }

    public void clickOnAnimationIcon(AppiumDriver driver)
    {
        click(animationIcon,driver);
    }

    public void verifyVideoSwicthOptionVisible(AppiumDriver driver,String actualCoin, String expectedCoin) throws InterruptedException {
        int coin1 = Integer.parseInt(actualCoin);
        int expectedCion = Integer.parseInt(expectedCoin);
        if (coin1 >= expectedCion) {
            Assert.assertTrue(true, "User coin is less than 20 So he cannot join the room");
            Thread.sleep(2000);
            swipeScreen(Direction.DOWN, driver);
            Thread.sleep(2000);
            waitForClickable(vivoHostedRoom.get(0), driver);
            click(vivoHostedRoom.get(0), "Clicked on Vivo call", driver);
            try {
                if (aidPage.size() == 1) {
                    click(aidPage.get(0), driver);
                }
                Thread.sleep(1000);
                if (skipNowButton.size() == 1) {
                    click(skipNowButton.get(0), driver);
                }
            } catch (Exception e) {

            }
            if (audioRecordAllowPopup.size() == 1) {
                click(audioRecordAllowPopup.get(0), "Clicked on audio record allow popup", driver);
            }
//            Thread.sleep(2000);
//            if (audioRecordAllowPopup.size() == 1) {
//                click(audioRecordAllowPopup.get(0), "Clicked on audio record allow popup", driver);
//            }
            Thread.sleep(7000);
            if(iAgreeButton.size()==1)
            {
                click(iAgreeButton.get(0),driver);
            }
            waitForVisibility(videoSwitchIcon, driver);
            Assert.assertTrue(videoSwitchIcon.isDisplayed(), "Video Switch Icon is not Visible");
        }
    }
    public int gettingAvailableCoins(AppiumDriver driver)
    {
        return Integer.parseInt(getText(availableCoins,"getting available coins",driver));
    }
    public void checkIfUserShouldOnlyBeAbleToJoinVideoCallRequestInVoiceCallIfUserHaveTheRequiredCoinBalance(AppiumDriver driver,int actualCoin,int expectedCoin) throws InterruptedException {
        Thread.sleep(2000);
            Assert.assertTrue(actualCoin >= expectedCoin, "User coin is less than 90 So he cannot join the room");
        Thread.sleep(2000);
                if(aidPage.size()==1) {
                    click(aidPage.get(0), driver);
                }
                Thread.sleep(1000);
                if(skipNowButton.size()==1) {
                    click(skipNowButton.get(0), driver);
                }
           //  click(audioRecordAllowPopup1,driver);
            if (audioRecordAllowPopup.size() == 1) {
                click(audioRecordAllowPopup.get(0), "Clicked on audio record allow popup", driver);
            }
            Thread.sleep(2000);
            if (audioRecordAllowPopup.size() == 1) {
                click(audioRecordAllowPopup.get(0), "Clicked on audio record allow popup", driver);
            }
            waitForVisibility(new HostedAudioCallPage(driver).connectingScreen,driver);
            Assert.assertTrue(new HostedAudioCallPage(driver).connectingScreen.isDisplayed(),"Connecting Screen is not visible");
            Thread.sleep(9000);
            if (iAgreeButton.size()==1) {
                click(iAgreeButton.get(0), "Clicked on IAgree Button", driver);
            }
            utils.log().info("User is able to join room as Coins is more than " + expectedCoin);
            ExtentReport.getTest().log(Status.INFO, "User is able to join as Coins is more than "+expectedCoin);
            waitForVisibility(giftBox, driver);
            Assert.assertTrue(giftBox.isDisplayed(), "User is not able to join hosted room");
            utils.log().info("User have joined the hosted room");
            ExtentReport.getTest().log(Status.INFO, "User have joined hosted room");
    }

    public void  verifyTheUserShoulAbleToSeeAndClickOnTheAurBataoIcon(AppiumDriver driver)
    {
        waitForVisibility(aurBtaoIcon,driver);
        click(aurBtaoIconCloseButton,driver);
        utils.log().info("AurBtaoIcon is displayed and clickable");
        ExtentReport.getTest().log(Status.INFO, "AurBtaoIcon is displayed and clickable");
    }
    public void verifyNotAbleToHostPTRroom(AppiumDriver driver)
    {
        waitForVisibility(plusIcon,driver);
        Assert.assertTrue(plusIcon.isDisplayed(),"User is able to Host PTR room");
        utils.log().info("User not able to Host PTR room");
        ExtentReport.getTest().log(Status.INFO, "User not able to Host PTR room");
    }

    public void checkStarUserDisplayedAndJoinRoom(AppiumDriver driver,String availableCoins,int expectedCoins) throws InterruptedException {
        Thread.sleep(2000);
        swipeScreen(Direction.DOWN,driver);
        Thread.sleep(2000);
        if(vivoStarHostedRoom.size()==1)
        {
            utils.log().info("StarUser Hosted Room Displayed");
            ExtentReport.getTest().log(Status.INFO, "StarUser Hosted Room Displayed");
            if(Integer.parseInt(availableCoins)>=expectedCoins)
            {
                click(vivoStarHostedRoom.get(0),driver);
                try
                {
                    if(aidPage.size()==1) {
                        click(aidPage.get(0), driver);
                    }
                    Thread.sleep(1000);
                    if(skipNowButton.size()==1) {
                        click(skipNowButton.get(0), driver);
                    }
                }catch (Exception e)
                {

                }
                if (audioRecordAllowPopup.size() == 1) {
                    click(audioRecordAllowPopup.get(0), "Clicked on audio record allow popup", driver);
                }
                Thread.sleep(2000);
                if (audioRecordAllowPopup.size() == 1) {
                    click(audioRecordAllowPopup.get(0), "Clicked on audio record allow popup", driver);
                }
                Thread.sleep(9000);
                if (iAgreeButton.size()==1) {
                    click(iAgreeButton.get(0), "Clicked on IAgree Button", driver);
                }
                utils.log().info("User is able to join room as Coins is more than " + expectedCoins);
                ExtentReport.getTest().log(Status.INFO, "User is able to join as Coins is more than "+expectedCoins);
                waitForVisibility(giftBox, driver);
                Assert.assertTrue(giftBox.isDisplayed(), "User is not able to join hosted room");
                utils.log().info("User have joined the hosted room");
                ExtentReport.getTest().log(Status.INFO, "User have joined hosted room");
            }
            else if(Integer.parseInt(availableCoins)<expectedCoins){
                click(vivoStarHostedRoom.get(0),driver);
                waitForVisibility(addCoinsToWalletLabel,driver);
                Assert.assertTrue(addCoinsToWalletLabel.isDisplayed(),"User is joining star room inspite of having coin less than "+expectedCoins);
                clickBackButton(driver);
                clickBackButton(driver);
                utils.log().info("User donot have required coins balance to join roon");
                ExtentReport.getTest().log(Status.INFO, "user donot have required coins balance to join room");
            }
        }
        else if(vivoStarHostedRoom.size()<1)
        {
            utils.log().info("StarUser Hosted Room not Displayed");
            ExtentReport.getTest().log(Status.INFO, "StarUser Hosted Room not Displayed");
        }
    }

    public void checkStarUserDisplayedAndJoinRoomForVideoCall(AppiumDriver driver,String availableCoins,int expectedCoins) throws InterruptedException {
        Thread.sleep(2000);
        swipeScreen(Direction.DOWN,driver);
        Thread.sleep(2000);
        if(vivoStarHostedRoom.size()==1)
        {
            utils.log().info("StarUser Hosted Room Displayed");
            ExtentReport.getTest().log(Status.INFO, "StarUser Hosted Room Displayed");
            if(Integer.parseInt(availableCoins)>=expectedCoins)
            {
                click(vivoStarHostedRoom.get(0),driver);
                try
                {
                    if(aidPage.size()==1) {
                        click(aidPage.get(0), driver);
                    }
                    Thread.sleep(1000);
                    if(skipNowButton.size()==1) {
                        click(skipNowButton.get(0), driver);
                    }
                }catch (Exception e)
                {

                }
                if (audioRecordAllowPopup.size() == 1) {
                    click(audioRecordAllowPopup.get(0), "Clicked on audio record allow popup", driver);
                }
                Thread.sleep(2000);
                if (audioRecordAllowPopup.size() == 1) {
                    click(audioRecordAllowPopup.get(0), "Clicked on audio record allow popup", driver);
                }
                Thread.sleep(9000);
                if (iAgreeButton.size()==1) {
                    click(iAgreeButton.get(0), "Clicked on IAgree Button", driver);
                }
                utils.log().info("User is able to join room as Coins is more than " + expectedCoins);
                ExtentReport.getTest().log(Status.INFO, "User is able to join as Coins is more than "+expectedCoins);
                waitForVisibility(giftBox, driver);
                Assert.assertTrue(giftBox.isDisplayed(), "User is not able to join hosted room");
                utils.log().info("User have joined the hosted room");
                ExtentReport.getTest().log(Status.INFO, "User have joined hosted room");
            }
            else if(Integer.parseInt(availableCoins)<expectedCoins){
                click(vivoStarHostedRoom.get(0),driver);
                waitForVisibility(addCoinsLabel,driver);
                Assert.assertTrue(addCoinsLabel.isDisplayed(),"User is joining star room inspite of having coin less than "+expectedCoins);
                clickBackButton(driver);
                clickBackButton(driver);
                utils.log().info("User donot have required coins balance to join roon");
                ExtentReport.getTest().log(Status.INFO, "user donot have required coins balance to join room");
            }
        }
        else if(vivoStarHostedRoom.size()<1)
        {
            utils.log().info("StarUser Hosted Room not Displayed");
            ExtentReport.getTest().log(Status.INFO, "StarUser Hosted Room not Displayed");
        }
    }
}
