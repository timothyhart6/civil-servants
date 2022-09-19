package com.civilservants.model;

import com.civilservants.helpers.HouseMemberHelperClass;
import com.civilservants.model.api.google.Address;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class HouseMember {

    private UserAddress userAddress;
    private String districtCode;
    private HouseMemberHelperClass helperClass;
    private String memberId;
    private String firstName;
    private String lastName;
    private String role;
    private String photoUrl;
    private String nextElection;
    private String phoneNumber;
    private Address officeAddress;
    private String twitterId;
    private String facebookId;
    private String youtubeId;

    public HouseMember(UserAddress userAddress, DistrictCode districtCode) {
        this.userAddress = userAddress;
        this.districtCode = districtCode.getCode();
        this.helperClass = new HouseMemberHelperClass(userAddress, districtCode.getCode());

        this.memberId = helperClass.getMemberId();
        this.firstName = helperClass.getFirstName();
        this.lastName = helperClass.getLastName();
        this.photoUrl = helperClass.getPhoto();
        this.phoneNumber = helperClass.getPhoneNumber();
        this.officeAddress = helperClass.getOfficeAddress();

        this.role = helperClass.getRole();
        this.nextElection = helperClass.getNextElection();
        this.twitterId = helperClass.getTwitterId();
        this.facebookId = helperClass.getFacebookId();
        this.youtubeId = helperClass.getYoutubeId();
    }

    public String titleAndFullName(){
        return getRole() + " " + getFirstName() + " " + getLastName();
    }
}
