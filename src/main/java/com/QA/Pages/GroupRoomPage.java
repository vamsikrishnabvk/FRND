package com.QA.Pages;

import com.QA.Base.BaseTest;
import com.QA.utlis.TestUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class GroupRoomPage extends BaseTest {
    public GroupRoomPage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    TestUtils utils = new TestUtils();
    //*************** Keep Elements Here ******************************************
    @AndroidFindBy(id = "com.dating.for.all:id/chat")
    private MobileElement plusIcon;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Create Room\"]")
    private MobileElement createRoomButton;

    @AndroidFindBy(id = "com.dating.for.all:id/instructionTv")
    private MobileElement waitForPlayersLabel;

    @AndroidFindBy(id = "com.dating.for.all:id/exitBt")
    private MobileElement leaveRoomButton;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"हिन्दी\"])[2]")
    private MobileElement hindiLabel;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Join Room\"]")
    private MobileElement joinRoomButton;

    @AndroidFindBy(id = "com.dating.for.all:id/unFollowButtonTv")
    private MobileElement followingLabel;

    @AndroidFindBy(id = "com.dating.for.all:id/gift")
    private MobileElement giftBox;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.dating.for.all:id/giftTitleTv\" and @text=\"IPL\"]")
    private MobileElement iplTab;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.dating.for.all:id/toy_name\" and @text=\"Punjab\"]")
    private MobileElement punjabHelmetGift;

    @AndroidFindBy(id = "com.dating.for.all:id/purchase_text")
    private MobileElement sendButton;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    private List<MobileElement> audioRecordAllowPopup;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    private List<MobileElement> audioRecordAllowPopup2;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    private List<MobileElement> allowFRNDToConnectPopup;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Make FRNDs in fun groups\"]")
    private MobileElement makingFrndInGroupLabel;

    @AndroidFindBy(id = "com.dating.for.all:id/coins")
    private MobileElement coinsNumber;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@resource-id=\"com.dating.for.all:id/discountPrice\"])[2]")
    private MobileElement helmentGiftPrice;

    @AndroidFindBy(xpath = "(//android.widget.ImageView[@resource-id=\"com.dating.for.all:id/hostIv\"])[2]")
    private MobileElement giftAnimation;


    //*********************** End Elements *************************************************

    public void clickOnPlusIcon(AppiumDriver driver) {
        click(plusIcon, "Clicked on Plus Icon ", driver);
    }

    public void verifyUserHostTheRoom(AppiumDriver driver) throws InterruptedException {
        click(plusIcon, "Clicked on Plus Icon", driver);
        click(createRoomButton, "Clicked on Create Room Icon", driver);
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
        waitForVisibility(waitForPlayersLabel, driver);
        Assert.assertTrue(waitForPlayersLabel.isDisplayed(), "User is not able to Host the Room");
        utils.log().info("User is able to Host the Room");
    }

    public void joinGroupRoom(AppiumDriver driver) throws InterruptedException {
        click(joinRoomButton, "clicked on JoinRoom Button", driver);
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
        waitForVisibility(giftBox, driver);
        Assert.assertTrue(giftBox.isDisplayed(), "User haven't joined the room");
        utils.log().info("User have joined the room");
    }

    public void verifyUserAbleToJoinWIth0Bal(AppiumDriver driver) throws InterruptedException {
        String coin = getCoins(driver);
        if (Integer.parseInt(coin) == 0) {
            click(joinRoomButton, "clicked on JoinRoom Button", driver);
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
            waitForVisibility(giftBox, driver);
            Assert.assertTrue(giftBox.isDisplayed(), "User haven't joined the room");
            utils.log().info("User have joined the room");
        }
    }

    public void verifyUserSendGiftToHost(String actualCoinValue, AppiumDriver driver) throws InterruptedException {
        click(giftBox, "Clicked on Gift Box", driver);
        click(iplTab, "Clicked on iplGiftOption", driver);
        click(punjabHelmetGift, "Clicked on Punjab Helmet gift", driver);
        String giftCoinValue = getText(helmentGiftPrice, "Getting gift price", driver);
        System.out.println(giftCoinValue);
        int m = Integer.parseInt(actualCoinValue);
        int n = Integer.parseInt(giftCoinValue);
        Assert.assertTrue(n < m, "Gift Coins values is not less than Actual Coins value So cannot send gift");
        //   click(punjabHelmetGift,"Clicked on punjabHelmetGift",driver);
        click(sendButton, "Clicked on Send Button", driver);
        waitForVisibility(giftAnimation, driver);
        Assert.assertTrue(giftAnimation.isDisplayed(), "Gift Animation is not displayed");
        utils.log().info("Gift Animation is visible");
    }

    public void checkCoinsDeducted(String expectedCoin, String actualCoins, AppiumDriver driver) {
        //click(homeTab,"Clicked on HomeTab");
        int actCoin = Integer.parseInt(expectedCoin);
        int remCoin = Integer.parseInt(actualCoins);
        Assert.assertTrue(remCoin < actCoin, "Coins left after sending gift is not less than the coin before sending gift");
        System.out.println("Coins left after sending gift is less than the coin before sending gift");
    }

    public void exitGroupRoom(AppiumDriver driver) {
        clickBackButton(driver);
        click(leaveRoomButton, "clicked on LeaveRoom Button", driver);
    }

    public void verifyUserExitRoom(AppiumDriver driver) {
        waitForVisibility(makingFrndInGroupLabel, driver);
        Assert.assertTrue(makingFrndInGroupLabel.isDisplayed(), "User haven't exit the room");
        utils.log().info("Users have successfully exit the room");
    }

    public void verifyUserBanned(AppiumDriver driver, String toastMessage) throws InterruptedException {
        click(joinRoomButton, "Clicked on Join Room", driver);
        Thread.sleep(4000);
        new ProfilePage(driver).verifyToastMessageUsingPageSource(toastMessage, driver);
    }

    public String getCoins(AppiumDriver driver) {
        return getText(coinsNumber, "Getting coins number", driver);
    }
}
