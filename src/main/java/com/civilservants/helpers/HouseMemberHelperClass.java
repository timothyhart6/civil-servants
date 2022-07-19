package com.civilservants.helpers;
import com.civilservants.model.UserAddress;
import com.civilservants.model.api.google.Address;
import com.civilservants.model.api.google.Channel;
import com.civilservants.model.api.google.GoogleApiRepresentativesModel;
import com.civilservants.model.api.google.Official;
import com.civilservants.model.api.proPublica.ProPublicaHouseMember;
import com.civilservants.service.GoogleApiCalls;
import com.civilservants.service.ProPublicaApiCalls;

public class HouseMemberHelperClass {

    private UserAddress userAddress;
    private String districtCode;
    private Official googleHouseMember;
    private ProPublicaHouseMember proPublicaHouseMember;

    public HouseMemberHelperClass(UserAddress userAddress, String districtCode) {
        this.userAddress = userAddress;
        this.districtCode = districtCode;
        this.googleHouseMember = fetchGoogleHouseMember();
        this.proPublicaHouseMember = fetchProPublicaHouseMember();
    }

    public Official fetchGoogleHouseMember() {
        GoogleApiCalls googleApiCalls = new GoogleApiCalls();
        GoogleApiRepresentativesModel googleApiRepresentativesModel = googleApiCalls.getGoogleApiRepresentativesModel(userAddress.getStreetAddress(), userAddress.getZipCode());
        return googleApiRepresentativesModel.officials.get(4);
    }

    public ProPublicaHouseMember fetchProPublicaHouseMember() {
        ProPublicaApiCalls proPublicaApiCalls = new ProPublicaApiCalls();
        return proPublicaApiCalls.getPropublicaApiRepresentativesModel(userAddress.getState(), districtCode);
    }

    public String getFirstName() {
        return  googleHouseMember.name.split(" ")[0];
    }

    public String getLastName() {
        return googleHouseMember.name.split(" ")[1];
    }

    public String getPhoto() {
        return googleHouseMember.photoUrl;
    }

    public String getPhoneNumber() {
        return googleHouseMember.phones.get(0);
    }

    public Address getOfficeAddress() {
        return googleHouseMember.address.get(0);
    }

    public String getRole() {
       return proPublicaHouseMember.getRole();
    }

    public String getNextElection() {
        return proPublicaHouseMember.getNextElection();
    }

    public String getTwitterId() {
        String[] rankedTwitterIdSources = {getSocialMediaIdFromGoogle("twitter"), proPublicaHouseMember.getTwitterId()};
        return bestAvailableSocialMediaId(rankedTwitterIdSources);
    }


    public String getFacebookId() {
        String[] rankedFacebookIdSources = {getSocialMediaIdFromGoogle("facebook"), proPublicaHouseMember.getFacebookAccount()};
        return bestAvailableSocialMediaId(rankedFacebookIdSources);
    }

    public String getYoutubeId() {
        String[] rankedYoutubeIdSources = {getSocialMediaIdFromGoogle("youtube"), proPublicaHouseMember.getYoutubeId()};
        return bestAvailableSocialMediaId(rankedYoutubeIdSources);
    }

    private String getSocialMediaIdFromGoogle(String socialMediaType) {
        String channelId = "";
        for (Channel channel : googleHouseMember.channels) {
            if(channel.type.equalsIgnoreCase(socialMediaType)) {
                channelId = channel.id;
            }
        }
        return channelId;
    }

    private String bestAvailableSocialMediaId(String[] rankedSocialMediaIdSources) {
        for (String source: rankedSocialMediaIdSources) {
            if(source == null){
                continue;
            }
            if (!source.isEmpty()) {
                return source;
            }
        }
        return "Not Available";
    }

}
