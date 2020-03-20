package Modules;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;

import com.aventstack.extentreports.Status;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import utilities.ExtentReport;
import utilities.GlobalUtils;

public class VerifyBatchProducts {
	ExtentReport er=new ExtentReport();
	Properties prop=new Properties();
	public void VerifyCoinBatchProducts() throws IOException
	{
		System.out.println(GlobalUtils.ChipID1);
		System.out.println(GlobalUtils.CoinID1);
		System.out.println(GlobalUtils.MBatch1);
		System.out.println(GlobalUtils.NFCBatch);
		FileInputStream file=new FileInputStream("Properties\\Input.Properties");
		prop.load(file);
		RestAssured.baseURI=prop.getProperty("baseURL");
        er.stepReport("VerifyCoinBatchProducts");
        System.out.println(GlobalUtils.RamBatch);
        Response a =RestAssured.given()
        		.header("Content-Type",prop.getProperty("Content-type"))
		        .header("x-api-secret",prop.getProperty("x-api-secret"))
		        .header("x-api-key",prop.getProperty("x-api-key"))
		        .when()
		        .queryParam("outputFormat", "JSON")
		        .queryParam("coinBatch", GlobalUtils.RamBatch)
		        .get("verifyBatchProducts")
		        .then().extract().response();
        String str= a.asString();   
   	 str = str.replaceAll("[^a-zA-Z0-9,:]", " ");  
   	 if(a.getStatusCode()==200)
   	 {
   		  System.out.println("VerifyCoinBatchProducts - The Response is : "+str);
   		  ExtentReport.test.log(Status.PASS, "VerifyCoinBatchProducts - The Response is : "+str); 
   		 ExtentReport.child.log(Status.PASS, a.asString());
   	   }
          else
          {
       	   System.out.println("VerifyCoinBatchProducts - The Response is : "+str);
       	   ExtentReport.test.log(Status.FAIL, "VerifyCoinBatchProducts - The Response is : "+str+" The Status code is : "+a.getStatusCode());
       	   ExtentReport.child.log(Status.FAIL, a.getStatusCode()+ " "+ a.asString());
       	   Assert.fail();
          }
      }
	
	public void VerifyChipBatchProducts() throws IOException
	{
		FileInputStream file=new FileInputStream("Properties\\Input.Properties");
		prop.load(file);
		RestAssured.baseURI=prop.getProperty("baseURL");
        er.stepReport("VerifyChipBatchProducts");
        Response a =RestAssured.given()
        		.header("Content-Type",prop.getProperty("Content-type"))
		        .header("x-api-secret",prop.getProperty("x-api-secret"))
		        .header("x-api-key",prop.getProperty("x-api-key"))
		        .when()
		        .queryParam("outputFormat", "JSON")
		        .queryParam("nfcBatch", GlobalUtils.NFCBatch)
		        .get("verifyBatchProducts")
		        .then().extract().response();
        String str= a.asString();   
   	 str = str.replaceAll("[^a-zA-Z0-9,:]", " ");  
   	 if(a.getStatusCode()==200)
   	 {
   		  System.out.println("VerifyChipBatchProducts - The Response is : "+str);
   		  ExtentReport.test.log(Status.PASS, "VerifyChipBatchProducts - The Response is : "+str); 
   		 ExtentReport.child.log(Status.PASS, a.asString());
   	   }
          else
          {
       	   System.out.println("VerifyChipBatchProducts - The Response is : "+str);
       	   ExtentReport.test.log(Status.FAIL, "VerifyChipBatchProducts - The Response is : "+str+" The Status code is : "+a.getStatusCode());
       	   ExtentReport.child.log(Status.FAIL, a.getStatusCode()+ " "+ a.asString());
       	   Assert.fail();
          }
      }
	
	public void VerifyManufacturerBatchProducts() throws IOException
	{
		FileInputStream file=new FileInputStream("Properties\\Input.Properties");
		prop.load(file);
		RestAssured.baseURI=prop.getProperty("baseURL");
        er.stepReport("VerifyManufacturerBatchProducts");
        Response a =RestAssured.given()
        		.header("Content-Type",prop.getProperty("Content-type"))
		        .header("x-api-secret",prop.getProperty("x-api-secret"))
		        .header("x-api-key",prop.getProperty("x-api-key"))
		        .when()
		        .queryParam("outputFormat", "JSON")
		        .queryParam("manufacturingBatch", GlobalUtils.MBatch1)
		        .get("verifyBatchProducts")
		        .then().extract().response();
        String str= a.asString();   
   	 str = str.replaceAll("[^a-zA-Z0-9,:]", " ");  
   	 if(a.getStatusCode()==200)
   	 {
   		  System.out.println("VerifyManufacturerBatchProducts - The Response is : "+str);
   		  ExtentReport.test.log(Status.PASS, "VerifyManufacturerBatchProducts - The Response is : "+str); 
   		 ExtentReport.child.log(Status.PASS, a.asString());
   	   }
          else
          {
       	   System.out.println("VerifyManufacturerBatchProducts - The Response is : "+str);
       	   ExtentReport.test.log(Status.FAIL, "VerifyManufacturerBatchProducts - The Response is : "+str+" The Status code is : "+a.getStatusCode());
       	   ExtentReport.child.log(Status.FAIL, a.getStatusCode()+ " "+ a.asString());
       	   Assert.fail();
          }
	}

}
