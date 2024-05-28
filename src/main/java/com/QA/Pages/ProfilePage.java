package com.QA.Pages;

import com.QA.Base.BaseTest;
import com.QA.reports.ExtentReport;
import com.QA.utlis.TestUtils;
import com.aventstack.extentreports.Status;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class ProfilePage extends BaseTest {

    public ProfilePage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    TestUtils utils = new TestUtils();

    @AndroidFindBy(id = "com.dating.for.all.debug:id/redeemNow")
    private List<MobileElement> winMoneyButton;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/redeemProgressDismiss")
    private MobileElement okayButton;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/withdraw")
    private MobileElement withDrawButton;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"mobile_number_text_field\"]/android.view.View/android.view.View[2]")
    private MobileElement mobileNumberField;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\" PhonePe ,Gpay, Paytm, UPI no.\"]")
    private MobileElement mobileNumberField2;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"mobile_number_text_field\"]")
    private MobileElement mobileNumberTextField;

    @AndroidFindBy(xpath = "//android.widget.Button")
    private MobileElement submitButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Enter UPI ID Manually\"]")
    private MobileElement enterUpiIdManuallyButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Enter your UPI ID\"]/following-sibling::android.widget.EditText")
    private MobileElement enterUpiIdField;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"Your UPI Id\"]/../android.widget.EditText)[1]")
    private MobileElement yourUpiIdField;

    @AndroidFindBy(xpath = "//android.widget.Button")
    private MobileElement upiSubmitButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Withdrawal Amount\"]/following-sibling::android.view.View//android.widget.TextView[contains(@text,\"Withdraw\")]")
    private MobileElement withDrawAmountButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Withdrawn successfully to your\n" +
            " bank account\"]")
    private MobileElement withDrawSuccessMessage;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/totalRemaningAmountTv")
    private MobileElement totalRemainingAmount;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Edit\"]")
    private MobileElement editButton;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/addfrndIcon")
    private MobileElement addFrndIcon;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/redeemProcessTitle")
    private MobileElement congratulationsMessage;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/redeemProcessSubtitle")
    private MobileElement yellowRoseRewardMessage;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/yrInfo")
    private List<MobileElement> noRoseCollectedMessage;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/yellowRoseCount")
    private List<MobileElement> yellowRoseCount;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/yellowRoseHeadTv")
    private List<MobileElement> yellowRoseHead;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/yrInfo")
    private MobileElement yellowRoseInfo;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Followers\"]")
    private MobileElement followersLabel;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/title")
    private MobileElement title;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/walletMoney")
    private MobileElement walletMoney;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"You've hit your daily withdrawal limit. Please try again tomorrow!\"]")
    private MobileElement withDrawLimitMessage;

    @AndroidFindBy(xpath = "//android.widget.Toast[@text=\"UPI id is already registered with us\"]")
    private MobileElement upiRegisteredMessage;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"UPI ID in use\"]")
    private MobileElement upiIdInUseMessage;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/walletCoins")
    private MobileElement walletCoins;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/menuBiv")
    public MobileElement hamburgerMenu;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Transactions\"]")
    public MobileElement transactionTab;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@resource-id=\"com.dating.for.all.debug:id/commentsTv\"]/following-sibling::android.widget.TextView)[1]")
    private MobileElement transactionDiscountPrice;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/timeTv")
    private MobileElement transactionStatus;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Enter your Full name as on PAN card\"]/preceding-sibling::android.widget.EditText")
    private MobileElement nameField;

    @AndroidFindBy(xpath= "//android.widget.TextView[@text=\"Name\"]/parent::android.view.View")
    private MobileElement parentNameField;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"Please enter 10-digit PAN number\"]/preceding-sibling::android.widget.EditText)[2]")
    private MobileElement panField;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"PAN\"]/parent::android.view.View")
    private MobileElement parentPanField;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Submit\"]")
    private MobileElement kycSubmitButton;

    @AndroidFindBy(id = "com.dating.for.all.debug:id/kycVerifiedLabelTv")
    private List<MobileElement> kycVerifiedLabel;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"1% TDS deduction\"]")
    private MobileElement onePercentTdsLabel;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"5% TDS deduction\"]")
    private MobileElement fivePercentTdsLabel;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,\"TDS deduction\")]/following-sibling::android.widget.TextView")
    private MobileElement tdsDeductAmount;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Used by another user. Please enter new PAN number.\"]")
    private MobileElement panErrorMessage;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Win money from yellow rose\"]")
    private List<MobileElement> winMoneyYellowRoseLabel;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/settings")
    public MobileElement settingIcon;
    @AndroidFindBy(id = "com.dating.for.all.debug:id/logoutCl")
    public MobileElement logOutButton;

    //*********************** End Elements *************************************************


    public void verifyToastMessageUsingPageSource(String toastmsg, AppiumDriver driver) throws InterruptedException {
        long startTime = System.currentTimeMillis(); //fetch starting time
        boolean status;
        do {
            String xmlFormat = driver.getPageSource();
            status = xmlFormat.contains(toastmsg);
            Assert.assertTrue(status, toastmsg + " is not displayed.");
        } while (!(status) && (((System.currentTimeMillis() - startTime) <= (5 * 1000))));
    }


    public int getTheYellowRoseCount(AppiumDriver driver) {
        int totalYellowRoseCount = 0;
        String yellowRosInfo = null;
        while (yellowRoseHead.size() < 1) {
            swipeScreen(Direction.LEFT, driver);
        }
        try {
            if (yellowRoseCount.get(0).isDisplayed()) {
                totalYellowRoseCount = Integer.parseInt(getText(yellowRoseCount.get(0), "get yellow rose count", driver));
            }
        }catch (Exception e)
        {

        }
        try {
            if (yellowRoseInfo.isDisplayed()) {
                yellowRosInfo = getText(yellowRoseInfo, "get yellow rose count", driver);
                System.out.println(yellowRosInfo);
                totalYellowRoseCount=0;
            }
        }catch (Exception e)
        {

        }
        return totalYellowRoseCount;

    }

    public void clikcOnWinMoneyButton(AppiumDriver driver) {
        while (winMoneyButton.size() < 1) {
            swipeScreen(Direction.LEFT, driver);
        }
        click(winMoneyButton.get(0), driver);
        ExtentReport.getTest().log(Status.INFO, "Clicked on WinMoey Button");
    }

    public void checkRedeemSuccessMessageVisibility(AppiumDriver driver) {
        waitForVisibility(congratulationsMessage, driver);
        congratulationsMessage.isDisplayed();
        yellowRoseRewardMessage.isDisplayed();
        utils.log().info("Redeem Successful message is displayed");
        ExtentReport.getTest().log(Status.INFO, "Redeem Successful message is displayed");
    }

    public void withDrawMoney(AppiumDriver driver,String phoneNumber,String upiId) throws InterruptedException {
        waitForClickable(okayButton, driver);
        click(okayButton, "Clicked on Okay Button", driver);
        if(winMoneyYellowRoseLabel.size()==1)
        {
            clickBackButton(driver);
            Thread.sleep(2000);
            click(walletMoney,driver);
        }
        waitForVisibility(totalRemainingAmount, driver);
        String text1 = getText(totalRemainingAmount, "get total amount", driver);
        int a = Integer.parseInt(text1.replace("₹", ""));
        click(withDrawButton, "Clicked on WithDraw button", driver);
        try {
            click(editButton, "Clicked on edit button", driver);
        } catch (Exception e) {

        }
        click(mobileNumberTextField,"clicked on PhoneNumber Text Field",driver);
        sendKeys(mobileNumberTextField,phoneNumber,driver);
        clickBackButton(driver);
        click(submitButton,"Clicked on Submit Button",driver);
//        click(editButton,driver);
//        click(enterUpiIdManuallyButton,driver);
//        click(enterUpiIdField,driver);
//        sendKeys(enterUpiIdField,upiId,driver);
//        clickBackButton(driver);
//        click(upiSubmitButton,driver);
        //      utils.log().info(getAttribute(upiRegisteredMessage,"name",driver));
        //   waitForVisibility(upiRegisteredMessage,driver);
        Thread.sleep(3000);
   //     verifyToastMessageUsingPageSource("UPI id is already registered with us", driver);
        //Assert.assertTrue(upiRegisteredMessage.isDiUPI id is already registered with ussplayed(),"Upi Registered message is not displayed");
        //  utils.log().info("Upi Registered message is displayed "+getText(upiRegisteredMessage,"",driver));
        click(withDrawAmountButton, "Clicked on withDrawAmount Button", driver);
      //  Assert.assertTrue(withDrawSuccessMessage.isDisplayed(), "WithDraw message is displayed");
        Thread.sleep(2000);
        clickBackButton(driver);
        waitForVisibility(totalRemainingAmount, driver);
        String text2 = getText(totalRemainingAmount, "get total amount", driver);
        int b = Integer.parseInt(text2.replace("₹", ""));
        Assert.assertTrue(b < a, "Money is not withdrawn from the account");
        ExtentReport.getTest().log(Status.INFO, "Successfully money withdrawn from the account");
    }

    public void verifyUpiIdInUseByOtherUser(AppiumDriver driver) {
        click(withDrawButton, "Clicked on WithDraw button", driver);
        try {
            click(editButton, "Clicked on edit button", driver);
        } catch (Exception e) {
        }
        click(enterUpiIdManuallyButton, " Clicked on EnterUpiIdManually Button", driver);
        click(enterUpiIdField, "Clicked Upi Id field", driver);
        sendKeys(enterUpiIdField, "aliwarsizahid-1@okicici", driver);
        clickBackButton(driver);
        click(upiSubmitButton, "Clicked on UPi submit button", driver);
        //click(withDrawAmountButton, "Clicked on withDrawAmount Button", driver);
        waitForVisibility(upiIdInUseMessage, driver);
        Assert.assertTrue(upiIdInUseMessage.isDisplayed(), "UpiId in Use message is not visible");
        utils.log().info("Verified Upi is already in Use by Some other user");
        ExtentReport.getTest().log(Status.INFO, "Verified Upi is already in Use by some other user");
    }

    public void allowYRRedeemIfYRLessThan5Yr1stTime(AppiumDriver driver, int expectedRose,String phoneNumber, String upiId) throws InterruptedException {
        int yellowRosCount = Integer.parseInt(getText(yellowRoseCount.get(0), "get yellow rose count", driver));
        if (yellowRosCount <= expectedRose) {
            Assert.assertTrue(true, "YellowRoseCount is not less than expected rose count");
            ExtentReport.getTest().log(Status.INFO, "YellowRoseCount is not less than expected rose count");
            clikcOnWinMoneyButton(driver);
            withDrawMoney(driver,phoneNumber,upiId);
            utils.log().info("Allow Yr Redeem for the first time when YR less than and equal to 5");
            ExtentReport.getTest().log(Status.INFO, "Allow Yr Redeem for the first time when YR less than and equal to 5");
        }
    }

    public void allowYrRedeemIfYrMoreThan5Yr(AppiumDriver driver, int expectedRose,String phoneNumber, String upiId) throws InterruptedException {
        int yellowRosCount = Integer.parseInt(getText(yellowRoseCount.get(0), "get yellow rose count", driver));
        if (yellowRosCount > expectedRose) {
            Assert.assertTrue(true, "YellowRoseCount is not more than expected rose count");
            clikcOnWinMoneyButton(driver);
            Thread.sleep(2000);
            withDrawMoney(driver,phoneNumber,upiId);
            utils.log().info("Allow Yr Redeem for the first time when YR more than 5");
            ExtentReport.getTest().log(Status.INFO, "Allow Yr Redeem for the first time when YR more than 5");
        }
    }

    public void verifyYrRedeemSuccess(AppiumDriver driver) throws InterruptedException {
        waitForClickable(okayButton, driver);
        click(okayButton, "Clicked on Okay Button", driver);
        clickBackButton(driver);
        Thread.sleep(2000);
        if(winMoneyYellowRoseLabel.size() == 1)
        {
            clickBackButton(driver);
        }
        while (noRoseCollectedMessage.size() < 1) {
            swipeScreen(Direction.LEFT, driver);
        }
        waitForVisibility(noRoseCollectedMessage.get(0), driver);
        noRoseCollectedMessage.get(0).isDisplayed();
        utils.log().info("Redeem is successfully done");
        ExtentReport.getTest().log(Status.INFO, "Redeem is successfully done");
    }

    public void verifyMin5RoseRequiredForRedeemForTheSecondTime(AppiumDriver driver) throws InterruptedException {
        try {
            if (totalRemainingAmount.isDisplayed()) {
                clickBackButton(driver);
            }
        } catch (Exception e) {

        }
        while (winMoneyButton.size() < 1) {
            swipeScreen(Direction.LEFT, driver);
        }
        swipeScreen(Direction.DOWN, driver);
        try {
            click(winMoneyButton.get(0), "Clicked on WinMoney button", driver);
        } catch (Exception e) {

        }
        waitForVisibility(title, driver);
        Assert.assertTrue(title.isDisplayed());
        utils.log().info(getText(title, "", driver));
        Thread.sleep(2000);
        clickBackButton(driver);
    }

    public void verifyUserNotWithdrawIfAmountLessThan50(AppiumDriver driver) {
        click(walletMoney, "Clicked on wallet money", driver);
        click(withDrawButton, "Clicked on WithDraw button", driver);
        waitForVisibility(title, driver);
        Assert.assertTrue(title.isDisplayed());
        utils.log().info(getText(title, "", driver));
        ExtentReport.getTest().log(Status.INFO, getText(title, "", driver));
    }

    public void verifyUserAllowLimitedGivenTransaction(AppiumDriver driver) {
        click(withDrawButton, "Clicked on WithDraw button", driver);
//        try {
//            click(editButton, "Clicked on edit button", driver);
//        } catch (Exception e) {
//
//        }
//        click(enterUpiIdManuallyButton, " Clicked on EnterUpiIdManually Button", driver);
//        click(enterUpiIdField, "Clicked Upi Id field", driver);
//        sendKeys(enterUpiIdField, "icicibank7071@ibl", driver);
//        clickBackButton(driver);
//        click(upiSubmitButton, "Clicked on UPi submit button", driver);
        click(withDrawAmountButton, "Clicked on withDrawAmount Button", driver);
        waitForVisibility(withDrawLimitMessage, driver);
        Assert.assertTrue(withDrawLimitMessage.isDisplayed(), "WithDraw limit reached messahe is not displayed");
        utils.log().info(getText(withDrawLimitMessage, "getting withdraw limit message", driver));
        ExtentReport.getTest().log(Status.INFO, getText(withDrawLimitMessage, "getting withdraw limit message", driver));
    }

    public void navigateToTainingTabPage(AppiumDriver driver) {
        try {
            if (yellowRoseCount.get(0).isDisplayed()) {
                clickBackButton(driver);
            }
        } catch (Exception e) {

        }
    }

    public void verifyYrTransactionOpenAndCloseBalance(AppiumDriver driver, int yrCountAvailable, String giftedYellowRose) {
        int expectedTotalYellowRose = yrCountAvailable + Integer.parseInt(giftedYellowRose);
        int actualYellowRoseCount = getTheYellowRoseCount(driver);
        Assert.assertEquals(actualYellowRoseCount, expectedTotalYellowRose, "Yr Transaction open and close balance is not working as expected");
        utils.log().info("Yr Transaction open and close balance is working as expected");
        ExtentReport.getTest().log(Status.INFO,"Yr Transaction open and close balance is working as expected");
    }

    public String gettingWalletCoins(AppiumDriver driver)
    {
        waitForVisibility(walletCoins,driver);
        return getText(walletCoins,"Getting WalletCoins",driver);
    }

    public void clickOnHamburgerMenu(AppiumDriver driver)
    {
        click(hamburgerMenu,"Clicked on HamburgerMenu",driver);
    }

    public void verifyTransation(AppiumDriver driver,String expectedDiscountPrice)
    {
        click(transactionTab,"Clicked on Transaction Tab",driver);
        waitForVisibility(transactionStatus,driver);
        Assert.assertTrue(transactionStatus.isDisplayed(),"Transaction Success status is not displayed");
        Assert.assertEquals(getText(transactionDiscountPrice,"getting discountedAmount",driver).replace("₹",""),expectedDiscountPrice,"Actual and expectedDiscountPrice are not equal");
        utils.log().info("Discount Coupoun transaction is sucessfully done");
        ExtentReport.getTest().log(Status.INFO,"Discount Coupoun transaction is sucessfully done");
    }

    public int getTotalRemainingAmount(AppiumDriver driver)
    {
        waitForVisibility(totalRemainingAmount, driver);
        String text1 = getText(totalRemainingAmount, "get total amount", driver);
        return Integer.parseInt(text1.replace("₹", ""));
    }

    public void checkKycVerified(AppiumDriver driver,String name,String panNumber) throws InterruptedException {
        waitForVisibility(withDrawButton,driver);
        String text1 = getText(totalRemainingAmount, "get total amount", driver);
        int a = Integer.parseInt(text1.replace("₹", ""));
        if(kycVerifiedLabel.size()<1)
        {
            click(withDrawButton,driver);
            click(parentNameField,driver);
            Thread.sleep(1000);
            click(nameField,driver);
            sendKeys(nameField,name,driver);
            click(parentPanField,driver);
            Thread.sleep(1000);
            click(panField,driver);
            sendKeys(panField,panNumber,driver);
            click(kycSubmitButton,driver);
//            waitForVisibility(kycVerifiedLabel.get(0),driver);
            utils.log().info("Kyc is verified");
            ExtentReport.getTest().log(Status.INFO,"Kyc is verified");
            //click(withDrawButton,driver);
        }
        else if(kycVerifiedLabel.size()==1)
        {
            utils.log().info("Kyc is verified");
            ExtentReport.getTest().log(Status.INFO,"Kyc is verified");
            click(withDrawButton,"Clicked on WithDraw Button",driver);
        }
    }
    public void checkOnePercentTdsLabel(AppiumDriver driver)
    {
        waitForVisibility(onePercentTdsLabel,driver);
        utils.log().info("OnePercentTdsLabel is displayed");
        ExtentReport.getTest().log(Status.INFO,"OnePercentTdsLabel is displayed");
    }

    public void checkFivePercentTdsLabel(AppiumDriver driver)
    {
        waitForVisibility(fivePercentTdsLabel,driver);
        utils.log().info("fivePercentTdsLabel is displayed");
        ExtentReport.getTest().log(Status.INFO,"fivePercentTdsLabel is displayed");
    }

    public void verifyTdsAmountDeduction(AppiumDriver driver,String fixedWithDrawAmount)
    {
        String tdsAmount = getText(tdsDeductAmount,"Getting Tds Deduct Amount",driver).replace("₹","");
        String withDrawAmount = getText(withDrawAmountButton,"Getting WithDrawAmount",driver).replace("Withdraw ₹ ","");
        Double remainingAmount = Double.parseDouble(fixedWithDrawAmount) - Double.parseDouble(tdsAmount);
        Assert.assertEquals(Double.toString(Double.parseDouble(withDrawAmount)),Double.toString(remainingAmount),"TdsAmount is not getting deducted");
    }

    public void verifyWithDrawSuccessful(AppiumDriver driver,int remainingWithDrawAmount)
    {
        waitForVisibility(totalRemainingAmount, driver);
        String text2 = getText(totalRemainingAmount, "get total amount", driver);
        int b = Integer.parseInt(text2.replace("₹", ""));
        Assert.assertTrue(b < remainingWithDrawAmount, "Money is not withdrawn from the account");
        ExtentReport.getTest().log(Status.INFO, "Successfully money withdrawn from the account");
    }

    public void verifyWalletMoneyMoreThan100(AppiumDriver driver)
    {
        waitForVisibility(walletMoney,driver);
        String walletMney = getText(walletMoney,"Getting Wallet money",driver).replace("₹","");
        if(Integer.parseInt(walletMney)>100)
        {
            utils.log().info("Wallet Money is more than 100");
            ExtentReport.getTest().log(Status.INFO,"Wallet Money is more than 100");
            click(walletMoney,driver);
        }
    }
    public void clickOnWalletMoney(AppiumDriver driver)
    {
        click(walletMoney,"clicked on Wallet Money",driver);
    }
    public void enterUpiIdValue(AppiumDriver driver,String upiID)
    {
        try {
            click(withDrawButton, driver);
        }catch(Exception e)
        {

        }
        try {
            click(editButton, "Clicked on edit button", driver);
        } catch (Exception e) {
        }
        click(enterUpiIdManuallyButton, " Clicked on EnterUpiIdManually Button", driver);
        click(enterUpiIdField, "Clicked Upi Id field", driver);
        sendKeys(enterUpiIdField, upiID, driver);
        clickBackButton(driver);
        click(upiSubmitButton, "Clicked on UPi submit button", driver);
    }

    public void checkKycVerifiedForAnotherUser(AppiumDriver driver,String name,String panNumber) throws InterruptedException {
        waitForVisibility(withDrawButton, driver);
        String text1 = getText(totalRemainingAmount, "get total amount", driver);
        int a = Integer.parseInt(text1.replace("₹", ""));
        if (kycVerifiedLabel.size() < 1) {
            click(withDrawButton, driver);
            click(parentNameField, driver);
            Thread.sleep(1000);
            click(nameField, driver);
            sendKeys(nameField, name, driver);
            click(parentPanField, driver);
            Thread.sleep(1000);
            click(panField, driver);
            sendKeys(panField, panNumber, driver);
            click(kycSubmitButton, driver);
//            waitForVisibility(kycVerifiedLabel.get(0),driver);
            utils.log().info("Kyc is verified");
            ExtentReport.getTest().log(Status.INFO, "Kyc is verified");
            //click(withDrawButton,driver);
        } else if (kycVerifiedLabel.size() == 1) {
            utils.log().info("Kyc is verified");
            ExtentReport.getTest().log(Status.INFO, "Kyc is verified");
            click(withDrawButton, "Clicked on WithDraw Button", driver);
        }
    }

    public void verifyPanNotAllowedToUse(AppiumDriver driver,String name, String panNumber) throws InterruptedException {
        click(withDrawButton, driver);
        click(parentNameField, driver);
        Thread.sleep(1000);
        click(nameField, driver);
        sendKeys(nameField, name, driver);
        click(parentPanField, driver);
        Thread.sleep(1000);
        click(panField, driver);
        sendKeys(panField, panNumber, driver);
        click(kycSubmitButton, driver);
        waitForVisibility(panErrorMessage,driver);
        Assert.assertTrue(panErrorMessage.isDisplayed(),"PanNumber is allowed to use by more than two user");
        utils.log().info("PanNumber is not allowed to use by More than two user");
        ExtentReport.getTest().log(Status.INFO,"PanNumber is not allowed to use by More than two user");
    }

}

