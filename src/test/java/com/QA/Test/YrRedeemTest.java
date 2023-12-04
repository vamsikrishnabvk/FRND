package com.QA.Test;

import com.QA.Base.BaseTest2;
import com.QA.Pages.*;
import com.QA.utlis.TestUtils;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.*;

import java.io.InputStream;
import java.lang.reflect.Method;

public class YrRedeemTest extends BaseTest2 {

    LandingPage landingPage1,landingPage2;
    HomePage homePage1,homePage2;
    PrivateTrainingRoomPage trainingRoomPage1,trainingRoomPage2;
    SelectTagScreenPage tagScreenPage1,tagScreenPage2;
    HostedAudioCallPage vivoCallPage1,vivoCallPage2;
    JSONObject YrRedeemTest;
    ProfilePage profilePage1,profilePage2;
    FrndCoinPage frndCoinPage1,frndCoinPage2;
    TestUtils utils = new TestUtils();
    PaymentPage paymentPage1, paymentPage2;

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
    }

    @AfterMethod
    public void afterMethod() {
        closeApp(getDriver1());
        closeApp(getDriver2());
        launchApp(getDriver1());
        launchApp(getDriver2());
//        getDriver().activateApp("com.dating.for.all");
    }

    @Test(enabled = false)
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
        landingPage1.changingPort(portNumber,getDriver1());
        landingPage2.handlingUpdatePopup(getDriver2());
        landingPage2.KEYCODE_VOLUME_DOWN(getDriver2());
        landingPage2.changingPort(portNumber,getDriver2());
        int i = getRandomNum();
        String phonNum = partialNum+Integer.toString(i);
        landingPage1.clickOnLetsGoButton(getDriver1());
        landingPage1.enterMobileNumber(phonNum,getDriver1());
        landingPage1.clickOnGetOTPButton(getDriver1());
        landingPage1.enterOTPNumber(otp,getDriver1());
        landingPage1.clickOnSubmitButton(getDriver1());
        landingPage1.enterNickName(getDriver1(),nickName);
        landingPage1.clickOnSelectGenderButton(getDriver1());
        landingPage1.clickOnBoyGender(getDriver1());
        landingPage1.clickOnDateOfBirthButtonAndOkButton(getDriver1());
        landingPage1.clickOnSignInSubmitButton(getDriver1());
        landingPage1.selectLanguage(getDriver1());
        landingPage1.checkCyberManifestoPolicies(getDriver1());
        landingPage1.selectAppLanguage(getDriver1());
        homePage1.handlingPopup(getDriver1());
        landingPage2.handlingUpdatePopup(getDriver2());
        landingPage2.loginToApplication(phoneNumber,otp,getDriver2());
        homePage1.clickOnTrainingTab(getDriver1());
        homePage2.handlingPopup(getDriver2());
        String text = homePage2.getAvailableCoin(getDriver2());
        homePage2.clickOnTrainingTab(getDriver2());
        trainingRoomPage1.clickOnPlusIcon(getDriver1());
        trainingRoomPage1.clickOnCreateRoomIcon(getDriver1());
        trainingRoomPage1.clickOnAudioRoomButton(getDriver1());
        tagScreenPage1.clickOnLoveTag(getDriver1());
        tagScreenPage1.verifyUerAbleToHost(getDriver1());
        trainingRoomPage2.checkCoinAndEnterRoom(text,expectedCoins,getDriver2());
        Thread.sleep(120000);
        vivoCallPage1.clickOnExitButton(getDriver1());
         trainingRoomPage1.clickOnProfileIcon(getDriver1());
        profilePage1.clikcOnWinMoneyButton(getDriver1());
        profilePage1.checkRedeemSuccessMessageVisibility(getDriver1());
        profilePage1.verifyYrRedeemSuccess(getDriver1());
    }

    @Test(enabled = false)
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
        landingPage1.changingPort(portNumber,getDriver1());
        landingPage2.handlingUpdatePopup(getDriver2());
        landingPage2.KEYCODE_VOLUME_DOWN(getDriver2());
        landingPage2.changingPort(portNumber,getDriver2());
        int i = getRandomNum();
        String phonNum = partialNum+Integer.toString(i);
        landingPage1.clickOnLetsGoButton(getDriver1());
        landingPage1.enterMobileNumber(phonNum,getDriver1());
        landingPage1.clickOnGetOTPButton(getDriver1());
        landingPage1.enterOTPNumber(otp,getDriver1());
        landingPage1.clickOnSubmitButton(getDriver1());
        landingPage1.enterNickName(getDriver1(),nickName);
        landingPage1.clickOnSelectGenderButton(getDriver1());
        landingPage1.clickOnBoyGender(getDriver1());
        landingPage1.clickOnDateOfBirthButtonAndOkButton(getDriver1());
        landingPage1.clickOnSignInSubmitButton(getDriver1());
        landingPage1.selectLanguage(getDriver1());
        landingPage1.checkCyberManifestoPolicies(getDriver1());
        landingPage1.selectAppLanguage(getDriver1());
        homePage1.handlingPopup(getDriver1());
        landingPage2.handlingUpdatePopup(getDriver2());
        landingPage2.loginToApplication(phoneNumber,otp,getDriver2());
        homePage1.clickOnTrainingTab(getDriver1());
        homePage2.handlingPopup(getDriver2());
        String text = homePage2.getAvailableCoin(getDriver2());
        homePage2.clickOnTrainingTab(getDriver2());
        trainingRoomPage1.clickOnPlusIcon(getDriver1());
        trainingRoomPage1.clickOnCreateRoomIcon(getDriver1());
        trainingRoomPage1.clickOnAudioRoomButton(getDriver1());
        tagScreenPage1.clickOnLoveTag(getDriver1());
        tagScreenPage1.verifyUerAbleToHost(getDriver1());
        trainingRoomPage2.checkCoinAndEnterRoom(text,expectedCoins,getDriver2());
        Thread.sleep(120000);
        vivoCallPage1.clickOnExitButton1(getDriver1());
        vivoCallPage2.verifyYrCreditShownToHost(getDriver2(),100,3);
    }

    @Test(enabled = false)
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
        landingPage1.changingPort(portNumber,getDriver1());
        landingPage2.handlingUpdatePopup(getDriver2());
        landingPage2.KEYCODE_VOLUME_DOWN(getDriver2());
        landingPage2.changingPort(portNumber,getDriver2());
        int i = getRandomNum();
        String phonNum = partialNum+Integer.toString(i);
        landingPage1.clickOnLetsGoButton(getDriver1());
        landingPage1.enterMobileNumber(phonNum,getDriver1());
        landingPage1.clickOnGetOTPButton(getDriver1());
        landingPage1.enterOTPNumber(otp,getDriver1());
        landingPage1.clickOnSubmitButton(getDriver1());
        landingPage1.enterNickName(getDriver1(),nickName);
        landingPage1.clickOnSelectGenderButton(getDriver1());
        landingPage1.clickOnBoyGender(getDriver1());
        landingPage1.clickOnDateOfBirthButtonAndOkButton(getDriver1());
        landingPage1.clickOnSignInSubmitButton(getDriver1());
        landingPage1.selectLanguage(getDriver1());
        landingPage1.checkCyberManifestoPolicies(getDriver1());
        landingPage1.selectAppLanguage(getDriver1());
        homePage1.handlingPopup(getDriver1());
        landingPage2.handlingUpdatePopup(getDriver2());
        landingPage2.loginToApplication(phoneNumber,otp,getDriver2());
        homePage1.clickOnTrainingTab(getDriver1());
        homePage2.handlingPopup(getDriver2());
        String text = homePage2.getAvailableCoin(getDriver2());
        homePage2.clickOnTrainingTab(getDriver2());
        trainingRoomPage1.clickOnPlusIcon(getDriver1());
        trainingRoomPage1.clickOnCreateRoomIcon(getDriver1());
        trainingRoomPage1.clickOnAudioRoomButton(getDriver1());
        tagScreenPage1.clickOnLoveTag(getDriver1());
        tagScreenPage1.verifyUerAbleToHost(getDriver1());
        trainingRoomPage2.checkCoinAndEnterRoom(text,expectedCoins,getDriver2());
        Thread.sleep(60000);
        vivoCallPage2.clickOnExitButton1(getDriver2());
        vivoCallPage2.verifyUserEndDeductYRAutomatically(getDriver2(),060,2);
    }

    @Test(enabled = false)
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
        landingPage1.changingPort(portNumber,getDriver1());
        int i = getRandomNum();
        String phonNum = partialNum+Integer.toString(i);
        landingPage1.clickOnLetsGoButton(getDriver1());
        landingPage1.enterMobileNumber(phonNum,getDriver1());
        landingPage1.clickOnGetOTPButton(getDriver1());
        landingPage1.enterOTPNumber(otp,getDriver1());
        landingPage1.clickOnSubmitButton(getDriver1());
        landingPage1.enterNickName(getDriver1(),nickName);
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
        landingPage2.changingPort(portNumber,getDriver2());
        landingPage2.loginToApplication(phoneNumber1,otp,getDriver2());
        homePage2.handlingPopup(getDriver2());
        String text = homePage2.getAvailableCoin(getDriver2());
        homePage2.clickOnTrainingTab(getDriver2());
        homePage1.clickOnTrainingTab(getDriver1());
        trainingRoomPage1.clickOnPlusIcon(getDriver1());
        trainingRoomPage1.clickOnCreateRoomIcon(getDriver1());
        trainingRoomPage1.clickOnAudioRoomButton(getDriver1());
        tagScreenPage1.clickOnLoveTag(getDriver1());
        tagScreenPage1.verifyUerAbleToHost(getDriver1());
        trainingRoomPage2.checkCoinAndEnterRoom(text,expectedCoins,getDriver2());
        vivoCallPage1.requestForGiftFor2Roses(getDriver2());
        vivoCallPage2.userSendGiftToHost(getDriver2());
        vivoCallPage1.clickOnExitButton(getDriver1());
        trainingRoomPage1.clickOnProfileIcon(getDriver1());
        profilePage1.clikcOnWinMoneyButton(getDriver1());
        profilePage1.allowYRRedeemIfYRLessThan5Yr1stTime(getDriver1(),5);
        profilePage1.verifyMin5RoseRequiredForRedeemForTheSecondTime(getDriver1());
        profilePage1.verifyUserNotWithdrawIfAmountLessThan50(getDriver1());
    }

    @Test(enabled = false)
    public void verifyThatUserShouldNotAllowToYrRedeemWhenUserTryToYrRedeemSecondTimeWithLessThanEqualTo5Yr() throws InterruptedException {
        String phoneNumber = YrRedeemTest.getJSONObject("YrRedeemTest").getString("phoneNumberDev1");
        String otp = YrRedeemTest.getJSONObject("YrRedeemTest").getString("otp");
        String phoneNumber1 = YrRedeemTest.getJSONObject("YrRedeemTest").getString("phoneNumberDev2");
        String partialNum = YrRedeemTest.getJSONObject("YrRedeemTest").getString("partialPhNo");
        String expectedCoins = YrRedeemTest.getJSONObject("YrRedeemTest").getString("expectedCoins");
        String nickName = YrRedeemTest.getJSONObject("YrRedeemTest").getString("nickName");
        String portNumber = YrRedeemTest.getJSONObject("YrRedeemTest").getString("portNumber");
        landingPage2.handlingUpdatePopup(getDriver2());
        landingPage2.KEYCODE_VOLUME_DOWN(getDriver2());
        landingPage2.changingPort(portNumber,getDriver2());
        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.KEYCODE_VOLUME_DOWN(getDriver1());
        landingPage1.changingPort(portNumber,getDriver1());
        landingPage2.loginToApplication(phoneNumber,otp,getDriver2());
        landingPage1.loginToApplication(phoneNumber1,otp,getDriver1());
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
        trainingRoomPage2.checkCoinAndEnterRoom(text,expectedCoins,getDriver2());
        vivoCallPage1.requestForGiftFor2Roses(getDriver1());
        vivoCallPage2.userSendGiftToHost(getDriver2());
        vivoCallPage1.clickOnExitButton(getDriver1());
        trainingRoomPage1.clickOnProfileIcon(getDriver1());
        profilePage1.verifyMin5RoseRequiredForRedeemForTheSecondTime(getDriver1());
    }

    @Test(enabled = false)
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
        landingPage2.changingPort(portNumber,getDriver2());
        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.KEYCODE_VOLUME_DOWN(getDriver1());
        landingPage1.changingPort(portNumber,getDriver1());
        landingPage2.loginToApplication(phoneNumber,otp,getDriver2());
        landingPage1.loginToApplication(phoneNumber1,otp,getDriver1());
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
        trainingRoomPage2.checkCoinAndEnterRoom(text,expectedCoins,getDriver2());
        vivoCallPage1.requestForGiftFor10Roses(getDriver1());
        vivoCallPage2.userSendGiftToHost(getDriver2());
        vivoCallPage1.clickOnExitButton(getDriver1());
        trainingRoomPage1.clickOnProfileIcon(getDriver1());
        profilePage1.clikcOnWinMoneyButton(getDriver1());
        profilePage1.allowYrRedeemIfYrMoreThan5Yr(getDriver1(),5);
    }

    @Test(enabled = true)
    public void verifyThatUserShouldBeAllowLimitedGivenWithdrawTranscationAndUpiRegisteredMessage() throws InterruptedException {
        String phoneNumber = YrRedeemTest.getJSONObject("YrRedeemTest").getString("phoneNumberDev1");
        String otp = YrRedeemTest.getJSONObject("YrRedeemTest").getString("otp");
        String phoneNumber1 = YrRedeemTest.getJSONObject("YrRedeemTest").getString("phoneNumberDev2");
        String partialNum = YrRedeemTest.getJSONObject("YrRedeemTest").getString("partialPhNo");
        String expectedCoins = YrRedeemTest.getJSONObject("YrRedeemTest").getString("expectedCoins");
        String nickName = YrRedeemTest.getJSONObject("YrRedeemTest").getString("nickName");
        String portNumber = YrRedeemTest.getJSONObject("YrRedeemTest").getString("portNumber");
        landingPage2.handlingUpdatePopup(getDriver2());
        landingPage2.KEYCODE_VOLUME_DOWN(getDriver2());
        landingPage2.changingPort(portNumber,getDriver2());
        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.KEYCODE_VOLUME_DOWN(getDriver1());
        landingPage1.changingPort(portNumber,getDriver1());
        landingPage2.loginToApplication(phoneNumber,otp,getDriver2());
        landingPage1.loginToApplication(phoneNumber1,otp,getDriver1());
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
        trainingRoomPage2.checkCoinAndEnterRoom(text,expectedCoins,getDriver2());
        vivoCallPage1.requestForGiftFor10Roses(getDriver1());
        vivoCallPage2.userSendGiftToHost(getDriver2());
        vivoCallPage1.clickOnExitButton(getDriver1());
        trainingRoomPage1.clickOnProfileIcon(getDriver1());
        profilePage1.clikcOnWinMoneyButton(getDriver1());
        profilePage1.withDrawMoney(getDriver1());
        profilePage1.verifyUserAllowLimitedGivenTransaction(getDriver1());
    }

    @Test(enabled = false)
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
        landingPage2.changingPort(portNumber,getDriver2());
        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.KEYCODE_VOLUME_DOWN(getDriver1());
        landingPage1.changingPort(portNumber,getDriver1());
        landingPage2.loginToApplication(phoneNumber,otp,getDriver2());
        landingPage1.loginToApplication(expectedCoins,otp,getDriver1());
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
        trainingRoomPage2.checkCoinAndEnterRoom(text,expectedCoins,getDriver2());
        Thread.sleep(70000);
        vivoCallPage1.clickOnExitButton(getDriver1());
        String totalGiftedRose = vivoCallPage2.getTotalRosesGifted(getDriver2());
        trainingRoomPage1.clickOnProfileIcon(getDriver1());
        profilePage1.verifyYrTransactionOpenAndCloseBalance(getDriver1(),yRCountAvailable,totalGiftedRose);
    }
}
