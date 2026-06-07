package adapters;

import io.restassured.mapper.ObjectMapperType;
import io.restassured.module.jsv.JsonSchemaValidator;
import models.CreateTestCaseRequest;
import models.CreateTestCaseResponse.CreateTestCaseResponse;
import models.DeleteTestCaseResponse.DeleteTestCaseResponse;
import models.GetTestCaseResponse.GetTestCaseResponse;
import models.UpdateTestCaseRequest;
import models.UpdateTestCaseResponse.UpdateTestCaseResponse;

import static io.restassured.RestAssured.given;

public class TestCaseAdapter extends BaseAdapter {

    public static CreateTestCaseResponse createTestCase(CreateTestCaseRequest testCaseRequest, String code,
                                                        int expectedStatus) {
        return given()
                .spec(spec)
                .pathParam("code", code)
                .body(gson.toJson(testCaseRequest))
                .log().all()
                .when()
                .post("/case/{code}")
                .then()
                .body(JsonSchemaValidator.
                        matchesJsonSchemaInClasspath("schema/createTestCaseSchemaResponse.json"))
                .log().all()
                .spec(statusCode(expectedStatus))
                .extract()
                .as(CreateTestCaseResponse.class);
    }

    public static GetTestCaseResponse getTestCase(String code, int id, String schemaPath, int expectedStatus) {
        return given()
                .spec(spec)
                .pathParam("code", code)
                .pathParam("id", id)
                .log().all()
                .when()
                .get("/case/{code}/{id}")
                .then()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath(schemaPath))
                .log().all()
                .spec(statusCode(expectedStatus))
                .extract()
                .as(GetTestCaseResponse.class, ObjectMapperType.GSON);
    }

    public static DeleteTestCaseResponse deleteTestCase(String code, int id, int expectedStatus) {
        return given()
                .spec(spec)
                .pathParam("code", code)
                .pathParam("id", id)
                .log().all()
                .when()
                .delete("/case/{code}/{id}")
                .then()
                .body(JsonSchemaValidator.
                        matchesJsonSchemaInClasspath("schema/deleteTestCaseSchemaResponse.json"))
                .log().all()
                .spec(statusCode(expectedStatus))
                .extract()
                .as(DeleteTestCaseResponse.class);
    }

    public static UpdateTestCaseResponse updateTestCase(UpdateTestCaseRequest testCaseRequest, String code, int id,
                                                        int expectedStatus) {
        return given()
                .spec(spec)
                .pathParam("code", code)
                .pathParam("id", id)
                .body(gson.toJson(testCaseRequest))
                .log().all()
                .when()
                .patch("/case/{code}/{id}")
                .then()
                .body(JsonSchemaValidator.
                        matchesJsonSchemaInClasspath("schema/updateTestCaseSchemaResponse.json"))
                .log().all()
                .spec(statusCode(expectedStatus))
                .extract()
                .as(UpdateTestCaseResponse.class);
    }
}
