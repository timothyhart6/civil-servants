package com.civilservants.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserDistrictController {

    @GetMapping("/userDistrict")
//    public String displayUserDistrict(@ModelAttribute("user") User user)
    public String displayUserDistrict(@RequestParam String streetAddress, String zipCode, Model model)
    {
        model.addAttribute("streetAddress", streetAddress);
        model.addAttribute("zipCode", zipCode);
        //Maybe this is how to get all the reps. getReps will call all the apis and create all the objects needed. It will return list of reps.
//        model.addAttribute("userReps", UserReps.getReps(address));
        return "userDistrict";
    }

}
