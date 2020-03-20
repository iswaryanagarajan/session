package Modules;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import utilities.ExtentReport;
import utilities.GlobalUtils;

public class DistributorIssue {
	public void distributorissue() throws IOException
	{
		ExtentReport er=new ExtentReport();
	    er.stepReport("Distributor Issue : One Batch with 3 Products");
		Properties prop=new Properties();
		FileInputStream file=new FileInputStream("Properties\\Input.Properties");
		prop.load(file);
		RestAssured.baseURI=prop.getProperty("baseURL");
		String json=utilities.ReadJsonFile.generateStringFromResource("DistributorIssue.json");
        json=json.replace("MBatch1", GlobalUtils.MBatch1);
        json=json.replace("MBatch2", GlobalUtils.MBatch2);
        json=json.replace("MBatch3", GlobalUtils.MBatch3);
        json=json.replace("ChipID1", GlobalUtils.ChipID1);
        json=json.replace("ChipID2", GlobalUtils.ChipID2);
        json=json.replace("ChipID3", GlobalUtils.ChipID3);
		Response a=RestAssured.given()
			        .header("Content-Type",prop.getProperty("Content-type"))
			        .header("x-api-secret",prop.getProperty("x-api-secret"))
			        .header("x-api-key",prop.getProperty("x-api-key"))
			        .body(json)
			        .when()
			        .post("issue/distributor")
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
 		  
 		   System.out.println("The Distributor ID"+j+" was issued sucessfully");
 		  ExtentReport.test.log(Status.PASS, "Distributor ISSUE - The Distributor ID"+j+" was issued sucessfully");
 		 ExtentReport.child.log(Status.PASS, a.asString());
 		   j++;
 	   }
 	   else
 	   {
 		System.out.println("The Distributor ID"+j+" was not issued");
 		System.out.println("Reason:"+reason[i]);
 		 ExtentReport.test.log(Status.PASS, "Distributor ISSUE - The Distributor ID"+j+" was not issued sucessfully. Reason:"+ reason[i]);
 		ExtentReport.child.log(Status.PASS, a.asString());
		   j++;
 	   }
    }
	        }
	       else
	       {
	    	   ExtentReport.test.log(Status.FAIL, "Distributor ISSUE - The Response is : "+a.asString()+" The Status code is : "+a.getStatusCode());
	    	   ExtentReport.child.log(Status.FAIL, a.getStatusCode()+ " "+ a.asString());
	    	   Assert.fail();
	       }
	}

	public void distributorissue1() throws IOException
	{
		ExtentReport er=new ExtentReport();
	    er.stepReport("Distributor Issue : One Batch with 3 Products");
		Properties prop=new Properties();
		FileInputStream file=new FileInputStream("Properties\\Input.Properties");
		prop.load(file);
		RestAssured.baseURI=prop.getProperty("baseURL");
		String json=utilities.ReadJsonFile.generateStringFromResource("DistributorIssue.json");
        json=json.replace("MBatch1", GlobalUtils.MBatch1);
        json=json.replace("MBatch2", GlobalUtils.MBatch2);
        json=json.replace("MBatch3", GlobalUtils.MBatch3);
        json=json.replace("ChipID1", GlobalUtils.ChipID1);
        json=json.replace("ChipID2", GlobalUtils.ChipID2);
        json=json.replace("ChipID3", GlobalUtils.ChipID3);
		Response a=RestAssured.given()
			        .header("Content-Type",prop.getProperty("Content-type"))
			        .header("x-api-secret","wrongsceret")
			        .header("x-api-key",prop.getProperty("x-api-key"))
			        .body(json)
			        .when()
			        .post("issue/distributor")
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
 		  
 		   System.out.println("The Distributor ID"+j+" was issued sucessfully");
 		  ExtentReport.test.log(Status.PASS, "Distributor ISSUE - The Distributor ID"+j+" was issued sucessfully");
 		 ExtentReport.child.log(Status.PASS, a.asString());
 		   j++;
 	   }
 	   else
 	   {
 		System.out.println("The Distributor ID"+j+" was not issued");
 		System.out.println("Reason:"+reason[i]);
 		 ExtentReport.test.log(Status.PASS, "Distributor ISSUE - The Distributor ID"+j+" was not issued sucessfully. Reason:"+ reason[i]);
 		ExtentReport.child.log(Status.PASS, a.asString());
		   j++;
 	   }
    }
	        }
	       else
	       {
	    	   ExtentReport.test.log(Status.FAIL, "Distributor ISSUE - The Response is : "+a.asString()+" The Status code is : "+a.getStatusCode());
	    	   ExtentReport.child.log(Status.FAIL, a.getStatusCode()+ " "+ a.asString());
	    	   Assert.fail();
	       }
	}
}
