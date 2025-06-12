package Commons;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import java.io.IOException;
import io.restassured.response.Response;

public class APIHelper{
	
	public static String baseurl,username,password;
	String requesturl;
	private Response response;
	ConfigReader config = new ConfigReader();
		
	public void setbaseurl(String baseurl) {
		this.baseurl = baseurl;
	}
	public void setusername(String username) {
		this.username = username;
	}
	public void setpassword(String password) {
		this.password = password;
	}
	
	public Response postuser(String postrequest, int code) throws IOException {
		String postendpoint = config.getpostendpoint();
		requesturl = baseurl + postendpoint;
		System.out.println(requesturl);
		response =  given().
						auth().preemptive().basic(username, password).
						contentType("application/json").            
						body(postrequest).
					when().
						post(""+requesturl+"").
					then().
						statusCode(code).log().body().extract().response();
		return response;
	}
	
	public Response postuser_invalidrequestinformation(String postrequest, int code, String endpoint, String usethispassword,String contenttype) throws IOException {
		requesturl = baseurl + endpoint;
		System.out.println(requesturl);
		response =  given().
						auth().preemptive().basic(username, usethispassword).
						contentType(contenttype).            
						body(postrequest).
					when().
						post(""+requesturl+"").
					then().
						statusCode(code).log().body().extract().response();
		return response;
	}
	
	public Response postuser_invalidheaderstructure(String postrequest, int code,String headerignore) throws IOException {
		String postendpoint = config.getpostendpoint();
		requesturl = baseurl + postendpoint;
		System.out.println(requesturl);
		
		if(headerignore.contentEquals("nocontenttype")) {
			response =  given().
							auth().preemptive().basic(username, password).
							body(postrequest).
						when().
							post(""+requesturl+"").
						then().
							statusCode(code).log().body().extract().response();
		}
		
		else if(headerignore.contentEquals("noauth")) {
			response =  given().
							contentType("application/json"). 
							body(postrequest).
						when().
							post(""+requesturl+"").
						then().
							statusCode(code).log().body().extract().response();
			}
		return response;
	}
	
	public Response deleteuserbyfirstname(int code, String firstname) throws IOException {
		String deleteendpoint = config.getdeletebyusernameendpoint();
		deleteendpoint = deleteendpoint+firstname;
		requesturl = baseurl + deleteendpoint;
		System.out.println(requesturl);
		response =  given().
						auth().preemptive().basic(username, password).
					when().
						delete(""+requesturl+"").
					then().
						statusCode(code).log().body().extract().response();
	return response;
	}
	
	public Response getuserbyfirstname(int code, String firstname) throws IOException {
		String getendpoint = config.get_getbyusernameendpoint();
		getendpoint = getendpoint+firstname;
		requesturl = baseurl + getendpoint;
		System.out.println(requesturl);
		response =  given().
						auth().preemptive().basic(username, password).
					when().
						get(""+requesturl+"").
					then().
						statusCode(code).log().body().extract().response();
	return response;
	}
	
	public Response getuserbyuserid(int code, String userid) throws IOException {
		String getendpoint = config.get_getbyuseridendpoint();
		getendpoint = getendpoint+userid;
		requesturl = baseurl + getendpoint;
		System.out.println(requesturl);
		response =  given().
						auth().preemptive().basic(username, password).
					when().
						get(""+requesturl+"").
					then().
						statusCode(code).log().body().extract().response();
	return response;
	}
	
	public Response deleteuserbyuserid(int code, String userid) throws IOException {
		String deleteendpoint = config.getdeletebyidendpoint();
		deleteendpoint = deleteendpoint+userid;
		requesturl = baseurl + deleteendpoint;
		System.out.println(requesturl);
		response =  given().
						auth().preemptive().basic(username, password).
					when().
						delete(""+requesturl+"").
					then().
						statusCode(code).log().body().extract().response();
	return response;
	}
	
	public Response patchuser(String patchrequest, int code,String userid) throws IOException {
		String patchendpoint = config.getpatchendpoint();
		patchendpoint=patchendpoint+userid;
		requesturl = baseurl + patchendpoint;
		System.out.println(requesturl);
		response =  given().
						auth().preemptive().basic(username, password).
						contentType("application/json").            
						body(patchrequest).
					when().
						patch(""+requesturl+"").
					then().
						statusCode(code).log().body().extract().response();
		return response;
	}
	
	public Response patchuserinvalidstructure(String patchrequest, int code,String userid) throws IOException {
		String patchendpoint = config.getpatchendpoint();
		patchendpoint=patchendpoint+userid;
		requesturl = baseurl + patchendpoint;
		System.out.println(requesturl);
		response =  given().
						contentType("application/json").            
						body(patchrequest).
					when().
						patch(""+requesturl+"").
					then().
						statusCode(code).log().body().extract().response();
		return response;
	}
	
	public Response putuser(String putrequest, int code, String userid,String contenttype) throws IOException {
		String putendpoint = config.getputendpoint();
		putendpoint=putendpoint+userid;
		requesturl = baseurl + putendpoint;
		contenttype = "application/"+contenttype;
		System.out.println(requesturl);
		response =  given().
						auth().preemptive().basic(username, password).
						contentType(contenttype).            
						body(putrequest).
					when().
						put(""+requesturl+"").
					then().
						statusCode(code).log().body().extract().response();
		return response;
	}
	
	public Response putuserincorrectheaderstructure(String putrequest, int code, String userid) throws IOException {
		String putendpoint = config.getputendpoint();
		putendpoint=putendpoint+userid;
		requesturl = baseurl + putendpoint;
		System.out.println(requesturl);
		response =  given().
						auth().preemptive().basic(username, password).
						contentType("application/xml").            
						body(putrequest).
					when().
						put(""+requesturl+"").
					then().
						statusCode(code).log().body().extract().response();
		return response;
	}
	
	public Response getalluser(int code,String test) throws IOException {
		String getallusersendpoint = config.getalluser();
		requesturl = baseurl + getallusersendpoint;
		System.out.println(requesturl);
		if (test.contentEquals("validheader")) {
			response =  given().
						auth().preemptive().basic(username, password).
					when().
						get(""+requesturl+"").
					then().
						statusCode(code).log().body().extract().response();
			}
		else if(test.contentEquals("unauthorized")){
			response =  given().
					auth().preemptive().basic(username, "abcd").
				when().
					get(""+requesturl+"").
				then().
					statusCode(code).log().body().extract().response();
		}
		
		else if(test.contentEquals("invalidendpoint")){
			response =  given().
					auth().preemptive().basic(username, password).
				when().
					get(""+requesturl+"1").
				then().
					statusCode(code).log().body().extract().response();
			}	
	return response;
	}
}
