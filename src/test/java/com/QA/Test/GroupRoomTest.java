package com.QA.Test;

import com.QA.Base.BaseTest;
import com.QA.Pages.*;
import com.QA.utlis.TestUtils;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.*;

import java.io.InputStream;
import java.lang.reflect.Method;

public class GroupRoomTest extends BaseTest {

    LandingPage landingPage1, landingPage2;
    HomePage homePage1, homePage2;
    PrivateTrainingRoomPage trainingRoomPage1, trainingRoomPage2;
    SelectTagScreenPage tagScreenPage1, tagScreenPage2;
    HostedAudioCallPage vivoCallPage1, vivoCallPage2;
    JSONObject GroupRoomTest;
    ProfilePage profilePage1, profilePage2;

    GroupRoomPage groupRoomPage1, groupRoomPage2;

    GroupRoomHostedPage groupRoomHostedPage1, groupRoomHostedPage2;
    TestUtils utils = new TestUtils();

    @BeforeClass
    public void beforeClass() throws Exception {
        InputStream datais = null;
        try {
            String dataFileName = "data/groupRoomTest.json";
            datais = getClass().getClassLoader().getResourceAsStream(dataFileName);
            JSONTokener tokener = new JSONTokener(datais);
            GroupRoomTest = new JSONObject(tokener);
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
        groupRoomPage1 = new GroupRoomPage(getDriver1());
        groupRoomPage2 = new GroupRoomPage(getDriver2());
        groupRoomHostedPage1 = new GroupRoomHostedPage(getDriver1());
        groupRoomHostedPage2 = new GroupRoomHostedPage(getDriver2());
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
    public void groupRoomTest() throws InterruptedException {
        String phoneNumber1 = GroupRoomTest.getJSONObject("GroupRoomTest").getString("phoneNumberDev1");
        String otp = GroupRoomTest.getJSONObject("GroupRoomTest").getString("otp");
        String phoneNumber2 = GroupRoomTest.getJSONObject("GroupRoomTest").getString("phoneNumberDev2");
        String portNumber = GroupRoomTest.getJSONObject("GroupRoomTest").getString("portNumber");
        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.KEYCODE_VOLUME_DOWN(getDriver1());
        landingPage1.changingPort(portNumber, getDriver1());
        landingPage2.handlingUpdatePopup(getDriver2());
        landingPage2.KEYCODE_VOLUME_DOWN(getDriver2());
        landingPage2.changingPort(portNumber, getDriver2());
        landingPage1.loginToApplication(phoneNumber2, otp, getDriver1());
        landingPage2.loginToApplication(phoneNumber1, otp, getDriver2());
        homePage1.handlingPopup(getDriver1());
        homePage2.handlingPopup(getDriver2());
        homePage1.clickOnHomeTab(getDriver1());
        homePage1.clickOnGroupRoom(getDriver1());
        groupRoomPage1.verifyUserHostTheRoom(getDriver1());
        groupRoomPage1.exitGroupRoom(getDriver1());
        groupRoomPage1.verifyUserHostTheRoom(getDriver1());
        homePage2.clickOnHomeTab(getDriver2());
        homePage2.clickOnGroupRoom(getDriver2());
        groupRoomPage2.joinGroupRoom(getDriver2());
        groupRoomPage2.exitGroupRoom(getDriver2());
        groupRoomPage2.verifyUserExitRoom(getDriver2());
        String availableCoin = groupRoomPage2.getCoins(getDriver2());
        groupRoomPage2.joinGroupRoom(getDriver2());
        groupRoomPage2.verifyUserSendGiftToHost(availableCoin, getDriver2());
        groupRoomHostedPage1.verifyHostMuteUnmuteFunctionality(getDriver1());
        groupRoomHostedPage1.verifyUserMuteUnmuteFunctionality(getDriver1());
        groupRoomHostedPage1.hostRemoveUser(getDriver1());
        groupRoomPage2.verifyUserExitRoom(getDriver2());
        String remainingCoin = groupRoomPage2.getCoins(getDriver2());
        groupRoomPage2.checkCoinsDeducted(availableCoin, remainingCoin, getDriver2());
        groupRoomPage2.joinGroupRoom(getDriver2());
    }

    @Test(priority = 1, enabled = true)
    public void checkUserJoinWithZeroBalance() throws InterruptedException {
        String phoneNumber = GroupRoomTest.getJSONObject("GroupRoomTest").getString("phoneNumberDev2");
        String otp = GroupRoomTest.getJSONObject("GroupRoomTest").getString("otp");
        String partialNum = GroupRoomTest.getJSONObject("GroupRoomTest").getString("partialPhNo");
        String nickName = GroupRoomTest.getJSONObject("GroupRoomTest").getString("nickName");
        String nickName2 = GroupRoomTest.getJSONObject("GroupRoomTest").getString("nickName1");
        String baseUri = GroupRoomTest.getJSONObject("GroupRoomTest").getString("baseUri");
        String endPoints = GroupRoomTest.getJSONObject("GroupRoomTest").getString("endPoint");
        String portNumber = GroupRoomTest.getJSONObject("GroupRoomTest").getString("portNumber");
        landingPage2.handlingUpdatePopup(getDriver2());
        landingPage2.KEYCODE_VOLUME_DOWN(getDriver2());
        landingPage2.changingPort(portNumber, getDriver2());
        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.KEYCODE_VOLUME_DOWN(getDriver1());
        landingPage1.changingPort(portNumber, getDriver1());
        int i = getRandomNum();
        String phonNum = partialNum + Integer.toString(i);
        landingPage2.clickOnLetsGoButton(getDriver2());
        landingPage2.enterMobileNumber(phonNum, getDriver1());
        landingPage2.clickOnGetOTPButton(getDriver2());
        landingPage2.enterOTPNumber(otp, getDriver2());
        landingPage2.clickOnSubmitButton(getDriver2());
        landingPage2.enterNickName(getDriver2(), nickName);
        landingPage2.clickOnSelectGenderButton(getDriver1());
        landingPage2.clickOnBoyGender(getDriver2());
        landingPage2.clickOnDateOfBirthButtonAndOkButton(getDriver2());
        landingPage2.clickOnSignInSubmitButton(getDriver2());
        landingPage2.selectLanguage(getDriver2());
        landingPage2.checkCyberManifestoPolicies(getDriver2());
        landingPage2.selectAppLanguage(getDriver2());
        homePage2.handlingPopup(getDriver2());
        landingPage1.loginToApplication(phoneNumber, otp, getDriver1());
        homePage1.handlingPopup(getDriver1());
        homePage1.clickOnHomeTab(getDriver1());
        homePage1.clickOnGroupRoom(getDriver1());
        groupRoomPage1.verifyUserHostTheRoom(getDriver1());
        homePage2.clickOnHomeTab(getDriver2());
        homePage2.clickOnGroupRoom(getDriver2());
        groupRoomPage2.verifyUserAbleToJoinWIth0Bal(getDriver2());
        groupRoomHostedPage1.hostBanTheUser(getDriver1());
        groupRoomHostedPage2.checkUserGetWarning(getDriver2());
        groupRoomPage2.verifyUserBanned(getDriver2(), "No game available right now");
    }
}
