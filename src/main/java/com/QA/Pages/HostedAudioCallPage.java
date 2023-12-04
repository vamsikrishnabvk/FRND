package com.QA.Pages;

import com.QA.Base.BaseTest2;
import com.QA.utlis.TestUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class HostedAudioCallPage extends BaseTest2 {

    public HostedAudioCallPage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);   }
    TestUtils utils = new TestUtils();
    //*************** Keep Elements Here ******************************************
    @AndroidFindBy(id = "com.dating.for.all:id/gift")
    public MobileElement giftBox;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"IPL\"]")
    private MobileElement iPLGiftOption;

    @AndroidFindBy(id = "com.dating.for.all:id/purchase_text")
    private MobileElement sendButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Punjab']/following-sibling::android.widget.LinearLayout//android.widget.TextView[@resource-id='com.dating.for.all:id/discountPrice']")
    private MobileElement punjabHelmetGift;

    @AndroidFindBy(id = "com.dating.for.all:id/close")
    private MobileElement exitButton;

    @AndroidFindBy(id = "com.dating.for.all:id/askYr")
    private MobileElement askYrIcon;

    @AndroidFindBy(id = "com.dating.for.all:id/star5")
    private  MobileElement fifthStarRating;

    @AndroidFindBy(id = "com.dating.for.all:id/reviewTV")
    private MobileElement reviewTextBox;

    @AndroidFindBy(id = "com.dating.for.all:id/submit")
    private MobileElement submitButton;

    @AndroidFindBy(id = "com.dating.for.all:id/star51")
    private MobileElement experienceStarRating;

    @AndroidFindBy(id="com.dating.for.all:id/callAgain")
    private List<MobileElement> callAgainButton;

    @AndroidFindBy(id = "com.dating.for.all:id/back")
    private List<MobileElement> popupBackButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]")
    private List<MobileElement> goOffLineCrossButton;

    @AndroidFindBy(id = "com.dating.for.all:id/timer")
     private MobileElement timer;

    @AndroidFindBy(id = "com.dating.for.all:id/menu")
    private MobileElement menu;

    @AndroidFindBy(id = "com.dating.for.all:id/mic")
    private MobileElement mic;

    @AndroidFindBy(id = "com.dating.for.all:id/soundOff")
    private List<MobileElement> soundOffSymbol;

    @AndroidFindBy(id = "com.dating.for.all:id/amt2Tv")
    private MobileElement roses10;

    @AndroidFindBy(id = "com.dating.for.all:id/amt1Tv")
    private MobileElement roses2;

    @AndroidFindBy(id = "com.dating.for.all:id/requestBt")
    private MobileElement requestButton;

    @AndroidFindBy(id = "com.dating.for.all:id/giftNowTv")
    private MobileElement giftNowButton;

    @AndroidFindBy(xpath = "(//android.widget.ImageView[@resource-id=\"com.dating.for.all:id/playerAvatar\"])[2]")
    private MobileElement userAvatarIcon;

    @AndroidFindBy(id = "com.dating.for.all:id/profileTv")
    private MobileElement profileLayout;

    @AndroidFindBy(id = "com.dating.for.all:id/removeLayout")
    private MobileElement removeLayout;

    @AndroidFindBy(id = "com.dating.for.all:id/positiveActionBtv")
    private  MobileElement removeButton;

    @AndroidFindBy(id = "com.dating.for.all:id/kickOutIv")
    private MobileElement banIcon;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Sexual Talk\"]")
    private MobileElement sexualTalkWarning;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Ban\"]")
    private MobileElement banButton;

    @AndroidFindBy(id = "com.dating.for.all:id/positiveActionBtv")
    private MobileElement punishButton;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"I Understand it won't happen again\"]/preceding-sibling::android.widget.ImageView)[2]")
    private MobileElement checkBox;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"I Promise\"]")
    private MobileElement iPromiseButton;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id=\"com.dating.for.all:id/skip\"]")
    private MobileElement skipCrossButton;

    @AndroidFindBy(id = "com.dating.for.all:id/title")
    private List<MobileElement> startTrainingLabel;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    private List<MobileElement> whileUsingAppButton;

    @AndroidFindBy(id = "com.dating.for.all:id/timeTv")
    private MobileElement callDurationTime;

    @AndroidFindBy(id = "com.dating.for.all:id/yellowRoseAmountTv")
    private MobileElement yellowRoseCollectedAmount;

    @AndroidFindBy(id = "com.dating.for.all:id/callDuration")
    private MobileElement userCallDuration;

    @AndroidFindBy(id = "com.dating.for.all:id/totalRoses")
    private MobileElement userTotalRoseGited;



    //*********************** End Elements *************************************************

public void requestForGiftFor10Roses(AppiumDriver driver)
{
    click(askYrIcon,"Clicked on AskYr Icon",driver);
    click(roses10,"Selected 10 Roses option", driver);
    click(requestButton,"Clicked on Request Button", driver);
}

public void requestForGiftFor2Roses(AppiumDriver driver)
{
    click(askYrIcon,"Clicked on AskYr Icon",driver);
    click(roses2,"Selected 10 Roses option", driver);
    click(requestButton,"Clicked on Request Button", driver);
}

public void userSendGiftToHost(AppiumDriver driver)
{
    click(giftNowButton,"Sended gift to owner", driver);
}
public void verfiyTimerAndGiftCoinAfterSendsGift(String actualCoinValue, AppiumDriver driver) throws InterruptedException {
    String actualTimerValue = getTimerValue(driver);
    click(giftBox,"Clicked on Gift Box",driver);
    click(iPLGiftOption,"Clicked on iplGiftOption", driver);
    String giftCoinValue= getText(punjabHelmetGift," Get coins value of selected gift", driver);
    int m = Integer.parseInt(actualCoinValue);
    int n = Integer.parseInt(giftCoinValue);
    Assert.assertTrue(n<m,"Gift Coins values is not less than Actual Coins value So cannot send gift");
    click(punjabHelmetGift,"Clicked on punjabHelmetGift",driver);
    click(sendButton,"Clicked on Send Button", driver);
    String timerValueAfterGift = getTimerValue(driver);
    int a = Integer.parseInt(actualTimerValue);
    System.out.println(a);
    int b = Integer.parseInt(timerValueAfterGift);
    System.out.println(b);
    Assert.assertTrue(a>b,"TimerValue is not less than the timerValue after sending gift");
    }


    public void checkMuteUnmuteFunctionality(AppiumDriver driver)
    {
        click(menu,"Cliked on menu",driver);
        click(mic, "Clicked on Mic", driver);
        Assert.assertTrue(soundOffSymbol.get(0).isDisplayed()," Mic is not mute");
        click(mic," Clicked on mic",driver);
        Assert.assertEquals(soundOffSymbol.size(), 0, "Mic is mute");
        utils.log().info("Mute Unmute functionality working fine");
    }

    public void verifyUserHaveEnteredRoom(AppiumDriver driver)
    {
        waitForVisibility(giftBox, driver);
        utils.log().info("Gift box is displayed and User Have Entered in Room");
    }
    public String getTimerValue(AppiumDriver driver)
    {
        waitForVisibility(timer,driver);
        return getText(timer,"get timer value", driver).replace(":","");
    }
    public void selectGiftAndClickonSendButton(AppiumDriver driver) throws InterruptedException {

    }

    public void checkGiftCoinLessThanActualCoin(String actualCoinValue, AppiumDriver driver)
    {
        click(iPLGiftOption,"Clicked on iplGiftOption", driver);
         String giftCoinValue= getText(punjabHelmetGift," Get coins value of selected gift", driver);
         int m = Integer.parseInt(actualCoinValue);
         int n = Integer.parseInt(giftCoinValue);
         Assert.assertTrue(n<m,"Gift Coins values is not less than Actual Coins value So cannot send gift");
        click(punjabHelmetGift,"Clicked on punjabHelmetGift", driver);
        click(sendButton,"Clicked on Send Button", driver);
    }

    public void clickOnExitButton(AppiumDriver driver) throws InterruptedException {

    Thread.sleep(2000);
    if(whileUsingAppButton.size()==1)
    {
        click(whileUsingAppButton.get(0),"Clicked on whileUsingAppButton",driver);
    }

      Thread.sleep(3000);
    try {
        clickBackButton(driver);
    }catch (Exception e)
    {
        clickBackButton(driver);
    }

        Thread.sleep(2000);
        click(exitButton,"Clicked on exit Button",driver);

        if(callAgainButton.size()==1)
        {
            clickBackButton(driver);
        }
        if(popupBackButton.size()==1)
        {
            click(popupBackButton.get(0),driver);
        }
        if(startTrainingLabel.size()==1)
        {
            clickBackButton(driver);
        }
//
    }

    public void clickOnExitButton1(AppiumDriver driver) throws InterruptedException {

        Thread.sleep(2000);
        if(whileUsingAppButton.size()==1)
        {
            click(whileUsingAppButton.get(0),"Clicked on whileUsingAppButton",driver);
        }

        Thread.sleep(3000);
        try {
            clickBackButton(driver);
        }catch (Exception e)
        {
            clickBackButton(driver);
        }

        Thread.sleep(2000);
        click(exitButton,"Clicked on exit Button",driver);
    }
    public void hostExitRoom(AppiumDriver driver) throws InterruptedException {
        while (goOffLineCrossButton.size() < 1)
        {
            clickBackButton(driver);
        }
        click(goOffLineCrossButton.get(0),"Clcked on goOfflineButton",driver);
        utils.log().info("clicked on goOffline Button and return to training tab page");
    }

    public void clickOnStarRating(AppiumDriver driver) throws InterruptedException {
        if(callAgainButton.size()==1)
        {
            clickBackButton(driver);
        }
        if(popupBackButton.size()==1)
        {
            click(popupBackButton.get(0),driver);
        }
        click(fifthStarRating,"Given Rating", driver);
    }

    public void giveReviewMessage(AppiumDriver driver) throws InterruptedException {
        click(reviewTextBox,"Clicked on review TextBox", driver);
        sendKeys(reviewTextBox,"It was a great experience","Shared the feedabck",driver);
    }

    public void clickOnSubmitButton(AppiumDriver driver) throws InterruptedException {
        click(submitButton,driver);
    }

    public void shareAppExperienceRating(AppiumDriver driver) throws InterruptedException {
        click(experienceStarRating,"Shared App Experience Rating", driver);
    }
    public void verifyHostAbleToClickOnUserAvatar(AppiumDriver driver) throws InterruptedException {
        waitForClickable(userAvatarIcon,driver);
        click(userAvatarIcon,"Clicked on UserAvatarIcon", driver);
        waitForVisibility(profileLayout, driver);
        Assert.assertTrue(profileLayout.isDisplayed(),"Profile is not displayed");
        utils.log().info("Host is able to click on user Avatar");
    }
    public void hostRemoveUserFromTheRoom(AppiumDriver driver) throws InterruptedException {
        waitForClickable(userAvatarIcon, driver);
        click(userAvatarIcon,"Clicked on UserAvatarIcon", driver);
        click(removeLayout,"Clicked on remove layout", driver);
        click(removeButton,"Clicked on Remove Button", driver);
    }
    public void verfiyUserGotRemoveFromVoiceCall(AppiumDriver driver) throws InterruptedException {
        Thread.sleep(5000);
        if(callAgainButton.size()==1)
        {
            clickBackButton(driver);
        }
        if(popupBackButton.size()==1)
        {
            click(popupBackButton.get(0),driver);
        }
        waitForVisibility(fifthStarRating,driver);
        Assert.assertTrue(fifthStarRating.isDisplayed(),"Host not able to remove user after clicking on remove button");
        utils.log().info("User have got removed from the voice call after host removed the user");
    }

    public void hostBanTheUser(AppiumDriver driver)
    {
        click(userAvatarIcon,"clicked on User Avatar Icon",driver);
        click(banIcon,"Clicked on ban icon",driver);
        click(sexualTalkWarning,"Select sexual talk warning",driver);
        click(banButton,"Clicked on ban button",driver);
        click(punishButton,"Clicked on Punish Button",driver);
    }

    public void userGotTheWarning(AppiumDriver driver)
    {
        click(checkBox,"Clicked on checkBox",driver);
        click(iPromiseButton,"Clicked on iPromiseButton",driver);
        click(skipCrossButton,"Clicked on skip cross button", driver);
    }

    public void verifyYrCreditShownToHost(AppiumDriver driver,int expectedTime, int expectedRose)
    {
        waitForVisibility(callDurationTime,driver);
        String callDuration = getText(callDurationTime,"get call duration time", driver);
        String totalYellowRoseCollected = getText(yellowRoseCollectedAmount,"Total yellow rose collected", driver);
        int calDuration = Integer.parseInt(callDuration.replace(":",""));
        int yellowRoseCollcted = Integer.parseInt(totalYellowRoseCollected);
        if(calDuration>expectedTime)
        {
            Assert.assertEquals(yellowRoseCollcted,expectedRose,"Actual yellow rose collected is not equal to expected yellow rose collected");
            utils.log().info("Actual yellow rose is equal to expected yellow rose");
            utils.log().info("YrCredit screen shown to host");
        }
    }

    public void verifyUserEndDeductYRAutomatically(AppiumDriver driver,int expectedTime,int expectedGiftedRose)
    {
        waitForVisibility(userCallDuration, driver);
        int userCallDurtionTime  = Integer.parseInt(getText(userCallDuration,"Get user call duration time",driver).replace(":",""));
        int totalRoseGifted = Integer.parseInt(getText(userTotalRoseGited,"Total rose gifted by User",driver));
        if(userCallDurtionTime>expectedTime)
        {
            Assert.assertEquals(totalRoseGifted,expectedGiftedRose,"Actual Gifted rose is not equal to expected gifted rose");
            utils.log().info("Actual and expected gidted rose are equals");
        }
    }

    public String getTotalRosesGifted(AppiumDriver driver)
    {
        waitForVisibility(userTotalRoseGited,driver);
        return getText(userTotalRoseGited,"Getting total rose gifted by user",driver);
    }
}
