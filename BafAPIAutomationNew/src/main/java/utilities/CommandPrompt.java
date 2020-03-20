package utilities;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class CommandPrompt {
	static JFrame frame;
	static JPanel panel;
	public static void showProgress(boolean b) throws InterruptedException
	{ 
		frame = new JFrame("BAF API Automation");
		JProgressBar progressbar = new JProgressBar();
		progressbar.setValue(100);
		progressbar.setStringPainted(true);
		progressbar.setString("Test is Running");
		 panel = new JPanel();
		panel.add(progressbar);
		panel.setSize(200, 50);
		frame.add(panel);
		frame.setSize(500, 200);
		frame.setVisible(b);
	}
	public static void closeProgress(boolean b) throws InterruptedException
	{
		frame.setVisible(b);
		JOptionPane.showMessageDialog(frame, "Test completed");
	}
	public void Open_Cmd ()
	{

		 try
	        { 
	           
	           Runtime.getRuntime().exec(new String[] {"cmd", "/K", "start"});
	        } 
	        catch (Exception e) 
	        { 
	            System.out.println("Error "); 
	            e.printStackTrace(); 
	        } 
	}	
	public void Close_cmd()
	{
		try 
		{
            Runtime.getRuntime().exec("taskkill /f /im cmd.exe") ;
        } 
		catch (Exception e)
		{
			System.out.println("Error "); 
            e.printStackTrace();  
        }
	}
	
	public void display_alert()
	{
		JFrame frame = new JFrame("BAF");
	    JOptionPane.showMessageDialog(frame, "Test completed");
	}
}
