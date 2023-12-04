package com.QA.Test;

import com.QA.Base.BaseTest;

public class LoginTest extends BaseTest {

//
//	LandingPage landingPage;
//	HomePage homePage;
//	PrivateTrainingRoomPage trainingRoomPage;
//	SelectTagScreenPage tagScreenPage;
//	JSONObject LoginDetails;
//	TestUtils utils = new TestUtils();
//
//	@BeforeClass
//	public void beforeClass() throws Exception {
//		InputStream datais = null;
//		try {
//			String dataFileName = "data/loginDetails.json";
//			datais = getClass().getClassLoader().getResourceAsStream(dataFileName);
//			JSONTokener tokener = new JSONTokener(datais);
//			LoginDetails = new JSONObject(tokener);
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw e;
//		} finally {
//			if (datais != null) {
//				datais.close();
//			}
//		}
//		//closeApp();
//		//launchApp();
//	}
//
//	@AfterClass
//	public void afterClass() {
//	}
//
//	@BeforeMethod
//	public void beforeMethod(Method m) {
//		utils.log().info("\n" + "****** starting test:" + m.getName() + "******" + "\n");
//		landingPage = new LandingPage(getD);
//		homePage = new HomePage();
//		trainingRoomPage = new PrivateTrainingRoomPage();
//		tagScreenPage = new SelectTagScreenPage();
//	}
//
//	@AfterMethod
//	public void afterMethod() {
//		closeApp();
//		launchApp();
//
//	}

//-------------------------- Test Below -----------------------------------------

//	@Test(priority = 2, enabled = true,description = "LT-02: Verify Login without entering password")
//	public void LoginWithoutPassword() throws InterruptedException {
//        String email = LoginDetails.getJSONObject("LoginDetails").getString("Email");
//		landingPage.clickSignIn();
//		loginPage.verifyLoginPage();
//		loginPage.clickOnEmailTextBox();
//		loginPage.enterEmail(email);
//		loginPage.disableSignInButton();
//	}
//@Test(priority = 3, enabled = true,description = "LT-02: Verify Login with Incorrectpassword")
//public void LoginWithWrongPassword() throws InterruptedException {
//	String email = LoginDetails.getJSONObject("LoginDetails").getString("Email");
//	String wrongPassword = LoginDetails.getJSONObject("LoginDetails").getString("wrongPassword");
//	landingPage.clickSignIn();
//	loginPage.verifyLoginPage();
//	loginPage.loginToPetzbe(email,wrongPassword);
//	loginPage.getTextErrorPopup();
//}

//	@Test(priority = 3, enabled = true,description = "LT-02: Verify Login with Incorrectpassword")
//	public void LoginButtonDisabledUntillCredentialNOtFilled() throws InterruptedException {
//		String email = LoginDetails.getJSONObject("LoginDetails").getString("Email");
//		String password = LoginDetails.getJSONObject("LoginDetails").getString("Password");
//		landingPage.clickSignIn();
//		loginPage.verifyLoginPage();
//		// Verify that the Login button is initially disabled
//		loginPage.verifyLoginButtonDisabled();
//		loginPage.enterEmail(email);
//		loginPage.enterPassword(password);
//		// Verify that the Login button is enabled after entering the email ID and password
//		loginPage.verifyLoginButtonEnabled();
//	}

}




