package helpers;

public class UtilityHelper {
	
public static CharSequence epoch;
	
	public static String email(){
				
		long epoch = System.currentTimeMillis()%100;
		System.out.println(epoch);
		return "phani"+epoch+"@gmail.com";
		
	}
	
	public static String uName() {
		
		long name = System.currentTimeMillis()%100;
		System.out.println(name);
		return "User"+name;		
		
	}

}
