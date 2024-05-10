package com.QA.Pages;

import com.QA.Base.BaseTest;
import com.QA.utlis.TestUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FrndCoinPage extends BaseTest {

    public FrndCoinPage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    TestUtils utils = new TestUtils();
    //*************** Keep Elements Here ******************************************
    @AndroidFindBy(xpath = "(//android.widget.TextView[@resource-id=\"com.dating.for.all.debug:id/headerTv\" and @text=\"Coin Pack\"]/..//android.view.ViewGroup)[5]")
    private MobileElement coinPackOption;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@resource-id=\"com.dating.for.all.debug:id/coinsTv\"])[4]/preceding-sibling::android.widget.TextView")
    private MobileElement coinsToBeAdded;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@resource-id=\"com.dating.for.all.debug:id/headerTv\" and @text=\"Coin Pack\"]/..//android.view.ViewGroup)[5]")
    private MobileElement coinsForAppliedCoupoun;

    @AndroidFindBy(xpath = "((//android.widget.ImageView[@resource-id=\"com.dating.for.all.debug:id/packageIv\"])[10]/following-sibling::android.widget.TextView)[3]")
    private MobileElement coinsPrice;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.dating.for.all.debug:id/coinsCountTv\" and @text=\"90\"]")
    private List<MobileElement> ninetyCoinsPackage;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.dating.for.all.debug:id/coinsCountTv\" and @text=\"200\"]")
    private List<MobileElement> twoHundredCoinsPackage;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.dating.for.all.debug:id/coinsCountTv\" and @text=\"20\"]")
    private List<MobileElement> twentyCoinsPackage;


    //*********************** End Elements *************************************************

    public void clickOnNienetyCoinPackage(AppiumDriver driver)
    {
        while(ninetyCoinsPackage.size()<1)
        {
            swipeScreenSmall(Direction.UP,driver);
        }
        click(ninetyCoinsPackage.get(0),"Clicked on Ninety Coins Package",driver);
    }
    public void clickOnTwoHundredCoinPackage(AppiumDriver driver)
    {
        while(twoHundredCoinsPackage.size()<1)
        {
            swipeScreenSmall(Direction.UP,driver);
        }
        click(twoHundredCoinsPackage.get(0),"Clicked on Ninety Coins Package",driver);
    }

    public void clickOnTwentyCoinPackage(AppiumDriver driver)
    {
        while(twentyCoinsPackage.size()<1)
        {
            swipeScreenSmall(Direction.UP,driver);
        }
        click(twentyCoinsPackage.get(0),"Clicked on Ninety Coins Package",driver);
    }

    public void clickOnCoinPackOption(AppiumDriver driver) {
        try {
            click(coinPackOption, "Clicked on coinPackOption", driver);
        }catch (Exception e)
        {

        }
    }

    public String getCoinsToBeAdded(AppiumDriver driver) {
        waitForVisibility(coinsToBeAdded, driver);
        return getText(coinsToBeAdded, "coins to be added", driver);
    }

    public void clickOnCoinPackageOption(AppiumDriver driver)
    {
        waitForVisibility(coinsForAppliedCoupoun,driver);
        click(coinsForAppliedCoupoun,driver);
    }
    public String getCoinsPrice(AppiumDriver driver)
    {
        return getText(coinsPrice,"getting coins price",driver);
    }

}
