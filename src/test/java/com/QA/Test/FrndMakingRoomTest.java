package com.QA.Test;

import com.QA.Base.BaseTest2;
import com.QA.Pages.*;
import com.QA.utlis.TestUtils;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.*;

import java.io.InputStream;
import java.lang.reflect.Method;

public class FrndMakingRoomTest extends BaseTest2 {
    LandingPage landingPage1,landingPage2;
    HomePage homePage1,homePage2;
    FrndMakingRoomsPage frndMakingRoom1, frndMakingRoom2;
    JSONObject LoginDetails;
    TestUtils utils = new TestUtils();

    @BeforeClass
    public void beforeClass() throws Exception {
        InputStream datais = null;
        try {
            String dataFileName = "data/loginDetails.json";
            datais = getClass().getClassLoader().getResourceAsStream(dataFileName);
            JSONTokener tokener = new JSONTokener(datais);
            LoginDetails = new JSONObject(tokener);
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
        homePage1 = new HomePage(getDriver1());
        homePage2 = new HomePage(getDriver2());
        frndMakingRoom1 = new FrndMakingRoomsPage(getDriver1());
        frndMakingRoom2 = new FrndMakingRoomsPage(getDriver2());
    }

    @AfterMethod
    public void afterMethod() {
        closeApp(getDriver1());
        closeApp(getDriver2());
        launchApp(getDriver1());
        launchApp(getDriver2());
    }

    //-------------------------- Test Below -----------------------------------------


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
        frndMakingRoom1.clickOnOptionsButton(getDriver1());
        frndMakingRoom1.clickOnMicButton(getDriver1());
        frndMakingRoom1.clickOnOptionsButton(getDriver1());
        frndMakingRoom1.clickOnSpeakerButton(getDriver1());

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
        Thread.sleep(8000);

        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.KEYCODE_VOLUME_DOWN(getDriver1());
        landingPage1.changingPort(portNum, getDriver1());
        landingPage1.handlingUpdatePopup(getDriver1());
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
        frndMakingRoom1.clickOnOptionsButton(getDriver1());
        frndMakingRoom1.clickOnMicButton(getDriver1());
        frndMakingRoom1.clickOnOptionsButton(getDriver1());
        frndMakingRoom1.clickOnSpeakerButton(getDriver1());

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
    }

}
