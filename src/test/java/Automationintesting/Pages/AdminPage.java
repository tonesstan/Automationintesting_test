package Automationintesting.Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.*;

public class AdminPage {
    private static final SelenideElement roomsButton = $x("//a[text()='Rooms']");
    private static final SelenideElement reportButton = $x("//a[text()='Report']");
    private static final SelenideElement brandingButton = $x("//a[text()='Branding']");
    private static final SelenideElement mainPageButton = $x("//a[text()='B&B Booking Management']");
    private static final SelenideElement messagesButton = $("i.fa.fa-inbox");
    private static final SelenideElement frontPageButton = $x("//a[text()='Front Page']");
    private static final SelenideElement logoutButton = $x("//a[text()='Logout']");

    private static final SelenideElement roomNumberField = $("#roomName");
    private static final SelenideElement roomTypeSelect = $("#type");
    private static final SelenideElement roomAvailabilityField = $("#accessible");
    private static final SelenideElement roomPriceField = $("#roomPrice");

    private static final SelenideElement wifiCheckbox = $("#wifiCheckbox");
    private static final SelenideElement tvCheckbox = $("#tvCheckbox");
    private static final SelenideElement radioCheckbox = $("#radioCheckbox");
    private static final SelenideElement refreshCheckbox = $("#refreshCheckbox");
    private static final SelenideElement safeCheckbox = $("#safeCheckbox");
    private static final SelenideElement viewsCheckbox = $("#viewsCheckbox");

    private static final SelenideElement createRoomButton = $("#createRoom");

    public static void clickRoomsButton() {roomsButton.click();}
    public static void clickReportButton() {reportButton.click();}
    public static void clickBrandingButton() {brandingButton.click();}
    public static void clickMainPageButton() {mainPageButton.click();}
    public static void clickMessagesButton() {messagesButton.click();}
    public static void clickFrontPageButton() {frontPageButton.click();}
    public static void clickLogoutButton() {logoutButton.click();}

    public static void enterRoomNumber(int number) {roomNumberField.setValue(String.valueOf(number));}
    public static void selectRoomType(String type) {
        roomTypeSelect.click();
        $("option[value='" + type + "']").click();
    }
    public static void enterRoomAvailability(boolean availability) {
        roomAvailabilityField.click();
        $("option[value='" + availability + "']").click();
    }
    public static void enterRoomPrice(int price) {roomPriceField.setValue(String.valueOf(price));}

    public static void checkWifiCheckbox() {wifiCheckbox.setSelected(true);}
    public static void checkTvCheckbox() {tvCheckbox.setSelected(true);}
    public static void checkRadioCheckbox() {radioCheckbox.setSelected(true);}
    public static void checkRefreshCheckbox() {refreshCheckbox.setSelected(true);}
    public static void checkSafeCheckbox() {safeCheckbox.setSelected(true);}
    public static void checkViewsCheckbox() {viewsCheckbox.setSelected(true);}

    public static void uncheckWifiCheckbox() {wifiCheckbox.setSelected(false);}
    public static void uncheckTvCheckbox() {tvCheckbox.setSelected(false);}
    public static void uncheckRadioCheckbox() {radioCheckbox.setSelected(false);}
    public static void uncheckRefreshCheckbox() {refreshCheckbox.setSelected(false);}
    public static void uncheckSafeCheckbox() {safeCheckbox.setSelected(false);}
    public static void uncheckViewsCheckbox() {viewsCheckbox.setSelected(false);}

    public static void clickCreateRoomButton() {createRoomButton.click();}

    public static void authorizationCheck() {logoutButton.shouldBe(exist);}

    public static void roomNumberCreationCheck(int number) {$x("//p[text()='" + number + "']").shouldBe(exist);}
}
