package Modules;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import utilities.ExtentReport;
import utilities.GlobalUtils;

public class RamIssue {
	@Test
	public void ramIssue() throws IOException
	{
		ExtentReport er=new ExtentReport();
	    er.stepReport("RAM Issue : One Batch with 3 Products");
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream("Properties/Input.Properties");
		prop.load(file);
	    RestAssured.baseURI="http://52.71.76.46:3000/v1";
	    GlobalUtils.CoinID1="CID1"+utilities.ReadJsonFile.CurrentDate();
		GlobalUtils.CoinID2="CID2"+utilities.ReadJsonFile.CurrentDate();
		GlobalUtils.CoinID3="CID3"+utilities.ReadJsonFile.CurrentDate();
		 GlobalUtils.RamBatch = "RB"+utilities.ReadJsonFile.CurrentDate();
		String json=utilities.ReadJsonFile.generateStringFromResource("RamIssue.json");
	        json=json.replace("COINID1", GlobalUtils.CoinID1);
	        json=json.replace("COINID2", GlobalUtils.CoinID2);
	        json=json.replace("COINID3", GlobalUtils.CoinID3);
	        json=json.replace("RBatch", GlobalUtils.RamBatch);
	    Response a=RestAssured.given()
			  .header("Content-Type",prop.getProperty("Content-type"))
		      .header("x-api-secret",prop.getProperty("x-api-secret"))
		      .header("x-api-key",prop.getProperty("x-api-key"))
		      .body(json)
		      .when()
		      .post("/issue/ram")
		      .then().extract().response();
	  if(a.getStatusCode()==200)
	  {
		   JSONArray response=new JSONArray(a.asString());
	       JSONObject product1=response.getJSONObject(0);
	       JSONObject product2=response.getJSONObject(1);
	       JSONObject product3=response.getJSONObject(2);
	       String status[]=new String[4];
	       String reason[]=new String[4];
	       status[0]=product1.getString("status");
	       status[1]=product2.getString("status");
	       status[2]=product3.getString("status");
	       reason[0]=product1.getString("reason");
	       reason[1]=product2.getString("reason");
	       reason[2]=product3.getString("reason");
	       int j=1;
	       for(int i=0;i<=2;i++)
	       {
	    	   if(status[i].equals("Issued"))
	    	   {
	    		   System.out.println("The COIN ID"+j+" was issued sucessfully");
		  ExtentReport.test.log(Status.PASS, "RAM ISSUE - The COIN ID"+j+" was issued sucessfully");
		  ExtentReport.child.log(Status.PASS, a.asString());
		  j++;
	    	   }
	    	   else
	    	   {
	    		   System.out.println("The COIN ID"+j+" was not issued");
	       		System.out.println("Reason:"+reason[i]);
	    			  ExtentReport.test.log(Status.PASS, "RAM ISSUE - The COIN ID"+j+" was not issued, Reason:" +reason[i]);
	    			  ExtentReport.child.log(Status.PASS, a.asString());
	    			  j++;
	    	   }
	  }
	       }
	  else
      {
		  ExtentReport.test.log(Status.FAIL, "RAM ISSUE - The Response is : "+a.asString()+" The Status code is : "+a.getStatusCode());
		  ExtentReport.child.log(Status.FAIL, a.getStatusCode()+ " "+ a.asString());
	    	Assert.fail();
      }
	}
}
