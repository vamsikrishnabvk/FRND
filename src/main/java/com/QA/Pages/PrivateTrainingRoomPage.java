package com.QA.Pages;

import com.QA.Base.BaseTest;
import com.QA.utlis.TestUtils;
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
    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.View[1]/android.view.View[4]")
    private MobileElement plusIcon;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Create Room\"]")
    private MobileElement createRoomIcon;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Audio Room\"]")
    private MobileElement audioRoomButton;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text = \"Daniel\"]/preceding-sibling::android.widget.TextView)[1]")
    //  @AndroidFindBy(xpath = "(//android.widget.ImageView[@resource-id=\"com.dating.for.all:id/avatarFrameIv\"])[2]")
    private List<MobileElement> vivoHostedRoom;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/android.view.ViewGroup/androidx.compose.ui.platform.ComposeView[2]/android.view.View/android.widget.ScrollView/android.view.View[1]/android.view.View[2]/android.widget.TextView")
    private MobileElement availableCoins;

    @AndroidFindBy(id = "com.dating.for.all:id/hostsRv")
    private MobileElement hostRv;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Video Room\"]")
    private MobileElement videoRoomButton;

    @AndroidFindBy(id = "com.dating.for.all:id/coinTitleTv")
    private MobileElement addCoinsToWalletLabel;

    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.View[1]/android.view.View[1]")
    private MobileElement profileIcon;

    @AndroidFindBy(id = "com.dating.for.all:id/gift")
    public MobileElement giftBox;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    private List<MobileElement> audioRecordAllowPopup;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"5 Min Call\"]")
    private MobileElement fiveMinuteCallButton;

    @AndroidFindBy(id = "com.dating.for.all:id/title")
    private List<MobileElement> startTrainingLabel;

    @AndroidFindBy(id = "com.dating.for.all:id/yellowRoseCount")
    private MobileElement yellowRoseCount;

    //*********************** End Elements *************************************************
    public void clickOnPlusIcon(AppiumDriver driver) throws InterruptedException {
        try {
            if (yellowRoseCount.isDisplayed()) {
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

    public void checkCoinAndEnterRoom(String coin, String expectedCoin, AppiumDriver driver) throws InterruptedException {
        int coin1 = Integer.parseInt(coin);
        int expectedCion = Integer.parseInt(expectedCoin);
        if (coin1 > expectedCion) {
            Assert.assertTrue(true, "User coin is less than 20 So he cannot join the room");
            while (vivoHostedRoom.size() < 1) {
                swipeScreen(Direction.DOWN, driver);
            }
            waitForClickable(vivoHostedRoom.get(0), driver);
            click(vivoHostedRoom.get(0), "Clicked on Vivo call", driver);
            if (audioRecordAllowPopup.size() == 1) {
                click(audioRecordAllowPopup.get(0), "Clicked on audio record allow popup", driver);
            }
            Thread.sleep(2000);
            if (audioRecordAllowPopup.size() == 1) {
                click(audioRecordAllowPopup.get(0), "Clicked on audio record allow popup", driver);
            }
            utils.log().info("User is able to join room as Coins is more than " + expectedCoin);
            waitForVisibility(giftBox, driver);
            Assert.assertTrue(giftBox.isDisplayed(), "User is not able to join hosted room");
            utils.log().info("User have joined the hosted room");
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
        }
    }

    public void checkCoinsDeducted(String expectedCoin, AppiumDriver driver) {
        //click(homeTab,"Clicked on HomeTab");
        waitForVisibility(availableCoins, driver);
        String coinsLeft = getText(availableCoins, "Get availabel coins", driver);
        int actCoin = Integer.parseInt(expectedCoin);
        int remCoin = Integer.parseInt(coinsLeft);
        Assert.assertTrue(remCoin < actCoin, "Coins left after sending gift is not less than the coin before sending gift");
        System.out.println("Coins left after sending gift is less than the coin before sending gift");
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
    }

    public void checkFiveMinuteCallButton(AppiumDriver driver) {
        if (startTrainingLabel.size() == 1) {
            clickBackButton(driver);
        }
        waitForVisibility(fiveMinuteCallButton, driver);
        Assert.assertTrue(fiveMinuteCallButton.isDisplayed(), "Five Minute call is not displayed");
        utils.log().info("User is getting Five minute free call");
    }
}
