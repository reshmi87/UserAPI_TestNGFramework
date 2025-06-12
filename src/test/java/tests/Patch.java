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

public class Patch extends baseclass{
	DataHelper dp = new DataHelper();
	APIHelper api = new APIHelper();
	SoftAssert softAssert = new SoftAssert();
	int casenumber;
	String  patchrequest;
	Response response;
	
	
	@Test(priority=1)
	public void Patchfirstname() throws IOException {
		casenumber = 40;
		JsonPath responsejson = patchandgetresponsejson(casenumber);
		Object userFirstName = responsejson.get("userFirstName");
		softAssert.assertEquals(userFirstName,dp.userFirstName,"Incorrect userFirstName");
		softAssert.assertAll();
		test.info("Test "+casenumber+" Executed");
	}
	
	@Test(priority=2)
	public void Patchlastname() throws IOException {
		casenumber = 41;
		JsonPath responsejson = patchandgetresponsejson(casenumber);
		Object userLastName = responsejson.get("userLastName");
		softAssert.assertEquals(userLastName,dp.userLastName,"Incorrect userLastName");
		softAssert.assertAll();
		test.info("Test "+casenumber+" Executed");
	}
	
	@Test(priority=3)
	public void Patchmultipleuserfields() throws IOException {
		casenumber = 42;
		JsonPath responsejson = patchandgetresponsejson(casenumber);
		Object userFirstName = responsejson.get("userFirstName");
		softAssert.assertEquals(userFirstName,dp.userFirstName,"Incorrect userFirstName");
		Object userAddress = responsejson.get("userAddress");
		Object street = ((HashMap) userAddress).get("street");
		softAssert.assertEquals(street,dp.street,"Incorrect street");
		softAssert.assertAll();
		test.info("Test "+casenumber+" Executed");
	}
	
	@Test(priority=4)
	public void Patch_emptyStreet() throws IOException {
		casenumber = 43;
		JsonPath responsejson = patchandgetresponsejson(casenumber);
		test.info("Test "+casenumber+" Executed");
	}
	
	@Test(priority=5)
	public void Patch_invalidemail() throws IOException {
		casenumber = 44;
		JsonPath responsejson = patchandgetresponsejson(casenumber);
		test.info("Test "+casenumber+" Executed");
	}
	
	@Test(priority=6)
	public void Patch_nonexistentuser() throws IOException {
		casenumber = 45;
		JsonPath responsejson = patchandgetresponsejson(casenumber);
		test.info("Test "+casenumber+" Executed");
	}
	
	@Test(priority=7)
	public void Patch_emptymandatoryfields() throws IOException {
		casenumber = 46;
		JsonPath responsejson = patchandgetresponsejson(casenumber);
		test.info("Test "+casenumber+" Executed");
	}
	
	@Test(priority=8)
	public void Patch_alphanumericphonenumber() throws IOException {
		casenumber = 47;
		JsonPath responsejson = patchandgetresponsejson(casenumber);
		test.info("Test "+casenumber+" Executed");
	}
	
	@Test(priority=9)
	public void Patch_emptystate() throws IOException {
		casenumber = 48;
		JsonPath responsejson = patchandgetresponsejson(casenumber);
		test.info("Test "+casenumber+" Executed");
	}
	
	@Test(priority=10)
	public void Patch_noauth() throws IOException {
		casenumber = 49;
		dp.setvaluesforfield(casenumber);
		int expectedstatuscode = Integer.parseInt(dp.code);
		patchrequest = dp.patchbody;
		response = api.patchuserinvalidstructure(patchrequest,expectedstatuscode,dp.userid);
		test.info("Test "+casenumber+" Executed");
	}
	
	@Test(priority=11)
	public void Patch_toinitialvalues() throws IOException {
		casenumber = 50;
		JsonPath responsejson = patchandgetresponsejson(casenumber);
		test.info("Test "+casenumber+" Executed");
	}
	
	public JsonPath patchandgetresponsejson(int casenumber) throws IOException {
		dp.setvaluesforfield(casenumber);
		int expectedstatuscode = Integer.parseInt(dp.code);
		patchrequest = dp.patchbody;
		response = api.patchuser(patchrequest,expectedstatuscode,dp.userid);
		String responsebody = response.asString();
		JsonPath responsejson = new JsonPath(responsebody);
		return responsejson;
	}

}
