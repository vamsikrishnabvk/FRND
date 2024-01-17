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
//        getDriver().activateApp("com.dating.for.all");
    }
    @Test(priority = 0, enabled = true)
    public void verifyThatHostAbleToReceiveTheAutoYRInAudioGames() throws InterruptedException {
        String phoneNumber = YrRedeemTest.getJSONObject("YrRedeemTest").getString("phoneNumberDev1");
        String otp = YrRedeemTest.getJSONObject("YrRedeemTest").getString("otp");
        String phoneNumber1 = YrRedeemTest.getJSONObject("YrRedeemTest").getString("phoneNumberDev2");
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
        Thread.sleep(125000);
        vivoCallPage1.clickOnExitButton(getDriver1());
        trainingRoomPage1.clickOnProfileIcon(getDriver1());
        profilePage1.clikcOnWinMoneyButton(getDriver1());
        profilePage1.checkRedeemSuccessMessageVisibility(getDriver1());
        profilePage1.verifyYrRedeemSuccess(getDriver1());
    }

    @Test(priority = 1, enabled = true)
    public void verifyThatHostAbleToReceiveTheAutoYRInVideoGames() throws InterruptedException {
        String phoneNumber = YrRedeemTest.getJSONObject("YrRedeemTest").getString("phoneNumberDev1");
        String otp = YrRedeemTest.getJSONObject("YrRedeemTest").getString("otp");
        String phoneNumber1 = YrRedeemTest.getJSONObject("YrRedeemTest").getString("phoneNumberDev2");
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

    @Test(priority = 2, enabled = true)
    public void verifyThatYRCreditedShouldBeShownInCallDurationScreenToHost() throws InterruptedException {
        String phoneNumber = YrRedeemTest.getJSONObject("YrRedeemTest").getString("phoneNumberDev1");
        String otp = YrRedeemTest.getJSONObject("YrRedeemTest").getString("otp");
        String phoneNumber1 = YrRedeemTest.getJSONObject("YrRedeemTest").getString("phoneNumberDev2");
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
        Thread.sleep(185000);
        vivoCallPage1.clickOnExitButton1(getDriver1());
        vivoCallPage2.verifyYrCreditShownToHost(getDriver2(), 100, 3);
    }

    @Test(priority = 3, enabled = true)
    public void verifyThatUserEndShouldBeDeductTheYRAutomaticallyPerMinuteAsRequiredInVoiceCallRoom() throws InterruptedException {
        String phoneNumber = YrRedeemTest.getJSONObject("YrRedeemTest").getString("phoneNumberDev1");
        String otp = YrRedeemTest.getJSONObject("YrRedeemTest").getString("otp");
        String phoneNumber1 = YrRedeemTest.getJSONObject("YrRedeemTest").getString("phoneNumberDev2");
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
        Thread.sleep(125000);
        vivoCallPage2.clickOnExitButton1(getDriver2());
        vivoCallPage2.verifyUserEndDeductYRAutomatically(getDriver2(), 060, 3);
    }
    @Test(priority = 4, enabled = true)
    public void verifyThatUserEndShouldBeDeductTheYRAutomaticallyPerMinuteAsRequiredInVideoCallRoom() throws InterruptedException {
        String phoneNumber = YrRedeemTest.getJSONObject("YrRedeemTest").getString("phoneNumberDev1");
        String otp = YrRedeemTest.getJSONObject("YrRedeemTest").getString("otp");
        String phoneNumber1 = YrRedeemTest.getJSONObject("YrRedeemTest").getString("phoneNumberDev2");
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
        vivoCallPage2.verifyUserEndDeductYRAutomatically1(getDriver2(), 060, 12);
    }

    @Test(priority = 5, enabled = true)
    public void verifyThatUserShouldBeAbleToAllowTheYRRedeemFor1stTimeWhenUserhaveLessThan5YR() throws InterruptedException {
        String phoneNumber = YrRedeemTest.getJSONObject("YrRedeemTest").getString("phoneNumberDev1");
        String otp = YrRedeemTest.getJSONObject("YrRedeemTest").getString("otp");
        String phoneNumber1 = YrRedeemTest.getJSONObject("YrRedeemTest").getString("phoneNumberDev2");
        String partialNum = YrRedeemTest.getJSONObject("YrRedeemTest").getString("partialPhNo");
        String expectedCoins = YrRedeemTest.getJSONObject("YrRedeemTest").getString("expectedCoins");
        String nickName = YrRedeemTest.getJSONObject("YrRedeemTest").getString("nickName");
        String portNumber = YrRedeemTest.getJSONObject("YrRedeemTest").getString("portNumber");
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
        homePage2.clickOnTrainingTab(getDriver2());
        homePage1.clickOnTrainingTab(getDriver1());
        trainingRoomPage1.clickOnPlusIcon(getDriver1());
        trainingRoomPage1.clickOnCreateRoomIcon(getDriver1());
        trainingRoomPage1.clickOnAudioRoomButton(getDriver1());
        tagScreenPage1.clickOnLoveTag(getDriver1());
        tagScreenPage1.verifyUerAbleToHost(getDriver1());
        trainingRoomPage2.checkCoinAndEnterRoom(text, expectedCoins, getDriver2());
      //  vivoCallPage1.requestForGiftFor2Roses(getDriver2());
      //  vivoCallPage2.userSendGiftToHost(getDriver2());
        Thread.sleep(125000);
        vivoCallPage1.clickOnExitButton(getDriver1());
        trainingRoomPage1.clickOnProfileIcon(getDriver1());
        profilePage1.clikcOnWinMoneyButton(getDriver1());
        profilePage1.allowYRRedeemIfYRLessThan5Yr1stTime(getDriver1(), 5);
        profilePage1.verifyMin5RoseRequiredForRedeemForTheSecondTime(getDriver1());
        profilePage1.verifyUserNotWithdrawIfAmountLessThan50(getDriver1());
    }

    @Test(priority = 7, enabled = true)
    public void verifyTheUserShouldBeAllowToYrRedeemSecondTimeWithSufiicientRequiredYrMoreThan5() throws InterruptedException {
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
        landingPage1.loginToApplication("7890123499", otp, getDriver1());
        homePage2.handlingPopup(getDriver2());
        homePage1.handlingPopup(getDriver1());
        String text = homePage2.getAvailableCoin(getDriver2());
        homePage1.clickOnTrainingTab(getDriver1());
        homePage2.clickOnTrainingTab(getDriver2());
        trainingRoomPage1.clickOnPlusIcon(getDriver1());
        trainingRoomPage1.clickOnCreateRoomIcon(getDriver1());
        trainingRoomPage1.clickOnAudioRoomButton(getDriver1());
        tagScreenPage1.clickOnLoveTag(getDriver1());
        tagScreenPage1.verifyUerAbleToHost(getDriver1());
        trainingRoomPage2.checkCoinAndEnterRoom(text, expectedCoins, getDriver2());
      //  vivoCallPage1.requestForGiftFor10Roses(getDriver1());
      //  vivoCallPage2.userSendGiftToHost(getDriver2());
        Thread.sleep(320000);
        vivoCallPage1.clickOnExitButton(getDriver1());
        trainingRoomPage1.clickOnProfileIcon(getDriver1());
        profilePage1.clikcOnWinMoneyButton(getDriver1());
        profilePage1.allowYrRedeemIfYrMoreThan5Yr(getDriver1(), 5);
        profilePage1.verifyUserAllowLimitedGivenTransaction(getDriver1());
    }

    @Test(priority = 9, enabled = true)
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

    @Test(priority = 10, enabled = true)
    public void verifyTheShouldNotAllowRegisterTheSameUPIIDMoreThanTwoUsers() throws InterruptedException {
        String phoneNumber = YrRedeemTest.getJSONObject("YrRedeemTest").getString("phoneNumberDev1");
        String otp = YrRedeemTest.getJSONObject("YrRedeemTest").getString("otp");
        String phoneNumber1 = YrRedeemTest.getJSONObject("YrRedeemTest").getString("phoneNumberDev2");
        String partialNum = YrRedeemTest.getJSONObject("YrRedeemTest").getString("partialPhNo");
        String expectedCoins = YrRedeemTest.getJSONObject("YrRedeemTest").getString("expectedCoins");
        String nickName = YrRedeemTest.getJSONObject("YrRedeemTest").getString("nickName");
        String portNumber = YrRedeemTest.getJSONObject("YrRedeemTest").getString("portNumber");
        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.KEYCODE_VOLUME_DOWN(getDriver1());
        landingPage1.changingPort("QA", getDriver1());
        landingPage1.loginToApplication("7890128542", otp, getDriver1());
        homePage1.handlingPopup(getDriver1());
        String id = fetchValue.fetchValue("7890128542");
        apiUdateData.updateUserWallet(id,"http://qa.frndapp.in:8080","/automatedTesting/updateUserWallet","7890128542");
        homePage1.clickOnTrainingTab(getDriver1());
        trainingRoomPage1.clickOnProfileIcon(getDriver1());
        profilePage1.clickOnWalletMoney(getDriver1());
        profilePage1.verifyUpiIdInUseByOtherUser(getDriver1());
    }

    @Test(priority = 11,enabled = true)
    public void verifyThatTDSShouldBeDeductOnePercentWhichUserIsDoneKYCVerified() throws InterruptedException {
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
        landingPage2.loginToApplication("7890134565", otp, getDriver2());
        homePage2.handlingPopup(getDriver2());
        String id = fetchValue.fetchValue("7890134565");
        apiUdateData.updateUserWallet(id,"http://qa.frndapp.in:8080","/automatedTesting/updateUserWallet","7890134565");
        homePage2.clickOnTrainingTab(getDriver2());
        apiUdateData.udateDataForKyc(id,true,"http://qa.frndapp.in:8080","/automatedTesting/updateFgGroup","7890134565");
        trainingRoomPage2.clickOnProfileIcon(getDriver2());
        profilePage2.verifyWalletMoneyMoreThan100(getDriver2());
        int remainingWithDrawAmount = profilePage2.getTotalRemainingAmount(getDriver2());
        profilePage2.checkKycVerified(getDriver2(),"Zahid Ali Warsi","AFIPW9091E");
        profilePage2.enterUpiIdValue(getDriver2(),"aliwarsizahid@okicici");
        profilePage2.checkOnePercentTdsLabel(getDriver2());
        profilePage2.verifyTdsAmountDeduction(getDriver2(),"9");
       // profilePage2.verifyWithDrawSuccessful(getDriver2(),remainingWithDrawAmount);
    }

    @Test(priority = 12, enabled = true)
    public void VvrifyThatTDSShouldBeDeduct5PercentWhichUserIsNotDoneKYCVerified() throws InterruptedException {
        String phoneNumber = YrRedeemTest.getJSONObject("YrRedeemTest").getString("phoneNumberDev1");
        String otp = YrRedeemTest.getJSONObject("YrRedeemTest").getString("otp");
        String phoneNumber1 = YrRedeemTest.getJSONObject("YrRedeemTest").getString("phoneNumberDev2");
        String partialNum = YrRedeemTest.getJSONObject("YrRedeemTest").getString("partialPhNo");
        String expectedCoins = YrRedeemTest.getJSONObject("YrRedeemTest").getString("expectedCoins");
        String nickName = YrRedeemTest.getJSONObject("YrRedeemTest").getString("nickName");
        String portNumber = YrRedeemTest.getJSONObject("YrRedeemTest").getString("portNumber");
        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.KEYCODE_VOLUME_DOWN(getDriver1());
        landingPage1.changingPort(portNumber, getDriver1());
        landingPage1.loginToApplication("7890134566", otp, getDriver1());
        homePage1.handlingPopup(getDriver1());
        String id = fetchValue.fetchValue("7890134566");
        apiUdateData.updateUserWallet(id,"http://qa.frndapp.in:8080","/automatedTesting/updateUserWallet","7890134566");
        homePage1.clickOnTrainingTab(getDriver1());
        apiUdateData.updateDataForTds(id,true,"http://qa.frndapp.in:8080","/automatedTesting/updateFgGroup","7890134566");
        trainingRoomPage1.clickOnProfileIcon(getDriver1());
        profilePage1.clickOnWalletMoney(getDriver1());
        profilePage1.enterUpiIdValue(getDriver1(),"aliwarsizahid@okicici");
        profilePage1.checkFivePercentTdsLabel(getDriver1());
        profilePage1.verifyTdsAmountDeduction(getDriver1(),"9");
    }

    @Test(priority =  13, enabled = true)
    public void verifyTheUserShouldNotAllowKYCVerificationMoreThanTwoUsersWithSamePANDetails() throws InterruptedException {
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
        landingPage2.loginToApplication("7890134563", otp, getDriver2());
        homePage2.handlingPopup(getDriver2());
        String id = fetchValue.fetchValue("7890134563");
        apiUdateData.updateUserWallet(id,"http://qa.frndapp.in:8080","/automatedTesting/updateUserWallet","7890134563");
        homePage2.clickOnTrainingTab(getDriver2());
        apiUdateData.udateDataForKyc(id,true,"http://qa.frndapp.in:8080","/automatedTesting/updateFgGroup","7890134563");
        trainingRoomPage2.clickOnProfileIcon(getDriver2());
        profilePage2.verifyWalletMoneyMoreThan100(getDriver2());
        int remainingWithDrawAmount = profilePage2.getTotalRemainingAmount(getDriver2());
        profilePage2.checkKycVerified(getDriver2(),"Zahid Ali Warsi","AFIPW9091E");

    }

    @Test(priority =  14, enabled = true)
    public void verifyTheUserShouldNotAllowKYCVerificationMoreThanTwoUsersWithSamePANDetails1() throws InterruptedException {
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
        landingPage2.loginToApplication("7890134564", otp, getDriver2());
        homePage2.handlingPopup(getDriver2());
        String id = fetchValue.fetchValue("7890134564");
        apiUdateData.updateUserWallet(id,"http://qa.frndapp.in:8080","/automatedTesting/updateUserWallet","7890134564");
        homePage2.clickOnTrainingTab(getDriver2());
        apiUdateData.udateDataForKyc(id,true,"http://qa.frndapp.in:8080","/automatedTesting/updateFgGroup","7890134564");
        trainingRoomPage2.clickOnProfileIcon(getDriver2());
        profilePage2.verifyWalletMoneyMoreThan100(getDriver2());
        profilePage2.verifyPanNotAllowedToUse(getDriver2(),"Zahid Ali Warsi","AFIPW9091E");
    }
}
