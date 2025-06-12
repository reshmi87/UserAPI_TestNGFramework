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

public class DeletebyFirstName extends baseclass{
	APIHelper api = new APIHelper();
	ExcelReader read = new ExcelReader();
	SoftAssert softAssert = new SoftAssert();
	int casenumber;
	Response response;
	
	@Test(priority=1)
	public void DeleteCreatedUsers() throws IOException {
		casenumber = 1;
		String userFirstName = read.getuserdata(casenumber,0);
		response = api.deleteuserbyfirstname(200,userFirstName);
		casenumber = 9;
		userFirstName = read.getuserdata(casenumber,0);
		response = api.deleteuserbyfirstname(200,userFirstName);
		String responsebody = response.asString();
		JsonPath responsejson = new JsonPath(responsebody);

		Object status = responsejson.get("status");
		Object message = responsejson.get("message");
					  
		softAssert.assertEquals(status,"Success","Incorrect status");
		softAssert.assertEquals(message,"User is deleted successfully","Incorrect message");
	}
	
	@Test(priority=2)
	public void Firstnameincaps() throws IOException {
		casenumber = 76;
		String userFirstName = read.getuserdata(casenumber,0);
		String code = read.getuserdata(casenumber,10);
		int expectedstatuscode = Integer.parseInt(code);
		response = api.deleteuserbyfirstname(expectedstatuscode,userFirstName);
	}

	@Test(priority=3)
	public void Delete_deleteduser() throws IOException {
		casenumber = 77;
		String userFirstName = read.getuserdata(casenumber,0);
		String code = read.getuserdata(casenumber,10);
		int expectedstatuscode = Integer.parseInt(code);
		response = api.deleteuserbyfirstname(expectedstatuscode,userFirstName);
	}
	
	@Test(priority=4)
	public void Delete_nonexistentuser() throws IOException {
		casenumber = 78;
		String userFirstName = read.getuserdata(casenumber,0);
		String code = read.getuserdata(casenumber,10);
		int expectedstatuscode = Integer.parseInt(code);
		response = api.deleteuserbyfirstname(expectedstatuscode,userFirstName);
	}
	
	@Test(priority=5)
	public void deletenumericfirstname() throws IOException {
		casenumber = 79;
		String userFirstName = read.getuserdata(casenumber,0);
		String code = read.getuserdata(casenumber,10);
		int expectedstatuscode = Integer.parseInt(code);
		response = api.deleteuserbyfirstname(expectedstatuscode,userFirstName);
	}
	
	@Test(priority=6)
	public void deletealphanumericfirstname() throws IOException {
		casenumber = 80;
		String userFirstName = read.getuserdata(casenumber,0);
		String code = read.getuserdata(casenumber,10);
		int expectedstatuscode = Integer.parseInt(code);
		response = api.deleteuserbyfirstname(expectedstatuscode,userFirstName);
	}
	
	@Test(priority=7)
	public void deletespecialcharinfirstname() throws IOException {
		casenumber = 81;
		String userFirstName = read.getuserdata(casenumber,0);
		String code = read.getuserdata(casenumber,10);
		int expectedstatuscode = Integer.parseInt(code);
		response = api.deleteuserbyfirstname(expectedstatuscode,userFirstName);
	}
	
	@Test(priority=8)
	public void deletewithemptyfirstname() throws IOException {
		casenumber = 82;
		String userFirstName = read.getuserdata(casenumber,0);
		String code = read.getuserdata(casenumber,10);
		int expectedstatuscode = Integer.parseInt(code);
		response = api.deleteuserbyfirstname(expectedstatuscode,userFirstName);
	}
	
	@Test(priority=9)
	public void deletelengthyuserfirstname() throws IOException {
		casenumber = 83;
		String userFirstName = read.getuserdata(casenumber,0);
		response = api.deleteuserbyfirstname(404,userFirstName);
	}
	
	@Test(priority=10)
	public void deletewithleadingspaces() throws IOException {
		casenumber = 84;
		String userFirstName = read.getuserdata(casenumber,0);
		String code = read.getuserdata(casenumber,10);
		int expectedstatuscode = Integer.parseInt(code);
		response = api.deleteuserbyfirstname(expectedstatuscode,userFirstName);
	}
	
	@Test(priority=11)
	public void deletewithfirstname0() throws IOException {
		casenumber = 85;
		String userFirstName = read.getuserdata(casenumber,0);
		String code = read.getuserdata(casenumber,10);
		int expectedstatuscode = Integer.parseInt(code);
		response = api.deleteuserbyfirstname(expectedstatuscode,userFirstName);
	}
	
	@Test(priority=12)
	public void deletewithnegativeint() throws IOException {
		casenumber = 86;
		String userFirstName = read.getuserdata(casenumber,0);
		String code = read.getuserdata(casenumber,10);
		int expectedstatuscode = Integer.parseInt(code);
		response = api.deleteuserbyfirstname(expectedstatuscode,userFirstName);
	}
	
	@Test(priority=13)
	public void deletewithnull() throws IOException {
		casenumber = 87;
		String userFirstName = read.getuserdata(casenumber,0);
		String code = read.getuserdata(casenumber,10);
		int expectedstatuscode = Integer.parseInt(code);
		response = api.deleteuserbyfirstname(expectedstatuscode,userFirstName);
	}
	
	@Test(priority=14)
	public void deletewithfirstnameindoublequotes() throws IOException {
		casenumber = 88;
		String userFirstName = read.getuserdata(casenumber,0);
		String code = read.getuserdata(casenumber,10);
		int expectedstatuscode = Integer.parseInt(code);
		response = api.deleteuserbyfirstname(expectedstatuscode,userFirstName);
	}
}
