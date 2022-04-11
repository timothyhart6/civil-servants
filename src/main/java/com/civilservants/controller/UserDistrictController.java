package com.civilservants.controller;

import com.civilservants.model.AddressAndDistrictInfo;
import com.civilservants.model.HouseMember;
import com.civilservants.service.GoogleApiCalls;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class UserDistrictController {

    @GetMapping("/userDistrict")
    public String displayUserDistrict(@RequestParam String streetAddress, String zipCode, Model model) {
        GoogleApiCalls googleApiCalls = new GoogleApiCalls();
        ArrayList<String> googleAddressAndDistrictInfo = googleApiCalls.fetchAddressAndDistrictInfo(streetAddress, zipCode);

        AddressAndDistrictInfo addressAndDistrictInfo = new AddressAndDistrictInfo(streetAddress, googleAddressAndDistrictInfo.get(1), googleAddressAndDistrictInfo.get(2), zipCode, googleAddressAndDistrictInfo.get(4));
        model.addAttribute("district", addressAndDistrictInfo);

        HouseMember houseMember = googleApiCalls.FetchHouseMember(streetAddress, zipCode);
        model.addAttribute("houseMember", houseMember);
        return "userDistrict";
    }

}
