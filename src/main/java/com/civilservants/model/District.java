package com.civilservants.model;

import lombok.Getter;

@Getter
public class District {

    private UserAddress userAddress;
    private DistrictCode districtCode;
    private HouseMember houseMember;


    public District(String streetAddress, String zipCode){
        this.userAddress = new UserAddress(streetAddress, zipCode);
        this.districtCode = new DistrictCode(streetAddress, zipCode);
        this.houseMember = new HouseMember(this.userAddress, this.districtCode);
    }
}
