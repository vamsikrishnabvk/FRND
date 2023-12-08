package com.QA.Pages;

import com.QA.Base.BaseTest;
import com.QA.utlis.TestUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class HomePage extends BaseTest {

    public HomePage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    TestUtils utils = new TestUtils();
    //*************** Keep Elements Here ******************************************
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.ImageView")
    public MobileElement tainingTab;

    @AndroidFindBy(id = "com.dating.for.all:id/coins")
    private MobileElement availableCoins;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Limited\n" +
            "Discount Offer\"]/preceding-sibling::android.view.View")
    protected List<MobileElement> crossButton;

    @AndroidFindBy(id = "com.dating.for.all:id/cancelBtv")
    protected List<MobileElement> cancelButton;

    @AndroidFindBy(id = "com.dating.for.all:id/title")
    protected List<MobileElement> titlePopup;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.TextView")
    private MobileElement homeTab;

    @AndroidFindBy(id = "com.dating.for.all:id/frameView")
    private MobileElement frameElement;

    @AndroidFindBy(id = "com.dating.for.all:id/design_bottom_sheet")
    private MobileElement frame2;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Dismiss update dialogue\"]")
    private List<MobileElement> updateCrossButton;

    @AndroidFindBy(id = "com.dating.for.all:id/freeMinsTv")
    private MobileElement freeMintCall;

    @AndroidFindBy(id = "com.dating.for.all:id/callNow")
    private MobileElement callNowButton;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    private List<MobileElement> audioRecordAllowPopup;

    @AndroidFindBy(id = "com.dating.for.all:id/addCoinsBtv")
    private MobileElement addCoinsNowButton;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[3]/android.widget.FrameLayout/android.widget.ImageView")
    public MobileElement frndTab;

    @AndroidFindBy(id = "com.dating.for.all:id/carouselIv")
    private MobileElement callNowBanner;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Group Rooms\"]")
    private List<MobileElement> groupRoom;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Private Training Rooms\"]")
    private MobileElement privateTrainingRooms;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"FRND Making Rooms\"]")
    private MobileElement frndMakingRoom;


//*********************** End Elements *************************************************

    public void clickOnHomeTab(AppiumDriver driver) {
        click(homeTab, "Click on HomeTab", driver);
    }

    public void clickOnTrainingTab(AppiumDriver driver) throws InterruptedException {
        Thread.sleep(5000);
        waitForVisibility(tainingTab, driver);
        click(tainingTab, "Clicked on Training Tab", driver);
    }

    public void handlingPopup(AppiumDriver driver) throws InterruptedException {

        if (updateCrossButton.size() == 1) {
            clickBackButton(driver);
        }
//        waitForVisibility(crossButton.get(0));
        Thread.sleep(5000);
        if (crossButton.size() == 1) {
            click(crossButton.get(0), "Clicked on Cross Button", driver);
            Thread.sleep(2000);
            click(cancelButton.get(0), "Clicked on Cancel Button", driver);
        } else if (cancelButton.size() == 1) {
            click(cancelButton.get(0), "Clicked on cancel button", driver);
        }

        if (updateCrossButton.size() == 1) {
            clickBackButton(driver);
        }

        if (titlePopup.size() == 1) {
            clickBackButton(driver);
            utils.log().info("Clicked on Back button");
        }
        if (updateCrossButton.size() == 1) {
            clickBackButton(driver);
        }
    }

    public String getAvailableCoin(AppiumDriver driver) throws InterruptedException {
        click(homeTab, "Clicked on HomeTab", driver);
        waitForVisibility(availableCoins, driver);
        return getText(availableCoins, "Get available coin package", driver);
    }

    public void clickOnCoins(AppiumDriver driver) {
        click(availableCoins, "Clicked on available coins", driver);
    }

    public void clickOnAvailableCoinValueSymbol(AppiumDriver driver) {
        click(availableCoins, "Clicked on Coin Package", driver);
    }

    public void verifyHostExitTheRoom(AppiumDriver driver) {
        waitForVisibility(homeTab, driver);
        Assert.assertTrue(homeTab.isDisplayed(), "Host is not able to exit the room");
        utils.log().info("Host have exit the room");
    }

    public void checkFreeMinuteAndConnect(AppiumDriver driver) {
        waitForVisibility(freeMintCall, driver);
        Assert.assertTrue(freeMintCall.isDisplayed(), "Free minute label is not displayed");
        click(callNowButton, "Clicked on call now button", driver);
        if (audioRecordAllowPopup.size() == 1) {
            click(audioRecordAllowPopup.get(0), "Clicked on Audio record allow popup", driver);
        }
    }

    public void clickOnAddCoinsNowButton(AppiumDriver driver) {
        click(addCoinsNowButton, "Click on Add Coins Now Button", driver);
    }

    public void verifyCoinsAddedAfterPayment(String availableCoins, String coinsAfterPayment, String coinsToBeAdded) {
        int availableCoin = Integer.parseInt(availableCoins);
        int coinAferPayemnt = Integer.parseInt(coinsAfterPayment);
        int coinAfterPayment = Integer.parseInt(coinsAfterPayment);
        int sumOfCoins = availableCoin + coinAferPayemnt;
        Assert.assertEquals(coinAfterPayment, sumOfCoins, "Coins After payment have not been added");
        utils.log().info("Coins After Payment have been added successfully");
    }

    public void clickOnFrndTab(AppiumDriver driver) {
        waitForVisibility(frndTab, driver);
        waitForVisibility(frndTab, driver);
        click(frndTab, "Clicked on Frnd Tab", driver);
    }

    public void verifyCallNowBannerDisplayed(boolean isDisplayed, AppiumDriver driver) {
        waitForVisibility(callNowBanner, driver);
        Assert.assertEquals(callNowBanner.isDisplayed(), isDisplayed);
    }

    public void clickOnGroupRoom(AppiumDriver driver) throws InterruptedException {
        swipeElementAndroid(privateTrainingRooms, Direction.LEFT, "swiping left", (AndroidDriver) driver);
        try {
            swipeElementAndroid(frndMakingRoom, Direction.LEFT, "swiping left", (AndroidDriver) driver);
        } catch (Exception e) {

        }
        click(groupRoom.get(0), "clicked on GroupRoom", driver);
    }
}
