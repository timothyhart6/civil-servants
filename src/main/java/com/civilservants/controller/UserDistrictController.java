package com.civilservants.controller;

import com.civilservants.model.District;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserDistrictController {

    @GetMapping("/userDistrict")
    public String displayUserDistrict(@RequestParam String streetAddress, String zipCode, Model model) {
        District district = new District(streetAddress, zipCode);
        model.addAttribute("district", district);
        return "userDistrict";
    }

}
