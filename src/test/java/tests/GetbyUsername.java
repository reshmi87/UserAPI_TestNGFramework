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

public class GetbyUsername  extends baseclass{
	DataHelper dp = new DataHelper();
	APIHelper api = new APIHelper();
	ExcelReader read = new ExcelReader();
	SoftAssert softAssert = new SoftAssert();
	int casenumber;
	Response response;
	
	@Test(priority=1)
	public void Get_validfirstname() throws IOException {
		casenumber = 25;
		dp.setvaluesforfield(casenumber);
		int expectedstatuscode = Integer.parseInt(dp.code);
		response = api.getuserbyfirstname(expectedstatuscode,dp.userFirstName);
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
		
		
		List<Map<String, Object>> userAddressList = (List<Map<String, Object>>) responsejson.get("userAddress");
		Map<String, Object> firstAddress = userAddressList.get(0); 
		Object plotNumber = firstAddress.get("plotNumber");
		Object street = firstAddress.get("street");
		Object state = firstAddress.get("state");
		Object country = firstAddress.get("country");
		Object zipCode = firstAddress.get("zipCode");
			
		softAssert.assertEquals(plotNumber,dp.plotNumber,"Incorrect plotNumber");
		softAssert.assertEquals(street,dp.street,"Incorrect street");
		softAssert.assertEquals(state,dp.state,"Incorrect state");
		softAssert.assertEquals(country,dp.country,"Incorrect country");
		softAssert.assertEquals(zipCode,Integer.parseInt(dp.zipCode),"Incorrect zipCode");
	}
	

	@Test(priority=2)
	public void Get_nonexistingfirstname() throws IOException {
		casenumber = 26;
		String userFirstName = read.getuserdata(casenumber,0);
		String code = read.getuserdata(casenumber,10);
		int expectedstatuscode = Integer.parseInt(code);
		response = api.getuserbyfirstname(expectedstatuscode,userFirstName);
	}
	
	@Test(priority=3)
	public void Get_caseSensitivefirstname() throws IOException {
		casenumber = 27;
		String userFirstName = read.getuserdata(casenumber,0);
		String code = read.getuserdata(casenumber,10);
		int expectedstatuscode = Integer.parseInt(code);
		response = api.getuserbyfirstname(expectedstatuscode,userFirstName);
	}
	
	@Test(priority=4)
	public void Get_nofirstname() throws IOException {
		casenumber = 28;
		String userFirstName = read.getuserdata(casenumber,0);
		String code = read.getuserdata(casenumber,10);
		int expectedstatuscode = Integer.parseInt(code);
		response = api.getuserbyfirstname(expectedstatuscode,userFirstName);
	}
	
	@Test(priority=5)
	public void Get_longfirstname() throws IOException {
		casenumber = 29;
		String userFirstName = read.getuserdata(casenumber,0);
		String code = read.getuserdata(casenumber,10);
		int expectedstatuscode = Integer.parseInt(code);
		response = api.getuserbyfirstname(expectedstatuscode,userFirstName);
	}
	
	@Test(priority=6)
	public void Get_lastname() throws IOException {
		casenumber = 30;
		String userFirstName = read.getuserdata(casenumber,1);
		String code = read.getuserdata(casenumber,10);
		int expectedstatuscode = Integer.parseInt(code);
		response = api.getuserbyfirstname(expectedstatuscode,userFirstName);
	}
	}
