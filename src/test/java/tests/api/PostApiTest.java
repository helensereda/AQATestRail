package tests.api;

import baseEntities.BaseApiTest;
import models.Milestone;
import org.apache.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PostApiTest extends BaseApiTest {
    static Logger logger = LogManager.getLogger(PostApiTest.class);
    @Test
    public void addMilestoneTest() {
        String endpoint = "/index.php?/api/v2/add_milestone";
        Milestone expectedMilestone = new Milestone();
        expectedMilestone.setName("WP_Milestone_01");

        given()
                .body(String.format("{\n" +
                        "  \"name\": \"%s\",\n" +
                        "}",
                        expectedMilestone.getName()
                ))
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }
}
