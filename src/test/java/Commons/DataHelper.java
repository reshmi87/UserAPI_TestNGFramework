package Commons;

import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class DataHelper {
	int rownumber;
	public String userFirstName,userLastName, userContactNumber,userEmailId,plotNumber,street,state,country,zipCode,caseno,code,message,userid,patchbody,username,password;
	ExcelReader read = new ExcelReader();
	String postrequest;
		
	public void setvaluesforfield(int casenum) throws IOException {
		 this.rownumber = casenum;
		 userFirstName = read.getuserdata(rownumber,0);
		 userLastName = read.getuserdata(rownumber,1);
		 userContactNumber = read.getuserdata(rownumber,2);
		 userEmailId = read.getuserdata(rownumber,3);
		 plotNumber = read.getuserdata(rownumber,4);
		 street = read.getuserdata(rownumber,5);
		 state = read.getuserdata(rownumber,6);
		 country = read.getuserdata(rownumber,7);
		 zipCode = read.getuserdata(rownumber,8);
		 caseno = read.getuserdata(rownumber,9);
		 code = read.getuserdata(rownumber,10);
		 message = read.getuserdata(rownumber,11); 
		userid = read.getuserdata(rownumber,12);
		patchbody = read.getuserdata(rownumber,13);
	}
	
	public String requestbodywithallfields() {
		try {
	        ObjectMapper mapper = new ObjectMapper();
	        
	        ObjectNode requestbody = mapper.createObjectNode();
	        requestbody.put("userFirstName", userFirstName);
	        requestbody.put("userLastName", userLastName);
	        requestbody.put("userContactNumber",userContactNumber);
	        requestbody.put("userEmailId",userEmailId);
	        
	    	 ObjectNode address = mapper.createObjectNode();
	    	 address.put("plotNumber",plotNumber);
	    	 address.put("street",street);
	    	 address.put("state",state);
	    	 address.put("country",country);
	    	 address.put("zipCode",zipCode);
	    	 
	    	 requestbody.set("userAddress", address);
	    	 
	    	 postrequest = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(requestbody);
	         System.out.println(postrequest);

	    } catch (Exception e) {
	        e.printStackTrace();
	    }	
		 return postrequest;
	}

}
