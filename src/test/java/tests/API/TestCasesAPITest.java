package tests.API;

import io.qameta.allure.*;
import models.CreateTestCaseRequest;
import models.CreateTestCaseResponse.CreateTestCaseResponse;
import models.DeleteTestCaseResponse.DeleteTestCaseResponse;
import models.GetTestCaseResponse.GetTestCaseResponse;
import models.UpdateTestCaseRequest;
import models.UpdateTestCaseResponse.UpdateTestCaseResponse;
import org.testng.annotations.Test;

import static adapters.TestCaseAdapter.*;
import static org.testng.Assert.*;

public class TestCasesAPITest {

    private final String PROJECT_CODE = "DEMO";

    CreateTestCaseRequest request = CreateTestCaseRequest.builder()
            .stepsType("classic")
            .description("description")
            .preconditions("preconditions")
            .postconditions("postconditions")
            .title("title")
            .severity(5)
            .priority(1)
            .behavior(3)
            .type(2)
            .layer(3)
            .isFlaky(0)
            .automation(1)
            .status(1)
            .createdAt("07.06.2026")
            .updatedAt("07.06.2026")
            .build();

    UpdateTestCaseRequest updateRequest = UpdateTestCaseRequest.builder()
            .stepsType("gherkin")
            .description("description2")
            .preconditions("preconditions2")
            .postconditions("postconditions2")
            .title("title2")
            .severity(4)
            .priority(2)
            .behavior(2)
            .type(1)
            .layer(2)
            .isFlaky(1)
            .automation(0)
            .status(0)
            .build();

    @Test
    @Description("Проверка создания нового тест-кейса через API")
    @Feature("Менеджер тест-кейсов")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("QATASK-006")
    @Issue("QASE-002")
    @Owner("Светлов А.А.")
    public void checkCreateTestCase() {
        CreateTestCaseResponse response = createTestCase(request, PROJECT_CODE, 200);
        assertTrue(response.status);
    }

    @Test
    @Description("Проверка получения существующего тест-кейса через API")
    @Feature("Менеджер тест-кейсов")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("QATASK-007")
    @Issue("QASE-002")
    @Owner("Светлов А.А.")
    public void checkGetTestCase() {
        CreateTestCaseResponse createResponse = createTestCase(request, PROJECT_CODE, 200);
        GetTestCaseResponse getResponse = getTestCase(PROJECT_CODE, createResponse.result.id,
                "schema/getTestCaseSchemaResponseSuccess.json", 200);
        assertTrue(getResponse.status);
        assertNull(getResponse.result.stepsType);
        assertEquals(getResponse.result.description, request.getDescription());
        assertEquals(getResponse.result.preconditions, request.getPreconditions());
        assertEquals(getResponse.result.postconditions, request.getPostconditions());
        assertEquals(getResponse.result.title, request.getTitle());
        assertEquals(getResponse.result.severity, request.getSeverity());
        assertEquals(getResponse.result.priority, request.getPriority());
        assertEquals(getResponse.result.behavior, request.getBehavior());
        assertEquals(getResponse.result.type, request.getType());
        assertEquals(getResponse.result.layer, request.getLayer());
        assertEquals(getResponse.result.isFlaky, request.getIsFlaky());
        assertEquals(getResponse.result.automation, request.getAutomation());
        assertEquals(getResponse.result.status, request.getStatus());
        assertEquals(getResponse.result.createdAt, "2026-06-07T00:00:00+00:00");
        assertEquals(getResponse.result.updatedAt, "2026-06-07T00:00:00+00:00");
    }

    @Test
    @Description("Проверка удаления существующего тест-кейса через API")
    @Feature("Менеджер тест-кейсов")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("QATASK-008")
    @Issue("QASE-002")
    @Owner("Светлов А.А.")
    public void checkDeleteTestCase() {
        CreateTestCaseResponse createResponse = createTestCase(request, PROJECT_CODE, 200);
        DeleteTestCaseResponse deleteResponse = deleteTestCase(PROJECT_CODE,
                createResponse.result.id, 200);
        assertTrue(deleteResponse.status);
        assertEquals(deleteResponse.result.id, createResponse.result.id);
        GetTestCaseResponse getResponse = getTestCase(PROJECT_CODE, createResponse.result.id,
                "schema/getTestCaseSchemaResponseUnsuccess.json", 404);
        assertFalse(getResponse.status);
        assertEquals(getResponse.errorMessage, "TestCase not found");
    }

    @Test
    @Description("Проверка обновления существующего тест-кейса через API")
    @Feature("Менеджер тест-кейсов")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("QATASK-009")
    @Issue("QASE-002")
    @Owner("Светлов А.А.")
    public void checkUpdateTestCase() {
        CreateTestCaseResponse createResponse = createTestCase(request, PROJECT_CODE, 200);
        UpdateTestCaseResponse updateResponse = updateTestCase(updateRequest, PROJECT_CODE,
                createResponse.result.id, 200);
        assertTrue(updateResponse.status);
        assertEquals(updateResponse.result.id, createResponse.result.id);
    }
}
