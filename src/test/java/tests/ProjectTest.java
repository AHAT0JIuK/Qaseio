package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class ProjectTest extends BaseTest {

    private final String PROJECT_NAME = "123";
    private final String PROJECT_CODE = "XXX";

    @Test
    @Description("Проверка создания нового проекта")
    @Feature("Менеджер проектов")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("QATASK-001")
    @Issue("QASE-001")
    @Owner("Светлов А.А.")
    public void checkCreateProject() {
        $(byText("Create new project")).click();
        $("#project-name").setValue(PROJECT_NAME);
        $("#project-code").setValue(PROJECT_CODE);
        $(byText("Create project")).click();
        $("h2").shouldHave(exactText(PROJECT_NAME));
        $("h1").shouldHave(text(PROJECT_CODE));
    }

    @Test
    @Description("Проверка удаления проекта")
    @Feature("Менеджер проектов")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("QATASK-002")
    @Issue("QASE-001")
    @Owner("Светлов А.А.")
    public void checkDeleteProject() {
        // добавил слипов потому что без них на тормознутом ВПНе тест не проходил
        sleep(3000);
        $(byText(PROJECT_NAME))
                .ancestor("tr")
                .find("button[aria-label='Open action menu']")
                .click();
        sleep(1000);
        $("[data-testid=remove]").click();
        sleep(1000);
        $x("//span[text()='Delete project']").click();
        sleep(1000);
        // собираю коллекцию проектов и проверяю, что в ней нет удаленного проекта
        $$x("//small/parent::div/a")
                // жду появления элементов на странице
                .shouldHave(sizeGreaterThan(0))
                // фильтрую коллекцию по имени проекта
                .filterBy(text(PROJECT_NAME))
                // ожидаю, что удаленного проекта нет в коллекции и после фильтрации она пустая
                .shouldHave(size(0));
    }
}
