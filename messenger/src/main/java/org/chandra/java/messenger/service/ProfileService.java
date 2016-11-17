package org.chandra.java.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.chandra.java.messenger.database.DatabaseClass;
import org.chandra.java.messenger.model.Profile;

public class ProfileService {

	private Map<String, Profile> profiles = DatabaseClass.getProfiles();
	
	public List<Profile> getAllprofiles(){
		return new ArrayList<Profile>(profiles.values());
	}
	public Profile getProfile (String profileName){
		return profiles.get(profileName);
		
	}
	public Profile addprofiles(Profile profile){
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
		
	}
	public ProfileService() {
		profiles.put("chandra", new Profile(1L,"chandraab","chandra","abburi"));
	}
	public Profile updateProfiles(Profile profile){
		if(profile.getProfileName().isEmpty()){
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
     	}
	public Profile removeprofile(String profileName){
		return profiles.remove(profileName);
		
	}
}
