package messanger.kemo.database;

import java.util.HashMap;
import java.util.Map;
import messanger.kemo.model.message;
import messanger.kemo.model.profile;
public class DatabaseClass {
	private static Map<Long,message> messages=new HashMap();
	private static Map<String,profile> profiles=new HashMap();
	
	public static Map<Long,message> getMessages(){
		return messages;
	}

	public static Map<String, profile> getProfiles() {
		return profiles;
	}

}
