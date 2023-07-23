package com.civilservants.service;

import com.civilservants.model.api.google.GoogleApiRepresentativesModel;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

public class GoogleApiCalls {

    public HashMap<String, String> fetchAddress(String streetAddress, String zipCode){
        HashMap<String, String> address = new HashMap<>();
        GoogleApiRepresentativesModel googleApiRepresentativesModel = getGoogleApiRepresentativesModel(streetAddress, zipCode);

        address.put("StreetAddress", googleApiRepresentativesModel.normalizedInput.line1);
        address.put("City", googleApiRepresentativesModel.normalizedInput.city);
        address.put("State", googleApiRepresentativesModel.normalizedInput.state);
        address.put("ZipCode", googleApiRepresentativesModel.normalizedInput.zip);
        return address;
    }

    public String fetchDistrictCode(String streetAddress, String zipCode) {
        GoogleApiRepresentativesModel googleApiRepresentativesModel = getGoogleApiRepresentativesModel(streetAddress, zipCode);
        String divisionID = googleApiRepresentativesModel.offices.get(3).divisionId;
        String districtCode = divisionID.substring(divisionID.length() - 2);
        return districtCode;
    }

    public GoogleApiRepresentativesModel getGoogleApiRepresentativesModel(String address, String zipCode) {
        String googleRepresentativesUrl = "https://www.googleapis.com/civicinfo/v2/representatives?key=AIzaSyCZom8UkHqmSzLcAWfnfL41vOfirikaS3w&address=" + address + zipCode;
        RestTemplate restTemplate = new RestTemplate();
        GoogleApiRepresentativesModel googleRep = null;
        try {
             googleRep = restTemplate.getForObject(googleRepresentativesUrl, GoogleApiRepresentativesModel.class);
        } catch (Exception e) {
            System.out.println("Google Representaives call failed with message: " + e.getMessage());
        }
        return googleRep;
    }
}


