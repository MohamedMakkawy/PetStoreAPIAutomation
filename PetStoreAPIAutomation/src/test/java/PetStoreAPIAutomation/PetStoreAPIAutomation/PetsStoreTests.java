package PetStoreAPIAutomation.PetStoreAPIAutomation;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;



import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;


import org.testng.annotations.AfterTest;


public class PetsStoreTests {

	
  @BeforeTest
  public void beforeTest() {
	  
      RestAssured.baseURI = "https://petstore.swagger.io/v2";

  }
  @Test(priority=1)	
  public void GetAvailablePets() {
	  Response response = given()
              .contentType(ContentType.JSON)
              .when()
              .get("/pet/findByStatus?status=available")
              .then()
              .extract().response();

	  assertEquals(response.statusCode(),200);
  }
  
  @Test(priority=2)	
  public void PostNewPets() throws Exception {
	  String file = "TestData\\PostNewPet.json";
      String requestBody = JsonReader.readFileAsString(file);

      Response response = given()
    		  .header("Content-Type", "application/json")
    		  .contentType(ContentType.JSON)
    		  .accept(ContentType.JSON)
              .and()
              .body(requestBody)
              .when()
              .post("/pet")
              .then()
              .extract().response();

      assertEquals(response.statusCode(),200);
  }
  
  @Test(priority=3)	
  public void PutNewPets() throws Exception {
	  String file = "TestData\\PutNewPet.json";
      String requestBody = JsonReader.readFileAsString(file);
      Response response = given()
    		  .header("Content-Type", "application/json")
    		  .contentType(ContentType.JSON)
    		  .accept(ContentType.JSON)
              .and()
              .body(requestBody)
              .when()
              .put("/pet")
              .then()
              .extract().response();

      assertEquals(response.statusCode(),200);
  }
  
  @Test(priority=4)	
  public void DeleteNewPets() {
	  Response response = given()
			  .header("Content-Type", "application/json")
    		  .contentType(ContentType.JSON)
    		  .accept(ContentType.JSON)
              .when()
              .delete("/pet/1104")
              .then()
              .extract().response();

      assertEquals(response.statusCode(),200);
  }
  
  
  @AfterTest
  public void afterTest() {
	  
  }

}
