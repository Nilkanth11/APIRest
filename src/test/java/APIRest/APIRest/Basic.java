package APIRest.APIRest;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import com.api.utils.PropertiesCache;

public class Basic {
	
	static String baseuri = PropertiesCache.getInstance().getProperty("baseuri");		

	@Test
	public static void basicTest() {
		RestAssured.baseURI = baseuri;
		
		RestAssured
		.given()
			.param("latitude", "28.6353")
			.param("longitude", "77.2250")
			.param("timeformat", "unixtime")
			.param("timezone", "Asia/Singapore")
			.param("timeformat", "unixtime")
			.param("daily", "weathercode").log().all()
		.when()
			.get("/v1/forecast")
		.then()
			.log()
			.all()
			.assertThat().statusCode(200).and().body("daily_units.time", equalTo("unixtime"))
			.log().all();
		
	}
	
	public static String basicTestExtract() {
		RestAssured.baseURI = baseuri;
		
		String response = RestAssured
		.given()
			.param("latitude", "28.6353")
			.param("longitude", "77.2250")
			.param("timeformat", "unixtime")
			.param("timezone", "Asia/Singapore")
			.param("timeformat", "unixtime")
			.param("daily", "weathercode").log().all()
		.when()
			.get("/v1/forecast")
		.then()
			.log()
			.all()
			.assertThat().statusCode(200).and().extract().response().asString();
		
		JsonPath jp = new JsonPath(response);
		return jp.get("daily_units.time");
		
	}
	
	@Test
	public static void printRespone() {
		System.out.println("Response is " + basicTestExtract());
	}
	
}
