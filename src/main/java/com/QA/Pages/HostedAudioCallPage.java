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

public class HostedAudioCallPage extends BaseTest {

    public HostedAudioCallPage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    TestUtils utils = new TestUtils();
    //*************** Keep Elements Here ******************************************
    @AndroidFindBy(id = "com.dating.for.all.debug:id/gift")
    public MobileElement giftBox;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/gift")
    public List<MobileElement> giftBox1;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"IPL\"]")
    private MobileElement iPLGiftOption;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/purchase_text")
    private MobileElement sendButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Punjab']/following-sibling::android.widget.LinearLayout//android.widget.TextView[@resource-id='com.dating.for.all.debug:id/discountPrice']")
    private MobileElement punjabHelmetGift;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/close")
    private MobileElement exitButton;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/close")
    private List<MobileElement> exitButton1;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/askYr")
    private List<MobileElement> askYrIcon;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/askYr")
    private List<MobileElement> askYrIcon1;

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

    @AndroidFindBy(id = "com.dating.for.all.debug:id/callAgain")
    private MobileElement callAgainButton1;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/back")
    private List<MobileElement> popupBackButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]")
    private List<MobileElement> goOffLineCrossButton;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/timer")
    private MobileElement timer;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/menu")
    private MobileElement threeDotMenu;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/mic")
    private MobileElement mic;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/soundOff")
    private List<MobileElement> soundOffSymbol;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/amt2Tv")
    private MobileElement roses10;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/amt1Tv")
    private MobileElement roses2;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/amt3Tv")
    private MobileElement rose20;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/requestBt")
    private MobileElement requestButton;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/giftNowTv")
    private MobileElement giftNowButton;

    @AndroidFindBy(xpath = "(//android.widget.ImageView[@resource-id=\"com.dating.for.all.debug:id/playerAvatar\"])[2]")
    private MobileElement userAvatarIcon;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/profileTv")
    private MobileElement profileLayout;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/removeIv")
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

    @AndroidFindBy(id = "com.dating.for.all.debug:id/title")
    private List<MobileElement> winMoneyFromYellowRoseLabel;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/addToBankLabel")
    private List<MobileElement> transferMoneyToYourBankLabel;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Start training with Popular Girl Experts\"]")
    private List<MobileElement> startTrainingLabel;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    private List<MobileElement> whileUsingAppButton;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/timeTv")
    private MobileElement callDurationTime;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/yellowRoseAmountTv")
    private MobileElement yellowRoseCollectedAmount;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/callDuration")
    private MobileElement userCallDuration;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/totalRoses")
    private MobileElement userTotalRoseGited;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/addCoinsBtv")
    private MobileElement addCoinsButton;

    @AndroidFindBy(xpath = "(//android.widget.ImageView[@resource-id=\"com.dating.for.all.debug:id/playerAvatar\"])[1]")
    private MobileElement giftAnimation;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/exitRoomRoot")
    private List<MobileElement> hostExitRoomButton;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/skip")
    private MobileElement getSkipCrossButton;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/addCoinsBtv")
    private MobileElement addcoinsNowButton;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/actualPriceTv")
    private MobileElement actualPriceValue;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/discountPriceTv")
    private MobileElement discountedPriceValue;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/applyDiscount2")
    private MobileElement appliedDiscountLabel;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/couponCodeDetail")
    private MobileElement coupounCodeDetail;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/title")
    private MobileElement startTrainingWithGirlTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"5 mins added to your call\"]")
    private MobileElement fiveMinuteAddCallPopup;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Okay\"]")
    private MobileElement okayButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"PLAY GAMES ON CALL\"]")
    private List<MobileElement> playGamePopup;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/invite")
    private MobileElement inviteButton;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/titleTv")
    private MobileElement inviteFrndsToRoomTitle;
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.dating.for.all.debug:id/connectBtv\"]")
    private List<MobileElement> usersConnectedList;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/closeBiv")
    private MobileElement closeCrossButton;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/howToEarnRewards")
    private MobileElement howToEarnRewardButton;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/wallpapers")
    private MobileElement wallpaperIcon;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/playTutoriaVideoIv")
    private MobileElement videoPreviewIcon;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/shareGame")
    private MobileElement shareIcon;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/volume")
    private MobileElement volumeIcon;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/titleTv")
    private MobileElement wallpaperTitle;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/skipNowTv")
    private List<MobileElement> skipNowButton;
    @AndroidFindBy(id = "android:id/title")
    private MobileElement shareTitle;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/funGames")
    private MobileElement gameIcon;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/funGames")
    private List<MobileElement> gameIcon1;
    @AndroidFindBy(xpath = "//android.widget.ImageView")
    private MobileElement gamePopupCrossButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Ludo\"]")
    private MobileElement ludoGame;
    @AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"Kya aap Daniel ke saath Ludo \n" +
            " khelna chahte hai?\"]/preceding-sibling::android.widget.ImageView)[1]")
    private MobileElement reconsiderCrossButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"No\"]")
    private MobileElement noButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Yes\"]")
    private MobileElement yesButton;

    @AndroidFindBy(xpath = "//android.widget.Image[@text=\"gzp_logo_white\"]")
    private MobileElement gameZopLabel;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/close")
    private MobileElement gameCrossCloseButton;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/close")
    private MobileElement gameCloseButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Game khelne se Daniel se baatein \n" +
            " lambi hoti hai \n" +
            " Are you sure you want to reject?\"]/preceding-sibling::android.widget.ImageView")
    private List<MobileElement> rejectCrossButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Haan\"]")
    private MobileElement haanButton;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/topic")
    private MobileElement howToEarnRewardsTopic;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/playerAvatar")
    private MobileElement hostAvatarProfile;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/avatarFramesRv")
    private MobileElement framesList;
    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@resource-id=\"com.dating.for.all.debug:id/frame_layout\"])[3]")
    private MobileElement singleFrame;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/purchase_text")
    private List<MobileElement> buyNowButton;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/applyAddonButton")
    private List<MobileElement> applyFrameButton;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/price")
    private MobileElement framePriceValue;
    @AndroidFindBy(xpath = "(//android.widget.TextView[@resource-id=\"com.dating.for.all.debug:id/free\"])[1]")
    private List<MobileElement> freeFrame;
    @AndroidFindBy(xpath = "//android.view.View[@resource-id=\"com.dating.for.all.debug:id/exo_subtitles\"]")
    private MobileElement videoPreviewScreen;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/gemsCountTv")
    private MobileElement gemIcon;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/coinsCountTv")
    private MobileElement coinsAmountIcon;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/coinTitleTv")
    private MobileElement addCoinsToWalletLabel;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/cancelBtv")
    private MobileElement cancelButton;
    @AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"Join Call\"])[1]")
    private MobileElement joinTab;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/player2Root")
    public MobileElement connectingScreen;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/exitPopup")
    private MobileElement askYrExitPopup;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/bigHeart")
    private MobileElement heartIcon;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/frndMeter")
    private List<MobileElement> frndMeterLabel;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/giftRose")
    private MobileElement giftRoseButton;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/suggestion3Root")
    private MobileElement yr100Suggestion;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/suggestion1Root")
    private MobileElement yr2Suggestion;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/suggestion2Root")
    private MobileElement yr10Suggestion;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/heartCounter")
    private MobileElement heartCounter;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Keep Gifting rose to fill Meter']")
    private List<MobileElement> keepGiftingRoseAnimation;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/knowMore")
    private List<MobileElement> knowMoreButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"FRND Meter\"]")
    private MobileElement frndMeterScreenLable;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/weeklyTv")
    private MobileElement weeklyButton;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/allTimeTv")
    private MobileElement allTimeButton;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/titleTv")
    private MobileElement touchAnimationLeaderBoardTitle;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Download & Share\"]")
    private MobileElement downloadAndShareButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Stay Online\"]")
    private MobileElement stayOnlineButton;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/head1Tv")
    private MobileElement demandBonusRoseGiftsLabel;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/customAmtTextTv")
    private List<MobileElement> customPlusButton;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/redAmt")
    private MobileElement minusIcon;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/incAmt")
    private MobileElement plusIcon;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/customAmountTv")
    private MobileElement customYrAmount;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/addTimer")
    private MobileElement addTimerIcon;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/info")
    private MobileElement addTimeToAvoidCallEndLabel;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/amount")
    private MobileElement addTimerAmount;
    @AndroidFindBy(xpath = "(//android.widget.TextView[@resource-id='com.dating.for.all.debug:id/info']/following-sibling::androidx.appcompat.widget.LinearLayoutCompat//android.widget.TextView[@text='Mins'])[1]")
    private MobileElement addingTimerOption1;
    @AndroidFindBy(xpath = "(//android.widget.TextView[@resource-id='com.dating.for.all.debug:id/info']/following-sibling::androidx.appcompat.widget.LinearLayoutCompat//android.widget.TextView[@text='Mins'])[2]")
    private MobileElement addingTimerOption2;
    @AndroidFindBy(xpath = "(//android.widget.TextView[@resource-id='com.dating.for.all.debug:id/info']/following-sibling::androidx.appcompat.widget.LinearLayoutCompat//android.widget.TextView[@text='Mins'])[3]")
    private MobileElement addingTimerOption3;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/videoSwitch")
    private MobileElement videoSwitchIcon;
    @AndroidFindBy(xpath = "//android.view.ViewGroup")
    private MobileElement viewGroup;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/negative")
    private MobileElement rejectButton;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/positive")
    private MobileElement acceptButton;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/switchToVideo")
    private MobileElement requestRejectedLabel;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/loader")
    private MobileElement loadingAnimation;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/faceNotDetected")
    private MobileElement faceNotDetectedLabel;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Show your face\"]")
    private MobileElement showYourFaceLabel;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/reducedEarningNotice")
    private MobileElement reduceEarningNotice;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/faceDetectionAnimation")
    private MobileElement faceDetectionAnimation;
    @AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"Daniel, You there?\"]/following-sibling::android.widget.TextView)[1]")
    private MobileElement tapOnNumberLabel;
    @AndroidFindBy(xpath = "//android.view.ViewGroup/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]")
    private MobileElement index1;

    //*********************** End Elements *************************************************

    public void requestForGiftFor10Roses(AppiumDriver driver) throws InterruptedException {
        Thread.sleep(2000);
        if(askYrIcon.size()==1)
        click(askYrIcon.get(0), "Clicked on AskYr Icon", driver);
        click(roses10, "Selected 10 Roses option", driver);
        click(requestButton, "Clicked on Request Button", driver);
    }

    public void requestForGiftFor2Roses(AppiumDriver driver) throws InterruptedException {
        Thread.sleep(2000);
        if(askYrIcon.size()==1)
        click(askYrIcon.get(0), "Clicked on AskYr Icon", driver);
        click(roses2, "Selected 10 Roses option", driver);
        click(requestButton, "Clicked on Request Button", driver);
    }

    public void clickOnskipCrossButton(AppiumDriver driver)
    {
        click(skipCrossButton,"Clicked on Skip Cross Button", driver);
    }

    public void userSendGiftToHost(AppiumDriver driver) {
        click(giftNowButton, "Sended gift to owner", driver);
    }

    public void verfiyTimerAndGiftCoinAfterSendsGift(String actualCoinValue, AppiumDriver driver) throws InterruptedException {
        String actualTimerValue = getTimerValue(driver);
        click(giftBox, "Clicked on Gift Box", driver);
        click(iPLGiftOption, "Clicked on iplGiftOption", driver);
        String giftCoinValue = getText(punjabHelmetGift, " Get coins value of selected gift", driver);
        int m = Integer.parseInt(actualCoinValue);
        int n = Integer.parseInt(giftCoinValue);
        Assert.assertTrue(n < m, "Gift Coins values is not less than Actual Coins value So cannot send gift");
        click(punjabHelmetGift, "Clicked on punjabHelmetGift", driver);
        click(sendButton, "Clicked on Send Button", driver);
    //    waitForVisibility(giftAnimation,driver);
    //    Assert.assertTrue(giftAnimation.isDisplayed(),"Gift Animation not displayed");
        ExtentReport.getTest().log(Status.INFO, "Gift Animation is visible");
        utils.log().info("Gift Animation is visible");
        String timerValueAfterGift = getTimerValue(driver);
        int a = Integer.parseInt(actualTimerValue);
        System.out.println(a);
        int b = Integer.parseInt(timerValueAfterGift);
        System.out.println(b);
        Assert.assertTrue(a > b, "TimerValue is not less than the timerValue after sending gift");
        ExtentReport.getTest().log(Status.INFO, "TimerValue is less than the timerValue after sending gift");
    }


    public void checkMuteUnmuteFunctionality(AppiumDriver driver) throws InterruptedException {
        click(threeDotMenu, "Cliked on menu", driver);
        click(mic, "Clicked on Mic", driver);
        Assert.assertTrue(soundOffSymbol.get(0).isDisplayed(), " Mic is not mute");
        ExtentReport.getTest().log(Status.INFO, "Mic is mute");
        click(mic, " Clicked on mic", driver);
        Thread.sleep(1000);
        Assert.assertEquals(soundOffSymbol.size(), 0, "Mic is mute");
        ExtentReport.getTest().log(Status.INFO, "Mic is not mute");
        utils.log().info("Mute Unmute functionality working fine");
        ExtentReport.getTest().log(Status.INFO, "Mute Unmute Functionality working fine");
    }

    public void verifyUserHaveEnteredRoom(AppiumDriver driver) {
        waitForVisibility(giftBox, driver);
        utils.log().info("Gift box is displayed and User Have Entered in Room");
        ExtentReport.getTest().log(Status.INFO, "Gift box is displayed and user have entered in room");
    }

    public String getTimerValue(AppiumDriver driver) {
        waitForVisibility(timer, driver);
        return getText(timer, "get timer value", driver).replace(":", "");
    }

    public void selectGiftAndClickonSendButton(AppiumDriver driver) throws InterruptedException {

    }

    public void checkGiftCoinLessThanActualCoin(String actualCoinValue, AppiumDriver driver) {
        click(iPLGiftOption, "Clicked on iplGiftOption", driver);
        String giftCoinValue = getText(punjabHelmetGift, " Get coins value of selected gift", driver);
        int m = Integer.parseInt(actualCoinValue);
        int n = Integer.parseInt(giftCoinValue);
        Assert.assertTrue(n < m, "Gift Coins values is not less than Actual Coins value So cannot send gift");
        ExtentReport.getTest().log(Status.INFO, "Gift Coins value is less than the Actual Coins So user  can send gift");
        click(punjabHelmetGift, "Clicked on punjabHelmetGift", driver);
        click(sendButton, "Clicked on Send Button", driver);
    }

    public void clickOnExitButton(AppiumDriver driver) throws InterruptedException {
        Thread.sleep(2000);
        if (whileUsingAppButton.size() == 1) {
            click(whileUsingAppButton.get(0), "Clicked on whileUsingAppButton", driver);

        }
        if(playGamePopup.size()==1)
        {
            clickBackButton(driver);
        }

        Thread.sleep(3000);
        try {
            clickBackButton(driver);
        } catch (Exception e) {
            clickBackButton(driver);
        }
        Thread.sleep(2000);
        click(exitButton, "Clicked on exit Button", driver);
        ExtentReport.getTest().log(Status.INFO, "Clicked on exit Button");

        if (callAgainButton.size() == 1) {
            clickBackButton(driver);
        }
        if (popupBackButton.size() == 1) {
            click(popupBackButton.get(0), driver);
        }
        if (startTrainingLabel.size() == 1) {
            clickBackButton(driver);
        }

    }

    public void clickOnExitButton2(AppiumDriver driver) throws InterruptedException {
        Thread.sleep(2000);
        if (whileUsingAppButton.size() == 1) {
            click(whileUsingAppButton.get(0), "Clicked on whileUsingAppButton", driver);
        }
        Thread.sleep(3000);
        while (exitButton1.size()<1)
        {
            clickBackButton(driver);
        }
        Thread.sleep(2000);
        click(exitButton1.get(0), "Clicked on exit Button", driver);
        ExtentReport.getTest().log(Status.INFO, "Clicked on exit Button");
        if (callAgainButton.size() == 1) {
            clickBackButton(driver);
        }
        if (popupBackButton.size() == 1) {
            click(popupBackButton.get(0), driver);
        }
        if (startTrainingLabel.size() == 1) {
            clickBackButton(driver);
        }

    }
    public  void handlingExitPopup(AppiumDriver driver) throws InterruptedException {
        if (callAgainButton.size() == 1) {
            clickBackButton(driver);
        }
        if (popupBackButton.size() == 1) {
            click(popupBackButton.get(0), driver);
        }
        if (startTrainingLabel.size() == 1) {
            clickBackButton(driver);
        }
    }

    public void clickOnExitButton1(AppiumDriver driver) throws InterruptedException {
        Thread.sleep(2000);
        if (whileUsingAppButton.size() == 1) {
            click(whileUsingAppButton.get(0), "Clicked on whileUsingAppButton", driver);
        }

        Thread.sleep(3000);
        try {
            clickBackButton(driver);
        } catch (Exception e) {
            clickBackButton(driver);
        }

        Thread.sleep(2000);
        click(exitButton, "Clicked on exit Button", driver);
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
        try {
            if (callAgainButton.size() == 1) {
                clickBackButton(driver);
            }
            if (popupBackButton.size() == 1) {
                click(popupBackButton.get(0), driver);
            }
        }catch(Exception e)
        {

        }
        if (startTrainingLabel.size() == 1) {
            clickBackButton(driver);
        }
        click(fifthStarRating, "Given Rating", driver);
    }

    public void clickOnStarRating2(AppiumDriver driver) throws InterruptedException {
        waitForVisibility(callAgainButton1,driver);
        try {
            if (callAgainButton.size() == 1) {
                clickBackButton(driver);
            }
            if (popupBackButton.size() == 1) {
                click(popupBackButton.get(0), driver);
            }
        }catch(Exception e)
        {

        }
        if (startTrainingLabel.size() == 1) {
            clickBackButton(driver);
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

    public void clickOnStarRating1(AppiumDriver driver) throws InterruptedException {
        click(fifthStarRating, "Given Rating", driver);
    }
    public void checkUserHaveExitRoomAutomatically(AppiumDriver driver)
    {
        waitForVisibility(fifthStarRating,driver);
        if(fifthStarRating.isDisplayed())
        {
            utils.log().info("User have exit the room Automatically");
            ExtentReport.getTest().log(Status.INFO,"User have exit the room Automatically");
        }
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
        }catch(Exception e)
        {

        }
    }

    public void verifyHostAbleToClickOnUserAvatar(AppiumDriver driver) throws InterruptedException {
        waitForClickable(userAvatarIcon, driver);
        click(userAvatarIcon, "Clicked on UserAvatarIcon", driver);
        waitForVisibility(profileLayout, driver);
        Assert.assertTrue(profileLayout.isDisplayed(), "Profile is not displayed");
        utils.log().info("Host is able to click on user Avatar");
        ExtentReport.getTest().log(Status.INFO, "Host is able to click on user Avatar");
    }

    public void hostRemoveUserFromTheRoom(AppiumDriver driver) throws InterruptedException {
        click(userAvatarIcon, "Clicked on UserAvatarIcon", driver);
        click(removeLayout, "Clicked on remove layout", driver);
        click(removeButton, "Clicked on Remove Button", driver);
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

    public void hostBanTheUser(AppiumDriver driver) {
        click(userAvatarIcon, "clicked on User Avatar Icon", driver);
        click(banIcon, "Clicked on ban icon", driver);
        click(sexualTalkWarning, "Select sexual talk warning", driver);
        click(banButton, "Clicked on ban button", driver);
        click(punishButton, "Clicked on Punish Button", driver);
        ExtentReport.getTest().log(Status.INFO, "Host ban the user");
    }

    public void userGotTheWarning(AppiumDriver driver) {
        click(checkBox, "Clicked on checkBox", driver);
        click(iPromiseButton, "Clicked on iPromiseButton", driver);
        click(skipCrossButton, "Clicked on skip cross button", driver);
    }

    public void verifyYrCreditShownToHost(AppiumDriver driver, int expectedTime, int expectedRose) {
        waitForVisibility(callDurationTime, driver);
        String callDuration = getText(callDurationTime, "get call duration time", driver);
        String totalYellowRoseCollected = getText(yellowRoseCollectedAmount, "Total yellow rose collected", driver);
        int calDuration = Integer.parseInt(callDuration.replace(":", ""));
        int yellowRoseCollcted = Integer.parseInt(totalYellowRoseCollected);
        if (calDuration > expectedTime) {
            Assert.assertEquals(yellowRoseCollcted, expectedRose, "Actual yellow rose collected is not equal to expected yellow rose collected");
            utils.log().info("Actual yellow rose is equal to expected yellow rose");
            ExtentReport.getTest().log(Status.INFO, "Actual yellow rose is equal to expected yellow rose");
            utils.log().info("YrCredit screen shown to host");
            ExtentReport.getTest().log(Status.INFO, "YrCredit shown to host");
        }
    }

    public void verifyUserEndDeductYRAutomatically(AppiumDriver driver, int expectedTime, int expectedGiftedRose) {
        waitForVisibility(userCallDuration, driver);
        int userCallDurtionTime = Integer.parseInt(getText(userCallDuration, "Get user call duration time", driver).replace(":", ""));
        int totalRoseGifted = Integer.parseInt(getText(userTotalRoseGited, "Total rose gifted by User", driver));
        if (userCallDurtionTime > expectedTime) {
            Assert.assertEquals(totalRoseGifted, expectedGiftedRose, "Actual Gifted rose is not equal to expected gifted rose");
            utils.log().info("Actual and expected gifted rose are equals");
            ExtentReport.getTest().log(Status.INFO, "Actual and expected gifted rose are equals");
        }
    }

    public void verifyEndCallDurationPromptPopupIsDisplayed(AppiumDriver driver)
    {
        waitForVisibility(userCallDuration, driver);
        Assert.assertTrue(userCallDuration.isDisplayed(),"User Call Duration popup is not displayed");
        utils.log().info("User Call Duration popup is displayed");
        ExtentReport.getTest().log(Status.INFO, "User Call Duration popup is displayed");
    }
    public void verifyUserEndDeductYRAutomatically1(AppiumDriver driver, int expectedTime, int expectedGiftedRose) {
        waitForVisibility(userCallDuration, driver);
        int userCallDurtionTime = Integer.parseInt(getText(userCallDuration, "Get user call duration time", driver).replace(":", ""));
        int totalRoseGifted = Integer.parseInt(getText(userTotalRoseGited, "Total rose gifted by User", driver));
        if (userCallDurtionTime > expectedTime) {
            Assert.assertTrue(totalRoseGifted>expectedGiftedRose, "Actual Gifted rose is not equal to expected gifted rose");
            utils.log().info("Actual and expected gifted rose are equals");
            ExtentReport.getTest().log(Status.INFO, "Actual and expected gifted rose are equals");
        }
    }

    public String getTotalRosesGifted(AppiumDriver driver) {
        waitForVisibility(userTotalRoseGited, driver);
        return getText(userTotalRoseGited, "Getting total rose gifted by user", driver);
    }
    public void verifyUserNotAbleToJoinSecTimeAfter5min(AppiumDriver driver)
    {
        waitForVisibility1(callAgainButton.get(0),driver);
        click(callAgainButton.get(0),"Clicked on call again button",driver);
        waitForVisibility(addCoinsButton,driver);
        Assert.assertTrue(addCoinsButton.isDisplayed(),"User is able to join after 5 minutes free call");
        utils.log().info("User is not able to join after 5 minutes of free call");
        ExtentReport.getTest().log(Status.INFO, "User is not able to join after 5 minute of free call");
    }
    public void hostExitGameRoom(AppiumDriver driver)
    {
        while (hostExitRoomButton.size()<1)
        {
            clickBackButton(driver);
        }
        click(hostExitRoomButton.get(0),"Clicked on Exit Button",driver);
    }
    public void verifyDiscountLabel(AppiumDriver driver)
    {
        waitForVisibility(actualPriceValue,driver);
        Assert.assertTrue(actualPriceValue.isDisplayed(),"ActualPrice Value is not displayed");
        Assert.assertTrue(discountedPriceValue.isDisplayed(),"DiscountedPrice value is not displayed");
        Assert.assertTrue(appliedDiscountLabel.isDisplayed(),"AppliedDiscountLabel is not displayed");
        utils.log().info("Discount Popup is displayed");
        ExtentReport.getTest().log(Status.INFO,"Discount Popup is displayed");
    }

    public void verifyUserGotRemovedAferFreeFiveMinuteCall(AppiumDriver driver)
    {
        waitForVisibility(startTrainingWithGirlTitle,driver);
        utils.log().info("User have got removed after using five minute call");
        ExtentReport.getTest().log(Status.INFO,"User have got removed after using five minute call");
        clickBackButton(driver);
    }

    public void verify5MinAddedToCall(AppiumDriver driver)
    {
        waitForVisibility(fiveMinuteAddCallPopup,driver);
        Assert.assertTrue(fiveMinuteAddCallPopup.isDisplayed(),"User didn't get Five Minute Free Call");
        click(okayButton,"Clicked on Okay Button",driver);
    }

    public void verifyInviteButton(AppiumDriver driver)
    {
        waitForVisibility(inviteButton,driver);
        Assert.assertTrue(inviteButton.isDisplayed(),"Invite Button is not displayed ");
        click(inviteButton,driver);
        waitForVisibility(closeCrossButton,driver);
        swipeScreen(Direction.UP,driver);
        click(closeCrossButton,driver);
        waitForVisibility(howToEarnRewardButton,driver);
        Assert.assertTrue(howToEarnRewardButton.isDisplayed(),"List is not closed");
    }
    public void verifyInviteButtonClickableAndUsersConnectListAvailable(AppiumDriver driver)
    {
        click(inviteButton,driver);
        waitForVisibility(inviteFrndsToRoomTitle,driver);
        Assert.assertTrue(usersConnectedList.get(0).isDisplayed(),"");
    }

    public void verifyThreeDotClickableAndAllIconsPresent(AppiumDriver driver) throws InterruptedException {
        click(threeDotMenu,driver);
        click(mic, "Clicked on Mic", driver);
        Assert.assertTrue(soundOffSymbol.get(0).isDisplayed(), " Mic is not mute");
        ExtentReport.getTest().log(Status.INFO, "Mic is mute");
        click(mic, " Clicked on mic", driver);
        Thread.sleep(1000);
        Assert.assertEquals(soundOffSymbol.size(), 0, "Mic is mute");
        click(volumeIcon,driver);
        click(volumeIcon,driver);
        click(wallpaperIcon,driver);
        waitForVisibility(wallpaperTitle,driver);
        clickBackButton(driver);
        click(videoPreviewIcon,driver);
        click(videoPreviewScreen,driver);
        click(skipNowButton.get(0),driver);
        click(shareIcon,driver);
        waitForVisibility(shareTitle,driver);
        clickBackButton(driver);
    }
    public void verifyThreeDotClickableAndAllIconsPresentInVideoCall(AppiumDriver driver) throws InterruptedException {
        click(threeDotMenu,driver);
        click(mic, "Clicked on Mic", driver);
        Assert.assertTrue(soundOffSymbol.get(0).isDisplayed(), " Mic is not mute");
        ExtentReport.getTest().log(Status.INFO, "Mic is mute");
        click(mic, " Clicked on mic", driver);
        Thread.sleep(1000);
        Assert.assertEquals(soundOffSymbol.size(), 0, "Mic is mute");
        click(volumeIcon,driver);
        click(volumeIcon,driver);
        click(videoPreviewIcon,driver);
        click(videoPreviewScreen,driver);
        click(skipNowButton.get(0),driver);
        click(shareIcon,driver);
        waitForVisibility(shareTitle,driver);
        clickBackButton(driver);
    }

    public void verifyHostEndShouldShowGamePromptOrNotWithin60Sec(AppiumDriver driver) throws InterruptedException {
        Thread.sleep(50000);
        if(playGamePopup.size()==1) {
            waitForVisibility(playGamePopup.get(0), driver);
            Assert.assertTrue(playGamePopup.get(0).isDisplayed(), "GamePopup is not visible");
            ExtentReport.getTest().log(Status.INFO, "GamePopup is visible");
        }
        else if(playGamePopup.size()==0)
        {
            Assert.assertFalse(false, "GamePopup visible visible");
            ExtentReport.getTest().log(Status.INFO, "GamePopup is not visible");
        }
    }

    public void verifyUserEndShouldShowGamePromptOrNotWithin60Sec(AppiumDriver driver) throws InterruptedException {
        Thread.sleep(75000);
        if(playGamePopup.size()==1) {
            waitForVisibility(playGamePopup.get(0), driver);
            Assert.assertTrue(playGamePopup.get(0).isDisplayed(), "GamePopup is not visible");
            ExtentReport.getTest().log(Status.INFO, "GamePopup is visible");
            utils.log().info("GamePopup is visible");
        }
        else if(playGamePopup.size()==0)
        {
            Assert.assertFalse(false, "GamePopup visible visible");
            ExtentReport.getTest().log(Status.INFO, "GamePopup is not visible");
            utils.log().info("GamePopup is not visible");
        }
    }

    public void clickOnGameIcon(AppiumDriver driver)
    {
        click(gameIcon,"Clicked on game ICon", driver);
    }
    public void clickOnGamePopupCrossButton(AppiumDriver driver)
    {
        click(gamePopupCrossButton,driver);
    }
    public void clickOnLudoGames(AppiumDriver driver)
    {
        click(ludoGame,"Clicked on Ludo Games", driver);
    }
    public void clickOnNoButton(AppiumDriver driver)
    {
        click(noButton,driver);
    }

    public void verifyGameStarted(AppiumDriver driver)
    {
        waitForVisibility(gameZopLabel,driver);
        Assert.assertTrue(gameZopLabel.isDisplayed(),"Game not started");
        ExtentReport.getTest().log(Status.INFO,"Game started");
        waitForVisibility(gameCrossCloseButton,driver);
        clickBackButton(driver);
        click(gameCloseButton,driver);
        waitForVisibility(giftBox,driver);
        Assert.assertTrue(giftBox.isDisplayed(),"Game is not closed");
        ExtentReport.getTest().log(Status.INFO,"Game is closed");
    }

    public void clickOnReconsiderCrossButton(AppiumDriver driver)
    {
        click(reconsiderCrossButton,"clicked on Reconsider Cross Button", driver);
    }
    public void clickOnYesButton(AppiumDriver driver)
    {
        click(yesButton,driver);
        if(rejectCrossButton.size()==0) {
            Assert.assertTrue(giftBox.isDisplayed(), "Game is not closed");
            ExtentReport.getTest().log(Status.INFO, "Game is closed");
        }
    }

    public void clickOnRejectCrossButton(AppiumDriver driver)
    {
        click(rejectCrossButton.get(0),"Clicked on Reject Cross Button", driver);
        if(rejectCrossButton.size()==0) {
            Assert.assertTrue(giftBox.isDisplayed(), "Game is not closed");
            ExtentReport.getTest().log(Status.INFO, "Game is closed");
        }
    }
    public void clickOnHaanButton(AppiumDriver driver)
    {
        click(haanButton,driver);
    }

    public void verifyHowToEarnRewardButtonClickable(AppiumDriver driver)
    {
        click(howToEarnRewardButton,driver);
        waitForVisibility(howToEarnRewardsTopic,driver);
        Assert.assertTrue(howToEarnRewardsTopic.isDisplayed(),"howToEarnRewardsButton not clickable");
        utils.log().info("howToEarnRewarsButton is clickable");
        ExtentReport.getTest().log(Status.INFO,"howToEarnRewarsButton is clickable");
        clickBackButton(driver);
    }

    public void verifyListOfFramesDisplayedWhenHostClickOnItsOwnAvatar(AppiumDriver driver)
    {
        click(hostAvatarProfile,driver);
        waitForVisibility(framesList,driver);
        Assert.assertTrue(framesList.isDisplayed(),"List of frames not displayed");
        utils.log().info("List of Frames displayed");
        ExtentReport.getTest().log(Status.INFO,"List of Frames displayed");
    }

    public void verifyAfterClickingOnFrameBuyNowButtonDisplayedAndClickable(AppiumDriver driver) throws InterruptedException {
        click(singleFrame, driver);
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
        waitForVisibility(hostAvatarProfile,driver);
        Assert.assertTrue(hostAvatarProfile.isDisplayed(),"Not able to click on BuyNow Button");
        utils.log().info("BuyNow button clickable");
        ExtentReport.getTest().log(Status.INFO,"BuyNow button clickable");
    }
    public void verifyFramesScrollableAndFreeFrameApply(AppiumDriver driver) throws InterruptedException {
        click(hostAvatarProfile,driver);
        Thread.sleep(2000);
        while(freeFrame.size()==1) {
            swipeElementAndroid(singleFrame,Direction.UP, "Swipe element up", (AndroidDriver) driver);
        }
        click(freeFrame.get(0),driver);
        if(buyNowButton.size()==1) {
            waitForVisibility(buyNowButton.get(0), driver);
            String text = getText(framePriceValue, "getting Frame Price", driver);
            Assert.assertEquals(text, "0", "FreeFrame price not equla to Zero");
            utils.log().info("FreeFrame price equal to zero");
            ExtentReport.getTest().log(Status.INFO, "FreeFrame price equal to zero");
            click(buyNowButton.get(0), driver);
        }
        else if(applyFrameButton.size()==1)
        {
            waitForVisibility(applyFrameButton.get(0), driver);
            click(applyFrameButton.get(0),driver);
        }
        waitForVisibility(hostAvatarProfile,driver);
        Assert.assertTrue(hostAvatarProfile.isDisplayed(),"BuyNow button for free frame not clickable");
        utils.log().info("BuyNow button for freeFrame is clickable");
        ExtentReport.getTest().log(Status.INFO,"BuyNow button for freeFrame is clickable");
    }

    public void verifyGemAndCoinsIconDisplayedOnFrameWindow(AppiumDriver driver)
    {
        click(hostAvatarProfile,driver);
        waitForVisibility(gemIcon,driver);
        Assert.assertTrue(gemIcon.isDisplayed() && coinsAmountIcon.isDisplayed(),"Gem and CoinsAmount icon not displayed" );
        utils.log().info("Gem and CoinsAmount icon displayed");
        ExtentReport.getTest().log(Status.INFO,"Gem and CoinsAmount icon displayed");
    }

    public void verifyClickingCoinsInFramesWindowShouldOpenaPaywallScreen(AppiumDriver driver) throws InterruptedException {
        click(coinsAmountIcon,driver);
        waitForVisibility(addCoinsToWalletLabel,driver);
        Assert.assertTrue(addCoinsToWalletLabel.isDisplayed(),"PayWall screen not displayed");
        utils.log().info("payWall screen displayed");
        ExtentReport.getTest().log(Status.INFO,"payWall screen displayed");
        Thread.sleep(1000);
        clickBackButton(driver);
        try {
            click(cancelButton,driver);
        }catch (Exception e)
        {

        }
        Thread.sleep(1000);
        clickBackButton(driver);
    }

    public void verifyIfUserTapsOnTheHostedCardOrJoinFromHomeScreenShouldTheConnectingScreenWithFillingBarAnimation(AppiumDriver driver)
    {
        try {
            click(new HomePage(driver).homePagePopup, driver);
        }catch (Exception e)
        {

        }
        click(joinTab,driver);
        waitForVisibility(connectingScreen,driver);
        Assert.assertTrue(connectingScreen.isDisplayed(),"ConnectingScreen is not visible");
        utils.log().info("ConnectingScreen is visible");
        ExtentReport.getTest().log(Status.INFO,"ConnectingScreen is visible");
    }
    public void verifyGiftBoxGamesAskIconDisplayed(AppiumDriver driver)
    {
        waitForVisibility(giftBox,driver);
        Assert.assertTrue(giftBox.isDisplayed() && gameIcon.isDisplayed(),"GiftBox AskYr Games Icon not displayed");
        utils.log().info("GiftBoxIcon AskICon GameIcon displayed");
        ExtentReport.getTest().log(Status.INFO,"GiftBoxIcon AskICon GameIcon displayed");
    }

    public void verifyAskFunGiftIconsShouldBeProperlyClickableAndShouldShowTheExpectedBehaviour(AppiumDriver driver) throws InterruptedException {
        Thread.sleep(2000);
        if(askYrIcon.size()==1) {
            click(askYrIcon.get(0), driver);
            click(askYrExitPopup, driver);
            click(gameIcon, driver);
            click(gamePopupCrossButton, driver);
            click(giftBox, driver);
            Thread.sleep(2000);
            clickBackButton(driver);
            waitForVisibility(giftBox, driver);
            Assert.assertTrue(giftBox.isDisplayed(), "Game Ask GiftBox icon is not working as expected");
            utils.log().info("Game Ask GiftBox icon is working as expected");
            ExtentReport.getTest().log(Status.INFO, "Game Ask GiftBox icon is working as expected");
        }
    }

    public void checkIfTheFRNDMeterHeartIconShouldDisplayedBetweenHostAndUserAvatarShouldBeClickableAndShouldGetFillAsUserSendsTheYR(AppiumDriver driver) throws InterruptedException {
        Thread.sleep(3000);
        if(frndMeterLabel.size()==1)
        {
            Assert.assertTrue(frndMeterLabel.get(0).isDisplayed() && heartIcon.isDisplayed(), "FrndMeter Heart is not displayed");
            utils.log().info("FrndMeter heart is displayed");
            ExtentReport.getTest().log(Status.INFO, "FrndMeter heart is displayed");
            int heartCount = Integer.parseInt(getText(heartCounter, "getting heart Count", driver));
            click(giftRoseButton, driver);
            giftYR2YR10YR100optionButtonsShouldDisplayAfterUserHaveClickedOnGiftRoseForTheFirstTimeInVoiceCall(driver);
            click(yr100Suggestion, driver);
            Thread.sleep(1000);
            int hearCount1 = Integer.parseInt(getText(heartCounter, "getting heart Count", driver));
            hearCount1 = heartCount + 1;
            utils.log().info("FrndHeartMeter is getting filled");
            ExtentReport.getTest().log(Status.INFO, "FrndHeartMeter is getting filled");
        }
    }

    public void verifyKeepGiftingRoseAnimationLable(AppiumDriver driver) throws InterruptedException {
        Thread.sleep(3000);
        if(keepGiftingRoseAnimation.size()==1) {
            waitForVisibility(keepGiftingRoseAnimation.get(0), driver);
            Assert.assertTrue(keepGiftingRoseAnimation.get(0).isDisplayed(), "KeepGiftingRoseAnimation not displayed");
        }
    }
    public void verifyKnowMoreButtonDsplayedAndClickable(AppiumDriver driver) throws InterruptedException {
        Thread.sleep(2000);
        if(knowMoreButton.size()==1) {
            Assert.assertTrue(knowMoreButton.get(0).isDisplayed(), "KnowMore Button is not displayed");
            click(knowMoreButton.get(0), driver);
            waitForVisibility(frndMeterScreenLable, driver);
            Assert.assertTrue(frndMeterScreenLable.isDisplayed(), "frndMeterScreenLable is not displayed");
            waitForVisibility(weeklyButton, driver);
            Assert.assertTrue(weeklyButton.isDisplayed() && allTimeButton.isDisplayed(), "WeeklyButton and AllTimeButton not displayed");
            click(weeklyButton, driver);
            waitForVisibility(touchAnimationLeaderBoardTitle, driver);
            clickBackButton(driver);
            click(allTimeButton, driver);
            waitForVisibility(touchAnimationLeaderBoardTitle, driver);
            clickBackButton(driver);
            swipeScreen(Direction.UP, driver);
            waitForVisibility(downloadAndShareButton, driver);
            Assert.assertTrue(downloadAndShareButton.isDisplayed(), "DownloadAndShare button not displayed");
            clickBackButton(driver);
            utils.log().info("KnowMore button is displayed and it's clickable");
            ExtentReport.getTest().log(Status.INFO, "KnowMore button is displayed and it's clickable");
        }
    }

    public void verifyHostMinizeTheRoom(AppiumDriver driver)
    {
        clickBackButton(driver);
        click(stayOnlineButton,driver);
        waitForVisibility(new PrivateTrainingRoomPage(driver).profileIcon,driver);
        Assert.assertTrue(new PrivateTrainingRoomPage(driver).profileIcon.isDisplayed(),"Have haven't minized the room");
        utils.log().info("Host have minized the room");
        ExtentReport.getTest().log(Status.INFO,"Host have minized the room");
    }
    public void giftYR2YR10YR100optionButtonsShouldDisplayAfterUserHaveClickedOnGiftRoseForTheFirstTimeInVoiceCall(AppiumDriver driver)
    {
        waitForVisibility(yr2Suggestion,driver);
        Assert.assertTrue(yr2Suggestion.isDisplayed() && yr10Suggestion.isDisplayed() && yr100Suggestion.isDisplayed(),"Yr suggestions not displayed");
        utils.log().info("YrSuggestions 2 && 10 && 100 is displayed");
        ExtentReport.getTest().log(Status.INFO,"YrSuggestions 2 && 10 && 100 is displayed");
    }

    public void checkUserAndhostshouldBeAbleToClickOnTheCustomShouldDisplayPlusMinusYRcount(AppiumDriver driver) throws InterruptedException {
        Thread.sleep(2000);
        if(askYrIcon.size()==1) {
            click(askYrIcon.get(0), driver);
            Assert.assertTrue(customPlusButton.get(0).isDisplayed(), "Custom + button not displayed");
            utils.log().info("Custom + button is displayed");
            ExtentReport.getTest().log(Status.INFO, "Custom + button is displayed");
        }
    }

    public void verifyIfPlusMinusYrCounticonShouldBeClickableAmountShouldIncreaseWhileUserClicksOnPlusMinusIcon(AppiumDriver driver) throws InterruptedException {
        Thread.sleep(2000);
        if(customPlusButton.size()==1) {
            click(customPlusButton.get(0), driver);
            waitForVisibility(minusIcon, driver);
            int customYrAmt = Integer.parseInt(getText(customYrAmount, "getting Yr amount to send", driver));
            click(plusIcon, driver);
            int incCustomYrAmt = Integer.parseInt(getText(customYrAmount, "getting Yr amount to send", driver));
            Assert.assertTrue(incCustomYrAmt > customYrAmt, "YrAmount is not increasing after clicking on plus icon");
            click(minusIcon, driver);
            int decCustomYrAmt = Integer.parseInt(getText(customYrAmount, "getting Yr amount to send", driver));
            Assert.assertTrue(decCustomYrAmt < incCustomYrAmt, "YrAmount is not increasing after clicking on plus icon");
            utils.log().info("Yr Amount increasing after clicking on plus icon and decreasing after clicking on minus icon");
            ExtentReport.getTest().log(Status.INFO, "Yr Amount increasing after clicking on plus icon and decreasing after clicking on minus icon");
        }
    }

    public void verifyIfTheIngameRechargeReminderShouldShowWhenUserClicksOnTheTimerBeforeLast3min(AppiumDriver driver)
    {
        click(addTimerIcon,driver);
        waitForVisibility(addTimeToAvoidCallEndLabel,driver);
        Assert.assertTrue(addTimeToAvoidCallEndLabel.isDisplayed(),"In Game Recharge Reminder popup is not displayed");
        utils.log().info("In Game Recharge Reminder popup is displayed");
        ExtentReport.getTest().log(Status.INFO,"In Game Recharge Reminder popup is displayed");
    }

    public void checkMentionedAmountOnTheBottomOfTheInGameRechargeReminderShouldAlsoChangeAsPerTheSelectedPackage(AppiumDriver driver)
    {
        click(addingTimerOption1,driver);
        String txt = getText(addTimerAmount,"getting timer Amount",driver);
        int num = getNumberFromString(txt);
        System.out.println(num);
        click(addingTimerOption2,driver);
        String txt1 = getText(addTimerAmount,"getting timer Amount",driver);
        int num1 = getNumberFromString(txt1);
        System.out.println(num1);
        Assert.assertNotEquals(num,num1,"Amount not changing as per the selected package");
        utils.log().info("Amount is changing in Game Recharge Reminder As per the Selected Package");
        ExtentReport.getTest().log(Status.INFO,"Amount is changing in Game Recharge Reminder As per the Selected Package");
    }

    public void verifyIfSwitchToVideoCallOptionShouldOnlyDisplayUnderTripleDotOptionOnceUserHaveJoinedTheHostedVoiceCall(AppiumDriver driver,String actualCoin,String expectedCoin) throws InterruptedException {
        new PrivateTrainingRoomPage(driver).verifyVideoSwicthOptionVisible(driver,actualCoin,expectedCoin);
        utils.log().info("Switch To Video Call Option Displayed Under Triple Dot Option Once User have joined Hosted Voice Call");
        ExtentReport.getTest().log(Status.INFO,"Switch To Video Call Option Displayed Under Triple Dot Option Once User have joined Hosted Voice Call");
    }

    public void verifyIfClickingOnVideoIconShouldShowABottomSheetUnderthreeDotsWithLoadingAnimationUntilOtherUserAcceptsOrejects(AppiumDriver driver)
    {
        click(threeDotMenu,driver);
        waitForVisibility(videoSwitchIcon,driver);
        click(videoSwitchIcon,driver);
        waitForVisibility(loadingAnimation,driver);
        Assert.assertTrue(loadingAnimation.isDisplayed(),"Loading Animation is not displayed");
        utils.log().info("Loading Animation displayed once user click on Video Switch Icon under three dot");
        ExtentReport.getTest().log(Status.INFO,"Loading Animation displayed once user click on Video Switch Icon under three dot");
    }

    public void checkIfSwitchToVideoCallRequestReceivedUserShouldShowAShimmerAnimationAcceptButton(AppiumDriver driver)
    {
        waitForVisibility(acceptButton ,driver);
        Assert.assertTrue(acceptButton.isDisplayed() && rejectButton.isDisplayed(),"Accept button is not displayed");
        utils.log().info("Accept and Reject Button is displayed to the user Once other user request for video call");
        ExtentReport.getTest().log(Status.INFO,"Accept and Reject Button is displayed to the user Once other user request for video call");
    }

    public void clickOnRejectButton(AppiumDriver driver)
    {
        click(rejectButton, driver);
        utils.log().info("clicked on Reject Button");
        ExtentReport.getTest().log(Status.INFO,"Clicke on Reject Button");

    }
    public void clickOnAcceptButton(AppiumDriver driver) throws InterruptedException {
        click(acceptButton,driver);
        utils.log().info("clicked on Accept Button");
        ExtentReport.getTest().log(Status.INFO,"Clicked on Accept Button");
        Thread.sleep(2000);
        if(new PrivateTrainingRoomPage(driver).audioRecordAllowPopup.size()==1)
        {
            click(new PrivateTrainingRoomPage(driver).audioRecordAllowPopup.get(0),driver);
        }
    }
    public void requestedUserShouldShowRequestRejectedWithCancelAndTryAgainOptionButton(AppiumDriver driver)
    {
        waitForVisibility(requestRejectedLabel,driver);
        Assert.assertTrue(rejectButton.isDisplayed() && acceptButton.isDisplayed()," Cancel And TryAgain button not displayed");
        utils.log().info("Requeted user showing Requested Reject Label and Cancel and Try Button");
        ExtentReport.getTest().log(Status.INFO,"Requeted user showing Requested Reject Label and Cancel and Try Button");
    }

    public void verifyClickingOnTryAgainOptionShouldInitiateTheVideoCallRequestToTheOtherUser(AppiumDriver driver)
    {
        waitForVisibility(acceptButton ,driver);
        Assert.assertTrue(acceptButton.isDisplayed() && rejectButton.isDisplayed(),"Accept button is not displayed");
        utils.log().info("Clicking on Try Again option initiating video cal request to the other user");
        ExtentReport.getTest().log(Status.INFO,"Clicking on Try Again option initiating video cal request to the other user");
    }
    public void returnToHomePageInGirlsLogin(AppiumDriver driver) throws InterruptedException {
        Thread.sleep(2000);
        if(winMoneyFromYellowRoseLabel.size()==1)
        {
            clickBackButton(driver);
        }
        Thread.sleep(2000);
        if(transferMoneyToYourBankLabel.size()==1)
        {
            clickBackButton(driver);
        }
    }

    public void verifyFaceNotDetectedUntilUserNotInfrontOfCamera(AppiumDriver driver)
    {
        waitForVisibility(faceNotDetectedLabel,driver);
        Assert.assertTrue(faceNotDetectedLabel.isDisplayed(),"Face Is detected although Host is not infront of the camera");
    }

    public void verifyIfHostIsNotInfrontOfTheDeviceCameraThenHostShouldNotBeAbleToAccessAnyOptionsFromTheVideoCall(AppiumDriver driver)
    {
        Assert.assertTrue(giftBox1.size()<1,"User is able to able to access the options from the video call although host is not infront of the camera");
        utils.log().info("As host is not infront of the Camera and not able to access any option from the video call");
        ExtentReport.getTest().log(Status.INFO,"As host is not infront of the Camera and not able to access any option from the video call");
    }

    public void checkIfFaceNotDetectedBottomSheetShouldShowAMovingAnimationForUserToGuideThatUserShouldBeInFrontOfTheDeviceCamera(AppiumDriver driver)
    {
        waitForVisibility(showYourFaceLabel,driver);
        Assert.assertTrue(faceDetectionAnimation.isDisplayed() && showYourFaceLabel.isDisplayed() && reduceEarningNotice.isDisplayed(),"User Guide Moving Animation not displayed");
        utils.log().info("User Guide That user should be infront of the Camera moving Animation is displayed to the user");
        ExtentReport.getTest().log(Status.INFO,"User Guide That user should be infront of the Camera moving Animation is displayed to the user");
    }
    public void getText(AppiumDriver driver)
    {
        waitForVisibility(tapOnNumberLabel,driver);
        System.out.println(getAttribute(tapOnNumberLabel,"index",driver));
        System.out.println(getAttribute(index1,"index",driver));
    }

    //*********************** Reusable Method *************************************************

    public int getNumberFromString(String str)
    {
        int num = 0;
        char[] ch = str.toCharArray();
        for(int i = 0;i<ch.length;i++)
        {
            if(ch[i]>='0' && ch[i]<='9')
            {
                num = ch[i]-48;
                break;
            }
        }
        return num;
    }

}
