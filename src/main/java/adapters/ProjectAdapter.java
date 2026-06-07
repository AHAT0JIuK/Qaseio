package adapters;

import io.restassured.module.jsv.JsonSchemaValidator;
import models.CreateProjectRequest;
import models.CreateProjectResponse.CreateProjectResponse;
import models.DeleteProjectResponse;
import models.GetProjectResponce.GetProjectResponse;

import static io.restassured.RestAssured.given;

public class ProjectAdapter extends BaseAdapter {

    public static CreateProjectResponse createProject(CreateProjectRequest projectRequest, int expectedStatus) {
        return given()
                .spec(spec)
                .body(gson.toJson(projectRequest))
                .log().all()
                .when()
                .post("/project")
                .then()
                .body(JsonSchemaValidator.
                        matchesJsonSchemaInClasspath("schema/createProjectSchemaResponse.json"))
                .log().all()
                .spec(statusCode(expectedStatus))
                .extract()
                .as(CreateProjectResponse.class);
    }

    public static GetProjectResponse getProject(String code, String schemaPath, int expectedStatus) {
        return given()
                .spec(spec)
                .pathParam("code", code)
                .log().all()
                .when()
                .get("/project/{code}")
                .then()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath(schemaPath))
                .log().all()
                .spec(statusCode(expectedStatus))
                .extract()
                .as(GetProjectResponse.class);
    }

    public static DeleteProjectResponse deleteProject(String code, int expectedStatus) {
        return given()
                .spec(spec)
                .pathParam("code", code)
                .log().all()
                .when()
                .delete("/project/{code}")
                .then()
                .log().all()
                .spec(statusCode(expectedStatus))
                .extract()
                .as(DeleteProjectResponse.class);
    }
}
