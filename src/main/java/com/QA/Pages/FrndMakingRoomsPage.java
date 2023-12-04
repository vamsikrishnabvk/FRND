package com.QA.Pages;

import com.QA.Base.BaseTest2;
import com.QA.utlis.TestUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class FrndMakingRoomsPage extends BaseTest2 {

    public FrndMakingRoomsPage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);   }
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
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Experts will make your FRND']")
    public MobileElement frndPageTitleForUser;
    @AndroidFindBy(xpath = "(//android.widget.FrameLayout/android.view.View)[2]")
    public MobileElement joinWaitlistButton;
    @AndroidFindBy(id = "com.dating.for.all:id/addUser")
    public MobileElement addUserButton;
    @AndroidFindBy(id = "com.dating.for.all:id/add")
    public MobileElement waitlistAddButton;
    @AndroidFindBy(id = "com.dating.for.all:id/avatar")
    public MobileElement userAvatar;
    @AndroidFindBy(id = "com.dating.for.all:id/menuOptions")
    public MobileElement threeDotsOption;
    @AndroidFindBy(id = "com.dating.for.all:id/mic")
    public MobileElement hostMicOption;
    @AndroidFindBy(id = "com.dating.for.all:id/speaker")
    public MobileElement hostSpeakerOption;


    //*************** Elements Ends Here ******************************************

    public void clickOnPlusIcon(AppiumDriver driver) throws InterruptedException {
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
        waitForVisibility(closeLiveRoomPopup, driver);
        String actualPageHeader = closeLiveRoomPopup.getText();
        Assert.assertEquals(actualPageHeader, expectedHeader, "Header is not as expected");
    }
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
    }
}
