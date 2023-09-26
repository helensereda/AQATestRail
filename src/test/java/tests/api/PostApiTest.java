package tests.api;

import baseEntities.BaseApiTest;
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
//    @Test
//    public void addMilestoneTest() {
//        int projectId=2;
//        String endpoint = "/index.php?/api/v2/add_milestone/{project_id}";
//        Milestone expectedMilestone = new Milestone();
//        expectedMilestone.setName("WP_Milestone_01");
//        expectedMilestone.setDue_on(1394596385);
//
//        given()
//                .body(String.format("{\n" +
//                        "  \"name\": \"%s\",\n" +
//                                "  \"due_on\": \"%d\",\n" +
//                        "}",
//                        expectedMilestone.getName(),
//                        expectedMilestone.getDue_on()
//                ))
//                .pathParam("project_id", projectId)
//                .log().body()
//                .when()
//                .post(endpoint)
//                .then()
//                .log().body()
//                .statusCode(HttpStatus.SC_OK);
//    }
    @Test
    public void addMilestone(){
        int projectId = 2;
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
