package com.QA.Test;

import com.QA.API.ApiUdateData;
import com.QA.Base.BaseTest;
import com.QA.DataBase.FetchValue;
import com.QA.Pages.*;
import com.QA.utlis.TestUtils;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.*;

import java.io.InputStream;
import java.lang.reflect.Method;

public class FrndRadioTest extends BaseTest {
    LandingPage landingPage1, landingPage2;
    HomePage homePage1, homePage2;
    FrndRadioPage frndRadioPage1, frndRadioPage2;
    PrivateTrainingRoomPage trainingRoomPage1,trainingRoomPage2;
    HostedAudioCallPage hostedAudioCallPage1,hostedAudioCallPage2;
    FrndMakingRoomsPage frndMakingRoomsPage;
    JSONObject frndRadioRoomTest;
    PaymentPage paymentPage1,paymentPage2;

    FetchValue fetchValue;

    ApiUdateData apiUdateData;

    FrndMakingRoomsPage frndMakingRoomsPage1,frndMakingRoomsPage2;

    SelectTagScreenPage tagScreenPage1,tagScreenPage2;
    TestUtils utils = new TestUtils();

    @BeforeClass
    public void beforeClass() throws Exception {
        InputStream datais = null;
        try {
            String dataFileName = "data/frndRadioRoomTest.json";
            datais = getClass().getClassLoader().getResourceAsStream(dataFileName);
            JSONTokener tokener = new JSONTokener(datais);
            frndRadioRoomTest = new JSONObject(tokener);
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
        frndRadioPage1 = new FrndRadioPage(getDriver1());
        frndRadioPage2 = new FrndRadioPage(getDriver2());
        fetchValue = new FetchValue();
        apiUdateData = new ApiUdateData();
        frndRadioPage1 = new FrndRadioPage(getDriver1());
        frndMakingRoomsPage1 = new FrndMakingRoomsPage(getDriver1());
        frndMakingRoomsPage2 = new FrndMakingRoomsPage(getDriver2());
        trainingRoomPage1 = new PrivateTrainingRoomPage(getDriver1());
        trainingRoomPage2 = new PrivateTrainingRoomPage(getDriver2());
        tagScreenPage1 = new SelectTagScreenPage(getDriver1());
        tagScreenPage2 = new SelectTagScreenPage(getDriver2());
        hostedAudioCallPage1 = new HostedAudioCallPage(getDriver1());
        hostedAudioCallPage2 = new HostedAudioCallPage(getDriver2());
        paymentPage1 = new PaymentPage(getDriver1());
        paymentPage2 = new PaymentPage(getDriver2());
    }

    @AfterMethod
    public void afterMethod() {
        closeApp(getDriver1());
        closeApp(getDriver2());
        launchApp(getDriver1());
        launchApp(getDriver2());
    }

    //-------------------------- Test Below -----------------------------------------


    @Test(priority = 0, enabled = false, description = "Verify the user should be redirect to Frnd Radio after click on group room")
    public void verifyTheShouldBeRedirectToFrndRadioAfterClickOnGroupRoom() throws InterruptedException {
        String hostPhoneNumber = frndRadioRoomTest.getJSONObject("LoginDetails").getString("hostPhoneNumber");
        String userPhoneNumber = frndRadioRoomTest.getJSONObject("LoginDetails").getString("userPhoneNumber");
        String frndRadioYourLiveShowPage = frndRadioRoomTest.getJSONObject("Headers").getString("frndRadioYourLiveShowPage");
        String user1Name = frndRadioRoomTest.getJSONObject("UserNames").getString("user1Name");
        String hostName = frndRadioRoomTest.getJSONObject("UserNames").getString("hostName");
        String topic = frndRadioRoomTest.getJSONObject("RadioRoomTopic").getString("topic");
        String otp = frndRadioRoomTest.getJSONObject("LoginDetails").getString("otp");
        String port8083 = frndRadioRoomTest.getJSONObject("Ports").getString("portQA");
        Thread.sleep(8000);

        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.KEYCODE_VOLUME_DOWN(getDriver1());
        landingPage1.changingPort(port8083, getDriver1());
        landingPage2.handlingUpdatePopup(getDriver2());
        landingPage2.KEYCODE_VOLUME_DOWN(getDriver2());
        landingPage2.changingPort(port8083, getDriver2());
        landingPage1.loginToApplication("7890134561", otp, getDriver1());
        landingPage2.loginToApplication("7890134562", otp, getDriver2());
        homePage1.handlingPopup(getDriver1());
        homePage2.handlingPopup(getDriver2());
        String id = fetchValue.fetchValue("7890134561");
        apiUdateData.frndRadio(id,true,"http://qa.frndapp.in:8080","/automatedTesting/updateFgGroup","7890134561");
        apiUdateData.frndRadioCohortUpdate(id,true,"http://qa.frndapp.in:8080","/automatedTesting/updateUser","7890134561");
        String id3 = fetchValue.fetchValue("7890134562");
        apiUdateData.frndRadio(id3,true,"http://qa.frndapp.in:8080","/automatedTesting/updateFgGroup","7890134562");
        homePage1.clickOnGroupRoom(getDriver1());
        frndRadioPage1.verifyGroupRoomsPage(true, getDriver1());
        frndRadioPage1.createGroupRooms(getDriver1());
        frndRadioPage1.createRadioRoom(frndRadioYourLiveShowPage, topic, 1, getDriver1());
        frndMakingRoomsPage1.allowAudioRecordAllowPopup(getDriver1());
        frndRadioPage1.verifyRadioRoomsTopic(topic, getDriver1());
        frndRadioPage1.clickOnSpeakerButton(getDriver1());
        frndRadioPage1.verifyTheMuteUnmuteFunctionalityShouldBeWorkAsExpected(getDriver1());
        homePage2.clickOnGroupRoom(getDriver2());
        frndRadioPage2.verifyGroupRoomsPage(true, getDriver2());
        frndRadioPage2.verifyTheUsersShouldBeAbleToSeeTheHostedFrndRadioRoomAfterClickOnGroupRoomInHomePage(true, getDriver2());
        frndRadioPage2.verifyTheUserShouldBeAbleToJoinTheHostedFrndRadioRoom(getDriver2());
        frndMakingRoomsPage2.allowAudioRecordAllowPopup(getDriver2());
        frndRadioPage2.verifyRadioRoomsTopicByUser(topic, getDriver2());
        frndRadioPage2.clickOnSpeakerButton(getDriver2());

        frndRadioPage2.verifyTheUsersShouldBeAbleToJoinTheWaitlistAfterClickOnJoinWaitlist(true, getDriver2());
        frndRadioPage1.verifyTheHostShouldBeAbleToAddWaitlistUsersOnHotSeat(0, user1Name, getDriver1());
        clickBackButton(getDriver2());
        frndRadioPage2.verifyTheMuteUnmuteFunctionalityShouldBeWorkAsExpected(getDriver2());

        frndRadioPage2.verifyTheUserShouldBeAbleToLeaveTheRoom(true, getDriver2());
        frndRadioPage1.verifyNoUserAddedToGame(0, user1Name, getDriver1());
        frndRadioPage1.verifyTheGameShouldBeCloseAfterHostCloseTheGame(true, getDriver1());
    }

    @Test(enabled = true)
    public void verifyTheFrndRadioShouldBeAvailableWhichUsersHasAssignedRadio_grouptrueInFg_Group() throws InterruptedException {
        String hostPhoneNumber = frndRadioRoomTest.getJSONObject("LoginDetails").getString("hostPhoneNumber");
        String userPhoneNumber = frndRadioRoomTest.getJSONObject("LoginDetails").getString("userPhoneNumber");
        String frndRadioYourLiveShowPage = frndRadioRoomTest.getJSONObject("Headers").getString("frndRadioYourLiveShowPage");
        String user1Name = frndRadioRoomTest.getJSONObject("UserNames").getString("user1Name");
        String hostName = frndRadioRoomTest.getJSONObject("UserNames").getString("hostName");
        String topic = frndRadioRoomTest.getJSONObject("RadioRoomTopic").getString("topic");
        String otp = frndRadioRoomTest.getJSONObject("LoginDetails").getString("otp");
        String port8083 = frndRadioRoomTest.getJSONObject("Ports").getString("portQA");
        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.KEYCODE_VOLUME_DOWN(getDriver1());
        landingPage1.changingPort("QA", getDriver1());
        landingPage1.loginToApplication("7890134561", "000000", getDriver1());
        homePage1.handlingPopup(getDriver1());
        landingPage2.handlingUpdatePopup(getDriver2());
        landingPage2.KEYCODE_VOLUME_DOWN(getDriver2());
        landingPage2.changingPort("QA", getDriver2());
        landingPage2.loginToApplication("7890134563", otp, getDriver2());
        String id = fetchValue.fetchValue("7890134561");
        apiUdateData.frndRadio(id,true,"http://qa.frndapp.in:8080","/automatedTesting/updateFgGroup","7890134561");
        apiUdateData.frndRadioCohortUpdate(id,true,"http://qa.frndapp.in:8080","/automatedTesting/updateUser","7890134561");
        homePage2.handlingPopup(getDriver2());
        String id1 = fetchValue.fetchValue("7890134563");
        apiUdateData.frndRadio(id1,true,"http://qa.frndapp.in:8080","/automatedTesting/updateFgGroup","7890134563");
        homePage1.clickOnGroupRoom(getDriver1());
        frndRadioPage1.verifyGroupRoomsPage(true, getDriver1());
        frndRadioPage1.createGroupRooms(getDriver1());
        frndRadioPage1.createRadioRoom(frndRadioYourLiveShowPage, topic, 1, getDriver1());
        frndMakingRoomsPage1.allowAudioRecordAllowPopup(getDriver1());
        frndRadioPage1.verifyRadioRoomsTopic(topic, getDriver1());
        homePage2.clickOnGroupRoom(getDriver2());
        frndRadioPage2.verifyGroupRoomsPage(true, getDriver2());
        frndRadioPage2.verifyTheUsersShouldBeAbleToSeeTheHostedFrndRadioRoomAfterClickOnGroupRoomInHomePage(true, getDriver2());
        frndRadioPage2.verifyTheUserShouldBeAbleToJoinTheHostedFrndRadioRoom(getDriver2());
        frndMakingRoomsPage2.allowAudioRecordAllowPopup(getDriver2());
        frndRadioPage2.verifyRadioRoomsTopicByUser(topic, getDriver2());
    }

    @Test(enabled = true)
    public  void verifyTheUsersShouldBeAbleToJoinInTheWaitlistAfterSendTheGifts() throws InterruptedException {
        String hostPhoneNumber = frndRadioRoomTest.getJSONObject("LoginDetails").getString("hostPhoneNumber");
        String userPhoneNumber = frndRadioRoomTest.getJSONObject("LoginDetails").getString("userPhoneNumber");
        String frndRadioYourLiveShowPage = frndRadioRoomTest.getJSONObject("Headers").getString("frndRadioYourLiveShowPage");
        String user1Name = frndRadioRoomTest.getJSONObject("UserNames").getString("user1Name");
        String hostName = frndRadioRoomTest.getJSONObject("UserNames").getString("hostName");
        String topic = frndRadioRoomTest.getJSONObject("RadioRoomTopic").getString("topic");
        String otp = frndRadioRoomTest.getJSONObject("LoginDetails").getString("otp");
        String port8083 = frndRadioRoomTest.getJSONObject("Ports").getString("portQA");
        Thread.sleep(8000);
        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.KEYCODE_VOLUME_DOWN(getDriver1());
        landingPage1.changingPort(port8083, getDriver1());
        landingPage2.handlingUpdatePopup(getDriver2());
        landingPage2.KEYCODE_VOLUME_DOWN(getDriver2());
        landingPage2.changingPort(port8083, getDriver2());
        landingPage1.loginToApplication("7890134561", otp, getDriver1());
        landingPage2.loginToApplication("7890134562", otp, getDriver2());
        homePage1.handlingPopup(getDriver1());
        homePage2.handlingPopup(getDriver2());
        String id = fetchValue.fetchValue("7890134561");
        apiUdateData.frndRadio(id,true,"http://qa.frndapp.in:8080","/automatedTesting/updateFgGroup","7890134561");
        apiUdateData.frndRadioCohortUpdate(id,true,"http://qa.frndapp.in:8080","/automatedTesting/updateUser","7890134561");
        String id3 = fetchValue.fetchValue("7890134562");
        apiUdateData.frndRadio(id3,true,"http://qa.frndapp.in:8080","/automatedTesting/updateFgGroup","7890134562");
        homePage1.clickOnGroupRoom(getDriver1());
        frndRadioPage1.verifyGroupRoomsPage(true, getDriver1());
        frndRadioPage1.createGroupRooms(getDriver1());
        frndRadioPage1.createRadioRoom(frndRadioYourLiveShowPage, topic, 1, getDriver1());
        frndMakingRoomsPage1.allowAudioRecordAllowPopup(getDriver1());
        frndRadioPage1.verifyRadioRoomsTopic(topic, getDriver1());
        String text = homePage2.getAvailableCoin(getDriver2());
        homePage2.clickOnGroupRoom(getDriver2());
        frndRadioPage2.verifyGroupRoomsPage(true, getDriver2());
        frndRadioPage2.verifyTheUsersShouldBeAbleToSeeTheHostedFrndRadioRoomAfterClickOnGroupRoomInHomePage(true, getDriver2());
        frndRadioPage2.verifyTheUserShouldBeAbleToJoinTheHostedFrndRadioRoom(getDriver2());
        frndMakingRoomsPage2.allowAudioRecordAllowPopup(getDriver2());
        frndRadioPage2.verifyRadioRoomsTopicByUser(topic, getDriver2());
        frndRadioPage2.userSendGiftToHost(getDriver2(),text);
        frndRadioPage2.verifyUserIsInWaitlist(true,getDriver2());
        frndRadioPage1.verifyTheGameShouldBeCloseAfterHostCloseTheGame(true, getDriver1());
        frndRadioPage2.clickOnCancelButton(getDriver2());
        frndRadioPage2.checkCoinsDeducted(text,getDriver2());
    }

    @Test(enabled = true)
    public  void verifyTheUserShouldBeRemoveInTheHotSeatAfterHostRemoveTheParticularUser() throws InterruptedException {
        String hostPhoneNumber = frndRadioRoomTest.getJSONObject("LoginDetails").getString("hostPhoneNumber");
        String userPhoneNumber = frndRadioRoomTest.getJSONObject("LoginDetails").getString("userPhoneNumber");
        String frndRadioYourLiveShowPage = frndRadioRoomTest.getJSONObject("Headers").getString("frndRadioYourLiveShowPage");
        String user1Name = frndRadioRoomTest.getJSONObject("UserNames").getString("user1Name");
        String hostName = frndRadioRoomTest.getJSONObject("UserNames").getString("hostName");
        String topic = frndRadioRoomTest.getJSONObject("RadioRoomTopic").getString("topic");
        String otp = frndRadioRoomTest.getJSONObject("LoginDetails").getString("otp");
        String port8083 = frndRadioRoomTest.getJSONObject("Ports").getString("portQA");
        Thread.sleep(8000);
        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.KEYCODE_VOLUME_DOWN(getDriver1());
        landingPage1.changingPort(port8083,getDriver1());
        landingPage2.handlingUpdatePopup(getDriver2());
        landingPage2.KEYCODE_VOLUME_DOWN(getDriver2());
        landingPage2.changingPort(port8083,getDriver2());
        landingPage1.loginToApplication("7890134561", otp, getDriver1());
        landingPage2.loginToApplication("7890134562", otp, getDriver2());
        homePage1.handlingPopup(getDriver1());
        homePage2.handlingPopup(getDriver2());
        String id = fetchValue.fetchValue("7890134561");
        apiUdateData.frndRadio(id,true,"http://qa.frndapp.in:8080","/automatedTesting/updateFgGroup","7890134561");
        apiUdateData.frndRadioCohortUpdate(id,true,"http://qa.frndapp.in:8080","/automatedTesting/updateUser","7890134561");
        String id3 = fetchValue.fetchValue("7890134562");
        apiUdateData.frndRadio(id3,true,"http://qa.frndapp.in:8080","/automatedTesting/updateFgGroup","7890134562");
        homePage1.clickOnGroupRoom(getDriver1());
        frndRadioPage1.verifyGroupRoomsPage(true, getDriver1());
        frndRadioPage1.createGroupRooms(getDriver1());
        frndRadioPage1.createRadioRoom(frndRadioYourLiveShowPage, topic, 1, getDriver1());
        frndMakingRoomsPage1.allowAudioRecordAllowPopup(getDriver1());
        frndRadioPage1.verifyRadioRoomsTopic(topic, getDriver1());
        homePage2.clickOnGroupRoom(getDriver2());
        frndRadioPage2.verifyGroupRoomsPage(true, getDriver2());
        frndRadioPage2.verifyTheUsersShouldBeAbleToSeeTheHostedFrndRadioRoomAfterClickOnGroupRoomInHomePage(true, getDriver2());
        frndRadioPage2.verifyTheUserShouldBeAbleToJoinTheHostedFrndRadioRoom(getDriver2());
        frndMakingRoomsPage2.allowAudioRecordAllowPopup(getDriver2());
        frndRadioPage2.verifyRadioRoomsTopicByUser(topic, getDriver2());
        frndRadioPage2.clickOnSpeakerButton(getDriver2());
        frndRadioPage2.verifyTheUsersShouldBeAbleToJoinTheWaitlistAfterClickOnJoinWaitlist(true, getDriver2());
        frndRadioPage1.verifyTheHostShouldBeAbleToAddWaitlistUsersOnHotSeat(0, user1Name, getDriver1());
        frndRadioPage1.removeUser(getDriver1());
        frndRadioPage1.verifyUserHaveGotRemoved(getDriver1());
    }

    @Test(enabled = true)
    public void verifyIfTheFRNDRadioShouldBeForBothMaleAndFemaleUser() throws InterruptedException {
        String hostPhoneNumber = frndRadioRoomTest.getJSONObject("LoginDetails").getString("hostPhoneNumber");
        String userPhoneNumber = frndRadioRoomTest.getJSONObject("LoginDetails").getString("userPhoneNumber");
        String frndRadioYourLiveShowPage = frndRadioRoomTest.getJSONObject("Headers").getString("frndRadioYourLiveShowPage");
        String user1Name = frndRadioRoomTest.getJSONObject("UserNames").getString("user1Name");
        String hostName = frndRadioRoomTest.getJSONObject("UserNames").getString("hostName");
        String topic = frndRadioRoomTest.getJSONObject("RadioRoomTopic").getString("topic");
        String otp = frndRadioRoomTest.getJSONObject("LoginDetails").getString("otp");
        String port8083 = frndRadioRoomTest.getJSONObject("Ports").getString("portQA");
        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.KEYCODE_VOLUME_DOWN(getDriver1());
        landingPage1.changingPort("QA", getDriver1());
        landingPage1.loginToApplication("7890134561", "000000", getDriver1());
        homePage1.handlingPopup(getDriver1());
        landingPage2.handlingUpdatePopup(getDriver2());
        landingPage2.KEYCODE_VOLUME_DOWN(getDriver2());
        landingPage2.changingPort("QA", getDriver2());
        landingPage2.loginToApplication("7890134567", otp, getDriver2());
        String id = fetchValue.fetchValue("7890134561");
        apiUdateData.frndRadio(id,true,"http://qa.frndapp.in:8080","/automatedTesting/updateFgGroup","7890134561");
        apiUdateData.frndRadioCohortUpdate(id,true,"http://qa.frndapp.in:8080","/automatedTesting/updateUser","7890134561");
        homePage2.handlingPopup(getDriver2());
        //landingPage2.clickOnActionBarRoot(getDriver2());
        String id1 = fetchValue.fetchValue("7890134567");
        apiUdateData.frndRadio(id1,true,"http://qa.frndapp.in:8080","/automatedTesting/updateFgGroup","7890134567");
        homePage1.clickOnGroupRoom(getDriver1());
        frndRadioPage1.verifyGroupRoomsPage(true, getDriver1());
        frndRadioPage1.createGroupRooms(getDriver1());
        frndRadioPage1.createRadioRoom(frndRadioYourLiveShowPage, topic, 1, getDriver1());
        frndMakingRoomsPage1.allowAudioRecordAllowPopup(getDriver1());
        frndRadioPage1.verifyRadioRoomsTopic(topic, getDriver1());
        homePage2.clickOnGroupRoom1(getDriver2());
      //  frndRadioPage2.verifyGroupRoomsPage(true, getDriver2());
        frndRadioPage2.verifyTheUsersShouldBeAbleToSeeTheHostedFrndRadioRoomAfterClickOnGroupRoomInHomePage(true, getDriver2());
        frndRadioPage2.verifyTheUserShouldBeAbleToJoinTheHostedFrndRadioRoom(getDriver2());
        frndMakingRoomsPage2.allowAudioRecordAllowPopup(getDriver2());
        frndRadioPage2.verifyRadioRoomsTopicByUser(topic, getDriver2());
    }

    @Test(enabled = true)
    public void checkThisFlowShouldBeAvailableForMale_retention() throws InterruptedException {
        landingPage2.handlingUpdatePopup(getDriver2());
        landingPage2.KEYCODE_VOLUME_DOWN(getDriver2());
        landingPage2.changingPort("QA",getDriver2());
        landingPage2.loginToApplication("7890134561","000000",getDriver2());
        homePage2.handlingPopup(getDriver2());
        homePage2.clickOnTrainingTab(getDriver2());
        trainingRoomPage2.clickOnPlusIcon(getDriver2());
        trainingRoomPage2.clickOnCreateRoomIcon(getDriver2());
        trainingRoomPage2.clickOnAudioRoomButton(getDriver2());
        tagScreenPage2.clickOnLoveTag(getDriver2());
        tagScreenPage2.verifyUerAbleToHost(getDriver2());
        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.KEYCODE_VOLUME_DOWN(getDriver1());
        landingPage1.changingPort("QA",getDriver1());
        int i = getRandomNum();
        String phonNum = "78901"+Integer.toString(i);
        landingPage1.clickOnLetsGoButton(getDriver1());
        landingPage1.enterMobileNumber(phonNum,getDriver1());
        landingPage1.clickOnGetOTPButton(getDriver1());
        landingPage1.enterOTPNumber("000000",getDriver1());
        landingPage1.clickOnSubmitButton(getDriver1());
        landingPage1.enterNickName(getDriver1(),"Daniel");
        landingPage1.clickOnSelectGenderButton(getDriver1());
        landingPage1.clickOnBoyGender(getDriver1());
        landingPage1.clickOnDateOfBirthButtonAndOkButton(getDriver1());
        landingPage1.clickOnSignInSubmitButton(getDriver1());
        String id1 = fetchValue.fetchValue(phonNum);
        System.out.println(id1);
        apiUdateData.udateData(id1,true,"http://qa.frndapp.in:8080","/automatedTesting/updateFgGroup",phonNum);
        apiUdateData.frndRadio(id1,true,"http://qa.frndapp.in:8080","/automatedTesting/updateFgGroup",phonNum);
        landingPage1.selectLanguage(getDriver1());
        landingPage1.checkCyberManifestoPolicies(getDriver1());
        landingPage1.selectAppLanguage(getDriver1());
        homePage1.handlingPopup(getDriver1());
        homePage1.checkFreeMinuteAndConnect(getDriver1());
        Thread.sleep(3000);
        hostedAudioCallPage2.clickOnExitButton(getDriver2());
        hostedAudioCallPage1.clickOnStarRating(getDriver1());
        hostedAudioCallPage1.giveReviewMessage(getDriver1());
        hostedAudioCallPage1.clickOnSubmitButton(getDriver1());
        hostedAudioCallPage1.shareAppExperienceRating(getDriver1());
        homePage1.clickOnHomeTab(getDriver1());
        homePage2.clickOnHomeTab(getDriver2());
        String id2 = fetchValue.fetchValue("7890134561");
        apiUdateData.frndRadio(id2,true,"http://qa.frndapp.in:8080","/automatedTesting/updateFgGroup","7890134561");
        apiUdateData.frndRadioCohortUpdate(id2,true,"http://qa.frndapp.in:8080","/automatedTesting/updateUser","7890134561");
        homePage2.clickOnGroupRoom(getDriver2());
        frndRadioPage2.verifyGroupRoomsPage(true, getDriver2());
        frndRadioPage2.createGroupRooms(getDriver2());
        frndRadioPage2.createRadioRoom("Your live show", "Frnd Radio Room", 1, getDriver2());
        frndMakingRoomsPage2.allowAudioRecordAllowPopup(getDriver2());
        frndRadioPage2.verifyRadioRoomsTopic("Frnd Radio Room", getDriver2());
        homePage1.clickOnGroupRoom(getDriver1());
        frndRadioPage1.verifyGroupRoomsPage(true, getDriver1());
        frndRadioPage1.verifyTheUsersShouldBeAbleToSeeTheHostedFrndRadioRoomAfterClickOnGroupRoomInHomePage(true, getDriver1());
        frndRadioPage1.verifyTheUserShouldBeAbleToJoinTheHostedFrndRadioRoom(getDriver1());
        frndMakingRoomsPage1.allowAudioRecordAllowPopup(getDriver1());
        frndRadioPage1.verifyRadioRoomsTopicByUser("Frnd Radio Room", getDriver1());
    }

    @Test(enabled = false)
    public void checkThisFlowForPaidMaleRetention() throws InterruptedException {
        landingPage2.handlingUpdatePopup(getDriver2());
        landingPage2.KEYCODE_VOLUME_DOWN(getDriver2());
        landingPage2.changingPort("QA",getDriver2());
        landingPage2.loginToApplication("7890134561","000000",getDriver2());
        homePage2.handlingPopup(getDriver2());
        homePage2.clickOnTrainingTab(getDriver2());
        trainingRoomPage2.clickOnPlusIcon(getDriver2());
        trainingRoomPage2.clickOnCreateRoomIcon(getDriver2());
        trainingRoomPage2.clickOnAudioRoomButton(getDriver2());
        tagScreenPage2.clickOnLoveTag(getDriver2());
        tagScreenPage2.verifyUerAbleToHost(getDriver2());
        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.KEYCODE_VOLUME_DOWN(getDriver1());
        landingPage1.changingPort("QA",getDriver1());
        int i = getRandomNum();
        String phonNum = "78901"+Integer.toString(i);
        landingPage1.clickOnLetsGoButton(getDriver1());
        landingPage1.enterMobileNumber(phonNum,getDriver1());
        landingPage1.clickOnGetOTPButton(getDriver1());
        landingPage1.enterOTPNumber("000000",getDriver1());
        landingPage1.clickOnSubmitButton(getDriver1());
        landingPage1.enterNickName(getDriver1(),"Daniel");
        landingPage1.clickOnSelectGenderButton(getDriver1());
        landingPage1.clickOnBoyGender(getDriver1());
        landingPage1.clickOnDateOfBirthButtonAndOkButton(getDriver1());
        landingPage1.clickOnSignInSubmitButton(getDriver1());
        String id = fetchValue.fetchValue(phonNum);
        System.out.println(id);
        apiUdateData.udateData1(id,true,"http://qa.frndapp.in:8080","/automatedTesting/updateFgGroup",phonNum);
        apiUdateData.frndRadio(id,true,"http://qa.frndapp.in:8080","/automatedTesting/updateFgGroup",phonNum);
        landingPage1.selectLanguage(getDriver1());
        landingPage1.checkCyberManifestoPolicies(getDriver1());
        landingPage1.selectAppLanguage(getDriver1());
        homePage1.handlingPopup(getDriver1());
        homePage1.checkFreeMinuteAndConnect(getDriver1());
        homePage1.clickOnAddCoinsNowButton(getDriver1());
        paymentPage1.selectFrndAppPaymentMethod(getDriver1());
        // paymentPage1.clickOnPhonePayIcon(getDriver1());
        paymentPage1.enterOTPAndMakePayment(getDriver1(),"111000");
        trainingRoomPage1.clickOnAudioRecordAllowPopoup(getDriver1());
        Thread.sleep(3000);
        hostedAudioCallPage2.clickOnExitButton(getDriver2());
        hostedAudioCallPage1.clickOnStarRating(getDriver1());
        hostedAudioCallPage1.giveReviewMessage(getDriver1());
        hostedAudioCallPage1.clickOnSubmitButton(getDriver1());
        hostedAudioCallPage1.shareAppExperienceRating(getDriver1());
        homePage1.clickOnHomeTab(getDriver1());
        homePage2.clickOnHomeTab(getDriver2());
        String id2 = fetchValue.fetchValue("7890134561");
        apiUdateData.frndRadio(id2,true,"http://qa.frndapp.in:8080","/automatedTesting/updateFgGroup","7890134561");
        apiUdateData.frndRadioCohortUpdate(id2,true,"http://qa.frndapp.in:8080","/automatedTesting/updateUser","7890134561");
        homePage2.clickOnGroupRoom(getDriver2());
        frndRadioPage2.verifyGroupRoomsPage(true, getDriver2());
        frndRadioPage2.createGroupRooms(getDriver2());
        frndRadioPage2.createRadioRoom("Your live show", "Frnd Radio Room", 1, getDriver2());
        frndMakingRoomsPage2.allowAudioRecordAllowPopup(getDriver2());
        frndRadioPage2.verifyRadioRoomsTopic("Frnd Radio Room", getDriver2());
        homePage1.clickOnGroupRoom(getDriver1());
        frndRadioPage1.verifyGroupRoomsPage(true, getDriver1());
        frndRadioPage1.verifyTheUsersShouldBeAbleToSeeTheHostedFrndRadioRoomAfterClickOnGroupRoomInHomePage(true, getDriver1());
        frndRadioPage1.verifyTheUserShouldBeAbleToJoinTheHostedFrndRadioRoom(getDriver1());
        frndMakingRoomsPage1.allowAudioRecordAllowPopup(getDriver1());
        frndRadioPage1.verifyRadioRoomsTopicByUser("Frnd Radio Room", getDriver1());
    }
}
