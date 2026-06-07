package adapters;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import utils.PropertyReader;

public class BaseAdapter {

    public static Gson gson = new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .setPrettyPrinting()
            .create();
    protected static String token = System.getProperty("token", PropertyReader.getProperty("token"));
    public static RequestSpecification spec = new RequestSpecBuilder()
            .setContentType(ContentType.JSON)
            .setBaseUri("https://api.qase.io")
            .setBasePath("/v1")
            .addHeader("Token", token)
            .build();

    public static ResponseSpecification statusCode(int Code) {
        return new ResponseSpecBuilder()
                .expectStatusCode(Code)
                .build();
    }
}
