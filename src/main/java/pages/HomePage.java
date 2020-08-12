package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertTrue;

public class HomePage {

    public void clickCreate() {
        $("#create_link").click();
    }

    public void isModalPresence() {
        $(By.id("project-field")).should(Condition.appear);
    }

    public void setProjectField() {
        $(By.id("project-field")).click();
        $(By.id("project-field")).setValue("Webinar (WEBINAR)");
        $(By.id("project-field")).pressTab();
        $(By.id("issuetype-field")).should(Condition.enabled);
    }

    public void setIssueField() {
        $(By.id("issuetype-field")).click();
        $(By.id("issuetype-field")).setValue("Task");
        $(By.id("issuetype-field")).pressEnter();
        $(By.id("issuetype-field")).should(Condition.enabled);
    }

    public void setSummary(String summary) {
        $(By.id("summary")).setValue(summary);
    }

    public void setReporter() {
        $(By.id("reporter-field")).click();
        $(By.id("reporter-field")).setValue("webinar5");
    }

    public void submitIssue() {
        $(By.id("create-issue-submit")).click();
    }

    public void isConfirmationPresence() {
        WebElement popUP = $(By.cssSelector("div[class='aui-message closeable aui-message-success aui-will-close'] a[class='issue-created-key issue-link']")).should(Condition.appear);
    String ticketName = popUP.getAttribute("data-issue-key");
        assertTrue(ticketName.contains("WEBINAR"));
    }


}


