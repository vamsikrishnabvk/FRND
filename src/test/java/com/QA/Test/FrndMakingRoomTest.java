package com.QA.Test;

import com.QA.API.ApiUdateData;
import com.QA.Base.BaseTest;
import com.QA.DataBase.FetchValue;
import com.QA.Pages.FrndMakingRoomsPage;
import com.QA.Pages.HomePage;
import com.QA.Pages.LandingPage;
import com.QA.utlis.TestUtils;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.*;

import java.io.InputStream;
import java.lang.reflect.Method;

public class FrndMakingRoomTest extends BaseTest {
    LandingPage landingPage1, landingPage2, landingPage3;
    HomePage homePage1, homePage2, homePage3;
    //    FrndMakingRoomsPage frndMakingRoom1, frndMakingRoom2;
    FrndMakingRoomsPage frndMakingRoom1, frndMakingRoom2;
    JSONObject FrndMakingRoomTest;
    TestUtils utils = new TestUtils();
    FetchValue fetchValue;
    ApiUdateData apiUdateData;

    @BeforeClass
    public void beforeClass() throws Exception {
        InputStream datais = null;
        try {
            String dataFileName = "data/frndMakingRoomTest.json";
            datais = getClass().getClassLoader().getResourceAsStream(dataFileName);
            JSONTokener tokener = new JSONTokener(datais);
            FrndMakingRoomTest = new JSONObject(tokener);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (datais != null) {
                datais.close();
            }
        }
        //  closeApp();
        //    launchApp();
    }

    @AfterClass
    public void afterClass() {
        // getDriver().quit();
    }

    @BeforeMethod
    public void beforeMethod(Method m) {
        utils.log().info("\n" + "****** starting test:" + m.getName() + "******" + "\n");
        landingPage1 = new LandingPage(getDriver1());
        landingPage2 = new LandingPage(getDriver2());
       // landingPage3 = new LandingPage(getDriver3());
        homePage1 = new HomePage(getDriver1());
        homePage2 = new HomePage(getDriver2());
      //  homePage3 = new HomePage(getDriver3());
        frndMakingRoom1 = new FrndMakingRoomsPage(getDriver1());
        frndMakingRoom2 = new FrndMakingRoomsPage(getDriver2());
        fetchValue = new FetchValue();
        apiUdateData = new ApiUdateData();
    //    frndMakingRoom3 = new FrndMakingRoomsPage(getDriver3());
    }

    @AfterMethod
    public void afterMethod() {
        closeApp(getDriver1());
        closeApp(getDriver2());
     //   closeApp(getDriver3());
        launchApp(getDriver1());
        launchApp(getDriver2());
    //    launchApp(getDriver3());
    }

    //-------------------------- Test Below -----------------------------------------


    @Test(priority = 0, enabled = true, description = "Verify that user able to host the Frnd Making room")
    public void verifyThatUserAbleToHostTheFrndMakingroom() throws InterruptedException {
        String hostPhoneNumber = FrndMakingRoomTest.getJSONObject("FrndMakingRoomTest").getString("hostPhoneNumber");
        String userPhoneNumber = FrndMakingRoomTest.getJSONObject("FrndMakingRoomTest").getString("userPhoneNumber");
        String otp = FrndMakingRoomTest.getJSONObject("FrndMakingRoomTest").getString("otp");
        String beFrndMakingExpertpopupHeader = FrndMakingRoomTest.getJSONObject("Headers").getString("createMakingRoomPopupHeader");
        String frndMakingRoomsPageHeader = FrndMakingRoomTest.getJSONObject("Headers").getString("frndMakingRoomsPagePopupHeader");
        String frndMakingLiveRoomsPageHeader = FrndMakingRoomTest.getJSONObject("Headers").getString("frndMakingLiveRoomsPageHeader");
        String frndPageTitleForUser = FrndMakingRoomTest.getJSONObject("Headers").getString("frndPageTitleForUser");
        String closeLiveRoomPopupHeader = FrndMakingRoomTest.getJSONObject("Headers").getString("closeLiveRoomPopupHeader");
        String port8083 = FrndMakingRoomTest.getJSONObject("Ports").getString("portQA");
        Thread.sleep(2000);

        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.KEYCODE_VOLUME_DOWN(getDriver1());
        landingPage1.changingPort(port8083, getDriver1());
        landingPage2.handlingUpdatePopup(getDriver2());
        landingPage2.KEYCODE_VOLUME_DOWN(getDriver2());
        landingPage2.changingPort(port8083, getDriver2());
        landingPage1.loginToApplication(hostPhoneNumber, otp, getDriver1());
        String id = fetchValue.fetchValue(hostPhoneNumber);
        apiUdateData.fmrCohartUpdate(id,true,"http://qa.frndapp.in:8080","/automatedTesting/updateUser",hostPhoneNumber);
        landingPage2.loginToApplication(userPhoneNumber, otp, getDriver2());
        homePage1.handlingPopup(getDriver1());
        homePage1.clickOnFrndTab(getDriver1());
        frndMakingRoom1.verifyFRNDMakingRoomsPageHeader(frndMakingRoomsPageHeader, getDriver1());
        frndMakingRoom1.clickOnPlusIconAfterJoinRoom(getDriver1());
        frndMakingRoom1.verifyCreatedFrndMeetingRoom(frndMakingLiveRoomsPageHeader, getDriver1());

        frndMakingRoom1.verifyThatHostAbleToCloseTheRoomBeforeStartTheGame(closeLiveRoomPopupHeader, frndMakingRoomsPageHeader,getDriver1());
        frndMakingRoom1.clickOnJoinRoomByUserName(getDriver1());
        frndMakingRoom1.clickOnCreateNewRoomButton(getDriver1());
        frndMakingRoom1.checkTheMuteUnmuteFunctionalityIsWorkingAsExpected(getDriver1());

        homePage2.handlingPopup(getDriver2());
        homePage2.clickOnFrndTab(getDriver2());
        frndMakingRoom2.verifyThatUsersAreAbleToJoinTheFrndMakingRoomWithZeroCoinBalance(frndPageTitleForUser, frndMakingLiveRoomsPageHeader, getDriver2());
        frndMakingRoom2.verifyThatUserAbleToLeaveTheGameWithoutOnGame(frndMakingRoomsPageHeader, getDriver2());

        frndMakingRoom2.clickOnJoinRoomByUserName(getDriver2());
        frndMakingRoom2.clickOnJoinWaitlistButton(getDriver2());
        frndMakingRoom1.clickOnAddUserButton(getDriver1());
        frndMakingRoom1.clickOnWaitlistAddButton(getDriver1());
        frndMakingRoom1.verifyUserAddedToGame(true, getDriver1());

        frndMakingRoom1.verifyThatHostAbleToDoMuteUnmuteToUsers(true, getDriver1());
        frndMakingRoom2.verifyThatUserIsAbleToExitDuringTheGame(getDriver2());

    }

    @Test(priority = 1, enabled = true, description = "Verify that Host able to close the room before start the game")
    public void verifyThatHostAbleToCloseTheRoomBeforeStartTheGame() throws InterruptedException {
        String hostPhoneNumber = FrndMakingRoomTest.getJSONObject("FrndMakingRoomTest").getString("hostPhoneNumber");
        String userPhoneNumber = FrndMakingRoomTest.getJSONObject("FrndMakingRoomTest").getString("userPhoneNumber");
        String otp = FrndMakingRoomTest.getJSONObject("FrndMakingRoomTest").getString("otp");
        String beFrndMakingExpertpopupHeader = FrndMakingRoomTest.getJSONObject("Headers").getString("createMakingRoomPopupHeader");
        String frndMakingRoomsPageHeader = FrndMakingRoomTest.getJSONObject("Headers").getString("frndMakingRoomsPagePopupHeader");
        String frndMakingLiveRoomsPageHeader = FrndMakingRoomTest.getJSONObject("Headers").getString("frndMakingLiveRoomsPageHeader");
        String frndPageTitleForUser = FrndMakingRoomTest.getJSONObject("Headers").getString("frndPageTitleForUser");
        String closeLiveRoomPopupHeader = FrndMakingRoomTest.getJSONObject("Headers").getString("closeLiveRoomPopupHeader");
        String removeUserPopupHeader = FrndMakingRoomTest.getJSONObject("Headers").getString("removeUserPopupHeader");
        String port8083 = FrndMakingRoomTest.getJSONObject("Ports").getString("portQA");
        Thread.sleep(2000);

        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.KEYCODE_VOLUME_DOWN(getDriver1());
        landingPage1.changingPort(port8083, getDriver1());
        landingPage2.handlingUpdatePopup(getDriver2());
        landingPage2.KEYCODE_VOLUME_DOWN(getDriver2());
        landingPage2.changingPort(port8083, getDriver2());
        landingPage1.loginToApplication(hostPhoneNumber, otp, getDriver1());
        String id = fetchValue.fetchValue(hostPhoneNumber);
        apiUdateData.fmrCohartUpdate(id,true,"http://qa.frndapp.in:8080","/automatedTesting/updateUser",hostPhoneNumber);
        landingPage2.loginToApplication(userPhoneNumber, otp, getDriver2());
        homePage1.handlingPopup(getDriver1());

        homePage1.clickOnFrndTab(getDriver1());
        frndMakingRoom1.verifyFRNDMakingRoomsPageHeader(frndMakingRoomsPageHeader, getDriver1());
        frndMakingRoom1.clickOnPlusIconAfterJoinRoom(getDriver1());
        frndMakingRoom1.verifyCreatedFrndMeetingRoom(frndMakingLiveRoomsPageHeader, getDriver1());
        frndMakingRoom1.clickOnOptionsButton(getDriver1());
        frndMakingRoom1.clickOnMicButton(getDriver1());
        frndMakingRoom1.clickOnOptionsButton(getDriver1());
        frndMakingRoom1.clickOnSpeakerButton(getDriver1());

        homePage2.handlingPopup(getDriver2());
        homePage2.clickOnFrndTab(getDriver2());
        frndMakingRoom2.clickOnJoinRoomAndLeave(getDriver2());
        frndMakingRoom2.clickOnJoinWaitlistButton(getDriver2());
        frndMakingRoom1.clickOnAddUserButton(getDriver1());
        frndMakingRoom1.clickOnWaitlistAddButton(getDriver1());
        frndMakingRoom1.verifyUserAddedToGame(true, getDriver1());

        String previousCoinCount = frndMakingRoom1.getAvailableCoin(getDriver1());
        frndMakingRoom2.clickOnSendGift(getDriver2());
        frndMakingRoom2.verifyGiftSentContentMessageDisplayed(true, getDriver2());
        frndMakingRoom1.verifyGiftingAmountOnFrndMakingRoom(previousCoinCount,getDriver1());

        frndMakingRoom1.verifyIfHostShouldBeAbleToApplyTheGiftedWallpaperDuringTheGame(getDriver1());

        frndMakingRoom1.verifyThatHostAbleToKickoutTheUserInFrndMakingRoomClickingOnKickOutOption(true, removeUserPopupHeader,frndPageTitleForUser, getDriver1());
        frndMakingRoom2.verifyThatUserAbleToRemoveTheFrndMakingRoomWhenHostRemoveParticularUsers(frndPageTitleForUser, getDriver2());
        homePage2.verifyCallNowBannerDisplayed(true, getDriver2());

        homePage2.clickOnFrndTab(getDriver2());
        frndMakingRoom2.clickOnJoinRoomAndLeave(getDriver2());
        frndMakingRoom2.clickOnJoinWaitlistButton(getDriver2());
        frndMakingRoom1.clickOnAddUserButton(getDriver1());
        frndMakingRoom1.clickOnWaitlistAddButton(getDriver1());
        frndMakingRoom1.verifyUserAddedToGame(true, getDriver1());

        frndMakingRoom1.verifyThatHostAbleToCloseTheRoomDuringTheGame(closeLiveRoomPopupHeader, getDriver1());
    }


    @Test(priority = 2, enabled = true, description = "Verify that coin balance is deducted when user send the Gifts")
    public void verifyThatCoinBalanceIsDeductedWhenUserSendTheGifts() throws InterruptedException {
        String hostPhoneNumber = FrndMakingRoomTest.getJSONObject("FrndMakingRoomTest").getString("hostPhoneNumber");
        String userPhoneNumber = FrndMakingRoomTest.getJSONObject("FrndMakingRoomTest").getString("userPhoneNumber");
        String otp = FrndMakingRoomTest.getJSONObject("FrndMakingRoomTest").getString("otp");
        String beFrndMakingExpertpopupHeader = FrndMakingRoomTest.getJSONObject("Headers").getString("createMakingRoomPopupHeader");
        String frndMakingRoomsPageHeader = FrndMakingRoomTest.getJSONObject("Headers").getString("frndMakingRoomsPagePopupHeader");
        String frndMakingLiveRoomsPageHeader = FrndMakingRoomTest.getJSONObject("Headers").getString("frndMakingLiveRoomsPageHeader");
        String frndPageTitleForUser = FrndMakingRoomTest.getJSONObject("Headers").getString("frndPageTitleForUser");
        String closeLiveRoomPopupHeader = FrndMakingRoomTest.getJSONObject("Headers").getString("closeLiveRoomPopupHeader");
        String port8083 = FrndMakingRoomTest.getJSONObject("Ports").getString("portQA");
        Thread.sleep(2000);

        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.KEYCODE_VOLUME_DOWN(getDriver1());
        landingPage1.changingPort(port8083, getDriver1());
        landingPage2.handlingUpdatePopup(getDriver2());
        landingPage2.KEYCODE_VOLUME_DOWN(getDriver2());
        landingPage2.changingPort(port8083, getDriver2());
        landingPage1.loginToApplication(hostPhoneNumber, otp, getDriver1());
        String id = fetchValue.fetchValue(hostPhoneNumber);
        apiUdateData.fmrCohartUpdate(id,true,"http://qa.frndapp.in:8080","/automatedTesting/updateUser",hostPhoneNumber);
        landingPage2.loginToApplication(userPhoneNumber, otp, getDriver2());
        homePage1.handlingPopup(getDriver1());

        homePage1.clickOnFrndTab(getDriver1());
        frndMakingRoom1.verifyFRNDMakingRoomsPageHeader(frndMakingRoomsPageHeader, getDriver1());
        frndMakingRoom1.clickOnPlusIconAfterJoinRoom(getDriver1());
     //   frndMakingRoom1.verifyBeFRNDMakingExpertPopup(beFrndMakingExpertpopupHeader, getDriver1());//
      //  frndMakingRoom1.clickOnCreateRoomButton(getDriver1());//
        frndMakingRoom1.allowAudioRecordAllowPopup(getDriver1());
        frndMakingRoom1.verifyCreatedFrndMeetingRoom(frndMakingLiveRoomsPageHeader, getDriver1());
        frndMakingRoom1.clickOnOptionsButton(getDriver1());
        frndMakingRoom1.clickOnMicButton(getDriver1());
        frndMakingRoom1.clickOnOptionsButton(getDriver1());
        frndMakingRoom1.clickOnSpeakerButton(getDriver1());

        homePage2.handlingPopup(getDriver2());
        String text = homePage2.getAvailableCoin(getDriver1());
        homePage2.clickOnFrndTab(getDriver2());
        frndMakingRoom2.verifyFrndPageTitleForUser(frndPageTitleForUser, getDriver2());
        frndMakingRoom2.clickOnJoinRoom(getDriver2());
        frndMakingRoom2.allowAudioRecordAllowPopup(getDriver2());
        frndMakingRoom2.clickOnJoinWaitlistButton(getDriver2());

        frndMakingRoom1.clickOnAddUserButton(getDriver1());
        frndMakingRoom1.clickOnWaitlistAddButton(getDriver1());
        frndMakingRoom1.verifyUserAddedToGame(true, getDriver1());

        frndMakingRoom2.clickOnSendGift(getDriver1());
        frndMakingRoom2.verifyGiftSentContentMessageDisplayed(true, getDriver2());
        frndMakingRoom2.checkCoinsDeducted(text, getDriver2());
    }

    @Test(priority = 3, enabled = true, description = "Verify that banned users should not be allowed back to join the same room")
    public void verifyThatBannedUsersShouldNotBeAllowedBackToJoinTheSameRoom() throws InterruptedException {
        String hostPhoneNumber = FrndMakingRoomTest.getJSONObject("FrndMakingRoomTest").getString("hostPhoneNumber");
        String userPhoneNumber = FrndMakingRoomTest.getJSONObject("FrndMakingRoomTest").getString("userPhoneNumber");
        String otp = FrndMakingRoomTest.getJSONObject("FrndMakingRoomTest").getString("otp");
        String beFrndMakingExpertpopupHeader = FrndMakingRoomTest.getJSONObject("Headers").getString("createMakingRoomPopupHeader");
        String frndMakingRoomsPageHeader = FrndMakingRoomTest.getJSONObject("Headers").getString("frndMakingRoomsPagePopupHeader");
        String frndMakingLiveRoomsPageHeader = FrndMakingRoomTest.getJSONObject("Headers").getString("frndMakingLiveRoomsPageHeader");
        String frndPageTitleForUser = FrndMakingRoomTest.getJSONObject("Headers").getString("frndPageTitleForUser");
        String closeLiveRoomPopupHeader = FrndMakingRoomTest.getJSONObject("Headers").getString("closeLiveRoomPopupHeader");
        String banUserPopupHeader = FrndMakingRoomTest.getJSONObject("Headers").getString("banUserPopupHeader");
        String port8083 = FrndMakingRoomTest.getJSONObject("Ports").getString("portQA");
        Thread.sleep(2000);
        landingPage2.handlingUpdatePopup(getDriver2());
        landingPage2.KEYCODE_VOLUME_DOWN(getDriver2());
        landingPage2.changingPort(port8083,getDriver2());
        int i = getRandomNum();
        String phonNum = "789012"+Integer.toString(i);
        landingPage2.clickOnLetsGoButton(getDriver2());
        landingPage2.enterMobileNumber(phonNum,getDriver2());
        landingPage2.clickOnGetOTPButton(getDriver2());
        landingPage2.enterOTPNumber(otp,getDriver2());
        landingPage2.clickOnSubmitButton(getDriver2());
        landingPage2.enterNickName(getDriver2(),"Daniel");
        landingPage2.clickOnSelectGenderButton(getDriver2());
        landingPage2.clickOnBoyGender(getDriver2());
        landingPage2.clickOnDateOfBirthButtonAndOkButton(getDriver2());
        landingPage2.clickOnSignInSubmitButton(getDriver2());
        landingPage2.selectLanguage(getDriver2());
        landingPage2.checkCyberManifestoPolicies(getDriver2());
        landingPage2.selectAppLanguage(getDriver2());
        homePage2.handlingPopup(getDriver2());
        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.KEYCODE_VOLUME_DOWN(getDriver1());
        landingPage1.changingPort(port8083, getDriver1());
        landingPage1.loginToApplication("7890134512", otp, getDriver1());
        String id = fetchValue.fetchValue("7890134512");
        apiUdateData.fmrCohartUpdate(id,true,"http://qa.frndapp.in:8080","/automatedTesting/updateUser","7890134512");
        homePage1.handlingPopup(getDriver1());
        homePage1.clickOnFrndTab(getDriver1());
        frndMakingRoom1.verifyFRNDMakingRoomsPageHeader(frndMakingRoomsPageHeader, getDriver1());
        frndMakingRoom1.clickOnPlusIconAfterJoinRoom(getDriver1());//
      //  frndMakingRoom1.clickOnPlusIcon(getDriver1());
       // frndMakingRoom1.verifyBeFRNDMakingExpertPopup(beFrndMakingExpertpopupHeader, getDriver1());
      //  frndMakingRoom1.clickOnCreateRoomButton(getDriver1());
        frndMakingRoom1.allowAudioRecordAllowPopup(getDriver1());
        frndMakingRoom1.verifyCreatedFrndMeetingRoom(frndMakingLiveRoomsPageHeader, getDriver1());
        frndMakingRoom1.clickOnOptionsButton(getDriver1());
        frndMakingRoom1.clickOnMicButton(getDriver1());
        frndMakingRoom1.clickOnOptionsButton(getDriver1());
        frndMakingRoom1.clickOnSpeakerButton(getDriver1());
        homePage2.handlingPopup(getDriver2());
        homePage2.clickOnFrndTab(getDriver2());
        frndMakingRoom2.clickOnJoinRoomAndLeave(getDriver2());//
       // frndMakingRoom2.clickOnJoinRoomByUserName(getDriver2());
        frndMakingRoom2.allowAudioRecordAllowPopup(getDriver2());
        frndMakingRoom2.clickOnJoinWaitlistButton(getDriver2());
        frndMakingRoom1.clickOnAddUserButton(getDriver1());
        frndMakingRoom1.clickOnWaitlistAddButton(getDriver1());
        frndMakingRoom1.verifyUserAddedToGame(true, getDriver1());
        frndMakingRoom1.clickOnUserAvatar(getDriver1());
        frndMakingRoom1.verifyBanUserButtonDisplayed(true, getDriver1());
        frndMakingRoom1.clickOnBanUserButton(getDriver1());
        frndMakingRoom1.verifyBanUserPopupHeader(banUserPopupHeader, getDriver1());
        frndMakingRoom1.selectBanUserReason(1, getDriver1());
        frndMakingRoom1.clickOnBanButtonOnPopup(getDriver1());
        frndMakingRoom1.clickOnPunishButtonOnPopup(getDriver1());
        frndMakingRoom2.clickOnIPromiseButtonOnWarningPopup(getDriver2());
        frndMakingRoom2.verifyFrndPageTitleForUser(frndPageTitleForUser, getDriver2());
        frndMakingRoom2.clickOnJoinRoom(getDriver2());
        frndMakingRoom2.verifyFrndPageTitleForUser(frndPageTitleForUser, getDriver2());
    }

    @Test(priority = 4, enabled = false, description = "Verify that audio game timer should be start when filled the all seats")
    public void verifyThatAudioGameTimerShouldBeStartWhenFilledTheAllSeats() throws InterruptedException {
        String hostPhoneNumber = FrndMakingRoomTest.getJSONObject("FrndMakingRoomTest").getString("hostPhoneNumber");
        String userPhoneNumber = FrndMakingRoomTest.getJSONObject("FrndMakingRoomTest").getString("userPhoneNumber");
        String otp = FrndMakingRoomTest.getJSONObject("FrndMakingRoomTest").getString("otp");
        String beFrndMakingExpertpopupHeader = FrndMakingRoomTest.getJSONObject("Headers").getString("createMakingRoomPopupHeader");
        String frndMakingRoomsPageHeader = FrndMakingRoomTest.getJSONObject("Headers").getString("frndMakingRoomsPagePopupHeader");
        String frndMakingLiveRoomsPageHeader = FrndMakingRoomTest.getJSONObject("Headers").getString("frndMakingLiveRoomsPageHeader");
        String frndPageTitleForUser = FrndMakingRoomTest.getJSONObject("Headers").getString("frndPageTitleForUser");
        String closeLiveRoomPopupHeader = FrndMakingRoomTest.getJSONObject("Headers").getString("closeLiveRoomPopupHeader");
        String banUserPopupHeader = FrndMakingRoomTest.getJSONObject("Headers").getString("banUserPopupHeader");
        String port8083 = FrndMakingRoomTest.getJSONObject("Ports").getString("portQA");
        String user2PhoneNumber = FrndMakingRoomTest.getJSONObject("FrndMakingRoomTest").getString("user2PhoneNumber");
        Thread.sleep(2000);
        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.KEYCODE_VOLUME_DOWN(getDriver1());
        landingPage1.changingPort(port8083, getDriver1());
        landingPage2.handlingUpdatePopup(getDriver2());
        landingPage2.KEYCODE_VOLUME_DOWN(getDriver2());
        landingPage2.changingPort(port8083, getDriver2());
        landingPage3.handlingUpdatePopup(getDriver3());
        landingPage3.KEYCODE_VOLUME_DOWN(getDriver3());
        landingPage3.changingPort(port8083, getDriver3());
        landingPage1.loginToApplication(hostPhoneNumber, otp, getDriver1());
        landingPage2.loginToApplication(userPhoneNumber, otp, getDriver2());
        landingPage3.loginToApplication(user2PhoneNumber, otp, getDriver3());
        homePage1.handlingPopup(getDriver1());
        homePage1.clickOnFrndTab(getDriver1());
        frndMakingRoom1.verifyFRNDMakingRoomsPageHeader(frndMakingRoomsPageHeader, getDriver1());
        frndMakingRoom1.clickOnPlusIcon(getDriver1());
        frndMakingRoom1.verifyBeFRNDMakingExpertPopup(beFrndMakingExpertpopupHeader, getDriver1());
        frndMakingRoom1.clickOnCreateRoomButton(getDriver1());
        frndMakingRoom1.allowAudioRecordAllowPopup(getDriver1());
        frndMakingRoom1.verifyCreatedFrndMeetingRoom(frndMakingLiveRoomsPageHeader, getDriver1());
        frndMakingRoom1.clickOnOptionsButton(getDriver1());
        frndMakingRoom1.clickOnSpeakerButton(getDriver1());
        homePage2.handlingPopup(getDriver2());
        homePage2.clickOnFrndTab(getDriver2());
        frndMakingRoom2.verifyFrndPageTitleForUser(frndPageTitleForUser, getDriver2());
        frndMakingRoom2.clickOnJoinRoom(getDriver2());
        frndMakingRoom2.allowAudioRecordAllowPopup(getDriver2());
        frndMakingRoom2.clickOnOptionsButton(getDriver2());
        frndMakingRoom2.clickOnSpeakerButton(getDriver2());
        frndMakingRoom2.clickOnJoinWaitlistButton(getDriver2());
        frndMakingRoom1.clickOnAddBoyButton(getDriver1());
        frndMakingRoom1.clickOnWaitlistAddButton(getDriver1());
        frndMakingRoom1.verifyUserAddedToGame(true, getDriver1());
        homePage3.handlingPopup(getDriver3());
        homePage3.clickOnFrndTab(getDriver3());
//        frndMakingRoom3.verifyFrndPageTitleForUser(frndPageTitleForUser, getDriver3());
//        frndMakingRoom3.clickOnJoinRoom(getDriver3());
//        frndMakingRoom3.allowAudioRecordAllowOnPopup(getDriver3());
//        frndMakingRoom3.clickOnOptionsButton(getDriver3());
//        frndMakingRoom3.clickOnSpeakerButton(getDriver3());
//        frndMakingRoom3.clickOnJoinWaitlistButton(getDriver3());
        frndMakingRoom1.clickOnAddGirlButton(getDriver1());
        frndMakingRoom1.clickOnWaitlistAddButton(getDriver1());
        frndMakingRoom1.verifyUserAddedToGame(true, getDriver1());
        frndMakingRoom1.verifyMakingRoomTimerDisplayed(true, getDriver1());
        frndMakingRoom1.waitTillFmrCallEnds();
        frndMakingRoom2.verifyThatUserIsAbleToExitAfterFmrCall(getDriver2());
//        frndMakingRoom3.verifyThatUserIsAbleToExitAfterFmrCall(getDriver3());
    }

}
