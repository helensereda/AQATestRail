package tests.api;

import baseEntities.BaseApiTest;
import models.Project;
import org.apache.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PostApiTest extends BaseApiTest {
    static Logger logger = LogManager.getLogger(PostApiTest.class);
    @Test
    public void addProjectTest1() {
        String endpoint = "/index.php?/api/v2/add_project";

        Project expectedProject = new Project();
        expectedProject.setProjectName("WP_Project_01");
        expectedProject.setAnnouncement("This is a description!!!");
        expectedProject.setProjectType(1);
        expectedProject.setFlag(true);

        given()
                .body(String.format("{\n" +
                                "  \"name\": \"%s\",\n" +
                                "  \"announcement\": \"%s\",\n" +
                                "  \"show_announcement\": %b,\n" +
                                "  \"suite_mode\" : %d\n" +
                                "}",
                        expectedProject.getProjectName(),
                        expectedProject.getAnnouncement(),
                        expectedProject.isFlag(),
                        expectedProject.getProjectType()
                ))
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }
}
