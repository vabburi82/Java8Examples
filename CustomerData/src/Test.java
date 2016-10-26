import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ZoneId myZone=ZoneId.systemDefault();
		Date date = new Date();
	    Instant now = date.toInstant();
		LocalDateTime dateTime = LocalDateTime.ofInstant(now, myZone);
		ZonedDateTime zdt = ZonedDateTime.ofInstant(now, myZone);
		System.out.println(now);
		System.out.println(dateTime);
		System.out.println(zdt);
		System.out.println(date);
		

	}

}
