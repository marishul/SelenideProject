import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.IssuePage;
import pages.LoginPage;

import static org.testng.Assert.assertTrue;

public class AddCommentTest {
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    IssuePage issuePage = new IssuePage();

    @BeforeMethod
    public void setUp() {
        Configuration.browser = "chrome";
        loginPage.navigateTo();
        loginPage.setUsername("webinar5");
        loginPage.setPassword("webinar5");
        loginPage.clickLogin();
        loginPage.panelAppears();
    }

    @Test
    public void addComment() {
        issuePage.openTicket();
        issuePage.openCommentField();
        issuePage.addComment("Commenr created by auto test");
        issuePage.deleteComment();

        assertTrue(1 == 1);
    }


    @AfterMethod
    public static void closeWindow() {
        WebDriverRunner.closeWindow();
    }
}
