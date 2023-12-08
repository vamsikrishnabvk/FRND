package com.QA.Test;

import com.QA.Base.BaseTest2;

public class DemoClass extends BaseTest2 {

//    LandingPage1 landingPage1;
//    LandingPage1 landingPage2;
//
//    HomePage1 homePage1;
//    HomePage2 homePage2;
//    PrivateTrainingRoomPage1 privateTrainingRoomPage1;
//    PrivateTrainingRoomPage2 privateTrainingRoomPage2;
//    SelectTagScreenPage1 selectTagScreenPage1;
//    HostVivoCallPage1 hostVivoCallPage1;
//    HostVivoCallPage2 hostVivoCallPage2;
//
//    ProfilePage1 profilePage1;
//
//    TestUtils utils = new TestUtils();
//
//    JSONObject LoginDetails;
//
//    @BeforeClass
//    public void beforeClass() throws Exception {
//        InputStream datais = null;
//        try {
//            String dataFileName = "data/loginDetails.json";
//            datais = getClass().getClassLoader().getResourceAsStream(dataFileName);
//            JSONTokener tokener = new JSONTokener(datais);
//            LoginDetails = new JSONObject(tokener);
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw e;
//        } finally {
//            if (datais != null) {
//                datais.close();
//            }
//        }
//        //    closeApp();
//        //    launchApp();
//    }
//
//    @AfterClass
//    public void afterClass() {
//        getDriver1().quit();
//        getDriver2().quit();
//    }
//
//    @BeforeMethod
//    public void beforeMethod(Method m) {
//        utils.log().info("\n" + "****** starting test:" + m.getName() + "******" + "\n");
//        landingPage1 = new LandingPage1(getDriver1());
//        homePage1 = new HomePage1();
//        privateTrainingRoomPage1 = new PrivateTrainingRoomPage1();
//        selectTagScreenPage1 = new SelectTagScreenPage1();
//        landingPage2 = new LandingPage1(getDriver2());
//        homePage2 = new HomePage2();
//        privateTrainingRoomPage2 = new PrivateTrainingRoomPage2();
//        hostVivoCallPage1 = new HostVivoCallPage1();
//        hostVivoCallPage2 = new HostVivoCallPage2();
//        profilePage1 = new ProfilePage1();
//    }
//
//    @AfterMethod
//    public void afterMethod() {
//        closeApp(getDriver1());
//        launchApp(getDriver1());
//       closeApp(getDriver1());
//        closeApp(getDriver2());
////        getDriver().activateApp("com.dating.for.all");
//    }
//
//    @Test(priority = 1, enabled = true, description = "LT-01: Verify User able to Host Voice call")
//    public void verifyUserAbleToHostVoiceCall() throws InterruptedException {
//        String phoneNumber = LoginDetails.getJSONObject("LoginDetails").getString("phoneNumber");
//        String otp = LoginDetails.getJSONObject("LoginDetails").getString("otp");
//        Thread.sleep(15000);
//      //  landingPage.KEYCODE_VOLUME_DOWN1();
//        landingPage1.clickOnLetsGoButton(getDriver1());
//        landingPage2.clickOnLetsGoButton(getDriver2());
//        landingPage1.enterMobileNumber1(phoneNumber);
//        landingPage2.enterMobileNumber2("7725924830");
//        landingPage1.clickOnGetOTPButton1();
//        landingPage2.clickOnGetOTPButton2();
//        Thread.sleep(3000);
//        landingPage1.enterOTPNumber1(otp);
//        landingPage2.enterOTPNumber2(otp);
//        landingPage1.clickOnSubmitButton1();
//        landingPage2.clickOnSubmitButton2();
//        homePage1.handlingPopup1();
//        homePage2.handlingPopup2();
//        String text = homePage2.getAvailableCoin2();
//        homePage1.clickOnTrainingTab1();
//        homePage2.clickOnTrainingTab2();
//        privateTrainingRoomPage1.clickOnPlusIcon1();
//        privateTrainingRoomPage1.clickOnCreateRoomIcon1();
//        privateTrainingRoomPage1.clickOnAudioRoomButton1();
//        selectTagScreenPage1.clickOnLoveTag1();
//        selectTagScreenPage1.verifyUerAbleToHost1();
////        landingPage.KEYCODE_VOLUME_DOWN();
//        privateTrainingRoomPage2.checkCoinAndEnterRoom2(text,"20");
//        hostVivoCallPage2.clickOnGiftBox2();
//        Thread.sleep(240000);
//        hostVivoCallPage1.clickOnExitButton1();
//        privateTrainingRoomPage1.clickOnProfileIcon();
//        profilePage1.clikcOnWinMoneyButton();
    }

