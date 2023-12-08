package com.QA.Pages;

<<<<<<< HEAD
import com.QA.Base.BaseTest;
import com.QA.utlis.TestUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
=======
import com.QA.Base.BaseTest2;
import com.QA.utlis.TestUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
>>>>>>> e7aad041656f51bcd7540c5837b667b08d8aa271
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

<<<<<<< HEAD
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FrndMakingRoomsPage extends BaseTest {

    public FrndMakingRoomsPage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

=======
public class FrndMakingRoomsPage extends BaseTest2 {

    public FrndMakingRoomsPage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);   }
>>>>>>> e7aad041656f51bcd7540c5837b667b08d8aa271
    TestUtils utils = new TestUtils();
    //*************** Keep Elements Here ******************************************

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='FRND Making Rooms']")
    public MobileElement frndMakingRoomsPageHeader;
    @AndroidFindBy(xpath = "//android.view.View[1]/android.view.View[3]")
    public MobileElement plusIcon;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Create Room']")
    public MobileElement createRoomButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Be FRND Making Expert']")
    public MobileElement beFRNDMakingExpertPopup;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='FRND RJ']")
    public MobileElement fRNDMakingLiveRoom;
    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    private MobileElement audioRecordAllowPopup;
    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    private MobileElement audioRecordConfirmAllowPopup;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Close Room']")
    public MobileElement closeLiveRoomPopup;
    @AndroidFindBy(id = "com.dating.for.all:id/close")
    public MobileElement closeLiveRoomCrossButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Join Room']")
    public MobileElement joinRoom;
<<<<<<< HEAD
    @AndroidFindBy(xpath = "  //android.widget.TextView[@text='Will']/following-sibling::android.view.View")
    public MobileElement joinRoomByUserName;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Experts will make your FRND']")
    public MobileElement frndPageTitleForUser;

//    @AndroidFindBy(xpath = "(//android.widget.FrameLayout/android.view.View)[2]")
//    public MobileElement joinWaitlistButton;

    @AndroidFindBy(id = "com.dating.for.all:id/add")
    public MobileElement joinWaitlistButton;
    @AndroidFindBy(id = "com.dating.for.all:id/addUser")
    public MobileElement addUserButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Add Boy']")
    public MobileElement addBoyButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Add Girl']")
    public MobileElement addGirlButton;

=======
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Experts will make your FRND']")
    public MobileElement frndPageTitleForUser;
    @AndroidFindBy(xpath = "(//android.widget.FrameLayout/android.view.View)[2]")
    public MobileElement joinWaitlistButton;
    @AndroidFindBy(id = "com.dating.for.all:id/addUser")
    public MobileElement addUserButton;
>>>>>>> e7aad041656f51bcd7540c5837b667b08d8aa271
    @AndroidFindBy(id = "com.dating.for.all:id/add")
    public MobileElement waitlistAddButton;
    @AndroidFindBy(id = "com.dating.for.all:id/avatar")
    public MobileElement userAvatar;
<<<<<<< HEAD
    @AndroidFindBy(id = "//android.view.ViewGroup[@resource-id='com.dating.for.all:id/maleSeat']//android.widget.ImageView[@resource-id='com.dating.for.all:id/avatar']")
    public MobileElement maleUserAvatar;
    @AndroidFindBy(id = "//android.view.ViewGroup[@resource-id='com.dating.for.all:id/femaleSeat']//android.widget.ImageView[@resource-id='com.dating.for.all:id/avatar']")
    public MobileElement femaleUserAvatar;
=======
>>>>>>> e7aad041656f51bcd7540c5837b667b08d8aa271
    @AndroidFindBy(id = "com.dating.for.all:id/menuOptions")
    public MobileElement threeDotsOption;
    @AndroidFindBy(id = "com.dating.for.all:id/mic")
    public MobileElement hostMicOption;
    @AndroidFindBy(id = "com.dating.for.all:id/speaker")
    public MobileElement hostSpeakerOption;
<<<<<<< HEAD
    @AndroidFindBy(id = "com.dating.for.all:id/micIv")
    public MobileElement muteUnmuteUserButton;
    @AndroidFindBy(id = "com.dating.for.all:id/background")
    public MobileElement wallpaperButton;
    @AndroidFindBy(id = "com.dating.for.all:id/removeIv")
    public MobileElement removeUserButton;
    @AndroidFindBy(id = "com.dating.for.all:id/positiveActionBtv")
    public MobileElement confirmRemoveButtonOnPopup;
    @AndroidFindBy(id = "com.dating.for.all:id/negativeActionBtv")
    public MobileElement cancelRemoveButtonOnPopup;
    @AndroidFindBy(id = "com.dating.for.all:id/titleTv")
    public MobileElement removeUserPopupHeader;
    @AndroidFindBy(id = "com.dating.for.all:id/kickOutIv")
    public MobileElement banUserButton;
    @AndroidFindBy(id = "com.dating.for.all:id/profileIv")
    public MobileElement userProfileButton;
    @AndroidFindBy(xpath = "(//android.widget.ImageView[@resource-id='com.dating.for.all:id/image'])[2]")
    public MobileElement userGiftIcon;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='com.dating.for.all:id/image']")
    public List<MobileElement> giftIcon;
    @AndroidFindBy(id = "com.dating.for.all:id/purchase")
    public MobileElement userGiftSendButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Gifted')]")
    public MobileElement giftSendContentMessage;
    @AndroidFindBy(id = "com.dating.for.all:id/leaderboardGiftingCount")
    public MobileElement userCoinCount;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/android.view.ViewGroup/androidx.compose.ui.platform.ComposeView[2]/android.view.View/android.widget.ScrollView/android.view.View[1]/android.view.View[2]/android.widget.TextView")
    private MobileElement availableCoins;
    @AndroidFindBy(xpath = "//android.view.View[2]/android.widget.TextView")
    private List<MobileElement> banUserOptions;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Ban']")
    public MobileElement banButtonOnPopup;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Be responsible and ban only if misbehaved']")
    public MobileElement banUserPopupHeader;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Punish']")
    public MobileElement punishButton;
    @AndroidFindBy(xpath = "//android.view.View/android.widget.ImageView[2]")
    public MobileElement warningCheckbox;
    @AndroidFindBy(xpath = "(//android.view.View/android.view.View)[2]")
    public MobileElement iPromiseButton;
    @AndroidFindBy(xpath = "//android.widget.Toast")
    public MobileElement toastMessage;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Wallpapers']")
    public MobileElement wallpaperPopupHeader;
    @AndroidFindBy(xpath = "(//android.widget.ImageView[@resource-id='com.dating.for.all:id/frameIv'])[1]")
    public MobileElement freeWallpaper;
    @AndroidFindBy(id = "com.dating.for.all:id/applyAddonButton")
    public MobileElement applyWallpaper;
    @AndroidFindBy(id = "com.dating.for.all:id/coin_image")
    public MobileElement buyFreeWallpaperButton;
    @AndroidFindBy(id = "com.dating.for.all:id/positiveActionBtv")
    public MobileElement createNewRoomButton;
    @AndroidFindBy(id = "com.dating.for.all:id/exitBtv")
    public MobileElement exitButtonOnAdPopup;
    @AndroidFindBy(id = "com.dating.for.all:id/roomTimer")
    public MobileElement makingRoomTimer;
=======
>>>>>>> e7aad041656f51bcd7540c5837b667b08d8aa271


    //*************** Elements Ends Here ******************************************

    public void clickOnPlusIcon(AppiumDriver driver) throws InterruptedException {
<<<<<<< HEAD
        waitForVisibility(plusIcon, driver);
        click(plusIcon, "Clicked on Plus Icon", driver);
    }

    public void clickOnCreateRoomButton(AppiumDriver driver) {
        waitForVisibility(createRoomButton, driver);
        click(createRoomButton, "Clicked on Plus Icon", driver);
    }

    public void clickOnExitButtonOnAdPopup(AppiumDriver driver) {
        waitForVisibility(exitButtonOnAdPopup, driver);
        click(exitButtonOnAdPopup, "Clicked on Plus Icon", driver);
    }

    public void clickOnCreateNewRoomButton(AppiumDriver driver) {
        waitForVisibility(createNewRoomButton, driver);
        waitForVisibility(createNewRoomButton, driver);
        click(createNewRoomButton, "Clicked on Plus Icon", driver);
    }

    public void allowAudioRecordAllowPopup(AppiumDriver driver) {
        waitForVisibility(audioRecordAllowPopup, driver);
        if (audioRecordAllowPopup.isDisplayed()) {
            click(audioRecordAllowPopup, "Clicked on Audio record allow popup", driver);
        }
        click(audioRecordConfirmAllowPopup, driver);
    }

    public void allowAudioRecordAllowOnPopup(AppiumDriver driver) {
        waitForVisibility(audioRecordAllowPopup, driver);
        try {
            if (audioRecordAllowPopup.isDisplayed()) {
                click(audioRecordAllowPopup, "Clicked on Audio record allow popup", driver);
            }
        } catch (Exception ignored) {
        }
    }

    public void clickOnBackButtonOnLiveCall(AppiumDriver driver) {
        clickBackButton(driver);
    }

    public void closeLiveRoomCrossButton(AppiumDriver driver) {
        waitForVisibility(closeLiveRoomCrossButton, driver);
        click(closeLiveRoomCrossButton, "Clicked on Close room cross button", driver);
    }

    public void clickOnJoinRoom(AppiumDriver driver) {
        waitForVisibility(joinRoom, driver);
        click(joinRoom, "Clicked on Join Room", driver);
    }

    public void clickOnJoinRoomByUserName(AppiumDriver driver) {
        waitForVisibility(joinRoomByUserName, driver);
        click(joinRoomByUserName, "Clicked on Join Room button", driver);
    }

    public void clickOnJoinWaitlistButton(AppiumDriver driver) throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        click(joinWaitlistButton, "Clicked on Join WaitList button", driver);
//        getDriver2().findElementByXPath("//*[@resource-id='com.dating.for.all:id/add']").click();
//        System.out.println("JoinedWaitList");
//        waitForVisible(joinWaitlistButton, driver);

    }

    public void clickOnAddUserButton(AppiumDriver driver) {
        waitForVisibility(addUserButton, driver);
        click(addUserButton, "Clicked on Add User", driver);
    }

    public void clickOnAddBoyButton(AppiumDriver driver) {
        fluentVisibility(addBoyButton, driver);
        click(addBoyButton, "Clicked on Add User", driver);
    }

    public void clickOnAddGirlButton(AppiumDriver driver) {
        fluentVisibility(addGirlButton, driver);
        click(addGirlButton, "Clicked on Add User", driver);
    }

    public void clickOnWaitlistAddButton(AppiumDriver driver) {
        waitForVisibility(waitlistAddButton, driver);
        click(waitlistAddButton, "Clicked on Watchlist button", driver);
    }

    public void clickOnOptionsButton(AppiumDriver driver) {
        fluentVisibility(threeDotsOption, driver);
        click(threeDotsOption, "Clicked on Three dots option", driver);
    }

    public void clickOnMicButton(AppiumDriver driver) {
        fluentVisibility(hostMicOption, driver);
        click(hostMicOption, "Clicked on mic option", driver);
    }

    public void clickOnSpeakerButton(AppiumDriver driver) throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        try {
            click(hostSpeakerOption, "Clicked on speaker option", driver);
        } catch (StaleElementReferenceException e) {
            click(hostSpeakerOption, "Clicked on speaker option", driver);
        }
    }

    public void clickOnMuteUnmuteUserButton(AppiumDriver driver) {
        waitForVisibility(muteUnmuteUserButton, driver);
        click(muteUnmuteUserButton, "Clicked on mic option", driver);
    }

    public void clickOnWallpaperButton(AppiumDriver driver) {
        waitForVisibility(wallpaperButton, driver);
        click(wallpaperButton, "Clicked on Wallpaper option", driver);
    }

    public void selectWallpaper(AppiumDriver driver) {
//        scrollIntoElement("FREE", "Scrolled to Free wallpaper", driver);
        waitForVisibility(freeWallpaper, driver);
        click(freeWallpaper, driver);
        click(applyWallpaper, driver);
        try {
            if (wallpaperPopupHeader.isDisplayed()) {
                clickBackButton(driver);
            }
        } catch (Exception ignored) {
        }
    }

    public void clickWallpaperPopupHeader(AppiumDriver driver) {
        waitForVisibility(wallpaperPopupHeader, driver);
        click(wallpaperPopupHeader, driver);
    }

    public void clickOnRemoveUserButton(AppiumDriver driver) {
        waitForVisibility(removeUserButton, driver);
        click(removeUserButton, "Clicked on Remove user button", driver);
    }

    public void clickOnConfirmRemoveUserOnPopup(AppiumDriver driver) {
        waitForVisibility(confirmRemoveButtonOnPopup, driver);
        click(confirmRemoveButtonOnPopup, "Clicked on confirm remove user button", driver);
    }

    public void clickOnBanUserButton(AppiumDriver driver) {
        waitForVisibility(banUserButton, driver);
        click(banUserButton, "Clicked on ban user button", driver);
    }

    public void clickOnUserProfileButton(AppiumDriver driver) {
        waitForVisibility(userProfileButton, driver);
        click(userProfileButton, "Clicked on user profile button", driver);
    }

    public void clickOnSendGift(AppiumDriver driver) {
        waitForVisibility(userGiftIcon, driver);
        click(userGiftIcon, "Clicked on gift icon", driver);
        click(userGiftSendButton, "Clicked on send gift button", driver);
    }

    public void clickSendGift(int giftIndex, AppiumDriver driver) {
        try {
            click(giftIcon.get(giftIndex), driver);
            click(userGiftSendButton, driver);
        } catch (IndexOutOfBoundsException e) {
            click(giftIcon.get(giftIndex), driver);
            click(userGiftSendButton, driver);
        }
    }

    public void clickOnUserAvatar(AppiumDriver driver) {
        waitForVisibility(userAvatar, driver);
        click(userAvatar, "Clicked on user avatar", driver);
    }

    public void selectBanUserReason(int banReasonIndex, AppiumDriver driver) {
        click(banUserOptions.get(banReasonIndex), "Clicked on Remove user button", driver);
    }

    public void clickOnBanButtonOnPopup(AppiumDriver driver) {
        waitForVisibility(banButtonOnPopup, driver);
        click(banButtonOnPopup, "Clicked on ban button", driver);
    }

    public void clickOnPunishButtonOnPopup(AppiumDriver driver) {
        waitForVisibility(punishButton, driver);
        click(punishButton, "Clicked on punish button", driver);
    }

    public void clickOnIPromiseButtonOnWarningPopup(AppiumDriver driver) {
        waitForVisibility(warningCheckbox, driver);
        click(warningCheckbox, "Clicked on popup checkbox", driver);
        click(iPromiseButton, "Clicked on I Promise button", driver);
    }

    public void clickOnPlusIconAfterJoinRoom(AppiumDriver driver) throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        try {
            if (joinRoom.isDisplayed()) {
                click(joinRoom, "Clicked on Join Room button", driver);
                allowAudioRecordAllowPopup(driver);
                clickBackButton(driver);
                click(closeLiveRoomCrossButton, driver);
                click(plusIcon, driver);
                waitForVisibility(createRoomButton, driver);
                click(createRoomButton, "Clicked on Plus Icon", driver);
            }
        } catch (Exception ignored) {
        }
        try {
            waitForVisibility(plusIcon, driver);
            click(plusIcon, "Clicked on Join Room button", driver);
            waitForVisibility(createRoomButton, driver);
            click(createRoomButton, "Clicked on Plus Icon", driver);
            allowAudioRecordAllowPopup(driver);
        } catch (Exception ignored) {
        }

    }

    public void clickOnJoinRoomAndLeave(AppiumDriver driver) throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        try {
            if (joinRoom.isDisplayed()) {
                click(joinRoom, "Clicked on Join Room button", driver);
                allowAudioRecordAllowPopup(driver);
                clickBackButton(driver);
                click(closeLiveRoomCrossButton, driver);
                click(joinRoomByUserName, driver);
            }
        } catch (Exception ignored) {
        }
        try {
            if (joinRoomByUserName.isDisplayed()) {
                click(joinRoomByUserName, "Clicked on Join Room button", driver);
                allowAudioRecordAllowPopup(driver);
            }
        } catch (Exception ignored) {
        }
    }

    public void waitTillFmrCallEnds() throws InterruptedException {
        TimeUnit.SECONDS.sleep(320);
    }

    //*************** Assert Methods ******************************************
    public void verifyFRNDMakingRoomsPageHeader(String expectedHeader, AppiumDriver driver) {
        waitForVisibility(frndMakingRoomsPageHeader, driver);
        String actualPageHeader = frndMakingRoomsPageHeader.getText();
        Assert.assertEquals(actualPageHeader, expectedHeader, "Popup header is not as expected");
    }

    public void verifyBeFRNDMakingExpertPopup(String expectedHeader, AppiumDriver driver) {
        waitForVisibility(beFRNDMakingExpertPopup, driver);
        String actualPopupHeader = beFRNDMakingExpertPopup.getText();
        Assert.assertEquals(actualPopupHeader, expectedHeader, "Popup header is not as expected");
    }

    public void verifyCreatedFrndMeetingRoom(String expectedHeader, AppiumDriver driver) {
        waitForVisibility(fRNDMakingLiveRoom, driver);
        try {
            String actualLiveRoomHeader = fRNDMakingLiveRoom.getText();
            Assert.assertEquals(actualLiveRoomHeader, expectedHeader, "Popup header is not as expected");
        } catch (Exception e) {
            String actualLiveRoomHeader = fRNDMakingLiveRoom.getText();
            Assert.assertEquals(actualLiveRoomHeader, expectedHeader, "Popup header is not as expected");
        }
    }

    public void verifyCloseFRNDMakingRoomsPopupHeader(String expectedHeader, AppiumDriver driver) {
=======
        Thread.sleep(5000);
        waitForVisibility(plusIcon,driver);
        click(plusIcon, "Clicked on Plus Icon",driver);
    }
    public void clickOnCreateRoomButton(AppiumDriver driver) throws InterruptedException {
        Thread.sleep(5000);
        waitForVisibility(createRoomButton,driver);
        click(createRoomButton, "Clicked on Plus Icon",driver);
    }
    public void allowAudioRecordAllowPopup(AppiumDriver driver)
    {
        waitForVisibility(audioRecordAllowPopup, driver);
        if(audioRecordAllowPopup.isDisplayed())
        {
            click(audioRecordAllowPopup,"Clicked on Audio record allow popup",driver);
        }
        try {
            click(audioRecordConfirmAllowPopup, driver);
        }catch (Exception e)
        {

        }
    }
    public void clickOnBackButtonOnLiveCall(AppiumDriver driver){
        clickBackButton(driver);
    }
    public void closeLiveRoomCrossButton(AppiumDriver driver) {
           click(closeLiveRoomCrossButton, driver);
    }
    public void clickOnJoinRoom(AppiumDriver driver){
        waitForVisibility(joinRoom, driver);
              click(joinRoom, driver);
    }
    public void clickOnJoinWaitlistButton(AppiumDriver driver){
        waitForVisibility(joinWaitlistButton, driver);
        click(joinWaitlistButton, driver);
    }
    public void clickOnAddUserButton(AppiumDriver driver){
        waitForVisibility(addUserButton, driver);
        click(addUserButton, driver);
    }
    public void clickOnWatchlistAddButton(AppiumDriver driver){
        waitForVisibility(waitlistAddButton, driver);
        click(waitlistAddButton, driver);
    }
    public void clickOnOptionsButton(AppiumDriver driver){
        waitForVisibility(threeDotsOption, driver);
        click(threeDotsOption, driver);
    }
    public void clickOnMicButton(AppiumDriver driver){
        waitForVisibility(hostMicOption, driver);
        click(hostMicOption, driver);
    }
    public void clickOnSpeakerButton(AppiumDriver driver) {
        waitForVisibility(hostSpeakerOption, driver);
        try {
            click(hostSpeakerOption, driver);
        } catch (StaleElementReferenceException e) {
            click(hostSpeakerOption, driver);
        }
    }


    //*************** Assert Methods ******************************************
    public void verifyFRNDMakingRoomsPageHeader(String expectedHeader, AppiumDriver driver) throws InterruptedException {
        Thread.sleep(5000);
        String actualPageHeader = frndMakingRoomsPageHeader.getText();
        Assert.assertEquals(actualPageHeader, expectedHeader, "Popup header is not as expected");
    }
    public void verifyBeFRNDMakingExpertPopup(String expectedHeader, AppiumDriver driver) throws InterruptedException {
        Thread.sleep(5000);
        String actualPopupHeader = beFRNDMakingExpertPopup.getText();
        Assert.assertEquals(actualPopupHeader, expectedHeader, "Popup header is not as expected");
    }
    public void verifyCreatedFrndMeetingRoom(String expectedHeader, AppiumDriver driver) throws InterruptedException {
        waitForVisibility(fRNDMakingLiveRoom, driver);
        String actualLiveRoomHeader = fRNDMakingLiveRoom.getText();
        Assert.assertEquals(actualLiveRoomHeader, expectedHeader, "Popup header is not as expected");
    }
    public void verifyCloseFRNDMakingRoomsPopupHeader(String expectedHeader, AppiumDriver driver) throws InterruptedException {
>>>>>>> e7aad041656f51bcd7540c5837b667b08d8aa271
        waitForVisibility(closeLiveRoomPopup, driver);
        String actualPageHeader = closeLiveRoomPopup.getText();
        Assert.assertEquals(actualPageHeader, expectedHeader, "Header is not as expected");
    }
<<<<<<< HEAD

    public void verifyFrndPageTitleForUser(String expectedHeader, AppiumDriver driver) {
        fluentVisibility(frndPageTitleForUser, driver);
        String actualPageHeader = frndPageTitleForUser.getText();
        Assert.assertEquals(actualPageHeader, expectedHeader, "Header is not as expected");
    }

    public void verifyUserAddedToGame(boolean isDisplayed, AppiumDriver driver) {
        waitForVisibility(userAvatar, driver);
        Assert.assertEquals(userAvatar.isDisplayed(), isDisplayed);
    }

    public int verifyUserAvailableCoins(AppiumDriver driver) {
        waitForVisibility(closeLiveRoomPopup, driver);
        int actualValue = Integer.parseInt(closeLiveRoomPopup.getText());
        return actualValue;
    }

    public void verifyCoinsAddedAfterPayment(AppiumDriver driver) {
        int coinAfterPayment = Integer.parseInt(closeLiveRoomPopup.getText());
        int sumOfCoins = coinAfterPayment + verifyUserAvailableCoins(getDriver2());
        Assert.assertEquals(coinAfterPayment, sumOfCoins, "Coins After payment have not been added");
        utils.log().info("Coins After Payment have been added successfully");
    }

    public void verifyMuteUnmuteUserButtonDisplayed(boolean isDisplayed, AppiumDriver driver) {
        waitForVisibility(muteUnmuteUserButton, driver);
        Assert.assertEquals(muteUnmuteUserButton.isDisplayed(), isDisplayed);
    }

    public void verifyRemoveUserButtonDisplayed(boolean isDisplayed, AppiumDriver driver) {
        waitForVisibility(removeUserButton, driver);
        Assert.assertEquals(removeUserButton.isDisplayed(), isDisplayed);
    }

    public void verifyBanUserButtonDisplayed(boolean isDisplayed, AppiumDriver driver) {
        waitForVisibility(banUserButton, driver);
        Assert.assertEquals(banUserButton.isDisplayed(), isDisplayed);
    }

    public void verifyRemoveUserPopupHeader(String expectedHeader, AppiumDriver driver) {
        waitForVisibility(removeUserPopupHeader, driver);
        try {
            String actualPageHeader = removeUserPopupHeader.getText();
            Assert.assertEquals(actualPageHeader, expectedHeader, "Header is not as expected");
        } catch (Exception e) {
            String actualPageHeader = removeUserPopupHeader.getText();
            Assert.assertEquals(actualPageHeader, expectedHeader, "Header is not as expected");
        }
    }

    public void checkCoinsDeducted(String expectedCoin, AppiumDriver driver) {

        waitForVisibility(availableCoins, driver);
        String coinsLeft = getText(availableCoins, "Get available coins", driver);
        int actCoin = Integer.parseInt(expectedCoin);
        int remCoin = Integer.parseInt(coinsLeft);
        Assert.assertTrue(remCoin < actCoin, "Coins left after sending gift is not less than the coin before sending gift");
        System.out.println("Coins left after sending gift is less than the coin before sending gift");
    }

    public void verifyGiftSentContentMessageDisplayed(boolean isDisplayed, AppiumDriver driver) {
        waitForVisibility(giftSendContentMessage, driver);
        Assert.assertEquals(giftSendContentMessage.isDisplayed(), isDisplayed);
    }

    public void verifyBanUserPopupHeader(String expectedHeader, AppiumDriver driver) {
        waitForVisibility(banUserPopupHeader, driver);
        try {
            String actualPageHeader = banUserPopupHeader.getText();
            Assert.assertEquals(actualPageHeader, expectedHeader, "Header is not as expected");
        } catch (StaleElementReferenceException e) {
            String actualPageHeader = banUserPopupHeader.getText();
            Assert.assertEquals(actualPageHeader, expectedHeader, "Header is not as expected");
        }
    }

    public void verifyToastMessage(String expectedMessage, AppiumDriver driver) {
        waitForVisibility(toastMessage, driver);
        try {
            String actualToastMessage = toastMessage.getText();
            Assert.assertEquals(actualToastMessage, expectedMessage, "Toast message is not as expected");
        } catch (StaleElementReferenceException e) {
            String actualToastMessage = toastMessage.getText();
            Assert.assertEquals(actualToastMessage, expectedMessage, "Toast message is not as expected");
        }
    }

    public String getAvailableCoin(AppiumDriver driver) {
        waitForVisibility(userCoinCount, driver);
        String coinCount = userCoinCount.getText();
        return coinCount;

    }

    public void verifyGiftingAmountOnFrndMakingRoom(String previousCoinCount, AppiumDriver driver) {
        waitForVisibility(userCoinCount, driver);
        String coinsAfterGiftSent = getText(userCoinCount, "Get available coins", driver);
        Assert.assertNotEquals(previousCoinCount, coinsAfterGiftSent, "Coins count after sending gift is same as the coin before sending gift");
        System.out.println("Coins count after sending gift is not same as the coin before sending gift");
    }

    //---------------------------------------------------------

    public void verifyThatHostAbleToCloseTheRoomBeforeStartTheGame(String closeLiveRoomPopupHeader, String frndMakingRoomsPageHeader, AppiumDriver driver) throws InterruptedException {
        clickOnBackButtonOnLiveCall(driver);
        verifyCloseFRNDMakingRoomsPopupHeader(closeLiveRoomPopupHeader, driver);
        closeLiveRoomCrossButton(driver);
        verifyFRNDMakingRoomsPageHeader(frndMakingRoomsPageHeader, driver);
    }

    public void verifyThatUsersAreAbleToJoinTheFrndMakingRoomWithZeroCoinBalance(String frndPageTitleForUser, String frndMakingLiveRoomsPageHeader, AppiumDriver driver) throws InterruptedException {
        verifyFrndPageTitleForUser(frndPageTitleForUser, driver);
        clickOnJoinRoomAndLeave(driver);
        verifyCreatedFrndMeetingRoom(frndMakingLiveRoomsPageHeader, driver);
    }

    public void verifyThatUserAbleToLeaveTheGameWithoutOnGame(String frndMakingRoomsPageHeader, AppiumDriver driver) {
        clickOnBackButtonOnLiveCall(driver);
        closeLiveRoomCrossButton(driver);
        verifyFRNDMakingRoomsPageHeader(frndMakingRoomsPageHeader, driver);
    }

    public void verifyThatHostAbleToDoMuteUnmuteToUsers(boolean muteButtonDisplayed, AppiumDriver driver) {
        clickOnUserAvatar(driver);
        verifyMuteUnmuteUserButtonDisplayed(muteButtonDisplayed, driver);
        clickOnMuteUnmuteUserButton(driver);
        clickBackButton(driver);
    }

    public void verifyThatHostAbleToDoMuteUnmuteToMaleUsers(boolean muteButtonDisplayed, AppiumDriver driver) {
        click(maleUserAvatar, "Clicked on Male avatar profile", driver);
        verifyMuteUnmuteUserButtonDisplayed(muteButtonDisplayed, driver);
        clickOnMuteUnmuteUserButton(driver);
        clickBackButton(driver);
    }

    public void verifyThatHostAbleToDoMuteUnmuteToFemaleUsers(boolean muteButtonDisplayed, AppiumDriver driver) {
        click(femaleUserAvatar, "Clicked on Female avatar profile", driver);
        verifyMuteUnmuteUserButtonDisplayed(muteButtonDisplayed, driver);
        clickOnMuteUnmuteUserButton(driver);
        clickBackButton(driver);
    }

    public void checkTheMuteUnmuteFunctionalityIsWorkingAsExpected(AppiumDriver driver) throws InterruptedException {
        clickOnOptionsButton(driver);
        clickOnMicButton(driver);
        clickOnOptionsButton(driver);
        clickOnSpeakerButton(driver);
    }

    public void verifyThatUserIsAbleToExitDuringTheGame(AppiumDriver driver) {
        clickBackButton(driver);
        closeLiveRoomCrossButton(driver);
        clickOnExitButtonOnAdPopup(driver);
    }

    public void verifyThatHostAbleToKickoutTheUserInFrndMakingRoomClickingOnKickOutOption(boolean isDisplayed, String removeUserPopupHeader, String frndPageTitleForUser, AppiumDriver driver) {
        clickOnUserAvatar(driver);
        verifyRemoveUserButtonDisplayed(isDisplayed, driver);
        clickOnRemoveUserButton(getDriver1());
        verifyRemoveUserPopupHeader(removeUserPopupHeader, driver);
        clickOnConfirmRemoveUserOnPopup(driver);
    }

    public void verifyThatUserAbleToRemoveTheFrndMakingRoomWhenHostRemoveParticularUsers(String frndPageTitleForUser, AppiumDriver driver) {
        verifyFrndPageTitleForUser(frndPageTitleForUser, driver);
        clickBackButton(driver);
    }

    public void verifyThatHostAbleToCloseTheRoomDuringTheGame(String closeLiveRoomPopupHeader, AppiumDriver driver) {
        clickOnBackButtonOnLiveCall(driver);
        verifyCloseFRNDMakingRoomsPopupHeader(closeLiveRoomPopupHeader, driver);
        closeLiveRoomCrossButton(driver);
    }

    public void verifyIfHostShouldBeAbleToApplyTheGiftedWallpaperDuringTheGame(AppiumDriver driver) throws InterruptedException {
        clickOnOptionsButton(driver);
        clickOnWallpaperButton(driver);
        clickWallpaperPopupHeader(driver);
        swipeElementAndroid(wallpaperPopupHeader, Direction.UP, "Swipe to Wallpaper Popup", (AndroidDriver) driver);
        TimeUnit.SECONDS.sleep(10);
        selectWallpaper(driver);
    }

    public void verifyMakingRoomTimerDisplayed(boolean isDisplayed, AppiumDriver driver) {
        fluentVisibility(makingRoomTimer, driver);
        Assert.assertEquals(makingRoomTimer.isDisplayed(), isDisplayed);
    }

    public void verifyThatUserIsAbleToExitAfterFmrCall(AppiumDriver driver) {
        clickBackButton(driver);
        closeLiveRoomCrossButton(driver);
=======
    public void verifyFrndPageTitleForUser(String expectedHeader, AppiumDriver driver) {
        waitForVisibility(frndPageTitleForUser, driver);
        try {
            String actualPageHeader = frndPageTitleForUser.getText();
            Assert.assertEquals(actualPageHeader, expectedHeader, "Header is not as expected");
        } catch(StaleElementReferenceException e){
            String actualPageHeader = frndPageTitleForUser.getText();
            Assert.assertEquals(actualPageHeader, expectedHeader, "Header is not as expected");
        }
    }
    public void verifyUserAddedToGame(AppiumDriver driver){
        waitForVisibility(userAvatar, driver);
        Assert.assertTrue(userAvatar.isDisplayed());
>>>>>>> e7aad041656f51bcd7540c5837b667b08d8aa271
    }
}
