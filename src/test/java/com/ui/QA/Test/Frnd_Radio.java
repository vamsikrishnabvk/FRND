package com.ui.QA.Test;

import com.QA.API.ApiUdateData;
import com.QA.Base.BaseTest;
import com.QA.DataBase.FetchValue;
import com.QA.Pages.*;
import com.QA.utlis.TestUtils;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class Frnd_Radio extends BaseTest {

    LandingPage landingPage1, landingPage2;
    HomePage homePage1, homePage2;
    PrivateTrainingRoomPage trainingRoomPage1, trainingRoomPage2;
    SelectTagScreenPage tagScreenPage1, tagScreenPage2;
    HostedAudioCallPage hostedAudioCallPage1,hostedAudioCallPage2;
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
    @Test(priority = 0, enabled = true, description = "LT-01: Verify User able to Host Voice call")
    public void verifyIfTheUserShouldBeAbleToSendGiftsAndCommentDuringTheRadioShow()
    {

    }
}
