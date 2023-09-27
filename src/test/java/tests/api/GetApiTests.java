package tests.api;

import baseEntities.BaseApiTest;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.apache.http.protocol.HTTP;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import utils.configuration.ReadProperties;
import static io.restassured.RestAssured.given;
public class GetApiTests extends BaseApiTest {
    static Logger logger = LogManager.getLogger(GetApiTests.class);
    @Test
    public void getAllUsers() {
        String endpoint = "/index.php?/api/v2/get_users";

        logger.info(token);

        given()
                .auth().preemptive().basic(ReadProperties.username(), ReadProperties.password())
                .header(HTTP.CONTENT_TYPE, ContentType.JSON)
                .when()
                .get(endpoint)
                .then()
                .log().status()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }
    @Test
    public void getAllProjects() {
        String endpoint = "/index.php?/api/v2/get_projects";

        logger.info(token);

        given()
                .auth().preemptive().basic(ReadProperties.username(), ReadProperties.password())
                .header(HTTP.CONTENT_TYPE, ContentType.JSON)
                .when()
                .get(endpoint)
                .then()
                .log().status()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }
    @Test
    public void getNegativeTestForProject() {
        String endpoint = "/index.php?/api/v2/get_projects";

        logger.info(token);

        given()
                .auth().preemptive().basic(ReadProperties.username(), ReadProperties.password())
                .header(HTTP.CONTENT_TYPE, ContentType.JSON)
                .when()
                .get(endpoint)
                .then()
                .log().status()
                .log().body()
                .statusCode(HttpStatus.SC_BAD_REQUEST);
    }
}
