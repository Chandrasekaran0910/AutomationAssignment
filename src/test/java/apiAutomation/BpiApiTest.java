package apiAutomation;

import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class BpiApiTest {

	@Test
    public void testBpi() {
		
        // Send a GET request to the API
        Response response = RestAssured.given()
        		.baseUri("https://api.coindesk.com")
                .when()
                .get("/v1/bpi/currentprice.json")
                .then()
                .extract()
                .response();

        // Assert that the status code is 200
        Assertions.assertEquals(200, response.getStatusCode(), "Response status code is not 200");

        // Extract the "bpi" object from the response JSON
        Map<String, Object> bpi = response.jsonPath().getMap("bpi");

        // Verify that the response contains the three BPIs: USD, GBP, and EUR
        Assertions.assertTrue(bpi.containsKey("USD"), "USD is missing in the response");
        Assertions.assertTrue(bpi.containsKey("GBP"), "GBP is missing in the response");
        Assertions.assertTrue(bpi.containsKey("EUR"), "EUR is missing in the response");

        // Verify that the GBP 'description' equals 'British Pound Sterling'
        Map<String, Object> gbpDetails = (Map<String, Object>) bpi.get("GBP");
        String gbpDescription = (String) gbpDetails.get("description");
        Assertions.assertEquals("British Pound Sterling", gbpDescription, "GBP description does not match");
    }
}
