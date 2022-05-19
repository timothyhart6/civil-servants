package com.civilservants.model;

import com.civilservants.service.GoogleApiCalls;
import lombok.Getter;

@Getter
public class DistrictCode {

    private String districtCode;

    public DistrictCode(String streetAddress,  String zipCode) {
        setDistrictCode(streetAddress, zipCode);
    }

    private void setDistrictCode(String streetAddress, String zipCode) {
        GoogleApiCalls googleApiCalls = new GoogleApiCalls();
        this.districtCode = googleApiCalls.fetchDistrictCode(streetAddress, zipCode);
    }
}
