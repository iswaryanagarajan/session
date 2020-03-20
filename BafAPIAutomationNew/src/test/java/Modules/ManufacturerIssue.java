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

public class ManufacturerIssue {
	public void manufacturerissue() throws IOException
	{

		ExtentReport er=new ExtentReport();
	    er.stepReport("Manufacturer Issue : One Batch with 3 Products");
		Properties prop=new Properties();
		FileInputStream file=new FileInputStream("Properties\\Input.Properties");
		prop.load(file);
		RestAssured.baseURI=prop.getProperty("baseURL");
		GlobalUtils.MBatch1="MID1"+utilities.ReadJsonFile.CurrentDate();
		 GlobalUtils.MBatch2="MID2"+utilities.ReadJsonFile.CurrentDate();
		 GlobalUtils.MBatch3="MID3"+utilities.ReadJsonFile.CurrentDate();
		 GlobalUtils.ExpiryDate1=utilities.ReadJsonFile.UTCDateandTime();
		 GlobalUtils.ExpiryDate2=utilities.ReadJsonFile.UTCDateandTime();
		 GlobalUtils.ExpiryDate3=utilities.ReadJsonFile.UTCDateandTime();
		String json=utilities.ReadJsonFile.generateStringFromResource("ManufacturerIssue.json");
        json=json.replace("Expirydate1", GlobalUtils.ExpiryDate1);
        json=json.replace("Expirydate2", GlobalUtils.ExpiryDate2);
        json=json.replace("Expirydate3", GlobalUtils.ExpiryDate3);
		json=json.replace("COINID1", GlobalUtils.CoinID1);
        json=json.replace("COINID2", GlobalUtils.CoinID2);
        json=json.replace("COINID3", GlobalUtils.CoinID3);
        json=json.replace("MBatch1", GlobalUtils.MBatch1);
        json=json.replace("MBatch2", GlobalUtils.MBatch2);
        json=json.replace("MBatch3", GlobalUtils.MBatch3);
        json=json.replace("ChipID1", GlobalUtils.ChipID1);
        json=json.replace("ChipID2", GlobalUtils.ChipID2);
        json=json.replace("ChipID3", GlobalUtils.ChipID3);
        json=json.replace("NFCBatch", GlobalUtils.NFCBatch);
        json=json.replace("NFCHASH1", GlobalUtils.NFCHash1);
        json=json.replace("NFCHASH2", GlobalUtils.NFCHash2);
        if(GlobalUtils.NFCHash3.isEmpty())
        {
        	json=json.replace("NFCHASH3", "0x6d55f905eac3b347e07d51a43856e8c15a1cc9e1e64d3b4729125afda339f72c");
        }
        else
        {
        json=json.replace("NFCHASH3", GlobalUtils.NFCHash3);
        }
		Response a=RestAssured.given()
			        .header("Content-Type",prop.getProperty("Content-type"))
			        .header("x-api-secret",prop.getProperty("x-api-secret"))
			        .header("x-api-key",prop.getProperty("x-api-key"))
			        .body(json)
			        .when()
			        .post("issue/manufacturer")
			        .then().extract().response();
		 if(a.getStatusCode()==200)
	        {
	JSONArray response=new JSONArray(a.asString());
    JSONObject product1=response.getJSONObject(0);
    JSONObject product2=response.getJSONObject(1);
    JSONObject product3=response.getJSONObject(2);
    String status[]=new String[4];
    String reason[]=new String[4];
    String Hash[]=new String[4];
    status[0]=product1.getString("status");
    status[1]=product2.getString("status");
    status[2]=product3.getString("status");
    reason[0]=product1.getString("reason");
    reason[1]=product2.getString("reason");
    reason[2]=product3.getString("reason");
    Hash[0]=product1.getString("Hash");
    GlobalUtils.MHash=Hash[0];
    int j=1;
    for(int i=0;i<=2;i++)
    {
 	   if(status[i].equals("Issued"))
 	   {
 		  System.out.println("The Manufacturer ID"+j+" was issued sucessfully");
 		  ExtentReport.test.log(Status.PASS, "Manufacturer ISSUE - The Manufacturer ID"+j+" was issued sucessfully"); 
 		 ExtentReport.child.log(Status.PASS, a.asString());
 		   j++;
 	   }
 	   else
 	   {
 		System.out.println("The Manufacturer ID"+j+" was not issued");
 		System.out.println("Reason:"+reason[i]);
 		ExtentReport.test.log(Status.PASS, "Manufacturer ISSUE- The Manufacturer ID"+j+" was not issued, Reason:" +reason[i]); 
 		 ExtentReport.child.log(Status.PASS, a.asString());
		   j++;
 	   }
    }
	        }
	       else
	       {
	    	   System.out.println(a.asString());
	    	   ExtentReport.test.log(Status.FAIL, "Manufacturer ISSUE - The Response is : "+a.asString()+" The Status code is : "+a.getStatusCode());
	    	   ExtentReport.child.log(Status.FAIL, a.getStatusCode()+ " "+ a.asString());
	    	   Assert.fail();
	       }
 }

}
