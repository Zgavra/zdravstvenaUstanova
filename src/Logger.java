import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Logger {
	private static Logger instance;
	private SimpleDateFormat ft;

	private Logger()
	{
		ft = new SimpleDateFormat ("[dd.MM.yyyy. hh:mm]");
	}
	
	public static Logger Instance()
	{
		if(instance == null)
		{
			instance = new Logger();
		}
		
		return instance;
	}
	
	public void Log(String logMsg)
	{
	    Date now = new Date();
		try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("log.txt"), "utf-8")))
		{
			writer.append(ft.format(now) + logMsg);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
