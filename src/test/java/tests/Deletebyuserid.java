package tests;

import java.io.IOException;
import java.util.List;

import org.json.simple.JSONArray;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Base.baseclass;
import Commons.APIHelper;
import Commons.DataHelper;
import Commons.ExcelReader;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Deletebyuserid extends baseclass{
	APIHelper api = new APIHelper();
	ExcelReader read = new ExcelReader();
	SoftAssert softAssert = new SoftAssert();
	int casenumber;
	Response response;
	
	@Test(priority=1)
	public void DeleteCreatedUsers() throws IOException {
		casenumber = 10;
		String userFirstName = read.getuserdata(casenumber,0);
		response = api.getuserbyfirstname(200,userFirstName);
		String responsebody = response.asString();
		JsonPath responsejson = new JsonPath(responsebody);

		Object responseuserid = responsejson.get("userId");
		 List<?> userIdList = (List<?>) responseuserid;
	    String userid = userIdList.get(0).toString(); 
		response = api.deleteuserbyuserid(200,userid);
		responsebody = response.asString();
		responsejson = new JsonPath(responsebody);

		Object status = responsejson.get("status");
		Object message = responsejson.get("message");
					  
		softAssert.assertEquals(status,"Success","Incorrect status");
		softAssert.assertEquals(message,"User is deleted successfully","Incorrect message");
		softAssert.assertAll();
	}
	
	@Test(priority=2)
	public void deletedeleteduser() throws IOException {
		casenumber = 89;
		String userid = read.getuserdata(casenumber,12);
		String code = read.getuserdata(casenumber,10);
		int expectedstatuscode = Integer.parseInt(code);
		response = api.deleteuserbyuserid(expectedstatuscode,userid);
	}
	
	@Test(priority=3)
	public void deletealphanumeric() throws IOException {
		casenumber = 90;
		String userid = read.getuserdata(casenumber,12);
		String code = read.getuserdata(casenumber,10);
		int expectedstatuscode = Integer.parseInt(code);
		response = api.deleteuserbyuserid(expectedstatuscode,userid);
	}
	@Test(priority=4)
	public void deleteinvalid() throws IOException {
		casenumber = 91;
		String userid = read.getuserdata(casenumber,12);
		String code = read.getuserdata(casenumber,10);
		int expectedstatuscode = Integer.parseInt(code);
		response = api.deleteuserbyuserid(expectedstatuscode,userid);
	}
	@Test(priority=5)
	public void deleteblank() throws IOException {
		casenumber = 92;
		String userid = read.getuserdata(casenumber,12);
		String code = read.getuserdata(casenumber,10);
		int expectedstatuscode = Integer.parseInt(code);
		response = api.deleteuserbyuserid(expectedstatuscode,userid);
	}
	@Test(priority=6)
	public void delete0userid() throws IOException {
		casenumber = 93;
		String userid = read.getuserdata(casenumber,12);
		String code = read.getuserdata(casenumber,10);
		int expectedstatuscode = Integer.parseInt(code);
		response = api.deleteuserbyuserid(expectedstatuscode,userid);
	}
	@Test(priority=7)
	public void deletenegativeuserid() throws IOException {
		casenumber = 94;
		String userid = read.getuserdata(casenumber,12);
		String code = read.getuserdata(casenumber,10);
		int expectedstatuscode = Integer.parseInt(code);
		response = api.deleteuserbyuserid(expectedstatuscode,userid);
	}
	@Test(priority=8)
	public void deleteoutofrange() throws IOException {
		casenumber = 95;
		String userid = read.getuserdata(casenumber,12);
		String code = read.getuserdata(casenumber,10);
		int expectedstatuscode = Integer.parseInt(code);
		response = api.deleteuserbyuserid(expectedstatuscode,userid);
	}
	@Test(priority=9)
	public void deletenull() throws IOException {
		casenumber = 96;
		String userid = read.getuserdata(casenumber,12);
		String code = read.getuserdata(casenumber,10);
		int expectedstatuscode = Integer.parseInt(code);
		response = api.deleteuserbyuserid(expectedstatuscode,userid);
	}
	@Test(priority=10)
	public void deletepreceedingspace() throws IOException {
		casenumber = 97;
		String userid = read.getuserdata(casenumber,12);
		String code = read.getuserdata(casenumber,10);
		int expectedstatuscode = Integer.parseInt(code);
		response = api.deleteuserbyuserid(expectedstatuscode,userid);
	}

}
