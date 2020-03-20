package utilities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class ReadJsonFile {
	public static String generateStringFromResource(String filename) throws IOException {
		return new String(Files.readAllBytes(Paths.get("JSONFiles/"+filename)));
	}
	public static String CurrentDateTime()
	{
		SimpleDateFormat formatter=new SimpleDateFormat("d-MMM-yyyy-kms");
		Date date=new Date();
		return formatter.format(date);
	}
	
	public static String CurrentDate()
	{ 
		  SimpleDateFormat simpleDateFormat =
	      new SimpleDateFormat("YYYYMMddhhmmss");
	      String dateAsString = simpleDateFormat.format(new Date());
	      return dateAsString;
	}
	public static String CurrentDate2()
	{   
		  SimpleDateFormat simpleDateFormat =
				  new SimpleDateFormat("dd MMMM yyyy HH:mm:ss");
	      String dateAsString = simpleDateFormat.format(new Date());
	      return dateAsString;
	}
	public static String UTCDateandTime()
	{
		SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd'T'HH:MM:ss.SSS'Z'");
		formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
		Calendar calendar=Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		Date datetomorrow=calendar.getTime();
		return formatter.format(datetomorrow).toString();
	}
}
