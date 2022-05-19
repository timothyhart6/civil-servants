package com.civilservants.model;

import com.civilservants.model.api.google.GoogleApiRepresentativesModel;
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
    private String nextElection;

    public HouseMember(UserAddress userAddress, DistrictCode districtCode) {
        this.userAddress = userAddress;
        this.districtCode = districtCode;
        fetchGoogleHouseMember();
        fetchProPublicaHouseMember();
    }

    public void fetchGoogleHouseMember(){
        GoogleApiCalls googleApiCalls = new GoogleApiCalls();
        GoogleApiRepresentativesModel googleApiRepresentativesModel = googleApiCalls.getGoogleApiRepresentativesModel(userAddress.getStreetAddress(), userAddress.getZipCode());
        String firstName = googleApiRepresentativesModel.officials.get(4).name.split(" ")[0];
        String lastName = googleApiRepresentativesModel.officials.get(4).name.split(" ")[1];
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void fetchProPublicaHouseMember(){
        ProPublicaApiCalls proPublicaApiCalls = new ProPublicaApiCalls();
        ProPublicaHouseMember proPublicaHouseMember = proPublicaApiCalls.getPropublicaApiRepresentativesModel(userAddress.getState(), districtCode.getDistrictCode());
        this.role = proPublicaHouseMember.getRole();
        this.nextElection = proPublicaHouseMember.getNextElection();
    }
}
