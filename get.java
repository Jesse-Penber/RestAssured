import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.*;
import io.restassured.response.Response;

public class Get {
	
	@Test
	public void testResponseCode() {
		
		Response response = RestAssured.get("https://samples.openweathermap.org/data/2.5/weather?zip=94040,us&appid=b6907d289e10d714a6e88b30761fae22");
		System.out.println("Status code is " + response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test
	public void testBody() {
		Response response = RestAssured.get("https://samples.openweathermap.org/data/2.5/weather?zip=94040,us&appid=b6907d289e10d714a6e88b30761fae22");
		String respString = response.asString();
		System.out.println("Data is" + respString);
		Assert.assertTrue(respString.contains("Mountain View"));
	}

	
	@Test
	public void testPerformance() {
		Response response = RestAssured.get("https://samples.openweathermap.org/data/2.5/weather?zip=94040,us&appid=b6907d289e10d714a6e88b30761fae22/");
		long time = response.time();
		System.out.println("The test took " + time + " ms");
		Assert.assertTrue(time < 5000);
	}

}
