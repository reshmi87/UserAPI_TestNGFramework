package tests;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Base.baseclass;
import Commons.APIHelper;
import Commons.DataHelper;
import Commons.ExcelReader;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Get extends baseclass{
	DataHelper dp = new DataHelper();
	APIHelper api = new APIHelper();
	ExcelReader read = new ExcelReader();
	SoftAssert softAssert = new SoftAssert();
	int casenumber;
	Response response;
	
	@Test(priority=1)
	public void Get_alluser() throws IOException {
		casenumber = 73;
		String code = read.getuserdata(casenumber,10);
		int expectedstatuscode = Integer.parseInt(code);
		response = api.getalluser(expectedstatuscode, "validheader");
		String responsebody = response.asString();
		JsonPath responsejson = new JsonPath(responsebody);
		int userId = responsejson.getInt("[0].userId");
		String firstName = responsejson.getString("[0].userFirstName");
		String lastName = responsejson.getString("[0].userLastName");
		long contactNumber = responsejson.getLong("[0].userContactNumber");
		String email = responsejson.getString("[0].userEmailId");
		
		int addressId = responsejson.getInt("[0].userAddress.addressId");
		String plotNumber = responsejson.getString("[0].userAddress.plotNumber");
		String street = responsejson.getString("[0].userAddress.street");
		String state = responsejson.getString("[0].userAddress.state");
		String country = responsejson.getString("[0].userAddress.country");
		int zipCode = responsejson.getInt("[0].userAddress.zipCode");
		
		System.out.println("First User ID: "+userId);
		System.out.println("User First name: "+firstName);
		System.out.println("User Last Name: "+lastName);
		System.out.println("Contact number: "+contactNumber);
		System.out.println("Email: "+email);
		System.out.println("Address plot number: "+plotNumber);
		System.out.println("Street: "+street);
		System.out.println("State: "+state);
		System.out.println("Country: "+country);
		System.out.println("ZipCode: "+zipCode);
		test.info("Test "+casenumber+" Executed");
	}
	
	@Test(priority=2)
	public void Get_invalidauth() throws IOException {
		casenumber = 74;
		String code = read.getuserdata(casenumber,10);
		int expectedstatuscode = Integer.parseInt(code);
		response = api.getalluser(expectedstatuscode, "unauthorized");
		test.info("Test "+casenumber+" Executed");
	}
	
	@Test(priority=3)
	public void Get_invalidendpoint() throws IOException {
		casenumber = 75;
		String code = read.getuserdata(casenumber,10);
		int expectedstatuscode = Integer.parseInt(code);
		response = api.getalluser(expectedstatuscode, "invalidendpoint");
		test.info("Test "+casenumber+" Executed");
	}

}
