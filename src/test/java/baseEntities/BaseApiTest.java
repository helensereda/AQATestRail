package baseEntities;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.protocol.HTTP;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import utils.configuration.ReadProperties;
import static io.restassured.RestAssured.given;

public class BaseApiTest {
    protected String token;

    @BeforeTest
    public void setupUriApi() {
        RestAssured.baseURI = ReadProperties.getUrl();

        RestAssured.requestSpecification = given()
                .auth().preemptive().basic(ReadProperties.username(), ReadProperties.password())
                .header(HTTP.CONTENT_TYPE, ContentType.JSON);
    }

    @BeforeClass
    public void setupApi() {
        token = "test";
    }
}