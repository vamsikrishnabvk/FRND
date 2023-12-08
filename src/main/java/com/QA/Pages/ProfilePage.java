package com.QA.Pages;

import com.QA.Base.BaseTest;
import com.QA.utlis.TestUtils;
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

    @AndroidFindBy(id = "com.dating.for.all:id/redeemNow")
    private List<MobileElement> winMoneyButton;

    @AndroidFindBy(id = "com.dating.for.all:id/redeemProgressDismiss")
    private MobileElement okayButton;

    @AndroidFindBy(id = "com.dating.for.all:id/withdraw")
    private MobileElement withDrawButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\" PhonePe ,Gpay, Paytm, UPI no.\"]")
    private MobileElement mobileNumberField;

    @AndroidFindBy(xpath = "//android.widget.Button")
    private MobileElement submitButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Enter UPI ID Manually\"]")
    private MobileElement enterUpiIdManuallyButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Enter your UPI ID\"]/following-sibling::android.widget.EditText")
    private MobileElement enterUpiIdField;

    @AndroidFindBy(xpath = "//android.widget.Button")
    private MobileElement upiSubmitButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Withdrawal Amount\"]/following-sibling::android.view.View//android.widget.Button")
    private MobileElement withDrawAmountButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Withdrawn successfully to your\n" +
            " bank account\"]")
    private MobileElement withDrawSuccessMessage;

    @AndroidFindBy(id = "com.dating.for.all:id/totalRemaningAmountTv")
    private MobileElement totalRemainingAmount;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Edit\"]")
    private MobileElement editButton;

    @AndroidFindBy(id = "com.dating.for.all:id/addfrndIcon")
    private MobileElement addFrndIcon;

    @AndroidFindBy(id = "com.dating.for.all:id/redeemProcessTitle")
    private MobileElement congratulationsMessage;

    @AndroidFindBy(id = "com.dating.for.all:id/redeemProcessSubtitle")
    private MobileElement yellowRoseRewardMessage;

    @AndroidFindBy(id = "com.dating.for.all:id/yrInfo")
    private List<MobileElement> noRoseCollectedMessage;

    @AndroidFindBy(id = "com.dating.for.all:id/yellowRoseCount")
    private List<MobileElement> yellowRoseCount;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Followers\"]")
    private MobileElement followersLabel;

    @AndroidFindBy(id = "com.dating.for.all:id/title")
    private MobileElement title;


    @AndroidFindBy(id = "com.dating.for.all:id/walletMoney")
    private MobileElement walletMoney;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"You've hit your daily withdrawal limit. Please try again tomorrow!\"]")
    private MobileElement withDrawLimitMessage;

    @AndroidFindBy(xpath = "//android.widget.Toast[@text=\"UPI id is already registered with us\"]")
    private MobileElement upiRegisteredMessage;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"UPI ID in use\"]")
    private MobileElement upiIdInUseMessage;


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
        while (yellowRoseCount.size() < 1) {
            swipeScreen(Direction.LEFT, driver);
        }
        int totalYellowRoseCount = Integer.parseInt(getText(yellowRoseCount.get(0), "get yellow rose count", driver));
        System.out.println(totalYellowRoseCount);
        return Integer.parseInt(getText(yellowRoseCount.get(0), "get yellow rose count", driver));
    }

    public void clikcOnWinMoneyButton(AppiumDriver driver) {
        while (winMoneyButton.size() < 1) {
            swipeScreen(Direction.LEFT, driver);
        }
        click(winMoneyButton.get(0), driver);

    }

    public void checkRedeemSuccessMessageVisibility(AppiumDriver driver) {
        waitForVisibility(congratulationsMessage, driver);
        congratulationsMessage.isDisplayed();
        yellowRoseRewardMessage.isDisplayed();
        utils.log().info("Redeem Successful message is displayed");
    }

    public void withDrawMoney(AppiumDriver driver) throws InterruptedException {
        waitForClickable(okayButton, driver);
        click(okayButton, "Clicked on Okay Button", driver);
        waitForVisibility(totalRemainingAmount, driver);
        String text1 = getText(totalRemainingAmount, "get total amount", driver);
        int a = Integer.parseInt(text1.replace("₹", ""));
        click(withDrawButton, "Clicked on WithDraw button", driver);
        try {
            click(editButton, "Clicked on edit button", driver);
        } catch (Exception e) {

        }
        click(enterUpiIdManuallyButton, " Clicked on EnterUpiIdManually Button", driver);
        click(enterUpiIdField, "Clicked Upi Id field", driver);
        sendKeys(enterUpiIdField, "icicibank7071@ibl", driver);
        clickBackButton(driver);
        click(upiSubmitButton, "Clicked on UPi submit button", driver);
        //      utils.log().info(getAttribute(upiRegisteredMessage,"name",driver));
        //   waitForVisibility(upiRegisteredMessage,driver);
//        Thread.sleep(2000);
        verifyToastMessageUsingPageSource("UPI id is already registered with us", driver);
        //Assert.assertTrue(upiRegisteredMessage.isDiUPI id is already registered with ussplayed(),"Upi Registered message is not displayed");
        //  utils.log().info("Upi Registered message is displayed "+getText(upiRegisteredMessage,"",driver));
        click(withDrawAmountButton, "Clicked on withDrawAmount Button", driver);
        Assert.assertTrue(withDrawSuccessMessage.isDisplayed(), "WithDraw message is displayed");
        clickBackButton(driver);
        waitForVisibility(totalRemainingAmount, driver);
        String text2 = getText(totalRemainingAmount, "get total amount", driver);
        int b = Integer.parseInt(text2.replace("₹", ""));
        Assert.assertTrue(b < a, "Successfully money withdrawn to Account");
    }

    public void verifyUpiIdInUseByOtherUser(AppiumDriver driver) {
        waitForClickable(okayButton, driver);
        click(okayButton, "Clicked on Okay Button", driver);
        waitForVisibility(totalRemainingAmount, driver);
        String text1 = getText(totalRemainingAmount, "get total amount", driver);
        int a = Integer.parseInt(text1.replace("₹", ""));
        click(withDrawButton, "Clicked on WithDraw button", driver);
        try {
            click(editButton, "Clicked on edit button", driver);
        } catch (Exception e) {

        }
        click(enterUpiIdManuallyButton, " Clicked on EnterUpiIdManually Button", driver);
        click(enterUpiIdField, "Clicked Upi Id field", driver);
        sendKeys(enterUpiIdField, "icicibank7071@ibl", driver);
        clickBackButton(driver);
        click(upiSubmitButton, "Clicked on UPi submit button", driver);
        click(withDrawAmountButton, "Clicked on withDrawAmount Button", driver);
        waitForVisibility(upiIdInUseMessage, driver);
        Assert.assertTrue(upiIdInUseMessage.isDisplayed(), "UpiId in Use message is not visible");
        utils.log().info("Verified Upi is already in Use by Some other user");
    }

    public void allowYRRedeemIfYRLessThan5Yr1stTime(AppiumDriver driver, int expectedRose) throws InterruptedException {
        int yellowRosCount = Integer.parseInt(getText(yellowRoseCount.get(0), "get yellow rose count", driver));
        if (yellowRosCount <= expectedRose) {
            Assert.assertTrue(true, "YellowRoseCount is not less than expected rose count");
            clikcOnWinMoneyButton(driver);
            withDrawMoney(driver);
            utils.log().info("Allow Yr Redeem for the first time when YR less than and equal to 5");
        }
    }

    public void allowYrRedeemIfYrMoreThan5Yr(AppiumDriver driver, int expectedRose) throws InterruptedException {
        int yellowRosCount = Integer.parseInt(getText(yellowRoseCount.get(0), "get yellow rose count", driver));
        if (yellowRosCount > expectedRose) {
            Assert.assertTrue(true, "YellowRoseCount is not more than expected rose count");
            clikcOnWinMoneyButton(driver);
            withDrawMoney(driver);
            utils.log().info("Allow Yr Redeem for the first time when YR more than 5");
        }
    }

    public void verifyYrRedeemSuccess(AppiumDriver driver) {
        waitForClickable(okayButton, driver);
        click(okayButton, "Clicked on Okay Button", driver);
        clickBackButton(driver);
        while (noRoseCollectedMessage.size() < 1) {
            swipeScreen(Direction.LEFT, driver);
        }
        waitForVisibility(noRoseCollectedMessage.get(0), driver);
        noRoseCollectedMessage.get(0).isDisplayed();
        utils.log().info("Redeem is successfully done");
    }

    public void verifyMin5RoseRequiredForRedeemForTheSecondTime(AppiumDriver driver) {
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
        clickBackButton(driver);
    }

    public void verifyUserNotWithdrawIfAmountLessThan50(AppiumDriver driver) {
        click(walletMoney, "Clicked on wallet money", driver);
        click(withDrawButton, "Clicked on WithDraw button", driver);
        waitForVisibility(title, driver);
        Assert.assertTrue(title.isDisplayed());
        utils.log().info(getText(title, "", driver));
    }

    public void verifyUserAllowLimitedGivenTransaction(AppiumDriver driver) {
        click(withDrawButton, "Clicked on WithDraw button", driver);
        try {
            click(editButton, "Clicked on edit button", driver);
        } catch (Exception e) {

        }
        click(enterUpiIdManuallyButton, " Clicked on EnterUpiIdManually Button", driver);
        click(enterUpiIdField, "Clicked Upi Id field", driver);
        sendKeys(enterUpiIdField, "icicibank7071@ibl", driver);
        clickBackButton(driver);
        click(upiSubmitButton, "Clicked on UPi submit button", driver);
        click(withDrawAmountButton, "Clicked on withDrawAmount Button", driver);
        waitForVisibility(withDrawLimitMessage, driver);
        Assert.assertTrue(withDrawLimitMessage.isDisplayed(), "WithDraw limit reached messahe is not displayed");
        utils.log().info(getText(withDrawLimitMessage, "getting withdraw limit message", driver));
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

    }
}

