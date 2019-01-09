package messanger.kemo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import messanger.kemo.database.DatabaseClass;
import messanger.kemo.model.message;
import messanger.kemo.model.profile;

public class profileService {
	private Map<String,profile> profiles=DatabaseClass.getProfiles();
	public profileService() {
		if(profiles.size()==0) {
			profiles.put("karem",new profile(1L,"kemo","kareem","mosaad"));
			profiles.put("kareem",new profile(2L,"emo","kareem","mosaad"));
			
		}
	}
	
	public List<profile> getAllprofiles(){
		return new ArrayList<profile>(profiles.values());
	}
	public profile getProfile(String profName) {
		
		return profiles.get(profName);
	}
	public profile addProfile(profile prof) {
		prof.setId(profiles.size()+1);
		profiles.put(prof.getProfileName(), prof);
		return prof;
	}
	public profile updateProfile(profile prof) {
		if(prof.getProfileName().isEmpty()) {return null;}
		profiles.put(prof.getProfileName(),prof);
		return prof;
	}
	public profile removeProfile(String profName) {
		
		return profiles.remove(profName);
	}

}
