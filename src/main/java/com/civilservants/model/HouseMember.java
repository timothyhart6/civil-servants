package com.civilservants.model;

import com.civilservants.model.api.google.Address;
import com.civilservants.model.api.google.GoogleApiRepresentativesModel;
import com.civilservants.model.api.google.Official;
import com.civilservants.model.api.proPublica.ProPublicaHouseMember;
import com.civilservants.service.GoogleApiCalls;
import com.civilservants.service.ProPublicaApiCalls;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HouseMember {

    private Official googleHouseMember;
    private ProPublicaHouseMember proPublicaHouseMember;
    private UserAddress userAddress;
    private DistrictCode districtCode;
    private String firstName;
    private String lastName;
    private String role;
    private String photoUrl;
    private String nextElection;
    private String phoneNumber;
    private Address officeAddress;
    private String twitterId;
    private String facebookId;
    private String youtubeId;


    public HouseMember(UserAddress userAddress, DistrictCode districtCode) {
        this.userAddress = userAddress;
        this.districtCode = districtCode;
        this.googleHouseMember = fetchGoogleHouseMember();
        this.proPublicaHouseMember = fetchProPublicaHouseMember();

        this.firstName = googleHouseMember.name.split(" ")[0];
        this.lastName = googleHouseMember.name.split(" ")[1];
        this.photoUrl = googleHouseMember.photoUrl;
        this.phoneNumber = googleHouseMember.phones.get(0);
        this.officeAddress = googleHouseMember.address.get(0);

        this.role = proPublicaHouseMember.getRole();
        this.nextElection = proPublicaHouseMember.getNextElection();
        this.twitterId = proPublicaHouseMember.getTwitterId();
        this.facebookId = proPublicaHouseMember.getFacebookAccount();
        this.youtubeId = proPublicaHouseMember.getYoutubeId();

        fetchProPublicaHouseMember();
    }

    public Official fetchGoogleHouseMember(){
        GoogleApiCalls googleApiCalls = new GoogleApiCalls();
        GoogleApiRepresentativesModel googleApiRepresentativesModel = googleApiCalls.getGoogleApiRepresentativesModel(userAddress.getStreetAddress(), userAddress.getZipCode());
        Official houseMember = googleApiRepresentativesModel.officials.get(4);
        return houseMember;
    }

    public ProPublicaHouseMember fetchProPublicaHouseMember(){
        ProPublicaApiCalls proPublicaApiCalls = new ProPublicaApiCalls();
        ProPublicaHouseMember proPublicaHouseMember = proPublicaApiCalls.getPropublicaApiRepresentativesModel(userAddress.getState(), districtCode.getDistrictCode());
        return proPublicaHouseMember;
    }

    public String titleAndFullName(){
        return getRole() + " " + getFirstName() + " " + getLastName();
    }
}
