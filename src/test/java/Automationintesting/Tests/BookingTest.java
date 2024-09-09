package Automationintesting.Tests;

import Automationintesting.Pages.AdminPage;
import Automationintesting.Pages.LoginPage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.security.SecureRandom;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BookingTest {

    String username = "admin";
    String password = "password";

    @BeforeAll
    public static void setUp() {
        Configuration.baseUrl = "https://automationintesting.online/#/admin";
        Configuration.browser = "firefox";
        Configuration.browserCapabilities = new FirefoxOptions().setPageLoadStrategy(PageLoadStrategy.EAGER).addArguments("--headless", "--window-size=1920,1080", "--disable-notifications", "--disable-gpu", "--disable-dev-tools", "--fastSetValue");
        open("/");
    }

    @AfterAll
    public static void tearDown() {Selenide.closeWebDriver();}

    @Test
    public void authorizationTest() {
        System.out.println("Authorization test");
        LoginPage.waitForPageLoad();
        LoginPage.moveWelcomePage();
        LoginPage.enterUserName(username);
        LoginPage.enterPassword(password);
        LoginPage.clickLoginButton();
        AdminPage.authorizationCheck();
        System.out.println("Authorization test successful");
        AdminPage.clickLogoutButton();
        System.out.println("Logout successful");
    }

    @Test
    public void createNewRoomNumberTest() {
        System.out.println("Create new room number test");
        LoginPage.waitForPageLoad();
        LoginPage.moveWelcomePage();
        LoginPage.enterUserName(username);
        LoginPage.enterPassword(password);
        LoginPage.clickLoginButton();
        AdminPage.authorizationCheck();
        System.out.println("Authorization successful");
        int newRoomNumber = (new SecureRandom()).nextInt(900) + 100;
        String newRoomType = ($("#type").$$("option").stream().map(option -> option.getAttribute("value")).toArray(String[]::new))[(new SecureRandom()).nextInt($("#type").$$("option").size())];
        System.out.println("Random room number and room type have been successfully generated");
        AdminPage.enterRoomNumber(newRoomNumber);
        AdminPage.selectRoomType(newRoomType);
        AdminPage.enterRoomAvailability(true);
        AdminPage.enterRoomPrice(150);
        if ((new SecureRandom()).nextBoolean()) {AdminPage.checkWifiCheckbox();}
        if ((new SecureRandom()).nextBoolean()) {AdminPage.checkTvCheckbox();}
        if ((new SecureRandom()).nextBoolean()) {AdminPage.checkRadioCheckbox();}
        if ((new SecureRandom()).nextBoolean()) {AdminPage.checkRefreshCheckbox();}
        if ((new SecureRandom()).nextBoolean()) {AdminPage.checkSafeCheckbox();}
        if ((new SecureRandom()).nextBoolean()) {AdminPage.checkViewsCheckbox();}
        AdminPage.clickCreateRoomButton();
        AdminPage.roomNumberCreationCheck(newRoomNumber);
        System.out.println("New room has been successfully created");
        System.out.println("New room number is " + newRoomNumber + " of " + newRoomType + " type");
        AdminPage.clickLogoutButton();
        System.out.println("Logout successful");
    }

}
