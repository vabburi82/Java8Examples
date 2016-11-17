package org.chandra.java.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.chandra.java.messenger.model.Profile;
import org.chandra.java.messenger.service.ProfileService;

@Path("/profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {

	private ProfileService profileService = new  ProfileService();
	@GET
	public List<Profile> getProfile(){
		return profileService.getAllprofiles();
	}
	@POST
	public Profile addProfile(Profile profile){
		return profileService.addprofiles(profile);
	}
	@GET
	@Path("/{profileName}")
	public Profile getProfile(@PathParam("profileName") String profileName){
		return profileService.getProfile(profileName);
	}
	@PUT
	@Path("/{profileName}")
	public Profile updateProfile(@PathParam("profileName") String profileName, Profile profile){
		profile.setProfileName(profileName);
		return profileService.updateProfiles(profile);
	}
	@DELETE
	@Path("/{profileName}")
	public void removeProfile(@PathParam("profileName") String profileName){
	    profileService.removeprofile(profileName);
	
}
}
