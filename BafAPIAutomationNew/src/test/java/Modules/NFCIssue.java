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

public class NFCIssue {
	
	public void nfcissue(String scenario) throws IOException
    {
		ExtentReport er=new ExtentReport();
	    er.stepReport("NFC Issue : One Batch with 3 Products");
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream("Properties/Input.Properties");
		prop.load(file);
		 GlobalUtils.ChipID1="ChipID1"+utilities.ReadJsonFile.CurrentDate();
		 GlobalUtils.ChipID2="ChipID2"+utilities.ReadJsonFile.CurrentDate();
		 GlobalUtils.ChipID3="ChipID3"+utilities.ReadJsonFile.CurrentDate();
		 GlobalUtils.NFCBatch = "NB"+utilities.ReadJsonFile.CurrentDate();
        RestAssured.baseURI=prop.getProperty("baseURL");
        String json=utilities.ReadJsonFile.generateStringFromResource("NFCIssue.json");
        json=json.replace("COINID1", GlobalUtils.CoinID1);
        json=json.replace("COINID2", GlobalUtils.CoinID2);
        json=json.replace("COINID3", GlobalUtils.CoinID3);
        json=json.replace("ChipID1", GlobalUtils.ChipID1);
        json=json.replace("ChipID2", GlobalUtils.ChipID2);
        json=json.replace("RBatch", GlobalUtils.RamBatch);
        if(scenario.equalsIgnoreCase("All 3 Products Should Issued Sucessfully"))
        {
        json=json.replace("ChipID3", GlobalUtils.ChipID3);
        }
        json=json.replace("NFCBatch", GlobalUtils.NFCBatch);
        Response a=RestAssured.given()
        .header("Content-Type",prop.getProperty("Content-type"))
        .header("x-api-secret",prop.getProperty("x-api-secret"))
        .header("x-api-key",prop.getProperty("x-api-key"))
        .body(json)
        .when()
        .post("/issue/nfc")
        .then().extract().response();
        if(a.getStatusCode()==200)
        {
       JSONArray response=new JSONArray(a.asString());
       JSONObject product1=response.getJSONObject(0);
       JSONObject product2=response.getJSONObject(1);
       JSONObject product3=response.getJSONObject(2);
       String status[]=new String[4];
       String reason[]=new String[4];
       String nfcHash[]=new String[4];
       status[0]=product1.getString("status");
       status[1]=product2.getString("status");
       status[2]=product3.getString("status");
       reason[0]=product1.getString("reason");
       reason[1]=product2.getString("reason");
       reason[2]=product3.getString("reason");
       nfcHash[0]=product1.getString("Hash");
       nfcHash[1]=product2.getString("Hash");
       nfcHash[2]=product3.getString("Hash");
       GlobalUtils.NFCHash1=nfcHash[0];
       GlobalUtils.NFCHash2=nfcHash[1];
       GlobalUtils.NFCHash3=nfcHash[2];
       int j=1;
       for(int i=0;i<=2;i++)
       {
    	   if(status[i].equals("Issued"))
    	   {
    		   System.out.println("The Chip ID"+j+" was issued sucessfully");
    		   ExtentReport.test.log(Status.PASS, "NFC ISSUE - The CHIP ID"+j+" was issued sucessfully");
    		   ExtentReport.child.log(Status.PASS, a.asString());
    		   j++;
    	   }
    	   else
    	   {
    		System.out.println("The Chip ID"+j+" was not issued");
    		System.out.println("Reason:"+reason[i]);
    		 ExtentReport.test.log(Status.PASS, "NFC ISSUE - The CHIP ID"+j+" was not issued, Reason:" +reason[i]);
    		 ExtentReport.child.log(Status.PASS, a.asString());
   		   j++;
    	   }
       }
      
    }else
    {
    	ExtentReport.test.log(Status.FAIL, "NFC ISSUE - The Response is : "+a.asString()+" The Status code is : "+a.getStatusCode());
    	ExtentReport.child.log(Status.FAIL, a.getStatusCode()+ " "+ a.asString());
    	Assert.fail();
    }
    }
}
