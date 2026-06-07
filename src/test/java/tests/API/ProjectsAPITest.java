package tests.API;

import io.qameta.allure.*;
import models.CreateProjectRequest;
import models.CreateProjectResponse.CreateProjectResponse;
import models.DeleteProjectResponse;
import models.GetProjectResponce.GetProjectResponse;
import org.testng.annotations.Test;

import static adapters.ProjectAdapter.*;
import static org.testng.Assert.*;

public class ProjectsAPITest {

    CreateProjectRequest request = CreateProjectRequest.builder()
            .title("123")
            .code("SSS")
            .description("API test")
            .access("all")
            .group("PLS")
            .build();

    @Test
    @Description("Проверка создания нового проекта через API")
    @Feature("Менеджер проектов")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("QATASK-003")
    @Issue("QASE-001")
    @Owner("Светлов А.А.")
    public void checkCreateProject() {
        CreateProjectResponse response = createProject(request, 200);
        assertTrue(response.status);
        assertEquals(response.result.code, request.getCode());
        deleteProject(request.getCode(), 200);
    }

    @Test
    @Description("Проверка получения сцществующего проекта через API")
    @Feature("Менеджер проектов")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("QATASK-004")
    @Issue("QASE-001")
    @Owner("Светлов А.А.")
    public void checkGetProject() {
        createProject(request, 200);
        GetProjectResponse response = getProject(request.getCode(),
                "schema/getProjectSchemaResponseSuccess.json", 200);
        assertTrue(response.status);
        assertEquals(response.result.code, request.getCode());
        assertEquals(response.result.counts.cases, 0);
        assertEquals(response.result.counts.suites, 0);
        assertEquals(response.result.counts.milestones, 0);
        assertEquals(response.result.counts.runs.total, 0);
        assertEquals(response.result.counts.runs.active, 0);
        assertEquals(response.result.counts.defects.total, 0);
        assertEquals(response.result.counts.defects.open, 0);
        deleteProject(request.getCode(), 200);
    }

    @Test
    @Description("Проверка удаления существующего проекта через API")
    @Feature("Менеджер проектов")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("QATASK-005")
    @Issue("QASE-001")
    @Owner("Светлов А.А.")
    public void checkDeleteProject() {
        createProject(request, 200);
        DeleteProjectResponse deleteResponse = deleteProject(request.getCode(), 200);
        assertTrue(deleteResponse.status);
        GetProjectResponse getResponse = getProject(request.getCode(),
                "schema/getProjectSchemaResponseUnsuccess.json", 404);
        assertFalse(getResponse.status);
        assertEquals(getResponse.errorMessage, "Project not found");
    }
}
