package com.QA.Pages;

import com.QA.Base.BaseTest;
import com.QA.utlis.TestUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

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

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"PhonePe\"]")
    private MobileElement phonePayIcon;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Add Coins\"]")
    private MobileElement addCoinsIcon;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.phonepe.app:id/tv_action\" and @text=\"PROCEED TO PAY\"]")
    private MobileElement proceedToPayButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"FRND App\"]/preceding-sibling::android.widget.TextView[@text=\"Final Price\"]")
    private MobileElement paymentMethodFrndApp;


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
        if (paymentMethodFrndApp.isDisplayed()) {
            click(paymentMethodFrndApp, "Clicked on PayemntMethod with Frnd App", driver);
            click(dropdownIcon, "clicked on dropdown icon", driver);
            click(phonePayIcon, "Clicked on PhonePay icon", driver);
            click(proceedToPayButton, "Clicked on Proceed to Pay Button", driver);
        } else {
            clickOnPhonePayIcon(driver);
            click(payRs1Button, "Clicked on Google Pay option", driver);
            sendKeys(enterPinField, "7071", "Enter the pin", driver);
            click(pinConfirmButton, "Click on Pin confirm Button", driver);
            click(okayButton, "Click on okay Button", driver);
        }
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
        click(phonePayIcon, "Clicked on PhonePay icon", driver);
    }

    public void clickOnProceedToPay(AppiumDriver driver) {
        click(proceedToPayButton, "Clicked on Proceed to Pay Button", driver);
    }
}
