package Maven.BafAPIAutomationNew;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.testng.TestNG;

import utilities.CommandPrompt;
import utilities.ExtentReport;
import utilities.MailSend;
public class MainClass {
	public static void main(String[] args) throws IOException, InterruptedException {
		CommandPrompt shell = new CommandPrompt();
		//shell.Open_Cmd();
		CommandPrompt.showProgress(true);
		TestNG runner=new TestNG();
		List<String> suitefiles=new ArrayList<String>();
		suitefiles.add("testng.xml");
		suitefiles.add("testng2.xml");
		runner.setTestSuites(suitefiles);
		runner.run();
		ExtentReport er=new ExtentReport();
		er.endReport();
		MailSend ms=new MailSend();
		ms.mailSend();
		CommandPrompt.closeProgress(false);
		//shell.Close_cmd();
		
	}


}
