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

public class PaymentPage extends BaseTest {

    public PaymentPage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    TestUtils utils = new TestUtils();
//*************** Keep Elements Here ******************************************

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Pay ₹1\"]")
    private MobileElement payRs1Button;

    @AndroidFindBy(id = "com.google.android.apps.nbu.paisa.user:id/form_item_input")
    private MobileElement enterPinField;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"0\"]/following-sibling::android.widget.ImageView")
    private MobileElement pinConfirmButton;

    @AndroidFindBy(id = "com.dating.for.all:id/button")
    private MobileElement okayButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.dating.for.all:id/appNameTv\" and @text=\"GPay\"]/preceding-sibling::android.widget.ImageView")
    private MobileElement googlePayIcon;

    @AndroidFindBy(xpath = "(//android.view.View)[7]")
    private MobileElement dropdownIcon;

    @AndroidFindBy(id = "com.dating.for.all:id/upiMoreOptionsIv")
    private MobileElement upiMoreDropDown;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"PhonePe\"])[1]")
    private MobileElement phonePayIcon;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Add Coins\"]")
    private MobileElement addCoinsIcon;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.phonepe.app:id/tv_action\" and @text=\"PROCEED TO PAY\"]")
    private MobileElement proceedToPayButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"FRND App\"]/preceding-sibling::android.widget.TextView[@text=\"Final Price\"]")
    private MobileElement paymentMethodFrndApp;

    @AndroidFindBy(id = "com.dating.for.all:id/icTriangleAtm")
    private List<MobileElement> icTriangleAtmIcon;

    @AndroidFindBy(id = "com.dating.for.all:id/tie_card_holder")
    private MobileElement cardHolderNameField;

    @AndroidFindBy(id = "com.dating.for.all:id/tie_card_number")
    private MobileElement cardNumberField;

    @AndroidFindBy(id = "com.dating.for.all:id/tie_card_date")
    private MobileElement expiryDateField;

    @AndroidFindBy(id = "com.dating.for.all:id/tie_card_cvv")
    private MobileElement cvvField;

    @AndroidFindBy(id = "com.dating.for.all:id/btn_card")
    private MobileElement payButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"textHelp\"]/preceding-sibling::android.widget.EditText[@resource-id=\"cardotp\"]")
    private MobileElement otpField;

    @AndroidFindBy(id = "com.dating.for.all:id/btn_upi")
    private MobileElement upiPayButton;

    @AndroidFindBy(xpath = "//android.widget.Button[@text=\"Simulate success\"]")
    private MobileElement simulateSuccess;

    @AndroidFindBy(id = "android:id/button1")
    private MobileElement yesButton;

    @AndroidFindBy(id = "com.dating.for.all:id/btn_yes")
    private MobileElement yesButton1;

    @AndroidFindBy(id = "com.dating.for.all:id/btn_yes")
    private MobileElement upiIDYesButton;

    @AndroidFindBy(id = "com.dating.for.all:id/tvPaymentStatus")
    private MobileElement paymentSatus;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.dating.for.all:id/appNameTv\" and @text=\"Other Apps\"]")
    private MobileElement otherAppsTab;

    @AndroidFindBy(id = "com.dating.for.all:id/tie_upi_vpa")
    private MobileElement upiIdField;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text=\"example@upi\"]")
    private MobileElement enterUPIIdText;

    @AndroidFindBy(xpath = "//android.widget.Button[@text=\"Simulate success\"]")
    private MobileElement simulateSuccessButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.dating.for.all:id/appNameTv\" and @text=\"BHIM\"]")
    private MobileElement bhimPayIcon;

    @AndroidFindBy(id = "com.dating.for.all:id/otherUpiIdTv")
    private MobileElement upiIdTv;

    @AndroidFindBy(id = "com.dating.for.all:id/iv_upi_arrow_collect")
    private MobileElement upiIdDropDown;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"FRND Website\"]")
    private MobileElement frndWebSitePaymentMethod;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"FRND App\"]")
    private MobileElement frndAppPaymentMethod;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Pay with any UPI app\"]/..")
    private MobileElement moreUpiDropdown;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Change Payment Mode\"]")
    private MobileElement changePaymentMethodModeTab;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@resource-id=\"com.dating.for.all:id/coinPriceTv\"])[3]")
    private MobileElement actualPrice1;

    @AndroidFindBy(id = "com.dating.for.all:id/finalCoinsPriceTv")
    private MobileElement finalPrice;

    @AndroidFindBy(id = "com.dating.for.all:id/coinsPriceTv")
    private MobileElement actualPrice;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"com.dating.for.all:id/couponCodeEt\"]")
    private MobileElement coupounCodeTextField;

    @AndroidFindBy(id = "com.dating.for.all:id/applyDiscountTv")
    private MobileElement applyDiscountButton;

    @AndroidFindBy(id = "com.dating.for.all:id/discountTv")
    private MobileElement discountPrice;


    //*********************** End Elements *************************************************

    public void makePaymentThroughGpay(AppiumDriver driver) {
        if (paymentMethodFrndApp.isDisplayed()) {
            click(paymentMethodFrndApp, "Clicked on PayemntMethod with Frnd App", driver);
            click(dropdownIcon, "clicked on dropdown icon", driver);
            click(googlePayIcon, "Clicked on PhonePay icon", driver);
            click(proceedToPayButton, "Clicked on Proceed to Pay Button", driver);
        } else {
            clickOnGooglePayIcon(driver);
            click(payRs1Button, "Clicked on Google Pay option", driver);
            sendKeys(enterPinField, "7071", "Enter the pin", driver);
            click(pinConfirmButton, "Click on Pin confirm Button", driver);
            click(okayButton, "Click on okay Button", driver);
        }
    }

    public void makePaymentThroughPhonePay(AppiumDriver driver) {
        try
        {
        if (paymentMethodFrndApp.isDisplayed()) {
            click(paymentMethodFrndApp, "Clicked on PayemntMethod with Frnd App", driver);
            click(dropdownIcon, "clicked on dropdown icon", driver);
            click(phonePayIcon, "Clicked on PhonePay icon", driver);
            click(proceedToPayButton, "Clicked on Proceed to Pay Button", driver);
        } }catch(Exception e)
        {

        }
        try {
                clickOnPhonePayIcon(driver);
                click(payRs1Button, "Clicked on Google Pay option", driver);
                sendKeys(enterPinField, "7071", "Enter the pin", driver);
                click(pinConfirmButton, "Click on Pin confirm Button", driver);
                click(okayButton, "Click on okay Button", driver);
        }catch (Exception e)
        {

        }
    }

    public void makePaymentThroughCard(AppiumDriver driver,String cardHolderName,String cardNumber,String expiryDate,String cvvNumber,String otpNumber)
    {
        while (icTriangleAtmIcon.size()<1) {
            swipeScreen(Direction.UP, driver);
        }
        click(icTriangleAtmIcon.get(0),"Clicked on Triangle Icon",driver);
        sendKeys(cardHolderNameField,cardHolderName,driver);
        sendKeys(cardNumberField,cardNumber,driver);
        sendKeys(expiryDateField,expiryDate,driver);
        sendKeys(cvvField,cvvNumber,driver);
        click(payButton,"Clicked on Pay Button",driver);
        click(otpField,"Clicked on OTP field",driver);
        sendKeys(otpField,otpNumber,driver);
        clickBackButton(driver);
        click(simulateSuccess,"Clicked on Simulate Success", driver);
        click(okayButton,"Clicked on Okay Button",driver);
    }

    public void clickOnGooglePayIcon(AppiumDriver driver) {
        click(googlePayIcon, "Clicked on Google Pay Icon", driver);
    }

    public void selectPaymentMethod(AppiumDriver driver) {
        if (paymentMethodFrndApp.isDisplayed()) {
            click(paymentMethodFrndApp, "Clicked on PayemntMethod with Frnd App", driver);
            click(dropdownIcon, "clicked on dropdown icon", driver);
        }
    }

    public void clickOnPhonePayIcon(AppiumDriver driver) {
        try {
            click(phonePayIcon, "Clicked on PhonePay icon", driver);
        }catch (Exception e)
        {

        }
    }

    public void clickOnProceedToPay(AppiumDriver driver) {
        click(proceedToPayButton, "Clicked on Proceed to Pay Button", driver);
    }

    public void clickOnChangePaymentMode(AppiumDriver driver)
    {
        click(upiMoreDropDown, "clicked on dropdown icon", driver);
        click(changePaymentMethodModeTab,driver);
    }

    public void clickOnChangePaymentMode1(AppiumDriver driver)
    {
        try {
            click(changePaymentMethodModeTab, driver);
        }catch (Exception e)
        {

        }
    }

    public void enterCardDetails(AppiumDriver driver,String cardHolderName,String cardNumber,String expiryDate,String cvvNumber)
    {
        while (icTriangleAtmIcon.size()<1) {
            swipeScreen(Direction.UP, driver);
        }
        click(icTriangleAtmIcon.get(0),"Clicked on Triangle Icon",driver);
        waitForVisibility(cardHolderNameField,driver);
        sendKeys(cardHolderNameField,cardHolderName,driver);
        sendKeys(cardNumberField,cardNumber,driver);
        sendKeys(expiryDateField,expiryDate,driver);
        sendKeys(cvvField,cvvNumber,driver);
        click(payButton,"Clicked on Pay Button",driver);
    }
    public void verifyFailCardPayment(AppiumDriver driver)
    {
        waitForVisibility(otpField,driver);
        clickBackButton(driver);
        click(yesButton,driver);
        waitForVisibility(cardHolderNameField,driver);
        clickBackButton(driver);
        click(yesButton1,driver);
        waitForVisibility(paymentSatus,driver);
        Assert.assertTrue(paymentSatus.isDisplayed(),"Payment got success even after cancel Transaction");
        utils.log().info("Payment get fail after cancelation");
        ExtentReport.getTest().log(Status.INFO,"Payment get fail after cancelation");
    }

    public void clickOnOtherApps(AppiumDriver driver)
    {
        click(otherAppsTab,"Clicked on Other Tabs",driver);
    }

    public void getHandles(AppiumDriver driver) throws InterruptedException {

//        Set<String> contextHandles = driver.getContextHandles();
//        System.out.println(contextHandles);
//        for (String context : contextHandles) {
//            if (context.startsWith(" WEBVIEW")) {
//               driver.context(context);
//                break;
//            }
//        }
        click(upiIdField,"Clicked on OTP Field",driver);
        click(enterUPIIdText,"Clicked on UpIIDText",driver);
        sendKeys(enterUPIIdText,"111000",driver);
     //  sendKeys(upiIdField,"111000",driver);
    }


    public void enterOTPAndMakePayment(AppiumDriver driver,String otpValue)
    {
        click(otpField,"Clicked on OTP Field",driver);
        swipeScreen(Direction.UP,driver);
        sendKeys(otpField,otpValue,driver);
        clickBackButton(driver);
        click(simulateSuccessButton,"Clicked on Simulate Success Button",driver);
        click(okayButton,"Clicked on Okay Button",driver);
    }

    public void failTheAppTransaction(AppiumDriver driver) throws InterruptedException {
        waitForVisibility(otpField,driver);
            clickBackButton(driver);
        click(yesButton,driver);
        waitForVisibility(paymentSatus,driver);
        Assert.assertTrue(paymentSatus.isDisplayed(),"Payment got success even after cancel Transaction");
        utils.log().info("Payment get fail after cancelation");
        ExtentReport.getTest().log(Status.INFO,"Payment get fail after cancelation");
        clickBackButton(driver);
    }


    public void clickBhimPayICon(AppiumDriver driver)
    {
        click(bhimPayIcon,"Clicked on BhimPay",driver);
    }
    public void makePaymentThroughUPIID(AppiumDriver driver,String upiIdValue)
    {
        click(upiIdTv,"Clicked on UPiID",driver);
        click(upiIdDropDown,driver);
        click(upiIdField,driver);
        sendKeys(upiIdField,upiIdValue,driver);
        click(upiPayButton,"Clicked on Pay Tab",driver);
        click(okayButton,"Clicked on Okay Button",driver);
    }
    public void failUpiIDPayment(AppiumDriver driver,String upiIdValue) throws InterruptedException {
        click(upiIdTv,"Clicked on UPiID",driver);
        click(upiIdDropDown,driver);
        click(upiIdField,driver);
        sendKeys(upiIdField,upiIdValue,driver);
        clickBackButton(driver);
        clickBackButton(driver);
        click(upiIDYesButton,driver);
        waitForVisibility(paymentSatus,driver);
        Assert.assertTrue(paymentSatus.isDisplayed(),"Payment got success even after cancel Transaction");
        utils.log().info("Payment get fail after cancelation");
        ExtentReport.getTest().log(Status.INFO,"Payment get fail after cancelation");
        clickBackButton(driver);
    }

    public void selectFrndAppPaymentMethod(AppiumDriver driver)
    {
        try {
            click(frndAppPaymentMethod, "Clicked on FrndApp Payment Method", driver);
            click(moreUpiDropdown, driver);
            click(changePaymentMethodModeTab, driver);
        }catch (Exception e)
        {

        }
    }
    public void clickOnPaymentMethodMode(AppiumDriver driver)
    {
        click(dropdownIcon, driver);
        click(changePaymentMethodModeTab, driver);
    }

    public void verifyCoupounApplied(AppiumDriver driver,String coupounCode,String actualPrice)
    {
        click(coupounCodeTextField,driver);
        sendKeys(coupounCodeTextField,coupounCode,driver);
        click(applyDiscountButton,driver);
        int  discountValue = Integer.parseInt(getText(discountPrice,"Getting discounted price",driver).replace("₹",""));
        int finalPrce = Integer.parseInt(getText(finalPrice,"Getting final price",driver).replace("₹",""));
        Assert.assertEquals(Float.parseFloat(actualPrice)+discountValue,finalPrce,"Coupoun is not applied");
        utils.log().info("Coupoun is applied successfully");
        ExtentReport.getTest().log(Status.INFO,"Coupoun is Applied successfully");
    }

    public String getActualPrice(AppiumDriver driver)
    {
        waitForVisibility(actualPrice1,driver);
        return getText(actualPrice1,"Getting actual Price",driver).replace("₹","");

    }
    public String getFinalPrice(AppiumDriver driver)
    {
        waitForVisibility(finalPrice,driver);
        return getText(finalPrice,"Getting actual Price",driver).replace("₹","");

    }

    public void verifyDefaultDiscountApplied(AppiumDriver driver)
    {
        String actualPrce=getText(actualPrice,"Getting actual price",driver).replace("₹","");
        int  discountValue = Integer.parseInt(getText(discountPrice,"Getting discounted price",driver).replace("₹",""));
        int finalPrce = Integer.parseInt(getText(finalPrice,"Getting final price",driver).replace("₹",""));
        Assert.assertEquals(Float.parseFloat(actualPrce)+discountValue,finalPrce,"Coupoun is not applied");
        utils.log().info("Default Coupoun is getting applied to new user for first transaction");
    }

    public void verifyDefaultDiscountApplied1(AppiumDriver driver,String actualPrce)
    {
        int  discountValue = Integer.parseInt(getText(discountPrice,"Getting discounted price",driver).replace("₹",""));
        int finalPrce = Integer.parseInt(getText(finalPrice,"Getting final price",driver).replace("₹",""));
        Assert.assertEquals(Float.parseFloat(actualPrce)+discountValue,finalPrce,"Coupoun is not applied");
        utils.log().info("Default Coupoun is getting applied to new user for first transaction");
    }

    public int getDiscountValue(AppiumDriver driver)
    {
        return Integer.parseInt(getText(discountPrice,"Getting discounted price",driver).replace("-₹",""));
    }
}
