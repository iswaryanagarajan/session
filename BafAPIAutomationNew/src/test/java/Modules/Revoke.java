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

public class Revoke {
	ExtentReport er=new ExtentReport();
	Properties prop=new Properties();
	public void revokeusingCoinID() throws IOException
	{
		FileInputStream file=new FileInputStream("Properties\\Input.Properties");
		prop.load(file);
		RestAssured.baseURI=prop.getProperty("baseURL");
    er.stepReport("Revoke using CoinID");
	
	String json=utilities.ReadJsonFile.generateStringFromResource("Revoke.json");
	json=json.replace("NAME", "coinId");
	json=json.replace("ID", GlobalUtils.CoinID1);
	Response a=RestAssured.given()
		        .header("Content-Type",prop.getProperty("Content-type"))
		        .header("x-api-secret",prop.getProperty("x-api-secret"))
		        .header("x-api-key",prop.getProperty("x-api-key"))
		        .body(json)
		        .when()
		        .patch("revoke")
		        .then().extract().response();
	String str= a.asString();   
	 str = str.replaceAll("[^a-zA-Z0-9,:]", " ");
		if(a.statusCode()==200)
		{
			  System.out.println("Revoke Coin - The Response is : "+str);
			  ExtentReport.test.log(Status.PASS, "Revoke Coin - The Response is : "+str); 
			 ExtentReport.child.log(Status.PASS, a.asString());
		   }
	       else
	       {
	    	   System.out.println("Revoke Coin - The Response is : "+str);
	    	   ExtentReport.test.log(Status.FAIL, "Revoke Coin - The Response is : "+str+" The Status code is : "+a.getStatusCode());
	    	   ExtentReport.child.log(Status.FAIL, a.getStatusCode()+ " "+ a.asString());
	    	   Assert.fail();
	       }
   }
	public void revokeusingChipID() throws IOException
	{
		FileInputStream file=new FileInputStream("Properties\\Input.Properties");
		prop.load(file);
		RestAssured.baseURI=prop.getProperty("baseURL");
    er.stepReport("Revoke using Chip ID");
	
	String json=utilities.ReadJsonFile.generateStringFromResource("Revoke.json");
	json=json.replace("NAME", "chipId");
	json=json.replace("ID", GlobalUtils.ChipID1);
	Response a=RestAssured.given()
		        .header("Content-Type",prop.getProperty("Content-type"))
		        .header("x-api-secret",prop.getProperty("x-api-secret"))
		        .header("x-api-key",prop.getProperty("x-api-key"))
		        .body(json)
		        .when()
		        .patch("revoke")
		        .then().extract().response();
	String str= a.asString();   
	 str = str.replaceAll("[^a-zA-Z0-9,:]", " ");  
	 if(a.getStatusCode()==200)
	 {
		  System.out.println("Revoke Chip - The Response is : "+str);
		  ExtentReport.test.log(Status.PASS, "Revoke Chip - The Response is : "+str); 
		 ExtentReport.child.log(Status.PASS, a.asString());
	   }
       else
       {
    	   System.out.println("Revoke Chip - The Response is : "+str);
    	   ExtentReport.test.log(Status.FAIL, "Revoke Chip - The Response is : "+str+" The Status code is : "+a.getStatusCode());
    	   ExtentReport.child.log(Status.FAIL, a.getStatusCode()+ " "+ a.asString());
    	   Assert.fail();
       }
   }
	public void revokeusingHash() throws IOException
	{
		FileInputStream file=new FileInputStream("Properties\\Input.Properties");
		prop.load(file);
		RestAssured.baseURI=prop.getProperty("baseURL");
    er.stepReport("Revoke using Hash");
	
	String json=utilities.ReadJsonFile.generateStringFromResource("Revoke.json");
	json=json.replace("NAME", "blockchainHash");
	json=json.replace("ID", GlobalUtils.MHash);
	Response a=RestAssured.given()
		        .header("Content-Type",prop.getProperty("Content-type"))
		        .header("x-api-secret",prop.getProperty("x-api-secret"))
		        .header("x-api-key",prop.getProperty("x-api-key"))
		        .body(json)
		        .when()
		        .patch("revoke")
		        .then().extract().response();
	String str= a.asString();   
	str = str.replaceAll("[^a-zA-Z0-9,:]", " ");  
	 if(a.getStatusCode()==200)
	 {
		  System.out.println("Revoke Hash - The Response is : "+str);
		  ExtentReport.test.log(Status.PASS, "Revoke Hash - The Response is :- "+str); 
		 ExtentReport.child.log(Status.PASS, a.asString());
	   }
      else
      {
    	  System.out.println("Revoke Hash - The Response is : "+str);
   	   ExtentReport.test.log(Status.FAIL, "Revoke Hash - The Response is : "+str+" The Status code is : "+a.getStatusCode());
   	   ExtentReport.child.log(Status.FAIL, a.getStatusCode()+ " "+ a.asString());
   	   Assert.fail();
      }
  }
	public void revokeusingMBatch() throws IOException
	{
		FileInputStream file=new FileInputStream("Properties\\Input.Properties");
		prop.load(file);
		RestAssured.baseURI=prop.getProperty("baseURL");
    er.stepReport("Revoke using manufaturer batch");
	
	String json=utilities.ReadJsonFile.generateStringFromResource("Revoke.json");
	json=json.replace("NAME", "manufacturingBatch");
	json=json.replace("ID", GlobalUtils.MBatch1);
	Response a=RestAssured.given()
		        .header("Content-Type",prop.getProperty("Content-type"))
		        .header("x-api-secret",prop.getProperty("x-api-secret"))
		        .header("x-api-key",prop.getProperty("x-api-key"))
		        .body(json)
		        .when()
		        .patch("revoke")
		        .then().extract().response();
	String str= a.asString();   
	str = str.replaceAll("[^a-zA-Z0-9,:]", " ");  
	 if(a.getStatusCode()==200)
	 {
		  System.out.println("Revoke Manufaturer Batch - The Response is : "+str);
		  ExtentReport.test.log(Status.PASS, "Revoke Manufaturer Batch - The Response is : "+str); 
		 ExtentReport.child.log(Status.PASS, a.asString());
	   }
      else
      {
    	  System.out.println("Revoke Manufaturer Batch - The Response is : "+str);
   	   ExtentReport.test.log(Status.FAIL, "Revoke Manufaturer Batch - The Response is : "+str+" The Status code is : "+a.getStatusCode());
   	   ExtentReport.child.log(Status.FAIL, a.getStatusCode()+ " "+ a.asString());
   	   Assert.fail();
      }
  }
}
