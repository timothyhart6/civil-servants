package com.civilservants.model;

public class District {

    String state;
    String districtCode;

    public District(String state, String districtCode) {
        this.state = state;
        this.districtCode = districtCode;
    }

    public String getState() {
        return state;
    }

    public String getDistrictCode() {
        return districtCode;
    }
}
