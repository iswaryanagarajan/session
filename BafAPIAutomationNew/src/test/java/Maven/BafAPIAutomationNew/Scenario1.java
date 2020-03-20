package Maven.BafAPIAutomationNew;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Modules.DistributorIssue;
import Modules.ManufacturerIssue;
import Modules.NFCIssue;
import Modules.RamAsApproverIssue;
import Modules.RamIssue;
import Modules.Revoke;
import Modules.VerifyBatchProducts;
import Modules.VerifyProduct;
import utilities.ExtentReport;

public class Scenario1 {

	@BeforeClass()
	public void startreport()
	{
		String Description="Scenario : One Batch with 3 Products & All 3 Products Should Issued Sucessfully";
	    String title="Issuing RAM, NFC, Manufacturer, Ram as Approver, Distributor, Revoke, Verify Product & Verify Batch Products";
		ExtentReport er=new ExtentReport();
		er.startReport(title, Description);
	}
	String scenario="All 3 Products Should Issued Sucessfully";
  @Test(priority=1)
  public void ramIssue() throws IOException, InterruptedException
  {
	  RamIssue ri=new RamIssue();
		ri.ramIssue();
		//Thread.sleep(40000);
		
  }
  @Test(priority=2)
  public void nfcIssue() throws IOException, InterruptedException
  {
	          NFCIssue nfc=new NFCIssue();
			  nfc.nfcissue(scenario);
			  //Thread.sleep(40000);
  }
  @Test (priority=3)
  public void manufacturerissue() throws IOException, InterruptedException
	{
		ManufacturerIssue mi=new ManufacturerIssue();
		mi.manufacturerissue();
		Thread.sleep(40000);
	}
  @Test (priority=4)
  public void ramasapproverissue() throws IOException, InterruptedException
    {
      RamAsApproverIssue ri = new RamAsApproverIssue();
      ri.ramasapproverissue();
      //Thread.sleep(40000);
    }
	@Test (priority=5)
	public void distributorissue() throws IOException, InterruptedException
	{
		DistributorIssue di=new DistributorIssue();
		di.distributorissue();
		//Thread.sleep(40000);
	}
	@Test (priority=6)
	public void revoke() throws IOException, InterruptedException
	{
		Revoke re=new Revoke();
		re.revokeusingCoinID();
		re.revokeusingChipID();
		re.revokeusingHash();
		re.revokeusingMBatch();
		//Thread.sleep(40000);
	}
	@Test (priority=7)
	public void verifyProduct() throws IOException
	{
		VerifyProduct vp=new VerifyProduct();
		vp.verifyProductusingCoinID();
		vp.verifyProductusingChipID();
		vp.verifyProductusingblockchainHash();
	}
	//@Test (priority=8)
	public void verifyBatchProducts() throws IOException
	{
		VerifyBatchProducts vbp=new VerifyBatchProducts();
		vbp.VerifyCoinBatchProducts();
		vbp.VerifyChipBatchProducts();
		vbp.VerifyManufacturerBatchProducts();
	}
}
