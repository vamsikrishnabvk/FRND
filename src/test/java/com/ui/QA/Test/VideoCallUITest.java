package com.ui.QA.Test;

import com.QA.API.ApiUdateData;
import com.QA.Base.BaseTest;
import com.QA.DataBase.FetchValue;
import com.QA.Pages.*;
import com.QA.utlis.TestUtils;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class VideoCallUITest extends BaseTest {

    LandingPage landingPage1, landingPage2;
    HomePage homePage1, homePage2;
    PrivateTrainingRoomPage trainingRoomPage1, trainingRoomPage2;
    SelectTagScreenPage tagScreenPage1, tagScreenPage2;
    HostedAudioCallPage hostedAudioCallPage1,hostedAudioCallPage2;
    HostedVideoCallPage hostedVideoCallPage1, hostedVideoCallPage2;
    FrndMakingRoomsPage frndMakingRoomsPage1,frndMakingRoomsPage2;
    FrndCoinPage frndCoinPage1,frndCoinPage2;
    PaymentPage paymentPage1,paymentPage2;
    FrndRadioPage frndRadioPage1, frndRadioPage2;
    FetchValue fetchValue;
    ApiUdateData apiUdateData;
    TestUtils utils = new TestUtils();

    @BeforeClass
    public void beforeClass() throws Exception {
//        InputStream datais = null;
//        try {
//            String dataFileName = "data/audioCallTest.json";
//            datais = getClass().getClassLoader().getResourceAsStream(dataFileName);
//            JSONTokener tokener = new JSONTokener(datais);
//            AudioCallTest = new JSONObject(tokener);
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw e;
//        } finally {
//            if (datais != null) {
//                datais.close();
//            }
//        }
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
        tagScreenPage1 = new SelectTagScreenPage((getDriver1()));
        tagScreenPage2 = new SelectTagScreenPage(getDriver2());
        hostedAudioCallPage1 = new HostedAudioCallPage(getDriver1());
        hostedAudioCallPage2 = new HostedAudioCallPage(getDriver2());
        trainingRoomPage1 = new PrivateTrainingRoomPage(getDriver1());
        trainingRoomPage2 = new PrivateTrainingRoomPage(getDriver2());
        frndCoinPage1 = new FrndCoinPage(getDriver1());
        frndCoinPage2 = new FrndCoinPage(getDriver2());
        frndMakingRoomsPage1 = new FrndMakingRoomsPage(getDriver1());
        frndMakingRoomsPage2 = new FrndMakingRoomsPage(getDriver2());
        paymentPage1 = new PaymentPage(getDriver1());
        paymentPage2 = new PaymentPage(getDriver2());
        frndRadioPage1 = new FrndRadioPage(getDriver1());
        frndRadioPage2 = new FrndRadioPage(getDriver2());
        hostedVideoCallPage1 = new HostedVideoCallPage(getDriver1());
        hostedVideoCallPage2 = new HostedVideoCallPage(getDriver2());
        fetchValue = new FetchValue();
        apiUdateData = new ApiUdateData();
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
     *Verify that users able to host that voice call room.
     * Verify that Host able to close the hosted room before start the game.
     * @throws InterruptedException
     */
    @Test(priority = 0, enabled = false, description = "LT-01: Verify User able to Host Voice call")
    public void checkIfTheUserShouldBeAbleToClickOnCreateButtonFromHomeScreenToHostVoiceCallForFemaleUser() throws InterruptedException {
        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.KEYCODE_VOLUME_DOWN(getDriver1());
        landingPage1.changingPort("QA",getDriver1());
        landingPage1.loginToApplication("7890128005", "000000", getDriver1());
        homePage1.handlingPopup(getDriver1());
        homePage1.clickOnCreateButton(getDriver1());
        homePage1.clickOnVideoRoomButton(getDriver1());
        tagScreenPage1.clickOnLoveTag(getDriver1());
        tagScreenPage1.checkGoOnlineButtonEnabled(getDriver1());
        tagScreenPage1.verifyUerAbleToHost(getDriver1());
        hostedAudioCallPage1.verifyInviteButton(getDriver1());
        hostedAudioCallPage1.verifyThreeDotClickableAndAllIconsPresentInVideoCall(getDriver1());
        hostedAudioCallPage1.verifyHowToEarnRewardButtonClickable(getDriver1());
        hostedVideoCallPage1.verifyListOfFramesDisplayedWhenHostClickOnItsOwnAvatar(getDriver1());
        hostedVideoCallPage1.verifyAfterClickingOnFrameBuyNowButtonDisplayedAndClickable(getDriver1());
        //  hostedAudioCallPage1.verifyFramesScrollableAndFreeFrameApply(getDriver1());
        hostedVideoCallPage1.verifyGemAndCoinsIconDisplayedOnFrameWindow(getDriver1());
        hostedAudioCallPage1.verifyClickingCoinsInFramesWindowShouldOpenaPaywallScreen(getDriver1());
        hostedAudioCallPage1.hostExitRoom(getDriver1());
       // hostedAudioCallPage1.clickOnskipCrossButton(getDriver1());
        hostedAudioCallPage1.returnToHomePageInGirlsLogin(getDriver1());
        // hostedAudioCallPage1.verifyIfUserTapsOnTheHostedCardOrJoinFromHomeScreenShouldTheConnectingScreenWithFillingBarAnimation(getDriver1());
        homePage1.clickOnCreateButton(getDriver1());
        homePage1.clickOnVideoRoomButton(getDriver1());
        tagScreenPage1.clickOnLoveTag(getDriver1());
        tagScreenPage1.checkGoOnlineButtonEnabled(getDriver1());
        tagScreenPage1.verifyUerAbleToHost(getDriver1());
        landingPage2.KEYCODE_VOLUME_DOWN(getDriver2());
        landingPage2.changingPort("QA", getDriver2());
        landingPage2.loginToApplication("7890134561", "000000", getDriver2());
        homePage2.handlingPopup(getDriver2());
        String text = homePage2.getAvailableCoin(getDriver2());
        homePage2.clickOnTrainingTab(getDriver2());
        homePage2.clickOnTrainingTab(getDriver2());
        trainingRoomPage2.checkCoinAndEnterRoom(text, "20", getDriver2());
        trainingRoomPage2.clickOnIAgreeButton(getDriver2());
        hostedAudioCallPage1.clickOnGameIcon(getDriver1());
        hostedAudioCallPage1.clickOnGamePopupCrossButton(getDriver1());
        hostedAudioCallPage2.clickOnGameIcon(getDriver2());
        hostedAudioCallPage2.clickOnGamePopupCrossButton(getDriver2());
        hostedAudioCallPage2.verifyKeepGiftingRoseAnimationLable(getDriver2());
        hostedAudioCallPage2.verifyGiftBoxGamesAskIconDisplayed(getDriver2());
        hostedAudioCallPage2.verifyAskFunGiftIconsShouldBeProperlyClickableAndShouldShowTheExpectedBehaviour(getDriver2());
        hostedAudioCallPage2.checkIfTheFRNDMeterHeartIconShouldDisplayedBetweenHostAndUserAvatarShouldBeClickableAndShouldGetFillAsUserSendsTheYR(getDriver2());
        hostedAudioCallPage2.verifyKnowMoreButtonDsplayedAndClickable(getDriver2());
        hostedAudioCallPage2.checkUserAndhostshouldBeAbleToClickOnTheCustomShouldDisplayPlusMinusYRcount(getDriver2());
        hostedAudioCallPage2.verifyIfPlusMinusYrCounticonShouldBeClickableAmountShouldIncreaseWhileUserClicksOnPlusMinusIcon(getDriver2());
        hostedAudioCallPage1.clickOnExitButton(getDriver1());
        hostedAudioCallPage2.clickOnStarRating2(getDriver2());
        hostedAudioCallPage2.clickOnskipCrossButton(getDriver2());
        trainingRoomPage2.clickOnPlusIcon(getDriver2());
        trainingRoomPage2.clickOnCreateRoomIcon(getDriver2());
        trainingRoomPage2.clickOnAudioRoomButton(getDriver2());
        tagScreenPage2.clickOnLoveTag(getDriver2());
        tagScreenPage2.checkGoOnlineButtonEnabled(getDriver2());
        tagScreenPage2.verifyUerAbleToHost(getDriver2());
        hostedAudioCallPage2.verifyHostMinizeTheRoom(getDriver2());
        trainingRoomPage2.clickOnPlusIcon(getDriver2());
        trainingRoomPage2.clickOnCreateRoomIcon(getDriver2());
        trainingRoomPage2.clickOnAudioRoomButton(getDriver2());
        tagScreenPage2.verifyUserRehostTheHostedRoom(getDriver2());
        hostedAudioCallPage2.verifyHostMinizeTheRoom(getDriver2());
    }

    @Test(priority = 1, enabled = false, description = "LT-01: Verify User able to Host Voice call")
    public void checkIfInGameRechargeReminderBottomSheetShouldDisplayOnLast3MinsLeftInVoiceCall() throws InterruptedException {
        landingPage2.handlingUpdatePopup(getDriver2());
        landingPage2.KEYCODE_VOLUME_DOWN(getDriver2());
        landingPage2.changingPort("QA", getDriver2());
//        int i = getRandomNum();
//        String phonNum = "78901" + Integer.toString(i);
//        landingPage2.clickOnLetsGoButton(getDriver2());
//        landingPage2.enterMobileNumber(phonNum, getDriver2());
//        landingPage2.clickOnGetOTPButton(getDriver2());
//        landingPage2.enterOTPNumber("000000", getDriver2());
//        landingPage2.clickOnSubmitButton(getDriver2());
//        landingPage2.enterNickName(getDriver2(), "Daniel");
//        landingPage2.clickOnSelectGenderButton(getDriver2());
//        landingPage2.clickOnBoyGender(getDriver2());
//        landingPage2.clickOnDateOfBirthButtonAndOkButton(getDriver2());
//        landingPage2.clickOnSignInSubmitButton(getDriver2());
//        landingPage2.selectLanguage(getDriver2());
//        landingPage2.checkCyberManifestoPolicies(getDriver2());
//        landingPage2.selectAppLanguage(getDriver2());
        landingPage2.loginToApplication("7890134562", "000000", getDriver2());
        homePage2.handlingPopup(getDriver2());
        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.KEYCODE_VOLUME_DOWN(getDriver1());
        landingPage1.changingPort("QA", getDriver1());
        landingPage1.loginToApplication("7890134561", "000000", getDriver1());
        homePage1.handlingPopup(getDriver1());
        String text = homePage1.getAvailableCoin(getDriver1());
        homePage1.clickOnTrainingTab(getDriver1());
        trainingRoomPage1.clickOnPlusIcon(getDriver1());
        trainingRoomPage1.clickOnCreateRoomIcon(getDriver1());
        trainingRoomPage1.clickOnVideoRoomButton(getDriver1());
        tagScreenPage1.clickOnLoveTag(getDriver1());
        tagScreenPage1.verifyUerAbleToHost(getDriver1());
        //    homePage2.clickOnHomeTab(getDriver2());
//        homePage2.clickOnCoins(getDriver2());
//        String getCoinsToBeAdded = frndCoinPage2.getCoinsToBeAdded(getDriver2());
//        frndCoinPage2.clickOnNienetyCoinPackage(getDriver2());
//        paymentPage2.selectFrndAppPaymentMethod(getDriver2());
//        paymentPage2.clickOnGooglePayIcon(getDriver2());
//        paymentPage2.enterOTPAndMakePayment(getDriver2(),"111000");
        trainingRoomPage2.clickOnIAgreeButton(getDriver2());
        String availableCoin = homePage2.getAvailableCoin(getDriver2());
        homePage2.clickOnTrainingTab(getDriver2());
        trainingRoomPage2.checkCoinAndEnterRoom(availableCoin, "90", getDriver2());
        hostedAudioCallPage2.clickOnGameIcon(getDriver2());
        hostedAudioCallPage2.clickOnGamePopupCrossButton(getDriver2());
        hostedAudioCallPage1.clickOnGameIcon(getDriver1());
        hostedAudioCallPage1.clickOnGamePopupCrossButton(getDriver1());
        trainingRoomPage2.verifyTheUserShoulAbleToSeeAndClickOnTheAurBataoIcon(getDriver2());
        hostedAudioCallPage2.verifyIfTheIngameRechargeReminderShouldShowWhenUserClicksOnTheTimerBeforeLast3min(getDriver2());
        hostedAudioCallPage2.checkMentionedAmountOnTheBottomOfTheInGameRechargeReminderShouldAlsoChangeAsPerTheSelectedPackage(getDriver2());
        clickBackButton(getDriver2());
        hostedAudioCallPage2.clickOnExitButton2(getDriver2());
        hostedAudioCallPage2.clickOnStarRating(getDriver2());
        hostedAudioCallPage2.clickOnskipCrossButton(getDriver2());
//        int availableCoins = trainingRoomPage2.gettingAvailableCoins(getDriver2());
//        trainingRoomPage2.checkCoinAndEnterRoom(Integer.toString(availableCoins),"90",getDriver2());
    //    hostedAudioCallPage2.verifyIfSwitchToVideoCallOptionShouldOnlyDisplayUnderTripleDotOptionOnceUserHaveJoinedTheHostedVoiceCall(getDriver2(), availableCoin, "20");
//        hostedAudioCallPage2.clickOnGameIcon(getDriver2());
//        hostedAudioCallPage2.clickOnGamePopupCrossButton(getDriver2());
//        hostedAudioCallPage1.clickOnGameIcon(getDriver1());
//        hostedAudioCallPage1.clickOnGamePopupCrossButton(getDriver1());
      //  hostedAudioCallPage2.verifyIfClickingOnVideoIconShouldShowABottomSheetUnderthreeDotsWithLoadingAnimationUntilOtherUserAcceptsOrejects(getDriver2());
     //   hostedAudioCallPage1.checkIfSwitchToVideoCallRequestReceivedUserShouldShowAShimmerAnimationAcceptButton(getDriver1());
    //    hostedAudioCallPage1.clickOnRejectButton(getDriver1());
     ////   hostedAudioCallPage2.requestedUserShouldShowRequestRejectedWithCancelAndTryAgainOptionButton(getDriver2());
  //      hostedAudioCallPage2.clickOnAcceptButton(getDriver2());
    //    hostedAudioCallPage1.verifyClickingOnTryAgainOptionShouldInitiateTheVideoCallRequestToTheOtherUser(getDriver1());
      //  hostedAudioCallPage1.clickOnAcceptButton(getDriver1());
      //  Thread.sleep(30000);
      //  trainingRoomPage2.checkIfUserShouldOnlyBeAbleToJoinVideoCallRequestInVoiceCallIfUserHaveTheRequiredCoinBalance(getDriver2(), availableCoins, 90);
    }

    @Test(priority = 1, enabled = false, description = "LT-01: Verify User able to Host Voice call")
    public void checkTheHostFaceIsNotInFrontOfTheMobileCameraThenHostShouldShowFaceNotDetectedScreenUntilTheAppDetectsTheFace() throws InterruptedException {
        landingPage2.handlingUpdatePopup(getDriver2());
        landingPage2.KEYCODE_VOLUME_DOWN(getDriver2());
        landingPage2.changingPort("QA", getDriver2());
        landingPage2.loginToApplication("7890124705", "000000", getDriver2());
        homePage2.handlingPopup(getDriver2());
        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.KEYCODE_VOLUME_DOWN(getDriver1());
        landingPage1.changingPort("QA", getDriver1());
        landingPage1.loginToApplication("7890134561", "000000", getDriver1());
        homePage1.handlingPopup(getDriver1());
        String text = homePage1.getAvailableCoin(getDriver1());
        homePage1.clickOnTrainingTab(getDriver1());
        trainingRoomPage1.clickOnPlusIcon(getDriver1());
        trainingRoomPage1.clickOnCreateRoomIcon(getDriver1());
        trainingRoomPage1.clickOnVideoRoomButton(getDriver1());
        tagScreenPage1.clickOnLoveTag(getDriver1());
        tagScreenPage1.verifyUerAbleToHost(getDriver1());
        trainingRoomPage2.clickOnIAgreeButton(getDriver2());
        String availableCoin = homePage2.getAvailableCoin(getDriver2());
        homePage2.clickOnTrainingTab(getDriver2());
        trainingRoomPage2.checkCoinAndEnterRoom(availableCoin, "90", getDriver2());
        hostedAudioCallPage2.verifyFaceNotDetectedUntilUserNotInfrontOfCamera(getDriver2());
        hostedAudioCallPage2.checkIfFaceNotDetectedBottomSheetShouldShowAMovingAnimationForUserToGuideThatUserShouldBeInFrontOfTheDeviceCamera(getDriver2());
    }

    @Test(priority = 1, enabled = false, description = "LT-01: Verify User able to Host Voice call")
    public void verifyIfSwitchToVideoCallOptionShouldNotBePresentUnderTripleDotOptionForBothHostAndUser() throws InterruptedException {
        landingPage2.handlingUpdatePopup(getDriver2());
        landingPage2.KEYCODE_VOLUME_DOWN(getDriver2());
        landingPage2.changingPort("QA", getDriver2());
        landingPage2.loginToApplication("7890134562", "000000", getDriver2());
        homePage2.handlingPopup(getDriver2());
        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.KEYCODE_VOLUME_DOWN(getDriver1());
        landingPage1.changingPort("QA", getDriver1());
        landingPage1.loginToApplication("7890134561", "000000", getDriver1());
        homePage1.handlingPopup(getDriver1());
        String text = homePage1.getAvailableCoin(getDriver1());
        homePage1.clickOnTrainingTab(getDriver1());
        trainingRoomPage1.clickOnPlusIcon(getDriver1());
        trainingRoomPage1.clickOnCreateRoomIcon(getDriver1());
        trainingRoomPage1.clickOnVideoRoomButton(getDriver1());
        tagScreenPage1.clickOnLoveTag(getDriver1());
        tagScreenPage1.verifyUerAbleToHost(getDriver1());
        trainingRoomPage2.clickOnIAgreeButton(getDriver2());
        String availableCoin = homePage2.getAvailableCoin(getDriver2());
        homePage2.clickOnTrainingTab(getDriver2());
        trainingRoomPage2.checkCoinAndEnterRoom(availableCoin, "90", getDriver2());
        hostedVideoCallPage2.verifyIfSwitchToVideoCallOptionShouldNotBePresentUnderTripleDotOptionForBothHostAndUser(getDriver2());
    }

    @Test(priority = 1, enabled = false, description = "LT-01: Verify User able to Host Voice call")
    public void checkIfHostShouldShowEndCallDurationPromptWhenUserLeavesVideoCallAndHostFaceIsNotDetected() throws InterruptedException {
        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.KEYCODE_VOLUME_DOWN(getDriver1());
        landingPage1.changingPort("QA", getDriver1());
        landingPage1.loginToApplication("7890134562", "000000", getDriver1());
        homePage1.handlingPopup(getDriver1());
        String text = homePage1.getAvailableCoin(getDriver1());
        homePage1.clickOnTrainingTab(getDriver1());
        trainingRoomPage1.clickOnPlusIcon(getDriver1());
        trainingRoomPage1.clickOnCreateRoomIcon(getDriver1());
        trainingRoomPage1.clickOnVideoRoomButton(getDriver1());
        tagScreenPage1.clickOnLoveTag(getDriver1());
        tagScreenPage1.verifyUerAbleToHost(getDriver1());
        landingPage2.handlingUpdatePopup(getDriver2());
        landingPage2.KEYCODE_VOLUME_DOWN(getDriver2());
        landingPage2.changingPort("QA", getDriver2());
        landingPage2.loginToApplication("7890134561", "000000", getDriver2());
        homePage2.handlingPopup(getDriver2());
        trainingRoomPage2.clickOnIAgreeButton(getDriver2());
        String availableCoin = homePage2.getAvailableCoin(getDriver2());
        homePage2.clickOnTrainingTab(getDriver2());
        trainingRoomPage2.checkCoinAndEnterRoom(availableCoin, "90", getDriver2());
        hostedVideoCallPage2.clickOnExitButton1(getDriver2());
        hostedAudioCallPage1.verifyYrCreditShownToHost(getDriver1(),1,1);
    }

    @Test(priority = 1, enabled = false, description = "LT-01: Verify User able to Host Voice call")
    public void verifyIfOnceTheUserLeavesTheHostVideoCallThenOnlyHostShouldReturnBackToVideoCallScreenIfFaceIsNotDetectedUntilThat() throws InterruptedException {
        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.KEYCODE_VOLUME_DOWN(getDriver1());
        landingPage1.changingPort("QA", getDriver1());
        landingPage1.loginToApplication("7890134561", "000000", getDriver1());
        homePage1.handlingPopup(getDriver1());
        String text = homePage1.getAvailableCoin(getDriver1());
        homePage1.clickOnTrainingTab(getDriver1());
        trainingRoomPage1.clickOnPlusIcon(getDriver1());
        trainingRoomPage1.clickOnCreateRoomIcon(getDriver1());
        trainingRoomPage1.clickOnVideoRoomButton(getDriver1());
        tagScreenPage1.clickOnLoveTag(getDriver1());
        tagScreenPage1.verifyUerAbleToHost(getDriver1());
        landingPage2.handlingUpdatePopup(getDriver2());
        landingPage2.KEYCODE_VOLUME_DOWN(getDriver2());
        landingPage2.changingPort("QA", getDriver2());
        landingPage2.loginToApplication("7890134562", "000000", getDriver2());
        homePage2.handlingPopup(getDriver2());
        trainingRoomPage2.clickOnIAgreeButton(getDriver2());
        String availableCoin = homePage2.getAvailableCoin(getDriver2());
        homePage2.clickOnTrainingTab(getDriver2());
        trainingRoomPage2.checkCoinAndEnterRoom(availableCoin, "90", getDriver2());
        Thread.sleep(10000);
        hostedVideoCallPage2.verifyTheCameraShouldBeSisableWhileMakeTheMute(getDriver2());
        hostedVideoCallPage2.verifyTheUserShouldBeAbleToEnableDisableOfSpeaker(getDriver2());
    }

    @Test(priority = 1, enabled = false, description = "LT-01: Verify User able to Host Voice call")
    public void verifyIfUserWithHostedVIVOCallOnOneDeviceThenSameUserOnOtherDevicesShouldNotBeAllowedToHostAndJoinFMRFRNDRadioDumsharasVIVO() throws InterruptedException {
        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.KEYCODE_VOLUME_DOWN(getDriver1());
        landingPage1.changingPort("QA", getDriver1());
        landingPage1.loginToApplication("7890134561","000000", getDriver1());
        homePage1.handlingPopup(getDriver1());
        homePage1.clickOnTrainingTab(getDriver1());
        trainingRoomPage1.clickOnPlusIcon(getDriver1());
        trainingRoomPage1.clickOnCreateRoomIcon(getDriver1());
        trainingRoomPage1.clickOnVideoRoomButton(getDriver1());
        tagScreenPage1.clickOnLoveTag(getDriver1());
        tagScreenPage1.verifyUerAbleToHost(getDriver1());
        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage2.KEYCODE_VOLUME_DOWN(getDriver2());
        landingPage2.changingPort("QA", getDriver2());
        landingPage2.loginToApplication("7890134561", "000000", getDriver2());
        String id = fetchValue.fetchValue("7890134561");
        apiUdateData.fmrCohartUpdate(id,true,"http://qa.frndapp.in:8080","/automatedTesting/updateUser","7890134561");
        homePage2.handlingPopup(getDriver2());
        homePage2.clickOnFrndTab(getDriver2());
        frndMakingRoomsPage2.verifyFRNDMakingRoomsPageHeader("FRND Making Rooms", getDriver2());
        frndMakingRoomsPage2.clickOnPlusIconAfterJoinRoom(getDriver2());
        // frndMakingRoom1.clickOnCreateNewRoomButton(getDriver1());
        landingPage2.handlingUpdatePopup(getDriver2());
        landingPage2.KEYCODE_VOLUME_DOWN(getDriver2());
        landingPage2.changingPort("QA", getDriver2());
        landingPage2.loginToApplication("7890134561", "000000", getDriver2());
        homePage2.handlingPopup(getDriver2());
        String id1 = fetchValue.fetchValue("7890134561");
        apiUdateData.frndRadio(id1,true,"http://qa.frndapp.in:8080","/automatedTesting/updateFgGroup","7890134561");
        apiUdateData.frndRadioCohortUpdate(id,true,"http://qa.frndapp.in:8080","/automatedTesting/updateUser","7890134561");
        homePage2.clickOnGroupRoom(getDriver2());
        frndRadioPage2.verifyGroupRoomsPage(true, getDriver2());
        frndRadioPage2.createGroupRooms(getDriver1());
        frndRadioPage2.createRadioRoom("Your live show", "Frnd Radio Room", 1, getDriver2());
        frndRadioPage2.allowAudioRecordAllowPopup(getDriver2());
        frndRadioPage2.verifyUserNotAbleToHostFrndRadioRoom(getDriver2());
        clickBackButton(getDriver2());
        homePage2.clickOnTrainingTab(getDriver2());
        trainingRoomPage2.clickOnPlusIcon(getDriver2());
        trainingRoomPage2.clickOnCreateRoomIcon(getDriver2());
        trainingRoomPage2.clickOnVideoRoomButton(getDriver2());
        tagScreenPage2.clickOnLoveTag(getDriver2());
        tagScreenPage2.clickOnGoOnlineButton(getDriver2());
        trainingRoomPage2.verifyNotAbleToHostPTRroom(getDriver2());
    }

    @Test(priority = 1, enabled = true, description = "LT-01: Verify User able to Host Voice call")
    public void checkIfInGameRechargeReminderBottonSheetShouldDisplayOnLastThreeMinsLeftIvideoCall() throws InterruptedException {
        landingPage2.handlingUpdatePopup(getDriver2());
        landingPage2.KEYCODE_VOLUME_DOWN(getDriver2());
        landingPage2.changingPort("QA", getDriver2());
        landingPage2.loginToApplication("7890134561", "000000", getDriver2());
        homePage2.handlingPopup(getDriver2());
        homePage2.clickOnTrainingTab(getDriver2());
        trainingRoomPage2.clickOnPlusIcon(getDriver2());
        trainingRoomPage2.clickOnCreateRoomIcon(getDriver2());
        trainingRoomPage2.clickOnVideoRoomButton(getDriver2());
        tagScreenPage2.clickOnLoveTag(getDriver2());
        tagScreenPage2.verifyUerAbleToHost(getDriver2());
        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.KEYCODE_VOLUME_DOWN(getDriver1());
        landingPage1.changingPort("QA", getDriver1());
        int i = getRandomNum();
        String phonNum = "78901" + Integer.toString(i);
        landingPage1.clickOnLetsGoButton(getDriver1());
        landingPage1.enterMobileNumber(phonNum, getDriver1());
        landingPage1.clickOnGetOTPButton(getDriver1());
        landingPage1.enterOTPNumber("000000", getDriver1());
        landingPage1.clickOnSubmitButton(getDriver1());
        landingPage1.enterNickName(getDriver1(), "Daniel");
        landingPage1.clickOnSelectGenderButton(getDriver1());
        landingPage1.clickOnBoyGender(getDriver1());
        landingPage1.clickOnDateOfBirthButtonAndOkButton(getDriver1());
        landingPage1.clickOnSignInSubmitButton(getDriver1());
        landingPage1.selectLanguage(getDriver1());
        landingPage1.checkCyberManifestoPolicies(getDriver1());
        landingPage1.selectAppLanguage(getDriver1());
        homePage1.handlingPopup(getDriver1());
        homePage1.clickOnCoins(getDriver1());
        frndCoinPage1.clickOnNienetyCoinPackage(getDriver1());
        paymentPage1.selectFrndAppPaymentMethod(getDriver1());
        paymentPage1.clickOnGooglePayIcon(getDriver1());
        paymentPage1.enterOTPAndMakePayment(getDriver1(), "111000");
        trainingRoomPage1.clickOnIAgreeButton(getDriver1());
        homePage1.clickOnCoins(getDriver1());
        frndCoinPage1.clickOnNienetyCoinPackage(getDriver1());
        paymentPage1.selectFrndAppPaymentMethod(getDriver1());
        paymentPage1.clickOnGooglePayIcon(getDriver1());
        paymentPage1.enterOTPAndMakePayment(getDriver1(), "111000");
        trainingRoomPage1.clickOnIAgreeButton(getDriver1());
        String availableCoin =  homePage1.getAvailableCoin(getDriver1());
        homePage1.clickOnTrainingTab(getDriver1());
        trainingRoomPage1.checkCoinAndEnterRoom(availableCoin,"90",getDriver1());
        hostedAudioCallPage2.clickOnGameIcon(getDriver2());
        hostedAudioCallPage2.clickOnGamePopupCrossButton(getDriver2());
        hostedAudioCallPage1.clickOnGameIcon(getDriver1());
        hostedAudioCallPage1.clickOnGamePopupCrossButton(getDriver1());
        Thread.sleep(60000);
        hostedVideoCallPage1.CheckIfInGameRechargeReminderBottonSheetShouldDisplayOnLastThreeMins(getDriver1());
        hostedVideoCallPage1.callTimerTextShouldShowInRedColourOnlyWhenUserIsInHisLastThreeMinOfVoiceCall(getDriver1());
        hostedVideoCallPage1.checkIfTheTimerCountdownShouldShowOnTheBottomSheetForLastThirdMin(getDriver1());
        hostedVideoCallPage1.checkIfAddCoinxxOptionButtonAmountShouldChangeAsPerSelectedOutOfTheThreeTimeMins(getDriver1());
        Thread.sleep(20000);
        hostedVideoCallPage1.verifyCannotAddExtraTimeInBottomSheetInLastMinuteemainingInVideoCall(getDriver1());
    }
}
