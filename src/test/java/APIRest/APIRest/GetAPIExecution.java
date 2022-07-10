package APIRest.APIRest;

import static org.hamcrest.Matchers.equalTo;

import com.api.utils.PropertiesCache;

import io.restassured.RestAssured;

public class GetAPIExecution {
	
	public static void getAPI(String baseuri) {
		
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

}
