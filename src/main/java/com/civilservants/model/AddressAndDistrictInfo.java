package com.civilservants.model;

public class AddressAndDistrictInfo {

    private String streetAddress;
    private String city;
    private String state;
    private String zipCode;
    private String districtCode;

    public AddressAndDistrictInfo(String streetAddress, String city, String state, String zipCode, String districtCode) {
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.districtCode = districtCode;
    }

    public String getStreetAddress() {
        return streetAddress;
    }
    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getDistrictCode() {
        return districtCode;
    }
}
