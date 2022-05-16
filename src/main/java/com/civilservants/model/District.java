package com.civilservants.model;

import com.civilservants.model.api.google.GoogleApiRepresentativesModel;
import com.civilservants.model.api.proPublica.ProPublicaHouseMember;
//import com.civilservants.service.ApiCaller;
import com.civilservants.model.api.proPublica.PropublicaHouseMembers;
import com.civilservants.service.GoogleApiCalls;
import com.civilservants.service.ProPublicaApiCalls;

import java.util.ArrayList;

public class District {

    private AddressAndDistrictInfo addressAndDistrictInfo;
    private HouseMember houseMember = new HouseMember();

    public District(String streetAddress, String zipCode){
        //TODO should this be in constructor?
        buildDistrict(streetAddress, zipCode);
    }

    public void buildDistrict(String streetAddress, String zipCode){
//        ArrayList<Object> apiObjects = ApiCaller.apiCallsForDistrict(streetAddress, zipCode);
//        this.houseMember = RepresentativeBuilder.buildHouseMember(apiObjects);
        //TODO consolidate address object like houseMember
        GoogleApiCalls googleApiCalls = new GoogleApiCalls();
        ArrayList<String> googleAddressAndDistrictInfo = googleApiCalls.fetchAddressAndDistrictInfo(streetAddress, zipCode);
        this.addressAndDistrictInfo = new AddressAndDistrictInfo(streetAddress, googleAddressAndDistrictInfo.get(1), googleAddressAndDistrictInfo.get(2), zipCode, googleAddressAndDistrictInfo.get(4));
//        this.houseMember = fetchHouseMember(streetAddress, zipCode);
        fetchGoogleHouseMember(streetAddress, zipCode, googleApiCalls);
        fetchProPublicaHouseMember();
    }

    public void fetchGoogleHouseMember(String address, String zipCode, GoogleApiCalls googleApiCalls){
        GoogleApiRepresentativesModel googleApiRepresentativesModel = googleApiCalls.getGoogleApiRepresentativesModel(address, zipCode);
        String firstName = googleApiRepresentativesModel.officials.get(4).name.split(" ")[0];
        String lastName = googleApiRepresentativesModel.officials.get(4).name.split(" ")[1];
        houseMember.setFirstName(firstName);
        houseMember.setLastName(lastName);
    }

    public void fetchProPublicaHouseMember(){
        ProPublicaApiCalls proPublicaApiCalls = new ProPublicaApiCalls();
        ProPublicaHouseMember proPublicaHouseMember = proPublicaApiCalls.getPropublicaApiRepresentativesModel(addressAndDistrictInfo.getState(), addressAndDistrictInfo.getDistrictCode());
        houseMember.setRole(proPublicaHouseMember.getRole());
        houseMember.setNextElection(proPublicaHouseMember.getNextElection());
        System.out.println(proPublicaHouseMember);
    }

    public AddressAndDistrictInfo getAddressAndDistrictInfo() {
        return addressAndDistrictInfo;
    }

    public HouseMember getHouseMember() {
        return houseMember;
    }

}
