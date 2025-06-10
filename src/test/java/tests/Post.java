package tests;

import java.io.IOException;
import java.util.HashMap;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import Base.baseclass;
import Commons.APIHelper;
import Commons.DataHelper;
import Commons.LoggerLoad;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class Post extends baseclass{
	DataHelper dp = new DataHelper();
	APIHelper api = new APIHelper();
	SoftAssert softAssert = new SoftAssert();
	int casenumber;
	String  postrequest;
	Response response;
	
	
	@Test(priority=1)
	public void CreateUser_WithAllFields() throws IOException {
		casenumber = 1;
		JsonPath responsejson = postandgetresponsejson(casenumber);
		validateallfields(responsejson);
		test.info("Test "+casenumber+" Executed");
	}
	 

	@Test(priority=2)
	public void CreateUser_WithOnlyMandatoryFields() throws IOException {
		casenumber = 2;
		JsonPath responsejson = postandgetresponsejson(casenumber);
		validatemandatoryfields(responsejson);
		test.info("Test "+casenumber+" Executed");
	}  
	
	@Test(priority=3)
	public void CreateUser_withoutfirstname() throws IOException {
		casenumber = 3;
		JsonPath responsejson = postandgetresponsejson(casenumber);
		validatefailmessage(responsejson);
		test.info("Test "+casenumber+" Executed");
	} 
	
	@Test(priority=4)
	public void CreateUser_withoutlastname() throws IOException {
		casenumber = 4;
		JsonPath responsejson = postandgetresponsejson(casenumber);
		validatefailmessage(responsejson);
		test.info("Test "+casenumber+" Executed");
	} 
	
	@Test(priority=5)
	public void CreateUser_withoutContactnumber() throws IOException {
		casenumber = 5;
		JsonPath responsejson = postandgetresponsejson(casenumber);
		validateerror(responsejson);
		test.info("Test "+casenumber+" Executed");
	}
	
	@Test(priority=6)
	public void CreateUser_withoutemailid() throws IOException {
		casenumber = 6;
		JsonPath responsejson = postandgetresponsejson(casenumber);
		validatefailmessage(responsejson);
		test.info("Test "+casenumber+" Executed");
	} 
	
	@Test(priority=7)
	public void CreateUser_duplicatecontactnumber() throws IOException {
		casenumber = 7;
		JsonPath responsejson = postandgetresponsejson(casenumber);
		validatefailmessage(responsejson);
		test.info("Test "+casenumber+" Executed");
	}
	
	@Test(priority=8)
	public void CreateUser_duplicateemailid() throws IOException {
		casenumber = 8;
		JsonPath responsejson = postandgetresponsejson(casenumber);
		validatefailmessage(responsejson);
		test.info("Test "+casenumber+" Executed");
	} 
	
	@Test(priority=9)
	public void CreateUser_withdeleteduserinformation() throws IOException {
		casenumber = 9;
		JsonPath responsejson = postandgetresponsejson(casenumber);
		test.info("Test "+casenumber+" Executed");
	}   
	
	@Test(priority=10)
	public void CreateUser_withduplicatenameandaddress() throws IOException {
		casenumber = 10;
		JsonPath responsejson = postandgetresponsejson(casenumber);
		validateallfields(responsejson);
		test.info("Test "+casenumber+" Executed");
	}   
	
	@Test(priority=11)
	public void CreateUser_invalidfirstname() throws IOException {
		casenumber = 11;
		JsonPath responsejson = postandgetresponsejson(casenumber);
		validatefailmessage(responsejson);
		test.info("Test "+casenumber+" Executed");
	} 
	
	@Test(priority=12)
	public void CreateUser_invalidlastname() throws IOException {
		casenumber = 12;
		JsonPath responsejson = postandgetresponsejson(casenumber);
		validatefailmessage(responsejson);
		test.info("Test "+casenumber+" Executed");
	} 
	
	@Test(priority=13)
	public void CreateUser_invalidcontactnumber() throws IOException {
		casenumber = 13;
		JsonPath responsejson = postandgetresponsejson(casenumber);
		validateerror(responsejson);
		test.info("Test "+casenumber+" Executed");
	} 
	
	@Test(priority=14)
	public void CreateUser_invalidemailid() throws IOException {
		casenumber = 14;
		JsonPath responsejson = postandgetresponsejson(casenumber);
		validatefailmessage(responsejson);
		test.info("Test "+casenumber+" Executed");
	} 
	
	@Test(priority=15)
	public void CreateUser_invalidplotnumber() throws IOException {
		casenumber = 15;
		JsonPath responsejson = postandgetresponsejson(casenumber);
		validatefailmessage(responsejson);
		test.info("Test "+casenumber+" Executed");
	} 
	
	@Test(priority=16)
	public void CreateUser_invalidstreet() throws IOException {
		casenumber = 16;
		JsonPath responsejson = postandgetresponsejson(casenumber);
		validatefailmessage(responsejson);
		test.info("Test "+casenumber+" Executed");
	} 
	@Test(priority=17)
	public void CreateUser_invalidstate() throws IOException {
		casenumber = 17;
		JsonPath responsejson = postandgetresponsejson(casenumber);
		validatefailmessage(responsejson);
		test.info("Test "+casenumber+" Executed");
	} 
	@Test(priority=18)
	public void CreateUser_invalidcountry() throws IOException {
		casenumber = 18;
		JsonPath responsejson = postandgetresponsejson(casenumber);
		validatefailmessage(responsejson);
		test.info("Test "+casenumber+" Executed");
	} 
	@Test(priority=19)
	public void CreateUser_invalidzipcode() throws IOException {
		casenumber = 19;
		JsonPath responsejson = postandgetresponsejson(casenumber);
		validateerror(responsejson);
		test.info("Test "+casenumber+" Executed");
	} 
	
	@Test(priority=20)
	public void CreateUser_invalidendpoint() throws IOException {
		casenumber = 20;
		dp.setvaluesforfield(casenumber);
		int expectedstatuscode = Integer.parseInt(dp.code);
		postrequest = dp.requestbodywithallfields();
		response = api.postuser_invalidrequestinformation(postrequest,expectedstatuscode,"createuserss","userapi@2025","application/json");
		String responsebody = response.asString();
		JsonPath responsejson = new JsonPath(responsebody);
		validateerror(responsejson);
		test.info("Test "+casenumber+" Executed");
	} 
	
	@Test(priority=21)
	public void CreateUser_invalidcredentials() throws IOException {
		casenumber = 21;
		dp.setvaluesforfield(casenumber);
		int expectedstatuscode = Integer.parseInt(dp.code);
		postrequest = dp.requestbodywithallfields();
		response = api.postuser_invalidrequestinformation(postrequest,expectedstatuscode,"createusers","abcd","application/json");
		String responsebody = response.asString();
		JsonPath responsejson = new JsonPath(responsebody);
		validateerror(responsejson);
		test.info("Test "+casenumber+" Executed");
	} 
	
	@Test(priority=22)
	public void CreateUser_invalidcontenttype() throws IOException {
		casenumber = 22;
		dp.setvaluesforfield(casenumber);
		int expectedstatuscode = Integer.parseInt(dp.code);
		postrequest = dp.requestbodywithallfields();
		response = api.postuser_invalidrequestinformation(postrequest,expectedstatuscode,"createusers","userapi@2025","application/xml");
		String responsebody = response.asString();
		JsonPath responsejson = new JsonPath(responsebody);
		validateerror(responsejson);
		test.info("Test "+casenumber+" Executed");
	}
	
	@Test(priority=23)
	public void CreateUser_nocontenttype() throws IOException {
		casenumber = 23;
		dp.setvaluesforfield(casenumber);
		int expectedstatuscode = Integer.parseInt(dp.code);
		postrequest = dp.requestbodywithallfields();
		response = api.postuser_invalidheaderstructure(postrequest,expectedstatuscode,"nocontenttype");
		String responsebody = response.asString();
		JsonPath responsejson = new JsonPath(responsebody);
		validateerror(responsejson);
		test.info("Test "+casenumber+" Executed");
	}
	
	@Test(priority=24)
	public void CreateUser_noauth() throws IOException {
		casenumber = 24;
		dp.setvaluesforfield(casenumber);
		int expectedstatuscode = Integer.parseInt(dp.code);
		postrequest = dp.requestbodywithallfields();
		response = api.postuser_invalidheaderstructure(postrequest,expectedstatuscode,"noauth");
		String responsebody = response.asString();
		JsonPath responsejson = new JsonPath(responsebody);
		validateerror(responsejson);
		test.info("Test "+casenumber+" Executed");
	} 
	
	
	//Common Non Test Methods.
	
	public JsonPath postandgetresponsejson(int casenumber) throws IOException {
		dp.setvaluesforfield(casenumber);
		int expectedstatuscode = Integer.parseInt(dp.code);
		postrequest = dp.requestbodywithallfields();
		response = api.postuser(postrequest,expectedstatuscode);
		String responsebody = response.asString();
		JsonPath responsejson = new JsonPath(responsebody);
		return responsejson;
	}
	
	public void validateallfields(JsonPath responsejson) {
		
		//Validation of values under main node
		
		//	softAssert.assertEquals(responsejson.getString("userFirstName"),dp.userFirstName,"Incorrect userFirstName");
		
		  Object userFirstName = responsejson.get("userFirstName");
		  Object userLastName = responsejson.get("userLastName");
		  Object userContactNumber = responsejson.get("userContactNumber");
		  Object userEmailId = responsejson.get("userEmailId");
		  Object userId = responsejson.get("userId");
		  Object creationTime = responsejson.get("creationTime");
		  Object lastModTime = responsejson.get("lastModTime");
		  
		  softAssert.assertEquals(userFirstName,dp.userFirstName,"Incorrect userFirstName");
		  softAssert.assertEquals(userLastName,dp.userLastName,"Incorrect userLastName");
		  softAssert.assertEquals(userContactNumber,Long.parseLong(dp.userContactNumber),"Incorrect userContactNumber");
		  softAssert.assertEquals(userEmailId,dp.userEmailId,"Incorrect userEmailId");
		  
		  softAssert.assertEquals(userFirstName.getClass().getSimpleName(),"String","userFirstName is not String");
		  softAssert.assertEquals(userLastName.getClass().getSimpleName(),"String","userLastName is not String");
		  softAssert.assertEquals(userContactNumber.getClass().getSimpleName(),"Long","userContactNumber is not Long");
		  softAssert.assertEquals(userEmailId.getClass().getSimpleName(),"String","userEmailId is not String");
		 
		  
		  //Validation of values under address node
		  
		  Object userAddress = responsejson.get("userAddress");
		  Object plotNumber = ((HashMap) userAddress).get("plotNumber");
		  Object street = ((HashMap) userAddress).get("street");
		  Object state = ((HashMap) userAddress).get("state");
		  Object country = ((HashMap) userAddress).get("country");
		  Object zipCode = ((HashMap) userAddress).get("zipCode");
		  Object addressId = ((HashMap) userAddress).get("addressId");
			
		softAssert.assertEquals(plotNumber,dp.plotNumber,"Incorrect plotNumber");
		softAssert.assertEquals(street,dp.street,"Incorrect street");
		softAssert.assertEquals(state,dp.state,"Incorrect state");
		softAssert.assertEquals(country,dp.country,"Incorrect country");
		softAssert.assertEquals(zipCode,Integer.parseInt(dp.zipCode),"Incorrect zipCode");
 
		
		softAssert.assertEquals(plotNumber.getClass().getSimpleName(),"String","plotNumber is not String");
		softAssert.assertEquals(street.getClass().getSimpleName(),"String","street is not String");
		softAssert.assertEquals(state.getClass().getSimpleName(),"String","state is not String");
		softAssert.assertEquals(country.getClass().getSimpleName(),"String","country is not String");
		softAssert.assertEquals(zipCode.getClass().getSimpleName(),"Integer","zipCode is not Integer");
		  
		softAssert.assertEquals(userId.getClass().getSimpleName(),"Integer","userId is not Integer");
		softAssert.assertEquals(addressId.getClass().getSimpleName(),"Integer","addressId is not Integer");
		softAssert.assertEquals(creationTime.getClass().getSimpleName(),"String","userId is not String");
		softAssert.assertEquals(lastModTime.getClass().getSimpleName(),"String","userId is not String");
		  
		  
		softAssert.assertAll();
	}
	
	public void validatemandatoryfields(JsonPath responsejson) {
		
		  Object userFirstName = responsejson.get("userFirstName");
		  Object userLastName = responsejson.get("userLastName");
		  Object userContactNumber = responsejson.get("userContactNumber");
		  Object userEmailId = responsejson.get("userEmailId");
		  Object userId = responsejson.get("userId");
		  Object creationTime = responsejson.get("creationTime");
		  Object lastModTime = responsejson.get("lastModTime");
		  
		  softAssert.assertEquals(userFirstName,dp.userFirstName,"Incorrect userFirstName");
		  softAssert.assertEquals(userLastName,dp.userLastName,"Incorrect userLastName");
		  softAssert.assertEquals(userContactNumber,Long.parseLong(dp.userContactNumber),"Incorrect userContactNumber");
		  softAssert.assertEquals(userEmailId,dp.userEmailId,"Incorrect userEmailId");
		  
		  softAssert.assertEquals(userFirstName.getClass().getSimpleName(),"String","userFirstName is not String");
		  softAssert.assertEquals(userLastName.getClass().getSimpleName(),"String","userLastName is not String");
		  softAssert.assertEquals(userContactNumber.getClass().getSimpleName(),"Long","userContactNumber is not Long");
		  softAssert.assertEquals(userEmailId.getClass().getSimpleName(),"String","userEmailId is not String");
				  
		  softAssert.assertEquals(userId.getClass().getSimpleName(),"Integer","userId is not Integer");
		  softAssert.assertEquals(creationTime.getClass().getSimpleName(),"String","userId is not String");
		  softAssert.assertEquals(lastModTime.getClass().getSimpleName(),"String","userId is not String");
		  
		  softAssert.assertAll();
	}
	
	public void validatefailmessage(JsonPath responsejson) {
		Object message = responsejson.get("message");
		String messageStr = message.toString();
		softAssert.assertTrue(messageStr.contains(dp.message), "Incorrect status message");
	}
	
	public void validateerror(JsonPath responsejson) {
		Object error = responsejson.get("error");
		String errorStr = error.toString();
		softAssert.assertTrue(errorStr.contains(dp.message), "Incorrect error message");
	}
	
}
