package com.civilservants.helpers;

import com.civilservants.model.DistrictCode;
import com.civilservants.model.UserAddress;
import com.civilservants.model.api.google.Address;
import com.civilservants.model.api.google.Channel;
import com.civilservants.model.api.google.GoogleApiRepresentativesModel;
import com.civilservants.model.api.google.Official;
import com.civilservants.model.api.proPublica.ProPublicaHouseMember;
import com.civilservants.service.GoogleApiCalls;
import com.civilservants.service.ProPublicaApiCalls;
import org.apache.catalina.User;

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
        for (Channel channel : googleHouseMember.channels) {
            if(channel.type.equalsIgnoreCase("twitter")) {
                return channel.id;
            }
        }
        return proPublicaHouseMember.getTwitterId();
    }

    public String getFacebookId() {
        for (Channel channel : googleHouseMember.channels) {
            if(channel.type.equalsIgnoreCase("facebook")) {
                return channel.id;
            }
        }
        return proPublicaHouseMember.getFacebookAccount();
    }

    public String getYoutubeId() {
        for (Channel channel : googleHouseMember.channels) {
            if(channel.type.equalsIgnoreCase("youtube")) {
                return channel.id;
            }
        }
        return proPublicaHouseMember.getYoutubeId();
    }
}
