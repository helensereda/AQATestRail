package tests.api;

import baseEntities.BaseApiTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class PostApiTest extends BaseApiTest {
    static Logger logger = LogManager.getLogger(PostApiTest.class);
    @Test
    public void addMilestoneTest() {
        String endpoint = "/index.php?/api/v2/add_milestone";

    }
}
