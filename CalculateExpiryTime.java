import java.sql.Timestamp;
import java.time.Instant;
import java.util.Calendar;

public class CalculateExpiryTime {
	public static void main(String[] args) {	
		// current time
		System.out.println("current Time: " + new Timestamp(Instant.now().toEpochMilli()));
		
		// set expiry time
		String expiryTime = "1";
		
		// calculate expiry time
		Calendar currentTs = Calendar.getInstance();
		currentTs.add(Calendar.MINUTE, Integer.parseInt(expiryTime));
		Timestamp expiryTimestamp = new Timestamp(currentTs.getTimeInMillis());
		
		System.out.println("expiry Time: " + expiryTimestamp);
	}
}
