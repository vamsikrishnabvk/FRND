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

public class SgnUpTest extends BaseTest {
    LandingPage landingPage1, landingPage2;
    HomePage homePage1, homePage2;
    PrivateTrainingRoomPage trainingRoomPage1, trainingRoomPage2;
    SelectTagScreenPage tagScreenPage1, tagScreenPage2;
    HostedAudioCallPage vivoCallPage1, vivoCallPage2;
    JSONObject SignUpTest;
    ProfilePage profilePage1, profilePage2;

    FrndCoinPage frndCoinPage1, frndCoinPage2;
    ApiUdateData apiUdateData;
    FetchValue fetchValue;
    TestUtils utils = new TestUtils();
    PaymentPage paymentPage1, paymentPage2;

    @BeforeClass
    public void beforeClass() throws Exception {
        InputStream datais = null;
        try {
            String dataFileName = "data/signUpTest.json";
            datais = getClass().getClassLoader().getResourceAsStream(dataFileName);
            JSONTokener tokener = new JSONTokener(datais);
            SignUpTest = new JSONObject(tokener);
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
        apiUdateData = new ApiUdateData();
        fetchValue = new FetchValue();
        paymentPage1 = new PaymentPage(getDriver1());
        paymentPage2 = new PaymentPage(getDriver2());
        frndCoinPage1 = new FrndCoinPage(getDriver1());
        frndCoinPage2 = new FrndCoinPage(getDriver2());
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

    @Test(priority = 0, enabled = true)
    public void verifyMaleSignUp() throws InterruptedException {
        String otp = SignUpTest.getJSONObject("SignUpTest").getString("otp");
        String partialNum = SignUpTest.getJSONObject("SignUpTest").getString("partialPhNo");
        String nickName = SignUpTest.getJSONObject("SignUpTest").getString("nickName");
        String portNumber = SignUpTest.getJSONObject("SignUpTest").getString("portNumber");
        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.KEYCODE_VOLUME_DOWN(getDriver1());
        landingPage1.changingPort(portNumber, getDriver1());
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
    }

    @Test(priority = 1, enabled = true)
    public void verifyMaleRetentionSignUp() throws InterruptedException {
        String phoneNumber = SignUpTest.getJSONObject("SignUpTest").getString("phoneNumberDev1");
        String otp = SignUpTest.getJSONObject("SignUpTest").getString("otp");
        String partialNum = SignUpTest.getJSONObject("SignUpTest").getString("partialPhNo");
        String nickName = SignUpTest.getJSONObject("SignUpTest").getString("nickName");
        String baseUri = SignUpTest.getJSONObject("SignUpTest").getString("baseUri");
        String endPoints = SignUpTest.getJSONObject("SignUpTest").getString("endPoint");
        String portNumber = SignUpTest.getJSONObject("SignUpTest").getString("portNumber");
        landingPage2.handlingUpdatePopup(getDriver2());
        landingPage2.KEYCODE_VOLUME_DOWN(getDriver2());
        landingPage2.changingPort(portNumber, getDriver2());
        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.KEYCODE_VOLUME_DOWN(getDriver1());
        landingPage1.changingPort(portNumber, getDriver1());
        landingPage2.loginToApplication(phoneNumber, otp, getDriver2());
        homePage2.handlingPopup(getDriver2());
        homePage2.clickOnTrainingTab(getDriver2());
        trainingRoomPage2.clickOnPlusIcon(getDriver2());
        trainingRoomPage2.clickOnCreateRoomIcon(getDriver2());
        trainingRoomPage2.clickOnAudioRoomButton(getDriver2());
        tagScreenPage2.clickOnLoveTag(getDriver2());
        tagScreenPage2.verifyUerAbleToHost(getDriver2());
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
        String id = fetchValue.fetchValue(phonNum);
        System.out.println(id);
        apiUdateData.udateData(id, true, baseUri, endPoints, phonNum);
        landingPage1.selectLanguage(getDriver1());
        landingPage1.checkCyberManifestoPolicies(getDriver1());
        landingPage1.selectAppLanguage(getDriver1());
        homePage1.handlingPopup(getDriver1());
        homePage1.checkFreeMinuteAndConnect(getDriver1());
        Thread.sleep(325000);
        vivoCallPage1.verifyUserGotRemovedAferFreeFiveMinuteCall(getDriver1());
        vivoCallPage1.clickOnStarRating(getDriver1());
        vivoCallPage1.clickOnskipCrossButton(getDriver1());
        String availableCoin = homePage1.getAvailableCoin(getDriver1());
        homePage1.clickOnTrainingTab(getDriver1());
        trainingRoomPage1.checkCoinAndEnterRoom(availableCoin, "20", getDriver1());
    }

    @Test(priority = 2, enabled = true)
    public void verifyPaidMaleSignup() throws InterruptedException {
        String phoneNumber = SignUpTest.getJSONObject("SignUpTest").getString("phoneNumberDev1");
        String otp = SignUpTest.getJSONObject("SignUpTest").getString("otp");
        String partialNum = SignUpTest.getJSONObject("SignUpTest").getString("partialPhNo");
        String nickName = SignUpTest.getJSONObject("SignUpTest").getString("nickName");
        String baseUri = SignUpTest.getJSONObject("SignUpTest").getString("baseUri");
        String endPoints = SignUpTest.getJSONObject("SignUpTest").getString("endPoint");
        String portNumber = SignUpTest.getJSONObject("SignUpTest").getString("portNumber");
        landingPage2.handlingUpdatePopup(getDriver2());
        landingPage2.KEYCODE_VOLUME_DOWN(getDriver2());
        landingPage2.changingPort(portNumber, getDriver2());
        landingPage2.loginToApplication(phoneNumber, otp, getDriver2());
        homePage2.handlingPopup(getDriver2());
        homePage2.clickOnTrainingTab(getDriver2());
        trainingRoomPage2.clickOnPlusIcon(getDriver2());
        trainingRoomPage2.clickOnCreateRoomIcon(getDriver2());
        trainingRoomPage2.clickOnAudioRoomButton(getDriver2());
        tagScreenPage2.clickOnLoveTag(getDriver2());
        tagScreenPage2.verifyUerAbleToHost(getDriver2());
        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.KEYCODE_VOLUME_DOWN(getDriver1());
        landingPage1.changingPort(portNumber, getDriver1());
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
        String id = fetchValue.fetchValue(phonNum);
        System.out.println(id);
        apiUdateData.udateData1(id, true, baseUri, endPoints, phonNum);
        landingPage1.selectLanguage(getDriver1());
        landingPage1.checkCyberManifestoPolicies(getDriver1());
        landingPage1.selectAppLanguage(getDriver1());
        homePage1.handlingPopup(getDriver1());
        homePage1.checkFreeMinuteAndConnect(getDriver1());
      //  paymentPage1.clickOnChangePaymentMode(getDriver1());
        homePage1.clickOnMorePackageOption(getDriver1());
        // paymentPage1.selectFrndAppPaymentMethod(getDriver1());
        // paymentPage1.clickOnPhonePayIcon(getDriver1());
        frndCoinPage1.clickOnTwentyCoinPackage(getDriver1());
        paymentPage1.selectFrndAppPaymentMethod(getDriver1());
        paymentPage1.clickOnGooglePayIcon(getDriver1());
        paymentPage1.enterOTPAndMakePayment(getDriver1(), "111000");
        trainingRoomPage1.clickOnAudioRecordAllowPopoup(getDriver1());
        Thread.sleep(439000);
        // vivoCallPage1.verifyUserGotRemovedAferFreeFiveMinuteCall(getDriver1());
        vivoCallPage1.clickOnStarRating(getDriver1());
        vivoCallPage1.clickOnskipCrossButton(getDriver1());
        homePage1.clickOnTrainingTab(getDriver1());
        trainingRoomPage1.clickOnHostedRoomAndJoin(getDriver1());
        trainingRoomPage1.verifyUserNeedToAddCoinsForFurtherCall(getDriver1());
    }

    @Test(priority = 3, enabled = true)
    public void verifyGirlSignUp() throws InterruptedException {
        String otp = SignUpTest.getJSONObject("SignUpTest").getString("otp");
        String partialNum = SignUpTest.getJSONObject("SignUpTest").getString("partialPhNo");
        String nickName2 = SignUpTest.getJSONObject("SignUpTest").getString("nickName1");
        String baseUri = SignUpTest.getJSONObject("SignUpTest").getString("baseUri");
        String portNumber = SignUpTest.getJSONObject("SignUpTest").getString("portNumber");
        String endPointGirlVerified = SignUpTest.getJSONObject("SignUpTest").getString("endPointGirlVerified");
        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.KEYCODE_VOLUME_DOWN(getDriver1());
        landingPage1.changingPort(portNumber, getDriver1());
        int i = getRandomNum();
        String phonNum = partialNum + Integer.toString(i);
        landingPage1.clickOnLetsGoButton(getDriver1());
        landingPage1.enterMobileNumber(phonNum, getDriver1());
        landingPage1.clickOnGetOTPButton(getDriver1());
        landingPage1.enterOTPNumber(otp, getDriver1());
        landingPage1.clickOnSubmitButton(getDriver1());
        landingPage1.enterNickName(getDriver1(), nickName2);
        landingPage1.clickOnSelectGenderButton(getDriver1());
        landingPage1.clickGirlGender(getDriver1());
        landingPage1.clickOnDateOfBirthButtonAndOkButton(getDriver1());
        landingPage1.clickOnSignInSubmitButton(getDriver1());
        landingPage1.selectLanguage(getDriver1());
        String id = fetchValue.fetchValue(phonNum);
        System.out.println(id);
        apiUdateData.updateGirlSignupData(id, baseUri, endPointGirlVerified, phonNum);
        landingPage1.clickOnVoiceRecordButton(getDriver1());
        landingPage1.selectAppLanguage(getDriver1());
    }

    @Test(enabled = true)
    public void verifyTheNon_mr_free_audioTrueCohortUsersShouldBeGetTheFree5MinAfterJoinedInTheVoiceCallWith1stSuccesfullTransction() throws InterruptedException {
        String phoneNumber = SignUpTest.getJSONObject("SignUpTest").getString("phoneNumberDev1");
        String otp = SignUpTest.getJSONObject("SignUpTest").getString("otp");
        String partialNum = SignUpTest.getJSONObject("SignUpTest").getString("partialPhNo");
        String nickName = SignUpTest.getJSONObject("SignUpTest").getString("nickName");
        String baseUri = SignUpTest.getJSONObject("SignUpTest").getString("baseUri");
        String endPoints = SignUpTest.getJSONObject("SignUpTest").getString("endPoint");
        String portNumber = SignUpTest.getJSONObject("SignUpTest").getString("portNumber");
        landingPage2.handlingUpdatePopup(getDriver2());
        landingPage2.KEYCODE_VOLUME_DOWN(getDriver2());
        landingPage2.changingPort(portNumber, getDriver2());
        landingPage2.loginToApplication(phoneNumber, otp, getDriver2());
        homePage2.handlingPopup(getDriver2());
        homePage2.clickOnTrainingTab(getDriver2());
        trainingRoomPage2.clickOnPlusIcon(getDriver2());
        trainingRoomPage2.clickOnCreateRoomIcon(getDriver2());
        trainingRoomPage2.clickOnAudioRoomButton(getDriver2());
        tagScreenPage2.clickOnLoveTag(getDriver2());
        tagScreenPage2.verifyUerAbleToHost(getDriver2());
        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.KEYCODE_VOLUME_DOWN(getDriver1());
        landingPage1.changingPort(portNumber, getDriver1());
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
        String id = fetchValue.fetchValue(phonNum);
        System.out.println(id);
        apiUdateData.noMrFreeAudio(id, true, baseUri, endPoints, phonNum);
        landingPage1.selectLanguage(getDriver1());
        landingPage1.checkCyberManifestoPolicies(getDriver1());
        landingPage1.selectAppLanguage(getDriver1());
        homePage1.handlingPopup(getDriver1());
        homePage1.clickOnCoins(getDriver1());
        String getCoinsToBeAdded = frndCoinPage1.getCoinsToBeAdded(getDriver1());
        frndCoinPage1.clickOnTwentyCoinPackage(getDriver1());
        paymentPage1.selectFrndAppPaymentMethod(getDriver1());
        paymentPage1.clickOnGooglePayIcon(getDriver1());
        paymentPage1.enterOTPAndMakePayment(getDriver1(), "111000");
        trainingRoomPage1.clickOnIAgreeButton(getDriver1());
        String availableCoin = homePage1.getAvailableCoin(getDriver1());
        homePage1.clickOnTrainingTab(getDriver1());
        trainingRoomPage1.checkCoinAndEnterRoom(availableCoin, "20", getDriver1());
        trainingRoomPage2.clickOnIAgreeButton(getDriver2());
        Thread.sleep(65000);
        vivoCallPage1.verify5MinAddedToCall(getDriver1());
        clickBackButton(getDriver2());
        Thread.sleep(343000);
        //  vivoCallPage1.verifyUserGotRemovedAferFreeFiveMinuteCall(getDriver1());
        vivoCallPage1.clickOnStarRating(getDriver1());
        vivoCallPage1.clickOnskipCrossButton(getDriver1());
        homePage1.clickOnTrainingTab(getDriver1());
        trainingRoomPage1.clickOnHostedRoomAndJoin(getDriver1());
        trainingRoomPage1.verifyUserNeedToAddCoinsForFurtherCall(getDriver1());
    }

    @Test(enabled = false)
    public void verifyTheShouldBeShownTheFreeDailyRewardsForPrivateCallWhichUserHaveAssignedTheDaily_reward()
    {

    }
}