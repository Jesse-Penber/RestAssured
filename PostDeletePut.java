import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostDeletePut {
	
	@Test
	public void Post(int id, String title, String author) {
		
		RestAssured.baseURI = "http://localhost:3000/posts";
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		JSONObject json = new JSONObject(); 
		json.put("id", id);
		json.put("title", title);
		json.put("author", author); 
		
		request.body(json.toString());
		Response response = request.post();
		
		int code = response.getStatusCode();
		Assert.assertEquals(code, 201);
	}
	
	@Test
	public void Delete(int id) {
		RestAssured.baseURI = "http://localhost:3000/posts";
		RequestSpecification request = RestAssured.given();
		Response response = request.delete(RestAssured.baseURI + id);
		int code = response.getStatusCode();
		Assert.assertEquals(code, 200);
		
	}
	
	@Test
	public void Put(int id, String title, String author) {
		RestAssured.baseURI = "http://localhost:3000/posts";
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		JSONObject json = new JSONObject(); 
		json.put("id", id);
		json.put("title", title);
		json.put("author", author);
		
		request.body(json.toString());
		Response response = request.put(RestAssured.baseURI + id);
		int code = response.getStatusCode();
		Assert.assertEquals(code, 200);
	}

}