package com.civilservants.model;

public class User {

    private String streetAddress;
    private String zipCode;
    private String districtCode;

    public User(String streetAddress, String zipCode) {
        this.streetAddress = streetAddress;
        this.zipCode = zipCode;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public String findDistrictCode() {
        return "15";
    }

    public String findState() {
        return "OH";
    }
}
