package com.QA.Test;

import com.QA.Base.BaseTest;
import com.QA.Pages.*;
import com.QA.utlis.TestUtils;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.*;

import java.io.InputStream;
import java.lang.reflect.Method;

public class PaymentTest extends BaseTest {

    LandingPage landingPage1,landingPage2;
    HomePage homePage1,homePage2;
    PrivateTrainingRoomPage trainingRoomPage1,trainingRoomPage2;
    SelectTagScreenPage tagScreenPage1,tagScreenPage2;
    HostedAudioCallPage vivoCallPage1,vivoCallPage2;
    JSONObject LoginDetails;
    ProfilePage profilePage1,profilePage2;
    FrndCoinPage frndCoinPage1,frndCoinPage2;
    TestUtils utils = new TestUtils();
    PaymentPage paymentPage1, paymentPage2;

    @BeforeClass
    public void beforeClass() throws Exception {
        InputStream datais = null;
        try {
            String dataFileName = "data/loginDetails.json";
            datais = getClass().getClassLoader().getResourceAsStream(dataFileName);
            JSONTokener tokener = new JSONTokener(datais);
            LoginDetails = new JSONObject(tokener);
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

    //-------------------------- Test Below -----------------------------------------
    @Test(priority = 0, enabled = true, description = "LT-01: Verify User able to Host Voice call")
    public void verifyThatCoinsShouldBeAddedProperlyInUserCoinWalletAfterSuccesfullyPurchaseTheCoins() throws InterruptedException {
        String phoneNumber = LoginDetails.getJSONObject("LoginDetails").getString("phoneNumber");
        String otp = LoginDetails.getJSONObject("LoginDetails").getString("otp");
        Thread.sleep(8000);
        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.KEYCODE_VOLUME_DOWN(getDriver1());
   //     landingPage1.changingPort(getDriver1());
        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.loginToApplication(phoneNumber,otp,getDriver1());
        homePage1.handlingPopup(getDriver1());
        String availableCoin = homePage1.getAvailableCoin(getDriver1());
        homePage1.clickOnCoins(getDriver1());
        String getCoinsToBeAdded = frndCoinPage1.getCoinsToBeAdded(getDriver1());
        frndCoinPage1.clickOnCoinPackOption(getDriver1());
      //  paymentPage1.clickOnGooglePayIcon(getDriver1());
        paymentPage1.makePaymentThroughGpay(getDriver1());
        String coinsAfterPayement = homePage1.getAvailableCoin(getDriver1());
        homePage1.verifyCoinsAddedAfterPayment(availableCoin,coinsAfterPayement,getCoinsToBeAdded);
    }

    @Test(priority = 1, enabled = true)
    public void paymentThroughPhonePay() throws InterruptedException {
        String phoneNumber = LoginDetails.getJSONObject("LoginDetails").getString("phoneNumber");
        String otp = LoginDetails.getJSONObject("LoginDetails").getString("otp");
        Thread.sleep(8000);
        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.KEYCODE_VOLUME_DOWN(getDriver1());
   //     landingPage1.changingPort(getDriver1());
        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.loginToApplication(phoneNumber,otp,getDriver1());
        homePage1.handlingPopup(getDriver1());
        String availableCoin = homePage1.getAvailableCoin(getDriver1());
        homePage1.clickOnCoins(getDriver1());
        String getCoinsToBeAdded = frndCoinPage1.getCoinsToBeAdded(getDriver1());
        frndCoinPage1.clickOnCoinPackOption(getDriver1());
        paymentPage1.makePaymentThroughPhonePay(getDriver1());
        String coinsAfterPayement = homePage1.getAvailableCoin(getDriver1());
        homePage1.verifyCoinsAddedAfterPayment(availableCoin,coinsAfterPayement,getCoinsToBeAdded);
    }

    public void paymentThroughBhimUpi()
    {

    }
}