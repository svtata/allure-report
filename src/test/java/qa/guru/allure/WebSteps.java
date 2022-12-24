package qa.guru.allure;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.commands.TakeScreenshot;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.linkText;


public class WebSteps {
    @Step("Открываем главную страницу")
    public void openMainPage(String page) {
        open(page);
    }

    @Step("Ищем репозиторий по имени")
    public void searchForRepository(String repository) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repository);
        $(".header-search-input").submit();
    }

    @Step("Открываем репозиторий {repository}")
    public void openLink(String repository) {
        $(linkText(repository)).click();
    }

    @Step("Открываем вкладку с задачами")
    public void openIssueTab() {
        $("#issues-tab").click();
    }

    @Step("Проверяем, что заголовок задачи виден")
    public void checkIssueTitle(String title) {
        $("#issue_76_link").shouldHave(text(title)).shouldBe(Condition.visible);
    }

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot)WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

}
