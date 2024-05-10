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

public class HostedVideoCallPage extends BaseTest {

    public HostedVideoCallPage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    TestUtils utils = new TestUtils();
    //*************** Keep Elements Here ******************************************
    @AndroidFindBy(id = "com.dating.for.all.debug:id/gift")
    public MobileElement giftBox;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"IPL\"]")
    private List<MobileElement> iPLGiftOption;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/purchase_text")
    private MobileElement sendButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Punjab']/following-sibling::android.widget.LinearLayout//android.widget.TextView[@resource-id='com.dating.for.all.debug:id/discountPrice']")
    private MobileElement punjabHelmetGift;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/close")
    private List<MobileElement> exitButton;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/askYr")
    private MobileElement askYrIcon;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/star5")
    private MobileElement fifthStarRating;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/reviewTV")
    private MobileElement reviewTextBox;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/submit")
    private MobileElement submitButton;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/star51")
    private MobileElement experienceStarRating;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/callAgain")
    private List<MobileElement> callAgainButton;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/back")
    private List<MobileElement> popupBackButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]")
    private List<MobileElement> goOffLineCrossButton;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/exitRoomRoot")
    private List<MobileElement> hostExitRoomButton;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/timer")
    private MobileElement timer;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/menu")
    private MobileElement menu;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/mic")
    private MobileElement mic;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/soundOff")
    private List<MobileElement> soundOffSymbol;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/volume")
    private MobileElement volumeIcon;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/amt2Tv")
    private MobileElement roses10;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/requestBt")
    private MobileElement requestButton;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/giftNowTv")
    private MobileElement giftNowButton;

    @AndroidFindBy(xpath = "(//android.widget.ImageView[@resource-id=\"com.dating.for.all.debug:id/avatar\"])[1]")
    private MobileElement userAvatarIcon;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/profileTv")
    private MobileElement profileLayout;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/removeLayout")
    private MobileElement removeLayout;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/positiveActionBtv")
    private MobileElement removeButton;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/kickOutIv")
    private MobileElement banIcon;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Sexual Talk\"]")
    private MobileElement sexualTalkWarning;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Ban\"]")
    private MobileElement banButton;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/positiveActionBtv")
    private MobileElement punishButton;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"I Understand it won't happen again\"]/preceding-sibling::android.widget.ImageView)[2]")
    private MobileElement checkBox;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"I Promise\"]")
    private MobileElement iPromiseButton;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id=\"com.dating.for.all.debug:id/skip\"]")
    private MobileElement skipCrossButton;

    @AndroidFindBy(xpath = "(//android.widget.ImageView[@resource-id=\"com.dating.for.all.debug:id/playerAvatar\"])[1]")
    private MobileElement giftAnimation;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/avatarFramesRv")
    private MobileElement framesList;
    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@resource-id=\"com.dating.for.all.debug:id/frame_layout\"])[3]")
    private MobileElement singleFrame;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/purchase_text")
    private List<MobileElement> buyNowButton;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/applyAddonButton")
    private List<MobileElement> applyFrameButton;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/gemsCountTv")
    private MobileElement gemIcon;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/coinsCountTv")
    private MobileElement coinsAmountIcon;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/videoSwitch")
    private List<MobileElement> videoSwitchIcon;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/menu")
    private MobileElement threeDotMenu;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/playerAvatar")
    private List<MobileElement> playerAvatar;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/info")
    private MobileElement addTimeToAvoidCallLabel;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id=\"com.dating.for.all.debug:id/timerIcon\"]/following-sibling::android.widget.TextView")
    private MobileElement timerCountDown;
    @AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"Mins\"])[1]")
    private MobileElement minuteOption1;
    @AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"Mins\"])[2]")
    private MobileElement minuteOption2;
    @AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"Mins\"])[3]")
    private MobileElement minuteOption3;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/amount")
    private MobileElement amountLabel;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/timerRoot")
    private MobileElement callTimer;
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.dating.for.all.debug:id/title\" and @text=\"Can't add extra time in last 00:01\"]")
    private MobileElement cannotAddExtraTimeMessage;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/title")
    private List<MobileElement> winMoneyFromYellowRoseLabel;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/addToBankLabel")
    private List<MobileElement> transferMoneyToYourBankLabel;

    //*********************** End Elements *************************************************

    public void requestForGift(AppiumDriver driver) {
        click(askYrIcon, "Clicked on AskYr Icon", driver);
        click(roses10, "Selected 10 Roses option", driver);
        click(requestButton, "Clicked on Request Button", driver);
    }

    public void userSendGiftToHost(AppiumDriver driver) {
        click(giftNowButton, "Sended gift to owner", driver);
    }

    public void verfiyTimerAndGiftCoinAfterSendsGift(String actualCoinValue, AppiumDriver driver) throws InterruptedException {
        String actualTimerValue = getTimerValue(driver);
        click(giftBox, "Clicked on Gift Box", driver);
        while (iPLGiftOption.size() < 1) {
            swipeScreen(Direction.LEFT, driver);
        }
        click(iPLGiftOption.get(0), "Clicked on iplGiftOption", driver);
        String giftCoinValue = getText(punjabHelmetGift, " Get coins value of selected gift", driver);
        int m = Integer.parseInt(actualCoinValue);
        int n = Integer.parseInt(giftCoinValue);
        Assert.assertTrue(n < m, "Gift Coins values is not less than Actual Coins value So cannot send gift");
        click(punjabHelmetGift, "Clicked on punjabHelmetGift", driver);
        click(sendButton, "Clicked on Send Button", driver);
        waitForVisibility(giftAnimation,driver);
        Assert.assertTrue(giftAnimation.isDisplayed(),"Gift Animation not displayed");
        ExtentReport.getTest().log(Status.INFO, "Gift Animation is displayed");
        String timerValueAfterGift = getTimerValue(driver);
        int a = Integer.parseInt(actualTimerValue);
        int b = Integer.parseInt(timerValueAfterGift);
        Assert.assertTrue(a > b, "TimerValue is not less than the timeValue after sending gift");
        ExtentReport.getTest().log(Status.INFO, "TimerValue is less than the time value after sending gift");
    }

    public void hostExitGameRoom(AppiumDriver driver) throws InterruptedException {
        while (hostExitRoomButton.size()<1)
        {
            clickBackButton(driver);
        }
        click(hostExitRoomButton.get(0),"Clicked on Exit Button",driver);
    }

    public void checkMuteUnmuteFunctionality(AppiumDriver driver) throws InterruptedException {
        click(menu, "Cliked on menu", driver);
        click(mic, "Clicked on Mic", driver);
        Assert.assertTrue(soundOffSymbol.get(0).isDisplayed(), " Mic is not mute");
        click(mic, " Clicked on mic", driver);
        Thread.sleep(2000);
        Assert.assertEquals(soundOffSymbol.size(), 0, "Mic is mute");
        utils.log().info("Mute Unmute functionality working fine");
        ExtentReport.getTest().log(Status.INFO, "Mute unmute functionality working fine");
    }
    public void verifyTheCameraShouldBeSisableWhileMakeTheMute(AppiumDriver driver) throws InterruptedException {
        click(menu, "Cliked on menu", driver);
        click(mic, "Clicked on Mic", driver);
        Thread.sleep(2000);
        Assert.assertTrue(playerAvatar.size()==1, "Camera is On");
        utils.log().info("Camera is Off");
        ExtentReport.getTest().log(Status.INFO, "Camera is Off");
        click(mic, "Clicked on Mic", driver);
        Thread.sleep(2000);
        Assert.assertTrue(playerAvatar.size()<1, "Camera is off");
        utils.log().info("Camera is On");
        ExtentReport.getTest().log(Status.INFO, "Camera is On");
    }

    public void verifyUserHaveEnteredRoom(AppiumDriver driver) {
        waitForVisibility(giftBox, driver);
        utils.log().info("Gift box is displayed and User Have Entered in Room");
        ExtentReport.getTest().log(Status.INFO, "Gift box is displayed and User have entered in room");
    }

    public String getTimerValue(AppiumDriver driver) {
        waitForVisibility(timer, driver);
        return getText(timer, "get timer value", driver).replace(":", "");
    }

    public void selectGiftAndClickonSendButton(AppiumDriver driver) throws InterruptedException {

    }

    public void checkGiftCoinLessThanActualCoin(String actualCoinValue, AppiumDriver driver) {
        click(iPLGiftOption.get(0), "Clicked on iplGiftOption", driver);
        String giftCoinValue = getText(punjabHelmetGift, " Get coins value of selected gift", driver);
        int m = Integer.parseInt(actualCoinValue);
        int n = Integer.parseInt(giftCoinValue);
        Assert.assertTrue(n < m, "Gift Coins values is not less than Actual Coins value So cannot send gift");
        ExtentReport.getTest().log(Status.INFO, "Gift Coins Value is less than Actual Coins value so cannot send gift");
        click(punjabHelmetGift, "Clicked on punjabHelmetGift", driver);
        click(sendButton, "Clicked on Send Button", driver);
    }

    public void clickOnExitButton(AppiumDriver driver) throws InterruptedException {
//        Thread.sleep(2000);
////        while (goOffLineCrossButton.size() < 1) {
//        clickBackButton(driver);
//        Thread.sleep(2000);
////        }
//        click(goOffLineCrossButton.get(0), "Clcked on goOfflineButton", driver);
//        utils.log().info("clicked on goOffline Button and return to training tab page");
//        ExtentReport.getTest().log(Status.INFO, "Clicked on goOffline Button and return to training tab page");

        Thread.sleep(3000);
        while (exitButton.size() < 1) {
            clickBackButton(driver);
        }
        click(exitButton.get(0), "Clicked on exit button", driver);
        if (callAgainButton.size() == 1) {
            clickBackButton(driver);
        }
        if (popupBackButton.size() == 1) {
            click(popupBackButton.get(0), driver);
        }

    }

    public void clickOnExitButton1(AppiumDriver driver) throws InterruptedException {
//        Thread.sleep(2000);
////        while (goOffLineCrossButton.size() < 1) {
//        clickBackButton(driver);
//        Thread.sleep(2000);
////        }
//        click(goOffLineCrossButton.get(0), "Clcked on goOfflineButton", driver);
//        utils.log().info("clicked on goOffline Button and return to training tab page");
//        ExtentReport.getTest().log(Status.INFO, "Clicked on goOffline Button and return to training tab page");

        Thread.sleep(5000);
            clickBackButton(driver);
        click(exitButton.get(0), "Clicked on exit button", driver);
        if (callAgainButton.size() == 1) {
            clickBackButton(driver);
        }
        if (popupBackButton.size() == 1) {
            click(popupBackButton.get(0), driver);
        }

    }

    public void hostExitRoom(AppiumDriver driver) throws InterruptedException {
        while (goOffLineCrossButton.size() < 1) {
            clickBackButton(driver);
        }
        click(goOffLineCrossButton.get(0), "Clcked on goOfflineButton", driver);
        utils.log().info("clicked on goOffline Button and return to training tab page");
        ExtentReport.getTest().log(Status.INFO, "Clicked on goOffline Button and return to training tab page");
    }

    public void clickOnStarRating(AppiumDriver driver) throws InterruptedException {
        Thread.sleep(2000);
        if (callAgainButton.size() == 1) {
            clickBackButton(driver);
        }
        if (popupBackButton.size() == 1) {
            click(popupBackButton.get(0), driver);
        }
        click(fifthStarRating, "Given Rating", driver);
    }

    public void verifyUserLeaveGameduringOnGame(AppiumDriver driver)
    {
        waitForVisibility(fifthStarRating,driver);
        Assert.assertTrue(fifthStarRating.isDisplayed(),"User not able to leave Game");
        utils.log().info("User is able to leave the Game during On Game");
        ExtentReport.getTest().log(Status.INFO,"User is able to leave the Game during On Game");
    }

    public void giveReviewMessage(AppiumDriver driver) throws InterruptedException {
        click(reviewTextBox, "Clicked on review TextBox", driver);
        sendKeys(reviewTextBox, "It was a great experience", "Shared the feedabck", driver);
    }

    public void clickOnSubmitButton(AppiumDriver driver) throws InterruptedException {
        click(submitButton, driver);
    }

    public void shareAppExperienceRating(AppiumDriver driver) throws InterruptedException {
        try {
            click(experienceStarRating, "Shared App Experience Rating", driver);
        }catch(Exception e )
        {

        }
    }

    public void verifyHostAbleToClickOnUserAvatar(AppiumDriver driver) throws InterruptedException {
        waitForClickable(userAvatarIcon, driver);
        click(userAvatarIcon, "Clicked on UserAvatarIcon", driver);
        waitForVisibility(profileLayout, driver);
        Assert.assertTrue(profileLayout.isDisplayed(), "Profile is not displayed");
        utils.log().info("Host is able to click on user Avatar");
        clickBackButton(driver);
    }

    public void hostRemoveUserFromTheRoom(AppiumDriver driver) throws InterruptedException {
        waitForClickable(userAvatarIcon, driver);
        click(userAvatarIcon, "Clicked on UserAvatarIcon", driver);
        click(removeLayout, "Clicked on remove layout", driver);
        click(removeButton, "Clicked on Remove Button", driver);
    }

    public void verfiyUserGotRemoveFromVideoCall(AppiumDriver driver) throws InterruptedException {
        Thread.sleep(5000);
        if (callAgainButton.size() == 1) {
            clickBackButton(driver);
        }
        if (popupBackButton.size() == 1) {
            click(popupBackButton.get(0), driver);
        }
        waitForVisibility(fifthStarRating, driver);
        Assert.assertTrue(fifthStarRating.isDisplayed(), "Host not able to remove user after clicking on remove button");
        utils.log().info("User have got removed from the voice call after host removed the user");
        ExtentReport.getTest().log(Status.INFO, "User have got remove from the video call after host removed the user");
    }

    public void hostBanTheUser(AppiumDriver driver) {
        click(userAvatarIcon, "clicked on User Avatar Icon", driver);
        click(banIcon, "Clicked on ban icon", driver);
        click(sexualTalkWarning, "Select sexual talk warning", driver);
       // scrollToElement(banButton, driver);
        click(banButton, "Clicked on ban button", driver);
        click(punishButton, "Clicked on Punish Button", driver);
        ExtentReport.getTest().log(Status.INFO, "Host Ban the user");
    }

    public void userGotTheWarning(AppiumDriver driver) {
        click(checkBox, "Clicked on checkBox", driver);
        click(iPromiseButton, "Clicked on iPromiseButton", driver);
        click(skipCrossButton, "Clicked on skip cross button", driver);
    }

    public void verfiyUserGotRemoveFromVoiceCall(AppiumDriver driver) throws InterruptedException {
        Thread.sleep(5000);
        if (callAgainButton.size() == 1) {
            clickBackButton(driver);
        }
        if (popupBackButton.size() == 1) {
            click(popupBackButton.get(0), driver);
        }
        waitForVisibility(fifthStarRating, driver);
        Assert.assertTrue(fifthStarRating.isDisplayed(), "Host not able to remove user after clicking on remove button");
        utils.log().info("User have got removed from the voice call after host removed the user");
        ExtentReport.getTest().log(Status.INFO, "User have got removed from the voice call after host removed the user");
    }

    public void verifyListOfFramesDisplayedWhenHostClickOnItsOwnAvatar(AppiumDriver driver)
    {
        click(userAvatarIcon,driver);
        waitForVisibility(framesList,driver);
        Assert.assertTrue(framesList.isDisplayed(),"List of frames not displayed");
        utils.log().info("List of Frames displayed");
        ExtentReport.getTest().log(Status.INFO,"List of Frames displayed");
    }
    public void verifyAfterClickingOnFrameBuyNowButtonDisplayedAndClickable(AppiumDriver driver) throws InterruptedException {
        click(new HostedVideoCallPage(driver).singleFrame, driver);
        Thread.sleep(1000);
        if (buyNowButton.size() == 1)
        {
            Assert.assertTrue(buyNowButton.get(0).isDisplayed(), "BuyNow button not displayed");
            utils.log().info("BuyNow button displayed");
            ExtentReport.getTest().log(Status.INFO, "BuyNow button displayed");
            click(buyNowButton.get(0), "Clicked on BuyNow Button", driver);
        }
        else if(applyFrameButton.size()==1)
        {
            Assert.assertTrue(applyFrameButton.get(0).isDisplayed(), "ApplyFrame button not displayed");
            utils.log().info("ApplyFrame button displayed");
            ExtentReport.getTest().log(Status.INFO, "ApplyFrame button displayed");
            click(applyFrameButton.get(0), "Clicked on ApplyFrame Button", driver);
        }
        clickBackButton(driver);
        waitForVisibility(userAvatarIcon,driver);
        Assert.assertTrue(userAvatarIcon.isDisplayed(),"Not able to click on BuyNow Button");
        utils.log().info("BuyNow button clickable");
        ExtentReport.getTest().log(Status.INFO,"BuyNow button clickable");
    }

    public void verifyGemAndCoinsIconDisplayedOnFrameWindow(AppiumDriver driver)
    {
        click(userAvatarIcon,driver);
        waitForVisibility(gemIcon,driver);
        Assert.assertTrue(gemIcon.isDisplayed() && coinsAmountIcon.isDisplayed(),"Gem and CoinsAmount icon not displayed" );
        utils.log().info("Gem and CoinsAmount icon displayed");
        ExtentReport.getTest().log(Status.INFO,"Gem and CoinsAmount icon displayed");
    }

    public void verifyIfSwitchToVideoCallOptionShouldNotBePresentUnderTripleDotOptionForBothHostAndUser(AppiumDriver driver) throws InterruptedException {
        click(threeDotMenu,driver);
        Thread.sleep(2000);
        Assert.assertTrue(videoSwitchIcon.size()<1,"VideoSwitchIcon is visible for User in Video Call");
        utils.log().info("VideoSwitchIcon is not visible for User in Video Call");
        ExtentReport.getTest().log(Status.INFO,"VideoSwitchIcon is not visible for User in Video Call");
    }

    public void verifyTheUserShouldBeAbleToEnableDisableOfSpeaker(AppiumDriver driver) throws InterruptedException {
        click(threeDotMenu,driver);
        Thread.sleep(2000);
        click(threeDotMenu,driver);
        click(volumeIcon,driver);
        utils.log().info("Speaker is disable");
        ExtentReport.getTest().log(Status.INFO,"Speaker is disable");
        Thread.sleep(2000);
        click(volumeIcon,driver);
        utils.log().info("Speaker is enable");
        ExtentReport.getTest().log(Status.INFO,"Speaker is enable");
    }

    public void CheckIfInGameRechargeReminderBottonSheetShouldDisplayOnLastThreeMins(AppiumDriver driver)
    {
        waitForVisibility(addTimeToAvoidCallLabel,driver);
        Assert.assertTrue(addTimeToAvoidCallLabel.isDisplayed(),"In Game Recharge Reminder is not displayed");
        utils.log().info("In Game Recharge Reminder is displayed");
        ExtentReport.getTest().log(Status.INFO,"In Game Recharge Reminder is displayed");
    }

    public void checkIfTheTimerCountdownShouldShowOnTheBottomSheetForLastThirdMin(AppiumDriver driver)
    {
       waitForVisibility(timerCountDown,driver);
       Assert.assertTrue(timerCountDown.isDisplayed(),"Timer CountDown is not displayed");
        utils.log().info("Timer CountDown is displayed");
        ExtentReport.getTest().log(Status.INFO,"Timer CountDown is displayed");
    }

    public void checkIfAddCoinxxOptionButtonAmountShouldChangeAsPerSelectedOutOfTheThreeTimeMins(AppiumDriver driver)
    {
        click(minuteOption1,driver);
        String txt = getText(amountLabel,"getting timer Amount",driver);
        int num = new HostedAudioCallPage(driver).getNumberFromString(txt);
        System.out.println(num);
        click(minuteOption2,driver);
        String txt1 = getText(amountLabel,"getting timer Amount",driver);
        int num1 = new HostedAudioCallPage(driver).getNumberFromString(txt1);
        System.out.println(num1);
        Assert.assertNotEquals(num,num1,"Amount not changing as per the selected package");
        utils.log().info("Amount is changing in Game Recharge Reminder As per the Selected Package");
        ExtentReport.getTest().log(Status.INFO,"Amount is changing in Game Recharge Reminder As per the Selected Package");
    }

    public void callTimerTextShouldShowInRedColourOnlyWhenUserIsInHisLastThreeMinOfVoiceCall(AppiumDriver driver)
    {
        waitForVisibility(callTimer,driver);
        Assert.assertTrue(callTimer.isDisplayed(),"CallTimer is not displayed");
        utils.log().info("CallTimer is displayed");
        ExtentReport.getTest().log(Status.INFO,"CallTimer is displayed");

    }
    public void verifyCannotAddExtraTimeInBottomSheetInLastMinuteemainingInVideoCall(AppiumDriver driver)
    {
        waitForVisibility(cannotAddExtraTimeMessage,driver);
        Assert.assertTrue(cannotAddExtraTimeMessage.isDisplayed(),"Cannot Add Extra Time is not Displayed");
        utils.log().info("Cannot Add Extra Time is displayed");
        ExtentReport.getTest().log(Status.INFO,"Cannot Add Extra Time is displayed");
    }
}
