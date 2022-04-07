package com.civilservants.model.user;

//import com.civilservants.model.com.civilservants.model.google.NormalizedInput;
//import com.civilservants.model.com.civilservants.model.google.NormalizedInput;
import com.civilservants.model.google.GoogleApiRepresentativesModel;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class GoogleApiCalls {

    public ArrayList<String> FetchAddressAndDistrictInfo(String address, String zipCode){
        //TODO Change addressAndDistrictInfo to map
        ArrayList<String> addressAndDistrictInfo = new ArrayList<>();
        String googleRepresentativesUrl = "https://www.googleapis.com/civicinfo/v2/representatives?key=AIzaSyCZom8UkHqmSzLcAWfnfL41vOfirikaS3w&address=" + address + zipCode;
        RestTemplate restTemplate = new RestTemplate();
        GoogleApiRepresentativesModel googleApiRepresentativesModel = restTemplate.getForObject(googleRepresentativesUrl, GoogleApiRepresentativesModel.class);

        String divisionID = googleApiRepresentativesModel.offices.get(3).divisionId;
        String districtCode = divisionID.substring(divisionID.length() - 2);

        addressAndDistrictInfo.add(googleApiRepresentativesModel.normalizedInput.line1);
        addressAndDistrictInfo.add(googleApiRepresentativesModel.normalizedInput.city);
        addressAndDistrictInfo.add(googleApiRepresentativesModel.normalizedInput.state);
        addressAndDistrictInfo.add(googleApiRepresentativesModel.normalizedInput.zip);
        addressAndDistrictInfo.add(districtCode);

        return addressAndDistrictInfo;
    }
}
