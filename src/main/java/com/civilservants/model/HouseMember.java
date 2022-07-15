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

    private UserAddress userAddress;
    private DistrictCode districtCode;
    private String firstName;
    private String lastName;
    private String role;
    private String photoUrl;
    private String nextElection;
    private String phoneNumber;
    private Address officeAddress;


    public HouseMember(UserAddress userAddress, DistrictCode districtCode) {
        this.userAddress = userAddress;
        this.districtCode = districtCode;
        fetchGoogleHouseMember();
        fetchProPublicaHouseMember();
    }

    public void fetchGoogleHouseMember(){
        GoogleApiCalls googleApiCalls = new GoogleApiCalls();
        GoogleApiRepresentativesModel googleApiRepresentativesModel = googleApiCalls.getGoogleApiRepresentativesModel(userAddress.getStreetAddress(), userAddress.getZipCode());
        Official houseMember = googleApiRepresentativesModel.officials.get(4);
        String firstName = houseMember.name.split(" ")[0];
        String lastName = houseMember.name.split(" ")[1];
        this.firstName = firstName;
        this.lastName = lastName;
        this.photoUrl = houseMember.photoUrl;
        this.phoneNumber = houseMember.phones.get(0);
        this.officeAddress = houseMember.address.get(0);
    }

    public void fetchProPublicaHouseMember(){
        ProPublicaApiCalls proPublicaApiCalls = new ProPublicaApiCalls();
        ProPublicaHouseMember proPublicaHouseMember = proPublicaApiCalls.getPropublicaApiRepresentativesModel(userAddress.getState(), districtCode.getDistrictCode());
        this.role = proPublicaHouseMember.getRole();
        this.nextElection = proPublicaHouseMember.getNextElection();
    }

    public String titleAndFullName(){
        return getRole() + " " + getFirstName() + " " + getLastName();
    }
}
