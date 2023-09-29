package tests.api;

import baseEntities.BaseApiTest;
import io.qameta.allure.Description;
import models.Milestone;
import org.apache.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import io.restassured.mapper.ObjectMapperType;
import utils.Endpoints;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
public class PostApiTest extends BaseApiTest {
    static Logger logger = LogManager.getLogger(PostApiTest.class);
    @Test(description = "тест на создание milestone", groups = "regression")
    @Description("Positive test")
    public void addMilestone(){
        logger.info(token);
        int projectId = 6;
        Milestone expectedMilestone = Milestone.builder()
                .name("TestMilestone 1")
                .build();

        Response response = given()
                .body(expectedMilestone, ObjectMapperType.GSON)
                .pathParam("project_id",projectId)
                .when()
                .post(Endpoints.ADD_MILESTONE)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .body("name",is(expectedMilestone.getName()))
                .extract()
                .response();
    }
}
