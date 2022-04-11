package com.civilservants.service;

//import com.civilservants.model.com.civilservants.model.google.NormalizedInput;
//import com.civilservants.model.com.civilservants.model.google.NormalizedInput;
import com.civilservants.model.HouseMember;
import com.civilservants.model.api.google.GoogleApiRepresentativesModel;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

public class GoogleApiCalls {

    public ArrayList<String> fetchAddressAndDistrictInfo(String address, String zipCode){
        //TODO Change addressAndDistrictInfo to map
        ArrayList<String> addressAndDistrictInfo = new ArrayList<>();
        GoogleApiRepresentativesModel googleApiRepresentativesModel = getGoogleApiRepresentativesModel(address, zipCode);

        String divisionID = googleApiRepresentativesModel.offices.get(3).divisionId;
        String districtCode = divisionID.substring(divisionID.length() - 2);

        addressAndDistrictInfo.add(googleApiRepresentativesModel.normalizedInput.line1);
        addressAndDistrictInfo.add(googleApiRepresentativesModel.normalizedInput.city);
        addressAndDistrictInfo.add(googleApiRepresentativesModel.normalizedInput.state);
        addressAndDistrictInfo.add(googleApiRepresentativesModel.normalizedInput.zip);
        addressAndDistrictInfo.add(districtCode);

        return addressAndDistrictInfo;
    }

    public HouseMember FetchHouseMember(String address, String zipCode){
        GoogleApiRepresentativesModel googleApiRepresentativesModel = getGoogleApiRepresentativesModel(address, zipCode);
        String firstName = googleApiRepresentativesModel.officials.get(4).name.split(" ")[0];
        String lastName = googleApiRepresentativesModel.officials.get(4).name.split(" ")[1];
        return new HouseMember(firstName, lastName);
    }

    private GoogleApiRepresentativesModel getGoogleApiRepresentativesModel(String address, String zipCode) {
        String googleRepresentativesUrl = "https://www.googleapis.com/civicinfo/v2/representatives?key=AIzaSyCZom8UkHqmSzLcAWfnfL41vOfirikaS3w&address=" + address + zipCode;
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(googleRepresentativesUrl, GoogleApiRepresentativesModel.class);
    }
}


