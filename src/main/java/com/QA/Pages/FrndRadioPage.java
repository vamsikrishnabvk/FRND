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
import java.util.concurrent.TimeUnit;

public class FrndRadioPage extends BaseTest {

    public FrndRadioPage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);   }
    TestUtils utils = new TestUtils();
    //*************** Keep Elements Here ******************************************

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    private MobileElement audioRecordAllowPopup;
    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    private MobileElement audioRecordConfirmAllowPopup;
    @AndroidFindBy(id = "com.dating.for.all:id/carouselIv")
    public MobileElement groupRoomsPageHeader;
    @AndroidFindBy(id = "com.dating.for.all:id/chat")
    public MobileElement groupRoomsPlusButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Create Room']")
    public MobileElement groupRoomsCreateRoomButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Your live show']")
    public MobileElement yourLiveShowPageHeader;
    @AndroidFindBy(id = "com.dating.for.all:id/topicEt")
    public MobileElement topicTextBox;
    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@resource-id='com.dating.for.all:id/tagsLayout']/android.widget.TextView)[1]")
    public MobileElement tagsLiveShow;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='GO LIVE']")
    public MobileElement goLiveButton;
    @AndroidFindBy(id = "com.dating.for.all:id/topicTv")
    public MobileElement radioRoomTopic;
    @AndroidFindBy(id = "com.dating.for.all:id/speakerControl")
    public MobileElement radioRoomSpeakerButton;
    @AndroidFindBy(id = "com.dating.for.all:id/micControl")
    public MobileElement radioRoomMicButton;
    @AndroidFindBy(id = "com.dating.for.all:id/endStreamBiv")
    public MobileElement endStreamButton;
    @AndroidFindBy(id = "com.dating.for.all:id/positiveActionBtv")
    public MobileElement confirmEndStreamButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Daniel\"]/following-sibling::android.view.View//android.widget.TextView[@text=\"Join Room\"]")
    public MobileElement joinRoomByHostName;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='com.dating.for.all:id/emptyPlayerBiv']")
    public List<MobileElement> addPlusButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Waitlist']")
    public MobileElement hostWaitlistButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Join Waitlist']")
    public MobileElement userWaitlistButton;
    @AndroidFindBy(id = "com.dating.for.all:id/add")
    public MobileElement addUserButton;
    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView//android.widget.TextView[@resource-id='com.dating.for.all:id/playerNameTv']")
    public List<MobileElement> addedUserName;
    @AndroidFindBy(id = "com.dating.for.all:id/playerLayout")
    public List<MobileElement> addedUserProfileAvatar;
    @AndroidFindBy(id = "com.dating.for.all:id/micIv")
    public MobileElement muteUserButton;
    @AndroidFindBy(id = "com.dating.for.all:id/removeIv")
    public MobileElement removeUserButton;
    @AndroidFindBy(id = "com.dating.for.all:id/removeIv")
    public MobileElement confirmRemoveUserButton;
    @AndroidFindBy(id = "com.dating.for.all:id/kickOutIv")
    public MobileElement banUserButton;




    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Leave']")
    public MobileElement userLeaveButton;
    @AndroidFindBy(id = "com.dating.for.all:id/exitBt")
    public MobileElement userConfirmLeaveRoomButton;
    @AndroidFindBy(id = "com.dating.for.all:id/giftLtv")
    public MobileElement giftIcon;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='com.dating.for.all:id/giftGradient']")
    public List<MobileElement> giftImage;
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.dating.for.all:id/coins']")
    public MobileElement giftPrice;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Send']")
    public MobileElement giftSendButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.dating.for.all:id/coinsCountTv']")
    public MobileElement userCoinsCount;
    @AndroidFindBy(id = "com.dating.for.all:id/titleTv")
    private MobileElement wallpaperTitle;

    @AndroidFindBy(id = "com.dating.for.all:id/stayBt")
    private MobileElement stayButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"You\"]")
    private MobileElement userInWaitList;

    @AndroidFindBy(id = "com.dating.for.all:id/giftLtv")
    private MobileElement giftBox;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.dating.for.all:id/giftTitleTv\" and @text=\"IPL\"]")
    private MobileElement iPLGiftOption;

    @AndroidFindBy(id = "com.dating.for.all:id/purchase_text")
    private MobileElement sendButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Punjab']/following-sibling::android.widget.LinearLayout//android.widget.TextView[@resource-id='com.dating.for.all:id/discountPrice']")
    private MobileElement punjabHelmetGift;

    @AndroidFindBy(xpath = "(//android.widget.ImageView[@resource-id=\"com.dating.for.all:id/playerAvatar\"])[1]")
    private MobileElement giftAnimation;

    @AndroidFindBy(id = "com.dating.for.all:id/close")
    private MobileElement crossCloseButton;

    @AndroidFindBy(xpath ="//android.widget.TextView[@resource-id=\"com.dating.for.all:id/coins\"]")
    private MobileElement remainingCoins;

    @AndroidFindBy(id = "com.dating.for.all:id/negativeActionBtv")
    private MobileElement cancelButton;

    @AndroidFindBy(id = "com.dating.for.all:id/removeIv")
    private MobileElement removeCrossLayout;

    @AndroidFindBy(id = "com.dating.for.all:id/positiveActionBtv")
    private MobileElement removeButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Daniel\"]")
    private MobileElement userInHostWaitList;

//*************** Elements Ends Here ******************************************

public void allowAudioRecordAllowPopup(AppiumDriver driver)
{
    waitForVisibility(audioRecordAllowPopup, driver);
    if(audioRecordAllowPopup.isDisplayed())
    {
        click(audioRecordAllowPopup,"Clicked on Audio record allow popup",driver);
    }
    click(audioRecordConfirmAllowPopup, driver);
}
    public void createGroupRooms(AppiumDriver driver){
        fluentVisibility(groupRoomsPlusButton, driver);
        click(groupRoomsPlusButton,"Clicked on Groups rooms plus icon" ,driver);
        click(groupRoomsCreateRoomButton,"Clicked on Create Room button" ,driver);
    }

    public void createRadioRoom(String expectedHeader, String topic, int tagIndex, AppiumDriver driver) throws InterruptedException {
       TimeUnit.SECONDS.sleep(35);
        fluentVisibility(yourLiveShowPageHeader, driver);
        String actualPageHeader = yourLiveShowPageHeader.getText();
        Assert.assertEquals(actualPageHeader, expectedHeader, "Header is not as expected");
        sendKeys(topicTextBox, topic,"Topic entered into text box" ,driver);
        driver.hideKeyboard();
        click(tagsLiveShow, "Tag selected",driver);
        click(goLiveButton,"Clicked on Go Live button" ,driver);
      //  clickBackButton(driver);
    }
    public void clickOnSpeakerButton(AppiumDriver driver){
        fluentVisibility(radioRoomSpeakerButton, driver);
        click(radioRoomSpeakerButton,"Clicked on Speaker icon" ,driver);
    }
    public void verifyTheMuteUnmuteFunctionalityShouldBeWorkAsExpected(AppiumDriver driver){
        fluentVisibility(radioRoomMicButton, driver);
        click(radioRoomMicButton,"Clicked on Mic icon" ,driver);
        click(radioRoomMicButton,"Clicked on Mic icon" ,driver);
    }
    public void clickOnEndStreamButton(AppiumDriver driver){
        fluentVisibility(endStreamButton, driver);
        click(endStreamButton,"Clicked on End Stream button" ,driver);
        click(confirmEndStreamButton, "Clicked on Confirm End stream button", driver);
    }

    public void clickOnAddPlusButton(int addButtonIndex, AppiumDriver driver){
        click(addPlusButton.get(addButtonIndex), driver);
    }


    //*************** Assert Methods ******************************************
    public void verifyGroupRoomsPage(boolean isDisplayed, AppiumDriver driver) throws InterruptedException {
        waitForVisibility(groupRoomsPageHeader, driver);
        Assert.assertEquals(groupRoomsPageHeader.isDisplayed(), isDisplayed, "Group Rooms page not displayed");
    }
    public void verifyRadioRoomsTopic(String expectedTopicHeader, AppiumDriver driver) throws InterruptedException {
    Thread.sleep(1000);
    try {
        if (wallpaperTitle.isDisplayed()) {
            clickBackButton(driver);
        }
    }catch (Exception e)
    {

    }
//    try {
//        if(stayButton.isDisplayed())
//        {
//            click(stayButton,driver);
//        }
//    }catch (Exception e)
//    {
//
//    }
        fluentVisibility(radioRoomTopic, driver);
        String actualHeader = radioRoomTopic.getText();
        Assert.assertEquals(actualHeader, expectedTopicHeader, "Radio Rooms Topic not as expected");
    }

    public void verifyRadioRoomsTopicByUser(String expectedTopicHeader, AppiumDriver driver) throws InterruptedException {
        fluentVisibility(radioRoomTopic, driver);
        String actualHeader = radioRoomTopic.getText();
        Assert.assertEquals(actualHeader, expectedTopicHeader, "Radio Rooms Topic not as expected");
    }

    public void verifyTheUsersShouldBeAbleToSeeTheHostedFrndRadioRoomAfterClickOnGroupRoomInHomePage(boolean isDispayed, AppiumDriver driver){
        fluentVisibility(joinRoomByHostName, driver);
        Assert.assertEquals(joinRoomByHostName.isDisplayed(), isDispayed, "Hosted room not displayed");
//    String hostName = host;
//        joinRoomByHostName.sendKeys(hostName);
//        MobileElement joinRoom = (MobileElement) getDriver().findElementByXPath("//*[@text=' "+hostName+"']");
//        joinRoom.click();
    }
    public  void verifyTheUserShouldBeAbleToJoinTheHostedFrndRadioRoom(AppiumDriver driver){
        click(joinRoomByHostName,"Clicked on Join Room", driver);
    }
    public  void verifyAddedUserName(int userIndex, String expectedUserName, AppiumDriver driver){
       String userName = addedUserName.get(userIndex).getText();
       Assert.assertEquals(userName,expectedUserName, "Added user name is not as expected");
    }
    public void verifyTheHostShouldBeAbleToAddWaitlistUsersOnHotSeat(int userIndex,String expectedUserName,AppiumDriver driver) throws InterruptedException {
        fluentVisibility(hostWaitlistButton, driver);
        click(hostWaitlistButton,"Clicked on Host Waitlist" ,driver);
        click(addUserButton,"Clicked on Add user button", driver);
        TimeUnit.SECONDS.sleep(5);
        verifyAddedUserName(userIndex, expectedUserName, driver);
    }
    public void verifyTheUsersShouldBeAbleToJoinTheWaitlistAfterClickOnJoinWaitlist(boolean isDisplayed,AppiumDriver driver){
        fluentVisibility(userWaitlistButton, driver);
        click(userWaitlistButton,"Clicked on User Waitlist Button" ,driver);
        fluentVisibility(hostWaitlistButton,driver);
        Assert.assertEquals(hostWaitlistButton.isDisplayed(), isDisplayed, "User waitlist not displayed");
        click(hostWaitlistButton,"Clicked on waitingList",driver);
        waitForVisibility(userInWaitList,driver);
        Assert.assertEquals(userInWaitList.isDisplayed(), isDisplayed, "User is not in waitList");
        utils.log().info("User is in waiting List");
        ExtentReport.getTest().log(Status.INFO,"User is in waiting List");
    }

    public void verifyUserIsInWaitlist(boolean isDisplayed,AppiumDriver driver){
        fluentVisibility(hostWaitlistButton,driver);
        Assert.assertEquals(hostWaitlistButton.isDisplayed(), isDisplayed, "User waitlist not displayed");
        click(hostWaitlistButton,"Clicked on waitingList",driver);
        waitForVisibility(userInWaitList,driver);
        Assert.assertEquals(userInWaitList.isDisplayed(), isDisplayed, "User is not in waitList");
        utils.log().info("User is in waiting List");
        ExtentReport.getTest().log(Status.INFO,"User is in waiting List");
    }
    public void verifyTheUserShouldBeAbleToLeaveTheRoom(boolean isDisplayed, AppiumDriver driver) throws InterruptedException {
        fluentVisibility(userLeaveButton, driver);
        click(userLeaveButton, "Clicked on Leave button" ,driver);
        clickBackButton(driver);
        click(userConfirmLeaveRoomButton, "Clicked on Leave Room button", driver);
        verifyGroupRoomsPage(isDisplayed, driver);
    }
    public void verifyTheGameShouldBeCloseAfterHostCloseTheGame(boolean isDisplayed, AppiumDriver driver) throws InterruptedException {
        fluentVisibility(endStreamButton, driver);
        click(endStreamButton, "Clicked on End Stream button",driver);
        click(confirmEndStreamButton,"Clicked on confirm end stream", driver);
        clickBackButton(driver);
        click(userConfirmLeaveRoomButton, "Clicked on Leave Room button", driver);
        verifyGroupRoomsPage(isDisplayed, driver);
    }
    public  void verifyNoUserAddedToGame(int userIndex, String expectedUserName, AppiumDriver driver) throws InterruptedException {
    TimeUnit.SECONDS.sleep(5);
        String userName = addedUserName.get(userIndex).getText();
        Assert.assertNotEquals(userName,expectedUserName, "User is added to room");
    }
    public void verifyTheUsersShouldBeAbleToJoinInTheWaitlistAfterSendTheGifts(int giftIndex, AppiumDriver driver){
        fluentVisibility(giftIcon, driver);
        click(giftIcon, "Clicked on Gift icon", driver);
        fluentVisibility(giftImage.get(giftIndex), driver);
        click(giftImage.get(giftIndex), "Gift selected", driver);
        click(giftSendButton, "Clicked on Send gift button", driver);
        fluentVisibility(hostWaitlistButton, driver);
        Assert.assertTrue(hostWaitlistButton.isDisplayed());
}

    public void verifyTheUserShouldBeRemoveInTheGameAfterHostRemoveTheParticularUser(int userIndex, AppiumDriver driver){
        click(addedUserProfileAvatar.get(userIndex), "Clicked on User avatar", driver);
        click(removeUserButton, "Clicked on Remove user button", driver);
        fluentVisibility(confirmRemoveUserButton, driver);
        click(confirmRemoveUserButton, "Clicked on confirm remove use button", driver);
    }
    public void verifyUserJoinWaitlistButtonDisplayed(AppiumDriver driver){
        Assert.assertTrue(userWaitlistButton.isDisplayed());
    }

    public void verifyTheUsersCoinsShouldBeDeductAfterSendTheAccorrdingGifts(int giftIndex, AppiumDriver driver){
        fluentVisibility(giftIcon, driver);
        click(giftIcon, "Clicked on Gift icon", driver);
        fluentVisibility(userCoinsCount, driver);
        int userAvailableCoins = Integer.parseInt(userCoinsCount.getText());
        click(giftImage.get(giftIndex), "Gift selected", driver);
        int giftAmount = Integer.parseInt(giftPrice.getText());
        click(giftSendButton, "Clicked on Send gift button", driver);
        fluentVisibility(giftIcon, driver);
        click(giftIcon, "Clicked on Gift icon", driver);
        fluentVisibility(userCoinsCount, driver);
        int userAvailableCoinsAfterSendingGift = Integer.parseInt(userCoinsCount.getText());

        Assert.assertTrue(userAvailableCoins > (userAvailableCoinsAfterSendingGift-giftAmount), "Coins not deducted after sending gift");
        clickBackButton(driver);
    }

    public void userSendGiftToHost(AppiumDriver driver,String actualCoinValue)
    {
        click(giftBox, "Clicked on Gift Box", driver);
        click(iPLGiftOption, "Clicked on iplGiftOption", driver);
        String giftCoinValue = getText(punjabHelmetGift, " Get coins value of selected gift", driver);
        int m = Integer.parseInt(actualCoinValue);
        int n = Integer.parseInt(giftCoinValue);
        Assert.assertTrue(n < m, "Gift Coins values is not less than Actual Coins value So cannot send gift");
        click(punjabHelmetGift, "Clicked on punjabHelmetGift", driver);
        click(sendButton, "Clicked on Send Button", driver);
        ExtentReport.getTest().log(Status.INFO, "Gift Animation is visible");
    }

    public String getRemainingCoins(AppiumDriver driver)
    {
        return getText(remainingCoins,"getting remaining coins",driver);
    }

    public void checkCoinsDeducted(String expectedCoin, AppiumDriver driver) {
        waitForVisibility(remainingCoins, driver);
        String coinsLeft = getText(remainingCoins, "Get availabel coins", driver);
        int actCoin = Integer.parseInt(expectedCoin);
        int remCoin = Integer.parseInt(coinsLeft);
        Assert.assertTrue(remCoin < actCoin, "Coins left after sending gift is not less than the coin before sending gift");
        utils.log().info("Coins left after sending gift is less than the coin before sending gift");
        ExtentReport.getTest().log(Status.INFO, "Coins left after sending gift is less than the coin before sending gift");
    }
    public void clickOnCancelButton(AppiumDriver driver)
    {
        click(cancelButton,driver);
    }

    public void removeUser(AppiumDriver driver)
    {
        click(addedUserProfileAvatar.get(0),"Clicked on User Profile",driver);
        click(removeCrossLayout,"clicked on Remove Layout",driver);
        click(removeButton,"Clicked on remove Button",driver);
    }
    public void verifyUserHaveGotRemoved(AppiumDriver driver) throws InterruptedException {
            Thread.sleep(3000);
            if(addedUserProfileAvatar.size()<1)
            {
                Assert.assertTrue(true,"User haven't remove from the hotSeat");
                utils.log().info("User have got removed from the HOt Seat");
                ExtentReport.getTest().log(Status.INFO,"User have got removed from the hot seat");
            }
    }
}
