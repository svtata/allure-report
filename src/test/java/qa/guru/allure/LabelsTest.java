package qa.guru.allure;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LabelsTest {
    @Test
    @Feature("Issue в репозитории")
    @Story("Создание Issue")
    @Owner("sverchkovatv")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://testing/github.com")
    @DisplayName("Создание Issue для авторизованного пользователя")
    public void staticLabelsTest(){
    }

    @Test
    public void dynamicLabelsTest(){
        Allure.getLifecycle().updateTestCase(t -> t.setName("Создание Issue для авторизованного пользователя"));
        Allure.feature("Issue в репозитории");
        Allure.story("Создание Issue");
        Allure.label("Owner", "sverchkovatv");
        Allure.label("Severity", SeverityLevel.CRITICAL.value());
        Allure.link("Testing","https://testing/github.com");
    }
}
