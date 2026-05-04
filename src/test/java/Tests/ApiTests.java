package Tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ApiTests {

    @Test(description = "API 1: Get All Products List")
    public void testGetAllProducts() {

        // 1. Tell Java where the server is (Just like pasting the URL in Postman)
        RestAssured.baseURI = "https://automationexercise.com";

        // 2. Build the request and hit SEND
        Response response = given()
                .when()
                .get("/api/productsList")
                .then()
                .extract().response(); // This grabs the response so we can look at it

        // 3. Print the JSON body to the IntelliJ Console (Just like the bottom half of Postman)
        System.out.println("SERVER RESPONSE:");
        System.out.println(response.asPrettyString());

        // 4. The Senior QA Assertions
        System.out.println("Status Code: " + response.statusCode());
        Assert.assertEquals(response.statusCode(), 200, "The server crashed or rejected us!");
    }



    @Test(description = "API 7: POST To Verify Login with valid details")
    public void testVerifyLogin() {

        // 1. Set the Base URL
        RestAssured.baseURI = "https://automationexercise.com";

        // 2. Build the POST request with the exact Payload we used in Postman
        Response response = given()
                .contentType("application/x-www-form-urlencoded") // Tells the server we are sending a form
                .formParam("email", "omar.2@g2ail.com") // Replace with your dummy email if needed
                .formParam("password", "123456")
                .when()
                .post("/api/verifyLogin")
                .then()
                .extract().response();

        // 3. Print the response so we can see it
        System.out.println("LOGIN RESPONSE:");
        System.out.println(response.asPrettyString());

        // 4. The Senior QA Assertions (Checking the JSON Body)
        // We use jsonPath() to read the exact keys out of the JSON response!
        int jsonResponseCode = response.jsonPath().getInt("responseCode");
        String jsonMessage = response.jsonPath().getString("message");

        Assert.assertEquals(jsonResponseCode, 200, "The response code in the JSON was wrong!");
        Assert.assertEquals(jsonMessage, "User exists!", "The login message was incorrect!");
    }
}