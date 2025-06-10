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
	DataHelper dp = new DataHelper();
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
		
	}

}
