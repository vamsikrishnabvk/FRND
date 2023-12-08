package com.QA.Test;

<<<<<<< HEAD
import com.QA.Base.BaseTest;
import com.QA.Pages.FrndMakingRoomsPage;
import com.QA.Pages.HomePage;
import com.QA.Pages.LandingPage;
=======
import com.QA.Base.BaseTest2;
import com.QA.Pages.*;
>>>>>>> e7aad041656f51bcd7540c5837b667b08d8aa271
import com.QA.utlis.TestUtils;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.*;

import java.io.InputStream;
import java.lang.reflect.Method;

<<<<<<< HEAD
public class FrndMakingRoomTest extends BaseTest {
    LandingPage landingPage1, landingPage2, landingPage3;
    HomePage homePage1, homePage2, homePage3;
    //    FrndMakingRoomsPage frndMakingRoom1, frndMakingRoom2;
    FrndMakingRoomsPage frndMakingRoom1, frndMakingRoom2, frndMakingRoom3;
    JSONObject FrndMakingRoomTest;
=======
public class FrndMakingRoomTest extends BaseTest2 {
    LandingPage landingPage1,landingPage2;
    HomePage homePage1,homePage2;
    FrndMakingRoomsPage frndMakingRoom1, frndMakingRoom2;
    JSONObject LoginDetails;
>>>>>>> e7aad041656f51bcd7540c5837b667b08d8aa271
    TestUtils utils = new TestUtils();

    @BeforeClass
    public void beforeClass() throws Exception {
        InputStream datais = null;
        try {
<<<<<<< HEAD
            String dataFileName = "data/frndMakingRoomTest.json";
            datais = getClass().getClassLoader().getResourceAsStream(dataFileName);
            JSONTokener tokener = new JSONTokener(datais);
            FrndMakingRoomTest = new JSONObject(tokener);
=======
            String dataFileName = "data/loginDetails.json";
            datais = getClass().getClassLoader().getResourceAsStream(dataFileName);
            JSONTokener tokener = new JSONTokener(datais);
            LoginDetails = new JSONObject(tokener);
>>>>>>> e7aad041656f51bcd7540c5837b667b08d8aa271
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
<<<<<<< HEAD
        landingPage3 = new LandingPage(getDriver3());
        homePage1 = new HomePage(getDriver1());
        homePage2 = new HomePage(getDriver2());
        homePage3 = new HomePage(getDriver3());
        frndMakingRoom1 = new FrndMakingRoomsPage(getDriver1());
        frndMakingRoom2 = new FrndMakingRoomsPage(getDriver2());
        frndMakingRoom3 = new FrndMakingRoomsPage(getDriver3());
=======
        homePage1 = new HomePage(getDriver1());
        homePage2 = new HomePage(getDriver2());
        frndMakingRoom1 = new FrndMakingRoomsPage(getDriver1());
        frndMakingRoom2 = new FrndMakingRoomsPage(getDriver2());
>>>>>>> e7aad041656f51bcd7540c5837b667b08d8aa271
    }

    @AfterMethod
    public void afterMethod() {
        closeApp(getDriver1());
        closeApp(getDriver2());
<<<<<<< HEAD
        closeApp(getDriver3());
        launchApp(getDriver1());
        launchApp(getDriver2());
        launchApp(getDriver3());
=======
        launchApp(getDriver1());
        launchApp(getDriver2());
>>>>>>> e7aad041656f51bcd7540c5837b667b08d8aa271
    }

    //-------------------------- Test Below -----------------------------------------


<<<<<<< HEAD
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
        String port8083 = FrndMakingRoomTest.getJSONObject("Ports").getString("port8083");
        Thread.sleep(8000);

        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.KEYCODE_VOLUME_DOWN(getDriver1());
        landingPage1.changingPort(port8083, getDriver1());
        landingPage2.handlingUpdatePopup(getDriver2());
        landingPage2.KEYCODE_VOLUME_DOWN(getDriver2());
        landingPage2.changingPort(port8083, getDriver2());
        landingPage1.loginToApplication(hostPhoneNumber, otp, getDriver1());
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
        String port8083 = FrndMakingRoomTest.getJSONObject("Ports").getString("port8083");
=======
    @Test(priority = 0,enabled = true, description = "Verify that user able to host the Frnd Making room")
    public void verifyThatUserAbleToHostTheFrndMakingroom() throws InterruptedException {
        String hostPhoneNumber = LoginDetails.getJSONObject("LoginDetails").getString("hostPhoneNumber");
        String otp = LoginDetails.getJSONObject("LoginDetails").getString("otp");
        String beFrndMakingExpertpopupHeader = LoginDetails.getJSONObject("Headers").getString("createMakingRoomPopupHeader");
        String frndMakingRoomsPageHeader = LoginDetails.getJSONObject("Headers").getString("frndMakingRoomsPagePopupHeader");
        String frndMakingLiveRoomsPageHeader = LoginDetails.getJSONObject("Headers").getString( "frndMakingLiveRoomsPageHeader");
        String portNum = LoginDetails.getJSONObject("Ports").getString( "port8088");
        Thread.sleep(8000);
        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.KEYCODE_VOLUME_DOWN(getDriver1());
        landingPage1.changingPort(portNum,getDriver1());
        landingPage1.loginToApplication(hostPhoneNumber,otp,getDriver1());
        homePage1.handlingPopup(getDriver1());
        homePage1.clickOnFrndTab(getDriver1());
        frndMakingRoom1.verifyFRNDMakingRoomsPageHeader(frndMakingRoomsPageHeader,getDriver1());
        frndMakingRoom1.clickOnPlusIcon(getDriver1());
        frndMakingRoom1.verifyBeFRNDMakingExpertPopup(beFrndMakingExpertpopupHeader, getDriver1());
        frndMakingRoom1.clickOnCreateRoomButton(getDriver1());
        frndMakingRoom1.allowAudioRecordAllowPopup(getDriver1());
        frndMakingRoom1.verifyCreatedFrndMeetingRoom(frndMakingLiveRoomsPageHeader,getDriver1());
    }

    @Test(priority = 1,enabled = true, description = "Verify that Host able to close the room before start the game")
    public void verifyThatHostAbleToCloseTheRoomBeforeStartTheGame() throws InterruptedException {
        String hostPhoneNumber = LoginDetails.getJSONObject("LoginDetails").getString("hostPhoneNumber");
        String otp = LoginDetails.getJSONObject("LoginDetails").getString("otp");
        String beFrndMakingExpertpopupHeader = LoginDetails.getJSONObject("Headers").getString("createMakingRoomPopupHeader");
        String frndMakingRoomsPageHeader = LoginDetails.getJSONObject("Headers").getString("frndMakingRoomsPagePopupHeader");
        String frndMakingLiveRoomsPageHeader = LoginDetails.getJSONObject("Headers").getString( "frndMakingLiveRoomsPageHeader");
        String closeLiveRoomPopupHeader = LoginDetails.getJSONObject("Headers").getString( "closeLiveRoomPopupHeader");
        String portNum = LoginDetails.getJSONObject("Ports").getString( "port8088");
>>>>>>> e7aad041656f51bcd7540c5837b667b08d8aa271
        Thread.sleep(8000);

        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.KEYCODE_VOLUME_DOWN(getDriver1());
<<<<<<< HEAD
        landingPage1.changingPort(port8083, getDriver1());
        landingPage2.handlingUpdatePopup(getDriver2());
        landingPage2.KEYCODE_VOLUME_DOWN(getDriver2());
        landingPage2.changingPort(port8083, getDriver2());
        landingPage1.loginToApplication(hostPhoneNumber, otp, getDriver1());
        landingPage2.loginToApplication(userPhoneNumber, otp, getDriver2());
        homePage1.handlingPopup(getDriver1());

        homePage1.clickOnFrndTab(getDriver1());
        frndMakingRoom1.verifyFRNDMakingRoomsPageHeader(frndMakingRoomsPageHeader, getDriver1());
        frndMakingRoom1.clickOnPlusIconAfterJoinRoom(getDriver1());
        frndMakingRoom1.verifyCreatedFrndMeetingRoom(frndMakingLiveRoomsPageHeader, getDriver1());
=======
        landingPage1.changingPort(portNum,getDriver1());
        landingPage1.loginToApplication(hostPhoneNumber,otp,getDriver1());
        homePage1.handlingPopup(getDriver1());
        homePage1.clickOnFrndTab(getDriver1());
        frndMakingRoom1.verifyFRNDMakingRoomsPageHeader(frndMakingRoomsPageHeader,getDriver1());
        frndMakingRoom1.clickOnPlusIcon(getDriver1());
        frndMakingRoom1.verifyBeFRNDMakingExpertPopup(beFrndMakingExpertpopupHeader, getDriver1());
        frndMakingRoom1.clickOnCreateRoomButton(getDriver1());
        frndMakingRoom1.allowAudioRecordAllowPopup(getDriver1());
        frndMakingRoom1.verifyCreatedFrndMeetingRoom(frndMakingLiveRoomsPageHeader,getDriver1());
        frndMakingRoom1.clickOnBackButtonOnLiveCall(getDriver1());
        frndMakingRoom1.verifyCloseFRNDMakingRoomsPopupHeader(closeLiveRoomPopupHeader, getDriver1());
        frndMakingRoom1.closeLiveRoomCrossButton(getDriver1());
        frndMakingRoom1.verifyFRNDMakingRoomsPageHeader(frndMakingRoomsPageHeader,getDriver1());
    }

    @Test(priority = 2,enabled = true, description = "Verify that users are able to join the frnd making room with zero coin balance")
    public void verifyThatUsersAreAbleToJoinTheFrndMakingRoomWithZeroCoinBalance() throws InterruptedException {
        String hostPhoneNumber = LoginDetails.getJSONObject("LoginDetails").getString("hostPhoneNumber");
        String otp = LoginDetails.getJSONObject("LoginDetails").getString("otp");
        String beFrndMakingExpertpopupHeader = LoginDetails.getJSONObject("Headers").getString("createMakingRoomPopupHeader");
        String frndMakingRoomsPageHeader = LoginDetails.getJSONObject("Headers").getString("frndMakingRoomsPagePopupHeader");
        String frndMakingLiveRoomsPageHeader = LoginDetails.getJSONObject("Headers").getString( "frndMakingLiveRoomsPageHeader");
        String frndPageTitleForUser = LoginDetails.getJSONObject("Headers").getString( "frndPageTitleForUser");
        String portNum = LoginDetails.getJSONObject("Ports").getString( "port8088");
        Thread.sleep(8000);
        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.KEYCODE_VOLUME_DOWN(getDriver1());
        landingPage1.changingPort(portNum, getDriver1());
        landingPage2.handlingUpdatePopup(getDriver2());
        landingPage2.KEYCODE_VOLUME_DOWN(getDriver2());
        landingPage2.changingPort(portNum, getDriver2());
        landingPage1.loginToApplication(hostPhoneNumber,otp,getDriver1());
        landingPage2.loginToApplication("7725924830",otp,getDriver2());
        homePage1.handlingPopup(getDriver1());

        homePage1.clickOnFrndTab(getDriver1());
        frndMakingRoom1.verifyFRNDMakingRoomsPageHeader(frndMakingRoomsPageHeader,getDriver1());
        frndMakingRoom1.clickOnPlusIcon(getDriver1());
        frndMakingRoom1.verifyBeFRNDMakingExpertPopup(beFrndMakingExpertpopupHeader, getDriver1());
        frndMakingRoom1.clickOnCreateRoomButton(getDriver1());
        frndMakingRoom1.allowAudioRecordAllowPopup(getDriver1());
        frndMakingRoom1.verifyCreatedFrndMeetingRoom(frndMakingLiveRoomsPageHeader,getDriver1());

        homePage2.handlingPopup(getDriver2());
        homePage2.clickOnFrndTab(getDriver2());
        frndMakingRoom2.verifyFrndPageTitleForUser(frndPageTitleForUser,getDriver2());
        frndMakingRoom2.clickOnJoinRoom(getDriver2());
        frndMakingRoom2.allowAudioRecordAllowPopup(getDriver2());
        frndMakingRoom2.verifyCreatedFrndMeetingRoom(frndMakingLiveRoomsPageHeader,getDriver2());
    }

    @Test(priority = 3,enabled = true, description = "Verify that user able to leave the game without ON game")
    public void verifyThatuserAbleToLeaveTheGameWithoutOnGame() throws InterruptedException {
        String hostPhoneNumber = LoginDetails.getJSONObject("LoginDetails").getString("hostPhoneNumber");
        String otp = LoginDetails.getJSONObject("LoginDetails").getString("otp");
        String beFrndMakingExpertpopupHeader = LoginDetails.getJSONObject("Headers").getString("createMakingRoomPopupHeader");
        String frndMakingRoomsPageHeader = LoginDetails.getJSONObject("Headers").getString("frndMakingRoomsPagePopupHeader");
        String frndMakingLiveRoomsPageHeader = LoginDetails.getJSONObject("Headers").getString( "frndMakingLiveRoomsPageHeader");
        String closeLiveRoomPopupHeader = LoginDetails.getJSONObject("Headers").getString( "closeLiveRoomPopupHeader");
        String frndPageTitleForUser = LoginDetails.getJSONObject("Headers").getString( "frndPageTitleForUser");
        String portNum = LoginDetails.getJSONObject("Ports").getString( "port8088");
        Thread.sleep(8000);

        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.KEYCODE_VOLUME_DOWN(getDriver1());
        landingPage1.changingPort(portNum, getDriver1());
        landingPage2.handlingUpdatePopup(getDriver2());
        landingPage2.KEYCODE_VOLUME_DOWN(getDriver2());
        landingPage2.changingPort(portNum, getDriver2());
        landingPage1.loginToApplication(hostPhoneNumber,otp,getDriver1());
        landingPage2.loginToApplication("7725924830",otp,getDriver2());
        homePage1.handlingPopup(getDriver1());

        homePage1.clickOnFrndTab(getDriver1());
        frndMakingRoom1.verifyFRNDMakingRoomsPageHeader(frndMakingRoomsPageHeader,getDriver1());
        frndMakingRoom1.clickOnPlusIcon(getDriver1());
        frndMakingRoom1.verifyBeFRNDMakingExpertPopup(beFrndMakingExpertpopupHeader, getDriver1());
        frndMakingRoom1.clickOnCreateRoomButton(getDriver1());
        frndMakingRoom1.allowAudioRecordAllowPopup(getDriver1());
        frndMakingRoom1.verifyCreatedFrndMeetingRoom(frndMakingLiveRoomsPageHeader,getDriver1());

        homePage2.handlingPopup(getDriver2());
        homePage2.clickOnFrndTab(getDriver2());
        frndMakingRoom2.verifyFrndPageTitleForUser(frndPageTitleForUser,getDriver2());
        frndMakingRoom2.clickOnJoinRoom(getDriver2());
        frndMakingRoom2.allowAudioRecordAllowPopup(getDriver2());
        frndMakingRoom2.verifyCreatedFrndMeetingRoom(frndMakingLiveRoomsPageHeader,getDriver2());
        frndMakingRoom2.clickOnBackButtonOnLiveCall(getDriver2());
        frndMakingRoom2.closeLiveRoomCrossButton(getDriver2());
        frndMakingRoom2.verifyFRNDMakingRoomsPageHeader(frndMakingRoomsPageHeader,getDriver2());
    }

    @Test(priority = 4,enabled = true, description = "Verify that Host able to close the room during the game")
    public void verifyThatHostAbleToCloseTheRoomDuringTheGame() throws InterruptedException {
        String hostPhoneNumber = LoginDetails.getJSONObject("LoginDetails").getString("hostPhoneNumber");
        String otp = LoginDetails.getJSONObject("LoginDetails").getString("otp");
        String beFrndMakingExpertpopupHeader = LoginDetails.getJSONObject("Headers").getString("createMakingRoomPopupHeader");
        String frndMakingRoomsPageHeader = LoginDetails.getJSONObject("Headers").getString("frndMakingRoomsPagePopupHeader");
        String frndMakingLiveRoomsPageHeader = LoginDetails.getJSONObject("Headers").getString( "frndMakingLiveRoomsPageHeader");
        String closeLiveRoomPopupHeader = LoginDetails.getJSONObject("Headers").getString( "closeLiveRoomPopupHeader");
        String frndPageTitleForUser = LoginDetails.getJSONObject("Headers").getString( "frndPageTitleForUser");
        String portNum = LoginDetails.getJSONObject("Ports").getString( "port8088");
        Thread.sleep(8000);

        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.KEYCODE_VOLUME_DOWN(getDriver1());
        landingPage1.changingPort(portNum, getDriver1());
        landingPage2.handlingUpdatePopup(getDriver2());
        landingPage2.KEYCODE_VOLUME_DOWN(getDriver2());
        landingPage2.changingPort(portNum, getDriver2());
        landingPage1.loginToApplication(hostPhoneNumber,otp,getDriver1());
        landingPage2.loginToApplication("7725924830",otp,getDriver2());
        homePage1.handlingPopup(getDriver1());

        homePage1.clickOnFrndTab(getDriver1());
        frndMakingRoom1.verifyFRNDMakingRoomsPageHeader(frndMakingRoomsPageHeader,getDriver1());
        frndMakingRoom1.clickOnPlusIcon(getDriver1());
        frndMakingRoom1.verifyBeFRNDMakingExpertPopup(beFrndMakingExpertpopupHeader, getDriver1());
        frndMakingRoom1.clickOnCreateRoomButton(getDriver1());
        frndMakingRoom1.allowAudioRecordAllowPopup(getDriver1());
        frndMakingRoom1.verifyCreatedFrndMeetingRoom(frndMakingLiveRoomsPageHeader,getDriver1());

        homePage2.handlingPopup(getDriver2());
        homePage2.clickOnFrndTab(getDriver2());
        frndMakingRoom2.verifyFrndPageTitleForUser(frndPageTitleForUser,getDriver2());
        frndMakingRoom2.clickOnJoinRoom(getDriver2());
        frndMakingRoom2.allowAudioRecordAllowPopup(getDriver2());
        frndMakingRoom2.verifyCreatedFrndMeetingRoom(frndMakingLiveRoomsPageHeader,getDriver2());
        frndMakingRoom2.clickOnJoinWaitlistButton(getDriver2());

        frndMakingRoom1.clickOnAddUserButton(getDriver1());
        frndMakingRoom1.clickOnWatchlistAddButton(getDriver1());
        frndMakingRoom1.verifyUserAddedToGame(getDriver1());

        frndMakingRoom1.clickOnBackButtonOnLiveCall(getDriver1());
        frndMakingRoom1.verifyCloseFRNDMakingRoomsPopupHeader(closeLiveRoomPopupHeader, getDriver1());
        frndMakingRoom1.closeLiveRoomCrossButton(getDriver1());
    }

    @Test(priority = 5,enabled = true, description = "Verify that user is able to exit during the game")
    public void verifyThatUserIsAbleToExitDuringTheGame() throws InterruptedException {
        String hostPhoneNumber = LoginDetails.getJSONObject("LoginDetails").getString("hostPhoneNumber");
        String otp = LoginDetails.getJSONObject("LoginDetails").getString("otp");
        String beFrndMakingExpertpopupHeader = LoginDetails.getJSONObject("Headers").getString("createMakingRoomPopupHeader");
        String frndMakingRoomsPageHeader = LoginDetails.getJSONObject("Headers").getString("frndMakingRoomsPagePopupHeader");
        String frndMakingLiveRoomsPageHeader = LoginDetails.getJSONObject("Headers").getString( "frndMakingLiveRoomsPageHeader");
        String closeLiveRoomPopupHeader = LoginDetails.getJSONObject("Headers").getString( "closeLiveRoomPopupHeader");
        String frndPageTitleForUser = LoginDetails.getJSONObject("Headers").getString( "frndPageTitleForUser");
        String portNum= LoginDetails.getJSONObject("Ports").getString( "port8088");
        Thread.sleep(8000);


        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.KEYCODE_VOLUME_DOWN(getDriver1());
        landingPage1.changingPort(portNum, getDriver1());
        landingPage2.handlingUpdatePopup(getDriver2());
        landingPage2.KEYCODE_VOLUME_DOWN(getDriver2());
        landingPage2.changingPort(portNum, getDriver2());
        landingPage1.loginToApplication(hostPhoneNumber,otp,getDriver1());
        landingPage2.loginToApplication("7725924830",otp,getDriver2());
        homePage1.handlingPopup(getDriver1());

        homePage1.clickOnFrndTab(getDriver1());
        frndMakingRoom1.verifyFRNDMakingRoomsPageHeader(frndMakingRoomsPageHeader,getDriver1());
        frndMakingRoom1.clickOnPlusIcon(getDriver1());
        frndMakingRoom1.verifyBeFRNDMakingExpertPopup(beFrndMakingExpertpopupHeader, getDriver1());
        frndMakingRoom1.clickOnCreateRoomButton(getDriver1());
        frndMakingRoom1.allowAudioRecordAllowPopup(getDriver1());
        frndMakingRoom1.verifyCreatedFrndMeetingRoom(frndMakingLiveRoomsPageHeader,getDriver1());
>>>>>>> e7aad041656f51bcd7540c5837b667b08d8aa271
        frndMakingRoom1.clickOnOptionsButton(getDriver1());
        frndMakingRoom1.clickOnMicButton(getDriver1());
        frndMakingRoom1.clickOnOptionsButton(getDriver1());
        frndMakingRoom1.clickOnSpeakerButton(getDriver1());

        homePage2.handlingPopup(getDriver2());
        homePage2.clickOnFrndTab(getDriver2());
<<<<<<< HEAD
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
        String port8083 = FrndMakingRoomTest.getJSONObject("Ports").getString("port8083");
        Thread.sleep(8000);

        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.KEYCODE_VOLUME_DOWN(getDriver1());
        landingPage1.changingPort(port8083, getDriver1());
        landingPage2.handlingUpdatePopup(getDriver2());
        landingPage2.KEYCODE_VOLUME_DOWN(getDriver2());
        landingPage2.changingPort(port8083, getDriver2());
        landingPage1.loginToApplication(hostPhoneNumber, otp, getDriver1());
        landingPage2.loginToApplication(userPhoneNumber, otp, getDriver2());
        homePage1.handlingPopup(getDriver1());

        homePage1.clickOnFrndTab(getDriver1());
        frndMakingRoom1.verifyFRNDMakingRoomsPageHeader(frndMakingRoomsPageHeader, getDriver1());
        frndMakingRoom1.clickOnPlusIcon(getDriver1());
        frndMakingRoom1.verifyBeFRNDMakingExpertPopup(beFrndMakingExpertpopupHeader, getDriver1());
        frndMakingRoom1.clickOnCreateRoomButton(getDriver1());
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
        String port8083 = FrndMakingRoomTest.getJSONObject("Ports").getString("port8083");
=======
        frndMakingRoom2.verifyFrndPageTitleForUser(frndPageTitleForUser,getDriver2());
        frndMakingRoom2.clickOnJoinRoom(getDriver2());
        frndMakingRoom2.allowAudioRecordAllowPopup(getDriver2());
        frndMakingRoom2.verifyCreatedFrndMeetingRoom(frndMakingLiveRoomsPageHeader,getDriver2());
        frndMakingRoom2.clickOnJoinWaitlistButton(getDriver2());

        frndMakingRoom1.clickOnAddUserButton(getDriver1());
        frndMakingRoom1.clickOnWatchlistAddButton(getDriver1());
        frndMakingRoom1.verifyUserAddedToGame(getDriver1());

        frndMakingRoom2.clickOnBackButtonOnLiveCall(getDriver2());
        frndMakingRoom2.closeLiveRoomCrossButton(getDriver2());
        frndMakingRoom2.verifyFrndPageTitleForUser(frndPageTitleForUser,getDriver2());
    }

    @Test(priority = 6,enabled = true, description = "Verify that host able to do mute/unmute/ to users")
    public void verifyThatHostAbleToDoMuteUnmuteToUsers() throws InterruptedException {
        String hostPhoneNumber = LoginDetails.getJSONObject("LoginDetails").getString("hostPhoneNumber");
        String otp = LoginDetails.getJSONObject("LoginDetails").getString("otp");
        String beFrndMakingExpertpopupHeader = LoginDetails.getJSONObject("Headers").getString("createMakingRoomPopupHeader");
        String frndMakingRoomsPageHeader = LoginDetails.getJSONObject("Headers").getString("frndMakingRoomsPagePopupHeader");
        String frndMakingLiveRoomsPageHeader = LoginDetails.getJSONObject("Headers").getString( "frndMakingLiveRoomsPageHeader");
        String closeLiveRoomPopupHeader = LoginDetails.getJSONObject("Headers").getString( "closeLiveRoomPopupHeader");
        String frndPageTitleForUser = LoginDetails.getJSONObject("Headers").getString( "frndPageTitleForUser");
        String portNum = LoginDetails.getJSONObject("Ports").getString( "port8088");
>>>>>>> e7aad041656f51bcd7540c5837b667b08d8aa271
        Thread.sleep(8000);

        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.KEYCODE_VOLUME_DOWN(getDriver1());
<<<<<<< HEAD
        landingPage1.changingPort(port8083, getDriver1());
        landingPage2.handlingUpdatePopup(getDriver2());
        landingPage2.KEYCODE_VOLUME_DOWN(getDriver2());
        landingPage2.changingPort(port8083, getDriver2());
        landingPage1.loginToApplication(hostPhoneNumber, otp, getDriver1());
        landingPage2.loginToApplication("8888877777", otp, getDriver2());
        homePage1.handlingPopup(getDriver1());

        homePage1.clickOnFrndTab(getDriver1());
        frndMakingRoom1.verifyFRNDMakingRoomsPageHeader(frndMakingRoomsPageHeader, getDriver1());
//        frndMakingRoom1.clickOnPlusIconAfterJoinRoom(getDriver1());
=======
        landingPage1.changingPort(portNum, getDriver1());
        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage2.KEYCODE_VOLUME_DOWN(getDriver2());
        landingPage2.changingPort(portNum, getDriver2());
        landingPage1.loginToApplication(hostPhoneNumber,otp,getDriver1());
        landingPage2.loginToApplication("7725924830",otp,getDriver2());
        homePage1.handlingPopup(getDriver1());

        homePage1.clickOnFrndTab(getDriver1());
        frndMakingRoom1.verifyFRNDMakingRoomsPageHeader(frndMakingRoomsPageHeader,getDriver1());
>>>>>>> e7aad041656f51bcd7540c5837b667b08d8aa271
        frndMakingRoom1.clickOnPlusIcon(getDriver1());
        frndMakingRoom1.verifyBeFRNDMakingExpertPopup(beFrndMakingExpertpopupHeader, getDriver1());
        frndMakingRoom1.clickOnCreateRoomButton(getDriver1());
        frndMakingRoom1.allowAudioRecordAllowPopup(getDriver1());
<<<<<<< HEAD
        frndMakingRoom1.verifyCreatedFrndMeetingRoom(frndMakingLiveRoomsPageHeader, getDriver1());
=======
        frndMakingRoom1.verifyCreatedFrndMeetingRoom(frndMakingLiveRoomsPageHeader,getDriver1());
>>>>>>> e7aad041656f51bcd7540c5837b667b08d8aa271
        frndMakingRoom1.clickOnOptionsButton(getDriver1());
        frndMakingRoom1.clickOnMicButton(getDriver1());
        frndMakingRoom1.clickOnOptionsButton(getDriver1());
        frndMakingRoom1.clickOnSpeakerButton(getDriver1());

        homePage2.handlingPopup(getDriver2());
        homePage2.clickOnFrndTab(getDriver2());
<<<<<<< HEAD
//        frndMakingRoom2.clickOnJoinRoomAndLeave(getDriver2());
        frndMakingRoom2.clickOnJoinRoomByUserName(getDriver2());
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

    @Test(priority = 4, enabled = true, description = "Verify that audio game timer should be start when filled the all seats")
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
        String port8083 = FrndMakingRoomTest.getJSONObject("Ports").getString("port8083");
        String user2PhoneNumber = FrndMakingRoomTest.getJSONObject("FrndMakingRoomTest").getString("user2PhoneNumber");
        Thread.sleep(8000);

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
        frndMakingRoom3.verifyFrndPageTitleForUser(frndPageTitleForUser, getDriver3());
        frndMakingRoom3.clickOnJoinRoom(getDriver3());
        frndMakingRoom3.allowAudioRecordAllowOnPopup(getDriver3());
        frndMakingRoom3.clickOnOptionsButton(getDriver3());
        frndMakingRoom3.clickOnSpeakerButton(getDriver3());
        frndMakingRoom3.clickOnJoinWaitlistButton(getDriver3());

        frndMakingRoom1.clickOnAddGirlButton(getDriver1());
        frndMakingRoom1.clickOnWaitlistAddButton(getDriver1());
        frndMakingRoom1.verifyUserAddedToGame(true, getDriver1());

        frndMakingRoom1.verifyMakingRoomTimerDisplayed(true, getDriver1());
        frndMakingRoom1.waitTillFmrCallEnds();
        frndMakingRoom2.verifyThatUserIsAbleToExitAfterFmrCall(getDriver2());
        frndMakingRoom3.verifyThatUserIsAbleToExitAfterFmrCall(getDriver3());
    }



=======
        frndMakingRoom2.verifyFrndPageTitleForUser(frndPageTitleForUser,getDriver2());
        frndMakingRoom2.clickOnJoinRoom(getDriver2());
        frndMakingRoom2.allowAudioRecordAllowPopup(getDriver2());
        frndMakingRoom2.verifyCreatedFrndMeetingRoom(frndMakingLiveRoomsPageHeader,getDriver2());
        frndMakingRoom2.clickOnJoinWaitlistButton(getDriver2());

        frndMakingRoom1.clickOnAddUserButton(getDriver1());
        frndMakingRoom1.clickOnWatchlistAddButton(getDriver1());
        frndMakingRoom1.verifyUserAddedToGame(getDriver1());
    }

>>>>>>> e7aad041656f51bcd7540c5837b667b08d8aa271
}
