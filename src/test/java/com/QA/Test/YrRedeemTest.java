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

public class YrRedeemTest extends BaseTest {

    LandingPage landingPage1, landingPage2;
    HomePage homePage1, homePage2;
    PrivateTrainingRoomPage trainingRoomPage1, trainingRoomPage2;
    SelectTagScreenPage tagScreenPage1, tagScreenPage2;
    HostedAudioCallPage vivoCallPage1, vivoCallPage2;
    JSONObject YrRedeemTest;
    ProfilePage profilePage1, profilePage2;
    FrndCoinPage frndCoinPage1, frndCoinPage2;
    TestUtils utils = new TestUtils();
    PaymentPage paymentPage1, paymentPage2;
    HostedVideoCallPage hostedVideoCallPage1, hostedVideoCallPage2;

    ApiUdateData apiUdateData;
    FetchValue fetchValue;
    String phonNum;

    @BeforeClass
    public void beforeClass() throws Exception {
        InputStream datais = null;
        try {
            String dataFileName = "data/yrRedeemTest.json";
            datais = getClass().getClassLoader().getResourceAsStream(dataFileName);
            JSONTokener tokener = new JSONTokener(datais);
            YrRedeemTest = new JSONObject(tokener);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (datais != null) {
                datais.close();
            }
        }
        //    closeApp();
        //    launchApp();
    }

    @AfterClass
    public void afterClass() {
        //   getDriver().quit();
    }

    @BeforeMethod
    public void beforeMethod(Method m) throws InterruptedException {
        utils.log().info("\n" + "****** starting test:" + m.getName() + "******" + "\n");
        landingPage1 = new LandingPage(getDriver1());
        landingPage2 = new LandingPage(getDriver2());
        homePage1 = new HomePage(getDriver1());
        homePage2 = new HomePage(getDriver2());
        trainingRoomPage1 = new PrivateTrainingRoomPage(getDriver1());
        trainingRoomPage2 = new PrivateTrainingRoomPage(getDriver2());
        tagScreenPage1 = new SelectTagScreenPage(getDriver1());
        tagScreenPage2 = new SelectTagScreenPage(getDriver2());
        vivoCallPage1 = new HostedAudioCallPage(getDriver1());
        vivoCallPage2 = new HostedAudioCallPage(getDriver2());
        profilePage1 = new ProfilePage(getDriver1());
        profilePage2 = new ProfilePage(getDriver2());
        frndCoinPage1 = new FrndCoinPage(getDriver1());
        paymentPage1 = new PaymentPage(getDriver1());
        paymentPage2 = new PaymentPage(getDriver2());
        hostedVideoCallPage1 = new HostedVideoCallPage(getDriver1());
        hostedVideoCallPage2 = new HostedVideoCallPage(getDriver2());
        apiUdateData = new ApiUdateData();
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
    @Test(priority = 0, enabled = false)
    public void verifyThatHostAbleToReceiveTheAutoYRInAudioGames() throws InterruptedException {
        String phoneNumber = YrRedeemTest.getJSONObject("YrRedeemTest").getString("phoneNumberDev1");
        String otp = YrRedeemTest.getJSONObject("YrRedeemTest").getString("otp");
        String partialNum = YrRedeemTest.getJSONObject("YrRedeemTest").getString("partialPhNo");
        String expectedCoins = YrRedeemTest.getJSONObject("YrRedeemTest").getString("expectedCoins");
        String nickName = YrRedeemTest.getJSONObject("YrRedeemTest").getString("nickName");
        String portNumber = YrRedeemTest.getJSONObject("YrRedeemTest").getString("portNumber");
        String baseUri = YrRedeemTest.getJSONObject("YrRedeemTest").getString("baseUri");
        String endPointFG = YrRedeemTest.getJSONObject("YrRedeemTest").getString("endPointFG");
        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.KEYCODE_VOLUME_DOWN(getDriver1());
        landingPage1.changingPort(portNumber, getDriver1());
        landingPage2.handlingUpdatePopup(getDriver2());
        landingPage2.KEYCODE_VOLUME_DOWN(getDriver2());
        landingPage2.changingPort(portNumber, getDriver2());
        int i = getRandomNum();
        String phonNum = partialNum + Integer.toString(i);
        landingPage1.clickOnLetsGoButton(getDriver1());
        landingPage1.enterMobileNumber(phonNum, getDriver1());
        landingPage1.clickOnGetOTPButton(getDriver1());
        landingPage1.enterOTPNumber(otp, getDriver1());
        landingPage1.clickOnSubmitButton(getDriver1());
        landingPage1.enterNickName(getDriver1(), nickName);
        landingPage1.clickOnSelectGenderButton(getDriver1());
        landingPage1.clickOnBoyGender(getDriver1());
        landingPage1.clickOnDateOfBirthButtonAndOkButton(getDriver1());
        landingPage1.clickOnSignInSubmitButton(getDriver1());
        landingPage1.selectLanguage(getDriver1());
        landingPage1.checkCyberManifestoPolicies(getDriver1());
        landingPage1.selectAppLanguage(getDriver1());
        homePage1.handlingPopup(getDriver1());
        landingPage2.handlingUpdatePopup(getDriver2());
        landingPage2.loginToApplication(phoneNumber, otp, getDriver2());
        String id = fetchValue.fetchValue(phonNum);
        apiUdateData.videoCallApi(id,true,baseUri,endPointFG,phonNum);
        homePage1.clickOnTrainingTab(getDriver1());
        homePage2.handlingPopup(getDriver2());
        String text = homePage2.getAvailableCoin(getDriver2());
        homePage2.clickOnTrainingTab(getDriver2());
        trainingRoomPage1.clickOnPlusIcon(getDriver1());
        trainingRoomPage1.clickOnCreateRoomIcon(getDriver1());
        trainingRoomPage1.clickOnAudioRoomButton(getDriver1());
        tagScreenPage1.clickOnLoveTag(getDriver1());
        tagScreenPage1.verifyUerAbleToHost(getDriver1());
        trainingRoomPage2.checkCoinAndEnterRoom(text, expectedCoins, getDriver2());
        vivoCallPage1.clickOnGameIcon(getDriver1());
        vivoCallPage1.clickOnGamePopupCrossButton(getDriver1());
        vivoCallPage2.clickOnGameIcon(getDriver2());
        vivoCallPage2.clickOnGamePopupCrossButton(getDriver2());
        Thread.sleep(125000);
        vivoCallPage1.clickOnExitButton(getDriver1());
        trainingRoomPage1.clickOnProfileIcon(getDriver1());
        profilePage1.clikcOnWinMoneyButton(getDriver1());
        profilePage1.checkRedeemSuccessMessageVisibility(getDriver1());
        profilePage1.verifyYrRedeemSuccess(getDriver1());
        clickBackButton(getDriver1());
        trainingRoomPage1.clickOnPlusIcon(getDriver1());
        trainingRoomPage1.clickOnCreateRoomIcon(getDriver1());
        trainingRoomPage1.clickOnVideoRoomButton(getDriver1());
        tagScreenPage1.clickOnLoveTag(getDriver1());
        tagScreenPage1.verifyUerAbleToHost(getDriver1());
        vivoCallPage2.clickOnStarRating(getDriver2());
        vivoCallPage2.clickOnskipCrossButton(getDriver2());
        Thread.sleep(1000);
        swipeScreen(Direction.DOWN,getDriver2());
        trainingRoomPage2.checkCoinAndEnterRoom(text, expectedCoins, getDriver2());
        vivoCallPage1.clickOnGameIcon(getDriver1());
        vivoCallPage1.clickOnGamePopupCrossButton(getDriver1());
        vivoCallPage2.clickOnGameIcon(getDriver2());
        vivoCallPage2.clickOnGamePopupCrossButton(getDriver2());
        Thread.sleep(85000);
        hostedVideoCallPage1.clickOnExitButton1(getDriver1());
        trainingRoomPage1.clickOnProfileIcon(getDriver1());
        profilePage1.clikcOnWinMoneyButton(getDriver1());
        profilePage1.checkRedeemSuccessMessageVisibility(getDriver1());
        profilePage1.verifyYrRedeemSuccess(getDriver1());
    }

    @Test(priority = 1, enabled = false)
    public void verifyThatHostAbleToReceiveTheAutoYRInVideoGames() throws InterruptedException {
        String phoneNumber = YrRedeemTest.getJSONObject("YrRedeemTest").getString("phoneNumberDev1");
        String otp = YrRedeemTest.getJSONObject("YrRedeemTest").getString("otp");
        String partialNum = YrRedeemTest.getJSONObject("YrRedeemTest").getString("partialPhNo");
        String expectedCoins = YrRedeemTest.getJSONObject("YrRedeemTest").getString("expectedCoins");
        String nickName = YrRedeemTest.getJSONObject("YrRedeemTest").getString("nickName");
        String portNumber = YrRedeemTest.getJSONObject("YrRedeemTest").getString("portNumber");
        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.KEYCODE_VOLUME_DOWN(getDriver1());
        landingPage1.changingPort(portNumber, getDriver1());
        landingPage2.handlingUpdatePopup(getDriver2());
        landingPage2.KEYCODE_VOLUME_DOWN(getDriver2());
        landingPage2.changingPort(portNumber, getDriver2());
        int i = getRandomNum();
        String phonNum = partialNum + Integer.toString(i);
        landingPage1.clickOnLetsGoButton(getDriver1());
        landingPage1.enterMobileNumber(phonNum, getDriver1());
        landingPage1.clickOnGetOTPButton(getDriver1());
        landingPage1.enterOTPNumber(otp, getDriver1());
        landingPage1.clickOnSubmitButton(getDriver1());
        landingPage1.enterNickName(getDriver1(), nickName);
        landingPage1.clickOnSelectGenderButton(getDriver1());
        landingPage1.clickOnBoyGender(getDriver1());
        landingPage1.clickOnDateOfBirthButtonAndOkButton(getDriver1());
        landingPage1.clickOnSignInSubmitButton(getDriver1());
        landingPage1.selectLanguage(getDriver1());
        landingPage1.checkCyberManifestoPolicies(getDriver1());
        landingPage1.selectAppLanguage(getDriver1());
        homePage1.handlingPopup(getDriver1());
        landingPage2.handlingUpdatePopup(getDriver2());
        landingPage2.loginToApplication(phoneNumber, otp, getDriver2());
        homePage1.clickOnTrainingTab(getDriver1());
        homePage2.handlingPopup(getDriver2());
        String id = fetchValue.fetchValue(phoneNumber);
        apiUdateData.videoCallApi(id,true,"http://qa.frndapp.in:8080","/automatedTesting/updateFgGroup",phoneNumber);
        String text = homePage2.getAvailableCoin(getDriver2());
        homePage2.clickOnTrainingTab(getDriver2());
        trainingRoomPage1.clickOnPlusIcon(getDriver1());
        trainingRoomPage1.clickOnCreateRoomIcon(getDriver1());
        trainingRoomPage1.clickOnVideoRoomButton(getDriver1());
        tagScreenPage1.clickOnLoveTag(getDriver1());
        tagScreenPage1.verifyUerAbleToHost(getDriver1());
        trainingRoomPage2.checkCoinAndEnterRoom(text, expectedCoins, getDriver2());
        trainingRoomPage1.clickOnIAgreeButton(getDriver1());
        Thread.sleep(125000);
        hostedVideoCallPage1.clickOnExitButton1(getDriver1());
        trainingRoomPage1.clickOnProfileIcon(getDriver1());
        profilePage1.clikcOnWinMoneyButton(getDriver1());
        profilePage1.checkRedeemSuccessMessageVisibility(getDriver1());
        profilePage1.verifyYrRedeemSuccess(getDriver1());
    }

    @Test(priority = 2, enabled = false)
    public void verifyThatYRCreditedShouldBeShownInCallDurationScreenToHost() throws InterruptedException {
        String phoneNumber = YrRedeemTest.getJSONObject("YrRedeemTest").getString("phoneNumberDev1");
        String otp = YrRedeemTest.getJSONObject("YrRedeemTest").getString("otp");
        String partialNum = YrRedeemTest.getJSONObject("YrRedeemTest").getString("partialPhNo");
        String expectedCoins = YrRedeemTest.getJSONObject("YrRedeemTest").getString("expectedCoins");
        String nickName = YrRedeemTest.getJSONObject("YrRedeemTest").getString("nickName");
        String portNumber = YrRedeemTest.getJSONObject("YrRedeemTest").getString("portNumber");
        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.KEYCODE_VOLUME_DOWN(getDriver1());
        landingPage1.changingPort(portNumber, getDriver1());
        landingPage2.handlingUpdatePopup(getDriver2());
        landingPage2.KEYCODE_VOLUME_DOWN(getDriver2());
        landingPage2.changingPort(portNumber, getDriver2());
        int i = getRandomNum();
        String phonNum = partialNum + Integer.toString(i);
        landingPage1.clickOnLetsGoButton(getDriver1());
        landingPage1.enterMobileNumber(phonNum, getDriver1());
        landingPage1.clickOnGetOTPButton(getDriver1());
        landingPage1.enterOTPNumber(otp, getDriver1());
        landingPage1.clickOnSubmitButton(getDriver1());
        landingPage1.enterNickName(getDriver1(), nickName);
        landingPage1.clickOnSelectGenderButton(getDriver1());
        landingPage1.clickOnBoyGender(getDriver1());
        landingPage1.clickOnDateOfBirthButtonAndOkButton(getDriver1());
        landingPage1.clickOnSignInSubmitButton(getDriver1());
        landingPage1.selectLanguage(getDriver1());
        landingPage1.checkCyberManifestoPolicies(getDriver1());
        landingPage1.selectAppLanguage(getDriver1());
        homePage1.handlingPopup(getDriver1());
        landingPage2.handlingUpdatePopup(getDriver2());
        landingPage2.loginToApplication(phoneNumber, otp, getDriver2());
        homePage1.clickOnTrainingTab(getDriver1());
        homePage2.handlingPopup(getDriver2());
        String text = homePage2.getAvailableCoin(getDriver2());
        homePage2.clickOnTrainingTab(getDriver2());
        trainingRoomPage1.clickOnPlusIcon(getDriver1());
        trainingRoomPage1.clickOnCreateRoomIcon(getDriver1());
        trainingRoomPage1.clickOnAudioRoomButton(getDriver1());
        tagScreenPage1.clickOnLoveTag(getDriver1());
        tagScreenPage1.verifyUerAbleToHost(getDriver1());
        trainingRoomPage2.checkCoinAndEnterRoom(text, expectedCoins, getDriver2());
        vivoCallPage1.clickOnGameIcon(getDriver1());
        vivoCallPage1.clickOnGamePopupCrossButton(getDriver1());
        vivoCallPage2.clickOnGameIcon(getDriver2());
        vivoCallPage2.clickOnGamePopupCrossButton(getDriver2());
        Thread.sleep(185000);
        vivoCallPage2.clickOnExitButton1(getDriver2());
        vivoCallPage1.verifyYrCreditShownToHost(getDriver1(), 100, 4);
    }

    @Test(priority = 3, enabled = false)
    public void verifyThatUserEndShouldBeDeductTheYRAutomaticallyPerMinuteAsRequiredInVoiceCallRoom() throws InterruptedException {
        String phoneNumber = YrRedeemTest.getJSONObject("YrRedeemTest").getString("phoneNumberDev1");
        String otp = YrRedeemTest.getJSONObject("YrRedeemTest").getString("otp");
        String partialNum = YrRedeemTest.getJSONObject("YrRedeemTest").getString("partialPhNo");
        String expectedCoins = YrRedeemTest.getJSONObject("YrRedeemTest").getString("expectedCoins");
        String nickName = YrRedeemTest.getJSONObject("YrRedeemTest").getString("nickName");
        String portNumber = YrRedeemTest.getJSONObject("YrRedeemTest").getString("portNumber");
        String baseUri = YrRedeemTest.getJSONObject("YrRedeemTest").getString("baseUri");
        String endPointFG = YrRedeemTest.getJSONObject("YrRedeemTest").getString("endPointFG");
        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.KEYCODE_VOLUME_DOWN(getDriver1());
        landingPage1.changingPort(portNumber, getDriver1());
        landingPage2.handlingUpdatePopup(getDriver2());
        landingPage2.KEYCODE_VOLUME_DOWN(getDriver2());
        landingPage2.changingPort(portNumber, getDriver2());
        int i = getRandomNum();
        String phonNum = partialNum + Integer.toString(i);
        landingPage1.clickOnLetsGoButton(getDriver1());
        landingPage1.enterMobileNumber(phonNum, getDriver1());
        landingPage1.clickOnGetOTPButton(getDriver1());
        landingPage1.enterOTPNumber(otp, getDriver1());
        landingPage1.clickOnSubmitButton(getDriver1());
        landingPage1.enterNickName(getDriver1(), nickName);
        landingPage1.clickOnSelectGenderButton(getDriver1());
        landingPage1.clickOnBoyGender(getDriver1());
        landingPage1.clickOnDateOfBirthButtonAndOkButton(getDriver1());
        landingPage1.clickOnSignInSubmitButton(getDriver1());
        landingPage1.selectLanguage(getDriver1());
        landingPage1.checkCyberManifestoPolicies(getDriver1());
        landingPage1.selectAppLanguage(getDriver1());
        homePage1.handlingPopup(getDriver1());
        landingPage2.handlingUpdatePopup(getDriver2());
        landingPage2.loginToApplication(phoneNumber, otp, getDriver2());
        String id = fetchValue.fetchValue(phonNum);
        apiUdateData.videoCallApi(id,true,baseUri,endPointFG,phonNum);
        homePage1.clickOnTrainingTab(getDriver1());
        homePage2.handlingPopup(getDriver2());
        String text = homePage2.getAvailableCoin(getDriver2());
        homePage2.clickOnTrainingTab(getDriver2());
        trainingRoomPage1.clickOnProfileIcon(getDriver1());
        int yRCountAvailable = profilePage1.getTheYellowRoseCount(getDriver1());
        trainingRoomPage1.clickOnPlusIcon(getDriver1());
        trainingRoomPage1.clickOnCreateRoomIcon(getDriver1());
        trainingRoomPage1.clickOnAudioRoomButton(getDriver1());
        tagScreenPage1.clickOnLoveTag(getDriver1());
        tagScreenPage1.verifyUerAbleToHost(getDriver1());
        trainingRoomPage2.checkCoinAndEnterRoom(text, expectedCoins, getDriver2());
        vivoCallPage1.clickOnGameIcon(getDriver1());
        vivoCallPage1.clickOnGamePopupCrossButton(getDriver1());
        vivoCallPage2.clickOnGameIcon(getDriver2());
        vivoCallPage2.clickOnGamePopupCrossButton(getDriver2());
        Thread.sleep(125000);
        vivoCallPage1.clickOnExitButton1(getDriver1());
        String totalGiftedRose = vivoCallPage2.getTotalRosesGifted(getDriver2());
        vivoCallPage2.verifyUserEndDeductYRAutomatically(getDriver2(), 060, 3);
        trainingRoomPage1.clickOnProfileIcon(getDriver1());
        profilePage1.verifyYrTransactionOpenAndCloseBalance(getDriver1(), yRCountAvailable, totalGiftedRose);
        clickBackButton(getDriver1());
        trainingRoomPage1.clickOnPlusIcon(getDriver1());
        trainingRoomPage1.clickOnCreateRoomIcon(getDriver1());
        trainingRoomPage1.clickOnVideoRoomButton(getDriver1());
        tagScreenPage1.clickOnLoveTag(getDriver1());
        tagScreenPage1.verifyUerAbleToHost(getDriver1());
        vivoCallPage2.clickOnStarRating(getDriver2());
        vivoCallPage2.clickOnskipCrossButton(getDriver2());
        Thread.sleep(2000);
        swipeScreen(Direction.DOWN,getDriver2());
        trainingRoomPage2.checkCoinAndEnterRoom(text, expectedCoins, getDriver2());
        trainingRoomPage1.clickOnIAgreeButton(getDriver1());
        vivoCallPage2.clickOnGameIcon(getDriver2());
        vivoCallPage2.clickOnGamePopupCrossButton(getDriver2());
        vivoCallPage1.clickOnGameIcon(getDriver1());
        vivoCallPage1.clickOnGamePopupCrossButton(getDriver1());
        Thread.sleep(85000);
        hostedVideoCallPage1.clickOnExitButton1(getDriver1());
        vivoCallPage2.verifyUserEndDeductYRAutomatically1(getDriver2(), 060, 10);
    }
    @Test(priority = 4, enabled = false)
    public void verifyThatUserEndShouldBeDeductTheYRAutomaticallyPerMinuteAsRequiredInVideoCallRoom() throws InterruptedException {
        String phoneNumber = YrRedeemTest.getJSONObject("YrRedeemTest").getString("phoneNumberDev1");
        String otp = YrRedeemTest.getJSONObject("YrRedeemTest").getString("otp");
        String partialNum = YrRedeemTest.getJSONObject("YrRedeemTest").getString("partialPhNo");
        String expectedCoins = YrRedeemTest.getJSONObject("YrRedeemTest").getString("expectedCoins");
        String nickName = YrRedeemTest.getJSONObject("YrRedeemTest").getString("nickName");
        String portNumber = YrRedeemTest.getJSONObject("YrRedeemTest").getString("portNumber");
        String baseUri = YrRedeemTest.getJSONObject("YrRedeemTest").getString("baseUri");
        String endPointFG = YrRedeemTest.getJSONObject("YrRedeemTest").getString("endPointFG");
        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.KEYCODE_VOLUME_DOWN(getDriver1());
        landingPage1.changingPort(portNumber, getDriver1());
        landingPage2.handlingUpdatePopup(getDriver2());
        landingPage2.KEYCODE_VOLUME_DOWN(getDriver2());
        landingPage2.changingPort(portNumber, getDriver2());
        int i = getRandomNum();
        String phonNum = partialNum + Integer.toString(i);
        landingPage1.clickOnLetsGoButton(getDriver1());
        landingPage1.enterMobileNumber(phonNum, getDriver1());
        landingPage1.clickOnGetOTPButton(getDriver1());
        landingPage1.enterOTPNumber(otp, getDriver1());
        landingPage1.clickOnSubmitButton(getDriver1());
        landingPage1.enterNickName(getDriver1(), nickName);
        landingPage1.clickOnSelectGenderButton(getDriver1());
        landingPage1.clickOnBoyGender(getDriver1());
        landingPage1.clickOnDateOfBirthButtonAndOkButton(getDriver1());
        landingPage1.clickOnSignInSubmitButton(getDriver1());
        landingPage1.selectLanguage(getDriver1());
        landingPage1.checkCyberManifestoPolicies(getDriver1());
        landingPage1.selectAppLanguage(getDriver1());
        homePage1.handlingPopup(getDriver1());
        landingPage2.handlingUpdatePopup(getDriver2());
        landingPage2.loginToApplication(phoneNumber, otp, getDriver2());
        homePage1.clickOnTrainingTab(getDriver1());
        homePage2.handlingPopup(getDriver2());
        String id = fetchValue.fetchValue(phoneNumber);
        apiUdateData.videoCallApi(id,true,baseUri,endPointFG,phoneNumber);
        String text = homePage2.getAvailableCoin(getDriver2());
        homePage2.clickOnTrainingTab(getDriver2());
        trainingRoomPage1.clickOnPlusIcon(getDriver1());
        trainingRoomPage1.clickOnCreateRoomIcon(getDriver1());
        trainingRoomPage1.clickOnVideoRoomButton(getDriver1());
        tagScreenPage1.clickOnLoveTag(getDriver1());
        tagScreenPage1.verifyUerAbleToHost(getDriver1());
        trainingRoomPage2.checkCoinAndEnterRoom(text, expectedCoins, getDriver2());
        trainingRoomPage1.clickOnIAgreeButton(getDriver1());
        Thread.sleep(125000);
        hostedVideoCallPage1.clickOnExitButton1(getDriver1());
        vivoCallPage2.verifyUserEndDeductYRAutomatically1(getDriver2(), 060, 12);
    }

    @Test(priority = 5, enabled = true)
    public void verifyThatUserShouldBeAbleToAllowTheYRRedeemFor1stTimeWhenUserhaveLessThan5YR() throws InterruptedException {
        String otp = YrRedeemTest.getJSONObject("YrRedeemTest").getString("otp");
        String phoneNumber1 = YrRedeemTest.getJSONObject("YrRedeemTest").getString("phoneNumberDev2");
        String partialNum = YrRedeemTest.getJSONObject("YrRedeemTest").getString("partialPhNo");
        String expectedCoins = YrRedeemTest.getJSONObject("YrRedeemTest").getString("expectedCoins");
        String nickName = YrRedeemTest.getJSONObject("YrRedeemTest").getString("nickName");
        String portNumber = YrRedeemTest.getJSONObject("YrRedeemTest").getString("portNumber");
        String phoneNumber4 = YrRedeemTest.getJSONObject("YrRedeemTest").getString("phoneNumber4");
        String baseUri = YrRedeemTest.getJSONObject("YrRedeemTest").getString("baseUri");
        String endPointFG = YrRedeemTest.getJSONObject("YrRedeemTest").getString("endPointFG");
        String upiId1 = YrRedeemTest.getJSONObject("YrRedeemTest").getString("upiId1");
        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.KEYCODE_VOLUME_DOWN(getDriver1());
        landingPage1.changingPort(portNumber, getDriver1());
        int i = getRandomNum();
        phonNum = partialNum + Integer.toString(i);
        landingPage1.clickOnLetsGoButton(getDriver1());
        landingPage1.enterMobileNumber(phonNum, getDriver1());
        landingPage1.clickOnGetOTPButton(getDriver1());
        landingPage1.enterOTPNumber(otp, getDriver1());
        landingPage1.clickOnSubmitButton(getDriver1());
        landingPage1.enterNickName(getDriver1(), nickName);
        landingPage1.clickOnSelectGenderButton(getDriver1());
        landingPage1.clickOnBoyGender(getDriver1());
        landingPage1.clickOnDateOfBirthButtonAndOkButton(getDriver1());
        landingPage1.clickOnSignInSubmitButton(getDriver1());
        landingPage1.selectLanguage(getDriver1());
        landingPage1.checkCyberManifestoPolicies(getDriver1());
        landingPage1.selectAppLanguage(getDriver1());
        homePage1.handlingPopup(getDriver1());
        landingPage2.handlingUpdatePopup(getDriver2());
        landingPage2.KEYCODE_VOLUME_DOWN(getDriver2());
        landingPage2.changingPort(portNumber, getDriver2());
        landingPage2.loginToApplication(phoneNumber1, otp, getDriver2());
        homePage2.handlingPopup(getDriver2());
        String text = homePage2.getAvailableCoin(getDriver2());
        String id1 = fetchValue.fetchValue(phonNum);
        apiUdateData.videoCallApi(id1,true,baseUri,endPointFG,phonNum);
        homePage2.clickOnTrainingTab(getDriver2());
        homePage1.clickOnTrainingTab(getDriver1());
        trainingRoomPage1.clickOnPlusIcon(getDriver1());
        trainingRoomPage1.clickOnCreateRoomIcon(getDriver1());
        trainingRoomPage1.clickOnAudioRoomButton(getDriver1());
        tagScreenPage1.clickOnLoveTag(getDriver1());
        tagScreenPage1.verifyUerAbleToHost(getDriver1());
        trainingRoomPage2.checkCoinAndEnterRoom(text, expectedCoins, getDriver2());
        vivoCallPage2.clickOnGameIcon(getDriver2());
        vivoCallPage2.clickOnGamePopupCrossButton(getDriver2());
        vivoCallPage1.clickOnGameIcon(getDriver1());
        vivoCallPage1.clickOnGamePopupCrossButton(getDriver1());
      //  vivoCallPage1.requestForGiftFor2Roses(getDriver2());
      //  vivoCallPage2.userSendGiftToHost(getDriver2());
        Thread.sleep(125000);
        vivoCallPage1.clickOnExitButton(getDriver1());
        trainingRoomPage1.clickOnProfileIcon(getDriver1());
        profilePage1.clikcOnWinMoneyButton(getDriver1());
        profilePage1.allowYRRedeemIfYRLessThan5Yr1stTime(getDriver1(), 5,phoneNumber4,upiId1);
        profilePage1.verifyMin5RoseRequiredForRedeemForTheSecondTime(getDriver1());
        profilePage1.verifyUserNotWithdrawIfAmountLessThan50(getDriver1());

    }

    @Test(priority = 7, enabled = false)
    public void verifyTheUserShouldBeAllowToYrRedeemSecondTimeWithSufiicientRequiredYrMoreThan5() throws InterruptedException {
        String phoneNumber = YrRedeemTest.getJSONObject("YrRedeemTest").getString("phoneNumberDev1");
        String otp = YrRedeemTest.getJSONObject("YrRedeemTest").getString("otp");
        String expectedCoins = YrRedeemTest.getJSONObject("YrRedeemTest").getString("expectedCoins");
        String portNumber = YrRedeemTest.getJSONObject("YrRedeemTest").getString("portNumber");
        String phoneNumber4 = YrRedeemTest.getJSONObject("YrRedeemTest").getString("phoneNumber4");
        String phoneNumber5 = YrRedeemTest.getJSONObject("YrRedeemTest").getString("phoneNumber5");
        String baseUri = YrRedeemTest.getJSONObject("YrRedeemTest").getString("baseUri");
        String endPointFG = YrRedeemTest.getJSONObject("YrRedeemTest").getString("endPointFG");
        String upiId1 = YrRedeemTest.getJSONObject("YrRedeemTest").getString("upiId1");
        landingPage2.handlingUpdatePopup(getDriver2());
        landingPage2.KEYCODE_VOLUME_DOWN(getDriver2());
        landingPage2.changingPort(portNumber, getDriver2());
        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.KEYCODE_VOLUME_DOWN(getDriver1());
        landingPage1.changingPort(portNumber, getDriver1());
        landingPage2.loginToApplication(phoneNumber, otp, getDriver2());
        landingPage1.loginToApplication(phoneNumber4, otp, getDriver1());
        String id1 = fetchValue.fetchValue(phoneNumber4);
        apiUdateData.videoCallApi(id1,true,baseUri,endPointFG,phoneNumber4);
        homePage2.handlingPopup(getDriver2());
        homePage1.handlingPopup(getDriver1());
        String text = homePage2.getAvailableCoin(getDriver2());
        homePage1.clickOnTrainingTab(getDriver1());
        homePage2.clickOnTrainingTab(getDriver2());
        trainingRoomPage1.clickOnPlusIcon(getDriver1());
        trainingRoomPage1.clickOnCreateRoomIcon(getDriver1());
        trainingRoomPage1.clickOnVideoRoomButton(getDriver1());
        tagScreenPage1.clickOnLoveTag(getDriver1());
        tagScreenPage1.verifyUerAbleToHost(getDriver1());
        trainingRoomPage2.checkCoinAndEnterRoom(text, expectedCoins, getDriver2());
      //  vivoCallPage1.requestForGiftFor10Roses(getDriver1());
      //  vivoCallPage2.userSendGiftToHost(getDriver2());
        vivoCallPage1.clickOnGameIcon(getDriver1());
        vivoCallPage1.clickOnGamePopupCrossButton(getDriver1());
        Thread.sleep(85000);
        vivoCallPage1.clickOnExitButton(getDriver1());
        trainingRoomPage1.clickOnProfileIcon(getDriver1());
        profilePage1.clikcOnWinMoneyButton(getDriver1());
        profilePage1.allowYrRedeemIfYrMoreThan5Yr(getDriver1(), 5,phoneNumber5,upiId1);
        profilePage1.verifyUserAllowLimitedGivenTransaction(getDriver1());
    }

    @Test(priority = 9, enabled = false)
    public void verifyThatYrTranscationOpenAndCloseBalanceShouldBeWorkAsExpected() throws InterruptedException {
        String phoneNumber = YrRedeemTest.getJSONObject("YrRedeemTest").getString("phoneNumberDev1");
        String otp = YrRedeemTest.getJSONObject("YrRedeemTest").getString("otp");
        String phoneNumber1 = YrRedeemTest.getJSONObject("YrRedeemTest").getString("phoneNumberDev2");
        String partialNum = YrRedeemTest.getJSONObject("YrRedeemTest").getString("partialPhNo");
        String expectedCoins = YrRedeemTest.getJSONObject("YrRedeemTest").getString("expectedCoins");
        String nickName = YrRedeemTest.getJSONObject("YrRedeemTest").getString("nickName");
        String portNumber = YrRedeemTest.getJSONObject("YrRedeemTest").getString("portNumber");
        landingPage2.handlingUpdatePopup(getDriver2());
        landingPage2.KEYCODE_VOLUME_DOWN(getDriver2());
        landingPage2.changingPort(portNumber, getDriver2());
        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.KEYCODE_VOLUME_DOWN(getDriver1());
        landingPage1.changingPort(portNumber, getDriver1());
        landingPage2.loginToApplication(phoneNumber, otp, getDriver2());
        landingPage1.loginToApplication(phoneNumber1, otp, getDriver1());
        homePage2.handlingPopup(getDriver2());
        homePage1.handlingPopup(getDriver1());
        String text = homePage2.getAvailableCoin(getDriver2());
        homePage1.clickOnTrainingTab(getDriver1());
        homePage2.clickOnTrainingTab(getDriver2());
        trainingRoomPage1.clickOnProfileIcon(getDriver1());
        int yRCountAvailable = profilePage1.getTheYellowRoseCount(getDriver1());
        trainingRoomPage1.clickOnPlusIcon(getDriver1());
        trainingRoomPage1.clickOnCreateRoomIcon(getDriver1());
        trainingRoomPage1.clickOnAudioRoomButton(getDriver1());
        tagScreenPage1.clickOnLoveTag(getDriver1());
        tagScreenPage1.verifyUerAbleToHost(getDriver1());
        trainingRoomPage2.checkCoinAndEnterRoom(text, expectedCoins, getDriver2());
        Thread.sleep(130000);
        vivoCallPage1.clickOnExitButton(getDriver1());
        String totalGiftedRose = vivoCallPage2.getTotalRosesGifted(getDriver2());
        trainingRoomPage1.clickOnProfileIcon(getDriver1());
        profilePage1.verifyYrTransactionOpenAndCloseBalance(getDriver1(), yRCountAvailable, totalGiftedRose);
    }

    @Test(priority = 10, enabled = false)
    public void verifyTheShouldNotAllowRegisterTheSameUPIIDMoreThanTwoUsers() throws InterruptedException {
        String otp = YrRedeemTest.getJSONObject("YrRedeemTest").getString("otp");
        String portNumber = YrRedeemTest.getJSONObject("YrRedeemTest").getString("portNumber");
        String phoneNumber6 = YrRedeemTest.getJSONObject("YrRedeemTest").getString("phoneNumber6");
        String baseUri = YrRedeemTest.getJSONObject("YrRedeemTest").getString("baseUri");
        String endPointWallet = YrRedeemTest.getJSONObject("YrRedeemTest").getString("endPointWallet");
        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.KEYCODE_VOLUME_DOWN(getDriver1());
        landingPage1.changingPort(portNumber, getDriver1());
        landingPage1.loginToApplication(phoneNumber6, otp, getDriver1());
        homePage1.handlingPopup(getDriver1());
        String id = fetchValue.fetchValue(phoneNumber6);
        apiUdateData.updateUserWallet(id,baseUri,endPointWallet,phoneNumber6);
        homePage1.clickOnTrainingTab(getDriver1());
        trainingRoomPage1.clickOnProfileIcon(getDriver1());
        profilePage1.clickOnWalletMoney(getDriver1());
        profilePage1.verifyUpiIdInUseByOtherUser(getDriver1());
    }

    @Test(priority = 11,enabled = false)
    public void verifyThatTDSShouldBeDeductOnePercentWhichUserIsDoneKYCVerified() throws InterruptedException {
        String otp = YrRedeemTest.getJSONObject("YrRedeemTest").getString("otp");
        String portNumber = YrRedeemTest.getJSONObject("YrRedeemTest").getString("portNumber");
        String phoneNumber7 = YrRedeemTest.getJSONObject("YrRedeemTest").getString("phoneNumber7");
        String baseUri = YrRedeemTest.getJSONObject("YrRedeemTest").getString("baseUri");
        String endPointFG = YrRedeemTest.getJSONObject("YrRedeemTest").getString("endPointFG");
        String upiId2 = YrRedeemTest.getJSONObject("YrRedeemTest").getString("upiId2");
        String endPointWallet = YrRedeemTest.getJSONObject("YrRedeemTest").getString("endPointWallet");
        String panName = YrRedeemTest.getJSONObject("YrRedeemTest").getString("panName");
        String panNumber = YrRedeemTest.getJSONObject("YrRedeemTest").getString("panNumber");
        String fixedWithDrawAmount = YrRedeemTest.getJSONObject("YrRedeemTest").getString("fixedWithDrawAmount");
        landingPage2.handlingUpdatePopup(getDriver2());
        landingPage2.KEYCODE_VOLUME_DOWN(getDriver2());
        landingPage2.changingPort(portNumber, getDriver2());
        landingPage2.loginToApplication(phoneNumber7, otp, getDriver2());
        homePage2.handlingPopup(getDriver2());
        String id = fetchValue.fetchValue(phoneNumber7);
        apiUdateData.updateUserWallet(id,baseUri,endPointWallet,phoneNumber7);
        homePage2.clickOnTrainingTab(getDriver2());
        apiUdateData.udateDataForKyc(id,true,baseUri,endPointFG,phoneNumber7);
        trainingRoomPage2.clickOnProfileIcon(getDriver2());
        profilePage2.verifyWalletMoneyMoreThan100(getDriver2());
        int remainingWithDrawAmount = profilePage2.getTotalRemainingAmount(getDriver2());
        profilePage2.checkKycVerified(getDriver2(),panName,panNumber);
        profilePage2.enterUpiIdValue(getDriver2(),upiId2);
        profilePage2.checkOnePercentTdsLabel(getDriver2());
        profilePage2.verifyTdsAmountDeduction(getDriver2(),fixedWithDrawAmount);
       // profilePage2.verifyWithDrawSuccessful(getDriver2(),remainingWithDrawAmount);
    }

    @Test(priority = 12, enabled = true)
    public void VvrifyThatTDSShouldBeDeduct5PercentWhichUserIsNotDoneKYCVerified() throws InterruptedException {
        String otp = YrRedeemTest.getJSONObject("YrRedeemTest").getString("otp");
        String portNumber = YrRedeemTest.getJSONObject("YrRedeemTest").getString("portNumber");
        String phoneNumber8 = YrRedeemTest.getJSONObject("YrRedeemTest").getString("phoneNumber8");
        String baseUri = YrRedeemTest.getJSONObject("YrRedeemTest").getString("baseUri");
        String endPointFG = YrRedeemTest.getJSONObject("YrRedeemTest").getString("endPointFG");
        String upiId2 = YrRedeemTest.getJSONObject("YrRedeemTest").getString("upiId2");
        String endPointWallet = YrRedeemTest.getJSONObject("YrRedeemTest").getString("endPointWallet");
        String fixedWithDrawAmount = YrRedeemTest.getJSONObject("YrRedeemTest").getString("fixedWithDrawAmount");
        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.KEYCODE_VOLUME_DOWN(getDriver1());
        landingPage1.changingPort(portNumber, getDriver1());
        landingPage1.loginToApplication(phoneNumber8, otp, getDriver1());
        homePage1.handlingPopup(getDriver1());
        String id = fetchValue.fetchValue(phoneNumber8);
        apiUdateData.updateUserWallet(id,baseUri,endPointWallet,phoneNumber8);
        homePage1.clickOnTrainingTab(getDriver1());
        apiUdateData.updateDataForTds(id,true,baseUri,endPointFG,phoneNumber8);
        trainingRoomPage1.clickOnProfileIcon(getDriver1());
        profilePage1.clickOnWalletMoney(getDriver1());
        profilePage1.enterUpiIdValue(getDriver1(),upiId2);
        profilePage1.checkFivePercentTdsLabel(getDriver1());
        profilePage1.verifyTdsAmountDeduction(getDriver1(),fixedWithDrawAmount);
    }

    @Test(priority =  13, enabled = false)
    public void verifyTheUserShouldNotAllowKYCVerificationMoreThanTwoUsersWithSamePANDetails() throws InterruptedException {
        String otp = YrRedeemTest.getJSONObject("YrRedeemTest").getString("otp");
        String portNumber = YrRedeemTest.getJSONObject("YrRedeemTest").getString("portNumber");
        String phoneNumber9 = YrRedeemTest.getJSONObject("YrRedeemTest").getString("phoneNumber9");
        String baseUri = YrRedeemTest.getJSONObject("YrRedeemTest").getString("baseUri");
        String endPointFG = YrRedeemTest.getJSONObject("YrRedeemTest").getString("endPointFG");
        String endPointWallet = YrRedeemTest.getJSONObject("YrRedeemTest").getString("endPointWallet");
        String panName = YrRedeemTest.getJSONObject("YrRedeemTest").getString("panName");
        String panNumber = YrRedeemTest.getJSONObject("YrRedeemTest").getString("panNumber");
        landingPage2.handlingUpdatePopup(getDriver2());
        landingPage2.KEYCODE_VOLUME_DOWN(getDriver2());
        landingPage2.changingPort(portNumber, getDriver2());
        landingPage2.loginToApplication(phoneNumber9, otp, getDriver2());
        homePage2.handlingPopup(getDriver2());
        String id = fetchValue.fetchValue(phoneNumber9);
        apiUdateData.updateUserWallet(id,baseUri,endPointWallet,phoneNumber9);
        homePage2.clickOnTrainingTab(getDriver2());
        apiUdateData.udateDataForKyc(id,true,baseUri,endPointFG,phoneNumber9);
        trainingRoomPage2.clickOnProfileIcon(getDriver2());
        profilePage2.verifyWalletMoneyMoreThan100(getDriver2());
        int remainingWithDrawAmount = profilePage2.getTotalRemainingAmount(getDriver2());
        profilePage2.checkKycVerified(getDriver2(),panName,panNumber);

    }

    @Test(priority =  14, enabled = false)
    public void verifyTheUserShouldNotAllowKYCVerificationMoreThanTwoUsersWithSamePANDetails1() throws InterruptedException {
        String otp = YrRedeemTest.getJSONObject("YrRedeemTest").getString("otp");
        String portNumber = YrRedeemTest.getJSONObject("YrRedeemTest").getString("portNumber");
        String phoneNumber10 = YrRedeemTest.getJSONObject("YrRedeemTest").getString("phoneNumber10");
        String baseUri = YrRedeemTest.getJSONObject("YrRedeemTest").getString("baseUri");
        String endPointFG = YrRedeemTest.getJSONObject("YrRedeemTest").getString("endPointFG");
        String endPointWallet = YrRedeemTest.getJSONObject("YrRedeemTest").getString("endPointWallet");
        String panName = YrRedeemTest.getJSONObject("YrRedeemTest").getString("panName");
        String panNumber = YrRedeemTest.getJSONObject("YrRedeemTest").getString("panNumber");
        landingPage2.handlingUpdatePopup(getDriver2());
        landingPage2.KEYCODE_VOLUME_DOWN(getDriver2());
        landingPage2.changingPort(portNumber, getDriver2());
        landingPage2.loginToApplication(phoneNumber10, otp, getDriver2());
        homePage2.handlingPopup(getDriver2());
        String id = fetchValue.fetchValue(phoneNumber10);
        apiUdateData.updateUserWallet(id,baseUri,endPointWallet,phoneNumber10);
        homePage2.clickOnTrainingTab(getDriver2());
        apiUdateData.udateDataForKyc(id,true,baseUri,endPointFG,phoneNumber10);
        trainingRoomPage2.clickOnProfileIcon(getDriver2());
        profilePage2.verifyWalletMoneyMoreThan100(getDriver2());
        profilePage2.verifyPanNotAllowedToUse(getDriver2(),panName,panNumber);
    }
}
