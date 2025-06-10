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
	DataHelper dp = new DataHelper();
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
}
