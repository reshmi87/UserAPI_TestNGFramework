package tests;

import java.io.IOException;
import java.util.HashMap;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Base.baseclass;
import Commons.APIHelper;
import Commons.DataHelper;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Put  extends baseclass{
	DataHelper dp = new DataHelper();
	APIHelper api = new APIHelper();
	SoftAssert softAssert = new SoftAssert();
	int casenumber;
	String  putrequest;
	Response response;
	
	
	@Test(priority=1)
	public void Put_Validfields() throws IOException {
		casenumber = 51;
		JsonPath responsejson = putandgetresponsejson(casenumber);

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
		
		softAssert.assertAll();
		test.info("Test "+casenumber+" Executed");
	}
	
	@Test(priority=2)
	public void Put_invaliduser() throws IOException {
		casenumber = 52;
		JsonPath responsejson = putandgetresponsejson(casenumber);
		test.info("Test "+casenumber+" Executed");
	}
	
	@Test(priority=3)
	public void Put_duplicate_email_contactnum() throws IOException {
		casenumber = 53;
		JsonPath responsejson = putandgetresponsejson(casenumber);
		test.info("Test "+casenumber+" Executed");
	}
	
	@Test(priority=4)
	public void Put_emptyaddressvalues() throws IOException {
		casenumber = 54;
		JsonPath responsejson = putandgetresponsejson(casenumber);
		test.info("Test "+casenumber+" Executed");
	}
	
	@Test(priority=5)
	public void Put_missingfirstname() throws IOException {
		casenumber = 55;
		JsonPath responsejson = putandgetresponsejson(casenumber);
		test.info("Test "+casenumber+" Executed");
	}
	
	@Test(priority=6)
	public void Put_zipcodeas0() throws IOException {
		casenumber = 56;
		JsonPath responsejson = putandgetresponsejson(casenumber);
		test.info("Test "+casenumber+" Executed");
	}
	
	@Test(priority=7)
	public void Put_missinglastname() throws IOException {
		casenumber = 57;
		JsonPath responsejson = putandgetresponsejson(casenumber);
		test.info("Test "+casenumber+" Executed");
	}
	
	@Test(priority=8)
	public void Put_missingcontactnum() throws IOException {
		casenumber = 58;
		JsonPath responsejson = putandgetresponsejson(casenumber);
		test.info("Test "+casenumber+" Executed");
	}
	
	@Test(priority=9)
	public void Put_missingemailid() throws IOException {
		casenumber = 59;
		JsonPath responsejson = putandgetresponsejson(casenumber);
		test.info("Test "+casenumber+" Executed");
	}
	
	@Test(priority=10)
	public void Put_firstandlastnamewithnumber() throws IOException {
		casenumber = 60;
		JsonPath responsejson = putandgetresponsejson(casenumber);
		test.info("Test "+casenumber+" Executed");
	}
	
	@Test(priority=11)
	public void Put_plotnum_withouthyphen() throws IOException {
		casenumber = 61;
		JsonPath responsejson = putandgetresponsejson(casenumber);
		test.info("Test "+casenumber+" Executed");
	}
	
	@Test(priority=12)
	public void Put_numericstate() throws IOException {
		casenumber = 62;
		JsonPath responsejson = putandgetresponsejson(casenumber);
		test.info("Test "+casenumber+" Executed");
	}
	
	@Test(priority=13)
	public void Put_nonstringfirstname() throws IOException {
		casenumber = 63;
		JsonPath responsejson = putandgetresponsejson(casenumber);
		test.info("Test "+casenumber+" Executed");
	}
	
	@Test(priority=14)
	public void Put_nonstringlastname() throws IOException {
		casenumber = 64;
		JsonPath responsejson = putandgetresponsejson(casenumber);
		test.info("Test "+casenumber+" Executed");
	}
	
	@Test(priority=15)
	public void Put_contactnum_withalpphabets() throws IOException {
		casenumber = 65;
		JsonPath responsejson = putandgetresponsejson(casenumber);
		test.info("Test "+casenumber+" Executed");
	}
	
	@Test(priority=16)
	public void Put_improperemailid() throws IOException {
		casenumber = 66;
		JsonPath responsejson = putandgetresponsejson(casenumber);
		test.info("Test "+casenumber+" Executed");
	}
	
	@Test(priority=17)
	public void Put_nonstringplotnumber() throws IOException {
		casenumber = 67;
		JsonPath responsejson = putandgetresponsejson(casenumber);
		test.info("Test "+casenumber+" Executed");
	}
	
	@Test(priority=18)
	public void Put_numericinstreet() throws IOException {
		casenumber = 68;
		JsonPath responsejson = putandgetresponsejson(casenumber);
		test.info("Test "+casenumber+" Executed");
	}
	
	@Test(priority=19)
	public void Put_alphanumericzipcode() throws IOException {
		casenumber = 69;
		JsonPath responsejson = putandgetresponsejson(casenumber);
		test.info("Test "+casenumber+" Executed");
	}
	
	@Test(priority=20)
	public void Put_numericcountry() throws IOException {
		casenumber = 70;
		JsonPath responsejson = putandgetresponsejson(casenumber);
		test.info("Test "+casenumber+" Executed");
	}
	@Test(priority=21)
	public void Put_incorrectconytenttype() throws IOException {
		casenumber = 71;
		JsonPath responsejson = putandgetresponsejson(casenumber);
		test.info("Test "+casenumber+" Executed");
	}
	@Test(priority=22)
	public void Put_resetoriginalvalues() throws IOException {
		casenumber = 72;
		JsonPath responsejson = putandgetresponsejson(casenumber);
		test.info("Test "+casenumber+" Executed");
	}
	
	public JsonPath putandgetresponsejson(int casenumber) throws IOException {
		dp.setvaluesforfield(casenumber);
		int expectedstatuscode = Integer.parseInt(dp.code);
		putrequest = dp.requestbodywithallfields();
		if(casenumber ==71)
			response = api.putuser(putrequest,expectedstatuscode,dp.userid,"xml");
		else
			response = api.putuser(putrequest,expectedstatuscode,dp.userid,"json");
		String responsebody = response.asString();
		JsonPath responsejson = new JsonPath(responsebody);
		return responsejson;
	}
}
