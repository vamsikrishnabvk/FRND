package com.QA.Test;

import com.QA.Base.BaseTest;
import com.QA.Pages.*;
import com.QA.utlis.TestUtils;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.*;

import java.io.InputStream;
import java.lang.reflect.Method;

public class VideoCallTest extends BaseTest {
    LandingPage landingPage1, landingPage2;
    HomePage homePage1, homePage2;
    PrivateTrainingRoomPage trainingRoomPage1, trainingRoomPage2;
    SelectTagScreenPage tagScreenPage1, tagScreenPage2;
    HostedVideoCallPage hostedVideoCallPage1, hostedVideoCallPage2;
    JSONObject VideoCallTest;
    TestUtils utils = new TestUtils();

    @BeforeClass
    public void beforeClass() throws Exception {
        InputStream datais = null;
        try {
            String dataFileName = "data/videoCallTest.json";
            datais = getClass().getClassLoader().getResourceAsStream(dataFileName);
            JSONTokener tokener = new JSONTokener(datais);
            VideoCallTest = new JSONObject(tokener);
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
        trainingRoomPage1 = new PrivateTrainingRoomPage(getDriver1());
        trainingRoomPage2 = new PrivateTrainingRoomPage(getDriver2());
        tagScreenPage1 = new SelectTagScreenPage(getDriver1());
        tagScreenPage2 = new SelectTagScreenPage(getDriver2());
        hostedVideoCallPage1 = new HostedVideoCallPage(getDriver1());
        hostedVideoCallPage2 = new HostedVideoCallPage(getDriver2());
    }

    @AfterMethod
    public void afterMethod() {
        closeApp(getDriver1());
        closeApp(getDriver2());
        launchApp(getDriver1());
        launchApp(getDriver2());
//        getDriver().activateApp("com.dating.for.all");
    }

    //-------------------------- Test Below -----------------------------------------


    @Test(priority = 0, enabled = true)
    public void verifyThatUserAbleToHostAndExitRoom() throws InterruptedException {
        String phoneNumber = VideoCallTest.getJSONObject("VideoCallTest").getString("phoneNumberDev1");
        String otp = VideoCallTest.getJSONObject("VideoCallTest").getString("otp");
        String portNumber = VideoCallTest.getJSONObject("VideoCallTest").getString("portNumber");
        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.KEYCODE_VOLUME_DOWN(getDriver1());
        landingPage1.changingPort(portNumber, getDriver1());
        landingPage1.loginToApplication(phoneNumber, otp, getDriver1());
        homePage1.handlingPopup(getDriver1());
        homePage1.clickOnTrainingTab(getDriver1());
        trainingRoomPage1.clickOnPlusIcon(getDriver1());
        trainingRoomPage1.clickOnCreateRoomIcon(getDriver1());
        trainingRoomPage1.clickOnVideoRoomButton(getDriver1());
        tagScreenPage1.clickOnLoveTag(getDriver1());
        tagScreenPage1.verifyUerAbleToHost(getDriver1());
        hostedVideoCallPage1.hostExitRoom(getDriver1());
        homePage1.verifyHostExitTheRoom(getDriver1());
    }

    @Test(priority = 1, enabled = true)
    public void checkThatMuteUnmuteFunctionalityIsWorkingAsExpected() throws InterruptedException {
        String phoneNumber = VideoCallTest.getJSONObject("VideoCallTest").getString("phoneNumberDev1");
        String otp = VideoCallTest.getJSONObject("VideoCallTest").getString("otp");
        String portNumber = VideoCallTest.getJSONObject("VideoCallTest").getString("portNumber");
        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.KEYCODE_VOLUME_DOWN(getDriver1());
        landingPage1.changingPort(portNumber, getDriver1());
        landingPage1.loginToApplication(phoneNumber, otp, getDriver1());
        homePage1.handlingPopup(getDriver1());
        homePage1.clickOnTrainingTab(getDriver1());
        trainingRoomPage1.clickOnPlusIcon(getDriver1());
        trainingRoomPage1.clickOnCreateRoomIcon(getDriver1());
        trainingRoomPage1.clickOnAudioRoomButton(getDriver1());
        tagScreenPage1.clickOnLoveTag(getDriver1());
        tagScreenPage1.verifyUerAbleToHost(getDriver1());
        hostedVideoCallPage1.checkMuteUnmuteFunctionality(getDriver1());
    }


    @Test(priority = 2, enabled = true)
    public void verifyThatUsersAreAbleToJoinInVideoCallAccordingCoinBalance() throws InterruptedException {
        String phoneNumber = VideoCallTest.getJSONObject("VideoCallTest").getString("phoneNumberDev1");
        String otp = VideoCallTest.getJSONObject("VideoCallTest").getString("otp");
        String phoneNumber2 = VideoCallTest.getJSONObject("VideoCallTest").getString("phoneNumberDev2");
        String partialum = VideoCallTest.getJSONObject("VideoCallTest").getString("partialPhNo");
        String expectedCoins = VideoCallTest.getJSONObject("VideoCallTest").getString("expectedCoins");
        String nickName = VideoCallTest.getJSONObject("VideoCallTest").getString("nickName");
        String portNumber = VideoCallTest.getJSONObject("VideoCallTest").getString("portNumber");
        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.KEYCODE_VOLUME_DOWN(getDriver1());
        landingPage1.changingPort(portNumber, getDriver1());
        landingPage1.handlingUpdatePopup(getDriver2());
        landingPage2.KEYCODE_VOLUME_DOWN(getDriver2());
        landingPage2.changingPort(portNumber, getDriver2());
        landingPage1.loginToApplication(phoneNumber, otp, getDriver1());
        landingPage2.loginToApplication(phoneNumber2, otp, getDriver2());
        homePage1.handlingPopup(getDriver1());
        homePage2.handlingPopup(getDriver2());
        String text = homePage1.getAvailableCoin(getDriver1());
        homePage2.clickOnTrainingTab(getDriver2());
        trainingRoomPage2.clickOnPlusIcon(getDriver2());
        trainingRoomPage2.clickOnCreateRoomIcon(getDriver2());
        homePage1.clickOnTrainingTab(getDriver1());
        trainingRoomPage2.clickOnVideoRoomButton(getDriver2());
        tagScreenPage2.clickOnLoveTag(getDriver2());
        tagScreenPage2.verifyUerAbleToHost(getDriver2());
        homePage1.clickOnTrainingTab(getDriver1());
        trainingRoomPage1.checkCoinAndEnterRoom(text, expectedCoins, getDriver1());
    }

    @Test(priority = 3, enabled = true)
    public void VerifyCoinBalanceAfterUserSendsGiftAccordingToTimer() throws InterruptedException {
        String phoneNumber = VideoCallTest.getJSONObject("VideoCallTest").getString("phoneNumberDev1");
        String otp = VideoCallTest.getJSONObject("VideoCallTest").getString("otp");
        String phoneNumber2 = VideoCallTest.getJSONObject("VideoCallTest").getString("phoneNumberDev2");
        String partialum = VideoCallTest.getJSONObject("VideoCallTest").getString("partialPhNo");
        String expectedCoins = VideoCallTest.getJSONObject("VideoCallTest").getString("expectedCoins");
        String nickName = VideoCallTest.getJSONObject("VideoCallTest").getString("nickName");
        String portNumber = VideoCallTest.getJSONObject("VideoCallTest").getString("portNumber");
        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.KEYCODE_VOLUME_DOWN(getDriver1());
        landingPage1.changingPort(portNumber, getDriver1());
        landingPage1.handlingUpdatePopup(getDriver2());
        landingPage2.KEYCODE_VOLUME_DOWN(getDriver2());
        landingPage2.changingPort(portNumber, getDriver2());
        landingPage1.loginToApplication(phoneNumber, otp, getDriver1());
        landingPage2.loginToApplication(phoneNumber2, otp, getDriver2());
        homePage1.handlingPopup(getDriver1());
        homePage2.handlingPopup(getDriver2());
        String text = homePage1.getAvailableCoin(getDriver1());
        homePage2.clickOnTrainingTab(getDriver2());
        trainingRoomPage2.clickOnPlusIcon(getDriver2());
        trainingRoomPage2.clickOnCreateRoomIcon(getDriver2());
        homePage1.clickOnTrainingTab(getDriver1());
        trainingRoomPage2.clickOnVideoRoomButton(getDriver2());
        tagScreenPage2.clickOnLoveTag(getDriver2());
        tagScreenPage2.verifyUerAbleToHost(getDriver2());
        trainingRoomPage1.checkCoinAndEnterRoom(text, expectedCoins, getDriver1());
        hostedVideoCallPage1.verfiyTimerAndGiftCoinAfterSendsGift(text, getDriver1());
        hostedVideoCallPage1.clickOnExitButton(getDriver1());
        hostedVideoCallPage1.clickOnStarRating(getDriver1());
        hostedVideoCallPage1.giveReviewMessage(getDriver1());
        hostedVideoCallPage1.clickOnSubmitButton(getDriver1());
        hostedVideoCallPage1.shareAppExperienceRating(getDriver1());
        trainingRoomPage1.checkCoinsDeducted(text, getDriver1());
    }

    @Test(priority = 4, enabled = true)
    public void verifyThatHostAbleToOpenUserProfileDuringCallByClickingOnUserAvatar() throws InterruptedException {
        String phoneNumber = VideoCallTest.getJSONObject("VideoCallTest").getString("phoneNumberDev1");
        String otp = VideoCallTest.getJSONObject("VideoCallTest").getString("otp");
        String phoneNumber2 = VideoCallTest.getJSONObject("VideoCallTest").getString("phoneNumberDev2");
        String partialum = VideoCallTest.getJSONObject("VideoCallTest").getString("partialPhNo");
        String expectedCoins = VideoCallTest.getJSONObject("VideoCallTest").getString("expectedCoins");
        String nickName = VideoCallTest.getJSONObject("VideoCallTest").getString("nickName");
        String portNumber = VideoCallTest.getJSONObject("VideoCallTest").getString("portNumber");
        landingPage1.KEYCODE_VOLUME_DOWN(getDriver1());
        landingPage1.changingPort(portNumber, getDriver1());
        landingPage1.loginToApplication(phoneNumber, otp, getDriver1());
        homePage1.handlingPopup(getDriver1());
        homePage1.clickOnTrainingTab(getDriver1());
        trainingRoomPage1.clickOnPlusIcon(getDriver1());
        trainingRoomPage1.clickOnCreateRoomIcon(getDriver1());
        trainingRoomPage1.clickOnVideoRoomButton(getDriver1());
        tagScreenPage1.clickOnLoveTag(getDriver1());
        hostedVideoCallPage1.verifyHostAbleToClickOnUserAvatar(getDriver1());
    }

    @Test(priority = 5, enabled = true)
    public void verifyThatUserAbleToRemoveTheVideoCallWhenHostRemoveParticularUsers() throws InterruptedException {
        String phoneNumber = VideoCallTest.getJSONObject("VideoCallTest").getString("phoneNumberDev1");
        String otp = VideoCallTest.getJSONObject("VideoCallTest").getString("otp");
        String phoneNumber2 = VideoCallTest.getJSONObject("VideoCallTest").getString("phoneNumberDev2");
        String partialum = VideoCallTest.getJSONObject("VideoCallTest").getString("partialPhNo");
        String expectedCoins = VideoCallTest.getJSONObject("VideoCallTest").getString("expectedCoins");
        String nickName = VideoCallTest.getJSONObject("VideoCallTest").getString("nickName");
        String portNumber = VideoCallTest.getJSONObject("VideoCallTest").getString("portNumber");
        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.KEYCODE_VOLUME_DOWN(getDriver1());
        landingPage1.changingPort(portNumber, getDriver1());
        landingPage2.handlingUpdatePopup(getDriver2());
        landingPage2.KEYCODE_VOLUME_DOWN(getDriver2());
        landingPage2.changingPort(portNumber, getDriver2());
        landingPage1.loginToApplication(phoneNumber, otp, getDriver1());
        landingPage2.loginToApplication(phoneNumber2, otp, getDriver2());
        homePage1.handlingPopup(getDriver1());
        homePage2.handlingPopup(getDriver2());
        String text = homePage1.getAvailableCoin(getDriver1());
        homePage2.clickOnTrainingTab(getDriver2());
        homePage1.clickOnTrainingTab(getDriver1());
        trainingRoomPage2.clickOnPlusIcon(getDriver2());
        trainingRoomPage2.clickOnCreateRoomIcon(getDriver2());
        trainingRoomPage2.clickOnVideoRoomButton(getDriver2());
        tagScreenPage2.clickOnLoveTag(getDriver2());
        tagScreenPage2.verifyUerAbleToHost(getDriver2());
        trainingRoomPage1.checkCoinAndEnterRoom(text, expectedCoins, getDriver1());
        hostedVideoCallPage2.hostRemoveUserFromTheRoom(getDriver2());
        hostedVideoCallPage1.verfiyUserGotRemoveFromVideoCall(getDriver1());
    }

    @Test(priority = 6, enabled = true)
    public void userNotAbleToJoinRoomWhenHostBanUser() throws InterruptedException {
        String phoneNumber = VideoCallTest.getJSONObject("VideoCallTest").getString("phoneNumberDev1");
        String otp = VideoCallTest.getJSONObject("VideoCallTest").getString("otp");
        String phoneNumber2 = VideoCallTest.getJSONObject("VideoCallTest").getString("phoneNumberDev2");
        String partialum = VideoCallTest.getJSONObject("VideoCallTest").getString("partialPhNo");
        String expectedCoins = VideoCallTest.getJSONObject("VideoCallTest").getString("expectedCoins");
        String nickName = VideoCallTest.getJSONObject("VideoCallTest").getString("nickName");
        String portNumber = VideoCallTest.getJSONObject("VideoCallTest").getString("portNumber");
        landingPage2.handlingUpdatePopup(getDriver2());
        landingPage2.KEYCODE_VOLUME_DOWN(getDriver2());
        landingPage2.changingPort(portNumber, getDriver2());
        int i = getRandomNum();
        String phonNum = partialum + Integer.toString(i);
        landingPage2.clickOnLetsGoButton(getDriver2());
        landingPage2.enterMobileNumber(phonNum, getDriver2());
        landingPage2.clickOnGetOTPButton(getDriver2());
        landingPage2.enterOTPNumber(otp, getDriver2());
        landingPage2.clickOnSubmitButton(getDriver2());
        landingPage2.enterNickName(getDriver2(), nickName);
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
        landingPage1.changingPort(portNumber, getDriver1());
        landingPage1.loginToApplication(phoneNumber, otp, getDriver1());
        homePage1.handlingPopup(getDriver1());
        String text = homePage1.getAvailableCoin(getDriver1());
        homePage2.clickOnTrainingTab(getDriver2());
        homePage1.clickOnTrainingTab(getDriver1());
        trainingRoomPage2.clickOnPlusIcon(getDriver2());
        trainingRoomPage2.clickOnCreateRoomIcon(getDriver2());
        trainingRoomPage2.clickOnVideoRoomButton(getDriver2());
        tagScreenPage2.clickOnLoveTag(getDriver2());
        tagScreenPage2.verifyUerAbleToHost(getDriver2());
        trainingRoomPage1.checkCoinAndEnterRoom(text, expectedCoins, getDriver1());
        hostedVideoCallPage2.hostBanTheUser(getDriver2());
        hostedVideoCallPage1.userGotTheWarning(getDriver1());
        trainingRoomPage1.verifyUserNotJoinRoomAfterBan(getDriver1());
    }

    @Test(priority = 7, enabled = true)
    public void verifyThatUserAbleToLeaveThatGameDuringONGame() throws InterruptedException {
        String phoneNumber = VideoCallTest.getJSONObject("VideoCallTest").getString("phoneNumberDev1");
        String otp = VideoCallTest.getJSONObject("VideoCallTest").getString("otp");
        String phoneNumber2 = VideoCallTest.getJSONObject("VideoCallTest").getString("phoneNumberDev2");
        String partialum = VideoCallTest.getJSONObject("VideoCallTest").getString("partialPhNo");
        String expectedCoins = VideoCallTest.getJSONObject("VideoCallTest").getString("expectedCoins");
        String nickName = VideoCallTest.getJSONObject("VideoCallTest").getString("nickName");
        String portNumber = VideoCallTest.getJSONObject("VideoCallTest").getString("portNumber");
        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.KEYCODE_VOLUME_DOWN(getDriver1());
        landingPage1.changingPort(portNumber, getDriver1());
        landingPage2.handlingUpdatePopup(getDriver2());
        landingPage2.KEYCODE_VOLUME_DOWN(getDriver2());
        landingPage2.changingPort(portNumber, getDriver2());
        landingPage1.loginToApplication(phoneNumber, otp, getDriver1());
        landingPage2.loginToApplication(phoneNumber2, otp, getDriver2());
        homePage1.handlingPopup(getDriver1());
        homePage2.handlingPopup(getDriver2());
        String text = homePage1.getAvailableCoin(getDriver1());
        homePage2.clickOnTrainingTab(getDriver2());
        homePage1.clickOnTrainingTab(getDriver1());
        trainingRoomPage2.clickOnPlusIcon(getDriver2());
        trainingRoomPage2.clickOnCreateRoomIcon(getDriver2());
        trainingRoomPage2.clickOnVideoRoomButton(getDriver2());
        tagScreenPage2.clickOnLoveTag(getDriver2());
        tagScreenPage2.verifyUerAbleToHost(getDriver2());
        trainingRoomPage1.checkCoinAndEnterRoom(text, expectedCoins, getDriver1());
        hostedVideoCallPage1.clickOnExitButton(getDriver1());
        hostedVideoCallPage1.verfiyUserGotRemoveFromVoiceCall(getDriver1());
    }
}
