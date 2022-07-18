package com.civilservants.model;

import com.civilservants.service.GoogleApiCalls;
import lombok.Getter;

@Getter
public class DistrictCode {

    private String code;

    public DistrictCode(String streetAddress,  String zipCode) {
        setCode(streetAddress, zipCode);
    }

    private void setCode(String streetAddress, String zipCode) {
        GoogleApiCalls googleApiCalls = new GoogleApiCalls();
        this.code = googleApiCalls.fetchDistrictCode(streetAddress, zipCode);
    }
}
