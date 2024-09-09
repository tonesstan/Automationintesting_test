package Automationintesting.Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
    private static final SelenideElement letMeHackButton = $x("//button[text()='Let me hack!']");
    private static final SelenideElement logo = $x("//h2[@data-testid='login-header']");
    private static final SelenideElement userName = $("#username");
    private static final SelenideElement password = $("#password");
    private static final SelenideElement loginButton = $("#doLogin");

    public static void moveWelcomePage() {if(letMeHackButton.exists()) {letMeHackButton.click();}}

    public static void waitForPageLoad() {logo.shouldBe(visible).shouldHave(text("Log into your account"));}

    public static void enterUserName(String name) {userName.setValue(name);}

    public static void enterPassword(String pass) {password.setValue(pass);}

    public static void clickLoginButton() {loginButton.click();}
}
