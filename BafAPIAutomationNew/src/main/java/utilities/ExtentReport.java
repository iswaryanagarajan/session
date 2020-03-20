package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.ReportAggregates;
import com.aventstack.extentreports.reporter.ExtentEmailReporter;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {
	static String a = ReadJsonFile.CurrentDateTime();
	public static ExtentHtmlReporter htmlreporter=new ExtentHtmlReporter("Reports/BAF_API_Test_Report"+a+".html");
public static ExtentReports reports=new ExtentReports();;
public static ExtentTest test;
public static ExtentTest child;
//public static ExtentEmailReporter b = new ExtentEmailReporter("Reports/Email.html");
public void startReport(String title, String Decription)
{
	reports.attachReporter(htmlreporter);
	 
	//reports.attachReporter(b);
	htmlreporter.config().setCSS(".test-name{word-break: break-word!important}.step-details{word-break: break-word!important}");
	htmlreporter.config().setDocumentTitle("BAF_API_Automation_Report");
	htmlreporter.config().setReportName("BAF_API_Automation_Report");
	 htmlreporter.config().setTheme(Theme.STANDARD);
	 GlobalUtils.filename="BAF_API_Test_Report"+a+".html";
	 
    test=reports.createTest(title, Decription);
    
}
public void stepReport(String steptitle)
{
	child =test.createNode(steptitle);
	
}
public void endReport()
{
	
	reports.flush();
}
}

