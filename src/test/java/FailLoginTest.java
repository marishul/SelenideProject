import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

import static org.testng.Assert.assertTrue;


public class FailLoginTest {
    LoginPage loginPage = new LoginPage();

    @BeforeMethod
    public void setUp() {
        Configuration.browser = "chrome";
    }

    @DataProvider(name = "Logins")
    public Object[][] createData1() {
        return new Object[][]{
                {"webinar5", "wrong"},
                {"wrong", "webinar5"},
                {"fake", "fake"},
        };
    }

    @Test(dataProvider = "Logins")
    public void failedLogin(String login, String pass) {
        loginPage.navigateTo();
        loginPage.setUsername(login);
        loginPage.setPassword(pass);
        loginPage.clickLogin();
        loginPage.errorAppears();

        assertTrue(1==1);
    }

    @AfterMethod
    public static void closeWindow() {
        WebDriverRunner.closeWindow();
    };
}
