import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;


public class SelenideLoginTest {
    LoginPage loginPage = new LoginPage();

    @BeforeMethod
    public void setUp() {
        Configuration.browser = "chrome";
    }

    @Test
    public void loginTest() {
        loginPage.navigateTo();
        loginPage.setUsername("webinar5");
        loginPage.setPassword("webinar5");
        loginPage.clickLogin();
        loginPage.verifyIfPanelPresence();

    }

    @AfterMethod
    public static void closeWindow() {
        WebDriverRunner.closeWindow();
    };
}
