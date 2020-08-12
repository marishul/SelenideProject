package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class IssuePage {
    public void openTicket() {
        open("https://jira.hillel.it/browse/WEBINAR-12328");
    }

    public void openCommentField() {
        $(By.id("footer-comment-button")).click();
        $(By.xpath("//div[@id='comment-wiki-edit']//child::li[@data-mode='source']")).should(Condition.appear);
    }

    public void addComment(String comment) {
        $(By.xpath("//div[@id='comment-wiki-edit']//child::li[@data-mode='source']")).click();
        $(By.id("comment")).click();
        $(By.id("comment")).setValue(comment);
        $(By.id("issue-comment-add-submit")).click();
        $(By.xpath("//*[@id='issue_actions_container']//child::*[@class='action-body flooded']")).should(Condition.appear);
    }

    public void deleteComment() {
        $(By.xpath("//a[@class='delete-comment issue-comment-action']")).click();
        $(By.xpath("//div[@class='form-body']//child::*[contains(text(), 'delete this comment?')]")).should(Condition.appear);
        $(By.id("comment-delete-submit")).click();
        $(By.xpath("//div[@class='aui-message closeable aui-message-success aui-will-close']")).should(Condition.appear);
    }


}
