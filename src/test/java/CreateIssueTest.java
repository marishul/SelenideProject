import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class CreateIssueTest {
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    @BeforeMethod
    public void setUp() {
        Configuration.browser = "chrome";
        loginPage.navigateTo();
        loginPage.setUsername("webinar5");
        loginPage.setPassword("webinar5");
        loginPage.clickLogin();
        loginPage.verifyIfPanelPresence();
    }

    @Test
    public void createIssue() {
        homePage.clickCreate();
        homePage.isModalPresence();
        homePage.setProjectField();
        homePage.setIssueField();
        homePage.setSummary("Created by auto tests");
        homePage.setReporter();
        homePage.submitIssue();
        homePage.isConfirmationPresence();

    }

    @AfterMethod
    public void closeWindow() {
        Selenide.closeWindow();
    }
}

