package utilities;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import utilities.GlobalUtils;
import utilities.ReadJsonFile;

public class MailSend {
	public void mailSend()
	{
		Properties pros=new Properties();
		pros.put("mail.smtp.host", "smtp.gmail.com");
		pros.put("mail.smtp.socketFactory.port", "465");
		pros.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		pros.put("mail.smtp.auth", "true");
		pros.put("mail.smtp.port", "465");
//        pros.put("mail.smtp.auth", "true");
//        pros.put("mail.smtp.starttls.enable", "true");
//        pros.put("mail.smtp.host", "outlook.office365.com");
//        pros.put("mail.smtp.port", "587");

		Session session = Session.getDefaultInstance(pros,
				 
				new javax.mail.Authenticator() {
 
					protected PasswordAuthentication getPasswordAuthentication() {
 
					return new PasswordAuthentication("abottcsk@gmail.com", "Testing@12");
 
					}
 
				});
		
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("abottcsk@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("v.ramasamy@lakeba.com, v.sehar@lakeba.com"));
			message.setSubject("BAF Automation Report on "+ReadJsonFile.CurrentDate2());
			BodyPart messageBodyPart1 = new MimeBodyPart();
			messageBodyPart1.setText("Hi \n\r please find the attached report");
			MimeBodyPart messageBodyPart2 = new MimeBodyPart();
			String filepath="Reports/"+GlobalUtils.filename;
			String filename=GlobalUtils.filename;
			DataSource source = new FileDataSource(filepath);
			messageBodyPart2.setDataHandler(new DataHandler(source));
			messageBodyPart2.setFileName(filename);
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart2);
			multipart.addBodyPart(messageBodyPart1);
			message.setContent(multipart);
			Transport.send(message);
 
		} catch (MessagingException e) {
 
			throw new RuntimeException(e);
 
		}
	}

}
