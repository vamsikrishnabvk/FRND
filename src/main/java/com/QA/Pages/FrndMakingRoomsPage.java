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
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FrndMakingRoomsPage extends BaseTest {

    public FrndMakingRoomsPage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

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
    //android.widget.TextView[@text="FRND Making Rooms"]
    //android.widget.TextView[@text='FRND RJ']
    @AndroidFindBy(id = "com.dating.for.all.debug:id/frndChattingTitle")
    public MobileElement fRNDMakingLiveRoom;
    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    private MobileElement audioRecordAllowPopup;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    private MobileElement audioRecordConfirmAllowPopup;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Close Room']")
    public MobileElement closeLiveRoomPopup;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/close")
    public MobileElement closeLiveRoomCrossButton;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/close")
    public List<MobileElement> closeLiveRoomCrossButton1;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Join Room']")
    public MobileElement joinRoom;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Daniel']/following-sibling::android.view.View//android.widget.TextView[@text=\"Join Room\"]")
    public MobileElement joinRoomByUserName;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Experts will make your FRND']")
    public MobileElement frndPageTitleForUser;

//    @AndroidFindBy(xpath = "(//android.widget.FrameLayout/android.view.View)[2]")
//    public MobileElement joinWaitlistButton;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/add")
    public MobileElement joinWaitlistButton;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/add")
    public List<MobileElement> joinWaitlistButton1;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/addUser")
    public MobileElement addUserButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Add Boy']")
    public MobileElement addBoyButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Add Girl']")
    public MobileElement addGirlButton;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/add")
    public MobileElement waitlistAddButton;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/avatar")
    public MobileElement userAvatar;
    @AndroidFindBy(id = "//android.view.ViewGroup[@resource-id='com.dating.for.all.debug:id/maleSeat']//android.widget.ImageView[@resource-id='com.dating.for.all.debug:id/avatar']")
    public MobileElement maleUserAvatar;
    @AndroidFindBy(id = "//android.view.ViewGroup[@resource-id='com.dating.for.all.debug:id/femaleSeat']//android.widget.ImageView[@resource-id='com.dating.for.all.debug:id/avatar']")
    public MobileElement femaleUserAvatar;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/menuOptions")
    public MobileElement threeDotsOption;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/mic")
    public MobileElement hostMicOption;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/speaker")
    public MobileElement hostSpeakerOption;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/micIv")
    public MobileElement muteUnmuteUserButton;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/background")
    public MobileElement wallpaperButton;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/removeIv")
    public MobileElement removeUserButton;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/positiveActionBtv")
    public MobileElement confirmRemoveButtonOnPopup;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/negativeActionBtv")
    public MobileElement cancelRemoveButtonOnPopup;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/titleTv")
    public MobileElement removeUserPopupHeader;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/kickOutIv")
    public MobileElement banUserButton;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/profileIv")
    public MobileElement userProfileButton;
    @AndroidFindBy(xpath = "(//android.widget.ImageView[@resource-id='com.dating.for.all.debug:id/image'])[2]")
    public MobileElement userGiftIcon;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='com.dating.for.all.debug:id/image']")
    public List<MobileElement> giftIcon;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='com.dating.for.all.debug:id/image']")
    public MobileElement giftIcon1;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/purchase")
    public MobileElement userGiftSendButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Gifted')]")
    public MobileElement giftSendContentMessage;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/leaderboardGiftingCount")
    public MobileElement userCoinCount;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/leaderboardGiftingCount")
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
    @AndroidFindBy(xpath = "(//android.widget.TextView[@resource-id=\"com.dating.for.all.debug:id/free\"])[1]")
    public List<MobileElement> freeWallpaper;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/appliedTv")
    public List<MobileElement> wallpaperInUse;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/applyAddonButtonLayout")
    public MobileElement applyWallpaper;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/purchase_button")
    public MobileElement buyNowButton;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/coin_image")
    public MobileElement buyFreeWallpaperButton;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/positiveActionBtv")
    public MobileElement createNewRoomButton;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/exitBtv")
    public MobileElement exitButtonOnAdPopup;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/roomTimer")
    public MobileElement makingRoomTimer;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Apply\"]")
    public MobileElement applyButton;
    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    private List<MobileElement> audioRecordAllowPopup2;
    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    private List<MobileElement> allowFRNDToConnectPopup;
    @AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"FRND Making Rooms\"]/preceding-sibling::android.view.View)[2]")
    private MobileElement coinBalanceIcon;
    @AndroidFindBy(xpath = "//android.view.View[@resource-id=\"plus_icon\"]/following-sibling::android.view.View")
    private MobileElement redColourDot;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"FRND Making Rooms\"]/../following-sibling::android.view.View")
    private MobileElement animatedImages;
    @AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"Experts will make your FRND\"]/following-sibling::android.view.View//android.widget.TextView)[1]")
    private MobileElement rjLanguage;
    @AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"Experts will make your FRND\"]/following-sibling::android.view.View//android.widget.TextView)[2]")
    private MobileElement rjName;
    @AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"Experts will make your FRND\"]/following-sibling::android.view.View//android.widget.TextView)[3]")
    private MobileElement newBieLabel;
    @AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"Experts will make your FRND\"]/following-sibling::android.view.View//android.widget.TextView)[4]")
    private MobileElement ratingLabel;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/headingTv")
    private MobileElement beFriendMakingExpertHeading;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/content")
    private MobileElement commentMessage;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/leaderboardGiftingCount")
    private MobileElement coinsXXLeaderBoardOption;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/topFansText")
    private MobileElement topFansText;
    @AndroidFindBy(id ="com.dating.for.all.debug:id/liveLabel")
    private MobileElement liveLabel;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/rules")
    private MobileElement helpIcon;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/title")
    private MobileElement helpTitle;
    @AndroidFindBy(xpath = "//android.view.View[@resource-id=\"couple_rooms_layout\"]/android.view.View/android.view.View/following-sibling::android.widget.TextView[@text=\"Our experts will make your\n" +
            "FRND in 5 min\"]")
    private MobileElement fingerPointer;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/menuOptions")
    private MobileElement threeDotMenu;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/mic")
    private MobileElement mic;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/statusIndicator")
    private List<MobileElement> soundOffSymbol;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/speaker")
    private MobileElement volumeIcon;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/titleTv")
    private MobileElement wallpaperTitle;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/background")
    private MobileElement wallpaperIcon;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/playTutoriaVideoIv")
    private MobileElement videoPreviewIcon;
    @AndroidFindBy(xpath = "//android.view.View[@resource-id=\"com.dating.for.all.debug:id/exo_subtitles\"]")
    private MobileElement videoPreviewScreen;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/skipNowTv")
    private List<MobileElement> skipNowButton;
    @AndroidFindBy(id = "android:id/title")
    private MobileElement shareTitle;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/share")
    private MobileElement shareIcon;
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.dating.for.all.debug:id/content\" and @text=\"Joined the waitlist ⏰ \"]")
    private MobileElement userJoinedWaitingListMessage;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/giftSuggestion")
    private MobileElement giftBottomSheetSuggestion;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/skipWaitlist")
    private MobileElement skipWaitListButton;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/gifts")
    private MobileElement freeGiftBottomSheet;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/followingRoot")
    private MobileElement followingRoot;
    @AndroidFindBy(xpath = "(//android.widget.ImageView[@resource-id=\"com.dating.for.all.debug:id/statusIndicator\"])[1]")
    private List<MobileElement> mutedSign;
    @AndroidFindBy(xpath = "(//android.widget.ImageView[@resource-id=\"com.dating.for.all.debug:id/image\"])[4]")
    private MobileElement giftCakeItem;

    //*************** Elements Ends Here ******************************************

    public void clickOnPlusIcon(AppiumDriver driver) throws InterruptedException {
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
        click(createNewRoomButton, "Clicked on Plus Icon", driver);
    }

    public void allowAudioRecordAllowPopup(AppiumDriver driver) throws InterruptedException {
//        try {
//            waitForVisibility(audioRecordAllowPopup, driver);
//            if (audioRecordAllowPopup.isDisplayed()) {
//                click(audioRecordAllowPopup, "Clicked on Audio record allow popup", driver);
//            }
//           // Thread.sleep(1000);
//           // click(audioRecordConfirmAllowPopup, driver);
//        }catch (Exception e)
//        {
//
//        }
        Thread.sleep(2000);
        if (audioRecordAllowPopup2.size() == 1) {
            click(audioRecordAllowPopup2.get(0), "Clicked on Audio record popup2", driver);
        }
        Thread.sleep(2000);
        if (audioRecordAllowPopup2.size() == 1) {
            click(audioRecordAllowPopup2.get(0), "Clicked on Audio record popup2", driver);
        }
        if (allowFRNDToConnectPopup.size() == 1) {
            click(allowFRNDToConnectPopup.get(0), "Clicked on allow button", driver);
        }
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
        try {
            waitForVisibility(joinRoomByUserName, driver);
            click(joinRoomByUserName, "Clicked on Join Room button", driver);
        }catch (Exception e)
        {

        }
    }

    public void clickOnJoinWaitlistButton(AppiumDriver driver) throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        click(joinWaitlistButton, "Clicked on Join WaitList button", driver);
//        getDriver2().findElementByXPath("//*[@resource-id='com.dating.for.all.debug:id/add']").click();
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

    public void clickOnOptionsButton(AppiumDriver driver) throws InterruptedException {
        fluentVisibility(threeDotsOption, driver);
        Thread.sleep(1000);
        click(threeDotsOption, "Clicked on Three dots option", driver);
    }
    public void clickOnCancelButton(AppiumDriver driver)
    {
        try {
            click(cancelRemoveButtonOnPopup, "Clicked on Cancel Button", driver);
        }catch (Exception e)
        {

        }
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

    public void selectWallpaper(AppiumDriver driver) throws InterruptedException {
//        scrollIntoElement("FREE", "Scrolled to Free wallpaper", driver);
        waitForVisibility(freeWallpaper.get(0), driver);
        if(wallpaperInUse.size()==1)
        {
            click(wallpaperInUse.get(0),driver);
            click(applyWallpaper, driver);
        }
        else if(freeWallpaper.size()==1) {
            click(freeWallpaper.get(0),driver);
            click(buyNowButton,driver);
            clickOnOptionsButton(driver);
            clickOnWallpaperButton(driver);
            clickWallpaperPopupHeader(driver);
            swipeElementAndroid(wallpaperPopupHeader, Direction.UP, "Swipe to Wallpaper Popup", (AndroidDriver) driver);
            TimeUnit.SECONDS.sleep(10);
            click(wallpaperInUse.get(0),driver);
            click(applyWallpaper, driver);
        }
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
        TimeUnit.SECONDS.sleep(2);
        try {
            if (joinRoom.isDisplayed()) {
                click(joinRoom, "Clicked on Join Room button", driver);
                allowAudioRecordAllowPopup(driver);
                Thread.sleep(4000);
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
            if (joinRoomByUserName.isDisplayed()) {
                click(joinRoomByUserName, "Clicked on Join Room button", driver);
                allowAudioRecordAllowPopup(driver);
            }
        } catch (Exception ignored) {
        }
        try {
            if (joinRoom.isDisplayed()) {
                click(joinRoom, "Clicked on Join Room button", driver);
                allowAudioRecordAllowPopup(driver);
                Thread.sleep(4000);
                clickBackButton(driver);
                click(closeLiveRoomCrossButton, driver);
                click(joinRoomByUserName, driver);
            }
        } catch (Exception ignored) {
        }
    }

    public void waitTillFmrCallEnds() throws InterruptedException {
        TimeUnit.SECONDS.sleep(320);
    }

    //*************** Assert Methods ******************************************
    public void verifyFRNDMakingRoomsPageHeader(String expectedHeader, AppiumDriver driver) {
        try
        {
            if(exitButtonOnAdPopup.isDisplayed())
            {
                click(exitButtonOnAdPopup,"Clicked on Exit Button",driver);
            }
        }catch (Exception e)
        {

        }
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
        waitForVisibility(closeLiveRoomPopup, driver);
        String actualPageHeader = closeLiveRoomPopup.getText();
        Assert.assertEquals(actualPageHeader, expectedHeader, "Header is not as expected");
    }

    public void verifyFrndPageTitleForUser(String expectedHeader, AppiumDriver driver) {
        try
        {
            if(exitButtonOnAdPopup.isDisplayed())
            {
                click(exitButtonOnAdPopup,"Clicked on Exit Button",driver);
            }
        }catch (Exception e)
        {

        }
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
        String coinsLeft = getText(availableCoins, "Get available coins", driver).replace("K","");
        String actualCoin=expectedCoin.replace("K","");
        Float actCoin = Float.parseFloat(actualCoin);
        Float remCoin = Float.parseFloat(coinsLeft);
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
     //   clickOnExitButtonOnAdPopup(driver);
    }

    public void verifyThatHostAbleToKickoutTheUserInFrndMakingRoomClickingOnKickOutOption(boolean isDisplayed, String removeUserPopupHeader, String frndPageTitleForUser, AppiumDriver driver) {
        clickOnUserAvatar(driver);
        verifyRemoveUserButtonDisplayed(isDisplayed, driver);
        clickOnRemoveUserButton(getDriver1());
        verifyRemoveUserPopupHeader(removeUserPopupHeader, driver);
        clickOnConfirmRemoveUserOnPopup(driver);
    }

    public void verifyThatUserAbleToRemoveTheFrndMakingRoomWhenHostRemoveParticularUsers(String frndPageTitleForUser, AppiumDriver driver) {
        try
        {
            if(exitButtonOnAdPopup.isDisplayed())
            {
                click(exitButtonOnAdPopup,"Clicked on Exit Button",driver);
            }
        }catch (Exception e)
        {

        }
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
    }
    public void verifyUserNotAbleToHostFMR(AppiumDriver driver) throws InterruptedException {
      //  new ProfilePage(driver).verifyToastMessageUsingPageSource(toastMessage,driver);
        waitForVisibility(plusIcon,driver);
        Assert.assertTrue(plusIcon.isDisplayed(),"User is able to Host FMR");
        utils.log().info("User is not able to Host FMR");
        ExtentReport.getTest().log(Status.INFO,"User is not able to Host FMR");
    }
    public void CheckCoinsBalanceShowBesideTheUserProfileAtTheLeftTopCornerOfTheFMRScreen(AppiumDriver driver)
    {
        waitForVisibility(coinBalanceIcon,driver);
        Assert.assertTrue(coinBalanceIcon.isDisplayed(),"CoinBalance Icon is not displayed");
        utils.log().info("CoinBalance Icon is displayed");
        ExtentReport.getTest().log(Status.INFO,"CoinBalance Icon is displayed");
    }
    public void checkBeforeClickOnRedColourRedColouredDotOnTheOptionButton(AppiumDriver driver)
    {
        waitForVisibility(redColourDot,driver);
        Assert.assertTrue(redColourDot.isDisplayed(),"RedColour ");
    }
    public void checkAnimatedImagesDisplayedBackgroundOfTheFRNDMakingRoom(AppiumDriver driver)
    {
        waitForVisibility(animatedImages,driver);
        Assert.assertTrue(animatedImages.isDisplayed(),"Animated Images is not visible");
        utils.log().info("Animated Images is Displayed");
        ExtentReport.getTest().log(Status.INFO,"Animated Images is displayed");
    }
    public void checkIfTheJoinRoomOptionButtonDisplayedOnTheActiveUsersCard(AppiumDriver driver)
    {
        waitForVisibility(joinRoom,driver);
        Assert.assertTrue(joinRoom.isDisplayed(),"Join Room Button is not displayed");
        utils.log().info("Join Room Button is displayed");
        ExtentReport.getTest().log(Status.INFO,"Join Room Button is displayed");
    }
    public void verifyfTheHostedRJLanguageShouldBeDisplayedBelowTheAvatar(AppiumDriver driver)
    {
        waitForVisibility(rjLanguage,driver);
        Assert.assertTrue(rjLanguage.isDisplayed(),"RJ Language is not displayed");
        utils.log().info("RJ Language is displayed");
        ExtentReport.getTest().log(Status.INFO,"RJ Language is displayed");
    }
    public void checkRJProfileShowAvatarImageWithGreenDotOnItIfRJIsActiveWithLanguageNmeRating(AppiumDriver driver)
    {
        waitForVisibility(rjLanguage,driver);
        Assert.assertTrue(rjLanguage.isDisplayed() && rjName.isDisplayed() && newBieLabel.isDisplayed() && ratingLabel.isDisplayed(),"RjName Language NewBie Rating is not displayed");
        utils.log().info("RjName Language NewBie Rating is displayed");
        ExtentReport.getTest().log(Status.INFO,"RjName Language NewBie Rating is displayed");
    }
    public void verifyUserDoNotHaveRJAccessThenShouldShowApplyWhenClicksOnPlusIcon(AppiumDriver driver)
    {
        waitForVisibility(applyButton,driver);
        Assert.assertTrue(applyButton.isDisplayed(),"Apply Button is not displayed");
        utils.log().info("Apply Button is displayed");
        ExtentReport.getTest().log(Status.INFO,"Apply Button is displayed");
    }
    public void verifyUserClicksOnApplyButtonShouldOpenRJApplicationScreenShouldGetOpen(AppiumDriver driver)
    {
        waitForVisibility(beFriendMakingExpertHeading,driver);
        Assert.assertTrue(beFriendMakingExpertHeading.isDisplayed(),"RJ Application Screen is not open");
        utils.log().info("RJ Application Screen is open");
        ExtentReport.getTest().log(Status.INFO,"RJ Application Screen is open");
    }
    public void clickOnApplyButton(AppiumDriver driver)
    {
        click(applyButton,driver);
        utils.log().info("Clicked on Apply Button");
        ExtentReport.getTest().log(Status.INFO,"Clicked on Apply Button");
    }
    public void checkGiftIconShouldHaveAJumpingAnimationInFMRAndShouldBeProperlyClickable(AppiumDriver driver)
    {
        waitForVisibility(giftIcon1,driver);
        Assert.assertTrue(giftIcon1.isDisplayed(),"Moving Gift Animation is not Visible");
        utils.log().info("Clicked on Apply Button");
        ExtentReport.getTest().log(Status.INFO,"Clicked on Apply Button");
        click(giftIcon1,driver);
        waitForVisibility(userGiftIcon,driver);
        Assert.assertTrue(userGiftIcon.isDisplayed(),"Gifts are not visible");
        utils.log().info("GiftIcon is clickable");
        ExtentReport.getTest().log(Status.INFO,"GiftIcon is clickable");
    }
    public void verifyIfUserShouldShowACommentOnceHostHaveHostedFMR(AppiumDriver driver)
    {
        waitForVisibility(commentMessage,driver);
        Assert.assertTrue(commentMessage.isDisplayed(),"Comment Message not displayed");
        utils.log().info("Comment Message not displayed");
        ExtentReport.getTest().log(Status.INFO,"Comment Message not displayed");
    }
    public void giftAnimationVisibleToHost(AppiumDriver driver)
    {
        waitForVisibility(giftIcon1,driver);
        Assert.assertTrue(giftIcon1.isDisplayed(),"Gift Animation is not visible to host");
        utils.log().info("Gift Animation is visible to Host");
        ExtentReport.getTest().log(Status.INFO,"Gift Animation is visible to Host");
    }
    public void verifyUserBeAbleToClickOnCoinXXXLeaderboardOptionToOpenLeaderboardScreenOfFMRGame(AppiumDriver driver)
    {
        if(closeLiveRoomCrossButton1.size()==1)
        {
            click(closeLiveRoomCrossButton1.get(0),driver);
        }
        click(coinsXXLeaderBoardOption,driver);
        waitForVisibility(topFansText,driver);
        Assert.assertTrue(topFansText.isDisplayed(),"LeaderBoard Screen not visible");
        utils.log().info("LeaderBoard Screen visible");
        ExtentReport.getTest().log(Status.INFO,"LeaderBoard Screen visible");
        clickBackButton(driver);
    }
    public void verifyHelpOptionDisplayedRightSideOfHostCardInFMRGameShouldBeClickableAndShouldOpenHelpScreen(AppiumDriver driver)
    {
        click(helpIcon,driver);
        waitForVisibility(helpTitle,driver);
        Assert.assertTrue(helpTitle.isDisplayed(),"Help Screen not visible");
        utils.log().info("Help Screen Visible");
        ExtentReport.getTest().log(Status.INFO,"Help Screen Visible");
        click(closeLiveRoomCrossButton,driver);
    }
    public void checkUserShouldShowHostedFMRCardInFMRtabWithFingerPointerAnimationWhenUserOpensUpForTheFirstTime(AppiumDriver driver)
    {
        waitForVisibility(fingerPointer,driver);
        Assert.assertTrue(fingerPointer.isDisplayed(),"Finger Pointer is not displayed");
        utils.log().info("Finger Pointer is displayed");
        ExtentReport.getTest().log(Status.INFO,"Finger Pointer is displayed");
    }

    public void verifyThreeDotClickableAndAllIconsPresent(AppiumDriver driver) throws InterruptedException {
        click(threeDotMenu,driver);
        click(mic, "Clicked on Mic", driver);
        click(threeDotMenu,driver);
        click(mic, "Clicked on Mic", driver);
        Assert.assertTrue(soundOffSymbol.get(0).isDisplayed(), " Mic is not mute");
        ExtentReport.getTest().log(Status.INFO, "Mic is mute");
        click(threeDotMenu,driver);
        click(mic, " Clicked on mic", driver);
        Thread.sleep(1000);
        Assert.assertEquals(soundOffSymbol.size(), 0, "Mic is mute");
        click(threeDotMenu,driver);
        click(volumeIcon,driver);
        click(threeDotMenu,driver);
        click(volumeIcon,driver);
        click(threeDotMenu,driver);
        click(wallpaperIcon,driver);
        waitForVisibility(wallpaperTitle,driver);
        clickBackButton(driver);
        click(threeDotMenu,driver);
        click(shareIcon,driver);
        waitForVisibility(shareTitle,driver);
        clickBackButton(driver);
    }
    public void verifyIfJoinWaitlistButtonShouldProperlyClickableAndShouldDisappearsOnceClickedOnIt(AppiumDriver driver) throws InterruptedException {
        click(joinWaitlistButton,driver);
        Thread.sleep(2000);
        Assert.assertEquals(joinWaitlistButton1.size(),0,"WaitlingList Button is not disappear");
        utils.log().info("WaitlingList Button disappear");
        ExtentReport.getTest().log(Status.INFO,"WaitlingList Button disappear");
    }
    public void CheckOnceUserJoinsWaitlistHostShouldShowOptionOnParticularGenderCardWithAddBoyAndAddGirlButton(AppiumDriver driver)
    {
        waitForVisibility(addBoyButton,driver);
        Assert.assertTrue(addBoyButton.isDisplayed(),"Add Boy Button is not visible");
        utils.log().info("Add Boy Button is visible");
        ExtentReport.getTest().log(Status.INFO,"Add Boy Button is visible");
    }
    public void checkOnceUserJoinsWaitlistSshouldShowAcommentOnBackgroundAsUsernameJoinedTheWaitlist(AppiumDriver driver)
    {
        waitForVisibility(userJoinedWaitingListMessage,driver);
        Assert.assertTrue(userJoinedWaitingListMessage.isDisplayed(),"User Joined WaitingList message is not displayed");
        utils.log().info("User Joined WaitingList message is displayed");
        ExtentReport.getTest().log(Status.INFO,"User Joined WaitingList message is displayed");
    }
    public void verifyUserShouldShowAgiftBottomSheetOnceUserHaveJoinedWaitlist(AppiumDriver driver)
    {
        if(closeLiveRoomCrossButton1.size()==1)
        {
            click(closeLiveRoomCrossButton1.get(0),driver);
        }
        waitForVisibility(giftBottomSheetSuggestion,driver);
        Assert.assertTrue(giftBottomSheetSuggestion.isDisplayed(),"Gift Bottom Sheet Suggestion is not displayed");
        utils.log().info("GiftBottom Sheet Suggestion is displayed");
        ExtentReport.getTest().log(Status.INFO,"GiftBottom Sheet Suggestion is displayed");
    }
    public void verifyUserShouldShowSkipWaitlistOptionButtonAfterJoiningWaitlistWithGreenColouredBackground(AppiumDriver driver)
    {
        waitForVisibility(skipWaitListButton,driver);
        Assert.assertTrue(skipWaitListButton.isDisplayed(),"Skip WaitList Button is not displayed");
        utils.log().info("Skip WaitList Button is displayed");
        ExtentReport.getTest().log(Status.INFO,"Skip WaitList Button is displayed");
    }
    public void checkSkipWaitlistOptionButtonShouldclickableAndShouldShowFREEGiftsBottomSheet(AppiumDriver driver)
    {
        click(skipWaitListButton,driver);
        waitForVisibility(freeGiftBottomSheet,driver);
        Assert.assertTrue(freeGiftBottomSheet.isDisplayed(),"FreeGift Bottom sheet is not displayed");
        utils.log().info("FreeGift Bottom sheet is displayed");
        ExtentReport.getTest().log(Status.INFO,"FreeGift Bottom sheet is displayed");
    }
    public void checkIfUserClicksOnHostAvatarProfileScreenShouldOpenForHostUser(AppiumDriver driver)
    {
        click(userAvatar,driver);
        waitForVisibility(userProfileButton,driver);
        Assert.assertTrue(userProfileButton.isDisplayed(),"Profile Screen is not displayed");
        utils.log().info("Profile Screen is displayed");
        ExtentReport.getTest().log(Status.INFO,"Profile Screen is displayed");
    }
    public void verifyHostUserClicksOnUserAvatarThenBottomSheetShouldOpenUpWithMuteRemoveBanProfileOptionButton(AppiumDriver driver)
    {
        waitForVisibility(userProfileButton,driver);
        Assert.assertTrue(userProfileButton.isDisplayed() && muteUnmuteUserButton.isDisplayed() && removeUserButton.isDisplayed() && banUserButton.isDisplayed(),"Remove Ban Mute Profile Icon is not displayed");
        utils.log().info("Remove Ban Mute Profile Icon is displayed");
        ExtentReport.getTest().log(Status.INFO,"Remove Ban Mute Profile Icon is displayed");
    }
    public void verifyMuteRemoveBanProfileOptionsShouldBeClickableAndShouldWorkAsPerExpectedBehaviour(AppiumDriver driver) {
        click(muteUnmuteUserButton, driver);
        clickBackButton(driver);
        waitForVisibility(userAvatar, driver);
        Assert.assertTrue(mutedSign.get(0).isDisplayed(), "Muted Sign is not displayed");
        utils.log().info("Muted Sign is displayed");
        ExtentReport.getTest().log(Status.INFO, "Muted Sign is displayed");
        click(userAvatar, driver);
        click(muteUnmuteUserButton, driver);
        clickBackButton(driver);
        waitForVisibility(userAvatar, driver);
        Assert.assertEquals(mutedSign.size(), 0, "Muted Sign is displayed");
        utils.log().info("Muted Sign is not displayed");
        ExtentReport.getTest().log(Status.INFO, "Muted Sign is not displayed");
        click(userAvatar, driver);
        click(userProfileButton, driver);
        waitForVisibility(followingRoot, driver);
        Assert.assertTrue(followingRoot.isDisplayed(),"User profile page is not displayed");
        utils.log().info("User profile page is displayed");
        ExtentReport.getTest().log(Status.INFO, "User profile page is displayed");
        clickBackButton(driver);
    }
//    public void checkTheGiftsBottomSheetShouldBeProperlyScrollableToLeftToRightSide(AppiumDriver driver)
//    {
//        swipeElementAndroid(giftCakeItem,Direction.LEFT,driver);
//    }
}
