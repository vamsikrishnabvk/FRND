package com.QA.Test;

import com.QA.Base.BaseTest;
import com.QA.Pages.*;
import com.QA.utlis.TestUtils;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.*;

import java.io.InputStream;
import java.lang.reflect.Method;

public class AudioCallTest extends BaseTest {


    LandingPage landingPage1, landingPage2;
    HomePage homePage1, homePage2;
    PrivateTrainingRoomPage trainingRoomPage1, trainingRoomPage2;
    SelectTagScreenPage tagScreenPage1, tagScreenPage2;
    HostedAudioCallPage vivoCallPage1, vivoCallPage2;
    JSONObject AudioCallTest;
    ProfilePage profilePage1, profilePage2;
    FrndCoinPage frndCoinPage1, frndCoinPage2;
    PaymentPage paymentPage1, paymentPage2;
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
        frndCoinPage2 = new FrndCoinPage(getDriver2());
        paymentPage1 = new PaymentPage(getDriver1());
        paymentPage2 = new PaymentPage(getDriver2());
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
     * Verify that users able to host that voice call room.
     * Verify that Host able to close the hosted room before start the game.
     *
     * @throws InterruptedException
     */
    @Test(priority = 0, enabled = false, description = "LT-01: Verify User able to Host Voice call")
    public void verifyUserAbleToHostVoiceCallAndExitFromRoom() throws InterruptedException {
        String phoneNumber1 = AudioCallTest.getJSONObject("AudioCallTest").getString("phoneNumberDev1");
        String otp = AudioCallTest.getJSONObject("AudioCallTest").getString("otp");
        String phoneNumber2 = AudioCallTest.getJSONObject("AudioCallTest").getString("phoneNumberDev1");
        String partialPhNum = AudioCallTest.getJSONObject("AudioCallTest").getString("partialPhNo");
        String expectedCoins = AudioCallTest.getJSONObject("AudioCallTest").getString("expectedCoins");
        String nickName = AudioCallTest.getJSONObject("AudioCallTest").getString("nickName");
        String portNumber = AudioCallTest.getJSONObject("AudioCallTest").getString("portNumber");
        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.KEYCODE_VOLUME_DOWN(getDriver1());
        landingPage1.changingPort(portNumber, getDriver1());
        landingPage1.loginToApplication(phoneNumber1, otp, getDriver1());
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

    /**
     * Verify that coin balance is deducted when user send that YR/Gifts according to timer.
     * Verify that game timer is start properly according user coins.
     * Verify that user able to leave that game during ON game.
     * Verify that user able to leave that game during ON game.
     * Verify that Gift animation is working as expected.
     *
     * @throws InterruptedException
     */
    @Test(priority = 1, enabled = true)
    public void VerifyCoinBalanceAfterUserSendsGiftAccordingToTimer() throws InterruptedException {
        String phoneNumber1 = AudioCallTest.getJSONObject("AudioCallTest").getString("phoneNumberDev1");
        String otp = AudioCallTest.getJSONObject("AudioCallTest").getString("otp");
        String phoneNumber2 = AudioCallTest.getJSONObject("AudioCallTest").getString("phoneNumberDev2");
        String expectedCoins = AudioCallTest.getJSONObject("AudioCallTest").getString("expectedCoins");
        String portNumber = AudioCallTest.getJSONObject("AudioCallTest").getString("portNumber");
        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.KEYCODE_VOLUME_DOWN(getDriver1());
        landingPage1.changingPort(portNumber, getDriver1());
        landingPage2.handlingUpdatePopup(getDriver2());
        landingPage2.KEYCODE_VOLUME_DOWN(getDriver2());
        landingPage2.changingPort(portNumber, getDriver2());
        landingPage1.loginToApplication(phoneNumber1, otp, getDriver1());
        landingPage2.loginToApplication(phoneNumber2, otp, getDriver2());
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
        vivoCallPage2.hostExitRoom(getDriver2());
        homePage2.verifyHostExitTheRoom(getDriver2());
        trainingRoomPage2.clickOnPlusIcon(getDriver2());
        trainingRoomPage2.clickOnCreateRoomIcon(getDriver2());
        homePage1.clickOnTrainingTab(getDriver1());
        trainingRoomPage2.clickOnAudioRoomButton(getDriver2());
        tagScreenPage2.clickOnLoveTag(getDriver2());
        tagScreenPage2.verifyUerAbleToHost(getDriver2());
        homePage1.clickOnTrainingTab(getDriver1());
        trainingRoomPage1.checkCoinAndEnterRoom(text, expectedCoins, getDriver1());
        vivoCallPage1.clickOnGameIcon(getDriver1());
        vivoCallPage1.clickOnGamePopupCrossButton(getDriver1());
        vivoCallPage2.clickOnGameIcon(getDriver2());
        vivoCallPage2.clickOnGamePopupCrossButton(getDriver2());
        vivoCallPage2.checkMuteUnmuteFunctionality(getDriver2());
        vivoCallPage1.verfiyTimerAndGiftCoinAfterSendsGift(text, getDriver1());
        vivoCallPage2.hostRemoveUserFromTheRoom(getDriver2());
        vivoCallPage1.verfiyUserGotRemoveFromVoiceCall(getDriver1());
        vivoCallPage1.clickOnStarRating(getDriver1());
        vivoCallPage1.clickOnskipCrossButton(getDriver1());
        trainingRoomPage1.checkCoinsDeducted(text, getDriver1());
        trainingRoomPage1.checkCoinAndEnterRoom(text, expectedCoins, getDriver1());
        vivoCallPage2.clickOnExitButton(getDriver2());
        homePage2.verifyHostExitTheRoom(getDriver2());
        trainingRoomPage2.clickOnPlusIcon(getDriver2());
        trainingRoomPage2.clickOnCreateRoomIcon(getDriver2());
        trainingRoomPage2.clickOnAudioRoomButton(getDriver2());
        tagScreenPage2.clickOnLoveTag(getDriver2());
        tagScreenPage2.verifyUerAbleToHost(getDriver2());
        vivoCallPage1.clickOnStarRating(getDriver1());
        vivoCallPage1.clickOnskipCrossButton(getDriver1());
        homePage1.clickOnTrainingTab(getDriver1());
        Thread.sleep(2000);
        swipeScreen(Direction.DOWN, getDriver1());
        trainingRoomPage1.checkCoinAndEnterRoom(text, expectedCoins, getDriver1());
        vivoCallPage1.clickOnExitButton(getDriver1());
        vivoCallPage1.verifyUserLeaveGameduringOnGame(getDriver1());
        vivoCallPage1.clickOnStarRating(getDriver1());
        vivoCallPage1.clickOnskipCrossButton(getDriver1());
        trainingRoomPage1.checkCoinsDeducted(text, getDriver1());
    }

    /**
     * Verify that users are able to join in voice call with sufficient requird balance.[ ≥ 20 coins].
     * Verify that users are not able to join in voice call with Insufficient  balance.[ < 20 coins].
     *
     * @throws InterruptedException
     */
    @Test(priority = 2, enabled = false)
    public void verifyThatUsersAreAbleToJoinInVoiceCallAccordingCoinBalance() throws InterruptedException {
        String phoneNumber1 = AudioCallTest.getJSONObject("AudioCallTest").getString("phoneNumberDev1");
        String otp = AudioCallTest.getJSONObject("AudioCallTest").getString("otp");
        String phoneNumber2 = AudioCallTest.getJSONObject("AudioCallTest").getString("phoneNumberDev2");
        String expectedCoins = AudioCallTest.getJSONObject("AudioCallTest").getString("expectedCoins");
        String portNumber = AudioCallTest.getJSONObject("AudioCallTest").getString("portNumber");
        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.KEYCODE_VOLUME_DOWN(getDriver1());
        landingPage1.changingPort(portNumber, getDriver1());
        landingPage2.handlingUpdatePopup(getDriver2());
        landingPage2.KEYCODE_VOLUME_DOWN(getDriver2());
        landingPage2.changingPort(portNumber, getDriver2());
        landingPage1.loginToApplication(phoneNumber1, otp, getDriver1());
        landingPage2.loginToApplication(phoneNumber2, otp, getDriver2());
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
        trainingRoomPage1.checkCoinAndEnterRoom(text, expectedCoins, getDriver1());
        vivoCallPage2.hostExitGameRoom(getDriver2());
    }

    /**
     * Check that mute/unmute functionality is working as expected.
     *
     * @throws InterruptedException
     */

    @Test(priority = 3, enabled = false)
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
        landingPage1.changingPort(portNumber, getDriver1());
        landingPage1.loginToApplication(phoneNumber1, otp, getDriver1());
        homePage1.handlingPopup(getDriver1());
        homePage1.clickOnTrainingTab(getDriver1());
        trainingRoomPage1.clickOnPlusIcon(getDriver1());
        trainingRoomPage1.clickOnCreateRoomIcon(getDriver1());
        trainingRoomPage1.clickOnAudioRoomButton(getDriver1());
        tagScreenPage1.clickOnLoveTag(getDriver1());
        tagScreenPage1.verifyUerAbleToHost(getDriver1());
        vivoCallPage1.checkMuteUnmuteFunctionality(getDriver1());
    }

    /**
     * Verify that host able to open user profile during call by clicking on user avatar.
     * Verify that user able to remove the voice call when host remove particular users.
     *
     * @throws InterruptedException
     */
    @Test(priority = 4, enabled = false)
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
        landingPage1.changingPort(portNumber, getDriver1());
        landingPage2.handlingUpdatePopup(getDriver2());
        landingPage2.KEYCODE_VOLUME_DOWN(getDriver2());
        landingPage2.changingPort(portNumber, getDriver2());
        landingPage1.loginToApplication(phoneNumber1, otp, getDriver1());
        landingPage2.loginToApplication(phoneNumber2, otp, getDriver2());
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
        trainingRoomPage1.checkCoinAndEnterRoom(text, expectedCoins, getDriver1());
        vivoCallPage2.hostRemoveUserFromTheRoom(getDriver2());
        vivoCallPage1.verfiyUserGotRemoveFromVoiceCall(getDriver1());
    }

    /**
     * Verify that user gets remove from the voice call when host kick out particular users.
     * Verify if user is not able to join the hosted VIVO room again if host ban the user with warning.
     *
     * @throws InterruptedException
     */
    @Test(priority = 5, enabled = false)
    public void verifyUserNotAbleToJoinRoomWhenHostBanUser() throws InterruptedException {
        String phoneNumber1 = AudioCallTest.getJSONObject("AudioCallTest").getString("phoneNumberDev1");
        String otp = AudioCallTest.getJSONObject("AudioCallTest").getString("otp");
        String partialPhNum = AudioCallTest.getJSONObject("AudioCallTest").getString("partialPhNo");
        String expectedCoins = AudioCallTest.getJSONObject("AudioCallTest").getString("expectedCoins");
        String nickName = AudioCallTest.getJSONObject("AudioCallTest").getString("nickName");
        String portNumber = AudioCallTest.getJSONObject("AudioCallTest").getString("portNumber");

        landingPage2.handlingUpdatePopup(getDriver2());
        landingPage2.KEYCODE_VOLUME_DOWN(getDriver2());
        landingPage2.changingPort(portNumber, getDriver2());
        int i = getRandomNum();
        String phonNum = partialPhNum + Integer.toString(i);
        landingPage2.clickOnLetsGoButton(getDriver2());
        landingPage2.enterMobileNumber(phonNum, getDriver2());
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
        landingPage1.loginToApplication(phoneNumber1, otp, getDriver1());
        homePage1.handlingPopup(getDriver1());
        String text = homePage1.getAvailableCoin(getDriver1());
        homePage1.clickOnTrainingTab(getDriver1());
        trainingRoomPage1.clickOnPlusIcon(getDriver1());
        trainingRoomPage1.clickOnCreateRoomIcon(getDriver1());
        trainingRoomPage1.clickOnAudioRoomButton(getDriver1());
        tagScreenPage1.clickOnLoveTag(getDriver1());
        tagScreenPage1.verifyUerAbleToHost(getDriver1());
        homePage2.handlingPopup(getDriver2());
        homePage2.clickOnCoins(getDriver2());
        frndCoinPage2.clickOnTwentyCoinPackage(getDriver2());
        paymentPage2.selectFrndAppPaymentMethod(getDriver2());
        paymentPage2.clickOnGooglePayIcon(getDriver2());
        paymentPage2.enterOTPAndMakePayment(getDriver2(), "111000");
        trainingRoomPage2.clickOnIAgreeButton(getDriver2());
        String availableCoin = homePage2.getAvailableCoin(getDriver2());
        homePage2.clickOnTrainingTab(getDriver2());
        trainingRoomPage2.checkCoinAndEnterRoom(text, expectedCoins, getDriver2());
        trainingRoomPage1.clickOnIAgreeButton(getDriver1());
        vivoCallPage1.hostBanTheUser(getDriver1());
        vivoCallPage2.userGotTheWarning(getDriver2());
        trainingRoomPage2.verifyUserNotJoinRoomAfterBan(getDriver2());
    }

    @Test(priority = 6, enabled = false)
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
        landingPage1.changingPort(portNumber, getDriver1());
        landingPage2.handlingUpdatePopup(getDriver2());
        landingPage2.KEYCODE_VOLUME_DOWN(getDriver2());
        landingPage2.changingPort(portNumber, getDriver2());
        landingPage1.loginToApplication(phoneNumber1, otp, getDriver1());
        landingPage2.loginToApplication(phoneNumber2, otp, getDriver2());
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
        trainingRoomPage1.checkCoinAndEnterRoom(text, expectedCoins, getDriver1());
        vivoCallPage1.clickOnExitButton(getDriver1());
        vivoCallPage1.verfiyUserGotRemoveFromVoiceCall(getDriver1());
    }

    @Test(priority = 7, enabled = false)
    public void verifyThatUserIsAbleToExitTheGameAutomaticallyAfterEndOfGameTimer() throws InterruptedException {
        String phoneNumber1 = AudioCallTest.getJSONObject("AudioCallTest").getString("phoneNumberDev1");
        String otp = AudioCallTest.getJSONObject("AudioCallTest").getString("otp");
        String partialPhNum = AudioCallTest.getJSONObject("AudioCallTest").getString("partialPhNo");
        String nickName = AudioCallTest.getJSONObject("AudioCallTest").getString("nickName");
        String portNumber = AudioCallTest.getJSONObject("AudioCallTest").getString("portNumber");
        landingPage2.handlingUpdatePopup(getDriver2());
        landingPage2.KEYCODE_VOLUME_DOWN(getDriver2());
        landingPage2.changingPort(portNumber, getDriver2());
        int i = getRandomNum();
        String phonNum = partialPhNum + Integer.toString(i);
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
        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.KEYCODE_VOLUME_DOWN(getDriver1());
        landingPage1.changingPort(portNumber, getDriver1());
        landingPage1.loginToApplication(phoneNumber1, otp, getDriver1());
        homePage1.handlingPopup(getDriver1());
        String text = homePage1.getAvailableCoin(getDriver1());
        homePage1.clickOnTrainingTab(getDriver1());
        trainingRoomPage1.clickOnPlusIcon(getDriver1());
        trainingRoomPage1.clickOnCreateRoomIcon(getDriver1());
        trainingRoomPage1.clickOnAudioRoomButton(getDriver1());
        tagScreenPage1.clickOnLoveTag(getDriver1());
        tagScreenPage1.verifyUerAbleToHost(getDriver1());
        homePage2.handlingPopup(getDriver2());
        homePage2.clickOnHomeTab(getDriver2());
        homePage2.clickOnCoins(getDriver2());
        String getCoinsToBeAdded = frndCoinPage2.getCoinsToBeAdded(getDriver2());
        frndCoinPage2.clickOnTwentyCoinPackage(getDriver2());
        paymentPage2.selectFrndAppPaymentMethod(getDriver2());
        paymentPage2.clickOnGooglePayIcon(getDriver2());
        paymentPage2.enterOTPAndMakePayment(getDriver2(), "111000");
        trainingRoomPage2.clickOnIAgreeButton(getDriver2());
        String availableCoin = homePage2.getAvailableCoin(getDriver2());
        homePage2.clickOnTrainingTab(getDriver2());
        trainingRoomPage2.checkCoinAndEnterRoom(availableCoin, "20", getDriver2());
        Thread.sleep(125000);
        vivoCallPage2.clickOnStarRating(getDriver2());
        vivoCallPage2.checkUserHaveExitRoomAutomatically(getDriver2());
    }

    @Test(priority = 7, enabled = false)
    public void verifyTheHostEndShouldBeShownTheGamePromptsInVivoIfUserNotClickManuallyInBefore60Sec() throws InterruptedException {
        String phoneNumber1 = AudioCallTest.getJSONObject("AudioCallTest").getString("phoneNumberDev1");
        String otp = AudioCallTest.getJSONObject("AudioCallTest").getString("otp");
        String phoneNumber2 = AudioCallTest.getJSONObject("AudioCallTest").getString("phoneNumberDev2");
        String expectedCoins = AudioCallTest.getJSONObject("AudioCallTest").getString("expectedCoins");
        String portNumber = AudioCallTest.getJSONObject("AudioCallTest").getString("portNumber");
        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.KEYCODE_VOLUME_DOWN(getDriver1());
        landingPage1.changingPort(portNumber, getDriver1());
        landingPage2.handlingUpdatePopup(getDriver2());
        landingPage2.KEYCODE_VOLUME_DOWN(getDriver2());
        landingPage2.changingPort(portNumber, getDriver2());
        landingPage1.loginToApplication(phoneNumber1, otp, getDriver1());
        landingPage2.loginToApplication(phoneNumber2, otp, getDriver2());
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
        trainingRoomPage2.clickOnAudioRoomButton(getDriver2());
        tagScreenPage2.clickOnLoveTag(getDriver2());
        tagScreenPage2.verifyUerAbleToHost(getDriver2());
        vivoCallPage1.clickOnStarRating(getDriver1());
        vivoCallPage1.clickOnskipCrossButton(getDriver1());
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
        trainingRoomPage2.clickOnAudioRoomButton(getDriver2());
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
        trainingRoomPage2.clickOnAudioRoomButton(getDriver2());
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
        trainingRoomPage2.clickOnAudioRoomButton(getDriver2());
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

    @Test(priority = 8, enabled = false)
    public void verifyUserShouldBeAbleToSeeStarUsersHostedPTRRoomWhichUsersHasDoneSuccesfullOneTranscation() throws InterruptedException {
        String otp = AudioCallTest.getJSONObject("AudioCallTest").getString("otp");
        String partialPhNum = AudioCallTest.getJSONObject("AudioCallTest").getString("partialPhNo");
        String nickName = AudioCallTest.getJSONObject("AudioCallTest").getString("nickName");
        String portNumber = AudioCallTest.getJSONObject("AudioCallTest").getString("portNumber");
        String phoneNumber3 = AudioCallTest.getJSONObject("AudioCallTest").getString("phoneNumber3");
        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.KEYCODE_VOLUME_DOWN(getDriver1());
        landingPage1.changingPort(portNumber, getDriver1());
        landingPage1.loginToApplication(phoneNumber3, otp, getDriver1());
        homePage1.handlingPopup(getDriver1());
        homePage1.clickOnTrainingTab(getDriver1());
        trainingRoomPage1.clickOnPlusIcon(getDriver1());
        trainingRoomPage1.clickOnCreateRoomIcon(getDriver1());
        trainingRoomPage1.clickOnAudioRoomButton(getDriver1());
        tagScreenPage1.clickOnLoveTag(getDriver1());
        tagScreenPage1.verifyUerAbleToHost(getDriver1());
        landingPage2.handlingUpdatePopup(getDriver2());
        landingPage2.KEYCODE_VOLUME_DOWN(getDriver2());
        landingPage2.changingPort(portNumber, getDriver2());
        int i = getRandomNum();
        String phonNum = partialPhNum + Integer.toString(i);
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
        String availableCoin = homePage2.getAvailableCoin(getDriver2());
        homePage2.clickOnTrainingTab(getDriver2());
        trainingRoomPage2.checkStarUserDisplayedAndJoinRoom(getDriver2(), availableCoin, 60);
        homePage2.clickOnCoins(getDriver2());
        frndCoinPage2.clickOnTwentyCoinPackage(getDriver2());
        paymentPage2.selectFrndAppPaymentMethod(getDriver2());
        paymentPage2.clickOnGooglePayIcon(getDriver2());
        paymentPage2.enterOTPAndMakePayment(getDriver2(), "111000");
        trainingRoomPage2.clickOnIAgreeButton(getDriver2());
        String availableCoin1 = homePage2.getAvailableCoin(getDriver2());
        homePage2.clickOnTrainingTab(getDriver2());
        trainingRoomPage2.checkStarUserDisplayedAndJoinRoom(getDriver2(), availableCoin1, 60);
        homePage2.clickOnCoins(getDriver2());
        frndCoinPage2.clickOnNienetyCoinPackage(getDriver2());
        paymentPage2.selectFrndAppPaymentMethod(getDriver2());
        paymentPage2.clickOnGooglePayIcon(getDriver2());
        paymentPage2.enterOTPAndMakePayment(getDriver2(), "111000");
        trainingRoomPage2.clickOnIAgreeButton(getDriver2());
        String availableCoin3 = homePage2.getAvailableCoin(getDriver2());
        homePage2.clickOnTrainingTab(getDriver2());
        trainingRoomPage2.checkStarUserDisplayedAndJoinRoom(getDriver2(), availableCoin3, 60);
    }

    @Test(priority = 8, enabled = false)
    public void verifyAreYouTherePopUpShouldBeShownOnlyForParticularFG_groupCohortsUsers() throws InterruptedException {
        String phoneNumber1 = AudioCallTest.getJSONObject("AudioCallTest").getString("phoneNumberDev1");
        String phoneNumber4 = AudioCallTest.getJSONObject("AudioCallTest").getString("phoneNumber4");
        String otp = AudioCallTest.getJSONObject("AudioCallTest").getString("otp");
        String portNumber = AudioCallTest.getJSONObject("AudioCallTest").getString("portNumber");
        landingPage2.handlingUpdatePopup(getDriver2());
        landingPage2.KEYCODE_VOLUME_DOWN(getDriver2());
        landingPage2.changingPort(portNumber, getDriver2());
        landingPage2.loginToApplication(phoneNumber1, otp, getDriver2());
        homePage2.handlingPopup(getDriver2());
        String text = homePage1.getAvailableCoin(getDriver1());
        homePage2.clickOnTrainingTab(getDriver2());
        trainingRoomPage2.clickOnPlusIcon(getDriver2());
        trainingRoomPage2.clickOnCreateRoomIcon(getDriver2());
        homePage1.clickOnTrainingTab(getDriver1());
        trainingRoomPage2.clickOnAudioRoomButton(getDriver2());
        tagScreenPage2.clickOnLoveTag(getDriver2());
        click(tagScreenPage2.goOnlineButton,getDriver2());
        tagScreenPage2.verifyUerAbleToHost(getDriver2());
        vivoCallPage2.getText(getDriver2());
        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.KEYCODE_VOLUME_DOWN(getDriver1());
        landingPage1.loginToApplication(phoneNumber4,otp,getDriver1());
        homePage1.handlingPopup(getDriver1());
        homePage1.getAvailableCoin(getDriver1());
        homePage1.clickOnTrainingTab(getDriver1());
        trainingRoomPage1.clickOnAudioRoomButton(getDriver1());
        tagScreenPage1.clickOnLoveTag(getDriver1());
        click(tagScreenPage2.goOnlineButton,getDriver2());
        tagScreenPage1.verifyUerAbleToHost(getDriver1());
        vivoCallPage1.getText(getDriver2());
        vivoCallPage1.verifyHostMinizeTheRoom(getDriver2());
        vivoCallPage1.getNumberFromString("");
        vivoCallPage2.clickOnReconsiderCrossButton(getDriver2());
        vivoCallPage1.hostBanTheUser(getDriver1());
        trainingRoomPage1.clickOnIAgreeButton(getDriver1());
        tagScreenPage2.verifyUserRehostTheHostedRoom(getDriver2());
        tagScreenPage1.verifyUserRehostTheHostedRoom(getDriver1());
        tagScreenPage2.clickOnGoOnlineButton(getDriver2());
        tagScreenPage1.clickOnGoOnlineButton(getDriver1());
        homePage1.getAvailableCoin(getDriver1());
    }
}