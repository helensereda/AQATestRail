package tests.api;

import baseEntities.BaseApiTest;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.apache.http.protocol.HTTP;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.configuration.ReadProperties;

import static io.restassured.RestAssured.given;

public class GetApiTest extends BaseApiTest {
    static Logger logger = LogManager.getLogger(GetApiTest.class);
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
}
