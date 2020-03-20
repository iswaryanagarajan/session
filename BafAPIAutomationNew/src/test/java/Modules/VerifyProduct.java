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

public class VerifyProduct {
	ExtentReport er=new ExtentReport();
	Properties prop=new Properties();
	public void verifyProductusingCoinID() throws IOException
	{
		FileInputStream file=new FileInputStream("Properties\\Input.Properties");
		prop.load(file);
		RestAssured.baseURI=prop.getProperty("baseURL");
        er.stepReport("Verify Product using CoinID");
        Response a =RestAssured.given()
        		.header("Content-Type",prop.getProperty("Content-type"))
		        .header("x-api-secret",prop.getProperty("x-api-secret"))
		        .header("x-api-key",prop.getProperty("x-api-key"))
		        .when()
		        .queryParam("coinId", GlobalUtils.CoinID1)
		        .get("verifyProduct")
		        .then().extract().response();
        String str= a.asString();   
   	 str = str.replaceAll("[^a-zA-Z0-9,:]", " ");  
   	 if(a.getStatusCode()==200)
   	 {
   		  System.out.println("VerifyProduct using Coin ID - The Response is : "+str);
   		  ExtentReport.test.log(Status.PASS, "VerifyProduct using Coin ID - The Response is : "+str); 
   		 ExtentReport.child.log(Status.PASS, a.asString());
   	   }
          else
          {
       	   System.out.println("VerifyProduct using Coin ID - The Response is : "+str);
       	   ExtentReport.test.log(Status.FAIL, "VerifyProduct using Coin ID - The Response is : "+str+" The Status code is : "+a.getStatusCode());
       	   ExtentReport.child.log(Status.FAIL, a.getStatusCode()+ " "+ a.asString());
       	   Assert.fail();
          }
      }
	
	public void verifyProductusingChipID() throws IOException
	{
		FileInputStream file=new FileInputStream("Properties\\Input.Properties");
		prop.load(file);
		RestAssured.baseURI=prop.getProperty("baseURL");
        er.stepReport("Verify Product using ChipID");
        Response a =RestAssured.given()
        		.header("Content-Type",prop.getProperty("Content-type"))
		        .header("x-api-secret",prop.getProperty("x-api-secret"))
		        .header("x-api-key",prop.getProperty("x-api-key"))
		        .when()
		        .queryParam("chipId", GlobalUtils.ChipID1)
		        .get("verifyProduct")
		        .then().extract().response();
        String str= a.asString();   
   	 str = str.replaceAll("[^a-zA-Z0-9,:]", " ");  
   	 if(a.getStatusCode()==200)
   	 {
   		  System.out.println("VerifyProduct using Chip ID - The Response is : "+str);
   		  ExtentReport.test.log(Status.PASS, "VerifyProduct using Chip ID - The Response is : "+str); 
   		 ExtentReport.child.log(Status.PASS, a.asString());
   	   }
          else
          {
       	   System.out.println("VerifyProduct using Chip ID - The Response is : "+str);
       	   ExtentReport.test.log(Status.FAIL, "VerifyProduct using Chip ID - The Response is : "+str+" The Status code is : "+a.getStatusCode());
       	   ExtentReport.child.log(Status.FAIL, a.getStatusCode()+ " "+ a.asString());
       	   Assert.fail();
          }
      }
	
	public void verifyProductusingblockchainHash() throws IOException
	{
		FileInputStream file=new FileInputStream("Properties\\Input.Properties");
		prop.load(file);
		RestAssured.baseURI=prop.getProperty("baseURL");
        er.stepReport("Verify Product using BlockchainHash");
        Response a =RestAssured.given()
        		.header("Content-Type",prop.getProperty("Content-type"))
		        .header("x-api-secret",prop.getProperty("x-api-secret"))
		        .header("x-api-key",prop.getProperty("x-api-key"))
		        .when()
		        .queryParam("blockchainHash", GlobalUtils.MHash)
		        .get("verifyProduct")
		        .then().extract().response();
        String str= a.asString();   
   	 str = str.replaceAll("[^a-zA-Z0-9,:]", " ");  
   	 if(a.getStatusCode()==200)
   	 {
   		  System.out.println("VerifyProduct using BlockchainHash - The Response is : "+str);
   		  ExtentReport.test.log(Status.PASS, "VerifyProduct using BlockchainHash - The Response is : "+str); 
   		 ExtentReport.child.log(Status.PASS, a.asString());
   	   }
          else
          {
       	   System.out.println("VerifyProduct using BlockchainHash - The Response is : "+str);
       	   ExtentReport.test.log(Status.FAIL, "VerifyProduct using BlockchainHash - The Response is : "+str+" The Status code is : "+a.getStatusCode());
       	   ExtentReport.child.log(Status.FAIL, a.getStatusCode()+ " "+ a.asString());
       	   Assert.fail();
          }
	}
}

