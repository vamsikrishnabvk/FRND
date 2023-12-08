package com.QA.Pages;

import com.QA.Base.BaseTest;
import com.QA.utlis.TestUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class GroupRoomHostedPage extends BaseTest {

    public GroupRoomHostedPage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    TestUtils utils = new TestUtils();

    @AndroidFindBy(id = "com.dating.for.all:id/playerSoundBiv")
    private MobileElement hostSoundICon;

    @AndroidFindBy(id = "com.dating.for.all:id/playerSoundBiv")
    private MobileElement soundOffIcon;

    @AndroidFindBy(xpath = "(//android.widget.ImageView[@resource-id=\"com.dating.for.all:id/playerIv\"])[2]")
    private MobileElement groupRoomUser;

    @AndroidFindBy(id = "com.dating.for.all:id/micIv")
    private MobileElement userMicIcon;

    @AndroidFindBy(id = "com.dating.for.all:id/soundOffIv")
    private MobileElement userMicOffIcon;

    @AndroidFindBy(id = "com.dating.for.all:id/removeIv")
    private MobileElement removeLayout;

    @AndroidFindBy(id = "com.dating.for.all:id/kickOutIv")
    private MobileElement banCrossIcon;

    @AndroidFindBy(id = "com.dating.for.all:id/profileIv")
    private MobileElement userProfileIcon;

    @AndroidFindBy(id = "com.dating.for.all:id/positiveActionBtv")
    private MobileElement removeButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Sexual Talk\"]")
    private MobileElement sexualTalkWarning;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Ban\"]")
    private MobileElement banButton;

    @AndroidFindBy(id = "com.dating.for.all:id/positiveActionBtv")
    private MobileElement punishButton;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"I Understand it won't happen again\"]/preceding-sibling::android.widget.ImageView)[2]")
    private MobileElement warningCheckBox;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"I Promise\"]")
    private MobileElement iPromiseButton;


    public void verifyHostMuteUnmuteFunctionality(AppiumDriver driver) throws InterruptedException {
        Thread.sleep(7000);
        // waitForClickable(hostSoundICon,driver);
        click(hostSoundICon, "Click on Host Sound Icon", driver);
        waitForVisibility(soundOffIcon, driver);
        Assert.assertTrue(soundOffIcon.isDisplayed(), "Host not muted");
        click(hostSoundICon, "Click on Host Sound Icon", driver);
        try {
            if (!soundOffIcon.isDisplayed()) {
                utils.log().info("Host is unmute");
            }
        } catch (Exception e) {

        }

    }

    public void verifyUserMuteUnmuteFunctionality(AppiumDriver driver) {
        click(groupRoomUser, "Clicked on User ", driver);
        click(userMicIcon, "Clicked on User Mic Icon", driver);
        clickBackButton(driver);
        waitForVisibility(userMicOffIcon, driver);
        Assert.assertTrue(userMicOffIcon.isDisplayed(), "User not muted");
        click(groupRoomUser, "Clicked on User ", driver);
        click(userMicIcon, "Clicked on User Mic Icon", driver);
        clickBackButton(driver);
        try {
            if (!soundOffIcon.isDisplayed()) {
                utils.log().info("Host is unmute");
            }
        } catch (Exception ignored) {

        }
    }

    public void hostRemoveUser(AppiumDriver driver) {
        click(groupRoomUser, "Clicked on User Profile Icon", driver);
        click(removeLayout, "Clicked on Remove cross button", driver);
        click(removeButton, "Clicked on Remove button", driver);
    }

    public void hostBanTheUser(AppiumDriver driver) {
        click(groupRoomUser, "Host clicked on User Profile", driver);
        click(banCrossIcon, "Cliked on Ban Cross Icon", driver);
        click(sexualTalkWarning, "Clicked on Warning", driver);
        click(banButton, "Clicked on Ban Button", driver);
        click(punishButton, "Clicked on Punish Button", driver);
    }

    public void checkUserGetWarning(AppiumDriver driver) {
        click(warningCheckBox, "Clicked on Warning CheckBox", driver);
        click(iPromiseButton, "Clicked on Ipromise Button", driver);
    }
}
