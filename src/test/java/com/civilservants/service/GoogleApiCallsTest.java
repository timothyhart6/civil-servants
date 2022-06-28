package com.civilservants.service;

import com.civilservants.model.api.google.GoogleApiRepresentativesModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Objects;

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
    public void testGetGoogleApiRepresentativesModelReturnsReps(){
        GoogleApiRepresentativesModel actual = googleApiCalls.getGoogleApiRepresentativesModel("399851 W 300th Rd", "74022");
        Assertions.assertFalse(actual.officials.isEmpty());
    }

}
