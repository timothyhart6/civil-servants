package com.civilservants.controller;

import com.civilservants.model.District;
import com.civilservants.model.User;
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
        User user = new User(streetAddress, zipCode);
        District userDistrict = new District(user.findState(), user.findDistrictCode());
        model.addAttribute("userDistrict", userDistrict);
        return "userDistrict";
    }

}
