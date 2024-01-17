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
    @Test(priority = 0, enabled = false, description = "LT-01: Verify User able to Host Voice call")
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
    public void paymentThroughUPI() throws InterruptedException {
       // String phoneNumber = LoginDetails.getJSONObject("LoginDetails").getString("phoneNumber");
      //  String otp = LoginDetails.getJSONObject("LoginDetails").getString("otp");
        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.KEYCODE_VOLUME_DOWN(getDriver1());
        landingPage1.changingPort("QA",getDriver1());
        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.loginToApplication("7890134561","000000",getDriver1());
        homePage1.handlingPopup(getDriver1());
        String availableCoin = homePage1.getAvailableCoin(getDriver1());
        homePage1.clickOnCoins(getDriver1());
        String getCoinsToBeAdded = frndCoinPage1.getCoinsToBeAdded(getDriver1());
        frndCoinPage1.clickOnCoinPackOption(getDriver1());
        paymentPage1.selectFrndAppPaymentMethod(getDriver1());
        paymentPage1.clickOnGooglePayIcon(getDriver1());
        paymentPage1.enterOTPAndMakePayment(getDriver1(),"111000");
        trainingRoomPage1.clickOnIAgreeButton(getDriver1());
        String coinsAfterPayement = homePage1.getAvailableCoin(getDriver1());
        homePage1.verifyCoinsAddedAfterPayment(availableCoin,coinsAfterPayement,getCoinsToBeAdded);
        homePage1.clickOnCoins(getDriver1());
        String getCoinsToBeAdded1 = frndCoinPage1.getCoinsToBeAdded(getDriver1());
        frndCoinPage1.clickOnCoinPackOption(getDriver1());
        paymentPage1.selectFrndAppPaymentMethod(getDriver1());
        paymentPage1.clickOnPhonePayIcon(getDriver1());
        paymentPage1.enterOTPAndMakePayment(getDriver1(),"111000");
        trainingRoomPage1.clickOnIAgreeButton(getDriver1());
        String coinsAfterPayement1 = homePage1.getAvailableCoin(getDriver1());
        homePage1.verifyCoinsAddedAfterPayment(coinsAfterPayement,coinsAfterPayement1,getCoinsToBeAdded1);
        homePage1.clickOnCoins(getDriver1());
        String getCoinsToBeAdded2 = frndCoinPage1.getCoinsToBeAdded(getDriver1());
        frndCoinPage1.clickOnCoinPackOption(getDriver1());
        paymentPage1.selectFrndAppPaymentMethod(getDriver1());
        paymentPage1.clickBhimPayICon(getDriver1());
        paymentPage1.enterOTPAndMakePayment(getDriver1(),"111000");
        trainingRoomPage1.clickOnIAgreeButton(getDriver1());
        String coinsAfterPayement2 = homePage1.getAvailableCoin(getDriver1());
        homePage1.verifyCoinsAddedAfterPayment(coinsAfterPayement1,coinsAfterPayement2,getCoinsToBeAdded2);
        homePage1.clickOnCoins(getDriver1());
        String getCoinsToBeAdded3 = frndCoinPage1.getCoinsToBeAdded(getDriver1());
        frndCoinPage1.clickOnCoinPackOption(getDriver1());
        paymentPage1.selectFrndAppPaymentMethod(getDriver1());
        paymentPage1.makePaymentThroughUPIID(getDriver1(),"testtpvsuccess@gocash");
        trainingRoomPage1.clickOnIAgreeButton(getDriver1());
        String coinsAfterPayement3 = homePage1.getAvailableCoin(getDriver1());
        homePage1.verifyCoinsAddedAfterPayment(coinsAfterPayement2,coinsAfterPayement3,getCoinsToBeAdded3);
        homePage1.clickOnCoins(getDriver1());
        String getCoinsToBeAdded4 = frndCoinPage1.getCoinsToBeAdded(getDriver1());
        frndCoinPage1.clickOnCoinPackOption(getDriver1());
        paymentPage1.selectFrndAppPaymentMethod(getDriver1());
        paymentPage1.makePaymentThroughCard(getDriver1(),"Test","4706131211212123","03/28","123","111000");
        trainingRoomPage1.clickOnIAgreeButton(getDriver1());
        String coinsAfterPayement4 = homePage1.getAvailableCoin(getDriver1());
        homePage1.verifyCoinsAddedAfterPayment(coinsAfterPayement3,coinsAfterPayement4,getCoinsToBeAdded4);
    }

    @Test(enabled = false)
    public void verifyThatCoinsShouldBeAddedProperlyInUserCoinWalletAfterSuccesfullyPurchaseTheCoins1() throws InterruptedException {
        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.KEYCODE_VOLUME_DOWN(getDriver1());
        landingPage1.changingPort("8081",getDriver1());
        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.loginToApplication("7725924830","000000",getDriver1());
        homePage1.handlingPopup(getDriver1());
        String availableCoin = homePage1.getAvailableCoin(getDriver1());
        homePage1.clickOnCoins(getDriver1());
        String getCoinsToBeAdded = frndCoinPage1.getCoinsToBeAdded(getDriver1());
        frndCoinPage1.clickOnCoinPackOption(getDriver1());
        paymentPage1.makePaymentThroughCard(getDriver1(),"Test","4706131211212123","03/28","123","111000");
        String coinsAfterPayment = homePage1.getAvailableCoin(getDriver1());
        homePage1.verifyCoinsAddedAfterPayment(availableCoin,coinsAfterPayment,getCoinsToBeAdded);
    }

    @Test(enabled = true)
    public void verifyThatBehaviorOfAppAfterCancelTheAnyTransction() throws InterruptedException {
        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.KEYCODE_VOLUME_DOWN(getDriver1());
        landingPage1.changingPort("QA",getDriver1());
        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.loginToApplication("7890134561","000000",getDriver1());
        homePage1.handlingPopup(getDriver1());
        String availableCoin = homePage1.getAvailableCoin(getDriver1());
        homePage1.clickOnCoins(getDriver1());
        String getCoinsToBeAdded = frndCoinPage1.getCoinsToBeAdded(getDriver1());
        frndCoinPage1.clickOnCoinPackOption(getDriver1());
        paymentPage1.selectFrndAppPaymentMethod(getDriver1());
        paymentPage1.clickOnGooglePayIcon(getDriver1());
        paymentPage1.failTheAppTransaction(getDriver1());
        frndCoinPage1.clickOnCoinPackOption(getDriver1());
        paymentPage1.clickOnChangePaymentMode1(getDriver1());
        paymentPage1.clickOnPhonePayIcon(getDriver1());
        paymentPage1.failTheAppTransaction(getDriver1());
        frndCoinPage1.clickOnCoinPackOption(getDriver1());
        paymentPage1.clickOnChangePaymentMode1(getDriver1());
        paymentPage1.clickBhimPayICon(getDriver1());
        paymentPage1.failTheAppTransaction(getDriver1());
        frndCoinPage1.clickOnCoinPackOption(getDriver1());
        paymentPage1.clickOnChangePaymentMode1(getDriver1());
        paymentPage1.failUpiIDPayment(getDriver1(),"testtpvsuccess@gocash");
        frndCoinPage1.clickOnCoinPackOption(getDriver1());
        paymentPage1.clickOnChangePaymentMode1(getDriver1());
        paymentPage1.enterCardDetails(getDriver1(),"Test","4706131211212123","03/28","123");
       // paymentPage1.failTheAppTransaction(getDriver1());
        paymentPage1.verifyFailCardPayment(getDriver1());
    }

    @Test(enabled = true)
    public void verifyThatDiscountCouponIsAppliedProperlyWhileAppliedTheCoupons() throws InterruptedException {
        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.KEYCODE_VOLUME_DOWN(getDriver1());
        landingPage1.changingPort("QA",getDriver1());
        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.loginToApplication("7890134561","000000",getDriver1());
        homePage1.handlingPopup(getDriver1());
        String availableCoin = homePage1.getAvailableCoin(getDriver1());
        homePage1.clickOnCoins(getDriver1());
        String actualPrice = paymentPage1.getActualPrice(getDriver1());
        frndCoinPage1.clickOnCoinPackageOption(getDriver1());
        paymentPage1.selectFrndAppPaymentMethod(getDriver1());
        paymentPage1.verifyCoupounApplied(getDriver1(),"LOVE50",actualPrice);
        String finalPrice = paymentPage1.getFinalPrice(getDriver1());
        paymentPage1.clickOnPhonePayIcon(getDriver1());
        paymentPage1.enterOTPAndMakePayment(getDriver1(),"111000");
        trainingRoomPage1.clickOnIAgreeButton(getDriver1());
        trainingRoomPage1.clickOnProfileIcon(getDriver1());
        profilePage1.clickOnHamburgerMenu(getDriver1());
        profilePage1.verifyTransation(getDriver1(),finalPrice);
    }

    @Test(enabled = true)
    public void checkWithAllAvailableDiscountCouponsTransactions() throws InterruptedException {
        landingPage2.handlingUpdatePopup(getDriver2());
        landingPage2.KEYCODE_VOLUME_DOWN(getDriver2());
        landingPage2.changingPort("QA",getDriver2());
        landingPage2.loginToApplication("7890134561","000000",getDriver2());
        homePage2.handlingPopup(getDriver2());
        homePage2.clickOnTrainingTab(getDriver2());
        trainingRoomPage2.clickOnPlusIcon(getDriver2());
        trainingRoomPage2.clickOnCreateRoomIcon(getDriver2());
        trainingRoomPage2.clickOnVideoRoomButton(getDriver2());
        tagScreenPage2.clickOnLoveTag(getDriver2());
        tagScreenPage2.verifyUerAbleToHost(getDriver2());
        landingPage1.handlingUpdatePopup(getDriver1());
        landingPage1.KEYCODE_VOLUME_DOWN(getDriver1());
        landingPage1.changingPort("QA",getDriver1());
        int i = getRandomNum();
        String phonNum = "789012"+Integer.toString(i);
        landingPage1.clickOnLetsGoButton(getDriver1());
        landingPage1.enterMobileNumber(phonNum,getDriver1());
        landingPage1.clickOnGetOTPButton(getDriver1());
        landingPage1.enterOTPNumber("000000",getDriver1());
        landingPage1.clickOnSubmitButton(getDriver1());
        landingPage1.enterNickName(getDriver1(),"Daniel");
        landingPage1.clickOnSelectGenderButton(getDriver1());
        landingPage1.clickOnBoyGender(getDriver1());
        landingPage1.clickOnDateOfBirthButtonAndOkButton(getDriver1());
        landingPage1.clickOnSignInSubmitButton(getDriver1());
        landingPage1.selectLanguage(getDriver1());
        landingPage1.checkCyberManifestoPolicies(getDriver1());
        landingPage1.selectAppLanguage(getDriver1());
        homePage1.handlingPopup(getDriver1());
        String text = homePage1.getAvailableCoin(getDriver1());
        homePage1.clickOnTrainingTab(getDriver1());
        trainingRoomPage1.checkCoinAndEnterRoom(text,"90",getDriver1());
        vivoCallPage1.verifyDiscountLabel(getDriver1());
        paymentPage1.clickOnChangePaymentMode(getDriver1());
        int discountedValue = paymentPage1.getDiscountValue(getDriver1());
        paymentPage1.verifyDefaultDiscountApplied(getDriver1());
        paymentPage1.clickOnPhonePayIcon(getDriver1());
        paymentPage1.enterOTPAndMakePayment(getDriver1(),"111000");
        trainingRoomPage1.handleHostedRoomPopup(getDriver1());
        Thread.sleep(90000);
        vivoCallPage1.clickOnStarRating(getDriver1());
        vivoCallPage1.giveReviewMessage(getDriver1());
        vivoCallPage1.clickOnSubmitButton(getDriver1());
        vivoCallPage1.shareAppExperienceRating(getDriver1());
        trainingRoomPage1.clickOnProfileIcon(getDriver1());
        profilePage1.clickOnHamburgerMenu(getDriver1());
        profilePage1.verifyTransation(getDriver1(),Integer.toString(discountedValue));
        clickBackButton(getDriver1());
        clickBackButton(getDriver1());
        String text1 = homePage1.getAvailableCoin(getDriver1());
        homePage1.clickOnTrainingTab(getDriver1());
        trainingRoomPage1.checkCoinAndEnterRoom(text1,"20",getDriver1());
        vivoCallPage1.verifyDiscountLabel(getDriver1());
        paymentPage1.clickOnChangePaymentMode(getDriver1());
        int discountedValue1 = paymentPage1.getDiscountValue(getDriver1());
        paymentPage1.verifyDefaultDiscountApplied(getDriver1());
        paymentPage1.clickOnPhonePayIcon(getDriver1());
        paymentPage1.enterOTPAndMakePayment(getDriver1(),"111000");
        trainingRoomPage1.handleHostedRoomPopup(getDriver1());
        Thread.sleep(90000);
        vivoCallPage1.clickOnStarRating(getDriver1());
        vivoCallPage1.giveReviewMessage(getDriver1());
        vivoCallPage1.clickOnSubmitButton(getDriver1());
      //  vivoCallPage1.shareAppExperienceRating(getDriver1());
        trainingRoomPage1.clickOnProfileIcon(getDriver1());
        profilePage1.clickOnHamburgerMenu(getDriver1());
        profilePage1.verifyTransation(getDriver1(),Integer.toString(discountedValue1));
    }
}