package com.components.ra.implement;

import java.util.Map;

import com.components.ra.driver.IAuthentication;
import com.components.ra.driver.RestAssuredDriver;

import io.restassured.RestAssured;

public class RestAssuredDriverFactory {

	public static RestAssuredDriver initDriver(Map<String, String> parameters, IAuthentication auth) {
		RestAssured.useRelaxedHTTPSValidation();
		RestAssured.urlEncodingEnabled=true;
		//instantiate driver
		return new RestAssuredDriver(auth);
	}
	
	
	public static RestAssuredDriver initDriver(Map<String, String> parameters) {
		RestAssured.useRelaxedHTTPSValidation();
		RestAssured.urlEncodingEnabled=true;
		//instantiate driver
		return new RestAssuredDriver();
	}

}
