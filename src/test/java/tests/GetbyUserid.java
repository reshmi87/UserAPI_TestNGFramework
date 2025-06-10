package tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Base.baseclass;
import Commons.APIHelper;
import Commons.DataHelper;
import Commons.ExcelReader;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetbyUserid extends baseclass{
	DataHelper dp = new DataHelper();
	APIHelper api = new APIHelper();
	ExcelReader read = new ExcelReader();
	SoftAssert softAssert = new SoftAssert();
	int casenumber;
	Response response;
	
	@Test(priority=1)
	public void Get_validuserid() throws IOException {
		casenumber = 31;
		dp.setvaluesforfield(casenumber);
		int expectedstatuscode = Integer.parseInt(dp.code);
		response = api.getuserbyuserid(expectedstatuscode,dp.userid);
		String responsebody = response.asString();
		JsonPath responsejson = new JsonPath(responsebody);

		Object userFirstName = responsejson.get("userFirstName");
		Object userLastName = responsejson.get("userLastName");
		Object userContactNumber = responsejson.get("userContactNumber");
		Object userEmailId = responsejson.get("userEmailId");
				  
		softAssert.assertEquals(userFirstName,dp.userFirstName,"Incorrect userFirstName");
		softAssert.assertEquals(userLastName,dp.userLastName,"Incorrect userLastName");
		softAssert.assertEquals(userContactNumber,Long.parseLong(dp.userContactNumber),"Incorrect userContactNumber");
		softAssert.assertEquals(userEmailId,dp.userEmailId,"Incorrect userEmailId");
		
		
		  Object userAddress = responsejson.get("userAddress");
		  Object plotNumber = ((HashMap) userAddress).get("plotNumber");
		  Object street = ((HashMap) userAddress).get("street");
		  Object state = ((HashMap) userAddress).get("state");
		  Object country = ((HashMap) userAddress).get("country");
		  Object zipCode = ((HashMap) userAddress).get("zipCode");
			
		softAssert.assertEquals(plotNumber,dp.plotNumber,"Incorrect plotNumber");
		softAssert.assertEquals(street,dp.street,"Incorrect street");
		softAssert.assertEquals(state,dp.state,"Incorrect state");
		softAssert.assertEquals(country,dp.country,"Incorrect country");
		softAssert.assertEquals(zipCode,Integer.parseInt(dp.zipCode),"Incorrect zipCode");
	}

	@Test(priority=2)
	public void Get_useridwithspace() throws IOException {
		casenumber = 32;
		String userid = read.getuserdata(casenumber,12);
		String code = read.getuserdata(casenumber,10);
		int expectedstatuscode = Integer.parseInt(code);
		response = api.getuserbyuserid(expectedstatuscode,userid);
	}
	
	@Test(priority=3)
	public void Get_invaliduserid() throws IOException {
		casenumber = 33;
		String userid = read.getuserdata(casenumber,12);
		String code = read.getuserdata(casenumber,10);
		int expectedstatuscode = Integer.parseInt(code);
		response = api.getuserbyuserid(expectedstatuscode,userid);
	}
	
	@Test(priority=4)
	public void Get_useridwithspecialcharacters() throws IOException {
		casenumber = 34;
		String userid = read.getuserdata(casenumber,12);
		String code = read.getuserdata(casenumber,10);
		int expectedstatuscode = Integer.parseInt(code);
		response = api.getuserbyuserid(expectedstatuscode,userid);
	}
	
	@Test(priority=5)
	public void Get_6digituserid() throws IOException {
		casenumber = 35;
		String userid = read.getuserdata(casenumber,12);
		String code = read.getuserdata(casenumber,10);
		int expectedstatuscode = Integer.parseInt(code);
		response = api.getuserbyuserid(expectedstatuscode,userid);
	}
	
	@Test(priority=6)
	public void Get_withnulluserid() throws IOException {
		casenumber = 36;
		String userid = read.getuserdata(casenumber,12);
		String code = read.getuserdata(casenumber,10);
		int expectedstatuscode = Integer.parseInt(code);
		response = api.getuserbyuserid(expectedstatuscode,userid);
	}
	
	@Test(priority=7)
	public void Get_floatuserid() throws IOException {
		casenumber = 37;
		String userid = read.getuserdata(casenumber,12);
		String code = read.getuserdata(casenumber,10);
		int expectedstatuscode = Integer.parseInt(code);
		response = api.getuserbyuserid(expectedstatuscode,userid);
	}
	
	@Test(priority=8)
	public void Get_longuserid() throws IOException {
		casenumber = 38;
		String userid = read.getuserdata(casenumber,12);
		String code = read.getuserdata(casenumber,10);
		int expectedstatuscode = Integer.parseInt(code);
		response = api.getuserbyuserid(expectedstatuscode,userid);
	}
	
	@Test(priority=9)
	public void Get_booleanuserid() throws IOException {
		casenumber = 39;
		String code = read.getuserdata(casenumber,10);
		int expectedstatuscode = Integer.parseInt(code);
		response = api.getuserbyuserid(expectedstatuscode,"true");
	}
}
