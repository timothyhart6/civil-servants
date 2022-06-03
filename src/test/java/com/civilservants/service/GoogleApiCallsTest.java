package com.civilservants.service;

import com.civilservants.model.api.google.GoogleApiRepresentativesModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class GoogleApiCallsTest {

    GoogleApiCalls googleApiCalls = new GoogleApiCalls();

    @Test
    public void fetchDistrictCodeReturnsACode(){
        String actualCode = googleApiCalls.fetchDistrictCode("59 Spruce St", "43215");
        Assertions.assertEquals("15", actualCode);
    }

    @Test
    public void fetchAddressReturnsCorrectAddressValues(){
        HashMap<String, String> addressHashMap = googleApiCalls.fetchAddress("59 Spruce St", "43215");
        Assertions.assertEquals("59 Spruce Street", addressHashMap.get("StreetAddress"));
        Assertions.assertEquals("Columbus", addressHashMap.get("City"));
        Assertions.assertEquals("OH", addressHashMap.get("State"));
        Assertions.assertEquals("43215", addressHashMap.get("ZipCode"));
    }

    @Test
    public void testGetGoogleApiRepresentativesModelIsNotNull(){
        GoogleApiRepresentativesModel repModel = googleApiCalls.getGoogleApiRepresentativesModel("59 spruce st", "43215");
            Assertions.assertNotNull(repModel);
    }

    @Test
    public void testGetGoogleApiRepresentativesModelHasCorrectAddressInfo(){
        GoogleApiRepresentativesModel repModel = googleApiCalls.getGoogleApiRepresentativesModel("946 Diamond St", "94114");
        Assertions.assertEquals("946 Diamond Street", repModel.normalizedInput.line1);
        Assertions.assertEquals("San Francisco", repModel.normalizedInput.city);
        Assertions.assertEquals("CA", repModel.normalizedInput.state);
        Assertions.assertEquals("94114", repModel.normalizedInput.zip);
    }
}
