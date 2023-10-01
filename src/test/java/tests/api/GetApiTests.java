package tests.api;

import baseEntities.BaseApiTest;
import io.qameta.allure.Description;
import io.qameta.allure.testng.Tag;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.apache.http.protocol.HTTP;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import utils.Endpoints;
import utils.configuration.ReadProperties;
import static io.restassured.RestAssured.given;
public class GetApiTests extends BaseApiTest {
    static Logger logger = LogManager.getLogger(GetApiTests.class);
    @Test(description = "получение всех пользователей", groups = "regression")
    @Description("Positive test")
    public void getAllUsers() {

        logger.info(token);

        given()
                .auth().preemptive().basic(ReadProperties.username(), ReadProperties.password())
                .header(HTTP.CONTENT_TYPE, ContentType.JSON)
                .when()
                .get(Endpoints.GET_ALL_USERS)
                .then()
                .log().status()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }
    @Test(description = "получение всех проектов", groups = "regression")
    @Description("Positive test")
    public void getAllProjects() {

        logger.info(token);

        given()
                .auth().preemptive().basic(ReadProperties.username(), ReadProperties.password())
                .header(HTTP.CONTENT_TYPE, ContentType.JSON)
                .when()
                .get(Endpoints.GET_ALL_PROJECTS)
                .then()
                .log().status()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }
//    @Test(description = "не получение всех проектов", groups = "regression")
//    @Description("Negative test")
//    @Tag("FailureTest")
//    public void getNegativeTestForProject() {
//
//        logger.info(token);
//
//        given()
//                .auth().preemptive().basic(ReadProperties.username(), ReadProperties.password())
//                .header(HTTP.CONTENT_TYPE, ContentType.JSON)
//                .when()
//                .get(Endpoints.GET_ALL_PROJECTS)
//                .then()
//                .log().status()
//                .log().body()
//                .statusCode(HttpStatus.SC_BAD_REQUEST);
//    }
}
