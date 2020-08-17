package pages;
import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {

    public void navigateTo() {
        open("https://jira.hillel.it/secure/Dashboard.jspa");
    }

    public void setUsername(String name) {
        $(By.id("login-form-username")).setValue(name);
    }

    public void setPassword(String password) {
        $(By.id("login-form-password")).setValue(password);
    }

    public void clickLogin() {
        $("#login").click();
    }

    public void panelAppears() {
        $(By.id("header-details-user-fullname")).should(Condition.appear);
    }

    public void errorAppears() {
        $(By.id("usernameerror")).should(Condition.appear);

    }



}
