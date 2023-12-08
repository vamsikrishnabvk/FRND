package com.QA.Test;

<<<<<<< HEAD
import com.QA.Base.BaseTest;
=======
import com.QA.Base.BaseTest2;
>>>>>>> e7aad041656f51bcd7540c5837b667b08d8aa271
import com.QA.Pages.*;
import com.QA.utlis.TestUtils;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.*;

import java.io.InputStream;
import java.lang.reflect.Method;

<<<<<<< HEAD
public class AudioCallTest extends BaseTest {


    LandingPage landingPage1, landingPage2;
    HomePage homePage1, homePage2;
    PrivateTrainingRoomPage trainingRoomPage1, trainingRoomPage2;
    SelectTagScreenPage tagScreenPage1, tagScreenPage2;
    HostedAudioCallPage vivoCallPage1, vivoCallPage2;
    JSONObject AudioCallTest;
    ProfilePage profilePage1, profilePage2;
=======
public class AudioCallTest extends BaseTest2 {


    LandingPage landingPage1,landingPage2;
    HomePage homePage1,homePage2;
    PrivateTrainingRoomPage trainingRoomPage1,trainingRoomPage2;
    SelectTagScreenPage tagScreenPage1,tagScreenPage2;
    HostedAudioCallPage vivoCallPage1,vivoCallPage2;
    JSONObject AudioCallTest;
    ProfilePage profilePage1,profilePage2;
>>>>>>> e7aad041656f51bcd7540c5837b667b08d8aa271
    TestUtils utils = new TestUtils();

    @BeforeClass
    public void beforeClass() throws Exception {
        InputStream datais = null;
        try {
            String dataFileName = "data/audioCallTest.json";
            datais = getClass().getClassLoader().getResourceAsStream(dataFileName);
            JSONTokener tokener = new JSONTokener(datais);
            AudioCallTest = new JSONObject(tokener);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (datais != null) {
                datais.close();
            }
        }
<<<<<<< HEAD
        //    closeApp();
        //    launchApp();
=======
    //    closeApp();
    //    launchApp();
>>>>>>> e7aad041656f51bcd7540c5837b667b08d8aa271
    }

    @AfterClass
    public void afterClass() {
<<<<<<< HEAD
        //   getDriver().quit();
=======
     //   getDriver().quit();
>>>>>>> e7aad041656f51bcd7540c5837b667b08d8aa271
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
<<<<<<< HEAD
    @Test(priority = 0, enabled = true, description = "LT-01: Verify User able to Host Voice call")
=======
    @Test(priority = 1, enabled = false, description = "LT-01: Verify User able to Host Voice call")
>>>>>>> e7aad041656f51bcd7540c5837b667b08d8aa271
    public void verifyUserAbleToHostVoiceCallAndExitFromRoom() throws InterruptedException {
        String phoneNumber1 = AudioCallTest.getJSONObject("AudioCallTest").getString("phoneNumberDev1");
        String otp = AudioCallTest.getJSONObject("AudioCallTest").getString("otp");
        String phoneNumber2 = AudioCallTest.getJSONObject("AudioCallTest").getString("phoneNumberDev1");
        String partialPhNum = AudioCallTest.getJSONObject("AudioCallTest").getString("partialPhNo");
        String expectedCoins = AudioCallTest.getJSONObject("AudioCallTest").getString("expectedCoins");
        String nickName = AudioCallTest.getJSONObject("AudioCallTest").getString("nickName");
        String portNumber = AudioCallTest.getJSONObject("AudioCallTest").getString("portNumber");
        landingPage1.handlingUpdatePopup(getDriver1());
<<<<<<< HEAD
        landingPage1.KEYCODE_VOLUME_DOWN(getDriver1());
        landingPage1.changingPort(portNumber, getDriver1());
        landingPage1.loginToApplication(phoneNumber1, otp, getDriver1());
=======
       landingPage1.KEYCODE_VOLUME_DOWN(getDriver1());
       landingPage1.changingPort(portNumber,getDriver1());
        landingPage1.loginToApplication(phoneNumber1,otp,getDriver1());
>>>>>>> e7aad041656f51bcd7540c5837b667b08d8aa271
        homePage1.handlingPopup(getDriver1());
        homePage1.clickOnTrainingTab(getDriver1());
        trainingRoomPage1.clickOnPlusIcon(getDriver1());
        trainingRoomPage1.clickOnCreateRoomIcon(getDriver1());
        trainingRoomPage1.clickOnAudioRoomButton(getDriver1());
        tagScreenPage1.clickOnLoveTag(getDriver1());
        tagScreenPage1.verifyUerAbleToHost(getDriver1());
        vivoCallPage1.hostExitRoom(getDriver1());
        homePage1.verifyHostExitTheRoom(getDriver1());
    }

<<<<<<< HEAD
    @Test(priority = 1, enabled = true)
=======
    @Test(priority = 0, enabled = false)
>>>>>>> e7aad041656f51bcd7540c5837b667b08d8aa271
    public void VerifyCoinBalanceAfterUserSendsGiftAccordingToTimer() throws InterruptedException {
        String phoneNumber1 = AudioCallTest.getJSONObject("AudioCallTest").getString("phoneNumberDev1");
        String otp = AudioCallTest.getJSONObject("AudioCallTest").getString("otp");
        String phoneNumber2 = AudioCallTest.getJSONObject("AudioCallTest").getString("phoneNumberDev2");
        String partialPhNum = AudioCallTest.getJSONObject("AudioCallTest").getString("partialPhNo");
        String expectedCoins = AudioCallTest.getJSONObject("AudioCallTest").getString("expectedCoins");
        String nickName = AudioCallTest.getJSONObject("AudioCallTest").getString("nickName");
        String portNumber = AudioCallTest.getJSONObject("AudioCallTest").getString("portNumber");
        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.KEYCODE_VOLUME_DOWN(getDriver1());
<<<<<<< HEAD
        landingPage1.changingPort(portNumber, getDriver1());
        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage2.KEYCODE_VOLUME_DOWN(getDriver2());
        landingPage2.changingPort(portNumber, getDriver2());
        landingPage1.loginToApplication(phoneNumber1, otp, getDriver1());
        landingPage2.loginToApplication(phoneNumber2, otp, getDriver2());
=======
        landingPage1.changingPort(portNumber,getDriver1());
        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage2.KEYCODE_VOLUME_DOWN(getDriver2());
        landingPage2.changingPort(portNumber,getDriver2());
        landingPage1.loginToApplication(phoneNumber1,otp,getDriver1());
        landingPage2.loginToApplication(phoneNumber2,otp,getDriver2());
>>>>>>> e7aad041656f51bcd7540c5837b667b08d8aa271
        homePage1.handlingPopup(getDriver1());
        homePage2.handlingPopup(getDriver2());
        String text = homePage1.getAvailableCoin(getDriver1());
        homePage2.clickOnTrainingTab(getDriver2());
        trainingRoomPage2.clickOnPlusIcon(getDriver2());
        trainingRoomPage2.clickOnCreateRoomIcon(getDriver2());
        homePage1.clickOnTrainingTab(getDriver1());
        trainingRoomPage2.clickOnAudioRoomButton(getDriver2());
        tagScreenPage2.clickOnLoveTag(getDriver2());
        tagScreenPage2.verifyUerAbleToHost(getDriver2());
<<<<<<< HEAD
        trainingRoomPage1.checkCoinAndEnterRoom(text, expectedCoins, getDriver1());
        vivoCallPage1.verfiyTimerAndGiftCoinAfterSendsGift(text, getDriver1());
=======
        trainingRoomPage1.checkCoinAndEnterRoom(text,expectedCoins,getDriver1());
        vivoCallPage1.verfiyTimerAndGiftCoinAfterSendsGift(text,getDriver1());
>>>>>>> e7aad041656f51bcd7540c5837b667b08d8aa271
        vivoCallPage1.clickOnExitButton(getDriver1());
        vivoCallPage1.clickOnStarRating(getDriver1());
        vivoCallPage1.giveReviewMessage(getDriver1());
        vivoCallPage1.clickOnSubmitButton(getDriver1());
        vivoCallPage1.shareAppExperienceRating(getDriver1());
<<<<<<< HEAD
        trainingRoomPage1.checkCoinsDeducted(text, getDriver1());
    }

    @Test(priority = 2, enabled = true)
=======
        trainingRoomPage1.checkCoinsDeducted(text,getDriver1());
    }
    @Test(priority =  1,enabled = false)
>>>>>>> e7aad041656f51bcd7540c5837b667b08d8aa271
    public void verifyThatUsersAreAbleToJoinInVoiceCallAccordingCoinBalance() throws InterruptedException {
        String phoneNumber1 = AudioCallTest.getJSONObject("AudioCallTest").getString("phoneNumberDev1");
        String otp = AudioCallTest.getJSONObject("AudioCallTest").getString("otp");
        String phoneNumber2 = AudioCallTest.getJSONObject("AudioCallTest").getString("phoneNumberDev2");
        String partialPhNum = AudioCallTest.getJSONObject("AudioCallTest").getString("partialPhNo");
        String expectedCoins = AudioCallTest.getJSONObject("AudioCallTest").getString("expectedCoins");
        String nickName = AudioCallTest.getJSONObject("AudioCallTest").getString("nickName");
        String portNumber = AudioCallTest.getJSONObject("AudioCallTest").getString("portNumber");
        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.KEYCODE_VOLUME_DOWN(getDriver1());
<<<<<<< HEAD
        landingPage1.changingPort(portNumber, getDriver1());
        landingPage1.handlingUpdatePopup(getDriver2());
        landingPage2.KEYCODE_VOLUME_DOWN(getDriver2());
        landingPage2.changingPort(portNumber, getDriver2());
        landingPage1.loginToApplication(phoneNumber1, otp, getDriver1());
        landingPage2.loginToApplication(phoneNumber2, otp, getDriver2());
=======
        landingPage1.changingPort(portNumber,getDriver1());
        landingPage1.handlingUpdatePopup(getDriver2());
        landingPage2.KEYCODE_VOLUME_DOWN(getDriver2());
        landingPage2.changingPort(portNumber,getDriver2());
        landingPage1.loginToApplication(phoneNumber1,otp,getDriver1());
        landingPage2.loginToApplication(phoneNumber2,otp,getDriver2());
>>>>>>> e7aad041656f51bcd7540c5837b667b08d8aa271
        homePage1.handlingPopup(getDriver1());
        homePage2.handlingPopup(getDriver2());
        String text = homePage1.getAvailableCoin(getDriver1());
        homePage2.clickOnTrainingTab(getDriver2());
        trainingRoomPage2.clickOnPlusIcon(getDriver2());
        trainingRoomPage2.clickOnCreateRoomIcon(getDriver2());
        homePage1.clickOnTrainingTab(getDriver1());
        trainingRoomPage2.clickOnAudioRoomButton(getDriver2());
        tagScreenPage2.clickOnLoveTag(getDriver2());
        tagScreenPage2.verifyUerAbleToHost(getDriver2());
<<<<<<< HEAD
        trainingRoomPage1.checkCoinAndEnterRoom(text, expectedCoins, getDriver1());
    }

    @Test(priority = 3, enabled = true)
=======
        trainingRoomPage1.checkCoinAndEnterRoom(text,expectedCoins,getDriver1());
    }
    @Test(enabled = false)
>>>>>>> e7aad041656f51bcd7540c5837b667b08d8aa271
    public void checkThatMuteUnmuteFunctionalityIsWorkingAsExpected() throws InterruptedException {
        String phoneNumber1 = AudioCallTest.getJSONObject("AudioCallTest").getString("phoneNumberDev1");
        String otp = AudioCallTest.getJSONObject("AudioCallTest").getString("otp");
        String phoneNumber2 = AudioCallTest.getJSONObject("AudioCallTest").getString("phoneNumberDev2");
        String partialPhNum = AudioCallTest.getJSONObject("AudioCallTest").getString("partialPhNo");
        String expectedCoins = AudioCallTest.getJSONObject("AudioCallTest").getString("expectedCoins");
        String nickName = AudioCallTest.getJSONObject("AudioCallTest").getString("nickName");
        String portNumber = AudioCallTest.getJSONObject("AudioCallTest").getString("portNumber");
        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.KEYCODE_VOLUME_DOWN(getDriver1());
<<<<<<< HEAD
        landingPage1.changingPort(portNumber, getDriver1());
        landingPage1.loginToApplication(phoneNumber1, otp, getDriver1());
=======
        landingPage1.changingPort(portNumber,getDriver1());
        landingPage1.loginToApplication(phoneNumber1,otp,getDriver1());
>>>>>>> e7aad041656f51bcd7540c5837b667b08d8aa271
        homePage1.handlingPopup(getDriver1());
        homePage1.clickOnTrainingTab(getDriver1());
        trainingRoomPage1.clickOnPlusIcon(getDriver1());
        trainingRoomPage1.clickOnCreateRoomIcon(getDriver1());
        trainingRoomPage1.clickOnAudioRoomButton(getDriver1());
        tagScreenPage1.clickOnLoveTag(getDriver1());
        tagScreenPage1.verifyUerAbleToHost(getDriver1());
        vivoCallPage1.checkMuteUnmuteFunctionality(getDriver1());
    }

<<<<<<< HEAD
    @Test(priority = 4, enabled = true, description = "LT-01: Verify User able to Host Voice call")
=======
    @Test(priority = 1, enabled = true, description = "LT-01: Verify User able to Host Voice call")
>>>>>>> e7aad041656f51bcd7540c5837b667b08d8aa271
    public void withDrawAmount() throws InterruptedException {
        String phoneNumber1 = AudioCallTest.getJSONObject("AudioCallTest").getString("phoneNumberDev1");
        String otp = AudioCallTest.getJSONObject("AudioCallTest").getString("otp");
        String phoneNumber2 = AudioCallTest.getJSONObject("AudioCallTest").getString("phoneNumberDev2");
        String partialPhNum = AudioCallTest.getJSONObject("AudioCallTest").getString("partialPhNo");
        String expectedCoins = AudioCallTest.getJSONObject("AudioCallTest").getString("expectedCoins");
        String nickName = AudioCallTest.getJSONObject("AudioCallTest").getString("nickName");
        String portNumber = AudioCallTest.getJSONObject("AudioCallTest").getString("portNumber");
        landingPage2.handlingUpdatePopup(getDriver2());
        landingPage2.KEYCODE_VOLUME_DOWN(getDriver2());
<<<<<<< HEAD
        landingPage2.changingPort(portNumber, getDriver2());
        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.KEYCODE_VOLUME_DOWN(getDriver1());
        landingPage1.changingPort(portNumber, getDriver1());
        landingPage2.loginToApplication(phoneNumber1, otp, getDriver2());
        landingPage1.loginToApplication(phoneNumber2, otp, getDriver1());
=======
        landingPage2.changingPort(portNumber,getDriver2());
        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.KEYCODE_VOLUME_DOWN(getDriver1());
        landingPage1.changingPort(portNumber,getDriver1());
        landingPage2.loginToApplication(phoneNumber1,otp,getDriver2());
        landingPage1.loginToApplication(phoneNumber2,otp,getDriver1());
>>>>>>> e7aad041656f51bcd7540c5837b667b08d8aa271
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
<<<<<<< HEAD
        trainingRoomPage2.checkCoinAndEnterRoom(text, expectedCoins, getDriver2());
=======
        trainingRoomPage2.checkCoinAndEnterRoom(text,expectedCoins,getDriver2());
>>>>>>> e7aad041656f51bcd7540c5837b667b08d8aa271
        vivoCallPage1.requestForGiftFor10Roses(getDriver1());
        vivoCallPage2.userSendGiftToHost(getDriver2());
        vivoCallPage1.clickOnExitButton(getDriver1());
        trainingRoomPage1.clickOnProfileIcon(getDriver1());
        profilePage1.clikcOnWinMoneyButton(getDriver1());
        profilePage1.withDrawMoney(getDriver1());
    }

<<<<<<< HEAD
    @Test(priority = 5, enabled = true)
=======
    @Test(enabled = false)
>>>>>>> e7aad041656f51bcd7540c5837b667b08d8aa271
    public void verifyThatUserAbleToRemoveTheVoiceCallWhenHostRemoveParticularUsers() throws InterruptedException {
        String phoneNumber1 = AudioCallTest.getJSONObject("AudioCallTest").getString("phoneNumberDev1");
        String otp = AudioCallTest.getJSONObject("AudioCallTest").getString("otp");
        String phoneNumber2 = AudioCallTest.getJSONObject("AudioCallTest").getString("phoneNumberDev2");
        String partialPhNum = AudioCallTest.getJSONObject("AudioCallTest").getString("partialPhNo");
        String expectedCoins = AudioCallTest.getJSONObject("AudioCallTest").getString("expectedCoins");
        String nickName = AudioCallTest.getJSONObject("AudioCallTest").getString("nickName");
        String portNumber = AudioCallTest.getJSONObject("AudioCallTest").getString("portNumber");
        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.KEYCODE_VOLUME_DOWN(getDriver1());
<<<<<<< HEAD
        landingPage1.changingPort(portNumber, getDriver1());
        landingPage2.handlingUpdatePopup(getDriver2());
        landingPage2.KEYCODE_VOLUME_DOWN(getDriver2());
        landingPage2.changingPort(portNumber, getDriver2());
        landingPage1.loginToApplication(phoneNumber1, otp, getDriver1());
        landingPage2.loginToApplication(phoneNumber2, otp, getDriver2());
=======
        landingPage1.changingPort(portNumber,getDriver1());
        landingPage2.handlingUpdatePopup(getDriver2());
        landingPage2.KEYCODE_VOLUME_DOWN(getDriver2());
        landingPage2.changingPort(portNumber,getDriver2());
        landingPage1.loginToApplication(phoneNumber1,otp,getDriver1());
        landingPage2.loginToApplication(phoneNumber2,otp,getDriver2());
>>>>>>> e7aad041656f51bcd7540c5837b667b08d8aa271
        homePage1.handlingPopup(getDriver1());
        homePage2.handlingPopup(getDriver2());
        String text = homePage1.getAvailableCoin(getDriver1());
        homePage2.clickOnTrainingTab(getDriver2());
        homePage1.clickOnTrainingTab(getDriver1());
        trainingRoomPage2.clickOnPlusIcon(getDriver2());
        trainingRoomPage2.clickOnCreateRoomIcon(getDriver2());
        trainingRoomPage2.clickOnAudioRoomButton(getDriver2());
        tagScreenPage2.clickOnLoveTag(getDriver2());
        tagScreenPage2.verifyUerAbleToHost(getDriver2());
<<<<<<< HEAD
        trainingRoomPage1.checkCoinAndEnterRoom(text, expectedCoins, getDriver1());
=======
        trainingRoomPage1.checkCoinAndEnterRoom(text,expectedCoins,getDriver1());
>>>>>>> e7aad041656f51bcd7540c5837b667b08d8aa271
        vivoCallPage2.hostRemoveUserFromTheRoom(getDriver2());
        vivoCallPage1.verfiyUserGotRemoveFromVoiceCall(getDriver1());
    }

<<<<<<< HEAD
    @Test(priority = 6, enabled = true)
=======
    @Test(enabled = false)
>>>>>>> e7aad041656f51bcd7540c5837b667b08d8aa271
    public void verifyUserNotAbleToJoinRoomWhenHostBanUser() throws InterruptedException {
        String phoneNumber1 = AudioCallTest.getJSONObject("AudioCallTest").getString("phoneNumberDev1");
        String otp = AudioCallTest.getJSONObject("AudioCallTest").getString("otp");
        String phoneNumber2 = AudioCallTest.getJSONObject("AudioCallTest").getString("phoneNumberDev2");
        String partialPhNum = AudioCallTest.getJSONObject("AudioCallTest").getString("partialPhNo");
        String expectedCoins = AudioCallTest.getJSONObject("AudioCallTest").getString("expectedCoins");
        String nickName = AudioCallTest.getJSONObject("AudioCallTest").getString("nickName");
        String portNumber = AudioCallTest.getJSONObject("AudioCallTest").getString("portNumber");
        landingPage2.handlingUpdatePopup(getDriver2());
        landingPage2.KEYCODE_VOLUME_DOWN(getDriver2());
<<<<<<< HEAD
        landingPage2.changingPort(portNumber, getDriver2());
        int i = getRandomNum();
        String phonNum = partialPhNum + Integer.toString(i);
        landingPage2.clickOnLetsGoButton(getDriver2());
        landingPage2.enterMobileNumber(phonNum, getDriver2());
        landingPage2.clickOnGetOTPButton(getDriver2());
        landingPage2.enterOTPNumber(otp, getDriver2());
        landingPage2.clickOnSubmitButton(getDriver2());
        landingPage2.enterNickName(getDriver2(), nickName);
=======
        landingPage2.changingPort(portNumber,getDriver2());
        int i = getRandomNum();
        String phonNum = partialPhNum+Integer.toString(i);
        landingPage2.clickOnLetsGoButton(getDriver2());
        landingPage2.enterMobileNumber(phonNum,getDriver2());
        landingPage2.clickOnGetOTPButton(getDriver2());
        landingPage2.enterOTPNumber(otp,getDriver2());
        landingPage2.clickOnSubmitButton(getDriver2());
        landingPage2.enterNickName(getDriver2(),nickName);
>>>>>>> e7aad041656f51bcd7540c5837b667b08d8aa271
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
<<<<<<< HEAD
        landingPage1.changingPort(portNumber, getDriver1());
        landingPage1.loginToApplication(phoneNumber1, otp, getDriver1());
=======
        landingPage1.changingPort(portNumber,getDriver1());
        landingPage1.loginToApplication(phoneNumber1,otp,getDriver1());
>>>>>>> e7aad041656f51bcd7540c5837b667b08d8aa271
        homePage1.handlingPopup(getDriver1());
        String text = homePage1.getAvailableCoin(getDriver1());
        homePage2.clickOnTrainingTab(getDriver2());
        homePage1.clickOnTrainingTab(getDriver1());
        trainingRoomPage2.clickOnPlusIcon(getDriver2());
        trainingRoomPage2.clickOnCreateRoomIcon(getDriver2());
        trainingRoomPage2.clickOnAudioRoomButton(getDriver2());
        tagScreenPage2.clickOnLoveTag(getDriver2());
        tagScreenPage2.verifyUerAbleToHost(getDriver2());
<<<<<<< HEAD
        trainingRoomPage1.checkCoinAndEnterRoom(text, expectedCoins, getDriver1());
=======
        trainingRoomPage1.checkCoinAndEnterRoom(text,expectedCoins,getDriver1());
>>>>>>> e7aad041656f51bcd7540c5837b667b08d8aa271
        vivoCallPage2.hostBanTheUser(getDriver2());
        vivoCallPage1.userGotTheWarning(getDriver1());
        trainingRoomPage1.verifyUserNotJoinRoomAfterBan(getDriver1());
    }

<<<<<<< HEAD
    @Test(priority = 7, enabled = true)
=======
    @Test(enabled = false)
>>>>>>> e7aad041656f51bcd7540c5837b667b08d8aa271
    public void verifyThatUserAbleToLeaveThatGameDuringONGame() throws InterruptedException {
        String phoneNumber1 = AudioCallTest.getJSONObject("AudioCallTest").getString("phoneNumberDev1");
        String otp = AudioCallTest.getJSONObject("AudioCallTest").getString("otp");
        String phoneNumber2 = AudioCallTest.getJSONObject("AudioCallTest").getString("phoneNumberDev2");
        String partialPhNum = AudioCallTest.getJSONObject("AudioCallTest").getString("partialPhNo");
        String expectedCoins = AudioCallTest.getJSONObject("AudioCallTest").getString("expectedCoins");
        String nickName = AudioCallTest.getJSONObject("AudioCallTest").getString("nickName");
        String portNumber = AudioCallTest.getJSONObject("AudioCallTest").getString("portNumber");
        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.KEYCODE_VOLUME_DOWN(getDriver1());
<<<<<<< HEAD
        landingPage1.changingPort(portNumber, getDriver1());
        landingPage2.handlingUpdatePopup(getDriver2());
        landingPage2.KEYCODE_VOLUME_DOWN(getDriver2());
        landingPage2.changingPort(portNumber, getDriver2());
        landingPage1.loginToApplication(phoneNumber1, otp, getDriver1());
        landingPage2.loginToApplication(phoneNumber2, otp, getDriver2());
=======
        landingPage1.changingPort(portNumber,getDriver1());
        landingPage2.handlingUpdatePopup(getDriver2());
        landingPage2.KEYCODE_VOLUME_DOWN(getDriver2());
        landingPage2.changingPort(portNumber,getDriver2());
        landingPage1.loginToApplication(phoneNumber1,otp,getDriver1());
        landingPage2.loginToApplication(phoneNumber2,otp,getDriver2());
>>>>>>> e7aad041656f51bcd7540c5837b667b08d8aa271
        homePage1.handlingPopup(getDriver1());
        homePage2.handlingPopup(getDriver2());
        String text = homePage1.getAvailableCoin(getDriver1());
        homePage2.clickOnTrainingTab(getDriver2());
        homePage1.clickOnTrainingTab(getDriver1());
        trainingRoomPage2.clickOnPlusIcon(getDriver2());
        trainingRoomPage2.clickOnCreateRoomIcon(getDriver2());
        trainingRoomPage2.clickOnAudioRoomButton(getDriver2());
        tagScreenPage2.clickOnLoveTag(getDriver2());
        tagScreenPage2.verifyUerAbleToHost(getDriver2());
<<<<<<< HEAD
        trainingRoomPage1.checkCoinAndEnterRoom(text, expectedCoins, getDriver1());
=======
        trainingRoomPage1.checkCoinAndEnterRoom(text,expectedCoins,getDriver1());
>>>>>>> e7aad041656f51bcd7540c5837b667b08d8aa271
        vivoCallPage1.clickOnExitButton(getDriver1());
        vivoCallPage1.verfiyUserGotRemoveFromVoiceCall(getDriver1());
    }
}