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

public class VideoCallTest extends BaseTest {
    LandingPage landingPage1, landingPage2;
    HomePage homePage1, homePage2;
    PrivateTrainingRoomPage trainingRoomPage1, trainingRoomPage2;
    SelectTagScreenPage tagScreenPage1, tagScreenPage2;
    HostedVideoCallPage hostedVideoCallPage1, hostedVideoCallPage2;
    ApiUdateData apiUdateData;
    PaymentPage paymentPage1, paymentPage2;
    FrndCoinPage frndCoinPage1,frndCoinPage2;

    HostedAudioCallPage vivoCallPage1, vivoCallPage2;
    FetchValue fetchValue;
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
        frndCoinPage1 = new FrndCoinPage(getDriver1());
        frndCoinPage2 = new FrndCoinPage(getDriver2());
        paymentPage1 = new PaymentPage(getDriver1());
        paymentPage2 = new PaymentPage(getDriver2());
        apiUdateData = new ApiUdateData();
        vivoCallPage1 = new HostedAudioCallPage(getDriver1());
        vivoCallPage2 = new HostedAudioCallPage(getDriver2());
        fetchValue = new FetchValue();
    }

    @AfterMethod
    public void afterMethod() {
        closeApp(getDriver1());
        closeApp(getDriver2());
        launchApp(getDriver1());
        launchApp(getDriver2());
//        getDriver().activateApp("com.dating.for.all.debug");
    }

    //-------------------------- Test Below -----------------------------------------

    /**
     *
     * @throws InterruptedException
     */
    @Test(priority = 0, enabled = false)
    public void verifyThatUserAbleToHostAndExitRoom() throws InterruptedException {
        String phoneNumber = VideoCallTest.getJSONObject("VideoCallTest").getString("phoneNumberDev1");
        String otp = VideoCallTest.getJSONObject("VideoCallTest").getString("otp");
        String portNumber = VideoCallTest.getJSONObject("VideoCallTest").getString("portNumber");
        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.KEYCODE_VOLUME_DOWN(getDriver1());
        landingPage1.changingPort(portNumber, getDriver1());
        landingPage1.loginToApplication(phoneNumber, otp, getDriver1());
      //  String id = fetchValue.fetchValue(phoneNumber);
     //   apiUdateData.videoCallApi(id,true,"http://dev.frndapp.in:8088","/automatedTesting/updateFgGroup");
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

    @Test(priority = 1, enabled = false)
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
        trainingRoomPage1.clickOnVideoRoomButton(getDriver1());
        tagScreenPage1.clickOnLoveTag(getDriver1());
        tagScreenPage1.verifyUerAbleToHost(getDriver1());
        hostedVideoCallPage1.checkMuteUnmuteFunctionality(getDriver1());
    }

    @Test(priority = 2, enabled = true)
    public void VerifyCoinBalanceAfterUserSendsGiftAccordingToTimer() throws InterruptedException {
        String phoneNumber = VideoCallTest.getJSONObject("VideoCallTest").getString("phoneNumberDev1");
        String otp = VideoCallTest.getJSONObject("VideoCallTest").getString("otp");
        String phoneNumber2 = VideoCallTest.getJSONObject("VideoCallTest").getString("phoneNumberDev2");
        String partialum = VideoCallTest.getJSONObject("VideoCallTest").getString("partialPhNo");
        String expectedCoins = VideoCallTest.getJSONObject("VideoCallTest").getString("expectedCoins");
        String baseUri = VideoCallTest.getJSONObject("VideoCallTest").getString("baseUri");
        String endPointFg = VideoCallTest.getJSONObject("VideoCallTest").getString("endPointFG");
        String portNumber = VideoCallTest.getJSONObject("VideoCallTest").getString("portNumber");
        landingPage2.handlingUpdatePopup(getDriver2());
        landingPage2.KEYCODE_VOLUME_DOWN(getDriver2());
        landingPage2.changingPort(portNumber, getDriver2());
        landingPage2.loginToApplication(phoneNumber2, otp, getDriver2());
        homePage2.handlingPopup(getDriver2());
        homePage2.clickOnTrainingTab(getDriver2());
        trainingRoomPage2.clickOnPlusIcon(getDriver2());
        trainingRoomPage2.clickOnCreateRoomIcon(getDriver2());
        trainingRoomPage2.clickOnVideoRoomButton(getDriver2());
        tagScreenPage2.clickOnLoveTag(getDriver2());
        tagScreenPage2.verifyUerAbleToHost(getDriver2());
        vivoCallPage2.hostExitRoom(getDriver2());
        homePage2.verifyHostExitTheRoom(getDriver2());
        trainingRoomPage2.clickOnPlusIcon(getDriver2());
        trainingRoomPage2.clickOnCreateRoomIcon(getDriver2());
        trainingRoomPage2.clickOnVideoRoomButton(getDriver2());
        tagScreenPage2.clickOnLoveTag(getDriver2());
        tagScreenPage2.verifyUerAbleToHost(getDriver2());
        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.KEYCODE_VOLUME_DOWN(getDriver1());
        landingPage1.changingPort(portNumber, getDriver1());
        landingPage1.loginToApplication(phoneNumber, otp, getDriver1());
        homePage1.handlingPopup(getDriver1());
        String id = fetchValue.fetchValue(phoneNumber);
        apiUdateData.videoCallApi(id,true,baseUri,endPointFg,phoneNumber);
        String text = homePage1.getAvailableCoin(getDriver1());
        homePage1.clickOnTrainingTab(getDriver1());
        homePage1.clickOnTrainingTab(getDriver1());
        homePage1.clickOnTrainingTab(getDriver1());
        Thread.sleep(2000);
        swipeScreen(Direction.DOWN,getDriver1());
        trainingRoomPage1.checkCoinAndEnterRoom(text, expectedCoins, getDriver1());
        hostedVideoCallPage1.verfiyTimerAndGiftCoinAfterSendsGift(text, getDriver1());
        vivoCallPage2.clickOnGameIcon(getDriver2());
        vivoCallPage2.clickOnGamePopupCrossButton(getDriver2());
        hostedVideoCallPage2.checkMuteUnmuteFunctionality(getDriver2());
        hostedVideoCallPage2.hostRemoveUserFromTheRoom(getDriver2());
        hostedVideoCallPage1.verfiyUserGotRemoveFromVoiceCall(getDriver1());
        hostedVideoCallPage1.clickOnStarRating(getDriver1());
        hostedVideoCallPage1.giveReviewMessage(getDriver1());
        hostedVideoCallPage1.clickOnSubmitButton(getDriver1());
        hostedVideoCallPage1.shareAppExperienceRating(getDriver1());
        trainingRoomPage1.checkCoinsDeducted(text, getDriver1());
        trainingRoomPage1.checkCoinAndEnterRoom(text, expectedCoins, getDriver1());
        hostedVideoCallPage2.clickOnExitButton(getDriver2());
        homePage2.verifyHostExitTheRoom(getDriver2());
        trainingRoomPage2.clickOnPlusIcon(getDriver2());
        trainingRoomPage2.clickOnCreateRoomIcon(getDriver2());
        trainingRoomPage2.clickOnVideoRoomButton(getDriver2());
        tagScreenPage2.clickOnLoveTag(getDriver2());
        tagScreenPage2.verifyUerAbleToHost(getDriver2());
        vivoCallPage1.clickOnStarRating(getDriver1());
        vivoCallPage1.clickOnskipCrossButton(getDriver1());
        homePage1.clickOnTrainingTab(getDriver1());
        Thread.sleep(2000);
        swipeScreen(Direction.DOWN,getDriver1());
        trainingRoomPage1.checkCoinAndEnterRoom(text, expectedCoins, getDriver1());
        hostedVideoCallPage1.clickOnExitButton(getDriver1());
        hostedVideoCallPage1.verifyUserLeaveGameduringOnGame(getDriver1());
        vivoCallPage1.clickOnStarRating(getDriver1());
        vivoCallPage1.clickOnskipCrossButton(getDriver1());
        trainingRoomPage1.checkCoinsDeducted(text, getDriver1());
    }

    @Test(priority = 3, enabled = false)
    public void verifyThatUserAbleToRemoveTheVideoCallWhenHostRemoveParticularUsers() throws InterruptedException {
        String phoneNumber = VideoCallTest.getJSONObject("VideoCallTest").getString("phoneNumberDev1");
        String otp = VideoCallTest.getJSONObject("VideoCallTest").getString("otp");
        String phoneNumber2 = VideoCallTest.getJSONObject("VideoCallTest").getString("phoneNumberDev2");
        String expectedCoins = VideoCallTest.getJSONObject("VideoCallTest").getString("expectedCoins");
        String portNumber = VideoCallTest.getJSONObject("VideoCallTest").getString("portNumber");
        String baseUri = VideoCallTest.getJSONObject("VideoCallTest").getString("baseUri");
        String endPointFg = VideoCallTest.getJSONObject("VideoCallTest").getString("endPointFG");
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
        String id = fetchValue.fetchValue(phoneNumber);
        apiUdateData.videoCallApi(id,true,baseUri,endPointFg,phoneNumber);
        String text = homePage1.getAvailableCoin(getDriver1());
        homePage2.clickOnTrainingTab(getDriver2());
        homePage1.clickOnTrainingTab(getDriver1());
        trainingRoomPage2.clickOnPlusIcon(getDriver2());
        trainingRoomPage2.clickOnCreateRoomIcon(getDriver2());
        trainingRoomPage2.clickOnVideoRoomButton(getDriver2());
        tagScreenPage2.clickOnLoveTag(getDriver2());
        tagScreenPage2.verifyUerAbleToHost(getDriver2());
        trainingRoomPage1.checkCoinAndEnterRoom(text, expectedCoins, getDriver1());
        trainingRoomPage2.clickOnIAgreeButton(getDriver2());
        hostedVideoCallPage2.hostRemoveUserFromTheRoom(getDriver2());
        hostedVideoCallPage1.verfiyUserGotRemoveFromVideoCall(getDriver1());
    }

    @Test(priority = 4, enabled = false)
    public void verifyThatUsersAreAbleToJoinInVoiceCallAccordingCoinBalance() throws InterruptedException {
        String phoneNumber = VideoCallTest.getJSONObject("VideoCallTest").getString("phoneNumberDev1");
        String otp = VideoCallTest.getJSONObject("VideoCallTest").getString("otp");
        String phoneNumber2 = VideoCallTest.getJSONObject("VideoCallTest").getString("phoneNumberDev2");
        String expectedCoins = VideoCallTest.getJSONObject("VideoCallTest").getString("expectedCoins");
        String portNumber = VideoCallTest.getJSONObject("VideoCallTest").getString("portNumber");
        String baseUri = VideoCallTest.getJSONObject("VideoCallTest").getString("baseUri");
        String endPointFg = VideoCallTest.getJSONObject("VideoCallTest").getString("endPointFG");
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
        String id = fetchValue.fetchValue(phoneNumber);
        apiUdateData.videoCallApi(id,true,baseUri,endPointFg,phoneNumber);
        String text = homePage1.getAvailableCoin(getDriver1());
        homePage2.clickOnTrainingTab(getDriver2());
        trainingRoomPage2.clickOnPlusIcon(getDriver2());
        trainingRoomPage2.clickOnCreateRoomIcon(getDriver2());
        homePage1.clickOnTrainingTab(getDriver1());
        trainingRoomPage2.clickOnVideoRoomButton(getDriver2());
        tagScreenPage2.clickOnLoveTag(getDriver2());
        tagScreenPage2.verifyUerAbleToHost(getDriver2());
        trainingRoomPage1.checkCoinAndEnterRoom(text, expectedCoins, getDriver1());
        trainingRoomPage2.clickOnIAgreeButton(getDriver2());
        hostedVideoCallPage2.hostExitGameRoom(getDriver2());
    }

    @Test(priority = 5, enabled = true)
    public void userNotAbleToJoinRoomWhenHostBanUser() throws InterruptedException {
        String phoneNumber = VideoCallTest.getJSONObject("VideoCallTest").getString("phoneNumberDev1");
        String otp = VideoCallTest.getJSONObject("VideoCallTest").getString("otp");
        String partialum = VideoCallTest.getJSONObject("VideoCallTest").getString("partialPhNo");
        String expectedCoins = VideoCallTest.getJSONObject("VideoCallTest").getString("expectedCoins");
        String nickName = VideoCallTest.getJSONObject("VideoCallTest").getString("nickName");
        String portNumber = VideoCallTest.getJSONObject("VideoCallTest").getString("portNumber");
        String baseUri = VideoCallTest.getJSONObject("VideoCallTest").getString("baseUri");
        String endPointFg = VideoCallTest.getJSONObject("VideoCallTest").getString("endPointFG");
        landingPage2.handlingUpdatePopup(getDriver2());
        landingPage2.KEYCODE_VOLUME_DOWN(getDriver2());
        landingPage2.changingPort(portNumber, getDriver2());
        int i = getRandomNum();
        String phonNum = partialum + Integer.toString(i);
        landingPage2.clickOnLetsGoButton(getDriver2());//1
        landingPage2.enterMobileNumber(phonNum, getDriver2());//1
        landingPage2.clickOnGetOTPButton(getDriver2());//1
        landingPage2.enterOTPNumber(otp, getDriver2());//1
        landingPage2.clickOnSubmitButton(getDriver2());//1
        landingPage2.enterNickName(getDriver2(), nickName);//1
        landingPage2.clickOnSelectGenderButton(getDriver2());//1
        landingPage2.clickOnBoyGender(getDriver2());//1
        landingPage2.clickOnDateOfBirthButtonAndOkButton(getDriver2());
        landingPage2.clickOnSignInSubmitButton(getDriver2());
        landingPage2.selectLanguage(getDriver2());
        landingPage2.checkCyberManifestoPolicies(getDriver2());
        landingPage2.selectAppLanguage(getDriver2());
        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.KEYCODE_VOLUME_DOWN(getDriver1());
        landingPage1.changingPort(portNumber, getDriver1());
        landingPage1.loginToApplication(phoneNumber, otp, getDriver1());
        homePage1.handlingPopup(getDriver1());
        String id = fetchValue.fetchValue(phonNum);
        apiUdateData.videoCallApi(id,true,baseUri,endPointFg,phonNum);
        String text = homePage1.getAvailableCoin(getDriver1());
        homePage1.clickOnTrainingTab(getDriver1());
        trainingRoomPage1.clickOnPlusIcon(getDriver2());
        trainingRoomPage1.clickOnCreateRoomIcon(getDriver2());
        trainingRoomPage1.clickOnVideoRoomButton(getDriver1());
        tagScreenPage1.clickOnLoveTag(getDriver1());
        tagScreenPage1.verifyUerAbleToHost(getDriver1());
        homePage2.handlingPopup(getDriver2());
        homePage2.clickOnHomeTab(getDriver2());
        homePage2.clickOnCoins(getDriver2());
        frndCoinPage2.clickOnNienetyCoinPackage(getDriver2());
        paymentPage2.selectFrndAppPaymentMethod(getDriver2());
        paymentPage2.clickOnGooglePayIcon(getDriver2());
        paymentPage2.enterOTPAndMakePayment(getDriver2(),otp);
        trainingRoomPage2.clickOnIAgreeButton(getDriver2());
        String availableCoin = homePage2.getAvailableCoin(getDriver2());
        homePage2.clickOnTrainingTab(getDriver2());
        trainingRoomPage2.checkCoinAndEnterRoom(text, expectedCoins, getDriver2());
        trainingRoomPage1.clickOnIAgreeButton(getDriver1());
        hostedVideoCallPage1.hostBanTheUser(getDriver1());
        hostedVideoCallPage2.userGotTheWarning(getDriver2());
        trainingRoomPage2.verifyUserNotJoinRoomAfterBan(getDriver2());
    }

    @Test(priority = 7,enabled = true)
    public void verifyThatUserIsAbleToExitTheGameAutomaticallyAfterEndOfGameTimer() throws InterruptedException {
        String phoneNumber = VideoCallTest.getJSONObject("VideoCallTest").getString("phoneNumberDev1");
        String otp = VideoCallTest.getJSONObject("VideoCallTest").getString("otp");
        String partialum = VideoCallTest.getJSONObject("VideoCallTest").getString("partialPhNo");
        String expectedCoins = VideoCallTest.getJSONObject("VideoCallTest").getString("expectedCoins");
        String nickName = VideoCallTest.getJSONObject("VideoCallTest").getString("nickName");
        String portNumber = VideoCallTest.getJSONObject("VideoCallTest").getString("portNumber");
        String baseUri = VideoCallTest.getJSONObject("VideoCallTest").getString("baseUri");
        String endPointFg = VideoCallTest.getJSONObject("VideoCallTest").getString("endPointFG");
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
        homePage2.clickOnHomeTab(getDriver2());
        homePage2.clickOnCoins(getDriver2());
        frndCoinPage2.clickOnNienetyCoinPackage(getDriver2());
        paymentPage2.selectFrndAppPaymentMethod(getDriver2());
        paymentPage2.clickOnGooglePayIcon(getDriver2());
        paymentPage2.enterOTPAndMakePayment(getDriver2(),otp);
        trainingRoomPage2.clickOnIAgreeButton(getDriver2());
        String availableCoin = homePage2.getAvailableCoin(getDriver2());
        homePage2.clickOnTrainingTab(getDriver2());
        String id = fetchValue.fetchValue(phonNum);
        apiUdateData.videoCallApi(id,true,baseUri,endPointFg,phonNum);
        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.KEYCODE_VOLUME_DOWN(getDriver1());
        landingPage1.changingPort(portNumber, getDriver1());
        landingPage1.loginToApplication(phoneNumber, otp, getDriver1());
        homePage1.handlingPopup(getDriver1());
        String text = homePage1.getAvailableCoin(getDriver1());
        homePage1.clickOnTrainingTab(getDriver1());
        trainingRoomPage1.clickOnPlusIcon(getDriver1());
        trainingRoomPage1.clickOnCreateRoomIcon(getDriver1());
        trainingRoomPage1.clickOnVideoRoomButton(getDriver1());
        tagScreenPage1.clickOnLoveTag(getDriver1());
        tagScreenPage1.verifyUerAbleToHost(getDriver1());
        trainingRoomPage2.checkCoinAndEnterRoom(availableCoin, expectedCoins, getDriver2());
        Thread.sleep(120000);
        vivoCallPage2.clickOnStarRating(getDriver2());
        vivoCallPage2.checkUserHaveExitRoomAutomatically(getDriver2());
    }

    @Test(priority = 7,enabled = true)
    public void verifyTheHostEndShouldBeShownTheGamePromptsInVivoIfUserNotClickManuallyInBefore60Sec() throws InterruptedException {
        String phoneNumber = VideoCallTest.getJSONObject("VideoCallTest").getString("phoneNumberDev1");
        String otp = VideoCallTest.getJSONObject("VideoCallTest").getString("otp");
        String phoneNumber2 = VideoCallTest.getJSONObject("VideoCallTest").getString("phoneNumberDev2");
        String expectedCoins = VideoCallTest.getJSONObject("VideoCallTest").getString("expectedCoins");
        String portNumber = VideoCallTest.getJSONObject("VideoCallTest").getString("portNumber");
        String baseUri = VideoCallTest.getJSONObject("VideoCallTest").getString("baseUri");
        String endPointFg = VideoCallTest.getJSONObject("VideoCallTest").getString("endPointFG");
        landingPage2.handlingUpdatePopup(getDriver2());
        landingPage2.KEYCODE_VOLUME_DOWN(getDriver2());
        landingPage2.changingPort(portNumber, getDriver2());
        landingPage2.loginToApplication(phoneNumber2, otp, getDriver2());
        homePage2.handlingPopup(getDriver2());
        homePage2.clickOnTrainingTab(getDriver2());
        trainingRoomPage2.clickOnPlusIcon(getDriver2());
        trainingRoomPage2.clickOnCreateRoomIcon(getDriver2());
        homePage1.clickOnTrainingTab(getDriver1());
        trainingRoomPage2.clickOnVideoRoomButton(getDriver2());
        tagScreenPage2.clickOnLoveTag(getDriver2());
        tagScreenPage2.verifyUerAbleToHost(getDriver2());
        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.KEYCODE_VOLUME_DOWN(getDriver1());
        landingPage1.changingPort(portNumber, getDriver1());
        landingPage1.loginToApplication(phoneNumber, otp, getDriver1());
        homePage1.handlingPopup(getDriver1());
        String id = fetchValue.fetchValue(phoneNumber);
        apiUdateData.videoCallApi(id,true,baseUri,endPointFg,phoneNumber);
        String text = homePage1.getAvailableCoin(getDriver1());
        homePage1.clickOnTrainingTab(getDriver1());
        trainingRoomPage1.checkCoinAndEnterRoom(text, expectedCoins, getDriver1());
        vivoCallPage2.verifyHostEndShouldShowGamePromptOrNotWithin60Sec(getDriver2());
        vivoCallPage2.clickOnLudoGames(getDriver2());
        vivoCallPage1.clickOnReconsiderCrossButton(getDriver1());
        vivoCallPage1.clickOnNoButton(getDriver1());
        vivoCallPage1.verifyGameStarted(getDriver1());
        vivoCallPage2.clickOnExitButton(getDriver2());
        trainingRoomPage2.clickOnPlusIcon(getDriver2());
        trainingRoomPage2.clickOnCreateRoomIcon(getDriver2());
        trainingRoomPage2.clickOnVideoRoomButton(getDriver2());
        tagScreenPage2.clickOnLoveTag(getDriver2());
        tagScreenPage2.verifyUerAbleToHost(getDriver2());
        vivoCallPage1.clickOnStarRating(getDriver1());
        vivoCallPage1.giveReviewMessage(getDriver1());
        vivoCallPage1.clickOnSubmitButton(getDriver1());
        vivoCallPage1.shareAppExperienceRating(getDriver1());
        homePage1.clickOnTrainingTab(getDriver1());
        trainingRoomPage1.checkCoinAndEnterRoom(text, expectedCoins, getDriver1());
        vivoCallPage2.clickOnGameIcon(getDriver2());
        vivoCallPage2.clickOnLudoGames(getDriver2());
        vivoCallPage1.clickOnHaanButton(getDriver1());
        vivoCallPage1.verifyGameStarted(getDriver1());
        vivoCallPage2.clickOnGameIcon(getDriver2());
        vivoCallPage2.clickOnGamePopupCrossButton(getDriver2());
        vivoCallPage2.clickOnExitButton(getDriver2());
        trainingRoomPage2.clickOnPlusIcon(getDriver2());
        trainingRoomPage2.clickOnCreateRoomIcon(getDriver2());
        trainingRoomPage2.clickOnVideoRoomButton(getDriver2());
        tagScreenPage2.clickOnLoveTag(getDriver2());
        tagScreenPage2.verifyUerAbleToHost(getDriver2());
        vivoCallPage1.clickOnStarRating(getDriver1());
        vivoCallPage1.clickOnskipCrossButton(getDriver1());
        homePage1.clickOnTrainingTab(getDriver1());
        trainingRoomPage1.checkCoinAndEnterRoom(text, expectedCoins, getDriver1());
        vivoCallPage2.clickOnGameIcon(getDriver2());
        vivoCallPage2.clickOnGamePopupCrossButton(getDriver2());
        vivoCallPage2.verifyHostEndShouldShowGamePromptOrNotWithin60Sec(getDriver2());
        vivoCallPage2.clickOnGameIcon(getDriver2());
        vivoCallPage2.clickOnLudoGames(getDriver2());
        vivoCallPage1.clickOnReconsiderCrossButton(getDriver1());
        vivoCallPage1.clickOnYesButton(getDriver1());
        vivoCallPage2.clickOnGameIcon(getDriver2());
        vivoCallPage2.clickOnLudoGames(getDriver2());
        vivoCallPage1.clickOnReconsiderCrossButton(getDriver1());
        vivoCallPage1.clickOnRejectCrossButton(getDriver1());
        vivoCallPage2.clickOnExitButton(getDriver2());
        trainingRoomPage2.clickOnPlusIcon(getDriver2());
        trainingRoomPage2.clickOnCreateRoomIcon(getDriver2());
        trainingRoomPage2.clickOnVideoRoomButton(getDriver2());
        tagScreenPage2.clickOnLoveTag(getDriver2());
        tagScreenPage2.verifyUerAbleToHost(getDriver2());
        vivoCallPage1.clickOnStarRating(getDriver1());
        vivoCallPage1.clickOnskipCrossButton(getDriver1());
        homePage1.clickOnTrainingTab(getDriver1());
        trainingRoomPage1.checkCoinAndEnterRoom(text, expectedCoins, getDriver1());
        trainingRoomPage2.clickOnIAgreeButton(getDriver2());
        vivoCallPage1.verifyUserEndShouldShowGamePromptOrNotWithin60Sec(getDriver1());
        vivoCallPage2.clickOnExitButton(getDriver2());
        trainingRoomPage2.clickOnPlusIcon(getDriver2());
        trainingRoomPage2.clickOnCreateRoomIcon(getDriver2());
        trainingRoomPage2.clickOnVideoRoomButton(getDriver2());
        tagScreenPage2.clickOnLoveTag(getDriver2());
        tagScreenPage2.verifyUerAbleToHost(getDriver2());
        vivoCallPage1.clickOnStarRating(getDriver1());
        vivoCallPage1.clickOnskipCrossButton(getDriver1());
        homePage1.clickOnTrainingTab(getDriver1());
        trainingRoomPage1.checkCoinAndEnterRoom(text, expectedCoins, getDriver1());
        vivoCallPage1.clickOnGameIcon(getDriver1());
        vivoCallPage1.clickOnGamePopupCrossButton(getDriver1());
        vivoCallPage1.verifyUserEndShouldShowGamePromptOrNotWithin60Sec(getDriver1());
    }

    @Test(priority = 8,enabled = true)
    public void verifyUserShouldBeAbleToSeeStarUsersHostedPTRRoomWhichUsersHasDoneSuccesfullOneTranscation() throws InterruptedException {
        String otp = VideoCallTest.getJSONObject("VideoCallTest").getString("otp");
        String partialum = VideoCallTest.getJSONObject("VideoCallTest").getString("partialPhNo");
        String nickName = VideoCallTest.getJSONObject("VideoCallTest").getString("nickName");
        String portNumber = VideoCallTest.getJSONObject("VideoCallTest").getString("portNumber");
        String phoneNumber3 = VideoCallTest.getJSONObject("VideoCallTest").getString("phoneNumber");
        String baseUri = VideoCallTest.getJSONObject("VideoCallTest").getString("baseUri");
        String endPointFg = VideoCallTest.getJSONObject("VideoCallTest").getString("endPointFG");
        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.KEYCODE_VOLUME_DOWN(getDriver1());
        landingPage1.changingPort(portNumber, getDriver1());
        landingPage1.loginToApplication(phoneNumber3, otp, getDriver1());
        homePage1.handlingPopup(getDriver1());
        homePage1.clickOnTrainingTab(getDriver1());
        trainingRoomPage1.clickOnPlusIcon(getDriver1());
        trainingRoomPage1.clickOnCreateRoomIcon(getDriver1());
        trainingRoomPage1.clickOnVideoRoomButton(getDriver1());
        tagScreenPage1.clickOnLoveTag(getDriver1());
        tagScreenPage1.verifyUerAbleToHost(getDriver1());
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
        String id = fetchValue.fetchValue(phonNum);
        apiUdateData.videoCallApi(id,true,baseUri,endPointFg,phonNum);
        String availableCoin = homePage2.getAvailableCoin(getDriver2());
        homePage2.clickOnTrainingTab(getDriver2());
        trainingRoomPage2.checkStarUserDisplayedAndJoinRoomForVideoCall(getDriver2(),availableCoin,200);
        homePage2.clickOnCoins(getDriver2());
        frndCoinPage2.clickOnTwentyCoinPackage(getDriver2());
        paymentPage2.selectFrndAppPaymentMethod(getDriver2());
        paymentPage2.clickOnGooglePayIcon(getDriver2());
        paymentPage2.enterOTPAndMakePayment(getDriver2(),otp);
        trainingRoomPage2.clickOnIAgreeButton(getDriver2());
        String availableCoin1 = homePage2.getAvailableCoin(getDriver2());
        homePage2.clickOnTrainingTab(getDriver2());
        trainingRoomPage2.checkStarUserDisplayedAndJoinRoomForVideoCall(getDriver2(),availableCoin1,200);
        homePage2.clickOnCoins(getDriver2());
        frndCoinPage2.clickOnTwoHundredCoinPackage(getDriver2());
        paymentPage2.selectFrndAppPaymentMethod(getDriver2());
        paymentPage2.clickOnGooglePayIcon(getDriver2());
        paymentPage2.enterOTPAndMakePayment(getDriver2(),otp);
        trainingRoomPage2.clickOnIAgreeButton(getDriver2());
        String availableCoin3 = homePage2.getAvailableCoin(getDriver2());
        homePage2.clickOnTrainingTab(getDriver2());
        trainingRoomPage2.checkStarUserDisplayedAndJoinRoomForVideoCall(getDriver2(),availableCoin3,200);
    }
}
