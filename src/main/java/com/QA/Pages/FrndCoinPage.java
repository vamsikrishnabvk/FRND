package com.QA.Pages;

import com.QA.Base.BaseTest;
import com.QA.utlis.TestUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class FrndCoinPage extends BaseTest {

    public FrndCoinPage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    TestUtils utils = new TestUtils();
    //*************** Keep Elements Here ******************************************
    @AndroidFindBy(xpath = "(//android.widget.TextView[@resource-id=\"com.dating.for.all:id/headerTv\" and @text=\"Coin Pack\"]/..//android.view.ViewGroup)[3]")
    private MobileElement coinPackOption;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@resource-id=\"com.dating.for.all:id/coinsTv\"])[3]/preceding-sibling::android.widget.TextView")
    private MobileElement coinsToBeAdded;
    //*********************** End Elements *************************************************

    public void clickOnCoinPackOption(AppiumDriver driver) {
        click(coinPackOption, "Clicked on coinPackOption", driver);
    }

    public String getCoinsToBeAdded(AppiumDriver driver) {
        waitForVisibility(coinsToBeAdded, driver);
        return getText(coinsToBeAdded, "coins to be added", driver);
    }
}
