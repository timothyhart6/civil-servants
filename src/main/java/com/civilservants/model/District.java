package com.civilservants.model;

import com.civilservants.service.GoogleApiCalls;

import java.util.ArrayList;

public class District {

    private AddressAndDistrictInfo addressAndDistrictInfo;
    private HouseMember houseMember;

    public District(String streetAddress, String zipCode){
        //TODO should this be in constructor?
        buildDistrict(streetAddress, zipCode);
    }

    public void buildDistrict(String streetAddress, String zipCode){
        GoogleApiCalls googleApiCalls = new GoogleApiCalls();
        ArrayList<String> googleAddressAndDistrictInfo = googleApiCalls.fetchAddressAndDistrictInfo(streetAddress, zipCode);
        this.addressAndDistrictInfo = new AddressAndDistrictInfo(streetAddress, googleAddressAndDistrictInfo.get(1), googleAddressAndDistrictInfo.get(2), zipCode, googleAddressAndDistrictInfo.get(4));
        this.houseMember = googleApiCalls.FetchHouseMember(streetAddress, zipCode);
    }

    public AddressAndDistrictInfo getAddressAndDistrictInfo() {
        return addressAndDistrictInfo;
    }

    public HouseMember getHouseMember() {
        return houseMember;
    }

}
