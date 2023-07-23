package com.civilservants.model;

import com.civilservants.service.GoogleApiCalls;
import lombok.Getter;

import java.util.HashMap;

@Getter
public class UserAddress {

    private String streetAddress;
    private String city;
    private String state;
    private String zipCode;

    public UserAddress(String streetAddress, String zipCode) {
        this.streetAddress = streetAddress;
        this.zipCode = zipCode;
        setAddressInfo();
    }

    private void setAddressInfo(){
        //todo make this a bean
        GoogleApiCalls googleApiCalls = new GoogleApiCalls();
        HashMap<String, String> googleAddressAndDistrictInfo = googleApiCalls.fetchAddress(streetAddress, zipCode);
        this.city = googleAddressAndDistrictInfo.get("City");
        this.state = googleAddressAndDistrictInfo.get("State");
    }



}
