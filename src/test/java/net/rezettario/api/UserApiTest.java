package net.rezettario.api;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class UserApiTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/foods/11")
          .then()
             .statusCode(200)
             .body(is("hello11"));
    }

}