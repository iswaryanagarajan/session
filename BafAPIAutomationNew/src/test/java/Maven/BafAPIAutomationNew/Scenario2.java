package Maven.BafAPIAutomationNew;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Modules.DistributorIssue;
import Modules.ManufacturerIssue;
import Modules.NFCIssue;
import Modules.RamAsApproverIssue;
import Modules.RamIssue;
import Modules.Revoke;
import Modules.VerifyProduct;
import utilities.ExtentReport;

public class Scenario2 {

	@BeforeClass()
	public void startreport()
	{
		String Description="Scenario : One Batch with 3 Products - 2 Products Should Issued Sucessfully & one product not issued";
		String title="Issuing RAM, NFC, Manufacturer, Ram as Approver, Distributor with one Product not Issued scenario";
		ExtentReport er=new ExtentReport();
		er.startReport(title, Description);
	}
	String scenario="One Batch with 3 Products - 2 Products Should Issued Sucessfully & one product not issued";
	@Test(priority=1)
	  public void ramIssue() throws IOException
	  {
		  RamIssue ri=new RamIssue();
			ri.ramIssue();
			
	  }
	  @Test(priority=2)
	  public void nfcIssue() throws IOException
	  {
		  NFCIssue nfc=new NFCIssue();
				  nfc.nfcissue(scenario);
	  }

  @Test(priority=3)
	public void manufacturerissue() throws IOException
	{
		ManufacturerIssue mi=new ManufacturerIssue();
		mi.manufacturerissue();
	}
	@Test(priority=4)
  public void ramasapproverissue() throws IOException
  {
      RamAsApproverIssue ri = new RamAsApproverIssue();
      ri.ramasapproverissue();
  }
	@Test(priority=5)
	public void distributorissue() throws IOException
	{
		DistributorIssue di=new DistributorIssue();
		di.distributorissue1();
	}
	@Test (priority=6)
	public void revoke() throws IOException
	{
		Revoke re=new Revoke();
		re.revokeusingCoinID();
		re.revokeusingChipID();
		re.revokeusingHash();
		re.revokeusingMBatch();	
	}
	@Test (priority=7)
	public void verifyProduct() throws IOException
	{
		VerifyProduct vp=new VerifyProduct();
		vp.verifyProductusingCoinID();
		vp.verifyProductusingChipID();
		vp.verifyProductusingblockchainHash();
	}
}
